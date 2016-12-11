package servlets;

import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.*;
import sessionscope.SessionScopeComponent;
import tables.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Controller class contains admin controllers, admin's request mapping
 * Created by pavelpetrov on 12.11.16.
 */
@Controller
@Secured(value = "ROLE_ADMIN")
@RequestMapping(value = "/admin")
public class AdminController {

    /**
     * class Logger
     */
    private static Logger logger = Logger.getLogger(AdminController.class);

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;

    /**
     * inject ProductListServiceSpring spring bean
     */
    @Autowired
    private ProductListServiceSpring productListService;

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult resultHttp;

    /**
     * inject GetProfitForDateSpring spring bean
     */
    @Autowired
    private GetProfitForDateSpring getProfitForDateSpring;

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult result;

    /**
     * inject CategoryServiceSpring spring bean
     */
    @Autowired
    private CategoryServiceSpring categoryService;

    /**
     * inject OrderServiceSpring spring bean
     */
    @Autowired
    private OrderServiceSpring ordeService;

    /**
     * inject OrderChangeServiceSpring spring bean
     */
    @Autowired
    private OrderChangeServiseString orderChangeService;

    /**
     * inject OrderSelectServiceSpring spring bean
     */
    @Autowired
    private OrderSelectServiceSpring selectService;


    /**
     * inject ProductRegistrationServiceSpring spring bean
     */
    @Autowired
    private ProductRegistrationServisSpring service;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;



    /**
     * method  Provides a consistent style between Servlet and Portlet
     * environments. Prepare information for Static Admin Page
     *
     * @param model model
     * @return Static admin Page
     */
    @RequestMapping(value = "/StatisticAdmin", method = RequestMethod.GET)
    public String getStatistis(Model model) {
        List<Client> clients = clientServiceSpring.getClientTopList();
        List<Long> longList = clientServiceSpring.getCount();
        List<Product> products = productListService.getTopProducts();
        List productLongList = productListService.getCountOfUniqueProductsInOrderTable();
        model.addAttribute("LongList", longList);
        model.addAttribute("ProductTopList", products);
        model.addAttribute("ProductCountList", productLongList);
        model.addAttribute("StatisticClient", clients);
        return "StatisticAdmin";
    }

    /**
     * Provides a consistent style between Servlet and Portlet. Change order information and return result to ajax
     * environments
     *
     * @param orderNumber order id
     * @param session     httpSession
     * @return result t ajax
     */
    @RequestMapping(value = "/ChangeOrderInformationServletAdmin", method = RequestMethod.POST)
    @ResponseBody
    public String changeOrderInformation(
            @RequestParam(value = "orderId") String orderNumber,
            HttpSession session
    ) {
        int orderNumberInt = Integer.parseInt(orderNumber);
        List<Orders> ordersList = sessionScopeComponent.getOrderListAdmin();
        Orders orderToChange = ordersList.get(orderNumberInt);
        session.setAttribute("orderToChange", orderToChange);
        sessionScopeComponent.setOrderToChange(orderToChange);
        return "result";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Get profit, and return it to the page
     *
     * @param firstDate first date
     * @param lastDate  second date
     * @param request   HttpSession
     * @return HHtpResult
     */
    @RequestMapping(value = "/GetProfit", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult getProfit(
            @RequestParam(value = "firstDate") String firstDate,
            @RequestParam(value = "lastDate") String lastDate,
            HttpSession request
    ) {
        resultHttp.setMessage("");
        List<Long> longList = getProfitForDateSpring.getPrice(firstDate, lastDate);
        if (longList == null) {
            resultHttp.setMessage("There are no orders on this dates");
            logger.info("There are no orders on this dates");
        } else {
            Long profit = longList.get(0);
            if (profit == null) {
                resultHttp.setMessage("There are no orders on this dates");
            } else {
                request.setAttribute("prifitForData", profit);
                sessionScopeComponent.setPrifitForData(profit);
                resultHttp.setData("Profit");
                logger.info("Get profi for dates");
            }
        }
        return resultHttp;
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. create new category
     *
     * @param categoryParam category s
     * @return result to page
     */
    @RequestMapping(value = "/CreateNewCategoryServlet", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult createNewCategoryServlet(
            @RequestParam(value = "category") String categoryParam
    ) {
        Category category = new Category();
        result = categoryService.createNewCategoryCheckParam(category, categoryParam);
        logger.info("created new category");
        return result;
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method Create category list and returns to the page
     *
     * @param modelAndView
     * @return modelAndView
     */
    @RequestMapping(value = "/CreateCategoryList", method = RequestMethod.GET)
    public ModelAndView createCategoryList(ModelAndView modelAndView) {
        List<Category> categories = categoryService.getAllCategories();
        modelAndView.setViewName("ProductRegitrationAdmin");
//        modelAndView = new ModelAndView("ProductRegitrationAdmin");
        modelAndView.addObject("CategoryList", categories);
        logger.info("created new category list");
        return modelAndView;
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method create OrderList and return to OrderListAdmin page
     *
     * @param model modelAndView
     * @return modelAdnView
     */
    @RequestMapping(value = "/OrderCreatorListAdmin", method = RequestMethod.GET)
    public ModelAndView createListAdmin(ModelAndView model) {
        List<Orders> ordersList = ordeService.getAllOrders();
        model.setViewName("OrderListAdmin");
//        model = new ModelAndView("OrderListAdmin");
        sessionScopeComponent.setOrderListAdmin(ordersList);
        model.addObject("OrderListAdmin", ordersList);
        return model;
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method change payment state and redirect to OterChangeinformationAdminPage
     *
     * @param newPaymentStateOfOrder new payment state status
     * @return redirect:/OrderChangeInfromationAdminPage
     */
    @RequestMapping(value = "/OrderPaymentStateChangerServlet", method = RequestMethod.POST)
    public String orderChangeService(
            @RequestParam(value = "cahngePaymentState") String newPaymentStateOfOrder) {
        Orders order = sessionScopeComponent.getOrderToChange();
        orderChangeService.updateOrderPaymentState(order, newPaymentStateOfOrder);
        logger.info("order List have been updated");
        return "redirect:/OrderChangeInfromationAdminPage";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method create new Orders list by selected param
     *
     * @param session HttpSession
     * @param select  order sort
     * @return result to ajax
     */
    @RequestMapping(value = "/OrderSelectServlet", method = RequestMethod.POST)
    @ResponseBody
    public String orderSelectAdmin(HttpSession session,
                                   @RequestParam(value = "orderSort") String select) {
        List<Orders> ordersList = selectService.getSortedOrdersList(select);
        sessionScopeComponent.setOrderListAdmin(ordersList);
        session.setAttribute("OrderListAdmin", ordersList);
        return "result";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method chage order status and redirect to another controller
     *
     * @param newOrderStatus new order status
     * @return redirect to OrderChangeInformationAdminPage
     */
    @RequestMapping(value = "/OrderStatusChangerServlet", method = RequestMethod.POST)
    public String orderChangeStatus(
            @RequestParam(value = "changeOrder") String newOrderStatus) {
        Orders order = sessionScopeComponent.getOrderToChange();
        orderChangeService.updateOrderState(order, newOrderStatus);
        return "redirect:/OrderChangeInfromationAdminPage";
    }

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. Method prepare and add new product
     *
     * @param name        product name
     * @param category    product category
     * @param quantity    quantity of product
     * @param price       price of prodcut
     * @param brand       brand of product
     * @param power       prower of product
     * @param color       color of product
     * @param weight      weight of prodcut
     * @param description discriprion of product
     * @return Httpresult object
     */
    @RequestMapping(value = "/ProductRegistrationAdmin", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult login(
            @RequestParam(value = "productName") String name,
            @RequestParam(value = "productCategory") String category,
            @RequestParam(value = "quantity") String quantity,
            @RequestParam(value = "price") String price,
            @RequestParam(value = "brand") String brand,
            @RequestParam(value = "power") String power,
            @RequestParam(value = "color") String color,
            @RequestParam(value = "weight") String weight,
            @RequestParam(value = "description") String description) {

       return service.getRegistrationHttpResult(brand, power, color, weight, name, quantity, price, description, category);
    }

}

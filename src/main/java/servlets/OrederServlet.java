package servlets;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AddProductsToCardSeviceSpring;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * create OrderList, witch is ready to buy
 * Created by pavelpetrov on 10.10.16.
 */
@Controller
public class OrederServlet extends HttpServlet {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrederServlet.class);

    /**
     * inject AddProductsToCardServiceSpring spring bean
     */
    @Autowired
    private AddProductsToCardSeviceSpring cartService;

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. create order list and productlist
     *
     * @param httpRequest HttpServletRequest
     * @param model       ModelAndView
     * @return ModelAdnView
     */
    @RequestMapping(value = "/OrderServlet", method = RequestMethod.POST)
    public ModelAndView getOrderList(
            HttpServletRequest httpRequest,
            ModelAndView model
    ) {
        String[] orderArray = httpRequest.getParameterValues("OrederCheckBox");
        return cartService.getProductsForOrderPage(model, orderArray);
    }

}

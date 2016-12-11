package servlets;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.SelectServiceSpring;
import sessionscope.SessionScopeComponent;
import tables.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * make selection in OrderList
 * Created by pavelpetrov on 13.10.16.
 */
@Controller
public class SelectServlet extends HttpServlet {

    /**
     * class servlet
     */
    private static Logger logger = Logger.getLogger(SelectServlet.class);

    /**
     * inject SelectServiceSpring spring bean
     */
    @Autowired
    private SelectServiceSpring selectService;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method sort ProductList
     *
     * @param select  param for selection
     * @param session httpSession
     * @return result to page
     */
    @RequestMapping(value = "/SelectServlet", method = RequestMethod.POST)
    @ResponseBody
    public String getProductSelect(
            @RequestParam(value = "sort") String select,
            HttpSession session) {
        List<Product> productLists = selectService.getOrderedByProductByParam(select);
        sessionScopeComponent.setProductList(productLists);
        session.setAttribute("ProductList", productLists);
        logger.info("product list selected");
        return "result";
    }
}

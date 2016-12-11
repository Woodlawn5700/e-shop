package servlets;

import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.OrderServiceSpring;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;

/**
 * controller regulate buying of products
 * Created by pavelpetrov on 11.10.16.
 */
@Controller
public class BuyProducts extends HttpServlet {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(BuyProducts.class);

    @Autowired
    private OrderServiceSpring orderServiceSpring;


    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. method buy logic of buying products
     *
     * @param delivery delivery method
     * @param payment  payment method
     * @param comments client's comments for order
     * @param request  HttpSession
     * @return HttpResult
     */
    @RequestMapping(value = "/BuyProducts", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult login(
            @RequestParam(value = "delivery") String delivery,
            @RequestParam(value = "payment") String payment,
            @RequestParam(value = "description") String comments,
            HttpSession request) {
        return orderServiceSpring.byProductsByClient(request, delivery, payment, comments);
    }
}

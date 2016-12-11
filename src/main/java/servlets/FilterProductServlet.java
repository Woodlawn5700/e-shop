package servlets;

import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.FilterProductServiceSpring;
import sessionscope.SessionScopeComponent;
import tables.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * servlet helps in product filtering
 * Created by pavelpetrov on 20.10.16.
 */
@Controller
public class FilterProductServlet extends HttpServlet {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(FilterProductServlet.class);

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult resultHttp;

    /**
     * inject FilterProductServiceSpring spring bean
     */
    @Autowired
    private FilterProductServiceSpring filterProductService;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;


    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. filter product by pararms
     *
     * @param category category of product
     * @param color    color of product
     * @param brand    brand of product
     * @param power    power of product
     * @param weight   weight of product
     * @param minPrice minPrice of product
     * @param maxPrice maxPrice if product
     * @param session  HttpSession
     * @return httpResult
     */
    @RequestMapping(value = "/FilterProductServlet", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult getFilterProduct(
            @RequestParam("categoryFilter") String category,
            @RequestParam("colorFilter") String color,
            @RequestParam("brandFilter") String brand,
            @RequestParam("powerFilter") String power,
            @RequestParam("weightFilter") String weight,
            @RequestParam("priceMinFilter") String minPrice,
            @RequestParam("priceMaxFilter") String maxPrice,
            HttpSession session) {
        List<Product> productList = filterProductService.
                productList(category, color, power, weight, minPrice, maxPrice, brand);
        sessionScopeComponent.setProductList(productList);
        session.setAttribute("ProductList", productList);
        resultHttp.setData("Filtered ProductList have been reload ");
        logger.info("Filtered ProductList have been reload");
        return resultHttp;
    }
}

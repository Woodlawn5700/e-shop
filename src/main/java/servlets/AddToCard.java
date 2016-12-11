package servlets;

import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AddProductsToCardSeviceSpring;
import sessionscope.SessionScopeComponent;
import tables.Product;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller checks what exactly product added to card
 * Created by pavelpetrov on 08.10.16.
 */
@Controller
public class AddToCard extends HttpServlet {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(AddToCard.class);

    /**
     * inject AddProductsToCardServiceSpring spring bean
     */
    @Autowired
    private AddProductsToCardSeviceSpring addProductsToCardSeviceSpring;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * inject HttpResult bean
     */
    @Autowired
    private HttpResult resultHttp;

    @RequestMapping(value = "/AddTOCard", method = RequestMethod.POST)
    @ResponseBody
    public HttpResult getOrderList(
            @RequestParam(value = "productIndex") String button,
            Model model, HttpSession session) {
        List<Product> productListOnMyCard = null;
        int numberOfButton = Integer.parseInt(button);
        List<Product> productList = sessionScopeComponent.getProductList();
        Product product = productList.get(numberOfButton);
        if (sessionScopeComponent.getProductListOnMyCard() == null) {
            productListOnMyCard = new ArrayList<Product>();
            productListOnMyCard = addProductsToCardSeviceSpring.getListOgProductsOnCart(productListOnMyCard, product);
        } else {
            productListOnMyCard = sessionScopeComponent.getProductListOnMyCard();
            productListOnMyCard = addProductsToCardSeviceSpring.getListOgProductsOnCart(productListOnMyCard, product);
        }
        sessionScopeComponent.setProductListOnMyCard(productListOnMyCard);
        session.setAttribute("ListOfProductOnCard", productListOnMyCard);
        int quantityProductsOnMyCard = addProductsToCardSeviceSpring.getQuantityOfProducOnCard(productListOnMyCard);
        String price = addProductsToCardSeviceSpring.getTotalPriceOfProductsOnCart(productListOnMyCard);
        sessionScopeComponent.setTotaPrice(price);
        session.setAttribute("TotalPrice", price);
        sessionScopeComponent.setQuantityProductsOnMyCard(quantityProductsOnMyCard);
        session.setAttribute("ProductsOnCardQuantity", quantityProductsOnMyCard);
        resultHttp.setData("Added to cart!");
        logger.info("Added to cart");
        return resultHttp;
    }
}

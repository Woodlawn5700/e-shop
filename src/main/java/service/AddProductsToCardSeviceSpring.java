package service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import sessionscope.SessionScopeComponent;
import tables.Product;

import java.util.ArrayList;
import java.util.List;


/**
 * Service class realize bossiness logic of adding products to cart
 * Created by pavelpetrov on 18.10.16.
 */
@Service
public class AddProductsToCardSeviceSpring {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(AddProductsToCardSeviceSpring.class);

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * serach product in the List, if find it we plus counter else we add to List new product with count ==1
     *
     * @param productList product list
     * @param product     picked product
     * @return Product List
     */
    public List<Product> getListOgProductsOnCart(List<Product> productList, Product product) {
        int count = 0;
        for (Product pr : productList) {
            if (pr.equals(product)) {
                int quantity = pr.getQuantityOfProductsOnCart();
                Product product2 = pr;
                product2.setQuantityOfProductsOnCart(++quantity);
                productList.remove(pr);
                productList.add(product2);
                logger.info("add new prduct to Cart");
                break;
            }
            count++;
        }
        if (count == productList.size()) {
            product.setQuantityOfProductsOnCart(1);
            productList.add(product);
        }
        logger.info("Return new List of product in Cart");
        return productList;
    }

    /**
     * method returns quantity of products on Cart
     *
     * @param products productList
     * @return quantity of products
     */
    public int getQuantityOfProducOnCard(List<Product> products) {
        int result = 0;
        for (Product p : products) {
            result += p.getQuantityOfProductsOnCart();
        }
        logger.info("Quantity of products on cart have been changed");
        return result;
    }

    /**
     * get total Price of all products on client's cart
     *
     * @param products Product List
     * @return String total price
     */
    public String getTotalPriceOfProductsOnCart(List<Product> products) {
        int price = 0;
        for (Product p : products) {
            price += p.getPrice() * p.getQuantityOfProductsOnCart();
        }
        String totalPrice = price + " $";
        logger.info("Total price of product on cart have been changed");
        return totalPrice;
    }

    /**
     * method prepare infromation for Order page
     *
     * @param model      ModelAndVie object
     * @param orderArray String[] orderArray
     * @return ModelAndView object
     */
    public ModelAndView getProductsForOrderPage(ModelAndView model, String[] orderArray) {
        List<Product> orderList = sessionScopeComponent.getProductListOnMyCard();
        List<Product> poductsAreReadyToBuy = new ArrayList<Product>();
        String client = sessionScopeComponent.getUsername();
        if (orderList == null || orderArray == null || client == null) {
            model.setViewName("redirect:/ProductListServlet");
            return model;
        } else {
            for (int i = 0; i < orderArray.length; i++) {
                int numberOfProduct = Integer.parseInt(orderArray[i]);
                if (numberOfProduct > 0) {
                    orderList.get(i).setQuantityOfProductsOnCart(numberOfProduct);
                    poductsAreReadyToBuy.add(orderList.get(i));
                }
            }
            model.setViewName("Orders");
//            model = new ModelAndView("Orders");
            sessionScopeComponent.setPoductsAreReadyToBuy(poductsAreReadyToBuy);
            model.addObject("poductsAreReadyToBuy", poductsAreReadyToBuy);
            int quantityProductsOnMyCard = getQuantityOfProducOnCard(poductsAreReadyToBuy);
            String price = getTotalPriceOfProductsOnCart(poductsAreReadyToBuy);
            sessionScopeComponent.setTotaPrice(price);
            sessionScopeComponent.setQuantityProductsOnMyCard(quantityProductsOnMyCard);
            model.addObject("TotalPrice", price);
            model.addObject("ProductsOnCardQuantity", quantityProductsOnMyCard);
            logger.info("creat total price, product on cart, product are ready to buy");
            return model;
        }
    }

}

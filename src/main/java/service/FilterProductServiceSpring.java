package service;

import DAO.implementation.ProductDaoImplSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.Product;

import java.util.List;

/**
 * Service class get params and make filter of products
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class FilterProductServiceSpring {

    /**
     * inject ProductDaoImplSpring spring bean
     */
    @Autowired
    ProductDaoImplSpring productDao;

    /**
     * String min price of product filter
     */
    private String minPrice;

    /**
     * max price of product filter
     */
    private String maxPrice;

    /**
     * method sort price by value
     *
     * @param firstPrice  income param of price
     * @param secondPrice income param of price
     */
    private void getMinPrice(String firstPrice, String secondPrice) {
        int price1 = Integer.parseInt(firstPrice);
        int price2 = Integer.parseInt(secondPrice);
        if (price1 < price2) {
            minPrice = firstPrice;
            maxPrice = secondPrice;
        } else {
            minPrice = secondPrice;
            maxPrice = firstPrice;
        }
    }

    /**
     * method returns filtred List of products
     *
     * @param category     category
     * @param color        color
     * @param power        power
     * @param weight       weight
     * @param minimumPrice minimumPrice
     * @param maximumPrice maximumPrice
     * @param brand        brand
     * @return list of products
     */
    @Transactional
    public List<Product> productList(String category, String color, String power,
                                     String weight, String minimumPrice, String maximumPrice, String brand) {
        getMinPrice(minimumPrice, maximumPrice);
        return productDao.getFiltredProductList(category, power, minPrice, maxPrice, brand, color, weight);
    }
}

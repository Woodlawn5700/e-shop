package service;

import DAO.implementation.ProductDaoImplSpring;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tables.Product;
import tables.TablesNames;

import java.util.List;

/**
 * Select service for Select servlet
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class SelectServiceSpring {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(SelectServiceSpring.class);

    /**
     * inject ProdcutDaoImplSpring spring bean
     */
    @Autowired
    ProductDaoImplSpring productDao;

    /**
     * Method retutns Product List ordered by param
     *
     * @param param ordered param
     * @return product list
     */
    public List<Product> getOrderedByProductByParam(String param) {
        List<Product> productList = null;
        if (param.equals("brand")) {
            productList = productDao.getAllObgectsFromTableByOrderParams(TablesNames.PRODUCT, param, "parametr");
        } else {
            productList = productDao.getAllObgectsFromTableByOrder("Product", param);
        }
        logger.info("poduct have been sorted by param");
        return productList;
    }
}

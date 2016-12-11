package service;

import DAO.implementation.ProductDaoImplSpring;
import DTO.ProductDTO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sessionscope.SessionScopeComponent;
import tables.Category;
import tables.Product;
import tables.TablesNames;

import java.util.ArrayList;
import java.util.List;

/**
 * Class working with ProductList Page information for sort and filter Product List
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class ProductListServiceSpring {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ProductListServiceSpring.class);

    /**
     * inject ProductDaoImplSpring spring bean
     */
    @Autowired
    ProductDaoImplSpring productDao;

    /**
     * inject CategoryServiceSpring spring bean
     */

    @Autowired
    private CategoryServiceSpring categoryService;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * default constructor
     */
    public ProductListServiceSpring() {
    }

    public ProductListServiceSpring(ProductDaoImplSpring productDao) {
        this.productDao = productDao;
    }

    /**
     * method returns product List
     *
     * @return product list
     */
    @Transactional
    public List<Product> getAllProducts() {
        return productDao.getAllObjectsFromTable(TablesNames.PRODUCT);
    }

    /**
     * method returns unique brand List
     *
     * @return brand List
     */
    @Transactional
    public List<String> getUniqueBrandList() {
        return productDao.getUniqueListObjectFromJoinAnotherTable(TablesNames.PRODUCT, "parametr", "brand");
    }

    /**
     * method returns unique color List
     *
     * @return color List
     */
    @Transactional
    public List<String> getUniqueColorList() {
        return productDao.getUniqueListObjectFromJoinAnotherTable(TablesNames.PRODUCT, "parametr", "color");
    }

    /**
     * method returns unique power List
     *
     * @return power List
     */
    @Transactional
    public List<Integer> getUniquePowerList() {
        return productDao.getUniqueListObjectFromJoinAnotherTableForInteger(TablesNames.PRODUCT, "parametr", "power");
    }

    /**
     * method returns unique weight List
     *
     * @return weight List
     */
    @Transactional
    public List<Integer> getUniqueWeightList() {
        return productDao.getUniqueListObjectFromJoinAnotherTableForInteger(TablesNames.PRODUCT, "parametr", "weigth");
    }

    /**
     * count products in Order table
     *
     * @return long list of products
     */
    @Transactional
    public List<Long> getCountOfUniqueProductsInOrderTable() {
        return productDao.getTopProductsCount(TablesNames.ORDER, "products");
    }

    /**
     * method checks ability to buy products by quantity
     *
     * @param products product list
     * @return true if able to buy this product
     */
    public boolean getAbleToBuyProdcut(List<Product> products) {
        boolean result = true;
        for (Product p : products) {
            if ((p.getQuantity() - p.getQuantityOfProductsOnCart()) < 0) {
                result = false;
                break;
            }
        }
        logger.info("created top 10 products");
        return result;
    }

    /**
     * update quantity of products after client bought'em
     *
     * @param products list of products witch are redy to buy
     */
    @Transactional
    public void updateProducts(List<Product> products) {
        for (Product p : products) {
            p.setQuantity(p.getQuantity() - p.getQuantityOfProductsOnCart());
            p.setQuantityOfProductsOnCart(0);
            productDao.updateTable(p);
            logger.info("Products have been updated");
        }
    }

    /**
     * get top list of products
     *
     * @return top product list
     */
    @Transactional
    public List<Product> getTopProducts() {
        return productDao.getTopProducts();
    }


    /**
     * get list ProductDTO for webService
     *
     * @return ProductDTO list
     */
    @Transactional
    public List<ProductDTO> getTopProductsWebServiceApp() {
        List<Product> products = productDao.getTopProducts();
        List<ProductDTO> productDTOs = new ArrayList<>();
        int maxProduct = 0;
        for (Product product : products) {
            if (maxProduct == 10) {
                break;
            }
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductBrand(product.getParametr().getBrand());
            productDTO.setProductName(product.getProductName());
            productDTO.setProductPrice(String.valueOf(product.getPrice()));
            productDTOs.add(productDTO);
            maxProduct++;
        }
        logger.info("get top products for webService");
        return productDTOs;
    }

    @Transactional
    public void prepareSessionScopeForProdcutList() {
        List<Product> productList = getAllProducts();
        sessionScopeComponent.setProductList(productList);
        List<String> brandList = getUniqueBrandList();
        sessionScopeComponent.setBrandList(brandList);
        List<Category> categoryList = categoryService.getAllCategories();
        sessionScopeComponent.setCategoryList(categoryList);
        List<String> colorList = getUniqueColorList();
        sessionScopeComponent.setColorList(colorList);
        List<Integer> powerList = getUniquePowerList();
        sessionScopeComponent.setPowerList(powerList);
        List<Integer> weightList = getUniqueWeightList();
        sessionScopeComponent.setWeightList(weightList);
    }

}

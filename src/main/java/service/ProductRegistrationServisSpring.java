package service;

import DAO.implementation.ParamsDaoSpring;
import DAO.implementation.ProductDaoImplSpring;
import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.Category;
import tables.Params;
import tables.Product;

/**
 * Product registration Service
 * class checks income parameters and write objects down to tables
 * Created by pavelpetrov on 03.11.16.
 */
@Service
public class ProductRegistrationServisSpring {
    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult resultHttpRegis;

    /**
     * inject CategoryServiceSpring spring bean
     */
    @Autowired
    private CategoryServiceSpring categoryService;

    /**
     * inject Httpresult spring bean
     */
    @Autowired
    HttpResult httpResultcreateProduct;

    /**
     * inject ProductDaoImplSpring spring bean
     */
    @Autowired
    ProductDaoImplSpring productDaoImpl;

    /**
     * inject ParamDaoSpring spring bean
     */
    @Autowired
    ParamsDaoSpring paramsDaoSpring;

    /**
     * inject Httpresult spring bean
     */
    @Autowired
    HttpResult httpResultCreatParam;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ProductRegistrationServisSpring.class);

    /**
     * private product
     */
    private Product product;

    /**
     * pricate params
     */
    private Params params;

    /**
     * default constructor
     */
    public ProductRegistrationServisSpring() {
    }

    public ProductRegistrationServisSpring(HttpResult httpResultcreateProduct, HttpResult httpResultCreatParam,
                                           ProductDaoImplSpring productDaoImpl, ParamsDaoSpring paramsDaoSpring ) {
        this.httpResultcreateProduct = httpResultcreateProduct;
        this.httpResultCreatParam = httpResultCreatParam;
        this.productDaoImpl = productDaoImpl;
        this.paramsDaoSpring = paramsDaoSpring;

    }

    /**
     * method check income param and create new Product.
     *
     * @param name        name of product
     * @param quantity    quantity of product in stock
     * @param price       price pf product
     * @param description discription of product
     * @return Product object
     */
    @Transactional
    public HttpResult createProduct(String name, String quantity, String price, String description) {
        httpResultcreateProduct.setMessage("");
        if (!name.isEmpty() || !quantity.isEmpty() || !price.isEmpty() || !description.isEmpty()) {
            if (!checkDigids(quantity) || !checkDigids(price)) {
                if (!checkDigids(quantity)) {
                    httpResultcreateProduct.setMessage("Quantity may be only numbers");
                    logger.info("Quantity may be only numbers");
                    if (logger.isDebugEnabled()) {
                        logger.debug("Quantity may be only numbers");
                    }
                }
                if (!checkDigids(price)) {
                    if (httpResultcreateProduct.getMessage().length() > 1) {
                        httpResultcreateProduct.setMessage(httpResultcreateProduct.getMessage() + "\n" + "Price may be only numbers");
                        logger.info("Price may be only numbers");
                        if (logger.isDebugEnabled()) {
                            logger.debug("Price may be only numbers");
                        }
                    } else {
                        httpResultcreateProduct.setMessage("Price may be only numbers");
                        logger.info("Price may be only numbers");
                        if (logger.isDebugEnabled()) {
                            logger.debug("Price may be only numbers");
                        }
                    }
                }
            } else {
                int pructPrice = Integer.parseInt(price);
                int productQuantity = Integer.parseInt(quantity);
                product = new Product(description, pructPrice, name, productQuantity);
                httpResultcreateProduct.setData(product);
            }
        } else {
            httpResultcreateProduct.setMessage("Please don't leave empty fields");
            logger.info("Please don't leave empty fields");
            if (logger.isDebugEnabled()) {
                logger.debug("Please don't leave empty fields");
            }
        }
        return httpResultcreateProduct;
    }

    /**
     * method check income params and create new Params and Http hold new Param ore error message
     *
     * @param brand  brand
     * @param power  power
     * @param color  color
     * @param weight weight
     * @return HttpResult
     */
    @Transactional
    public HttpResult createParams(String brand, String power, String color, String weight) {
        httpResultCreatParam.setMessage("");
        if (!brand.isEmpty() || !power.isEmpty() || !color.isEmpty() || !weight.isEmpty()) {
            if (!checkDigids(power) || !checkDigids(weight)) {
                if (!checkDigids(power)) {
                    httpResultCreatParam.setMessage("Power may be only numbers");
                    logger.info("Power may be only numbers");
                    if (logger.isDebugEnabled()) {
                        logger.debug("Power may be only numbers");
                    }
                }
                if (!checkDigids(weight)) {
                    if (httpResultCreatParam.getMessage().length() > 1) {
                        httpResultCreatParam.setMessage(httpResultCreatParam.getMessage() + "\n" + "Weight may be only numbers");
                        logger.info("Weight may be only numbers");
                        if (logger.isDebugEnabled()) {
                            logger.debug("Weight may be only numbers");
                        }
                    } else {
                        httpResultCreatParam.setMessage("Weight may be only numbers");
                        logger.info("Weight may be only numbers");
                        if (logger.isDebugEnabled()) {
                            logger.debug("Weight may be only numbers");
                        }
                    }
                }
            } else {
                int paramWeight = Integer.parseInt(weight);
                int paramPower = Integer.parseInt(power);
                params = new Params(brand, color, paramPower, paramWeight);
                httpResultCreatParam.setData(params);
            }
        } else {
            httpResultCreatParam.setMessage("Please don't leave empty fields");
            logger.info("Please don't leave empty fields");
            if (logger.isDebugEnabled()) {
                logger.debug("Please don't leave empty fields");
            }
        }
        return httpResultCreatParam;
    }

    /**
     * insert Product and his params to DB
     *
     * @param product  Product that we want to add to DB
     * @param params   Param table
     * @param category CAtegory
     */
    @Transactional
    public void addProductandParamsToDB(Product product, Params params, Category category) {
        product.setCategory(category);
        product.setParametr(params);
        paramsDaoSpring.insertToTable(params);
        productDaoImpl.insertToTable(product);
        logger.info("pramas, category and products have been inserted to DB");
    }

    /**
     * check text on digids
     *
     * @param text text for checking
     * @return boolean true if text contains only numbers
     */
    public Boolean checkDigids(String text) {
        String regex = "^(\\d+)$";
        return text.matches(regex);
    }

    @Transactional
    public HttpResult getRegistrationHttpResult(String brand, String power, String color, String weight,String name,
                                                String quantity, String price, String description, String category ) {
        Category category1 = categoryService.getCategoryByName(category);
        httpResultcreateProduct = createProduct(name, quantity, price, description);
        httpResultCreatParam = createParams(brand, power, color, weight);
        if (httpResultcreateProduct.getMessage().length() > 1 || httpResultCreatParam.getMessage().length() > 1) {
            if (httpResultcreateProduct.getMessage().equals(httpResultCreatParam.getMessage())) {
                resultHttpRegis.setMessage(httpResultcreateProduct.getMessage());
            } else {
                resultHttpRegis.setMessage(httpResultcreateProduct.getMessage() + "\n" + httpResultCreatParam.getMessage());
            }
        } else {
            addProductandParamsToDB((Product) httpResultcreateProduct.getData(), (Params) httpResultCreatParam.getData(), category1);
            logger.info("Product have been inserted to DB");
            resultHttpRegis.setData("Product have been inserted to DB");
        }
        return resultHttpRegis;

    }



}

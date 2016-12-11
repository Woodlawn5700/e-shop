package servlets;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.ProductListServiceSpring;
import sessionscope.SessionScopeComponent;

/**
 * Servlet load list of Products and fill attribute with list
 * Created by pavelpetrov on 08.10.16.
 */
@Controller
public class ProductList {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ProductList.class);

    /**
     * inject ProductListServiceSpring spring bean
     */
    @Autowired
    private ProductListServiceSpring productListService;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * Provides a consistent style between Servlet and Portlet
     * environments. create list of products and fill attribute with list
     *
     * @param model ModelAndView
     * @return ModelAndView ProductList page
     */
    @RequestMapping(value = "/ProductListServlet", method = RequestMethod.GET)
    public ModelAndView productList(ModelAndView model) {
        productListService.prepareSessionScopeForProdcutList();
        model.setViewName("ProductList");
//        model = new ModelAndView("ProductList");
        model.addObject("UniqueWeightList", sessionScopeComponent.getWeightList());
        model.addObject("UniquePowerList", sessionScopeComponent.getPowerList());
        model.addObject("UniqueColorList", sessionScopeComponent.getColorList());
        model.addObject("UniqueCategoryList", sessionScopeComponent.getCategoryList());
        model.addObject("UniqueBrandList", sessionScopeComponent.getBrandList());
        model.addObject("ProductList", sessionScopeComponent.getProductList());
        logger.info("create and add to page uniqueWeightList, powerList, ColorList, CategoryList, BrandList," +
                " ProductList");
        return model;
    }
}

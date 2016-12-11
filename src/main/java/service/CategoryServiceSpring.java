package service;

import DAO.implementation.CategoryDaoImlSpring;
import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.Category;
import tables.TablesNames;

import java.util.List;

/**
 * business logic with category table
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class CategoryServiceSpring {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(CategoryServiceSpring.class);

    /**
     * inject categoryDao bean
     */
    @Autowired
    private CategoryDaoImlSpring categoryDao;

    /**
     * inject hhetResult spring bean
     */
    @Autowired
    private HttpResult httpResult;

    /**
     *class constructor
     */
    public CategoryServiceSpring(CategoryDaoImlSpring categoryDao, HttpResult httpResult ) {
        this.categoryDao = categoryDao;
        this.httpResult = httpResult;
    }

    /**
     * defaul constructor
     */
    public CategoryServiceSpring() {
    }

    /**
     * method returns unique Category by name
     *
     * @param categoryName name of category in table;
     * @return Category
     */
    @Transactional
    public Category getCategoryByName(String categoryName) {
        List<Category> categories = categoryDao.getAllObjectsFromeTableWithParamName(TablesNames.CATEGORY, "category", categoryName);
        if (categories.isEmpty()) {
            return null;
        } else {
            return categories.get(0);
        }
    }

    /**
     * insert to Table new Category in DB
     *
     * @param category new category
     */
    @Transactional
    public void createNewCategory(Category category) {
        categoryDao.insertToTable(category);
    }

    /**
     * method returns httpResult, set message if something wrong, set data if everything is ok.
     *
     * @param category      new category
     * @param categoryParam category name
     * @return HttpResult
     */
    @Transactional
    public HttpResult createNewCategoryCheckParam(Category category, String categoryParam) {
        Category category1 = getCategoryByName(categoryParam);
        if (!categoryParam.isEmpty()) {
            if (category1 == null) {
                category.setCategory(categoryParam);
                createNewCategory(category);
                logger.info("Category have been added!");
                httpResult.setData("Category have been added!");
            } else {
                logger.info("This category is already exist!");
                httpResult.setMessage("This category is already exist!");
            }
        } else {
            logger.info("Sorry, but we can't add empty category!");
            httpResult.setMessage("Sorry, but we can't add empty category!");
        }
        return httpResult;
    }

    /**
     * Method returns list of all categories from table Category
     *
     * @return list of categories
     */
    @Transactional
    public List<Category> getAllCategories() {
        return categoryDao.getAllObjectsFromTable(TablesNames.CATEGORY);
    }
}

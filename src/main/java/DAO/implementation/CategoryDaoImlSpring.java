package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.Category;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * consist methods of working with category table in project DB
 * Created by pavelpetrov on 02.11.16.
 */
@Repository
public class CategoryDaoImlSpring {

    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(CategoryDaoImlSpring.class);


    /**
     * serching list of category by parametrs
     *
     * @param tableName       in DT
     * @param fieldName       column in table
     * @param firstParamValue searching value
     * @return object list
     */
    public List<Category> getAllObjectsFromeTableWithParamName(String tableName, String fieldName, String firstParamValue) {
        String query = "SELECT c FROM " + tableName + " c" + " WHERE " + "c." + fieldName + " = ?1";
        logger.info("created list of Category by param name");
        return entityManager.createQuery(query, Category.class).setParameter(1, firstParamValue).getResultList();
    }

    /**
     * method insert new category into table
     *
     * @param objectType of table
     */
    public void insertToTable(Category objectType) {
        logger.info("created new Category");
        entityManager.persist(objectType);
    }

    /**
     * Method returns List of all category witch are in table
     *
     * @return List of objects
     */
    public List<Category> getAllObjectsFromTable(String tableName) {
        String query = "SELECT c FROM " + tableName + " c";
        logger.info("get list of all category objects");
        return entityManager.createQuery(query, Category.class).getResultList();
    }
}

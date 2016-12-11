package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.Product;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * class ProductDaoImplSpring consist methods of working with order table in project DB
 * Created by pavelpetrov on 02.11.16.
 */
@Repository
public class ProductDaoImplSpring {

    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ProductDaoImplSpring.class);


    /**
     * get profit
     *
     * @param time1 start date
     * @param time2 end date
     * @return profit for dates
     */

    public List<Long> getProfitByTime(String time1, String time2) {
        Query query = entityManager.createQuery("SELECT  sum(t.price) " +
                "from Orders c " +
                "INNER JOIN c.products t " +
                "where c.dateOfOrder >= '" + time1 + "' " +
                "AND c.dateOfOrder <= '" + time2 + "'");
        logger.info("created profit list");
        return (List<Long>) query.getResultList();
    }

    /**
     * method for filter for Product table
     *
     * @param category           category
     * @param power              power
     * @param priceLowThreshold  priceLowThreshold
     * @param priceHighThreshold priceHighThreshold
     * @param brand              brand of product
     * @param color              color
     * @param weight             weight
     * @return filtred List
     */

    public List<Product> getFiltredProductList(String category, String power,
                                               String priceLowThreshold, String priceHighThreshold, String brand,
                                               String color, String weight) {


        String query = "SELECT c from Product c JOIN c.category JOIN c.parametr o where 1 = 1";
        if (category.length() > 0) {
            query += " AND c.category.category = '" + category + "'";
        }
        if (power.length() > 0) {
            query += " AND c.parametr.power = '" + power + "'";
        }
        if (priceLowThreshold.length() > 0) {
            query += " AND c.price >= '" + priceLowThreshold + "'";
        }
        if (priceHighThreshold.length() > 0) {
            query += " AND c.price <= '" + priceHighThreshold + "'";
        }
        if (brand.length() > 0) {
            query += " AND c.parametr.brand = '" + brand + "'";
        }
        if (color.length() > 0) {
            query += " AND c.parametr.color = '" + color + "'";
        }
        if (weight.length() > 0) {
            query += " AND c.parametr.weigth = '" + weight + "'";
        }
        logger.info("get list of Product giltered by param");

        return entityManager.createQuery(query, Product.class).getResultList();
    }

    /**
     * get list of top Products
     *
     * @return top productList
     */

    public List<Product> getTopProducts() {
        String query = "select e from Orders c left JOIN c.products e group by e order by count(e) desc";
        logger.info("get lost of top Products");
        return entityManager.createQuery(query, Product.class).getResultList();
    }

    /**
     * method return list of Products object  ordered by param from join table
     *
     * @param tableName      name of the table from TableName class
     * @param orderedByParam sort param
     * @param joingTable     join table
     * @return product  list
     */
    public List<Product> getAllObgectsFromTableByOrderParams(String tableName, String orderedByParam, String joingTable) {
        String query = "SELECT c FROM " + tableName + " c JOIN c." + joingTable +
                " ORDER BY  c." + joingTable + "." + orderedByParam;
        logger.info("get list of Products by param");
        return entityManager.createQuery(query, Product.class).getResultList();
    }


    /**
     * method gives a list of products ordered by param.
     *
     * @param tableName      name of the table in class TableName
     * @param orderedByParam sorted param
     * @return list of Products
     */
    public List<Product> getAllObgectsFromTableByOrder(String tableName, String orderedByParam) {
        String query = "SELECT c FROM " + tableName + " c ORDER BY c." + orderedByParam;
        logger.info("get list of Products ordered by param");
        return entityManager.createQuery(query, Product.class).getResultList();
    }

    /**
     * Method returns List of all Products witch are in table
     *
     * @return List of product
     */
    public List<Product> getAllObjectsFromTable(String tableName) {
        String query = "SELECT c FROM " + tableName + " c";
        logger.info("get all list of Products");
        return entityManager.createQuery(query, Product.class).getResultList();
    }

    /**
     * method returns list of String unique columns
     *
     * @param tableName                           table name
     * @param nameOfSecondTableInFirstTableEntity join table name
     * @param param                               column name
     * @return String list
     */
    public List<String> getUniqueListObjectFromJoinAnotherTable(String tableName,
                                                                String nameOfSecondTableInFirstTableEntity, String param) {
        String query = "select DISTINCT c." + nameOfSecondTableInFirstTableEntity + "." + param + " from " + tableName + " c";
        logger.info("get unique list of product's param ");
        return entityManager.createQuery(query, String.class).getResultList();
    }


    /**
     * method returns list of Integer unique columns
     *
     * @param tableName                           table name
     * @param nameOfSecondTableInFirstTableEntity join table name
     * @param param                               column name
     * @return String list
     */
    public List<Integer> getUniqueListObjectFromJoinAnotherTableForInteger(String tableName,
                                                                           String nameOfSecondTableInFirstTableEntity, String param) {
        String query = "select DISTINCT c." + nameOfSecondTableInFirstTableEntity + "." + param + " from " + tableName + " c";
        return entityManager.createQuery(query, Integer.class).getResultList();
    }

    /**
     * method returns count of unique objects in table with left Join Table
     *
     * @return list of numbers group sorted by value
     */
    public List<Long> getTopProductsCount(String tableName, String joinTable) {
        String query = "select count(e)  from " + tableName + " c left JOIN c." + joinTable + " e group by e order by count(e) desc ";

        return entityManager.createQuery(query).getResultList();
    }

    /**
     * method update Product into table
     *
     * @param objectType type of table
     */
    public void updateTable(Product objectType) {
        logger.info("update Product object");
        entityManager.merge(objectType);
    }

    /**
     * method insert Product into table
     *
     * @param objectType type of table
     */
    public void insertToTable(Product objectType) {
        logger.info("insert new Product into table");
        entityManager.persist(objectType);
    }
}

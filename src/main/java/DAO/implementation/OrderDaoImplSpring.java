package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import tables.Orders;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Class OrderDaoImlSpring consist methods of working with order table in project DB
 * Created by pavelpetrov on 27.09.16.
 */
@Repository
public class OrderDaoImplSpring {


    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrderDaoImplSpring.class);

    /**
     * public constructor
     */
    public OrderDaoImplSpring() {
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }



    /**
     * method gives a list of orders ordered by param.
     *
     * @param tableName      name of the table in class TableName
     * @param orderedByParam sorted param
     * @return listof Objects
     */
    public List<Orders> getAllObgectsFromTableByOrder(String tableName, String orderedByParam) {
        String query = "SELECT c FROM " + tableName + " c ORDER BY c." + orderedByParam;
        logger.info("get Order list ordered by param");
        return entityManager.createQuery(query, Orders.class).getResultList();
    }

    /**
     * method return object list ordered by param from join table
     *
     * @param tableName      name of the table from TableName class
     * @param orderedByParam sort param
     * @param joingTable     join table
     * @return object list
     */
    public List<Orders> getAllObgectsFromTableByOrderParams(String tableName, String orderedByParam, String joingTable) {
        String query = "SELECT c FROM " + tableName + " c JOIN c." + joingTable +
                " ORDER BY  c." + joingTable + "." + orderedByParam;
        logger.info("get List of Orders by param");
        return entityManager.createQuery(query, Orders.class).getResultList();
    }


    /**
     * method return list of orders where one of the params equals serchParam
     *
     * @param tableName   table name from TableName class
     * @param joingTable  jion table
     * @param searchParam searchParam
     * @return objectList
     */
    public List<Orders> getAllObgectsFromTableWhereOneOfTheColumnEqalsParam(String tableName, String joingTable, String searchParam) {

        String query = "SELECT c FROM " + tableName + " c JOIN c." + joingTable
                + " o where c." + joingTable + "." + joingTable + " = '" + searchParam + "'";
        logger.info("get List of Orders by param");
        return entityManager.createQuery(query, Orders.class).getResultList();
    }

    /**
     * Get all orders from table where one of the params do not equals of column
     *
     * @param tableName       table name
     * @param joingTable      join table
     * @param searchParam     search aprametor
     * @param serachingColumn searching column
     * @return list of object
     */
    public List<Orders> getAllObgectsFromTableWhereOneOfTheColumnDontEqalsParam(String tableName, String joingTable, String searchParam, String serachingColumn) {
        String query = "SELECT c FROM " + tableName + " c JOIN c." + joingTable
                + " o where c." + joingTable + "." + serachingColumn + " = '" + searchParam + "'";
        logger.info("get List of Orders by param");
        return entityManager.createQuery(query, Orders.class).getResultList();
    }

    /**
     * method insert order into table
     *
     * @param objectType type of table
     */
    public void insertToTable(Orders objectType) {
        logger.info("insert new Order to table");
        entityManager.persist(objectType);
    }

    /**
     * Method returns List of all orders wutch are in table
     *
     * @return List of objects
     */
    public List<Orders> getAllObjectsFromTable(String tableName) {
        String query = "SELECT c FROM " + tableName + " c";
        logger.info("Get all Orders from table");
        return entityManager.createQuery(query, Orders.class).getResultList();
    }

    /**
     * method update Order into table
     *
     * @param objectType type of table
     */

    public void updateTable(Orders objectType) {
        logger.info("order table have bben updated");
        entityManager.merge(objectType);
    }
}

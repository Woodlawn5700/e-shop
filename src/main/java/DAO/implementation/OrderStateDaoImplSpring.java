package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.OrderState;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * orders tate dao impl string class
 * Created by pavelpetrov on 02.11.16.
 */
@Repository
public class OrderStateDaoImplSpring {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrderStateDaoImplSpring.class);

    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * Metshod returns ordertable object from table by his id
     *
     * @param id object's id in table
     * @return object from table
     */
    public OrderState getObjectFromTable(int id) {
        logger.info("return order state object by id");
        return entityManager.find(OrderState.class, id);
    }


    /**
     * serching list of orderstates  objects by parametrs
     *
     * @param tableName       in DT
     * @param fieldName       locumn in table
     * @param firstParamValue searching value
     * @return object list
     */
    public List<OrderState> getAllObjectsFromeTableWithParamName(String tableName, String fieldName, String firstParamValue) {
        List<OrderState> objectList = null;

        String query = "SELECT c FROM " + tableName + " c" + " WHERE " + "c." + fieldName + " = ?1";

        objectList = entityManager.createQuery(query, OrderState.class).setParameter(1, firstParamValue).getResultList();

        logger.info("Get all order state objects from table with param name Abstract class method");
        return objectList;
    }
}

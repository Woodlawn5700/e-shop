package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.PaymentState;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * class PaymentStateDaoImlSpring consist methods of working with order table in project DB
 * Created by pavelpetrov on 02.11.16.
 */
@Repository
public class PaymentStateDaoImplSpring {

    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(PaymentStateDaoImplSpring.class);

    /**
     * Metshod returns PaymentState object from table by his id
     *
     * @param id object's id in table
     * @return object from table
     */
    public PaymentState getObjectFromTable(int id) {
        logger.info("get paument state object from table by id");
        return (PaymentState) entityManager.find(PaymentState.class, id);
    }


    /**
     * serching list of PAYMENTSTATE by parametrs
     *
     * @param tableName       in DT
     * @param fieldName       locumn in table
     * @param firstParamValue searching value
     * @return PyamentStateList list
     */
    public List<PaymentState> getAllObjectsFromeTableWithParamName(String tableName, String fieldName, String firstParamValue) {
        String query = "SELECT c FROM " + tableName + " c" + " WHERE " + "c." + fieldName + " = ?1";
        logger.info("get PaymentState object list by param");
        return entityManager.createQuery(query, PaymentState.class).setParameter(1, firstParamValue).getResultList();
    }
}

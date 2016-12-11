package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.DeliveryMethod;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * consist methods of working with order table in project DB
 * Created by pavelpetrov on 02.11.16.
 */
@Repository
public class DeliveryMethodDaoImplSpring {

    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(DeliveryMethodDaoImplSpring.class);


    /**
     * serching list of object by parametrs
     *
     * @param tableName       in DT
     * @param fieldName       locumn in table
     * @param firstParamValue searching value
     * @return object list
     */
    public List<DeliveryMethod> getAllObjectsFromeTableWithParamName(String tableName, String fieldName, String firstParamValue) {
        String query = "SELECT c FROM " + tableName + " c" + " WHERE " + "c." + fieldName + " = ?1";
        logger.info("get list of delivery method ibjects by param");
        return entityManager.createQuery(query, DeliveryMethod.class).setParameter(1, firstParamValue).getResultList();
    }
}

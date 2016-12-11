package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.Client;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * consist methods of working with category table in project DB
 * Created by pavelpetrov on 01.11.16.
 */
@Repository
public class ClietnDaoImplSpring {
    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ClietnDaoImplSpring.class);

    /**
     * Get top list of clients ordered by count
     *
     * @return clientList
     */
    public List<Client> getTopListOfObjects() {

        // Query query2 = entityManager.createQuery("select new ")
        String query = "select c.client from Orders c join  c.client e group by c.client order by COUNT(c.client) desc ";

        List<Client> objectList = entityManager.createQuery(query, Client.class).getResultList();

        logger.info("Top list of clients ordered by order quantity ");
        return objectList;
    }

    /**
     * method returns top count of clients
     *
     * @return longList
     */
    public List<Long> getTop() {
        String query = "select  count(c.client) from Orders c group by c.client order by count (c.client) desc ";
        List<Long> objectList = entityManager.createQuery(query, Long.class).getResultList();

        logger.info("List of Long order my cliens order");
        return objectList;
    }

    /**
     * serching list of clients by parametrs
     *
     * @param tableName       in DT
     * @param fieldName       locumn in table
     * @param firstParamValue searching value
     * @return object list
     */
    public List<Client> getAllObjectsFromeTableWithParamName(String tableName, String fieldName, String firstParamValue) {

        String query = "SELECT c FROM " + tableName + " c" + " WHERE " + "c." + fieldName + " = ?1";

        List<Client> objectList = entityManager.createQuery(query, Client.class).setParameter(1, firstParamValue).getResultList();

        logger.info("Get all object from table with param name Abstract class method");
        return objectList;
    }

    /**
     * serching list of clients by parametrs
     *
     * @param tableName        in DB
     * @param fieldName        first searchin field
     * @param secondField      second searching field
     * @param firstParamValue  first searchng param
     * @param secondParamValue second searching param
     * @return object list
     */

    public List<Client> getAllObjectsFromeTableWithParamName(String tableName, String fieldName, String secondField,
                                                             String firstParamValue, String secondParamValue) {

        String query = "SELECT c FROM " + tableName + " c" + " WHERE " + "c." + fieldName + " = ?1 and c."
                + secondField + " = ?2";

        List<Client> objectList = entityManager.createQuery(query, Client.class).setParameter(1, firstParamValue)
                .setParameter(2, secondParamValue).getResultList();

        logger.info("Get all Objects from table with two params Abstaract mehod");
        return objectList;
    }

    /**
     * method update client into table
     *
     * @param objectType type of table
     */
    public void updateTable(Client objectType) {
        logger.info("client have been updated");
        entityManager.merge(objectType);
    }

    /**
     * method insert new client into table
     *
     * @param objectType type of table
     */
    public void insertToTable(Client objectType) {
        logger.info("new client have been created");
        entityManager.persist(objectType);
    }

}

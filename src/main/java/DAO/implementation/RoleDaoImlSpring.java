package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.Role;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * class Role consist methods of working with order table in project DB
 * Created by pavelpetrov on 07.11.16.
 */
@Repository
public class RoleDaoImlSpring {

    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(RoleDaoImlSpring.class);

    /**
     * Method returns List of all Role objects wutch are in table
     *
     * @return List of product
     */

    public List<Role> getAllObjectsFromTable(String tableName) {
        String query = "SELECT c FROM " + tableName + " c";
        logger.info("Get all Role objects from table");
        return entityManager.createQuery(query, Role.class).getResultList();
    }

    /**
     * Metshod returns Role object from table by his id
     *
     * @param id object's id in table
     * @return object from table
     */
    public Role getObjectFromTable(int id) {
        logger.info("get Role object by his id");
        return (Role) entityManager.find(Role.class, id);
    }
}

package DAO.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tables.Params;

import javax.persistence.EntityManager;

/**
 * class ParamDaoSpring consist methods of working with order table in project DB
 * Created by pavelpetrov on 03.11.16.
 */
@Repository
public class ParamsDaoSpring {
    /**
     * inject entityManager
     */
    @Autowired
    private EntityManager entityManager;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ParamsDaoSpring.class);

    /**
     * method insert object into table
     *
     * @param objectType type of table
     */
    public void insertToTable(Params objectType) {
        entityManager.persist(objectType);
        logger.info("Insert new param to DB");
    }

}

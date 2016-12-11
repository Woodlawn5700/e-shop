package service;

import DAO.implementation.OrderStateDaoImplSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.OrderState;

/**
 * class workin g whit Order-state table
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class OrderStateServiceSpring {

    /**
     * inject OrderStateDaoImplSpring spring bean
     */
    @Autowired
    OrderStateDaoImplSpring orderStateDaoImpl;

    /**
     * method returns order state in the stock
     */
    @Transactional
    public OrderState getOrderStateStock() {
        return orderStateDaoImpl.getObjectFromTable(1);
    }
}

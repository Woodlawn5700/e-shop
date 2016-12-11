package service;

import DAO.implementation.OrderDaoImplSpring;
import DAO.implementation.OrderStateDaoImplSpring;
import DAO.implementation.PaymentStateDaoImplSpring;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.OrderState;
import tables.Orders;
import tables.PaymentState;
import tables.TablesNames;

import java.util.List;

/**
 * class works with OrderState and update information in DB
 * Created by pavelpetrov on 04.11.16.
 */
@Service
public class OrderChangeServiseString {

    /**
     * inject OrderStateDaoImplSpring spring bean
     */
    @Autowired
    OrderStateDaoImplSpring orderStateDaoImpl;

    /**
     * inject OrderDaoImplSpring spring bean
     */
    @Autowired
    OrderDaoImplSpring orderDaoImpl;

    /**
     * inject PaymentStateDaoImplSpring spring bean
     */
    @Autowired
    PaymentStateDaoImplSpring paymentStateDaoImpl;



    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrderChangeServiseString.class);

    /**
     * method change OrderState in Orders table and update information
     * @param order Order
     * @param orderState param Order State
     */
    @Transactional
    public void updateOrderState(Orders order, String orderState) {
        List<OrderState> orderState1 = orderStateDaoImpl
                .getAllObjectsFromeTableWithParamName(TablesNames.ORDER_STATE, "orderState", orderState);
        order.setOrderState(orderState1.get(0));
        orderDaoImpl.updateTable(order);
        logger.info("OrderState table have been updated");
    }

    /**
     * method change PaymentState in Orders table and update information in Db
     * @param order Order
     * @param paymentStateParam param Paymnet state of order
     */
    @Transactional
    public void updateOrderPaymentState(Orders order, String paymentStateParam) {
        List<PaymentState> paymentState = paymentStateDaoImpl
                .getAllObjectsFromeTableWithParamName(TablesNames.PAYMENT_STATE, "paymentState", paymentStateParam);
        order.setPaymentState(paymentState.get(0));
        orderDaoImpl.updateTable(order);
        logger.info("OrderPaymentState table have been updated");
    }
}

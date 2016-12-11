package service;

import DAO.implementation.PaymentStateDaoImplSpring;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tables.PaymentState;

/**
 * class workin g whit payment_service table
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class PaymentStateServiceSpring {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(PaymentStateServiceSpring.class);

    /**
     * inject PaymentStateDaoImplSpring spring bean
     */
    @Autowired
    PaymentStateDaoImplSpring paymentStateDaoImpl;

    /**
     * method returns PaymentState depend of payment method
     *
     * @param payment payment method
     * @return PaymentState
     */
    public PaymentState getPaymentStateByMethod(String payment) {
        PaymentState paymentState = null;
        if (payment.equals("cash")) {
            paymentState = paymentStateDaoImpl.getObjectFromTable(2);
            logger.info("Wait for payment");
        } else {
            paymentState = paymentStateDaoImpl.getObjectFromTable(1);
            logger.info("paid");
        }
        return paymentState;
    }
}

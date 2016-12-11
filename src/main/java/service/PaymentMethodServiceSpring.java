package service;

import DAO.implementation.PaymentMethodDaoImplSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.PaymentMethod;
import tables.TablesNames;

import java.util.List;

/**
 * class works with payment method table
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class PaymentMethodServiceSpring {

    /**
     * inject PaymentMethodDaoImplSpring spring bean
     */
    @Autowired
    PaymentMethodDaoImplSpring paymentMethodDaoImpl;

    /**
     * method returns PaymentMethod by name
     * @param payment payment Method
     * @return PaymentMethod
     */
    @Transactional
    public PaymentMethod getPaymentMethod(String payment) {
        List<PaymentMethod> paymentMethodList = paymentMethodDaoImpl
                .getAllObjectsFromeTableWithParamName(TablesNames.PAYMENT_METHOD, "paymetnMethod", payment);
        return paymentMethodList.get(0);
    }
}

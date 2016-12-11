package service;

import DAO.implementation.DeliveryMethodDaoImplSpring;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tables.DeliveryMethod;
import tables.TablesNames;

import java.util.List;

/**
 * class working with delivery method table
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class DeliveryMethodServiceSpring {

    /**
     * inject DeliveryMthodDaoImplSpring spring bean
     */
    @Autowired
    DeliveryMethodDaoImplSpring deliveryMethodDao;

    /**
     * method returns DeliveryMethod by param.
     *
     * @param delivery name of delivery Method
     * @return DeliveryMethod
     */
    public DeliveryMethod getDeliveryMethod(String delivery) {
        List<DeliveryMethod> deliveryMethodList = deliveryMethodDao.
                getAllObjectsFromeTableWithParamName(TablesNames.DELIVERY_METHOD, "deliveryMethod", delivery);
        return deliveryMethodList.get(0);
    }
}

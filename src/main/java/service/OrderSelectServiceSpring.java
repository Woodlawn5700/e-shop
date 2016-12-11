package service;

import DAO.implementation.OrderDaoImplSpring;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tables.Orders;
import tables.TablesNames;

import java.util.List;

/**
 * Class working with OrderSelcetServlet, request information from servlet and response Order sorted list
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class OrderSelectServiceSpring {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrderSelectServiceSpring.class);

    /**
     * inject OrderDaoImplSpring spring bean
     */
    @Autowired
    OrderDaoImplSpring ordersDao;

    /**
     * default constructor
     */
    public OrderSelectServiceSpring() {
    }

    /**
     * class constructor
     * @param ordersDao OrderDaoImplSpring
     */
    public OrderSelectServiceSpring(OrderDaoImplSpring ordersDao) {
        this.ordersDao = ordersDao;
    }

    /**
     * method return sorted order List
     *
     * @param param parametr of searching
     * @return Order list
     */
    @Transactional
    public List<Orders> getSortedOrdersList(String param) {
        List<Orders> ordersList = null;
        if (param.equals("dateOfOrder")) {
            ordersList = ordersDao.getAllObgectsFromTableByOrder(TablesNames.ORDER, param);
        } else if (param.equals("orderState")) {
            ordersList = ordersDao.getAllObgectsFromTableByOrderParams(TablesNames.ORDER, param, "orderState");
        } else if (param.equals("login")) {
            ordersList = ordersDao.getAllObgectsFromTableByOrderParams(TablesNames.ORDER, param, "client");
        } else if (param.equals("deliveryMethod")) {
            ordersList = ordersDao.getAllObgectsFromTableByOrderParams(TablesNames.ORDER, param, "deliveryMethod");
        } else {
            ordersList = ordersDao.getAllObgectsFromTableWhereOneOfTheColumnEqalsParam(TablesNames.ORDER, "orderState", param);
        }
        logger.info("order list have been sorted");
        return ordersList;
    }

    /**
     * method return list of Orders by search user login
     *
     * @param userlogin String search param
     * @return List of Orders
     */
    @Transactional
    public List<Orders> getListOfOrderByClient(String userlogin) {
        List<Orders> orderListByClientName = ordersDao
                .getAllObgectsFromTableWhereOneOfTheColumnDontEqalsParam(TablesNames.ORDER, "client", userlogin, "login");
        if (orderListByClientName.size() == 0) {
            return null;
        } else {
            return orderListByClientName;
        }
    }
}

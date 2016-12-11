package service;

import DAO.implementation.OrderDaoImplSpring;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tables.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * OrderSelectServiceSrping class test
 * Created by pavelpetrov on 24.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class OrderSelectServiceSpringTest {
    private OrderSelectServiceSpring orderSelectServiceSpring;
    private Orders orders1;
    private Orders orders2;
    private List<Orders> testOrdersList;

    @Mock
    private OrderDaoImplSpring ordersDao;

    @Before
    public void setUp() throws Exception {
        testOrdersList = new ArrayList<>();
        orderSelectServiceSpring = new OrderSelectServiceSpring(ordersDao);
        Client client1 = new Client("test1", "test1", "test1", "test1");
        Client client2 = new Client("test2", "test2", "test2", "test2");
        OrderState orderState1 = new OrderState();
        orderState1.setOrderState("1");
        OrderState orderState2 = new OrderState();
        orderState1.setOrderState("2");
        Date date1 = new Date(12345);
        Date date2 = new Date(123456);
        DeliveryMethod deliveryMethod1 = new DeliveryMethod();
        deliveryMethod1.setDeliveryMethod("1");
        DeliveryMethod deliveryMethod2 = new DeliveryMethod();
        deliveryMethod2.setDeliveryMethod("2");
        orders1 = new Orders(client1, orderState2, deliveryMethod1, date2);
        orders2 = new Orders(client2, orderState1, deliveryMethod2, date1);
        List<Orders> dateAndOrderStateSelectOrderList = new ArrayList<>();
        dateAndOrderStateSelectOrderList.add(orders2);
        dateAndOrderStateSelectOrderList.add(orders1);
        List<Orders> clientAdnDeliveryMethodSortedOrderList = new ArrayList<>();
        clientAdnDeliveryMethodSortedOrderList.add(orders1);
        clientAdnDeliveryMethodSortedOrderList.add(orders2);

        when(ordersDao.getAllObgectsFromTableByOrder(TablesNames.ORDER, "dateOfOrder"))
                .thenReturn(dateAndOrderStateSelectOrderList);
        when(ordersDao.getAllObgectsFromTableByOrderParams(TablesNames.ORDER, "orderState", "orderState"))
                .thenReturn(dateAndOrderStateSelectOrderList);
        when(ordersDao.getAllObgectsFromTableByOrderParams(TablesNames.ORDER, "login", "client"))
                .thenReturn(clientAdnDeliveryMethodSortedOrderList);
        when(ordersDao.getAllObgectsFromTableByOrderParams(TablesNames.ORDER, "deliveryMethod", "deliveryMethod"))
                .thenReturn(clientAdnDeliveryMethodSortedOrderList);

    }

    @After
    public void tearDown() throws Exception {
        testOrdersList = new ArrayList<>();
    }
    @Test
    public void testMockCreation() {
        assertNotNull(ordersDao);
    }

    @Test
    public void getSortedOrdersListByDateOfOrder() throws Exception {
        testOrdersList.add(orders2);
        testOrdersList.add(orders1);
        Assert.assertEquals(testOrdersList, orderSelectServiceSpring.getSortedOrdersList("dateOfOrder"));

    }

    @Test
    public void getSortedOrdersListByOrderState() throws Exception {
        testOrdersList.add(orders2);
        testOrdersList.add(orders1);
        Assert.assertEquals(testOrdersList, orderSelectServiceSpring.getSortedOrdersList("orderState"));

    }

    @Test
    public void getSortedOrdersListByClient() throws Exception {
        testOrdersList.add(orders1);
        testOrdersList.add(orders2);
        Assert.assertEquals(testOrdersList, orderSelectServiceSpring.getSortedOrdersList("login"));

    }

    @Test
    public void getSortedOrdersListByDeliveryMethod() throws Exception {
        testOrdersList.add(orders1);
        testOrdersList.add(orders2);
        Assert.assertEquals(testOrdersList, orderSelectServiceSpring.getSortedOrdersList("deliveryMethod"));

    }


}
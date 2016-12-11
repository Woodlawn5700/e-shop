package service;

import DAO.implementation.OrderDaoImplSpring;
import httphendler.HttpResult;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sessionscope.SessionScopeComponent;
import tables.*;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * class workinf with Orders table
 * Created by pavelpetrov on 02.11.16.
 */
@Service
public class OrderServiceSpring {

    /**
     * inject OrderDaoImplSpring spring bean
     */
    @Autowired
    OrderDaoImplSpring orderDaoImp;

    /**
     * inject HttpResult spring bean
     */
    @Autowired
    private HttpResult resultHttp;

    /**
     * inject ProductListServiceSpring spring bean
     */
    @Autowired
    private ProductListServiceSpring productListService;

    /**
     * inject DeliveryMethodServiceSpring spring bean
     */
    @Autowired
    private DeliveryMethodServiceSpring deliveryMethodService;

    /**
     * inject ClientServiceSpring spring bean
     */
    @Autowired
    private ClientServiceSpring clientServiceSpring;

    /**
     * inject PaymentStateServiceSpring spring bean
     */
    @Autowired
    private PaymentStateServiceSpring paymentStateService;

    /**
     * inject OrtderStateServiceSpring spring bean
     */
    @Autowired
    private OrderStateServiceSpring orderStateService;

    /**
     * inject PaymentMethodServiceSpring spring bean
     */
    @Autowired
    private PaymentMethodServiceSpring paymentMethodService;

    /**
     * inject SessionScopeComponent spring bean
     */
    @Autowired
    private SessionScopeComponent sessionScopeComponent;

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrderServiceSpring.class);

    /**
     * Order object
     */
    private Orders orders;

    /**
     * Client object
     */
    private Client client;

    /**
     * PaymentMethod object
     */
    private PaymentMethod paymentMethod;

    /**
     * list of Prodcut objects
     */
    private List<Product> products;

    /**
     * PaymentState object
     */
    private PaymentState paymentState;

    /**
     * OrderState object
     */
    private OrderState orderState;

    /**
     * Date date
     */
    private Date date;

    /**
     * DeliveryMethod object
     */
    private DeliveryMethod deliveryMethod;

    /**
     * String client's comments
     */
    private String comments;

    /**
     * default class constructor
     */
    public OrderServiceSpring() {
    }


    /**
     * constructor
     *
     * @param comments       client's comment
     * @param deliveryMethod deliveryMethod
     * @param date           date
     * @param orderState     orderState
     * @param paymentState   paymentState
     * @param products       products
     * @param paymentMethod  paymentMethod
     * @param client         client
     */
    public OrderServiceSpring(String comments, DeliveryMethod deliveryMethod, Date date, OrderState orderState,
                              PaymentState paymentState, List<Product> products, PaymentMethod paymentMethod, Client client) {
        this.client = client;
        this.paymentMethod = paymentMethod;
        this.products = products;
        this.paymentState = paymentState;
        this.orderState = orderState;
        this.date = date;
        this.deliveryMethod = deliveryMethod;
        this.comments = comments;
    }


    /**
     * fill the Order List Table
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void fillTheOrderTable() {
        orders = new Orders();
        orders.setClient(client);
        orders.setComments(comments);
        orders.setDateOfOrder(date);
        orders.setDeliveryMethod(deliveryMethod);
        orders.setOrderState(orderState);
        orders.setPaymentMethod(paymentMethod);
        Set<Product> poductSet = new HashSet<>();
        for (Product p : products) {
            poductSet.add(p);
        }
        orders.setProducts(poductSet);
        orders.setPaymentState(paymentState);
        OrderDaoImplSpring daoImplSpring = new OrderDaoImplSpring();
        daoImplSpring.insertToTable(orders);
        productListService.updateProducts(products);
        logger.info("new Order inserted to table, product have been updated");
    }


    /**
     * method prepare
     * @param request
     * @param delivery
     * @param payment
     * @param comments
     * @return
     */
    @Transactional
    public HttpResult byProductsByClient(HttpSession request, String delivery, String payment, String comments) {
        String clientLogin = sessionScopeComponent.getUsername();

        Client client = clientServiceSpring.getClient(clientLogin);
        DeliveryMethod deliveryMethod = deliveryMethodService.getDeliveryMethod(delivery);
        List<Product> productList = sessionScopeComponent.getPoductsAreReadyToBuy();
        if (productList.size() == 0) {
            resultHttp.setMessage("There is no products to buy");
        } else {
            PaymentState paymentState = paymentStateService.getPaymentStateByMethod(payment);
            OrderState orderState = orderStateService.getOrderStateStock();
            Date date = new Date();
            PaymentMethod paymentMethod = paymentMethodService.getPaymentMethod(payment);
            setComments(comments);
            setDeliveryMethod(deliveryMethod);
            setDate(date);
            setOrderState(orderState);
            setPaymentState(paymentState);
            setProducts(productList);
            setPaymentMethod(paymentMethod);
            setClient(client);
            if (!productListService.getAbleToBuyProdcut(productList)) {
                logger.info("Unable to buy products");
                resultHttp.setMessage("Unable to buy products");
            } else {
                fillTheOrderTable();
                request.setAttribute("ProductsOnCardQuantity", null);
                request.setAttribute("ListOfProductOnCard", null);
                request.setAttribute("TotalPrice", null);
                logger.info("Order Have been completed!");
                resultHttp.setData("Order Have been completed!");
            }
        }
        return resultHttp;
    }

    /**
     * method returns all Orders from DB
     *
     * @return orders list
     */
    @Transactional
    public List<Orders> getAllOrders() {
        return orderDaoImp.getAllObjectsFromTable(TablesNames.ORDER);
    }

    /**
     * Orders getter
     *
     * @return order object
     */
    public Orders getOrders() {
        return orders;
    }

    /**
     * Orders setter
     *
     * @param orders order
     */
    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
     * Client getter
     *
     * @return client object
     */
    public Client getClient() {
        return client;
    }

    /**
     * Client Setter
     *
     * @param client client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * PaymentMethod getter
     *
     * @return paymentMethod object
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * paymentMethod setter
     *
     * @param paymentMethod payment method
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * product list getter
     *
     * @return product list
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * product list getter
     *
     * @param products product list
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * PaymentState getter
     *
     * @return paymentState object
     */
    public PaymentState getPaymentState() {
        return paymentState;
    }

    /**
     * paymentState setter
     *
     * @param paymentState payment state
     */
    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    /**
     * orderState getter
     *
     * @return order state object
     */
    public OrderState getOrderState() {
        return orderState;
    }

    /**
     * orderState setter
     *
     * @param orderState order state
     */
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    /**
     * Date date getter
     *
     * @return Date object
     */
    public Date getDate() {
        return date;
    }

    /**
     * Date date setter
     *
     * @param date date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Delivery method getter
     *
     * @return delivery method object
     */
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Delivery method setter
     *
     * @param deliveryMethod deliveru method
     */
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * clients comments getter
     *
     * @return client's comments String
     */
    public String getComments() {
        return comments;
    }

    /**
     * client's comment's setter
     *
     * @param comments commnets
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
}

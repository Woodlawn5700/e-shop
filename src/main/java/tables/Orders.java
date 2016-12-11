package tables;

import org.apache.log4j.Logger;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "orders" table in DB
 * Created by pavelpetrov on 27.09.16.
 */
@Entity
@Table(name = "orders")
@AttributeOverride(name = "entityId", column = @Column(name = "order_id"))
public class Orders extends TableEntity {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Orders.class);

    /**
     * Client's id
     */
    @ManyToOne(
            fetch = FetchType.LAZY)
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * Payment method id
     */
    @ManyToOne(
            fetch = FetchType.LAZY)
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "payment_method_id")
    private PaymentMethod paymentMethod;

    /**
     * many to many relation to product table
     */
    @ManyToMany(
            fetch = FetchType.LAZY)
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinTable(name = "order_product", joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "product_id")
    private Set<Product> products = new HashSet<Product>();

    /**
     * payment state id
     */
    @ManyToOne(
            fetch = FetchType.LAZY)
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "payment_state_id")
    private PaymentState paymentState;

    /**
     * order state id
     */
    @ManyToOne(
            fetch = FetchType.LAZY)
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "order_statement_id")
    private OrderState orderState;

    /**
     * delivery method id
     */
    @ManyToOne(
            fetch = FetchType.LAZY)
    @NotFound(
            action = NotFoundAction.IGNORE)
    @JoinColumn(name = "delivery_method_id")
    private DeliveryMethod deliveryMethod;

    /**
     * date of order
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "date_of_order")
    private Date dateOfOrder;

    /**
     * comments
     */
    @Column(name = "comments")
    private String comments;

    /**
     * default constructor
     */
    public Orders() {
    }

    /**
     * class constructor
     * @param client Client
     * @param orderState OrderState object
     * @param deliveryMethod DeliveryMethod object
     * @param dateOfOrder date of order
     */
    public Orders(Client client, OrderState orderState, DeliveryMethod deliveryMethod, Date dateOfOrder) {
        this.client = client;
        this.orderState = orderState;
        this.deliveryMethod = deliveryMethod;
        this.dateOfOrder = dateOfOrder;
    }

    /**
     * Date of Order getter
     *
     * @return Date of Order
     */
    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    /**
     * Date of Order setter
     *
     * @param dateOfOrder Date of Order
     */
    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    /**
     * client's comments getter
     *
     * @return client's comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * client's comments setter
     *
     * @param comments client's comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * Order State getter
     *
     * @return Order state
     */
    public OrderState getOrderState() {
        return orderState;
    }

    /**
     * Order state setter
     *
     * @param orderState Order state
     */
    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    /**
     * Delivery Method getter
     *
     * @return Delivery Method object
     */
    public DeliveryMethod getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Delivery Method setter
     *
     * @param deliveryMethod Delivery Method object
     */
    public void setDeliveryMethod(DeliveryMethod deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }

    /**
     * Payment State getter
     *
     * @return Payment State object
     */
    public PaymentState getPaymentState() {
        return paymentState;
    }

    /**
     * Payment State setter
     *
     * @param paymentState Payment State object
     */
    public void setPaymentState(PaymentState paymentState) {
        this.paymentState = paymentState;
    }

    /**
     * Client getter
     *
     * @return Client object
     */
    public Client getClient() {
        return client;
    }

    /**
     * Client setter
     *
     * @param client object
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Paymet Method getter
     *
     * @return Paymet Method object
     */
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Paymet Method setter
     *
     * @param paymentMethod Paymet Method object
     */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Product Set getter
     *
     * @return Product Set object
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Product Set setter
     *
     * @param products Product Set object
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

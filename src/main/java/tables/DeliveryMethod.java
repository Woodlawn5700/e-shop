package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entety of "delivery_method" table in DB
 * Created by pavelpetrov on 28.09.16.
 */

@Entity
@Table(name = "delivery_method")
@AttributeOverride(name = "entityId", column = @Column(name = "delivery_method_id"))
public class DeliveryMethod extends TableEntity {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(DeliveryMethod.class);

    /**
     * name of delivery method in "delivery_method" table
     */
    @Column(name = "delivery_method", unique = true)
    private String deliveryMethod;

    /**
     * set of orderses
     */
    @OneToMany(mappedBy = "deliveryMethod")
    private Set<Orders> orderses = new HashSet<Orders>();

    /**
     * Set of Orders getter
     *
     * @return set of Orders
     */
    public Set<Orders> getOrderses() {
        return orderses;
    }

    /**
     * Set of Orders setter
     *
     * @param orderses set of Orders
     */
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }

    /**
     * Deliveru Method getter
     *
     * @return Deliveru Method
     */
    public String getDeliveryMethod() {
        return deliveryMethod;
    }

    /**
     * Deliveru Method setter
     *
     * @param deliveryMethod Deliveru Method
     */
    public void setDeliveryMethod(String deliveryMethod) {
        this.deliveryMethod = deliveryMethod;
    }
}

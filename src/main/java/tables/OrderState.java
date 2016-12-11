package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "order state" table in DB
 * Created by pavelpetrov on 28.09.16.
 */

@Entity
@Table(name = "order_state")
@AttributeOverride(name = "entityId", column = @Column(name = "order_statement_id"))
public class OrderState extends TableEntity {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(OrderState.class);

    /**
     * name of order state
     */
    @Column(name = "order_statement", unique = true)
    private String orderState;

    /**
     * set of orderses
     */
    @OneToMany(mappedBy = "orderState")
    private Set<Orders> orderses = new HashSet<Orders>();

    /**
     * Order State getter
     *
     * @return Order State object
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * Order State setter
     *
     * @param orderState Order State
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    /**
     * Orders Set getter
     *
     * @return Orders Set
     */
    public Set<Orders> getOrderses() {
        return orderses;
    }

    /**
     * Orders Set setter
     *
     * @param orderses Orders Set
     */
    public void setOrderses(Set<Orders> orderses) {
        this.orderses = orderses;
    }
}

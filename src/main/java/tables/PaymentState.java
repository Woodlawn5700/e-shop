package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "payment_state" table in DB
 * Created by pavelpetrov on 28.09.16.
 */

@Entity
@Table(name = "payment_state")
@AttributeOverride(name = "entityId", column = @Column(name = "payment_statement_id"))
public class PaymentState extends TableEntity {

    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(PaymentState.class);

    /**
     * name of payment state in table "payment_state"
     */
    @Column(name = "payment_statement", unique = true)
    private String paymentState;

    /**
     * set of orderses
     */
    @OneToMany(mappedBy = "paymentState")
    private Set<Orders> orderses = new HashSet<Orders>();

    /**
     * Payment State getter
     *
     * @return PaymentState object
     */
    public String getPaymentState() {
        return paymentState;
    }

    /**
     * Payment State setter
     *
     * @param paymentState PaymentState object
     */
    public void setPaymentState(String paymentState) {
        this.paymentState = paymentState;
    }
}

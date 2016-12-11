package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "payment_method" table in DB
 * Created by pavelpetrov on 28.09.16.
 */
@Entity
@Table(name = "payment_method")
@AttributeOverride(name = "entityId", column = @Column(name = "payment_method_id"))
public class PaymentMethod extends TableEntity {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(PaymentMethod.class);

    /**
     * name of payment method in table "payment_method"
     */
    @Column(name = "payment_method", unique = true)
    private String paymetnMethod;

    /**
     * set of orderses
     */
    @OneToMany(mappedBy = "paymentMethod")
    private Set<Orders> orderses = new HashSet<Orders>();

    /**
     * Payment Method getter
     *
     * @return Payment Method object
     */
    public String getPaymetnMethod() {
        return paymetnMethod;
    }

    /**
     * Payment Method setter
     *
     * @param paymetnMethod Payment Method object
     */
    public void setPaymetnMethod(String paymetnMethod) {
        this.paymetnMethod = paymetnMethod;
    }
}

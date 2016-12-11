package tables;

import org.apache.log4j.Logger;

/**
 * quick access to toble names
 * Created by pavelpetrov on 01.10.16.
 */
public class TablesNames {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(TablesNames.class);

    /**
     * name of client table
     */
    public static final String CLIENT = "Client";

    /**
     * name of oreder table
     */
    public static final String ORDER = "Orders";

    /**
     * name of category table
     */
    public static final String CATEGORY = "Category";

    /**
     * name of delivery method table
     */
    public static final String DELIVERY_METHOD = "DeliveryMethod";

    /**
     * name of order state table
     */
    public static final String ORDER_STATE = "OrderState";

    /**
     * name of params table
     */
    public static final String PARAMS = "Params";

    /**
     * name of payment method table
     */
    public static final String PAYMENT_METHOD = "PaymentMethod";

    /**
     * name of payment state table
     */
    public static final String PAYMENT_STATE = "PaymentState";


    /**
     * name of product table
     */
    public static final String PRODUCT = "Product";

    /**
     * name of product_param table
     */
    public static final String PRODCUT_PARAM = "ProductParam";


}

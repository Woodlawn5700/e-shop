package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;

/**
 * Hiberanate class discolate entity of "product_param" table in DB
 * Created by pavelpetrov on 28.09.16.
 */

@Entity
@Table(name = "product_param")
public class ProductParam {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(ProductParam.class);

    /**
     * id of product_param
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productParamId;

    /**
     * foreign key of product id
     */
    @Column(name = "product_id_fk")
    private int productIdFk;

    /**
     * foreign key of param id
     */
    @Column(name = "param_id_fk")
    private int paramIdFk;

    /**
     * Prodcut paramId getter
     *
     * @return ProductParamId
     */
    public int getProductParamId() {
        return productParamId;
    }

    /**
     * Prodcut param id setter
     *
     * @param productParamId ProductParamId
     */
    public void setProductParamId(int productParamId) {
        this.productParamId = productParamId;
    }

    /**
     * Product id getter
     *
     * @return product id
     */
    public int getProductIdFk() {
        return productIdFk;
    }

    /**
     * Product id setter
     *
     * @param productIdFk product id
     */
    public void setProductIdFk(int productIdFk) {
        this.productIdFk = productIdFk;
    }

    /**
     * param id getter
     *
     * @return pararm id
     */
    public int getParamIdFk() {
        return paramIdFk;
    }

    /**
     * param id setter
     *
     * @param paramIdFk param id
     */
    public void setParamIdFk(int paramIdFk) {
        this.paramIdFk = paramIdFk;
    }
}

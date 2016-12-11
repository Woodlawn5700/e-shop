package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "params" table in DB
 * Created by pavelpetrov on 28.09.16.
 */

@Entity
@Table(name = "params")
@AttributeOverride(name = "entityId", column = @Column(name = "param_id"))
public class Params extends TableEntity {


    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Params.class);

    /**
     * brand id in "params" table
     */
    @Column(name = "brand")
    private String brand;

    /**
     * power id in "params" table
     */
    @Column(name = "power")
    private int power;

    /**
     * color id in "params" table
     */
    @Column(name = "color")
    private String color;

    /**
     * weight id in "params" table
     */
    @Column(name = "weight")
    private int weigth;

    /**
     * set of products
     */
    @OneToMany(mappedBy = "parametr")
    private Set<Product> products = new HashSet<Product>();

    /**
     * constrctor with params
     *
     * @param brand
     * @param color
     * @param power
     * @param weigth
     */
    public Params(String brand, String color, int power, int weigth) {
        this.brand = brand;
        this.color = color;
        this.power = power;
        this.weigth = weigth;
    }

    /**
     * constructor without params
     */
    public Params() {
    }

    /**
     * brand name getter
     *
     * @return String Brand name
     */
    public String getBrand() {
        return brand;
    }

    /**
     * power getter
     *
     * @return Integer power
     */
    public int getPower() {
        return power;
    }

    /**
     * power setter
     *
     * @param power Integer power
     */
    public void setPower(int power) {
        this.power = power;
    }

    /**
     * color getter
     *
     * @return String color name
     */
    public String getColor() {
        return color;
    }

    /**
     * weight getter
     *
     * @return Integer weight
     */
    public int getWeigth() {
        return weigth;
    }

    /**
     * weight setter
     *
     * @param weigthId Integer weight
     */
    public void setWeigth(int weigthId) {
        this.weigth = weigth;
    }

    /**
     * brand setter
     *
     * @param brand String brand name
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * color setter
     *
     * @param color String color name
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Product set getter
     *
     * @return Product Set
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Product set setter
     *
     * @param products Product Set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "product" table in DB
 * Created by pavelpetrov on 28.09.16.
 */

@Entity
@Table(name = "product")
@AttributeOverride(name = "entityId", column = @Column(name = "product_id"))
public class Product extends TableEntity {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Product.class);

    /**
     * id of category
     */
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    /**
     * description of product
     */
    @Column(name = "description")
    private String description;

    /**
     * price of product
     */
    @Column(name = "price")
    private int price;

    /**
     * name of Product
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * oaramet id
     */
    @ManyToOne
    @JoinColumn(name = "parametr_id")
    private Params parametr;

    /**
     * avalible quantity of product
     */
    @Column(name = "quantity")
    private int quantity;

    /**
     * many to many relation to order table
     */
    @ManyToMany(mappedBy = "products")
    private Set<Orders> orderses = new HashSet<Orders>();

    /**
     * private count of products on cart
     */
    @Transient
    private int quantityOfProductsOnCart;


    /**
     * Product table constructor
     *
     * @param description
     * @param price
     * @param productName
     * @param quantity
     */
    public Product(String description, int price, String productName, int quantity) {
        this.description = description;
        this.price = price;
        this.productName = productName;
        this.quantity = quantity;
        this.orderses = orderses;
    }

    /**
     * default constructor
     */
    public Product() {
    }

    /**
     * quantity of product on cart getter
     *
     * @return int quantityOfProductsOnCart
     */
    public int getQuantityOfProductsOnCart() {
        return quantityOfProductsOnCart;
    }

    /**
     * quantity of product on cart setter
     *
     * @param quantityOfProductsOnCart int quantityOfProductsOnCart
     */
    public void setQuantityOfProductsOnCart(int quantityOfProductsOnCart) {
        this.quantityOfProductsOnCart = quantityOfProductsOnCart;
    }

    /**
     * Category getter
     *
     * @return Category object
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Category setter
     *
     * @param category Category object
     */
    public void setCategory(Category category) {
        this.category = category;
    }

    /**
     * product description getter
     *
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * product description setter
     *
     * @param description String description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * price getter
     *
     * @return int price
     */
    public int getPrice() {
        return price;
    }

    /**
     * price setter
     *
     * @param price int price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * product name getter
     *
     * @return String product name
     */
    public String getProductName() {
        return productName;
    }

    /**
     * product name setter
     *
     * @param productName String product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
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

    /**
     * quantity getter
     *
     * @return int quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * product quantity setter
     *
     * @param quantity int quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Params getter
     *
     * @return Params object
     */
    public Params getParametr() {
        return parametr;
    }

    /**
     * Params setter
     *
     * @param parametr Params object
     */
    public void setParametr(Params parametr) {
        this.parametr = parametr;
    }

    /**
     * override equals method
     *
     * @param obj Object
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        Product obj2 = (Product) obj;
        if (this.getDescription().equals(obj2.getDescription())
                && this.getProductName().equals(obj2.getProductName())
                && this.getPrice() == obj2.getPrice()) {
            return true;
        } else {
            return false;
        }
    }
}

package tables;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Hiberanate class discolate entity of "category" table in DB
 * Created by pavelpetrov on 28.09.16.
 */
@Entity
@Table(name = "category")
@AttributeOverride(name = "entityId", column = @Column(name = "category_id"))
public class Category extends TableEntity {
    /**
     * class logger
     */
    private static Logger logger = Logger.getLogger(Category.class);

    /**
     * id of previous category
     * for example: doors -> wooden door
     */
    @Column(name = "category")
    private String category;


    /**
     * set of products
     */
    @OneToMany(mappedBy = "category")
    private Set<Product> products = new HashSet<Product>();

    /**
     * category name getter
     * @return category name
     */
    public String getCategory() {
        return category;
    }

    /**
     * category name setter
     * @param category  categoty name
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Product Set getter
     * @return ProductSet
     */
    public Set<Product> getProducts() {
        return products;
    }

    /**
     * Product Set setter
     * @param products Product set
     */
    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}

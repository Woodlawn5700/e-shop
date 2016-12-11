package sessionscope;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import tables.Category;
import tables.Client;
import tables.Orders;
import tables.Product;

import java.util.List;

/**
 * class spring bean for session scope of app
 * Created by pavelpetrov on 11.11.16.
 */
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionScopeComponent {

    /**
     * prudct list
     */
    private List<Product> productList;

    /**
     * brand list
     */
    private List<String> brandList;

    /**
     * category list
     */
    private List<Category> categoryList;

    /**
     * color list
     */
    private List<String> colorList;

    /**
     * power list
     */
    private List<Integer> powerList;

    /**
     * weight list
     */
    private List<Integer> weightList;

    /**
     * product lis on cart
     */
    private List<Product> productListOnMyCard;

    /**
     * order list for admin
     */
    private List<Orders> orderListAdmin;

    /**
     *
     */
    private Orders orderToChange;

    /**
     * profit
     */
    private Long prifitForData;

    /**
     * client
     */
    private Client client;

    /**
     * client's username
     */
    private String username;

    /**
     * product a ready to buy
     */
    private List<Product> poductsAreReadyToBuy;

    /**
     * total price on client's cart
     */
    private String totaPrice;

    /**
     * quantity prodcts on client's cart
     */
    private int quantityProductsOnMyCard;

    /**
     * productsArereadyToBuy getter
     *
     * @return Product list
     */
    public List<Product> getPoductsAreReadyToBuy() {
        return poductsAreReadyToBuy;
    }

    /**
     * productsArereadyToBuy setter
     *
     * @param poductsAreReadyToBuy products are ready to buy
     */
    public void setPoductsAreReadyToBuy(List<Product> poductsAreReadyToBuy) {
        this.poductsAreReadyToBuy = poductsAreReadyToBuy;
    }

    /**
     * client's user name getter
     *
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * client's username setter
     *
     * @param username String username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * client getter
     *
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * client setter
     *
     * @param client client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * profit getter
     *
     * @return Losng profit
     */
    public Long getPrifitForData() {
        return prifitForData;
    }

    /**
     * profit setter
     *
     * @param prifitForData profit
     */
    public void setPrifitForData(Long prifitForData) {
        this.prifitForData = prifitForData;
    }

    /**
     * order to change getter
     *
     * @return Orders
     */
    public Orders getOrderToChange() {
        return orderToChange;
    }

    /**
     * order to change getter
     *
     * @param orderToChange order to chage
     */
    public void setOrderToChange(Orders orderToChange) {
        this.orderToChange = orderToChange;
    }

    /**
     * order list admin getter
     *
     * @return list of Orders
     */
    public List<Orders> getOrderListAdmin() {
        return orderListAdmin;
    }

    /**
     * order list admin setter
     *
     * @param orderListAdmin Orders list
     */
    public void setOrderListAdmin(List<Orders> orderListAdmin) {
        this.orderListAdmin = orderListAdmin;
    }

    /**
     * quantity of products in catr getter
     *
     * @return quantityProductsOnMyCard
     */
    public int getQuantityProductsOnMyCard() {
        return quantityProductsOnMyCard;
    }

    /**
     * quantity of products in catr setter
     *
     * @param quantityProductsOnMyCard quantityProductsOnMyCard
     */
    public void setQuantityProductsOnMyCard(int quantityProductsOnMyCard) {
        this.quantityProductsOnMyCard = quantityProductsOnMyCard;
    }

    /**
     * total price getter
     *
     * @return total price
     */
    public String getTotaPrice() {
        return totaPrice;
    }

    /**
     * total price setter
     *
     * @param totaPrice total price
     */
    public void setTotaPrice(String totaPrice) {
        this.totaPrice = totaPrice;
    }

    /**
     * product list on Clients cart getter
     *
     * @return product list on client's cart
     */
    public List<Product> getProductListOnMyCard() {
        return productListOnMyCard;
    }

    /**
     * product list on client's cart setter
     *
     * @param productListOnMyCard product list on client's cart
     */
    public void setProductListOnMyCard(List<Product> productListOnMyCard) {
        this.productListOnMyCard = productListOnMyCard;
    }

    /**
     * productList getter
     *
     * @return productList
     */
    public List<Product> getProductList() {
        return productList;
    }

    /**
     * prodcutList setter
     *
     * @param productList Product list
     */
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    /**
     * Brand list  getter
     *
     * @return Brand list
     */
    public List<String> getBrandList() {
        return brandList;
    }

    /**
     * bran list setter
     *
     * @param brandList BrandName list
     */
    public void setBrandList(List<String> brandList) {
        this.brandList = brandList;
    }

    /**
     * category list getter
     *
     * @return Category list
     */
    public List<Category> getCategoryList() {
        return categoryList;
    }

    /**
     * category list setter
     *
     * @param categoryList Category list
     */
    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    /**
     * color list getter
     *
     * @return ColorName list
     */
    public List<String> getColorList() {
        return colorList;
    }

    /**
     * color list setter
     *
     * @param colorList Color name list
     */
    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }

    /**
     * Power list getter
     *
     * @return Power Integer list
     */
    public List<Integer> getPowerList() {
        return powerList;
    }

    /**
     * Power list setter
     *
     * @param powerList Power Integer list
     */
    public void setPowerList(List<Integer> powerList) {
        this.powerList = powerList;
    }

    /**
     * Weight list getter
     *
     * @return Weight Integer List
     */
    public List<Integer> getWeightList() {
        return weightList;
    }

    /**
     * Weight list setter
     *
     * @param weightList Weight Integer List
     */
    public void setWeightList(List<Integer> weightList) {
        this.weightList = weightList;
    }
}

package DTO;

/**
 * Created by pavelpetrov on 17.11.16.
 */
public class ProductDTO {
    /**
     * prodcu name
     */
    private String productName;

    /**
     * product price
     */
    private String productPrice;

    /**
     * prodcut brand
     */
    private String productBrand;

    /**
     * prodcut name getter
     * @return productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * product name setter
     * @param productName product name
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * prudct price getter
     * @return productPrice
     */
    public String getProductPrice() {
        return productPrice;
    }

    /**
     * product price setter
     * @param productPrice product price
     */
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * product brand getter
     * @return productBrand
     */
    public String getProductBrand() {
        return productBrand;
    }

    /**
     * prudct brand setter
     * @param productBrand prodcut brand
     */
    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }
}

package service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tables.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * test class for  AddProductsToCardSeviceSpring class
 * Created by pavelpetrov on 20.11.16.
 */
public class AddProductsToCardSeviceSpringTest {

    private Product product1;
    private Product product2;
    private List<Product> productList;
    private AddProductsToCardSeviceSpring addProductsToCardSeviceSpring;

    @Before
    public void setUp() throws Exception {
        addProductsToCardSeviceSpring = new AddProductsToCardSeviceSpring();
        product1 = new Product("1", 1, "1", 1);
        product2 = new Product("2", 2, "2", 2);
        productList = new ArrayList<Product>();


    }
    @After
    public void tearDown() throws Exception {
        productList = new ArrayList<Product>();
    }

    @Test
    public void getListOgProductsOnCartManyProducts()  throws Exception {
        productList.add(product1);
        product1.setQuantityOfProductsOnCart(1);
        product2.setQuantityOfProductsOnCart(1);
        Assert.assertEquals(2, addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product1)
                .get(0).getQuantityOfProductsOnCart());
    }

    @Test
    public void getListOfPrudctsONCartTestWithOneElement() throws  Exception {
        Assert.assertEquals(1, addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product2)
                .get(0).getQuantityOfProductsOnCart());
    }

    @Test
    public void getListOfPrudctsONCartTestQuantity6() throws  Exception {
        product2.setQuantityOfProductsOnCart(5);
        productList.add(product2);
        Assert.assertEquals(6, addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product2)
                .get(0).getQuantityOfProductsOnCart());
    }

    @Test
    public void getQuantityOfProducOnCardTestwithEmptyList() throws Exception {
        Assert.assertEquals(0, addProductsToCardSeviceSpring.getQuantityOfProducOnCard(productList));
    }

    @Test
    public void getQuantityOfProducOnCardwithEnatherMethod() throws Exception {
        product1.setQuantityOfProductsOnCart(1);
        productList.add(product1);
        Assert.assertEquals(1, addProductsToCardSeviceSpring.getQuantityOfProducOnCard(productList));
    }

    @Test
    public void getQuantityOfProducOnCardTest2_GetListOnproductOnCardMethod() throws Exception {
        productList =  addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product2);
        productList =  addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product2);
        productList = addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product1);
        productList = addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product2);
        Assert.assertEquals(4, addProductsToCardSeviceSpring.getQuantityOfProducOnCard(productList));
    }

    @Test
    public void getTotalPriceOfProductsOnCart() throws Exception {

        Assert.assertEquals("0 $", addProductsToCardSeviceSpring.getTotalPriceOfProductsOnCart(productList));
    }

    @Test
    public void getTotalPriceOfProductsOnCartwithGetListOnProductOnCartMethod() throws Exception {
        product1.setPrice(1);
        productList.add(product1);
        productList = addProductsToCardSeviceSpring.getListOgProductsOnCart(productList, product1);
        Assert.assertEquals("1 $", addProductsToCardSeviceSpring.getTotalPriceOfProductsOnCart(productList));
    }

}
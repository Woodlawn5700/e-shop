package service;

import DAO.implementation.ProductDaoImplSpring;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tables.Params;
import tables.Product;
import tables.TablesNames;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * ProductListServiceSpring Test class
 * Created by pavelpetrov on 20.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductListServiceSpringTest {


    private ProductListServiceSpring productListServiceSpring;

    @Mock
    ProductDaoImplSpring productDao;

    @Before
    public void setUp() throws Exception {
        productListServiceSpring = new ProductListServiceSpring(productDao);
        Product product1 = new Product("prodcut1", 1, "Product1", 20);
        Product product2 = new Product("prodcut2", 2, "Product2", 21);
        ;
        product1.setQuantityOfProductsOnCart(20);

        product2.setQuantityOfProductsOnCart(21);
        Params params = new Params();
        params.setBrand("1");
        params.setColor("1");
        params.setPower(1);
        product1.setParametr(params);
        product2.setParametr(params);
        List<Product> productList = new ArrayList<>();
        List<String> brands = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        brands.add(product1.getParametr().getBrand());
        brands.add(product2.getParametr().getBrand());
        when(productDao.getAllObjectsFromTable(TablesNames.PRODUCT)).thenReturn(productList);
        when(productDao.getUniqueListObjectFromJoinAnotherTable(TablesNames.PRODUCT, "parametr", "brand")).thenReturn(brands);

    }

    @Test
    public void testMockCreation() {
        assertNotNull(productDao);
    }

    @Test
    public void getAllProducts_NotNull() throws Exception {
        assertNotNull(productListServiceSpring.getAllProducts());
    }

    @Test
    public void getAllProductsTest() throws Exception {
        Product product1 = new Product("prodcut1", 1, "Product1", 20);
        Product product2 = new Product("prodcut2", 2, "Product2", 21);
        List<Product> productList = new ArrayList<>();
        productList.add(product1);
        productList.add(product2);
        Assert.assertEquals(productList, productListServiceSpring.getAllProducts());
    }

    @Test
    public void getUniqueBrandList() throws Exception {
        assertNotNull(productListServiceSpring.getUniqueBrandList());
    }


}
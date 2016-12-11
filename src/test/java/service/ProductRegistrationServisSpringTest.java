package service;

import DAO.implementation.ParamsDaoSpring;
import DAO.implementation.ProductDaoImplSpring;
import httphendler.HttpResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * ProductRegistrationServisSpring Test class
 * Created by pavelpetrov on 20.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductRegistrationServisSpringTest {

    private ProductRegistrationServisSpring productRegistrationServisSpring;

    @InjectMocks
    HttpResult httpResultcreateProduct;

    /**
     * inject ProductDaoImplSpring spring bean
     */
    @Mock
    ProductDaoImplSpring productDaoImpl;

    /**
     * inject ParamDaoSpring spring bean
     */
    @Mock
    ParamsDaoSpring paramsDaoSpring;


    /**
     * inject Httpresult spring bean
     */
    @InjectMocks
    HttpResult httpResultCreatParam;

    @Before
    public void setUp() throws Exception {
        productRegistrationServisSpring = new ProductRegistrationServisSpring(httpResultcreateProduct,
                httpResultCreatParam, productDaoImpl, paramsDaoSpring);


    }

    @After
    public void tearDown() throws Exception {
        httpResultcreateProduct.setMessage("");


    }


    @Test
    public void checkDigidsText() {
        Assert.assertTrue(productRegistrationServisSpring.checkDigids("123"));
    }

    @Test
    public void checkDigidsText2() {
        Assert.assertFalse(productRegistrationServisSpring.checkDigids("1a3"));
    }

    @Test
    public void checkDigidsText3() {
        Assert.assertFalse(productRegistrationServisSpring.checkDigids("-"));
    }

    @Test
    public void checkDigidsText4() {
        Assert.assertFalse(productRegistrationServisSpring.checkDigids("1."));
    }



}
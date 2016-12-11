package service;

import DAO.implementation.CategoryDaoImlSpring;
import httphendler.HttpResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import tables.Category;
import tables.TablesNames;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * CategoryServiceSpring Test class
 * Created by pavelpetrov on 20.11.16.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceSpringTest {

    private CategoryServiceSpring serviceSpring;
    private List<Category> categoryList;
    private Category category1;
    private Category category2;

    @Mock
    private CategoryDaoImlSpring categoryDao;


    @InjectMocks
    private HttpResult httpResult;


    @Before
    public void setUp() throws Exception {
        serviceSpring = new CategoryServiceSpring(categoryDao, httpResult);
        category1 = new Category();
        category2 = new Category();
        categoryList = new ArrayList<>();
        category1.setCategory("Cat1");
        category2.setCategory("Cat2");
        categoryList.add(category1);
        categoryList.add(category2);
        List<Category> categories = new ArrayList<>();
        categories.add(category1);
        when(categoryDao.getAllObjectsFromeTableWithParamName(TablesNames.CATEGORY, "category", "Cat1")).thenReturn(categories);
        when(categoryDao.getAllObjectsFromTable(TablesNames.CATEGORY)).thenReturn(categoryList);
    }

    @After
    public void tearDown() throws Exception {
        categoryList = new ArrayList<>();
    }

    @Test
    public void testMockCreation() {
        assertNotNull(categoryDao);
    }

    @Test
    public void getCategoryByNameTest1() throws Exception {
        Assert.assertEquals(category1, serviceSpring.getCategoryByName("Cat1"));
    }

    @Test
    public void getCategoryByNameTest2() throws Exception {
        Assert.assertNull(serviceSpring.getCategoryByName("Cat2"));

    }

    @Test
    public void getAllCategories() throws Exception {
        assertNotNull(serviceSpring.getAllCategories());
    }

}
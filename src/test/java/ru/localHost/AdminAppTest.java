package ru.localHost;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

/**
 * auto test MVC with Selenide
 * Created by pavelpetrov on 22.11.16.
 */
public class AdminAppTest {
    private WebDriver driver;

    @Before
    public void DriverSettings() {
        System.setProperty("webdriver.chrome.driver", "/Users/pavelpetrov/Downloads/chromedriver");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @After
    public void coseDriver() {
        driver.quit();
    }


    @Test
    public void adminPagesTest() {
        open("/ProductListServlet");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        open("/LoginUser");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("username")).setValue("Admin");
        $(By.id("password")).setValue("Admin");
        $(By.id("LogButt")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        open("/admin/OrderCreatorListAdmin");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("inStockSort")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("orderStateSort")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("deliveryMethodSort")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        $(By.id("change_2")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("sort")).selectOption("Delivered");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("buttonStateOrder")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        open("/CreateNewCategoryAdminPage");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        $(By.id("createNewCategoryInput")).setValue("Test");
        $(By.id("createNewCategoryBtn")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        open("/admin/CreateCategoryList");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("productNameInput")).setValue("Test");

        $(By.id("sel1")).selectOption("Test");

        $(By.id("quantityProduct")).setValue("Test");

        $(By.id("priceProduct")).setValue("Test");

        $(By.id("brandProduct")).setValue("Test");

        $(By.id("powerProduct")).setValue("Test");

        $(By.id("colorProduct")).setValue("Test");

        $(By.id("weightProduct")).setValue("Test");

        $(By.id("Text1")).setValue("Test");
        $(By.id("productRegistrationButton")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        $(By.id("quantityProduct")).setValue("1");
        $(By.id("priceProduct")).setValue("1");
        $(By.id("productRegistrationButton")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
        $(By.id("powerProduct")).setValue("1");
        $(By.id("weightProduct")).setValue("1");
        $(By.id("productRegistrationButton")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

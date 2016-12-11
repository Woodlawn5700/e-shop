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
 * Created by pavelpetrov on 24.11.16.
 */
public class UserRegistrationTest {
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
    public void userRegistrationTest() {
        open("/ProductListServlet");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        open("/LoginUser");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        $(By.id("registration")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        $(By.id("firstNameClient")).setValue("Pavel");
        $(By.id("secondNameClient")).setValue("Petrov");
        $(By.id("emailClient")).setValue("Pavel124578@mail.ru");
        $(By.id("clientAddressClient")).setValue("SPB");
        $(By.id("passwordClient")).setValue("1409");
        $(By.id("passwordAgainClient")).setValue("1409");

        $(By.id("registrationButton2")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

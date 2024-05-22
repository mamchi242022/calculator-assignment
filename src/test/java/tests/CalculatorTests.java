package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Actions;

public class CalculatorTests {
    WebDriver driver;
    @BeforeMethod
    public void portalsetup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://nuix.github.io/SDET/senior-sdet/productionCalc/index.html");
    }

    @AfterMethod
    public void portalteardown(){
        try{
            driver.close();
            driver.quit();
        }catch(Exception e){

        }

    }
    @Test
    public void test_addition(){
        Actions.enterNumber(driver,7);
        Actions.enterNumber(driver,"+");
        Actions.enterNumber(driver,4);
        Actions.enterNumber(driver,"=");
        Assert.assertEquals(Actions.getResult(driver),(7+4));
    }
    @Test
    public void test_substraction(){
        Actions.enterNumber(driver,6);
        Actions.enterNumber(driver,"-");
        Actions.enterNumber(driver,2);
        Actions.enterNumber(driver,"=");
        Assert.assertEquals(Actions.getResult(driver),(6-2));
    }
    @Test
    public void test_multiplication(){
        Actions.enterNumber(driver,4);
        Actions.enterNumber(driver,"×");
        Actions.enterNumber(driver,3);
        Actions.enterNumber(driver,"=");
        Assert.assertEquals(Actions.getResult(driver),(4*3));
    }

    @Test
    public void test_devide(){
        Actions.enterNumber(driver,8);
        Actions.enterNumber(driver,"÷");
        Actions.enterNumber(driver,2);
        Actions.enterNumber(driver,"=");
        Assert.assertEquals(Actions.getResult(driver),(8/2));
    }

}

package com.aweiz.wiki.UI.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

/**
 * Created by daweizhuang on 5/11/16.
 */
@FixMethodOrder(MethodSorters.JVM)
public class UITestForLogIn {

    static WebDriver driver;
    static Wait<WebDriver> wait;

    @BeforeClass
    public static void LaunchBrowser() {
        System.setProperty("webdriver.chrome.driver","/Users/daweizhuang/workspace/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 3);
    }

    @Test
    public void loginTest(){
        driver.get("http://localhost:8080/");
        boolean result;
        try {
            String displayCss = driver.findElement(By.id("access_wiki_modal_dialog")).getCssValue("display");
            result = "block".equalsIgnoreCase(displayCss);
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        }
        assertTrue(result);
    }

    @Test
    public void inputAccessCodeTest1Wrongly(){
        boolean result;
        try {
            driver.findElement(By.id("access_code")).sendKeys("antra");
            driver.findElement(By.id("save_access_button")).click();
            result = driver.findElement(By.className("alert-danger")).isDisplayed();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        }
        assertTrue(result);
    }

    @Test
    public void inputAccessCodeTest2Correctly(){
        boolean result;
        try {
            driver.findElement(By.id("access_code")).sendKeys("0216");
            driver.findElement(By.id("save_access_button")).click();
            result = driver.findElement(By.className("bs-docs-section")).isDisplayed();
        } catch(Exception e) {
            e.printStackTrace();
            result = false;
        }
        assertTrue(result);
    }


    @AfterClass
    public static void close() {
        driver.close();
    }
}

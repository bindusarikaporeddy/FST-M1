package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity6 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        // Set up the Firefox driver
        //  WebDriverManager.firefox().setup();
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
        // Check the title of the page
        //   String title = driver.getTitle();

        //Print the title of the page
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[contains(text(),'My Account')]")).click();
        Thread.sleep(3000);
        String header = driver.findElement(By.xpath("//h1")).getText();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        driver.findElement(By.id("user_login")).sendKeys("root");
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).submit();
        Thread.sleep(3000);
         String yourSection = driver.findElement(By.xpath("//h3[contains(text(),'Your Courses')]")).getText();
        WebElement ele = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        System.out.println("Page header is: " + header);
        String actual = "My Account";
        String actual1 = "Your Courses";

        //Assertion for page title
        Assert.assertEquals("My Account – Alchemy LMS", title);
        Assert.assertEquals(actual.trim(), header.trim(),"Header title is valid");
        //    Assert.assertEquals(actual1.trim(), yourSection.trim(),"Your courses section is visible");
        Assert.assertTrue(ele.isDisplayed(),"Logout button is visible");
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

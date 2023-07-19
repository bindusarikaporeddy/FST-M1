package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class activity2 {
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
    public void exampleTestCase() {
        // Check the title of the page
     //   String title = driver.getTitle();

        //Print the title of the page

        String header = driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Page title is: " + header);
        String actual = "Learn from Industry Experts";

        //Assertion for page title
        Assert.assertEquals(actual.trim(), header.trim());
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }

}

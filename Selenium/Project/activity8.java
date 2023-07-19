package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class activity8 {
    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new FirefoxDriver();

        //Open browser
        driver.get("https://alchemy.hguy.co/lms/");
    }

    @Test
    public void exampleTestCase() throws InterruptedException {
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
        driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
        Thread.sleep(3000);
        String section = driver.findElement(By.xpath("//h2[contains(text(),'Send')]")).getText();
        driver.findElement(By.id("wpforms-8-field_0")).sendKeys("admin");
        driver.findElement(By.id("wpforms-8-field_1")).sendKeys("admin@gmail.com");
        driver.findElement(By.id("wpforms-8-field_3")).sendKeys("subject");
        driver.findElement(By.id("wpforms-8-field_2")).sendKeys("Comment section");
        driver.findElement(By.id("wpforms-submit-8")).click();
        String submitMsg = driver.findElement(By.xpath("//p[contains(text(),'Thanks for')]")).getText();
        // String count = driver.findElement(By)
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
        System.out.println("Page header is: " + header);
        System.out.println("Message section header is : " + section);
        System.out.println("Message successful is : " + submitMsg);

        Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.",submitMsg);
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }
}

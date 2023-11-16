package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FlightBookingTest {
    private WebDriver driver;
    private FlightBookingPage flightBookingPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\svvibhu\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
       // driver.get("https://www.makemytrip.com/");
         driver.get("https://www.makemytrip.com/hotels/");

        flightBookingPage = new FlightBookingPage(driver);
    }

    @Test
    public void loginWithEmailTest() {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        // Wait for any overlay or advertisement to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class, 'your-advertisement-class')]")));
        By locator = By.id("webklipper-publisher-widget-container-notification-frame");

        wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame")).click();
        // Click on the login link/button
        driver.findElement(By.xpath("//a[text()='Login or Create Account']")).click();

        // Locate the email field and enter the email ID
        driver.findElement(By.id("suvarna")).sendKeys("suvarnavibhute1995@gmail.com");

        // Locate and click the login button
        driver.findElement(By.id("loginBtn")).click();

        // Add assertions or validation steps after login if required

        // For example, you can check if the login was successful by verifying elements on the next page.

        // Example assertion to verify if the user is logged in successfully
        // assert driver.findElement(By.xpath("//span[text()='Welcome, Your Name']")).isDisplayed();

        // You can add further test steps or assertions based on your test scenario

        // For now, let's just wait for 5 seconds before quitting the browser
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            //driver.quit();
        }
    }
}

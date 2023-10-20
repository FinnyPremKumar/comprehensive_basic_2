package Techademy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question5_1 {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ec65f\\OneDrive\\Documents\\Assignment\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.automationanywhere.com/");
        // Add a wait or sleep here if needed
        // e.g., Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
    }

    @Test(priority = 1, enabled = true, timeOut = 10000)
    public void testAutomationAnywhereLogo() {
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        if (logo.isDisplayed()) {
            System.out.println("Automation Anywhere logo is present.");
        } else {
            System.out.println("Automation Anywhere logo is not present.");
        }
    }

    @Test(priority = 2, enabled = true, timeOut = 10000)
    public void testRequestDemoButton() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");
        // Add a wait or sleep here if needed
        // e.g., Thread.sleep(2000);
        WebElement requestDemoButton = driver.findElement(By.xpath("//*[@id=\"topNavbar\"]/div/div/div[1]/div[2]/a"));
        if (requestDemoButton.isDisplayed()) {
            System.out.println("Request demo button is present.");

            if (requestDemoButton.isEnabled()) {
                System.out.println("Request demo button is clickable.");

            } else {
                System.out.println("Request demo button is not clickable.");
            }
        } else {
            System.out.println("Request demo button is not present.");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

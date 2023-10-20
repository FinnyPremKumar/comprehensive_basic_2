package Techademy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Question5_2 {

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
    public void testProductsLink() {
        verifyAndClickLink("Products");
    }

    @Test(priority = 2, enabled = false, timeOut = 5000)
    public void testSolutionsLink() {
        verifyAndClickLink("Solutions");
    }

    @Test(priority = 3, enabled = true, timeOut = 8000)
    public void testResourcesLink() {
        verifyAndClickLink("Resources");
    }

    @Test(priority = 4, enabled = true, timeOut = 7000)
    public void testBeyondRPALink() {
        verifyAndClickLink("Beyond RPA");
    }

    @Test(priority = 5, enabled = true, timeOut = 6000)
    public void testCompanyLink() {
        verifyAndClickLink("Company");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    private void verifyAndClickLink(String linkText) {
        WebElement link = driver.findElement(By.xpath("//a[text()='" + linkText + "']"));

        if (link.isDisplayed()) {
            System.out.println(linkText + " link is present.");
            link.click();
            System.out.println("Navigated to: " + driver.getTitle());
        } else {
            System.out.println(linkText + " link is not present.");
        }
        // Commenting out the navigate back for the demonstration
        // driver.navigate().back();
    }
}

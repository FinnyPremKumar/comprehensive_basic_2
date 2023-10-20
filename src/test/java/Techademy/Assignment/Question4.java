package Techademy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Question4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ec65f\\\\OneDrive\\\\Documents\\\\Assignment\\\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.automationanywhere.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        verifyAndClickLink(driver, "Products");
        verifyAndClickLink(driver, "Solutions");
        verifyAndClickLink(driver, "Resources");
        verifyAndClickLink(driver, "Beyond RPA");
        verifyAndClickLink(driver, "Company");

        driver.quit();
    }

    private static void verifyAndClickLink(WebDriver driver, String linkText) {
        WebElement link = driver.findElement(By.xpath("//a[text()='" + linkText + "']"));

        if (link.isDisplayed()) {
            System.out.println(linkText + " link is present.");

            link.click();

            System.out.println("Navigated to: " + driver.getTitle());

        } else {
            System.out.println(linkText + " link is not present.");
        }

        driver.navigate().back();
    }
}


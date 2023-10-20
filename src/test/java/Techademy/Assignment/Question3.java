package Techademy.Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Question3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ec65f\\OneDrive\\Documents\\Assignment\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.automationanywhere.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("onetrust-accept-btn-handler")).click();
        WebElement logo = driver.findElement(By.xpath("//img[@alt='Automation Anywhere']"));
        if (logo.isDisplayed()) {
            System.out.println("Automation Anywhere logo is present.");
        } else {
            System.out.println("Automation Anywhere logo is not present.");
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)");
        Thread.sleep(2000);
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
        driver.quit();
    }
}

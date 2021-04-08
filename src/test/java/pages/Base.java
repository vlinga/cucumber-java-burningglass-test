package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    public static WebDriver driver;
    public static Properties prop;
    public static WebElement element;
    protected WebDriverWait wait;
    private String lastWinHandle;

    public Base() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream((
                    "src/main/config.properties"));
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    public static void closeBrowser() {
        driver.close();
    }

    public void Visit(String url) {
        driver.get(url);
    }

    public void SendText(By by_locator, String text) {
        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).sendKeys(text);
    }

    public void click(By by_locator) {
        wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).click();
    }

    public void hoverOverElement(By by_locator) {
        wait = new WebDriverWait(driver, 100);
        System.out.println("xpath is in mousehover " + by_locator);
        Actions action = new Actions(driver);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
        action.moveToElement(element).perform();
    }

    /**
     * Method to switch to new window
     */
    public void switchToNewWindow() {
        wait = new WebDriverWait(driver, 100);
        for (String winHandle : driver.getWindowHandles())
        lastWinHandle = winHandle;
        driver.switchTo().window(lastWinHandle);
    }

    public void getTitle(By by_locator)  {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
        if (webElement.isDisplayed()) {
            System.out.println("****** image title is ***** " + webElement.getAttribute("alt"));

        } else {
            System.out.println("******No image displayed is***** ");
        }
    }
}



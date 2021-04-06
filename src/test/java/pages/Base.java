package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Base {
	public ExtentReports rep = null;
	public ExtentTest test = null;
    public static WebDriver browser;
    public static Properties prop;
    public static WebElement element;
	protected WebDriverWait wait ;

	
	/*
	 * @BeforeMethod public void init(ITestResult result) {
	 * System.out.println("Before method"); rep = ExtentManager.getReports(); test =
	 * rep.createTest(result.getMethod().getMethodName().toUpperCase()); }
	 * 
	 * @AfterMethod public void quit() { System.out.println("After method");
	 * rep.flush(); }
	 */
	
		/*
		 * @Before public void before(Scenario s) {
		 * System.out.println("***Bef*** "+s.getName()); con.initReports(s.getName()); }
		 * 
		 * @After public void after() { System.out.println("***Aft***"); con.quit(); }
		 */
	
	 
	
	public void log(String msg) {
		test.log(Status.INFO, msg);
	}
	
    public Base() {
        try{
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


    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equals("chrome")){
          //  browser = new ChromeDriver();
        	//Create a instance of ChromeOptions class
        	ChromeOptions options = new ChromeOptions();

        	//Add chrome switch to disable notification - "**--disable-notifications**"
        	options.addArguments("--disable-notifications");

        	//Set path for driver exe 
        	//System.setProperty("webdriver.chrome.driver","path/to/driver/exe");

        	//Pass ChromeOptions instance to ChromeDriver Constructor
        	 browser =new ChromeDriver(options);
        }else if(browserName.equals("firefox")){
            browser = new FirefoxDriver();
            browser.manage().window().maximize();
        }
//        browser.manage().window().maximize();
//        browser.manage().deleteAllCookies();
//        browser.get(prop.getProperty("url"));
    }

    public static void closeBrowser(){
        browser.quit();
    }

    public void Visit(String url){
        browser.get(url);
    }

    public WebElement GetElement(By by_locator, int waitfor){
        WebDriverWait wait = new WebDriverWait(browser, waitfor);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
    }


    public List<WebElement> GetElements(By by_locator, int waitfor){
        WebDriverWait wait = new WebDriverWait(browser, waitfor);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by_locator));
    }

    public void SendText(By by_locator, String text){
        WebDriverWait wait = new WebDriverWait(browser, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).sendKeys(text);
    }

    public void Click(By by_locator){
    	System.out.println("xpath is " + by_locator);
        WebDriverWait wait = new WebDriverWait(browser, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).click();
    }

    public void DeleteByIndex(int index){
        String locator = "/html/body/div[2]/div/ul/li["+index+"]/a";
        By by_locator = By.xpath(locator);
        Click(by_locator);
    }

    public void ClickProductByIndex(int index){
        String locator = "/html/body/div[2]/div/ul/li["+index+"]/span/a";
        By by_locator = By.xpath(locator);
        Click(by_locator);
    }
    
    public void hoverOverElement(By by_locator)
	{    	System.out.println("xpath is in mousehover " + by_locator);

    	wait =  new WebDriverWait(browser, 50);
		Actions action = new Actions(browser);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
		action.moveToElement(element).perform();
	}
    
    
    public void scrolldown() {
    	JavascriptExecutor js = (JavascriptExecutor)browser;

		/*
		 * ((JavascriptExecutor) browser)
		 * .executeScript("window.scrollTo(0, document.body.scrollHeight)");
		 */
    	js.executeScript("scroll(589, 558)");

    }
	public By getelementbytype(String type,String access_name)
	{
		switch(type)
		{
			case "id" : return By.id(access_name);
			case "name" : return By.name(access_name);
			case "class" : return By.className(access_name);
			case "xpath" : return By.xpath(access_name);
			case "css" : return By.cssSelector(access_name);
			case "linkText" : return By.linkText(access_name);
			case "partialLinkText" : return By.partialLinkText(access_name);
			case "tagName" : return By.tagName(access_name);
		default : return null;
						
		}
	}
	public void select(By by_locator) throws Throwable {


		WebDriverWait wait = new WebDriverWait(browser, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).click();
	}
   
	public void Allnewnextpage(String Allnewnextpagestart , String Allnewnextpageend) {
		String xpath_start = Allnewnextpagestart;
		String xpath_end = Allnewnextpageend;
		for (int i=1; i< 5; i++) {
			By by_locator1 = By.xpath(Allnewnextpagestart + i + Allnewnextpageend);
			//By locator = By.xpath("//*[@id=\"category-root\"]/div[2]/div[2]/div[2]/div/div/div/li[2]/a");
		    WebDriverWait wait = new WebDriverWait(browser, 100);
		    
		    System.out.println("by_locator1 :: "+by_locator1);
		 //   JavascriptExecutor js =(JavascriptExecutor)browser;
	       // js.executeScript("window.scrollTo(0,"+element.getLocation().y+")");
		
	        boolean result = false;
	        int attempts = 0;
	        while(attempts < 4) {
	            try {
	            	browser.manage().window().maximize() ;
	            	//WebElement element = browser.findElement(by_locator1);
	            	WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator1));
	            	JavascriptExecutor executor = (JavascriptExecutor)browser;
	            	executor.executeScript("arguments[0].click()", element);
	    	       //  wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
	    	      // .click();		
	    	      //  WebElement button = browser.findElement(locator);
	             //   button.click();
	
	                result = true;
	                break;
	            } catch(NoSuchElementException e) {
	            	
	            	System.out.println("There are no pages to click ");
	            	
	            }
	            attempts++;
	        }
	        
	}
	}
	}


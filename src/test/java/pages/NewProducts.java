package pages;

import java.util.List;

import org.openqa.selenium.*;

public class NewProducts extends Base {
    By product = By.xpath("//*[@id=\\\"nav\\\"]/li[1]/a/span");
    By bt_login = By.xpath("//*[@id=\"continue\"]");
    By bt_product = By.xpath("//*[@id=\"nav\"]/li[1]/a/span");
    By clothing = By.xpath("//*[@id=\"nav\"]/li[2]");
    By dresses = By.xpath("//*[@id=\"nav\"]/li[3]");

    By product_names = By.xpath("//*[@id=\"nav\"]/li[1]");
    By AllNew = By.xpath("//*[@id=\"nav\"]/li[1]/div/div[1]/div/div[1]/ul/li[1]/a");
    By allclothing = By.xpath("//*[@id=\"nav\"]/li[2]/div/div[1]/div/ul/li[1]/a");
    By alldress = By.xpath("//*[@id=\"nav\"]/li[3]/div/div[1]/div/ul/li[1]/a");
    By productnamestart = By.xpath("\t//*[@id=\"card-");
    By productnameend = By.xpath("]/div/li[2]/a");
    By searchbox = By.xpath("\t/html/body/div[1]/div/header/div[2]/div[1]/div/div/div/div[2]/input");
    By Allnewnextpagestart = By.xpath("//*[@id=\"category-root\"]/div[1]/div[");
    By Allnewnextpageend = By.xpath("\"]/div[3]/div/div/a");
    By colourname = By.xpath("//*[@id=\"filter-container\"]/div/div[1]/div[2]/div/ul/li[1]/div/div");
    By by_locator_multi = By.xpath("//*[@id=\"filter-container\"]/div/div[1]/div[2]/div/ul/li[1]/span");
    By by_locator_black = By.xpath("//*[@id=\"filter-container\"]/div/div[1]/div[2]/div/ul/li[2]/span");
    By by_locator_blue = By.xpath("//*[@id=\"filter-container\"]/div/div[1]/div[2]/div/ul/li[3]/span");


    By blackname = By.xpath("//*[@id=\"filter-container\"]/div/div[1]/div[2]/div/ul/li[2]/div/div");
    By bluename = By.xpath("//*[@id=\"filter-container\"]/div/div[1]/div[2]/div/ul/li[3]/div/div");

    private static String[] links = null;
    private static int linksCount = 0;

    public void product() {
        super.Click(product);
    }

    public void AllNew(String submodel) {
        System.out.println("mouse hover page" + submodel);

        if (submodel.equalsIgnoreCase("allnew")) {
            super.Click(AllNew);
        } else if (submodel.equalsIgnoreCase("allclothing")) {
            super.Click(allclothing);

        } else if (submodel.equalsIgnoreCase("alldress")) {
            super.Click(alldress);

        }
    }

    public void moveHover(String model) {
        System.out.println("mouse hover page" + model);
        if (model.equalsIgnoreCase("first")) {
            super.hoverOverElement(bt_product);
        } else if (model.equalsIgnoreCase("clothing")) {
            super.hoverOverElement(clothing);

        } else if (model.equalsIgnoreCase("dress")) {
            super.hoverOverElement(dresses);

        }
    }


    public void InspectProduct() {

        List<WebElement> products = browser.findElements(By.tagName("a"));
        linksCount = products.size();
        System.out.println("Total no of links Available: " + linksCount);
        links = new String[linksCount];
        System.out.println("List of links Available: ");
        // print all the links from webpage
        for (int i = 0; i < linksCount; i++) {
            links[i] = products.get(i).getAttribute("href");
            System.out.println(products.get(i).getAttribute("href"));
        }
        // navigate to each Link on the webpage
        for (int i = 0; i < linksCount; i++) {
            browser.navigate().to(links[i]);
        }

        for (int i = 0; i < products.size(); i++) {
            String name = products.get(i).getText();
            if (name.equals(products)) {
                ClickProductByIndex(i + 1);
            } else {
                System.out.println("No link present");

            }
        }

    }

    public void select(String colours) throws Throwable {


        if (colours.equalsIgnoreCase("Multi")) {
            super.select(colourname);
        } else if (colours.equalsIgnoreCase("Black")) {
            super.select(blackname);
        } else if (colours.equalsIgnoreCase("Blue")) {
            super.select(bluename);

        }
    }

    public String totalCount(String colours) throws Throwable {
        String count = "";
        count = super.coloursCount(by_locator_multi);
        return count;
    }

}
	


package pages;

import org.openqa.selenium.By;

public class Login extends Base {

    By usernamePath = By.name("_username");
    By passwordPath = By.name("_password");
    By bt_login = By.xpath("//*[@id=\"header\"]/div/div[2]/div[2]/strong/a");
    By signin = By.xpath("//*[@id=\"tab-login-form\"]/div/div[1]/form/p[1]/button/span");
    By loggedin_path = By.xpath("//*[@id=\"js-user-details\"]/div/a");
    By logout_path = By.xpath("//*[@id=\"js-user-details\"]/div/ul/li[7]/a");
    By polawebsite_xpath = By.xpath("//*[@id=\"content\"]/div/div[1]/div[3]/div/div[3]/a");
    By polaimage_xpath = By.xpath("/html/body/div[1]/section[1]/div/h1/picture/img");
    By inspiring_xpath = By.xpath("//*[@id=\"block-sotd\"]/div/div[2]/ul/li[1]/div/figure/a/div/img");

    public void getImageTitle() {
        super.getTitle(inspiring_xpath);
    }

    public void launchwebsite() {
        super.Visit("https://www.awwwards.com/");
    }

    public void SetUser(String username) {
        super.SendText(usernamePath, username);
    }

    public void SetPassword(String password) {
        super.SendText(passwordPath, password);
    }

    public void ClickLogin() {
        super.click(bt_login);
    }

    public void Signin() {
        super.click(signin);
    }

    public void polawebsite() {
        super.click(polawebsite_xpath);
    }

    public void switchtonewwindow() {
        super.switchToNewWindow();
    }

    public void getTitle() {
        super.getTitle(polaimage_xpath);
    }

    public void logout(String userloggedin) {
        if (userloggedin.toUpperCase().contains("VENUISTQB")) {
            super.hoverOverElement(loggedin_path);
            super.click(logout_path);
        } else {
            System.out.println("User Not logged in ");
        }
    }
}
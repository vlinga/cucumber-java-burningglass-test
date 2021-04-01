package pages;

import org.openqa.selenium.By;

public class Login extends Base {

    By username = By.xpath("//*[@id=\"ap_email\"]");
    By password = By.xpath("//*[@id=\"ap_password\"]");
    By bt_login = By.xpath("//*[@id=\"continue\"]");
    By signin = By.xpath("//*[@id=\"signInSubmit\"]");
    By toast = By.xpath("//*[@id=\"nav-signin-tooltip\"]/a/span");



    public void LaunchLoginPage(){
        super.Visit("https://www.inthestyle.com/");
    }

    public void SetUser(String user){
        super.SendText(username, user);
    }

    public void SetPassword(String pwd){
        super.SendText(password, pwd);
    }

    public void ClickLogin(){
        super.Click(bt_login);
    }
    public void Signin(){
        super.Click(signin);
    }

    public boolean IsToast(){
        boolean isElement = false;
        if(super.GetElement(toast, 10) != null){
            isElement = true;
        }
        return isElement;
    }
}

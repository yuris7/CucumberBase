package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
//   base.Driver.findElement(By.name("UserName")).sendKeys(user.username); //"admin"
//   base.Driver.findElement(By.name("Password")).sendKeys(user.password); //"adminpassw"
/**
 * Created by yurii.voina on 3/16/2017.
 */
public class LoginPage {

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  @FindBy(how = How.NAME, using = "UserName")
  public WebElement txtUserName;

  @FindBy(how = How.NAME, using = "Password")
  public WebElement txtPassword;

  @FindBy(how = How.NAME, using = "Login")
  public WebElement btnLogin;


  public void Login(String username, String password){
    txtUserName.sendKeys(username);
    txtPassword.sendKeys(password);
  }
  public void ClickLogin(){
    btnLogin.submit();
  }
}

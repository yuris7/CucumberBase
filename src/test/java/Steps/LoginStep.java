package Steps;

import Base.BaseUtil;
import Transformation.EmailTransform;
import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.LoginPage;
import java.util.ArrayList;
import java.util.List;

public class LoginStep extends BaseUtil{

  private BaseUtil base;

  public LoginStep(BaseUtil base) {
    this.base = base;
  }
  @Given("^I navigate to the login page$")
  public void iNavigateToTheLoginPageApplicaton() {
    System.out.println("Navigate login page");
    base.Driver.navigate().to("http://executeautomation.com/demosite/Login.html");
  }

  @And("^I click login button$")
  public void iClickLoginButton() throws Throwable {
    LoginPage page = new LoginPage(base.Driver);
    page.ClickLogin();
  }

  @Then("^I should see the userform page$")
  public void iShouldTheUsernameAsAdminAndPasswordAsAdmin() throws Throwable {
   Assert.assertEquals(base.Driver.findElement(By.id("Initial")).isDisplayed(),true);
  }

  @And("^I enter username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
  public void iEnterUsernameAsAndPasswordAs(String username, String password) throws Throwable {

  }
  @And("^I enter the following for Login$")
  public void iEnterTheFollowingForLogin(DataTable table) throws Throwable {
    List<User> users = new ArrayList<User>();
    users = table.asList(User.class);
    LoginPage page = new LoginPage(base.Driver);
    for (User user : users){
      page.Login(user.username,user.password);
    }
  }
  @And("^I enter([^\"]*) and ([^\"]*)$")
  public void iEnterUsernameAndPassword(String username, String password) throws Throwable {
  }

  @And("^I enter the users email address as Email:([^\"]*)$")
  public void iEnterTheUsersEmailAddressAsEmailAdmin(@Transform(EmailTransform.class) String email) throws Throwable {

  }
  public class User{
      public String username;
      public String password;

    public User(String userName, String passWord) {
      username = userName;
      password = passWord;

    }
  }
}

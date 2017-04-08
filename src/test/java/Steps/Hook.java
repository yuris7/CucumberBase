package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by yurii.voina on 3/15/2017.
 */
public class Hook extends BaseUtil{

  private BaseUtil base;

  public Hook(BaseUtil base) {
    this.base = base;
  }

  @Before
  public void initialiseTest(){

    System.out.println("Opening the Browser : Chrome");
    System.setProperty("webdriver.chrome.driver", "C:\\github\\CucumberBase\\src\\test\\java\\Steps\\chromedriver.exe");
    base.Driver = new ChromeDriver();
  }

  @After
  public void tearDownTest(Scenario scenario){

    if(scenario.isFailed()){
      //Take screenshot)
      System.out.println(scenario.getName());
    }




  }

}

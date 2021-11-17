package StepDefinations;


import Pages.Page1;
import Pages.Page2;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Steps_Of_Test extends PageObject {
    WebDriver driver;

    @Steps
    Page1 p1;
    @Steps
    Page2 p2;


    @Before
    public void Setup(){
        driver= new ChromeDriver();
    }
    @Given("Open the booking site")
    public void openBrowser(){
        p1.open_url();
    }

    @When("^I Search for (.*) in search Box$")
    public void i_search_for_manali_in_search_box(String loc) throws InterruptedException {
        p1.enter_txt(loc);
        p1.set_date();
        p1.Search_Btn();
    }

    @Then("^Show me the result (.*)$")
    public void show_me_the_result_result(int expectedResults) throws InterruptedException {
        int y=p2.second_page();
        Assert.assertEquals(y, expectedResults);
    }

    @After
    public void Close(){
        driver.quit();
    }





}

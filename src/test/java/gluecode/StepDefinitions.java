package gluecode;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class StepDefinitions {
    private WebDriver driver=Hooks.driver;
    private String subtotalValueStr;
    private int subtotalValue;
    ExtentReports extent= new ExtentReports();
    ExtentTest feature;
    ExtentTest scenarioTest;


    @Given("Open the Browser using this url {string}")
    public void open_the_browser_using_this_url(String url) throws ClassNotFoundException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(url);
        driver.manage().window().maximize();

    }
    @When("I click in the search bar")
    public void i_click_in_the_search_bar() {

        driver.findElement(By.id("twotabsearchtextbox")).click();

    }

    @When("I search for {string}")
    public void i_search_for(String keys) {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keys);
        driver.findElement(By.id("nav-search-submit-button")).click();

    }
    @When("I scroll down until a find the text {string}")
    public void i_scroll_down_until_a_find_the_text(String param) {
        WebElement element = driver.findElement(By.xpath("//span[contains(text(),'"+param+"')][@class='a-size-base-plus a-color-base a-text-normal']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
    @When("I scroll down until a find the text on subtotalPage")
    public void i_scroll_down_until_a_find_the_text_on_subotalpage() {
        WebElement element = driver.findElement(By.id("sc-subtotal-label-activecart"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

    }
    @When("I click to the button add to cart")
    public void i_click_to_the_button_add_to_cart() {
        driver.findElement(By.id("add-to-cart-button")).click();

    }
    @When("I click dont add protection")
    public void i_click_dont_add_protection() {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        driver.findElement(By.id("attachSiAddCoverage")).click();

    }

    @Given("I click on cart")
    public void i_click_on_cart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("nav-cart-count-container")).click();
    }
    @When("I save the value of subtotal")
    public void i_save_the_value_of_subtotal() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        subtotalValueStr = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
        subtotalValueStr=subtotalValueStr.replaceAll("[$, ]","");
        int min =subtotalValueStr.length()-4;
        int max = subtotalValueStr.length()-3;
        subtotalValueStr=subtotalValueStr.substring(min,max);
        subtotalValue=Integer.valueOf(subtotalValueStr);
    }
    @Then("I expect to be greater than {int}")
    public void i_expect_to_be_greater_than(Integer int1) {
        Assert.assertTrue("It's not greater than this value",subtotalValue<int1);
    }
    @Then("I expect to be less than {int}")
    public void i_expect_to_be_less_than(Integer int1) {
        Assert.assertTrue("It's more bigger than this value",subtotalValue>int1);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.close();
    }

}

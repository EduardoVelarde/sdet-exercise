package gluecode;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class Hooks {
    public static WebDriver driver;
    File file = new File("/Users/eduardolopezvelarde/Documents/selenium binding/chromedriver");

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        if(driver==null){
            driver = new ChromeDriver();
        }
    }
}

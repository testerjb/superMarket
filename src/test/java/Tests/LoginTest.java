package Tests;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.BasePage;

public class LoginTest {

    private WebDriver driver;
    final String baseUrl=  "https://www.walmart.co.cr/";
    String welcomeUserName = "Hola, Jilthy";
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
        public void LogInPage()  {
        BasePage basePage = new BasePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //wait page to load
        basePage.isElementPresentBy(homePage.getHomeLogo());
        basePage.elementToBeClickable(homePage.getmenuMyAccountLink()) ;
        //Click "Menu > Mi Cuenta"
        homePage.getmenuMyAccountLink().click();

        //wait page to load
        basePage.isElementPresentBy(loginPage.getLoginPageLoad());
        loginPage.getMailInput().sendKeys("urbanjill1@gmail.com");
        loginPage.getPasswordInput().sendKeys("Questfarmanima6!");

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", loginPage.getClickLoginButton());

        basePage.isElementPresentBy(homePage.getHomeLogo());
        basePage.elementsToBeVisibles(homePage.getWelcomeUser());
        Assert.assertEquals(homePage.getWelcomeUser().getText(),welcomeUserName);  //actual , expected

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}

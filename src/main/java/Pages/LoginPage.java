package Pages;

/*import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
/*import java.util.Arrays;
import java.util.Collection;*/

//@RunWith(Parameterized.class)
public class LoginPage {
    WebDriver driver;
    //String userName, password;

    @FindBy(xpath = "//page-auth2[@class='ion-page']/ion-content[@class='md hydrated']")
    WebElement loginPage;
    @FindBy(xpath = "(//input[@class='native-input sc-ion-input-md'])[1]")
    WebElement eMailInput;
    @FindBy(xpath = "(//input[@class='native-input sc-ion-input-md'])[2]")
    WebElement passwordInput;
    @FindBy(xpath = "//ion-button[@class='ion-margin-vertical ion-color ion-color-primary md button button-block button-solid button-strong ion-activatable ion-focusable hydrated']/span")
    WebElement clickLoginButton;  //Ingresar a tu cuenta

    public WebElement getClickLoginButton(){ return clickLoginButton;}
    public WebElement getPasswordInput() {return passwordInput; }
    public WebElement getMailInput() { return eMailInput; }
    public WebElement getLoginPageLoad() {return loginPage;}


    //constructor
    public LoginPage ( WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
}

//OLD
    /*public void goToLogin() {
        basePage.elementsToBeVisibles(loginPage);
        basePage.elementToBeClickable(eMailInput);
        basePage.sendKeys(eMailInput,userName);
        basePage.elementToBeClickable(passwordInput);
        basePage.sendKeys(passwordInput,password);
        basePage.click(loginButton);
    }
    public LoginPage ( WebDriver driverString ,String userName, String password) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

        this.userName = userName;
        this.password = password;
        this.driver = localDriver;
    }

     @Parameterized.Parameters
     public  Collection<Object[]> paramters() {  //static
        Object[][] runParameter = new Object[1][2];
        runParameter[0][0] = userName; //"urbanjill1@gmail.com";
        runParameter[0][1] = password; //"Questfarmanima6!";
        //TODO coding for Demo User.
        return Arrays.asList(runParameter);
    }
     //constructor
    public LoginPage ( WebDriver driverString ,String userName, String password) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }
 */

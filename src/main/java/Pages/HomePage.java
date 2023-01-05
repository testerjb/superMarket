package Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/* ******************************************************************
 * FALTA DEFINIR TODO **********************************
 *                    **********************************
                      **********************************
 * **********************************/


public class HomePage {
     WebDriver driver;
     BasePage basePage;
     LoginPage logInPage;

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    //public WebElement getLogo(){ return driver.findElement(logo); }
    @FindBy(xpath = "//img[@class='vtex-store-components-3-x-logoImage vtex-render-runtime-8-x-lazyload lazyloaded']")
    private WebElement homeLogo;
    @FindBy(xpath = "//div[@class='flex pv2 items-center']/span[@class='vtex-login-2-x-label t-action--small pl4 gray dn db-l']")
    private static WebElement menuMyAccountLink;
    @FindBy(xpath = "//a[@class='vtex-rich-text-0-x-link vtex-rich-text-0-x-link--mi-tienda']")
    private WebElement menuMyOrders  ;
    @FindBy (xpath = "//p[@class='lh-copy vtex-rich-text-0-x-paragraph vtex-rich-text-0-x-paragraph--mi-tel']/a[@class='vtex-rich-text-0-x-link vtex-rich-text-0-x-link--mi-tel']")
    private WebElement menuMyList;
    @FindBy(xpath = "//div[@class='vtex-button__label flex items-center justify-center h-100 ph6']/span[@class='flex items-center nr2']/div[2]")
    private WebElement selectMyStore;
    @FindBy(xpath = "//span[@class='vtex-login-2-x-profile truncate t-action--small order-1 pl4 gray dn db-l']")
    private WebElement welcomeUser;

    //logged in account purchases
    @FindBy(xpath ="//input[@id='downshift-0-input']")
    private WebElement searchBar;
    @FindBy(xpath ="//div[@class='vtex-store-components-3-x-suffixWrapper vtex-store-components-3-x-suffixWrapper--search-mobile-walmart flex h-100']")
    private WebElement searchLoop;
    @FindBy(xpath = "//div[@class='walmartcr-walmart-components-0-x-buttonDataContainer flex justify-center']/span[@class='walmartcr-walmart-components-0-x-buttonText']")
    private WebElement addToCartButton;

    @FindBy(xpath = "(//span[@class='vtex-product-summary-2-x-productBrand vtex-product-summary-2-x-brandName t-body'])[1]")
    private WebElement productAddedName;

    //Go to Menu > My account
    public WebElement getmenuMyAccountLink() { return menuMyAccountLink; }
    public WebElement getHomeLogo() { return homeLogo; }
    public WebElement getWelcomeUser() { return welcomeUser; }

    //user shopping
    public WebElement getSearchBar() { return searchBar;}
    public WebElement getSearchLoop() { return searchLoop;}
    public WebElement getAddToCartButton() { return addToCartButton;}
    public WebElement getProductAddedName() { return productAddedName;}
   /*public boolean verifyAllElementsLoad()
        return basePage.elementsToBeVisibles(homeLogo) &&  basePage.elementsToBeVisibles(menuMyAccountLogin)
                && basePage.elementsToBeVisibles(menuMyOrders) && basePage.elementsToBeVisibles(menuMyList);
    }*/
}

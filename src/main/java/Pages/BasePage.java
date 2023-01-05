package Pages;
/* *************************************************************************
 * We define here default explicit wait and actions like sendkeys, click etc
 **************************************************************************/

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public boolean click (WebElement wElement) {
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable(wElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean sendKeys (WebElement wElement, String text) {
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable(wElement));
            waitElem.sendKeys(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clearElement (WebElement wElement) {
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable(wElement));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getText (WebElement wElement) {
        WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.visibilityOf(wElement));
        return waitElem.getText();
    }

    //Select a dropdown
    public String selectDropdown(WebElement wElement, String objetoSel) {
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOf(wElement));
            Select dropdown = new Select(wElement);
            dropdown.selectByVisibleText(objetoSel);
        } catch (Exception e) {
            throw new RuntimeException("Option '" + objetoSel +"' not found in the dropdown");
        }
        return objetoSel;
    }

    public boolean isElementPresentBy(WebElement wElement) {
        boolean isVisible = false; //added 2022
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOf(wElement));
            isVisible = true;
        } catch (Exception e) {
            System.out.println("Test - WebElement not found ");
            return false;
        }
        return isVisible;
    }

    public boolean elementToBeClickable(WebElement wElement) {
        boolean isCliqueable = false;
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.elementToBeClickable(wElement));
            isCliqueable = true;
        } catch(Exception e) {
            throw new RuntimeException("Test - Element not available");
        }
        return isCliqueable;
    }

    public boolean elementsToBeVisibles(By byElement) {
        boolean isVisible = false;
        try {
            boolean waitElem2 = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.invisibilityOfElementLocated(byElement));
            isVisible = true;
        } catch (Exception e) {
            throw new RuntimeException("Test - Element not available");
        }
        return isVisible;
    }

    public boolean elementsToBeVisibles(WebElement wElement) {
        boolean esVisible = false;
        try {
            WebElement waitElem = new WebDriverWait(driver, Duration.ofSeconds(10)).
                    until(ExpectedConditions.visibilityOf(wElement));
            esVisible = true;
        } catch (Exception e) {
            throw new RuntimeException("Test - Element not available");
        }
        return esVisible;
    }
}

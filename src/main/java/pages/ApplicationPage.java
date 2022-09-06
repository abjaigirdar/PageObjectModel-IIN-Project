package pages;

import browser.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.sql.rowset.BaseRowSet;
import java.util.List;
import java.util.WeakHashMap;

public class ApplicationPage {
    WebDriver driver = Browser.driver;

    @FindBy(id = "edit-submitted-contact-info-firstname") private WebElement firstNameElement;
    @FindBy(id = "edit-submitted-contact-info-lastname") private WebElement lastNameElement;
    @FindBy(id = "edit-submitted-contact-info-email") private WebElement emailElement;
    @FindBy(id = "edit-submitted-contact-info-home-phone-c") private WebElement phoneElement;
    @FindBy(id = "edit-webform-ajax-next-21570") private WebElement nextButton;
    @FindBy(css = "input[placeholder='Address 1*']") private WebElement addressElement;
    @FindBy(id = "edit-submitted-shipping-info-city") private WebElement cityElement;
    @FindBy(id = "edit-submitted-shipping-info-country") private WebElement dropdownArrow;
    @FindBy(id = "edit-submitted-shipping-info-postalcode") private WebElement zipElement;
    @FindBy(id = "edit-webform-ajax-next-21570--2") private WebElement nextButton2;
    @FindBy(id = "edit-submitted-shipping-info-state") private WebElement stateDropdown;
    @FindBy(id = "edit-submitted-additional-info-occupation-c") private WebElement occupationDropdown;
    @FindBy(id = "edit-submitted-additional-info-education-level-c") private WebElement educationDropdown;
    @FindBy(id = "edit-submitted-additional-info-course-c") private WebElement courseDropdown;
    @FindBy(id = "edit-webform-ajax-submit-21570") private WebElement finishButton;

    public ApplicationPage applicationFirstPage(String firstName, String lastName, String email, String phone) {
        firstNameElement.sendKeys(firstName);
        lastNameElement.sendKeys(lastName);
        emailElement.sendKeys(email);
        phoneElement.sendKeys(phone);
        nextButton.click();

        return this;
    }

    public ApplicationPage applicationSecondPage(String address, String city, String country, String state, String zip) {
        addressElement.sendKeys(address);
        cityElement.sendKeys(city);
        dropdownArrow.click();
        List<WebElement> countryList = driver.findElements(By.cssSelector("select[id='edit-submitted-shipping-info-country']>option"));
        for (WebElement countryName : countryList) {
            if (countryName.getText().equalsIgnoreCase(country)) {
                countryName.click();
                break;
            }
        }
        stateDropdown.click();
        List<WebElement> stateList = driver.findElements(By.cssSelector("select[id='edit-submitted-shipping-info-state']>option"));
        for (WebElement stateName : stateList) {
            if (stateName.getText().equalsIgnoreCase(state)) {
                stateName.click();
                break;
            }
        }
        zipElement.sendKeys(zip);
        nextButton2.click();
        return this;
    }

    public AppSubmissionThankyouPage applicationThirdPage(String occupation, String education, String course) {
        occupationDropdown.click();
        List<WebElement> occupationList = driver.findElements(By.cssSelector("select[id='edit-submitted-additional-info-occupation-c']>option"));
        for (WebElement occupationName : occupationList) {
            if (occupationName.getText().equalsIgnoreCase(occupation)) {
                occupationName.click();
                break;
            }
        }
        educationDropdown.click();
        List<WebElement>educationList = driver.findElements(By.cssSelector("select[id='edit-submitted-additional-info-education-level-c']>option"));
        for (WebElement educationName : educationList) {
            if (educationName.getText().equalsIgnoreCase(education)) {
                educationName.click();
                break;
            }
        }
        courseDropdown.click();
        List<WebElement>courseList = driver.findElements(By.cssSelector("select[id='edit-submitted-additional-info-course-c']>option"));
        for (WebElement courseName : courseList) {
            if (courseName.getText().equalsIgnoreCase(course)) {
                courseName.click();
                break;
            }
        }
        finishButton.click();
        return PageFactory.initElements(Browser.driver, AppSubmissionThankyouPage.class);
    }
}

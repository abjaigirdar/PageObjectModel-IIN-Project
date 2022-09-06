package pages;

import browser.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    @FindBy(linkText = "Get Free Sample Class")
    private WebElement getFreeSampleClassButton;
    @FindBy(css = "input[placeholder='First Name*']")
    private WebElement firstName;
    @FindBy(css = "input[placeholder='Your Best Email*']")
    private WebElement emailAddress;
    @FindBy(css = "input[placeholder='Phone']")
    private WebElement phone;
    @FindBy(css = "input[type='submit']")
    private WebElement sendMeMyClassButton;

    public ModulesPage getSampleClass(String name, String email, String phoneNumber) {
        getFreeSampleClassButton.click();
        firstName.sendKeys(name);
        emailAddress.sendKeys(email);
        phone.sendKeys(phoneNumber);
        sendMeMyClassButton.click();

        return PageFactory.initElements(Browser.driver,ModulesPage.class);
    }

}

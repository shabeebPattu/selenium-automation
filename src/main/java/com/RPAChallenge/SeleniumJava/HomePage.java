package com.RPAChallenge.SeleniumJava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//label[text()='Phone Number']/../input[@ng-reflect-name='labelPhone']")
    private WebElement phoneNumber;

    @FindBy(xpath = "//label[text()='Company Name']/../input[@ng-reflect-name='labelCompanyName']")
    private WebElement companyName;

    @FindBy(xpath = "//label[text()='Email']/../input[@ng-reflect-name='labelEmail']")
    private WebElement email;

    @FindBy(xpath = "//label[text()='Last Name']/../input[@ng-reflect-name='labelLastName']")
    private WebElement lastName;

    @FindBy(xpath = "//label[text()='Role in Company']/../input[@ng-reflect-name='labelRole']")
    private WebElement roleInCompany;

    @FindBy(xpath = "//label[text()='Address']/../input[@ng-reflect-name='labelAddress']")
    private WebElement address;

    @FindBy(xpath = "//label[text()='First Name']/../input[@ng-reflect-name='labelFirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//button[text()='Start']")
    private WebElement startButton;

    @FindBy(xpath = "//div[text()='Congratulations!']")
    private WebElement completionText;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    // New locator for success rate
    @FindBy(xpath = "//div[contains(@class,'message2')]")
    private WebElement successRateElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getPhoneNumber() {
        return phoneNumber;
    }

    public WebElement getCompanyName() {
        return companyName;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getRoleInCompany() {
        return roleInCompany;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getStartButton() {
        return startButton;
    }

    public WebElement completionText() {
        return completionText;
    }

    // ===== New methods for success rate =====

    // Get full success rate message from the page
    public String getSuccessRateMessage() {
        return successRateElement.getText();
    }

    // Extract only percentage value from the message
    public String extractPercentage(String message) {
        String percentage = "";
        String[] parts = message.split(" ");
        for (String part : parts) {
            if (part.endsWith("%")) {
                percentage = part;
                break;
            }
        }
        return percentage;
    }
}

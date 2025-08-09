package com.RPAChallenge.SeleniumJava;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomeTest extends Base {

    @Test
    public void automateRPAChallenge() throws InterruptedException, IOException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        HomePage homepage = new HomePage(driver);

        // Read all data from Excel
        String filePath = "./data/challenge.xlsx";
        String sheetName = "Sheet1";
        List<List<String>> data = ExcelUtils.getSheetData(filePath, sheetName);
        
        homepage.getStartButton().click();
        Thread.sleep(1000);

        // Loop through each row (skip header if needed)
        for (int i = 1; i <=10; i++) { // i=1 if first row is header
        	System.out.println(data.size());
            List<String> row = data.get(i);

            WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//label[text()='First Name']/../input[@ng-reflect-name='labelFirstName']")
            ));
            firstName.clear();
            firstName.sendKeys(row.get(0));


            homepage.getLastName().clear();
            homepage.getLastName().sendKeys(row.get(1)); // Last Name
           
            homepage.getAddress().clear();
            homepage.getAddress().sendKeys(row.get(4)); // Address
            
            homepage.getCompanyName().clear();
            homepage.getCompanyName().sendKeys(row.get(2)); // Company Name
           
            homepage.getEmail().clear();
            homepage.getEmail().sendKeys(row.get(5)); // Email
            
            homepage.getPhoneNumber().clear();
            homepage.getPhoneNumber().sendKeys(row.get(6)); // Phone
           
            homepage.getRoleInCompany().clear();
            homepage.getRoleInCompany().sendKeys(row.get(3)); // Role
            
            homepage.getSubmitButton().click();

            Thread.sleep(3000); // Wait before moving to next row
        }

        // Verify completion
        Assert.assertTrue(homepage.completionText().isDisplayed(), "Automation Failed");

        // ===== New success rate validation =====
        String successRateMessage = homepage.getSuccessRateMessage();
        System.out.println("Full Success Rate Message: " + successRateMessage);

        String percentage = homepage.extractPercentage(successRateMessage);
        System.out.println("Extracted Success Percentage: " + percentage);
    }
}

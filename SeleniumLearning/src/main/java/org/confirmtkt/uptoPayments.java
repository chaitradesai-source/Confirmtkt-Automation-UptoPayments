package org.confirmtkt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.confirmtkt.com/rbooking/");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        WebElement searchButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='SEARCH']"))
        );
        searchButton.click();

        WebElement sl1 = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'WL')]"))
        );
        sl1.click();

        WebElement enterNumber = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("mobile-number"))
        );
        enterNumber.click();
        enterNumber.clear();
        enterNumber.sendKeys("0000000000");

        WebElement clickProceed = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='PROCEED']"))
        );
        clickProceed.click();

        WebElement enterOtp = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(":r4:"))
        );
        enterOtp.click();
        enterOtp.clear();
        enterOtp.sendKeys("578946");

        WebElement clickVerify = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='VERIFY']"))
        );
        clickVerify.click();

        Thread.sleep(5000);

        WebElement sl2 = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'WL')]"))
        );
        sl2.click();

        WebElement bookButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[.//div[text()='Book'] and .//span[contains(text(),'₹')]]")
                )
        );
        bookButton.click();

        // ===== CLICK 'grandpa' CHECKBOX =====
        WebElement grandpaCheckboxInput = explicitWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//p[text()='grandpa']/ancestor::label//input[@type='checkbox']")
                )
        );
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].click();", grandpaCheckboxInput);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", grandpaCheckboxInput);

        // Click 'Select Passengers' button
        WebElement selectPassengersButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Select Passengers')]")
                )
        );
        selectPassengersButton.click();

        Thread.sleep(5000);


        WebElement proceedToPayButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Proceed to Pay')]")
                )
        );
        proceedToPayButton.click();
        // driver.quit();

        // Wait 4 seconds before clicking OK
        Thread.sleep(4000);

// Locate and click the OK button
        WebElement okButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'OK')]")
                )
        );
        okButton.click();
    }
}

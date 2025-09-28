package org.confirmtkt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {
        // Set path to chromedriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the ConfirmTkt booking page
        driver.get("https://www.confirmtkt.com/rbooking/");

        // Explicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait for SEARCH button and click
        WebElement searchButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='SEARCH']"))
        );
        searchButton.click();

        // Wait for first WL element and click
        WebElement sl1 = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'WL')]"))
        );
        sl1.click();

        // Enter mobile number
        WebElement enterNumber = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("mobile-number"))
        );
        enterNumber.click();
        enterNumber.clear();
        enterNumber.sendKeys("0000000000");

        // Click PROCEED
        WebElement clickProceed = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='PROCEED']"))
        );
        clickProceed.click();

        // Enter OTP
        WebElement enterOtp = explicitWait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id(":r4:"))
        );
        enterOtp.click();
        enterOtp.clear();
        enterOtp.sendKeys("578946");

        // Click VERIFY
        WebElement clickVerify = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='VERIFY']"))
        );
        clickVerify.click();

        // Small pause to observe result
        Thread.sleep(5000);

        // Click second WL element
        WebElement sl2 = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'WL')]"))
        );
        sl2.click();

        // Click the 'Book' button
        WebElement bookButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[.//div[text()='Book'] and .//span[contains(text(),'₹')]]")
                )
        );
        bookButton.click();

        // Click the <p> element containing "grandpa"
        WebElement grandpaElement = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//p[text()='grandpa']")
                )
        );
        grandpaElement.click();

        // Click 'Select Passengers' button
        WebElement selectPassengersButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Select Passengers')]")
                )
        );
        selectPassengersButton.click();

        // Optional pause to observe final step
        Thread.sleep(5000);

        // Close the browser
        // driver.quit();
    }
}

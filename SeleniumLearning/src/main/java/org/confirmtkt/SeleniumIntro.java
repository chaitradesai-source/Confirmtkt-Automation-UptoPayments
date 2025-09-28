package org.confirmtkt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Chaithra\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // fire fox launch
        // geckoddriver
        // webdriver.gecko.driver

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Chaithra\\Downloads\\geckodriver-v0.36.0-win-aarch64\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();


        driver.get("https://www.confirmtkt.com/rbooking/");

        // check the title of the page
        System.out.println(driver.getTitle());

        // landing on proper page or not
        System.out.println(driver.getCurrentUrl());

        driver.close();
        // closes every associated window
        driver.quit();

        // locators -> to find html elements / components
        //id, xpath, name, classname, tagname, linktext, partial link text

    }
}

// ""

// edge
//System.setProperty("webdriver.edge.driver", "path");
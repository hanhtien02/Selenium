package com.company;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
    static WebDriver obj;

    public static void main(String[] args) {
	    System.out.println("hello my bot");
	    System.setProperty("webdriver.gecko.driver","C:\\Users\\tien\\Documents\\software\\driver\\geckodriver-v0.24.0-win64\\geckodriver.exe");
        obj = new FirefoxDriver();
        //open website
        openWebsite("https://www.wikihow.com");
        verifyTitle("Google");

        // open link
        openLink("Quảng cáo");
        verifyTitle("Facebook - log in or sign up");


        //Wait for 5 Sec
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception has occured when try to open https://translate.google.com/  ");
        }

        obj.close();
        //System.out.println("Close browser affter 5s");

    }
    public static void openWebsite(String url){
        obj.get(url);
    }
    public static void openLink(String linkText){
        obj.findElement(By.linkText(linkText)).click();
    }
    public static void verifyTitle(String expTitle){
        String actualTitle = obj.getTitle();
        System.out.println("this is actual title: " + actualTitle);
        if(expTitle.equals(actualTitle)){
            System.out.println("Title is correct as expected");
        }
        else {
            System.out.println("Oh man ! It failed");
        }
    }
}

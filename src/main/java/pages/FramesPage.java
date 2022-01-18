package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public FramesPage(WebDriver driver) {

        this.driver = driver;
    }
    //Locator for "Frames" button
    By framesBtn = By.id("frame1");

    //Locator for the "iFrame" text
    By iFrame = By.id("sampleHeading");

    //Method to switch to the iFrame and save the text from the iFrame into a string and print it out
    public String switchToIframe() {
        driver.switchTo().frame(driver.findElement(framesBtn));
        String str = driver.findElement(iFrame).getText();
        System.out.println(str);

        return str;
    }
}


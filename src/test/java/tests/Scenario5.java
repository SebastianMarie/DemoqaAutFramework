package tests;

import base.BaseTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.FramesPage;
import pages.HomePage;
import pages.AlertsFramesAndWindowsPage;

//        Step 1: Click pe Alerts, Frame & Windows de pe pagina principala
//        Step 2: Click pe "Frames" din lista
//        Step 3: Sa se salveze textul ce apare in iframe, intr-o variabila de tip String
//        Step 4: Sa se afiseze textul in consola

public class Scenario5 extends BaseTests {

    private WebDriver driver;
    private By iFrame;

    @BeforeEach
    public void initDriver() {
        driver = setUp();
    }
    @Test
    public void scenario5() {
        //STEP 0) Load the Home Page
        //Creating object of Home page
        HomePage homePage = new HomePage(driver);

        //STEP 1) Find "AlertsFramesAnd Windows" button on the HomePage and click on it
        homePage.clickAlertsFramesAndWindows();

        //STEP 2) Creating object of Elements page
        AlertsFramesAndWindowsPage alertsFramesAndWindowsPage = new AlertsFramesAndWindowsPage(driver);

        //STEP 3) Find "Frames" button and click on it
        alertsFramesAndWindowsPage.clickFramesBtn();

        //STEP 4) Creating object of "Frames" page
        FramesPage framesPage = new FramesPage(driver);

        //STEP 5) Switch the iFrame into a String type data and print out
        String actualPrintedMessage = framesPage.switchToIframe();

        //STEP 5a) Verify if the actual message "str" printed in the console is the same with the expected message
        String expectedPrintedMessage = "This is a sample page";

        Assertions.assertEquals(expectedPrintedMessage, actualPrintedMessage);
    }
    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}
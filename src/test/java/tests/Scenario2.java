package tests;

import base.BaseTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ElementsPage;
import pages.HomePage;
import pages.CheckBoxPage;

//        Step 1: Click pe Elements de pe pagina principala
//        Step 2: Click pe Check Box din lista
//        Step 3: Expand Home prin click pe sageata
//        Step 4: Click pe checkbox-ul aferent "Desktop"
//        Step 5: Sa se salveze textul generat de checkbox-ul selectat intr-o variabila, apoi afisata in consola


public class Scenario2 extends BaseTests {
    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        driver = setUp();
    }
    @Test
    public void scenario2() {
        //STEP 0) Load the Home Page
        //Creating object of Home page
        HomePage homePage = new HomePage(driver);

        //STEP 1) Find "Elements" button on the HomePage and click on it
        homePage.clickElements();

        //STEP 2) Creating object of Elements page
        ElementsPage elementsPage = new ElementsPage(driver);

        //STEP 3) Find "Check Box" button on the ElementsPage and click on it
        //Creating object of CheckBox page
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        elementsPage.clickCheckBoxBtn();

        //STEP 4) Find the "Expand Home" button arrow and click on it
        checkBoxPage.clickExpandHomeBtn();

        //STEP 5) Find the "Desktop" button and click on it
        checkBoxPage.clickDesktopBtn();

        //STEP 6) Save the generated text into a variable and print it into the console
        checkBoxPage.printText();

        //STEP 7) Verify that the actual printed text in the console is the same with the expected text
        String expectedText = "You have selected :\n" +
                "desktop\n" +
                "notes\n" +
                "commands";
        String actualText = checkBoxPage.viewPrintedText();

        Assertions.assertEquals(expectedText, actualText);
    }
    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

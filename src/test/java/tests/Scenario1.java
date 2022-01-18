package tests;

import base.BaseTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.ElementsPage;
import pages.HomePage;
import pages.TextBoxPage;

//        Step 1: Click pe Elements de pe pagina principala
//        Step 2: Click pe Text Box din lista
//        Step 3: Sa se completeze formularul
//        Step 4: Click pe Submit

public class Scenario1 extends BaseTests {
    private WebDriver driver;

    @BeforeEach
    public void initDriver() {
        driver = setUp();
    }
    @Test
    public void scenario1() {
        //STEP 0) Load the Home Page
        //Creating object of Home page
        HomePage homePage = new HomePage(driver);

        //STEP 1) Find "Elements" button on the HomePage and click on it
        homePage.clickElements();

        //STEP 2) Creating object of Elements page
        ElementsPage elementsPage = new ElementsPage(driver);

        //STEP 3) Find "Text Box" button on the ElementsPage and click on it
        elementsPage.clickTextBoxBtn();

        //STEP 4) Creating object of TextBox page
        TextBoxPage text = new TextBoxPage(driver);

        //STEP 5) Fill up  in the TextBoxPage the "User Name" , "email", "Current Address" and "Permanent Address" text
        // field with valid credentials
        // and then click on the "Submit" button
        text.enterUserName("Ion Pop");
        text.enterEmail("test@automation.com");
        text.enterCurrentAddress("Frunzisului 106");
        text.enterPermanentAddress("Frunzisului 106");
        text.clickSubmitBTn1();

        //STEP 6) Verify that the actual text is the same with the expected text
        String expectedText = "Name:Ion Pop\n" +

                "Email:test@automation.com\n" +

                "Current Address :Frunzisului 106\n" +

                "Permananet Address :Frunzisului 106";
        String actualText = text.viewTextArea();

        Assertions.assertEquals(expectedText, actualText);
    }
    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}

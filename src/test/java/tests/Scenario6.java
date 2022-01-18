package tests;

import base.BaseTests;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import pages.DatePickerPage;
import pages.HomePage;
import pages.WidgetsPage;

//         Step 1: Click pe Widgets de pe pagina principala
//         Step 2: Click pe "Date Picker" din lista
//         Step 3: Sa se adauge o data in fiecare dintre input fields, cu 30 de zile in viitor fata de data executiei

public class Scenario6 extends BaseTests {
    private WebDriver driver;
    private By datePickerMonthYearInput;
    private By dateAndTimePickerInput;

    @BeforeEach
    public void initDriver() {
        driver = setUp();
    }
    @Test
    public void scenario6() {
        //STEP 0) Load the Home Page
        //Creating object of Home page
        HomePage homePage = new HomePage(driver);

        //STEP 1) Find "Widgets" button on the "HomePage" and click on it
        homePage.clickWidgets();

        //STEP 2) Creating object of "Widgets" page
        WidgetsPage widgetsPage = new WidgetsPage(driver);

        //STEP 3) Find "DatePicker" button and click on it
        widgetsPage.clickDatePickerBtn();

        //STEP 4) Creating object of "Date Picker" page
        DatePickerPage datePickerPage = new DatePickerPage(driver);

        //STEP 5) Edit the "DatePickerMonthYearInput"
        String dueDate = datePickerPage.getDueDate(30);
        datePickerPage.setDueDate(dueDate);

        //STEP 5a) Verify if the actual DatePickerMonthYearInput is the same as the expected DatePickerMonthYearInput

        String actualDueDate = datePickerPage.viewDatePickerMonthYearInput();
        Assertions.assertEquals(dueDate, actualDueDate);

        datePickerPage.clickSelectDateText();

        //STEP 7a) Verify if the actual DateAndTimePickerInput is the same as the expected DateAndTimePickerInput
        String dueDate2 = datePickerPage.getDueDate2(30);
        datePickerPage.setDueDate2(dueDate2);

        String actualDueDate2 = datePickerPage.viewDateAndTimePickerInput();
        Assertions.assertEquals(dueDate2, actualDueDate2);

        datePickerPage.clickDateAndTimeText();

    }
    @AfterEach
    public void quitWebDriver() {
        driver.quit();
    }
}
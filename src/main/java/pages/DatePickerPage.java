package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DatePickerPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public DatePickerPage(WebDriver driver) {

        this.driver = driver;
    }
    //Locator for "datePickerMonthYearInput" input box
    By datePickerMonthYearInput = By.id("datePickerMonthYearInput");

    //Locator for "dateAndTimePickerInput" input box
    By dateAndTimePickerInput = By.id("dateAndTimePickerInput");

    //Locator for "Select Date" button
    By selectDateText = By.xpath("//div[contains(text(), 'Select Date')]");

    //  Method to click on the "Select Date" button
    public void clickSelectDateText() {
        driver.findElement(selectDateText).click();
    }
    //Locator for "Date And Time" button
    By dateAndTimeBtn = By.xpath("//div[contains(text(), 'Date And Time')]");

    //  Method to click on the "Date And Time" button
    public void clickDateAndTimeText() {
        driver.findElement(dateAndTimeBtn).click();
    }
    public String getDueDate(int numberOfDays) {
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_YEAR, numberOfDays);
        SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY");
        Date resultDate = c1.getTime();
        return df.format(resultDate);
    }
    public void setDueDate(String dueDate) {
        driver.findElement(datePickerMonthYearInput).sendKeys(Keys.CONTROL, "A");
        driver.findElement(datePickerMonthYearInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(datePickerMonthYearInput).sendKeys(dueDate);
    }
    //Method to view the text "datePickerMonthYearInput"
    public String viewDatePickerMonthYearInput() {
        return driver.findElement(datePickerMonthYearInput).getAttribute("value");

    }
    public String getDueDate2(int numberOfDays) {
        Calendar c1 = Calendar.getInstance();
        c1.add(Calendar.DAY_OF_YEAR, numberOfDays);
        SimpleDateFormat df = new SimpleDateFormat("MMMMMMM/DD/YYYY/hh:mm aaa");
        Date resultDate = c1.getTime();
        return df.format(resultDate);
    }
    public void setDueDate2(String dueDate2) {
        driver.findElement(dateAndTimePickerInput).sendKeys(Keys.CONTROL, "A");
        driver.findElement(dateAndTimePickerInput).sendKeys(Keys.BACK_SPACE);
        driver.findElement(dateAndTimePickerInput).sendKeys(dueDate2);
    }
    public String viewDateAndTimePickerInput() {
        return driver.findElement(dateAndTimePickerInput).getAttribute("value");
    }
}
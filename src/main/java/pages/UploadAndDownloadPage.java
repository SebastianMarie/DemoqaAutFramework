package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadAndDownloadPage {

    WebDriver driver;

    //Constructor that will be automatically called as soon as the object of the class is created
    public UploadAndDownloadPage(WebDriver driver) {

        this.driver = driver;
    }
    //Locator for "uploadFile" button
    By chooseFileBtn = By.id("uploadFile");

    //Locator for "uploadFile" message
    By uploadFileText = By.cssSelector(".mt-3");

    //Method to upload file
    public void uploadFile(String pathToFile) {

        driver.findElement(chooseFileBtn).sendKeys(pathToFile);
    }
    //Method to find the text message after the upload file
    public String actualMessageText() {
        return driver.findElement(uploadFileText).getText();

    }


}


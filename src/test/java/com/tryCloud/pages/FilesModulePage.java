package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesModulePage {

    public FilesModulePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckbox;


    @FindBy (xpath = "//input[@class='selectCheckBox checkbox']")
    public List<WebElement> checkboxes;
}

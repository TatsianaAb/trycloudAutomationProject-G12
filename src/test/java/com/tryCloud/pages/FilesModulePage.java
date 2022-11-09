package com.tryCloud.pages;

import com.tryCloud.utilities.BrowserUtils;
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

    @FindBy (xpath = "(//a[@class='action action-menu permanent'])[1]")
    public WebElement firstFileActionIcon;

    @FindBy (xpath = "//div[@id='app-navigation']//a")
    public List<WebElement> dropdownMenu;

   @FindBy (xpath = "//div//span[@class='nametext']")
   public List<WebElement> favoriteOptions;

   @FindBy (xpath = "//div[@class='fileActionsMenu popovermenu bubble open menu']//li//span[2]")
   public List<WebElement> actionIconOptions;




}

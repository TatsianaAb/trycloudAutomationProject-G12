package com.tryCloud.pages;

import com.tryCloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Dashboard']")
    public WebElement dashboard;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Files']")
    public WebElement files;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Photos']")
    public WebElement photos;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Activity']")
    public WebElement activity;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Talk']")
    public WebElement talk;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Contacts']")
    public WebElement contacts;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Circles']")
    public WebElement circles;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Calendar']")
    public WebElement calendar;

    @FindBy (xpath = "//ul[@id='appmenu']//a[@aria-label='Deck']")
    public WebElement deck;

    @FindBy (xpath = "//span[@aria-label='Magnify icon']")
    public WebElement searchIcon;

    @FindBy (xpath = "//img[@title='Notifications']")
    public WebElement notifications;

    @FindBy (xpath = "//div[@class='icon-contacts menutoggle']")
    public WebElement searchContactsIcon;

    @FindBy (xpath = "//div[@class='avatardiv avatardiv-shown']")
    public WebElement userIcon;

    @FindBy (xpath = "//a[normalize-space()='Log out']")
    public WebElement logoutButton;



}

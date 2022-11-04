package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.DashboardPage;
import com.tryCloud.pages.TryCloudLoginPage;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import javax.sound.midi.Track;

public class ContactsModuleStepDefs {

    TryCloudLoginPage tryCloudLoginPage = new TryCloudLoginPage();
    DashboardPage dashboardPage = new DashboardPage();


    @When("the user clicks the contacts module")
    public void the_user_clicks_the_contacts_module() {
        dashboardPage.searchContactsIcon.click();
    }

    @Then("verify the contact names are in the list")
    public void verify_the_contact_names_are_in_the_list() {
        Assert.assertTrue(dashboardPage.contactFullNames.size() >= 2);
        for (WebElement each : dashboardPage.contactFullNames) {
            System.out.println(each.getText());
        }
    }







}

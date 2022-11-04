package com.tryCloud.step_definitions;

import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.FilesModulePage;
import com.tryCloud.pages.TryCloudLoginPage;
import com.tryCloud.utilities.BrowserUtils;
import com.tryCloud.utilities.ConfigurationReader;
import com.tryCloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilesModuleStepDefs {

    BasePage basePage = new BasePage();
    TryCloudLoginPage tryCloudLoginPage = new TryCloudLoginPage();
    FilesModulePage filesModulePage = new FilesModulePage();

    @Given("user uses {string} and {string} to log in and on the dashboard page")
    public void user_uses_and_to_log_in_and_on_the_dashboard_page(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        tryCloudLoginPage.login(username, password);
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        BrowserUtils.waitForVisibility(basePage.files, 10);
      basePage.files.click();
    }
    @Then("verifies the page title is {string}")
    public void verifies_the_page_title_is(String expectedTitle) {
      BrowserUtils.verifyTitle(expectedTitle);
    }

}

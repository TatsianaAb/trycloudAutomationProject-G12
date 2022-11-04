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
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class FilesModuleStepDefs {

 //   BasePage basePage = new BasePage();
 //   TryCloudLoginPage tryCloudLoginPage = new TryCloudLoginPage();
    FilesModulePage filesModulePage = new FilesModulePage();
    BasePage basePage = new BasePage();

    TryCloudLoginPage tryCloudLoginPage = new TryCloudLoginPage();

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

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
       filesModulePage.selectAllCheckbox.click();
    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        for (WebElement each : filesModulePage.checkboxes) {
            Assert.assertTrue(each.isSelected());
        }
    }

}

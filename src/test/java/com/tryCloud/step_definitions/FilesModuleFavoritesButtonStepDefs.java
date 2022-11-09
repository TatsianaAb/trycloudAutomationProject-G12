package com.tryCloud.step_definitions;


import com.tryCloud.pages.BasePage;
import com.tryCloud.pages.FilesModulePage;
import com.tryCloud.pages.TryCloudLoginPage;
import com.tryCloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;


public class FilesModuleFavoritesButtonStepDefs {

    //TryCloudLoginPage tryCloudLoginPage = new TryCloudLoginPage();
  //  BasePage basePage = new BasePage();
    FilesModulePage filesModulePage = new FilesModulePage();

    @When("the user clicks action-icon from first file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        BrowserUtils.waitForVisibility(filesModulePage.firstFileActionIcon, 10);
        filesModulePage.firstFileActionIcon.click();
        }
    @When("user choose the {string} option")
    public void user_choose_the_option(String str) {
        try {
            for (WebElement each : filesModulePage.actionIconOptions) {
                if (each.getText().equals(str)) {
                    each.click();
                }
            }

        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
        }
    }


    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String str) {
        for (WebElement each : filesModulePage.dropdownMenu) {
            if(each.getText().equals(str)){
                each.click();
                break;
            }
        }

    }

    @Then("Verify the chosen file {string} is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table(String string) {
        for (WebElement each : filesModulePage.favoriteOptions) {
            if(each.getText().equals(string)){
                break;
            }
        }

    }


}

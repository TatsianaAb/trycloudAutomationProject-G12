package com.tryCloud.step_definitions;

/*
In this class we will be able to pass pre- and post- conditions to each scenario and each step
 */

import com.tryCloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//glue in CukesRunner class

public class Hooks {
    //import from io.cucumber.java not from junit
    @Before
    public void setUpScenario() {

    }


    @After
    public void tearDownScenario(Scenario scenario) {
        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();

    }
}



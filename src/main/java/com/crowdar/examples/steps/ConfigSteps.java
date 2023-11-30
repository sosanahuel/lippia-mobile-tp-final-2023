package com.crowdar.examples.steps;

import com.crowdar.examples.services.ConfigService;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.TimeEntryService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ConfigSteps {
    @And("selects from the hamburger menu")
    public void selects_from_the_hamburger_menu() {
        ConfigService.clickMenuIcon();
    }
    @And("selects settings")
    public void sellect_settings() {
        ConfigService.clickSettings();
    }
    @And("switches to dark mode")
    public void switches_to_dark_mode() {
        ConfigService.clickDarkMode();
    }
    @And("logs out")
    public void logs_out() {
        ConfigService.clickMenu();
        ConfigService.clickLogout();
        ConfigService.confimLogout();
    }
    @Then("the user is logged out")
    public void the_user_is_logged_out() {
        TimeEntryService.isViewLoaded();
    }
}

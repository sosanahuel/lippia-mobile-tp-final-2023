package com.crowdar.examples.steps;

import com.crowdar.core.PageSteps;
import com.crowdar.examples.services.HomeService;
import com.crowdar.examples.services.TimeEntryService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class TimeEntrySteps extends PageSteps {

    @Given("the user successfully logged into the app")
    public void the_user_successfully_logged_into_the_app() {
        TimeEntryService.isViewLoaded();
    }
    @When("the user enters their (.*), (.*)")
    public void the_user_enters_their_email_password(String email, String password) {
        TimeEntryService.logIn(email, password);
    }
    @Then("el usuario se a logeado correctamente con su (.*)")
    public void el_usuario_se_ha_logeado_correctamente_con_su(String email) {
        TimeEntryService.validarEmail(email);
    }
    @Then("obtengo el pass")
    public void obtengo_el_pass(){
        TimeEntryService.obtengoElPass();
    }

    //NoSave
    @And("the user cancels the save")
    public void the_user_cancels_the_save() {
        TimeEntryService.previusClick();
        TimeEntryService.discartClick();
    }
    @And("the user sets start time {string} {string}")
    public void the_user_sets_start_time_Starthour_Startminutes(String hour, String minutes) {
        HomeService.addTime(hour, minutes);
    }

    @And("the user enters a date {string}")
    public void theUserEntersADate(String date) throws InterruptedException {
        TimeEntryService.entersDate();
        String[] newDate = date.split("-");
        TimeEntryService.inputDate(newDate);
    }
    @And("confirms the data")
    public void confirms_the_data() {
        TimeEntryService.saveButtonDate();
    }
}

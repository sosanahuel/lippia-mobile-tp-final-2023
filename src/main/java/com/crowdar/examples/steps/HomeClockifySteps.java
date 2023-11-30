package com.crowdar.examples.steps;

import com.crowdar.examples.services.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.crowdar.examples.services.ApiService.*;


public class HomeClockifySteps {
    @And("the user sets a time (.*) (.*)")
    public void the_user_sets_a_time_hour_minutes(String hora, String minutos) {
        HomeService.clickAddTime();
        HomeService.addTime(hora, minutos);
    }

    @And("the user adds to the project (.*) and description (.*)")
    public void the_user_adds_to_the_project_project_and_description_text(String project, String texto) {
        HomeService.clickAddProject(project);
        HomeService.addDescription(texto);
    }

    @And("the user saves the time entry")
    public void the_user_saves_the_time_entry() {
        HomeService.saveTimeEntry();
    }

    @Then("the user checks their saved project (.*)")
    public void the_user_checks_their_saved_project_text(String text) {
        HomeService.validarSave(text);
    }

    @Then("the user checks their unsaved project (.*)")
    public void the_user_checks_their_unsaved_project_text(String texto){
        HomeService.validateNoSave(texto);
    }
    @And("deletes the task by backend from the time entry {string} in the project")
    public void elimina_tarea(String timeEntryName){
        String[] workspace = getWorkspace();
        String idTimeEntry = getTimeEntrys(workspace, timeEntryName);
        deleteTimeEntry(workspace, idTimeEntry);
    }

}

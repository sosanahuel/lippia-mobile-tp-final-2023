package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddEntryConstants;
import com.crowdar.examples.constants.HomeConstants;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HomeService extends MobileActionManager {

    public static void clickAddTime() {
        MobileActionManager.waitClickable(HomeConstants.PLUS_BUTTON);
        MobileActionManager.click(HomeConstants.PLUS_BUTTON);
    }

    public static void addTime(String hora, String minutos) {
        setInput(AddEntryConstants.HOURS_ENTRY, hora, true,true);
        setInput(AddEntryConstants.MIN_ENTRY, minutos,true,true);
    }
    public static void addDescription(String texto) {
        MobileActionManager.setInput(HomeConstants.INPUT_WORKING, texto, true, false);
    }
    public static void clickAddProject(String project) {
        MobileActionManager.waitVisibility(AddEntryConstants.ADD_PROJECT).click();
        MobileActionManager.waitVisibility(HomeConstants.PROJECTS);
        List<WebElement> ProjectGet = MobileActionManager.getElements(HomeConstants.PROJECTS);
        for (WebElement projectElement : ProjectGet) {
            if (projectElement.getText().equals(project)) {
                projectElement.click();
            }
        }
    }
    public static void saveTimeEntry() {
        MobileActionManager.waitClickable(HomeConstants.SAVE_BUTTON);
        MobileActionManager.click(HomeConstants.SAVE_BUTTON);
    }
    public static void validarSave(String text) {
        MobileActionManager.waitClickable(HomeConstants.PLUS_BUTTON);
        List<WebElement> description = MobileActionManager.getElements(HomeConstants.DESCRIPTION_BUTTON);
        for(WebElement descriptionIndiv: description){
            Assert.assertEquals(descriptionIndiv.getText().toLowerCase(), text.toLowerCase());
        }
    }
    public static void validateNoSave(String texto) {
        MobileActionManager.waitVisibility(HomeConstants.ALL_TIME_ENTRIES);
        List<WebElement> timeEntriesList = MobileActionManager.getElements(HomeConstants.ALL_TIME_ENTRIES);
        for(WebElement timeEntries: timeEntriesList){
            Assert.assertNotEquals(texto, timeEntries.getText());
        }
    }
}

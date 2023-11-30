package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.driver.DriverManager;
import com.crowdar.examples.constants.ConfigConstants;
import com.crowdar.examples.constants.HomeConstants;
import org.testng.Assert;

import static com.crowdar.core.actions.ActionManager.isPresent;

public class ConfigService {
    public static void clickMenuIcon() {
        MobileActionManager.waitClickable(ConfigConstants.MENU_ICON_BUTTON);
        MobileActionManager.click(ConfigConstants.MENU_ICON_BUTTON);
    }
    public static void clickMenu(){
        MobileActionManager.click(ConfigConstants.MENU_DARK_BUTTON);
    }
    public static void clickSettings() {
        MobileActionManager.click(ConfigConstants.SETTINGS_BUTTON);
    }

    public static void clickDarkMode() {
        MobileActionManager.waitClickable(ConfigConstants.DARKMODE_BUTTON);
        MobileActionManager.click(ConfigConstants.DARKMODE_BUTTON);
    }


    public static void clickLogout() {
        MobileActionManager.waitClickable(ConfigConstants.LOGOUT_BUTTON);
        MobileActionManager.click(ConfigConstants.LOGOUT_BUTTON);
    }

    public static void confimLogout(){
        MobileActionManager.waitVisibility(ConfigConstants.CONFIRM_LOGOUT_BUTTON);
        MobileActionManager.click(ConfigConstants.CONFIRM_LOGOUT_BUTTON);
    }


}

package com.crowdar.examples.services;

import com.crowdar.core.actions.MobileActionManager;
import com.crowdar.examples.constants.AddEntryConstants;
import com.crowdar.examples.constants.HomeConstants;
import com.crowdar.examples.constants.TimeEntryConstants;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TimeEntryService {

    public static void isViewLoaded(){
        MobileActionManager.waitVisibility(TimeEntryConstants.LOGIN_DISPLAYED);
        Assert.assertTrue(MobileActionManager.isPresent(TimeEntryConstants.LOGIN_DISPLAYED));
    }
    public static void logIn(String email, String password) {
        MobileActionManager.setInput(TimeEntryConstants.INPUT_EMAIL, email);
        MobileActionManager.setInput(TimeEntryConstants.INPUT_PASSWORD, password);
        MobileActionManager.click(TimeEntryConstants.BUTTON_LOGIN);
    }
    public static void validarEmail(String email){
        MobileActionManager.waitClickable(TimeEntryConstants.MENU_BUTTON);
        MobileActionManager.click(TimeEntryConstants.MENU_BUTTON);
        MobileActionManager.waitClickable(TimeEntryConstants.USER_EMAIL);
        Assert.assertEquals(MobileActionManager.getText(TimeEntryConstants.USER_EMAIL), email);
    }
    public static void obtengoElPass(){
        String Passw = MobileActionManager.getText(TimeEntryConstants.GET_PASS);
    }

    public static void previusClick(){
        MobileActionManager.click(TimeEntryConstants.PREVIUS_BUTTON);
    }
    public static void discartClick(){
        MobileActionManager.waitClickable(TimeEntryConstants.DISCART_BUTTON);
        MobileActionManager.click(TimeEntryConstants.DISCART_BUTTON);
    }

    //DATE
    public static void inputDate(String[] date) throws InterruptedException {
        String[] actualDate = getActualDate().split("-");
        String desirableDate = date[0]+" "+getMonth(Integer.parseInt(date[1].replace("0","")))+" "+date[2];
        int monthsDif = Integer.parseInt(actualDate[1] ) - Integer.parseInt(date[1]);
        for (int i=1; i<=monthsDif;i++){
            MobileActionManager.click(TimeEntryConstants.NAVIGATE_MONTHS_BEFORE);
        }
        if(date[0].equals(MobileActionManager.getElement("xpath://android.view.View[@content-desc='"+desirableDate+"']").getText())){
            MobileActionManager.click("xpath://android.view.View[@content-desc='"+desirableDate+"']");
        }
        Thread.sleep(1000);
    }
    private static String getActualDate() {
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        return formato.format(fechaActual);
    }
    public static String getMonth(int numberMonth) {
        String monthName;
        switch (numberMonth) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "Invalid month number";
                break;
        }
        return monthName;
    }
    public static void entersDate() {
        MobileActionManager.click(TimeEntryConstants.SELECT_DATE);
    }
    public static void saveButtonDate(){
        MobileActionManager.click(TimeEntryConstants.SAVE_BUTTON_DATE);
    }
}

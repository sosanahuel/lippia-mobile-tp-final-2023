package com.crowdar.examples.services;


import com.crowdar.core.PropertyManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ApiService {
    public static String[] getWorkspace(){
        RestAssured.baseURI = PropertyManager.getProperty("urlClockify")+"workspaces";
        String response = RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .header("X-Api-Key", PropertyManager.getProperty("token"))
                .when()
                .get()
                .then().assertThat().log().all().statusCode(200)
                .extract().response().body().prettyPrint();

        JsonPath jsonPathEvaluator = JsonPath.from(response.toString());
        String[] workAndUser = {jsonPathEvaluator.get("[0].id"), jsonPathEvaluator.get("[0].memberships[0].userId")};
        return workAndUser;
    }
    public static String getTimeEntrys(String[] workspaceIDUser, String nameTimeEntry){
        RestAssured.baseURI = PropertyManager.getProperty("urlClockify")+"workspaces/"+workspaceIDUser[0]+"/user/"+workspaceIDUser[1]+"/time-entries";
        String response = RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .header("X-Api-Key", PropertyManager.getProperty("token"))
                .header("cache-control", "no-cache")
                .when()
                .get()
                .then().assertThat().log().all().statusCode(200)
                .extract().response().body().prettyPrint();

        String idTimeEntry = null;
        int i = 0;
        JsonPath jsonPathEvaluator = JsonPath.from(response.toString());
        while (jsonPathEvaluator.get("["+i+"].id")!=null){
            if(jsonPathEvaluator.get("["+i+"].description").toString().equalsIgnoreCase(nameTimeEntry)) idTimeEntry = jsonPathEvaluator.get("["+i+"].id");
            i++;
        }
        return idTimeEntry;
    }
    public static void deleteTimeEntry(String[] workspaceID, String idTimeEntry){

        RestAssured.baseURI = PropertyManager.getProperty("urlClockify")+"workspaces/"+workspaceID[0]+"/time-entries/"+idTimeEntry;

        String response = RestAssured.given().log().all()
                .header("Content-type", "application/json")
                .header("X-Api-Key", PropertyManager.getProperty("token"))
                .header("cache-control", "no-cache")
                .when()
                .delete()
                .then().assertThat().log().all().statusCode(204)
                .extract().response().toString();

        JsonPath jsonPathEvaluator = JsonPath.from(response.toString());

        System.out.println(jsonPathEvaluator);
    }

}

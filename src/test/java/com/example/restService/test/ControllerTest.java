package com.example.restService.test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class ControllerTest {

    @Test
    public void getAllNotes(){
        RestAssured.baseURI = "http://localhost:8080/api/model";
        given().when()
                .get("/all")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void addNote(){
        RestAssured.baseURI = "http://localhost:8080/api/model";
        given().contentType(ContentType.JSON).body("{" +
                "        \"title\": \"pierwszy tytul\"," +
                "        \"content\": \"pierwszy kontent\"" +
                "    }")
                .when()
                .post("")
                .then().statusCode(200);
    }

    @Test
    public void modifyNote(){
        RestAssured.baseURI = "http://localhost:8080/api/model";
        given().contentType(ContentType.JSON).body("{" +
                "        \"title\": \"modyfikacja\"," +
                "        \"content\": \"testowy kontent\"" +
                "    }")
                .when()
                .put("/1")
                .then().statusCode(200);
    }

    @Test
    public void deleteNote(){
        RestAssured.baseURI = "http://localhost:8080/api/model";
        given().when()
                .delete("/1")
                .then().statusCode(200);
    }

    @Test
    public void getBackup(){
        RestAssured.baseURI = "http://localhost:8080/api/model";
        given().when()
                .get("/backup/all")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void getAllNoteVersions(){
        RestAssured.baseURI = "http://localhost:8080/api/model";
        given().when()
                .get("/backup/1")
                .then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

}

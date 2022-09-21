package com.toptaltest.API;

import com.toptaltest.UI.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class APITest extends BaseClass {

    String userId = "06dbf469-ddfb-49cc-b47f-74bb1cdf2eb0";
    String isbn = "9781491950296";

    RequestSpecification request;

    @BeforeTest
    public void setup() {

        RestAssured.baseURI = "https://bookstore.toolsqa.com";

        request = RestAssured.given();


        String credentials = "saffinsh:Saffin@123.";

        byte[] encodedCredentials = Base64.encodeBase64(credentials.getBytes());

        String encodedCredentialsAsString = new String(encodedCredentials);
        // RestAssured.authentication = RestAssured.preemptive().basic("ToolsQA", "TestPassword");
        request.header("Authorization", "Basic " + encodedCredentialsAsString);
    }

    @Test(priority = 1, description = "testing GET method and 200 status code")
    public void listOfBooks() {
        logger = reports.createTest("listOfBooks");

        request.header("Content-Type", "application/json");
        Response response = request.get("/BookStore/v1/Books");

        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

    }

    @Test(priority = 2, description = "testing Post method for 201 created status code")
    public void PostingOfBooks() {


        logger = reports.createTest("PostingOfBooks");

        String payload = "{\r\n" +
                "  \"userId\": \"06dbf469-ddfb-49cc-b47f-74bb1cdf2eb0\",\r\n" +
                "  \"collectionOfIsbns\": [\r\n" +
                "    {\r\n" +
                "      \"isbn\": \"9781593277574\"\r\n" +
                "    }\r\n" +
                "  ]\r\n" +
                "}";

        request.header("Content-Type", "application/json");

        Response response = request.body(payload).post("/BookStore/v1/Books");
        System.out.println("PostingOfBooks");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 201);

    }

    @Test(priority = 3, description = "testing PUT method to update book from userid for 200 status code")
    public void updatingBookInUserId(){

        logger = reports.createTest("updatingBookInUserId");

        Data data = new Data();
        data.setUserId(userId);
        data.setIsbn(isbn);



        request.header("Content-Type", "application/json");

        Response response = request.body(data).put("/BookStore/v1/Books/9781593277574");
        System.out.println("updatingBookInUserId");
        response.prettyPrint();

        Assert.assertEquals(response.statusCode(), 200);

    }


    @Test(priority = 4, description = "Validate if updating same book to the user is showing error 400 bad request status code")
    public void RePostingOfSameBooks() {

        logger = reports.createTest("RePostingOfSameBooks");

        Data data = new Data();
        data.setUserId(userId);
        data.setIsbn(isbn);

        request.header("Content-Type", "application/json");

        Response response = request.body(data).put("/BookStore/v1/Books/9781593277574");
        System.out.println("RePostingOfSameBooks");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 400);

    }

    @Test(priority = 5, description = "testing DELETE method to delete available book from userid for 204 status code")
    public void DeletingOfBookFromUserId() {

        logger = reports.createTest("DeletingOfBookFromUserId");

        Data data = new Data();
        data.setUserId(userId);
        data.setIsbn(isbn);


        request.header("Content-Type", "application/json");

        Response response = request.body(data).delete("/BookStore/v1/Book");
        System.out.println("DeletingOfBookFromUserId");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 204);

    }


    @Test(priority = 6, description = "Validate DELETE method to delete non existence of book from userId for 400 Bad request status code")
    public void deleteSameBookAgainToCheckError() {

        logger = reports.createTest("deleteSameBookAgainToCheckError");

        Data data = new Data();
        data.setUserId(userId);
        data.setIsbn(isbn);


        request.header("Content-Type", "application/json");

        Response response = request.body(data).delete("/BookStore/v1/Book");
        System.out.println("deleteSameBookAgainToCheckError");
        response.prettyPrint();
        Assert.assertEquals(response.statusCode(), 400);

    }


}

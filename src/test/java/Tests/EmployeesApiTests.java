package Tests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class EmployeesApiTests extends BaseEmployeesControllerTest {
    @Test
    public void printAllEmployees() {       //  (1)
        Response response = given()
                .log().uri().
                when().
                get("/employees").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void printEmployee() {       //  (3)
        Response response = given()
                .log().uri().
                when().
                get("/employee/{id}", "9328").        //  id-ul e afisat la creare
                then().
                statusCode(200).
                contentType(ContentType.JSON).
//                        body("data.employee_name",
//                                equalTo("Automation Test")).
        extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void createEmployee() {      //  (2)
        Response response = given()
                .log().uri().
                contentType(ContentType.JSON).
                body("{\"employee_name\":\"Automation Test\"," +
                        "\"employee_salary\":\"123\"," +
                        "\"employee_age\":\"35\", " +
                        "\"profile_image\":\"\"}").
                when().
                post("/create").
                then().
                statusCode(200).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void updateEmployee() {      //  (4)
        Response response = given()
                .log().uri().
                contentType(ContentType.JSON).
                body("{\"employee_name\":\"Automation Test\"," +
                        "\"employee_salary\":\"123\"," +
                        "\"employee_age\":\"35\", " +
                        "\"profile_image\":\"\"}").
                when().
                put("/update/{id}", "7177").        //  id-ul e afisat la creare
                then().
                statusCode(200).
                extract().response();
        response.getBody().prettyPrint();
    }

    @Test
    public void deleteEmployee() {      //  (5)
        Response response = given()
                .log().uri().
                contentType(ContentType.JSON).
                when().
                get("/delete/{id}", "7177").        //  id-ul e afisat la creare
                then().
                extract().response();
        response.getBody().prettyPrint();
        response = given()
                .log().uri().
                when().
                get("/employee/{id}", "7177").        //  id-ul e afisat la creare
                then().
//                        statusCode(404).
        contentType(ContentType.JSON).
                extract().response();
        response.getBody().prettyPrint();
    }
}

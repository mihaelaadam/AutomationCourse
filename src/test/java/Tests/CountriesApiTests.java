package Tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;

public class CountriesApiTests extends BaseCountriesControllerTest {
    @Test
    public void getCountryByName() {
        Response response = given()     //  pregaterste restAssured-ul pentru urmatoarele actiuni. E un must have pentru toate call-urile
                .log().uri().       //  printeaza in consola tot API-ul pe care-l interogam
                when().             //  keyword-ul pe care il facem pentru a spune ca vrem sa facem un call cu anumite filtrari sau cu anumite conditii, in care ii spunem  requestului ca tb sa vina un request de un anumit tip (un request cu o filtrare)
                get("/name/{name}", "rom").
                then().             //  am facut call-ul, s-au terminat instructiunile. Urmeaza validarile
                statusCode(200).    //  assert pentru raspuns code-ul pe care il primim
                contentType(ContentType.JSON).  //  spunem codului ca tb sa-l citeasca ca si un fisier json
                body("name.official[0]",        //  este tot o validare, assert-uri
                        equalTo("Romania")).
                body("currencies.RON.symbol[0]",
                        equalTo("lei")).
                extract().response();       //  extrage informatia de la server la nivel de pachet de date si o mapeaza in acest obiect de tip response
        response.getBody().prettyPrint();       //  acum putem sa printam contentul la nivel de text. (prettyPrint) Ni-l printeaza structurat ca un fisier json
    }

    @Test
    public void verifyCountriesCapital() {
        given()
                .log().uri().
                when().
                queryParam("fullText", true).       //     cand caut strict dupa numele intreg
                get("/name/{name}", "romania").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("capital[0][0]", equalTo("Bucharest")).      //    [0][0] este o matrice, vrem primul element
                extract().response();
    }

    @Test
    public void verifyAltSpelling() {
        given()
                .log().uri().
                when().
                queryParam("fullText", true).
                get("/name/{name}", "romania").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("altSpellings[0]", hasItem("România")).        //  un alt obiect. E un singur vector. Validam in in acele valori ale altSprlling este si Romania cu diacritice
                extract().response();
    }

    @Test
    public void verifyCountryBorders() {
        List<String> expectedBorders = Arrays.asList(
                "MDA", "BGR", "HUN", "SRB", "UKR");
        List<String> actualBorders = new ArrayList<>(given()        //  cream lista de stringuri pentru a stoca infomatia pt assertul actual.
                // Cand primim eroarea Collections$UnmodifiableList transformam lista intr-un ArrayList. Adica le transformam intr-o noua lista (3)
                .log().uri().
                when().
                queryParam("fullText", true).
                get("/name/{name}", "romania").
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                extract().response().jsonPath().getList("borders[0]",   //  lista cu raspunsul nu este stocat. E o lista de stringuri (1)
                        String.class));
        expectedBorders.sort(Comparator.naturalOrder());        //      cand ma interseaza doar elementele, eu tb sa-mi sortez listele dupa acelasi criteriu (cand nu stim ordinea in liste)
        actualBorders.sort(Comparator.naturalOrder());          //      --- '' ---
        Assert.assertEquals(expectedBorders, actualBorders);    //  pentru orice obiect care nu este primitiv in java se poate compara cu assertEquals (2)
    }
}

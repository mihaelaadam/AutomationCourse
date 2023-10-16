package Tests;

import Utils.ConstantUtils;
import Utils.GenericUtils;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseEmployeesControllerTest {

    String apiConfig = ConstantUtils.API_CONFIG_FILE;
    String apiVersion, baseUrl;

    @BeforeClass
    public void setUp() {
        apiVersion = GenericUtils.getApiVersion(apiConfig,
                "apiVers");
        baseUrl = GenericUtils.getBaseUrl(apiConfig,
                "protocolEmployees",
                "baseUrl");
        System.out.println("Use this baseurl:" + baseUrl);
        System.out.println("Use this apiVersion:" + apiVersion);
        RestAssured.baseURI = baseUrl + "/" + apiVersion;
    }
}
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AAIB_Task extends BaseTest {

    private static int userId;
    private static String updatedJob = " QA Engineer";
    private static final String API_KEY = "reqres_366d4ca18b4342a2b77789cdbc39e6e0";

    // 1️- Create User
    @Test(priority = 1)
    public void createUser() {
        Response response =
                given()
                        .header("Content-Type", "application/json")
                        .header("x-api-key", API_KEY)
                        .body("""
                                {
                                  "name": "Abdelrhman",
                                  "job": "QA Engineer"
                                }
                              """)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .extract().response();

        userId = response.jsonPath().getInt("id");
        Assert.assertTrue(userId > 0, "User ID should be generated");
    }

    // 2️- Update User
    @Test(priority = 2)
    public void updateUser() {
        given()
                .header("Content-Type", "application/json")
                .header("x-api-key", API_KEY)
                .body("""
                        {
                          "job": " junior QA Engineer"
                        }
                      """)
                .when()
                .put("/users/" + userId)
                .then()
                .statusCode(200);
    }

    // 3️- Get User & Verify Update
    @Test(priority = 3)
    public void getUserAndVerifyUpdate() {
        Response response =
                given()
                        .header("x-api-key", API_KEY)
                        .when()
                        .get("/users/" + userId)
                        .then()
                        .statusCode(200)
                        .extract().response();

        String actualJob = response.jsonPath().getString("job");
        Assert.assertEquals(actualJob, updatedJob, "Job should be updated");
    }

    // 4️- Delete User
    @Test(priority = 4)
    public void deleteUser() {
        given()
                .header("x-api-key", API_KEY)
                .when()
                .delete("/users/" + userId)
                .then()
                .statusCode(204);
    }

    // 5-Get User & Verify Deletion
    @Test(priority = 5)
    public void verifyUserDeleted() {
        given()
                .header("x-api-key", API_KEY)
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(404);
    }
}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostTweeTest {

    @Test
    public void addPetTest() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");

        JSONObject json = new JSONObject();
        json.put("id", 2);
        json.put("title", "RestAssured");
        json.put("auther", "Avinash");

        request.body(json.toJSONString());

        Response response = request.post("http://localhost:3000/posts");

        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 201);

    }
}

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PatchCallTest {

    @Test
    public void modifyDetails() {

        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        JSONObject json = new JSONObject();
//            json.put("id", 2);
        json.put("title", "RestAssured");
//            json.put("auther", "Avinash");

        Response response = request.patch("http://localhost:3000/posts/1");
        System.out.println("Status code: " + response.statusCode());
        System.out.println("Time:" + response.getTime());
        System.out.println("Response Body: " + response.asPrettyString());

        Assert.assertEquals(response.statusCode(), 200);

    }
}

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetCallBDDTest {

    @Test
    public void getDetails() {

        //String body = given().when().get("http://localhost:3000/posts").asPrettyString();
        //System.out.println("Body: " + body);
    }

    @Test
    public void postTest() {
        JSONObject json = new JSONObject();
        json.put("id", 5);
        json.put("title", "Restassured");
        json.put("authar", "Ram");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                //when().post("http://localhost:3000/posts/").
                then().statusCode(201);
    }
    @Test
    public void putPetTest(){

        JSONObject json = new JSONObject();
        json.put("title", "Restassured");
        json.put("authar", "Sachin");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                //when().put("http://localhost:3000/posts/1").
                then().statusCode(200);
    }
    @Test
    public void patchPetTest(){

        JSONObject json = new JSONObject();
        json.put("title", "Restassured");
        json.put("authar", "Aditya");

        given().header("Content-Type", "application/json").body(json.toJSONString()).
                //when().patch("http://localhost:3000/posts/1").
                then().statusCode(200);
    }

    @Test
    public void deletePetTest(){
        given().header("Content-Type", "application/json").
                //when().delete("http://localhost:3000/posts/5").
                then().statusCode(200);
    }
}

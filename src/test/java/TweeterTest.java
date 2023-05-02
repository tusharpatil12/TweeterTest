import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TweeterTest {

    String API_KEY = "AvUl8mBbjpoJzxJNj6OfymHqT";
    String API_SECRET_KEY = "5x5INgUt0Zq4tp81Ja9U2unoOqSRQzi752ZmOmx4f5Tqh9BSjk";
    String ACCESS_TOKEN = "1649678689179959296-GjrKkkFBSYbMm1rneCKDeUJyfA3M9L";
    String ACCESS_SECRET_TOKEN = "II7Ct6KwZGE1FWcVzL0SGvInF8roJHskVxbJC5WdSXE54";
    String id;

    @Test
    public void CreateTweetTest() {
        RestAssured.baseURI = "https://api.twitter.com/1.1/statuses";
        Response response = given().auth().oauth(API_KEY, API_SECRET_KEY, ACCESS_TOKEN, ACCESS_SECRET_TOKEN).
                queryParam("status", "This is my First Tweet").
                when().post("update.json").then().extract().response();
        String res = response.asString();
        JsonPath js = new JsonPath(res);
        //id = js.get("id").toString();
        //System.out.println("Tweet ID is :" + id);
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body "+response.asPrettyString());
    }

    @Test
    public void DeleteTweetTest() {
        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                post("https://api.twitter.com/1.1/statuses/destroy/1651788639226183680.json");

        System.out.println("Status Code "+response.statusCode());
        System.out.println("Response Body "+response.asPrettyString());
    }
    @Test
    public void UndoRetweetTest() {
        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                post("https://api.twitter.com/1.1/statuses/unretweet/1651789041162162177.json");

        System.out.println("Status Code "+response.statusCode());
        System.out.println("Response Body "+response.asPrettyString());
    }
    @Test
    public void RetweetTest(){
        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                post("https://api.twitter.com/1.1/statuses/retweet/1651788639226183680.json");

        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body :"+response.asPrettyString());

    }
    @Test
    public void GetLatestTweet(){
        RestAssured.baseURI="https://api.twitter.com/1.1/statuses";
        Response response= given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).queryParam("count", "1").
                when().get("/home_timeline.json").then().extract().response();
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body :"+response.asPrettyString());

    }
    @Test
    public void Retweetlookup(){
        Response response = given().auth().oauth(API_KEY,API_SECRET_KEY,ACCESS_TOKEN,ACCESS_SECRET_TOKEN).
                get("https://api.twitter.com/1.1/retweeters/id.json");
        String res =response.asString();
        System.out.println(res);
        System.out.println("Status Code :"+response.statusCode());
        System.out.println("Response Body :"+response.asPrettyString());

    }
}

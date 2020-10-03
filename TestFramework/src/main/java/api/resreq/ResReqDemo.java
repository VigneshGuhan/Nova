package api.resreq;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class ResReqDemo {

    /**To add resource Details and get an unique id
     *
     * @param name
     * @param job
     * @return id - if resource is created else "nil"
     */
    public static String createDetailsViaApiUsingPost(String name, String job) {
        RestAssured.baseURI = "https://reqres.in";
        RestAssured.basePath = "/api/users";

        JsonObject postBody = new JsonObject();
        postBody.addProperty("name",name);
        postBody.addProperty("job",job);

        RequestSpecification request = RestAssured.given()
                                                  .contentType(ContentType.JSON);

        Response response = request.with().body(postBody)
                                   .when().post();

        int statusCode = response.getStatusCode();
      //  System.out.println("statusCode = " + statusCode);
        if(statusCode==201){
            String s = response.getBody().asString();
          //  System.out.println("s = " + s);
            return   response.path("id").toString();
        }
        else {
            Assert.assertTrue("Post request for data creation failed",false);
            return "";
        }



    }
}

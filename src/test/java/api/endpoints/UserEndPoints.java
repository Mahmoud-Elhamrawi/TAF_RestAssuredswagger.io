package api.endpoints;

import api.payload.UserPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class UserEndPoints {

    //create crud user

    public static Response createUser(UserPojo payload)
    {
        Response createUserRes = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when().post(Routes.post_url_user) ;
        return createUserRes;

    }


 public static Response getUser(String userName)
 {
     Response readUserRes =given()
             .contentType(ContentType.JSON)
             .pathParam("username",userName)
             .when().get(Routes.get_url_user) ;
     return  readUserRes ;
 }

    public static Response updateUser(String userName , UserPojo payload)
    {
        Response updateUserRes =given()
                .contentType(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload)
                .when().put(Routes.update_url_user) ;
        return  updateUserRes ;
    }



    public static Response deleteUSer(String userName)
    {
        Response deleteUSerRes =given()
                .contentType(ContentType.JSON)
                .pathParam("username",userName)
                .when().delete(Routes.delete_url_user) ;
        return  deleteUSerRes ;
    }


}

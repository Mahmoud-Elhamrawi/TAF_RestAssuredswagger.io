package api.testCase;

import api.endpoints.UserEndPoints;
import api.payload.UserPojo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.*;
import com.github.hemanthsridhar.CSVUtils;
import com.github.hemanthsridhar.lib.ExtUtils;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class UserTest {
    Faker faker = new Faker();;
    UserPojo userPayload;


//
//    @BeforeClass
//    public void setUpData() throws JsonProcessingException {
//        faker = new Faker();
//        userPayload = new UserPojo() ;
//
//
//        /*userPayload.setUsername(faker.name().username());
//        userPayload.setId(faker.idNumber().hashCode());
//        userPayload.setFirstName(faker.name().firstName());
//        userPayload.setLastName(faker.name().lastName());
//        userPayload.setEmail(faker.internet().safeEmailAddress());
//        userPayload.setPassword(faker.internet().password(5,10));
//        userPayload.setPhone(faker.phoneNumber().cellPhone());
//        */
//
//
//    }




    @DataProvider(name = "UserDataCsv")
    public Object [][] provider( ) throws Exception
    {
        String path = "./src\\test\\resources\\userData.csv" ;
        ExtUtils ext = new CSVUtils(path, true);
        return ext.parseData();
    }


    @Test(priority = 0 ,dataProvider = "UserDataCsv")
    public void userPostTest(String username,String firstName,String lastName,String email,String password,String phone) throws JsonProcessingException {
        userPayload = new UserPojo() ;

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(username);
        userPayload.setFirstName(firstName);
        userPayload.setLastName(lastName);
        userPayload.setEmail(email);
        userPayload.setPassword(password);
        userPayload.setPhone(phone);



        Response resPost = UserEndPoints.createUser(this.userPayload) ;
        resPost.prettyPrint() ;
        Assert.assertEquals(resPost.statusCode() , 200);
    }




/*
    @Test(priority = 1)
    public void userReadTest()
    {
     Response resGet = UserEndPoints.getUser(this.userPayload.getUsername()) ;
     resGet.prettyPrint();

     Assert.assertEquals(resGet.statusCode() , 200);
    }

    @Test(priority = 2)
    public void userUpdateTest()
    {
        //update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response resUpdate = UserEndPoints.updateUser(this.userPayload.getUsername() , userPayload) ;
        resUpdate.prettyPrint();

        Assert.assertEquals(resUpdate.statusCode() , 200);


        Response resAfterUpdate = UserEndPoints.getUser(this.userPayload.getUsername()) ;
        resAfterUpdate.prettyPrint() ;
        Assert.assertEquals(resAfterUpdate.statusCode() , 200);



    }

    @Test(priority = 3)
    public void userDeleteTest()
    {
        Response resDelete = UserEndPoints.deleteUSer(this.userPayload.getUsername()) ;
        resDelete.prettyPrint() ;

        Assert.assertEquals(resDelete.statusCode() , 200);
    }
*/

}

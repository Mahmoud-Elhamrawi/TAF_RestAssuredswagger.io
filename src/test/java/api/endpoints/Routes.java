package api.endpoints;

public class Routes {

    public static String base_url ="https://petstore.swagger.io/v2";



    //UserPojo Model
    public static String post_url_user =base_url+"/user";
    public static String get_url_user =base_url+"/user/{username}";
    public static String update_url_user =base_url+"/user/{username}";
    public static String delete_url_user =base_url+"/user/{username}";

    //Pet Model
    public static String post_url_pet =base_url+"/pet";
    public static String get_url_pet =base_url+"/pet/{petId}";
    public static String update_url_pet =base_url+"/pet";
    public static String delete_url_pet =base_url+"/pet/{petId}";

    //Store Model
    public static String post_url_store =base_url+"/store/order";
    public static String get_url_store2 =base_url+"/store/order/{orderId}";
    public static String get_url_store =base_url+"/store/inventory";
    public static String delete_url_store=base_url+"/store/order/{orderId}";





}

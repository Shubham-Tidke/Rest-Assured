import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
public class solution {
	public static void main(String[] args) {
		
	//To get the Authorization code,endpoint auth-server url should be hit using browser,it can also be done using Selenium
	/* Auth-server endpoint : https://accounts.google.com/o/oauth2/v2/auth
	 * /oauthchooseaccount?scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&
	 * auth_url=https%3A%2F%2Faccounts.google.com%2Fo%2Foauth2%2Fv2%2Fauth&
	 * client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&
	 * response_type=code&redirect_uri=https%3A%2F%2Frahulshettyacademy.com%2FgetCourse.php&flowName=GeneralOAuthFlow
	*/	String auth_code = "4%2F0AY0e-g5vPYHf3IIAs0H5OOkuU6j93ox63wTsKbVujI9RjLagB9-mxwJqhT_roh_nm6bStw";
		String accessTokenResponse = given().queryParams("code", auth_code).urlEncodingEnabled(false) //auth code,using which access token is generated
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.when().log().all()
		.post("https://www.googleapis.com/oauth2/v4/token") //hitting access token endpoint with auth code to get access token
		.asString(); 
		//output will be JSON,to get the access token JSON needs to be parsed
		JsonPath path = new JsonPath(accessTokenResponse);
		String accessToken = path.getString("access_token"); //this will be the required access token
		
		
		//Actual Request Test with access_token
		String response = given().queryParam("access_token", accessToken)//access token
		.when().log().all()
		.get("https://rahulshettyacademy.com/getCourse.php")//hitting actual endpoint with access token 
		.asString();//converting raw response in String
		System.out.println(response);
	}
}

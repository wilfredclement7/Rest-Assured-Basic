package alpha;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Car_Serialize {
	public static void main(String[] args) {

		Car_Pojo car = new Car_Pojo();
		car.setMake("Honda");
		car.setModel("City");
		car.setYear(2015);

		Response res = given().log().all().contentType(ContentType.JSON).when().body(car)
				.post("http://localhost:3000/posts").then().extract().response();
		System.out.println("The status code is : " + res.getStatusCode());
		System.out.println("The response is : " + res.as(Car_Pojo.class).getResponse());
	}
}

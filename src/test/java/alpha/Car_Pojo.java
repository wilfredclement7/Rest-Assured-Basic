package alpha;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car_Pojo {

	@JsonProperty("Make")
	private String make;
	@JsonProperty("Model")
	private String model;
	@JsonProperty("Year")
	int year;
	@JsonProperty("Response")
	private String Response;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getResponse() {
		return Response;
	}

	public void setResponse(String response) {
		Response = response;
	}

}

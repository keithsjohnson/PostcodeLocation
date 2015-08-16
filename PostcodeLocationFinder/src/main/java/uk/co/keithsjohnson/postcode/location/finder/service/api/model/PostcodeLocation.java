package uk.co.keithsjohnson.postcode.location.finder.service.api.model;

public class PostcodeLocation {
	private final String postcode;
	private final String latitude;
	private final String longitude;
	private final String population;
	private final String households;

	public PostcodeLocation(String postcode, String latitude, String longitude, String population, String households) {
		super();
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.population = population;
		this.households = households;
	}

	public String getPostcode() {
		return postcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getPopulation() {
		return population;
	}

	public String getHouseholds() {
		return households;
	}

	@Override
	public String toString() {
		return "PostcodeLocation [postcode=" + postcode + ", latitude=" + latitude + ", longitude=" + longitude
				+ ", population=" + population + ", households=" + households + "]";
	}

}

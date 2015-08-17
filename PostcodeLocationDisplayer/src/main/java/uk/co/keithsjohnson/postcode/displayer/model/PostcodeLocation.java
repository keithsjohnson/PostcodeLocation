package uk.co.keithsjohnson.postcode.displayer.model;

import java.io.Serializable;

public class PostcodeLocation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String postcode;

	private String latitude;

	private String longitude;

	public PostcodeLocation() {
	}

	public PostcodeLocation(String postcode, String latitude, String longitude) {
		this.postcode = postcode;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "PostcodeLocation [postcode=" + postcode + ", latitude=" + latitude + ", longitude=" + longitude + "]";
	}

}
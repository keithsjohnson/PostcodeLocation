package uk.co.keithsjohnson.postcode.location.finder.service.api.model;

public class Postcode {
	private String postcode;

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcode() {
		return postcode;
	}

	@Override
	public String toString() {
		return "Postcode [postcode=" + postcode + "]";
	}

}

package uk.co.keithsjohnson.postcode.location.client.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.keithsjohnson.postcode.location.client.api.PostcodeLocationDisplayer;
import uk.co.keithsjohnson.postcode.location.client.model.PostcodeLocation;

@RestController
public class ReceivePostcodeLocationAction {

	@Autowired
	private PostcodeLocationDisplayer postcodeLocationDisplayer;

	@RequestMapping("/displaypostcode")
	public @ResponseBody PostcodeLocation displayPostcode(PostcodeLocation postcodeLocation) {
		System.out.println("Display postcode=" + postcodeLocation.getPostcode() + " longitude="
				+ postcodeLocation.getLongitude() + " latitude=" + postcodeLocation.getLatitude());
		postcodeLocationDisplayer.sendPostcodeLocationForDisplayOnMap(postcodeLocation);
		return postcodeLocation;
	}

}
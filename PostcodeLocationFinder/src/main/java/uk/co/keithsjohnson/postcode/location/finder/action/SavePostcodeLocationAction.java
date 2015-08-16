package uk.co.keithsjohnson.postcode.location.finder.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.keithsjohnson.postcode.location.finder.service.api.PostcodeLocationDetailStorer;
import uk.co.keithsjohnson.postcode.location.finder.service.api.model.PostcodeLocation;

@RestController
public class SavePostcodeLocationAction {

	@Autowired
	private PostcodeLocationDetailStorer postcodeLocationDetailStorer;

	@RequestMapping(value = "/save")
	public @ResponseBody String save(String postcode, String latitude, String longitude, String population,
			String households) {

		PostcodeLocation postcodeLocation = new PostcodeLocation(postcode, latitude, longitude, population, households);

		postcodeLocationDetailStorer.storePostcodeLocationDisplay(postcodeLocation);

		return "OK";
	}
}

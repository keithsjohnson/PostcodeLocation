package uk.co.keithsjohnson.postcode.location.client.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.keithsjohnson.postcode.location.client.api.StoreProvider;

@RestController
public class UploadFileAction {

	@Autowired
	private StoreProvider storeProvider;

	@RequestMapping(value = "/upload")
	public @ResponseBody String upload(String key, String filename) {

		storeProvider.store(key, filename);

		return "OK";
	}

}

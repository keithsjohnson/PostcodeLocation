package uk.co.keithsjohnson.postcode.location.request.receiver.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import uk.co.keithsjohnson.postcode.location.request.receiver.infrastructure.sqs.PostcodeLocationFinderQueueSender;

@RestController
public class ReceivePostcodeForDisplayAction {

	@Autowired
	private PostcodeLocationFinderQueueSender postcodeLocationFinderQueueSender;

	@RequestMapping(value = "/postcode")
	public @ResponseBody String postcode(String postcode) {

		postcodeLocationFinderQueueSender.send(postcode);

		return "OK";
	}
}

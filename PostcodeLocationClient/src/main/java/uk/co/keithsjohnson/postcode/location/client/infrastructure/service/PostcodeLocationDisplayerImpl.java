package uk.co.keithsjohnson.postcode.location.client.infrastructure.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import uk.co.keithsjohnson.postcode.location.client.api.PostcodeLocationDisplayer;
import uk.co.keithsjohnson.postcode.location.client.model.PostcodeLocation;

@Component
public class PostcodeLocationDisplayerImpl implements PostcodeLocationDisplayer {

	@Autowired
	SimpMessagingTemplate messaging;

	@Override
	public void sendPostcodeLocationForDisplayOnMap(PostcodeLocation postcodeLocation) {
		final Map<String, String> msg = new HashMap<>();
		msg.put("postcode", postcodeLocation.getPostcode());
		msg.put("latitude", postcodeLocation.getLatitude());
		msg.put("longitude", postcodeLocation.getLongitude());
		this.messaging.convertAndSend("/topic/postcodemap", msg);
	}

}

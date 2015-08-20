package uk.co.keithsjohnson.postcode.location.client.infrastructure.service;

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
		this.messaging.convertAndSend("/topic/postcodemap", postcodeLocation);
	}

}

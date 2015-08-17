package uk.co.keithsjohnson.postcode.displayer.action;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.keithsjohnson.postcode.displayer.model.PostcodeLocation;

@Controller
@Component
public class DisplayAddress {

	@Autowired
	SimpMessagingTemplate messaging;

	@RequestMapping("/displaypostcode")
	// @SendTo("/topic/postcodemap")
	public @ResponseBody PostcodeLocation displayPostcode(PostcodeLocation postcodeLocation) {
		System.out.println("Display postcode=" + postcodeLocation.getPostcode() + " longitude="
				+ postcodeLocation.getLongitude() + " latitude=" + postcodeLocation.getLatitude());
		sendAddressMessageToWebSocket(postcodeLocation);
		return postcodeLocation;
	}

	private void sendAddressMessageToWebSocket(PostcodeLocation postcodeLocation) {
		final Map<String, String> msg = new HashMap<>();
		msg.put("postcode", postcodeLocation.getPostcode());
		msg.put("latitude", postcodeLocation.getLatitude());
		msg.put("longitude", postcodeLocation.getLongitude());
		this.messaging.convertAndSend("/topic/postcodemap", msg);
	}

}
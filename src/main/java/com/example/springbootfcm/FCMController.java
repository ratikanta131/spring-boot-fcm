package com.example.springbootfcm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FCMController {
	
	@Autowired
	private FCMService fcmService;

	@PostMapping("sendToOne")
	public String sendToOne(@RequestBody FCMModel model) {
		return fcmService.sendToOne(model);
	}
	
	@PostMapping("sendToTopic")
	public String sendToTopic(@RequestBody FCMModel model) {
		return fcmService.sendToTopic(model);
	}
	
	@PostMapping("/subscribeToTopic")
    public String subscribeToTopic(@RequestBody FCMSubscribeModel model) {
		return fcmService.subscribeToTopic(model);
    }
	
	@PostMapping("/unsubscribeFromTopic")
    public String unsubscribeFromTopic(@RequestBody FCMSubscribeModel model) {
		return fcmService.unsubscribeFromTopic(model);
    }
}

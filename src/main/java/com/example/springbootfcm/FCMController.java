package com.example.springbootfcm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FCMController {
	
	@Autowired
	private FCMService fcmService;
	
	
	@PostMapping("register")
    public String resister(@RequestBody FCMRegisterModel model) {
		return fcmService.register(model);
    }

	@PostMapping("sendToOne")
	public String sendToOne(@RequestBody FCMModel model) {
		return fcmService.sendToOne(model);
	}
	
	@PostMapping("sendToTopic")
	public String sendToTopic(@RequestBody FCMModel model) {
		return fcmService.sendToTopic(model);
	}
	
	@PostMapping("subscribeToTopic")
    public String subscribeToTopic(@RequestBody FCMSubscribeModel model) {
		return fcmService.subscribeToTopic(model);
    }
	
	@PostMapping("unsubscribeFromTopic")
    public String unsubscribeFromTopic(@RequestBody FCMSubscribeModel model) {
		return fcmService.unsubscribeFromTopic(model);
    }
	
	@GetMapping("getAllUsers")
	public List<FCMRegisterModel> getAllUsers(){
		return fcmService.getAllUsers();
	}
	
}

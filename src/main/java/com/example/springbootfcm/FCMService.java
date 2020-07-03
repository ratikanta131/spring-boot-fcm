package com.example.springbootfcm;

import java.util.List;

public interface FCMService {
	
	String register(FCMRegisterModel model);
	
	List<FCMRegisterModel> getAllUsers();
	
	String sendToOne(FCMModel model);
	
	String sendToTopic(FCMModel model);
	
	String subscribeToTopic(FCMSubscribeModel model);
	
	String unsubscribeFromTopic(FCMSubscribeModel model);
	
	

}

package com.example.springbootfcm;

public interface FCMService {
	
	String sendToOne(FCMModel model);
	
	String sendToTopic(FCMModel model);
	
	String subscribeToTopic(FCMSubscribeModel model);
	
	String unsubscribeFromTopic(FCMSubscribeModel model);

}

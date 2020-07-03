package com.example.springbootfcm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;

@Service
public class FCMServiceImpl implements FCMService {
	
	
	final List<FCMRegisterModel> users = new ArrayList<>(); 
	
	@Override
	public String register(FCMRegisterModel model) {
		users.add(model);
		return "success";
	}
	
	@Override
	public List<FCMRegisterModel> getAllUsers() {
		return users;
	}

	@Override
	public String sendToOne(FCMModel model) {
		Message message = Message.builder()
                .setToken(model.getTo())
                .setNotification(Notification.builder().setTitle(model.getTitle()).setBody(model.getBody()).build())
                .putData("content", model.getTitle())
                .putData("body", model.getBody())
                .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
        	SpringbootfcmApplication.logger.error("Fail to send firebase notification", e);
        }

        return response;
	}

	@Override
	public String sendToTopic(FCMModel model) {
		Message message = Message.builder()
                .setTopic(model.getTo())
                .setNotification(Notification.builder().setTitle(model.getTitle()).setBody(model.getBody()).build())
                .putData("content", model.getTitle())
                .putData("body", model.getBody())
                .build();

        String response = null;
        try {
            response = FirebaseMessaging.getInstance().send(message);
        } catch (FirebaseMessagingException e) {
        	SpringbootfcmApplication.logger.error("Fail to send firebase notification", e);
        }

        return response;
	}

	@Override
	public String subscribeToTopic(FCMSubscribeModel model) {
		try {
            FirebaseMessaging.getInstance().subscribeToTopic(Arrays.asList(model.getToken()), model.getTopic());
            return "success";
        } catch (FirebaseMessagingException e) {
        	SpringbootfcmApplication.logger.error("Firebase subscribe to topic fail", e);
        	return "error";
        }
	}
	
	@Override
	public String unsubscribeFromTopic(FCMSubscribeModel model) {
		try {
            FirebaseMessaging.getInstance().unsubscribeFromTopic(Arrays.asList(model.getToken()), model.getTopic());
            return "success";
        } catch (FirebaseMessagingException e) {
        	SpringbootfcmApplication.logger.error("Firebase unsubscribe from topic fail", e);
        	return "error";
        }
	}

}

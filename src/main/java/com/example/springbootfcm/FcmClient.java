package com.example.springbootfcm;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FcmClient {
	
	

	public FcmClient(FcmSettings settings) {
		Path p = Paths.get(settings.getServiceAccountFile());
		try (InputStream serviceAccount = Files.newInputStream(p)) {
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

			FirebaseApp.initializeApp(options);
			SpringbootfcmApplication.logger.info("FCM initialized succesfully.");
		}
		catch (IOException e) {
			SpringbootfcmApplication.logger.error("init fcm", e);
		}
	}
}

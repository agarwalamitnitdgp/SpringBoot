package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.foo.NotificationService;

@RestController
public class PageController {

	@Autowired
	NotificationService notificationService;
	
	/*@Autowired
	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}*/

	/*@Autowired
	public PageController(NotificationService notificationService) {
		this.notificationService = notificationService;
	}*/

	/*@RequestMapping("/")
	public String home() {
		return notificationService.toString();
	}*/
	
	@Value("${pageController.msg}")
	private String pageControllerMsg;
	
	@Value("${app.description}")
	private String app;
	
	@RequestMapping("/")
	public String home() {
		return app;
	}
}

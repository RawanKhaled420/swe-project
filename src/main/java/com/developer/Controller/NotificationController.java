package com.developer.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.developer.entities.Notification;
import com.developer.repository.NotificationRepository;
import com.developer.repository.UserRepository;;

@Controller
public class NotificationController {
	@Autowired
	private NotificationRepository notificationRepository;
	private UserRepository  userRepository;
	
	@GetMapping("/showNotification")
	@ResponseBody
	public List<Notification> ShowNotification (@RequestParam("UserID") int userID)
	{
		List<Notification> notificationList =  notificationRepository.getNotificationrequestId2(userID);
		notificationRepository.delete(notificationList);
		return notificationList;
	}
}

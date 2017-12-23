package com.developer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.developer.entities.Friend;
import com.developer.entities.Notification;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer>
{
	@Query("SELECT n FROM Notification n WHERE (:userID is null or n.userID = :userID) ")
	 public List<Notification> getNotificationrequestId2(@Param("userID") Integer userID ); 
}

	
	



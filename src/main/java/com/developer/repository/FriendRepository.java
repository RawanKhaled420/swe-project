package com.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.developer.entities.Friend;
import com.developer.entities.User;


import java.util.List ; 

@Repository
public interface FriendRepository extends JpaRepository<Friend, Integer>
{
	@Query("SELECT f FROM Friend f WHERE f.friend_one = :id1 AND f.friend_two = :id2 AND f.status = :status")
	public Friend findById1(@Param("id1") int id1, @Param("id2") int id2, @Param("status") String status);


@Query("SELECT f FROM Friend f WHERE (:id2 is null or f.friend_two = :id2) AND (f.status LIKE CONCAT('PENDING')) ")
	 public List<Friend> getfriendrequestId2(@Param("id2") Integer id2 ); 
}


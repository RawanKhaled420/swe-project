package com.developer.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.developer.entities.FriendshipStatus;
import com.developer.entities.Friend;
import com.developer.entities.User;
import com.developer.repository.FriendRepository;
import com.developer.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	 
	private FriendRepository friendRepository;

	@GetMapping("/addfriend")
	public String showAddFriend(Model model) {
		return "addfriend";
	}
	
	@GetMapping("/notification")
	public String showNotification(Model model) {
		return "notification";
	}

	@PostMapping("/addfriend")
	public String addfriend(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		Friend f = new Friend(id1, id2, FriendshipStatus.PENDING);
		friendRepository.save(f);
		
		return "addfriend";
	}
	
	@PostMapping("/acceptfriend")
	public boolean acceptfriend(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		Friend f =  friendRepository.findById1(id2, id1, FriendshipStatus.PENDING.toString());
		f.setStatus(FriendshipStatus.ACCEPTED);
		friendRepository.save(f);
		return true;
	}
	@GetMapping("/showrequest_friend")
	public List<User> showrequest_friend( @RequestParam("id2") int id2) {
		List<Friend> friendRequrstList =  friendRepository.getfriendrequestId2(id2);
		List<User> friendList = new ArrayList();
		for (int i=0 ; i <friendRequrstList.size();i++ )
		{
			Friend f = friendRequrstList.get(i);
			User friend = this.userRepository.getOne(f.getFriend_one());
			friendList.add(friend);
		}
		
		return friendList;

		
		
		
	}
	
	
	
	@PostMapping("/ignorefriend")
	public boolean ignorefriend(@RequestParam("id1") int id1, @RequestParam("id2") int id2) {
		Friend f =  friendRepository.findById1(id2, id1, FriendshipStatus.PENDING.toString());
		/*f.setStatus(FriendshipStatus.IGNORED); */
		friendRepository.delete(f);
		return true;
	}
	
	
	

	/*
	 * @PostMapping("/addfriend") public String addfriend(Model
	 * model,@ModelAttribute users users) {
	 * System.out.println(com.developer.entities.users .getUsername());
	 * System.out.println(users .getUserID()); model.addAttribute("friend",new
	 * users());
	 * 
	 * return "r" ; }
	 */
//	public String profile() {
//		User.getUsername();
//		User.getEmail();
//		// users.getUserID() ;
//		return "";
//	}

}

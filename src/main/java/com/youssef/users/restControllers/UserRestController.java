package com.youssef.users.restControllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.youssef.users.entities.User;
import com.youssef.users.entities.Role;
import com.youssef.users.mail.EmailSenderService;
import com.youssef.users.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class UserRestController {
	@Autowired
	UserService userService;
	@Autowired
	EmailSenderService emailService;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(path = "all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.findAllUsers();
	}
	@GetMapping("/exists/{email}")
    public boolean checkUserExists(@PathVariable String email) {
        return userService.hasUserWithEmail(email);
    }
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {
		
		List<Role> roles = new ArrayList<>();

	    Role r = new Role();
	    r.setRole("USER");
	    roles.add(r);
	    user.setEnabled(true);
	    user.setRoles(roles);
	    
		userService.saveUser(user);
        return ResponseEntity.ok("User added successfully!");
    }

	@PostMapping("/register/{email}")
	public ResponseEntity<Map<String, String>> registerUser(@PathVariable String email) {
	    
	        // Send verification email and get the generated token
	        String verificationToken = emailService.sendVerificationEmail(email);
	        System.out.println("Email sent successfully. Verification token: " + verificationToken);
	        Map<String, String> response = new HashMap<>();
	        response.put("message", "Verification token sent to email");
	        response.put("token", verificationToken);

	        return ResponseEntity.ok(response);
	    }
	}
	



package dataAndroidNauAn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.userDTO;
import dataAndroidNauAn.service.impl.UserService;

@RestController
public class userAPI {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user")
	public userDTO createUser(@RequestBody userDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/user")
	public userDTO getUser(@RequestParam("userName") String userName) {
		return service.getUser(userName);
	}
	
}

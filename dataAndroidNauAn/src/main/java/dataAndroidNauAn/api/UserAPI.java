package dataAndroidNauAn.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.service.impl.UserService;

@RestController
public class UserAPI {

	@Autowired
	private UserService service;
	
	@PostMapping(value = "/user")
	public UserDTO createUser(@RequestBody UserDTO model) {
		return service.save(model);
	}
	
	@GetMapping(value = "/user")
	public UserDTO getUser(@RequestParam("userName") String userName) {
		return service.getUser(userName);
	}
	
}

package dataAndroidNauAn.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dataAndroidNauAn.dto.UserDTO;
import dataAndroidNauAn.service.impl.UserService;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/register")
    public UserDTO register(@RequestBody UserDTO user){
        user.setPassWord(new BCryptPasswordEncoder().encode(user.getPassWord()));
        return userService.save(user);
    }
}
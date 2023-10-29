package digital.osf.hackazillians.controller;

import digital.osf.hackazillians.dto.UserDto;
import digital.osf.hackazillians.entities.User;
import digital.osf.hackazillians.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;
    @PostMapping
    public User createUser(@RequestBody UserDto user){
        return service.createUser(user);
    }
}

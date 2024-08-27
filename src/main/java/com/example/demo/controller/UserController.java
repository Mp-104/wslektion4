package com.example.demo.controller;

import com.example.demo.user.MyUser;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final List<MyUser> userList = new ArrayList<>(100);

    @GetMapping()
    public List<MyUser> getAllUsers() {
        return userList;
    }

    @PostMapping("/{username}")
    public boolean postUser(@PathVariable("username")
                            String username) {
        return userList.add(
                new MyUser(userList.size(),
                        username, "password", true)
        );
    }

    @PostMapping("/add")
    public MyUser addUser(@RequestParam(defaultValue = "name") String
                                username) {
        MyUser user = new MyUser(userList.size(),
                username, "pass", true);
        userList.add(user);

        return user;
    }

}

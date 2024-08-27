package com.example.demo.controller;

import com.example.demo.user.MyUser;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class MyController {

    private final List<MyUser> userList = new ArrayList(
            List.of(
            new MyUser(1, "Lenny", "password", true)
            )
    );

    @GetMapping
    public List<MyUser> getUser () {

        return userList;
    }

    @PostMapping("/{username}/{password}")
    public boolean postUser (@PathVariable("username") String username, @PathVariable("password") String password) {

        return userList.add(new MyUser(userList.size() + 1, username, password, true));
    }

    @DeleteMapping("/{id}")
    public MyUser deleteUserById (@PathVariable("id") int id) {

        for (MyUser user : userList) {

            if (user.id() == id) {
                return userList.remove(id);
            }

        }

        return null;

    }


}

package com.shamil.insure.insure.Controller;

import com.shamil.insure.insure.Models.User;
import com.shamil.insure.insure.Services.UserService;
import com.shamil.insure.insure.Utils.GenerateID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUserByPID(id), HttpStatus.OK);
    }

    @GetMapping("/getCount")
    public ResponseEntity<Map<String, Integer>> getUsersCount() {
        Map<String, Integer> m = new HashMap<>();
        m.put("count", userService.getUsers().size());
        return new ResponseEntity<>(m, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> addUser(@RequestBody User user) {

        if (userService.getUserByPID(user.getpID()) == null) {
            GenerateID g = new GenerateID();
            String InsID = "";
            do {
                InsID = g.generateInsID();
                user.setInsID(InsID);
            }
            while (userService.getUserByInsID(InsID) != null);

            return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }

    }


}

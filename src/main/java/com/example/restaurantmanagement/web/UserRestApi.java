package com.example.restaurantmanagement.web;

import com.example.restaurantmanagement.entities.User;
import com.example.restaurantmanagement.exceptions.UserNotFoundException;
import com.example.restaurantmanagement.repositories.UserRepository;
import com.example.restaurantmanagement.services.UserService;
import com.example.restaurantmanagement.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class UserRestApi {

    private UserService userService;

    /*public UserRestApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/

    @GetMapping("/users")
    public List<User> users(){
        return  userService.getUsers();
    }

    @GetMapping("user/{id}")
    public User getUser(@PathVariable(name = "id") Long userId) throws UserNotFoundException {
        return userService.getUser(userId);
    }

    @PostMapping("/createUser")
    public User saveUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/updateUser/{userId}")
    public User updateUser(@PathVariable Long userId,@RequestBody User user){
        user.setId(userId);
        return userService.updateUser(user);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().body("User deleted successfuly");
    }

    @PostMapping("/connect")
    public ResponseEntity<User> isUser(@RequestBody User user){
        log.info(user.getPassword());
        User user1 = userService.isUser(user.getEmail(), user.getPassword());
        if(user1 == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user1);
    }



}

package com.example.dataDemo.controller;
import com.example.dataDemo.bo.CreateUserRequest;
import com.example.dataDemo.bo.UserResponse;
import com.example.dataDemo.entity.Status;
import com.example.dataDemo.entity.UserEntity;
import com.example.dataDemo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userService.getALLUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        UserResponse response = userService.createUser(request);

        if (response != null) {
            // Return a 201 Created status code along with the created user data
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/updateStatus")
    public ResponseEntity<UserResponse> updateUserStatus(@RequestParam Long userId, @RequestParam String status) {
        UserResponse response = userService.updateUserStatus(userId, status);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/searchUsers")
    public ResponseEntity<List<UserEntity>> searchUsers(@RequestParam String status) {
        List<UserEntity> response = userService.searchUser(status);
        if (response != null) {
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}

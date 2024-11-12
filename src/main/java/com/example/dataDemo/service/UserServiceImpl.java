package com.example.dataDemo.service;

import com.example.dataDemo.entity.Status;
import com.example.dataDemo.entity.UserEntity;
import com.example.dataDemo.repository.UserRepository;
import com.example.dataDemo.bo.CreateUserRequest;
import com.example.demo.bo.UserResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserEntity> getALLUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse createUser(CreateUserRequest request) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(request.getName());
        userEntity.setStatus(Status.valueOf(request.getStatus()));
        userEntity = userRepository.save(userEntity);
        UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(),userEntity.getStatus().toString());

        return response;
    }
    @Override
    public UserResponse updateUserStatus(Long id, String status) {
        if (status.equalsIgnoreCase("Active") || status.equalsIgnoreCase("Inactive")) {
            UserEntity userEntity = userRepository.findById(id).orElse(null);
            userEntity.setStatus(Status.valueOf(status.toUpperCase()));
            userEntity = userRepository.save(userEntity);
            UserResponse response = new UserResponse(userEntity.getId(), userEntity.getName(), userEntity.getStatus().toString());
            return response;
        }
        else {
            throw new IllegalArgumentException("Invalid status!!!");
        }
    }

    @Override
    public List<UserEntity> searchUser(String status) {
        List<UserEntity> filteredUsers = new ArrayList<>();
        for (UserEntity userEntity : userRepository.findAll()) {
            if (userEntity.getStatus().toString().equalsIgnoreCase(status.toUpperCase())) {
                filteredUsers.add(userEntity);
            }
        }
        return filteredUsers;
    }




}//end of class

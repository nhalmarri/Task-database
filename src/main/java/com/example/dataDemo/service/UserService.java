package com.example.dataDemo.service;

import com.example.dataDemo.entity.UserEntity;
import   com.example.demo.bo.UserResponse;
import com.example.dataDemo.bo.CreateUserRequest;


import java.util.List;

public interface UserService {

  List<UserEntity> getALLUsers();
  UserResponse updateUserStatus(Long id,String status);
  UserResponse createUser( CreateUserRequest request);

  List<UserEntity> searchUser(String status);
}//end of class

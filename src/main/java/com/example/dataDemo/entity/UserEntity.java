package com.example.dataDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "User_entity")
public class UserEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String name;
   private Status status;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Status getStatus() {
        return status;
    }

    //Is this how the  setting suppose to be or should i set the variable to inActive ?
    public void setStatus(Status status) {
        this.status = Status.Inactive;
    }


}//end of class

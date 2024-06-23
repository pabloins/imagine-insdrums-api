package com.insdrums.imagine_api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegisteredUser implements Serializable {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String Role;
    private String jwt;
}

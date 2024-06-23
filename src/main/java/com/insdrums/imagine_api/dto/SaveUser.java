package com.insdrums.imagine_api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SaveUser implements Serializable {
    private String name;
    private String username;
    private String email;
    private String password;
    private String repeatedPassword;
}

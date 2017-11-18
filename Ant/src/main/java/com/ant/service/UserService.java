package com.ant.service;

/**
 * <p>
 * Created by doublehuang.
 */

public interface UserService {

    String loginUser(String username, String password);

    String registerUser(String username, String password, String email);

    boolean isUserExists(String username);

}

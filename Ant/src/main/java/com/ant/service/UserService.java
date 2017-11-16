package com.ant.service;

/**
 * <p>
 * Created by doublehuang.
 */

public interface UserService {

    boolean isUsernameAndPasswordCorrect(String username, String password);

    boolean registerUser(String username, String password, String email);

    boolean isUserExists(String username);

}

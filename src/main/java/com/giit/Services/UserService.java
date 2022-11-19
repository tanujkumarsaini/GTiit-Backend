package com.giit.Services;

import java.util.List;

import com.giit.Models.User;
import com.giit.payload.UserDto;

public interface UserService {
UserDto saveUser(UserDto userDto);
UserDto updateUser(int userId,UserDto newUserDto);
UserDto getUserById(int userId);
UserDto getUserByEmail(String userEmail);
List<UserDto> getAllUsers();
void deleteUser(String userEamil);
}

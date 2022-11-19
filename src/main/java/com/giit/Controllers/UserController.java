package com.giit.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giit.Services.UserService;
import com.giit.payload.UserDto;

@RestController
public class UserController {
@Autowired
private UserService userService;	

@PostMapping("/users/")
public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto){
	UserDto savedUser = this.userService.saveUser(userDto);
	return new ResponseEntity<UserDto>(savedUser,HttpStatus.OK);
}

@GetMapping("/users/")
public ResponseEntity<List<UserDto>> getAllUsers(){
	List<UserDto> allUsers = this.userService.getAllUsers();
	return new ResponseEntity<List<UserDto>>(allUsers,HttpStatus.OK);
}

@GetMapping("/users/{userId}")
public ResponseEntity<UserDto> getUser(@PathVariable Integer userId){
	UserDto userDto = this.userService.getUserById(userId);
	return new ResponseEntity<UserDto> (userDto,HttpStatus.OK);
}

@PutMapping("/users/{userId}")
public ResponseEntity<UserDto> updateUser(@PathVariable Integer userId,@RequestBody UserDto userDto){
UserDto updatedUser = this.userService.updateUser(userId, userDto);	
return new ResponseEntity<UserDto>(updatedUser,HttpStatus.OK);
}


}

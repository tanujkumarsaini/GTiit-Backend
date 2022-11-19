package com.giit.ServicesImpl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.giit.Exception.ResourceNotFoundException;
import com.giit.Models.Role;
import com.giit.Models.User;
import com.giit.Repositories.RoleRepository;
import com.giit.Repositories.UserRepository;
import com.giit.Services.UserService;
import com.giit.payload.UserDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public UserDto saveUser(UserDto userDto) {
		
		String encodedPassword = this.passwordEncoder.encode(userDto.getPassword());
		
		Role studentRole = this.roleRepository.findById(11).orElseThrow(()->new ResourceNotFoundException("Role not found with this id"));
		Set<Role> roles=new HashSet<>();
		roles.add(studentRole);
		
		User user = this.modelMapper.map(userDto, User.class);
		user.setCreatedAt(new Date());
		user.setRoles(roles);
		user.setPassword(encodedPassword);
        User savedUser = this.userRepository.save(user);
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(int userId, UserDto newUserDto) {
		User oldUser = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found on server"));
		oldUser.setFirstName(newUserDto.getFirstName());
		oldUser.setLastName(newUserDto.getLastName());
		oldUser.setEmail(newUserDto.getEmail());
		oldUser.setPhone(newUserDto.getPhone());
		oldUser.setGender(newUserDto.getGender());
		oldUser.setDob(newUserDto.getDob());
		User updatedUser = this.userRepository.save(oldUser);
		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(int userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()->  new ResourceNotFoundException());
		return this.modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto getUserByEmail(String userEmail) {
	
		return null;
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> allUsers = this.userRepository.findAll();
		List<UserDto> allUsersDtos = allUsers.stream().map((user)->this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
		return allUsersDtos;
	}

	@Override
	public void deleteUser(String userEamil) {
		
		
	}

}

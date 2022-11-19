package com.giit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.giit.Models.Role;
import com.giit.Models.User;
import com.giit.Repositories.RoleRepository;
import com.giit.Repositories.UserRepository;

@SpringBootApplication
public class GiitBackendApplication implements CommandLineRunner{

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(GiitBackendApplication.class, args);
	}

	
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}




	@Override
	public void run(String... args) throws Exception {
	try {
	Role role1=new Role();
	role1.setId(11);
	role1.setName("ROLE_ADMIN");
	
	Role role2=new Role();
	role2.setId(21);
	role2.setName("ROLE_TEACHER");
	
	Role role3=new Role();
	role3.setId(31);
	role3.setName("ROLE_STUDENT");
	
	List<Role> roles=new ArrayList<>(); 
	roles.add(role1);
	roles.add(role2);
	roles.add(role3);
	this.roleRepository.saveAll(roles);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	
	try {
		User user2 = this.userRepository.findById(2).orElseThrow(null);
		User user3 = this.userRepository.findById(3).orElseThrow(null);
		
		User user4=new User();
	    user4.setId(1);
		
		Set<User> users=new HashSet<>();
		users.add(user2);
		users.add(user3);
		users.add(user4);
		
		Role role=new Role();
		role.setId(34);
		role.setName("temp2");
		role.setUsers(users);
		this.roleRepository.save(role);
	}
	catch(Exception e1)
	{
		System.out.println(e1);
	}
	
	}
	
}

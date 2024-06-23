package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.dto.request.UserRequestDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

//bean:application context <- rest
@RestController
@RequestMapping("/user")
public class UserController {

	@PostMapping(value = "/" )//headers = "apiKey=v1.0")
	//@RequestMapping(method = RequestMethod.POST, path = "/", headers = "apiKey=v1.0")
	public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {
		return "User added";
	}
	
	@PutMapping("/{userId}")
	public String updateUser(@PathVariable("userId") int id, @Valid @RequestBody UserRequestDTO userDTO) {
		System.out.println("Request Update user with id = " + id);
		return "User updated";
	}
	
	//update part
	@PatchMapping("/{userId}")
	public String changeStatus(@Min(1) @PathVariable int userId,
			@RequestParam(required = false) @Min(1) int status) {
		System.out.println("Request change user status, userId = " + userId);
		return "User status changed";
	}
	
	@DeleteMapping("/{userId}")
	public String deleteUser(@Min(1) @PathVariable int userId) {
		System.out.println("Request delete User with id = " + userId);
		return "User deleted";
	}
	
	@GetMapping("/{userId}")
	public UserRequestDTO getUser(@PathVariable int userId) {
		System.out.println("Request get Userdetail by userId = " + userId);
		return new UserRequestDTO("Nguyen", "Nghia", "phone", "0321321");
	}
	
	@GetMapping("/list")
	public List<UserRequestDTO> getAllUser(@RequestParam(required = false) String email,//co the nhap ork 
			                               @RequestParam(defaultValue = "0") int pageNo,
			                               @RequestParam(defaultValue = "10") int pageSize){
		System.out.println("Request get all User Detail");
		return List.of(
				new UserRequestDTO("java", "core", "pho", "123"),
				new UserRequestDTO("C", "++", "phone", "123"));
	}
}

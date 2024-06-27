package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.demo.configuration.Translator;
import com.example.demo.dto.request.UserRequestDTO;
import com.example.demo.dto.response.ResponseData;
import com.example.demo.dto.response.ResponseError;
import com.example.demo.dto.response.ResponseSuccess;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;

//bean:application context <- rest
@RestController
@RequestMapping("/user")
@Validated
public class UserController {
	
	//@RequestMapping(method = RequestMethod.POST, path = "/", headers = "apiKey=v1.0")
	//@ResponseStatus(value = HttpStatus.CREATED)
//	@Operation(summary = "summary", description = "description",
//			responses = {@ApiResponse(responseCode = "201", description = "User added successfully",
//			content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
//			examples = @ExampleObject(name = "ex name", summary = "ex summary",
//			value = """
//					 {
//					   "status" : 201,
//					   "message" : "User added successfully",
//					   "data" : 1
//					 }
//					"""
//			)))})
	@PostMapping(value = "/" )//headers = "apiKey=v1.0")
	public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userDTO) {
		System.out.println("Request add user: " + userDTO.getFirstName());
		//return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Cannot create user");
		return new ResponseData<>(HttpStatus.CREATED.value(), Translator.toLocale("user.add.success"), 1);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseData<?> updateUser(@Min(value = 1, message = "userId must be greater than 0") 
	              @PathVariable("userId") int id, @Valid @RequestBody UserRequestDTO userDTO) {
		System.out.println("Request Update user with id = " + id);
		return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
	}
	
	//update part
	@PatchMapping("/{userId}")
	public ResponseData<?> changeStatus(@Min(1) @PathVariable int userId,
			@RequestParam int status) {
		System.out.println("Request change user status, userId = " + userId);
		return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User status changed");
	}
	
	@DeleteMapping("/{userId}")
	public ResponseData<?> deleteUser(@Min(value = 1, message = "userId must be greater than 0")
			@PathVariable int userId) {
		System.out.println("Request delete User with id = " + userId);
		return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted");
	}
	
	@GetMapping("/{userId}")
	public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {
		System.out.println("Request get Userdetail by userId = " + userId);
		return new ResponseData<>(HttpStatus.OK.value(), "User", 
				new UserRequestDTO("Nguyen", "Nghia", "emg@gmail.com", "0123465789"));
	}
	
	@GetMapping("/list")
	public ResponseData<List<UserRequestDTO>> getAllUser(@RequestParam(required = false) String email,//co the nhap ork 
			                               @RequestParam(defaultValue = "0", required = false) int pageNo,
			                              @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize){
		System.out.println("Request get all User Detail");
		return new ResponseData<>(HttpStatus.OK.value(), "Users", 
			   List.of(new UserRequestDTO("Nguyen", "Nghia", "emg@gmail.com", "0123465789"),
					   new UserRequestDTO("Tai", "Quan", "eggs@gmail.com", "123-345-9993")));
	}
}

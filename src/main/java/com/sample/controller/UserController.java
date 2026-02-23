package com.sample.controller;

import java.util.List;

import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sample.entity.ReqBody;
import com.sample.entity.User;
import com.sample.entity.UserCredentialsDTO;
import com.sample.entity.UserDTO;
import com.sample.entity.UserDTO2;

import com.sample.entity.UsernameDTO;
import com.sample.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;
  
  @GetMapping
  public List<User> getAllUsers() {
      return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id) {
      return userService.getUserById(id)
              .map(ResponseEntity::ok)
              .orElse(ResponseEntity.notFound().build());
  }

//  @PostMapping("/adduserdata")
//  public User createUser(@RequestBody User user) {
//      return userService.createUser(user);
//  }
  
  @PostMapping("/add-user-with-company")
  public ResponseEntity<User> addUser(@RequestBody User userDetails) {
      User user = userService.addUserWithCompany(userDetails);
      return ResponseEntity.ok(user);
  }


  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
      try {
          return ResponseEntity.ok(userService.updateUser(id, userDetails));
      } catch (RuntimeException e) {
          return ResponseEntity.notFound().build();
      }
  }

  @DeleteMapping("deleteuser/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
      userService.deleteUser(id);
      return ResponseEntity.noContent().build();
  }

@GetMapping("/checkusername/{username}")
public ResponseEntity<String> checkUsernameExists(@PathVariable String username) {
    boolean exists = userService.checkUsernameExists(username);
    if (exists) {
        return ResponseEntity.ok("Username exists");
    } else {
        return ResponseEntity.status(404).body("Username does not exist");
    }
}
  
  // To check whether the given username is exist in db or not
  @PostMapping("/checkusername")
  public ResponseEntity<String> checkUsernameExists(@RequestBody Map<String, String> requestBody) {
      String username = requestBody.get("username");
      if (username == null || username.isEmpty()) {
          return ResponseEntity.badRequest().body("Username is required");
      }
      
      boolean exists = userService.checkUsernameExists(username);
      if (exists) {
          return ResponseEntity.ok("Username exists");
      } else {
          return ResponseEntity.status(404).body("Username does not exist");
      }
  }



  // Other methods...

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody ReqBody reqbody ) {
  	System.out.print(reqbody.username+reqbody.password);
      String result = userService.validateUserCredentials(reqbody.username,reqbody.password);
      if (result.equals("Login successful")) {
          return ResponseEntity.ok(result);
      } else {
          return ResponseEntity.status(401).body(result);  // 401 Unauthorized for invalid credentials
      }
  }
  
  @GetMapping("/getuserid/{username}")
  public ResponseEntity<?> getUserIdByUsername(@PathVariable String username) {
      Optional<Long> userIdOptional = userService.getUserIdByUsername(username);

      if (userIdOptional.isPresent()) {
          return ResponseEntity.ok().body(Map.of("userId", userIdOptional.get()));
      } else {
          return ResponseEntity.status(404).body("User not found");
      }
  }

  @PostMapping("/getuserid")
  public ResponseEntity<?> getUserIdByUsername(@RequestBody Map<String, String> request) {
      String username = request.get("username");
      if (username == null || username.isEmpty()) {
          return ResponseEntity.badRequest().body("Username is required");
      }
      
      Optional<Long> userIdOptional = userService.getUserIdByUsername(username);
      
      if (userIdOptional.isPresent()) {
          return ResponseEntity.ok().body(Map.of("userId", userIdOptional.get()));
      } else {
          return ResponseEntity.status(404).body("User not found");
      }
  }
  @GetMapping("/user/{userId}/details")
  public Map<String, Object> getUserDetails(@PathVariable Long userId) {
      return userService.getUserDetails(userId);
  }
  @PostMapping("/user/details")
  public Map<String, Object> getUserDetails(@RequestBody Map<String, Long> request) {
      Long userId = request.get("userId");
      return userService.getUserDetails(userId);
  }
  
  //user table
  
  @GetMapping("/allusercredentials")
  public List<UserCredentialsDTO> getAllUserCredentials() {
      return userService.getAllUserCredentials();
  }
  
  @PostMapping("/addusercredentials")
  public ResponseEntity<User> addUser(@RequestBody UserCredentialsDTO userCredentialsDTO) {
      User newUser = userService.addUser(userCredentialsDTO);
      return ResponseEntity.ok(newUser);
  }

  @DeleteMapping("/deleteuserbased/{id}")
  public ResponseEntity<String> deleteUserByIdbased(@PathVariable Long id) {
      boolean isDeleted = userService.deleteUserByIdbased(id);
      if (isDeleted) {
          return ResponseEntity.ok("User deleted successfully");
      } else {
          return ResponseEntity.status(404).body("User not found");
      }
  }
  
  @PutMapping("/updateusercredentials/{id}")
  public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody UserCredentialsDTO userCredentialsDTO) {
      User updatedUser = userService.updateUserById(id, userCredentialsDTO);
      if (updatedUser != null) {
          return ResponseEntity.ok(updatedUser);
      } else {
          return ResponseEntity.status(404).body(null); // 404 Not Found if the user doesn't exist
      }
  }
  
  @GetMapping("/usernames")
  public List<UsernameDTO> getAllUsernames() {
      return userService.getAllUsernames();
  }
  
//  // Endpoint to retrieve all users along with their details (including companyId)
  @GetMapping("/getalluserdetailswithcompanyid")
  public List<UserDTO> getAllUsers1() {
      return userService.getAllUsers1();
  }
  // Endpoint to retrieve all users along with their details (including companyId)
  @PostMapping("/getalluserdetailswithcompanyid")
  public ResponseEntity<List<UserDTO>> getAllUsersWithCompanyId() {
      List<UserDTO> users = userService.getAllUsers1();
      return ResponseEntity.ok(users);
  }
  
//Update User details
  @PostMapping("/updateuserdetails/{id}")
  public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDTO userDetails) {
      User updatedUser = userService.updateUser(id, userDetails);
      return ResponseEntity.ok(updatedUser);
  }
  
  //To display userdetails based on id
  @PostMapping("/getUserdetailsById")
  public ResponseEntity<UserDTO2> getUserById1(@RequestBody Map<String, Long> requestBody) {
      Long id = requestBody.get("id");
      if (id == null) {
          return ResponseEntity.badRequest().build();
      }
      UserDTO2 userDTO = userService.getUserById1(id);
      return userDTO != null ? ResponseEntity.ok(userDTO) : ResponseEntity.notFound().build();
  }


  
}


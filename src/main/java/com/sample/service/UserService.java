package com.sample.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sample.entity.Company;
import com.sample.entity.Permission;
import com.sample.entity.PermissionDTO;
import com.sample.entity.Role;

import com.sample.entity.User;
import com.sample.entity.UserCredentialsDTO;
import com.sample.entity.UserDTO;
import com.sample.entity.UserDTO2;


import com.sample.entity.UsernameDTO;
import com.sample.repository.CompanyRepository;
import com.sample.repository.PermissionRepository;
import com.sample.repository.RoleRepository;
import com.sample.repository.UserRepository;

import jakarta.transaction.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private PermissionRepository permissionRepository;
    
    @Autowired
    private CompanyRepository companyRepository;
     
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

//    public User createUser(User user) {
//        return userRepository.save(user);
//    }
    
    public User addUserWithCompany(User userDetails) {
        if (userDetails.getCompany() == null || userDetails.getCompany().getId() == null) {
            throw new RuntimeException("Company ID is required in the request.");
        }

        // Fetch the company based on the provided company ID
        Company company = companyRepository.findById(userDetails.getCompany().getId())
                .orElseThrow(() -> new RuntimeException("Company not found with id " + userDetails.getCompany().getId()));
        
        userDetails.setCompany(company);

        // Save the user with the associated company
        return userRepository.save(userDetails);
    }

    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setFirstname(userDetails.getFirstname());
            user.setMiddlename(userDetails.getMiddlename());
            user.setLastname(userDetails.getLastname());
            user.setJoiningdate(userDetails.getJoiningdate());
            user.setMobilenumber(userDetails.getMobilenumber());
            user.setEmail(userDetails.getEmail());
            user.setCompanyname(userDetails.getCompanyname());
            user.setState(userDetails.getState());
            user.setPlatnumber(userDetails.getPlatnumber());
            user.setCity(userDetails.getCity());
            user.setState(userDetails.getState());
            user.setCountry(userDetails.getCountry());
            user.setZipcode(userDetails.getZipcode());
            user.setDbaname(userDetails.getDbaname());
            user.setStatus(userDetails.getStatus());
            user.setCreatedby(userDetails.getCreatedby());
            user.setCreateddate(userDetails.getCreateddate());
            
            user.setCompany(userDetails.getCompany());
            user.setRoles(userDetails.getRoles());
            user.setBrands(userDetails.getBrands());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with id " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    
    
    // Check Whether Username is present in database or not
    public boolean checkUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }
 
    // check Whether Username and password is present in database or not

    public String validateUserCredentials(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(password)) {
                return "Login successful";
            } else {
                return "Invalid credentials";
            }
        } else {
            return "Invalid credentials";
        }
    }
    
 // Fetch User ID based on Username
    public Optional<Long> getUserIdByUsername(String username) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        return userOptional.map(User::getId);
    }
    
   //1.previous for permissionname // Fetch All
    public Map<String, Object> getUserDetails(Long userId) {
        Map<String, Object> userDetails = new HashMap<>();

        // Fetch company ID associated with the user
        Long companyId = userRepository.findCompanyIdByUserId(userId);
        userDetails.put("companyId", companyId);

        // Fetch roles associated with the user
        List<Role> roles = roleRepository.findRolesByUserId(userId);

        // Fetch permissions associated with each role
        Map<Long, List<String>> rolePermissions = new HashMap<>();
        for (Role role : roles) {
            List<String> permissions = permissionRepository.findPermissionsByRoleId(role.getId())
                                                           .stream()
                                                           .map(Permission::getName)
                                                           .collect(Collectors.toList());
            rolePermissions.put(role.getId(), permissions);
        }
        userDetails.put("rolePermissions", rolePermissions);

        return userDetails;
    }
 
    //current permissions-id,name
//    public Map<String, Object> getUserDetails(Long userId) {
//        Map<String, Object> userDetails = new HashMap<>();
//
//        // Get company ID
//        Long companyId = userRepository.findCompanyIdByUserId(userId);
//        userDetails.put("companyId", companyId);
//
//        // Get roles for user
//        List<Role> roles = roleRepository.findRolesByUserId(userId);
//
//        // Map roleId to list of PermissionDTO
//        Map<Long, List<PermissionDTO>> rolePermissions = new HashMap<>();
//        for (Role role : roles) {
//            List<PermissionDTO> permissions = permissionRepository.findPermissionsByRoleId(role.getId())
//                .stream()
//                .map(p -> new PermissionDTO(p.getId(), p.getName()))
//                .collect(Collectors.toList());
//
//            rolePermissions.put(role.getId(), permissions);
//        }
//
//        userDetails.put("rolePermissions", rolePermissions);
//
//        return userDetails;
//    }

    // user table 
    public List<UserCredentialsDTO> getAllUserCredentials() {
        return userRepository.findAll().stream()
                .map(user -> new UserCredentialsDTO(
                		user.getId(),
                        user.getUsername(),
                        user.getPassword(),
                        user.getCompany().getId()))
                .collect(Collectors.toList());
    }
    
 
    
    public User addUser(UserCredentialsDTO userCredentialsDTO) {
        // Fetch the company by company_id
        Company company = companyRepository.findById(userCredentialsDTO.getCompanyId())
                            .orElseThrow(() -> new IllegalArgumentException("Invalid company_id"));

        // Create a new User
        User user = new User();
        user.setUsername(userCredentialsDTO.getUsername());
        user.setPassword(userCredentialsDTO.getPassword());
        user.setCompany(company);

        // Save the user to the database
        return userRepository.save(user);
    }
    
    public boolean deleteUserByIdbased(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        
        if (userOptional.isPresent()) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;  // User not found
        }
    }
    
    
    public User updateUserById(Long id, UserCredentialsDTO userCredentialsDTO) {
        // Fetch the user by id
        Optional<User> userOptional = userRepository.findById(id);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Fetch the company by company_id
            Optional<Company> companyOptional = companyRepository.findById(userCredentialsDTO.getCompanyId());

            if (companyOptional.isPresent()) {
                user.setUsername(userCredentialsDTO.getUsername());
                user.setPassword(userCredentialsDTO.getPassword());
                user.setCompany(companyOptional.get());

                // Save the updated user to the database
                return userRepository.save(user);
            }
        }

        return null; // User or company not found
    }
    
    public List<UsernameDTO> getAllUsernames() {
        return userRepository.findAllUsernames();
    }
    
 // Retrieve all users and return their details including companyId
    public List<UserDTO> getAllUsers1() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getFirstname(),
                user.getMiddlename(),
                user.getLastname(),
                user.getJoiningdate(),
                user.getMobilenumber(),
                user.getEmail(),
                user.getCompanyname(),
                user.getStreetname(),
                user.getPlatnumber(),
                user.getCity(),
                user.getState(),
                user.getCountry(),
                user.getZipcode(),
                user.getDbaname(),
                user.getStatus(),
                user.getCreatedby(),
                user.getCreateddate(),
                user.getCompany().getId() // Extract company ID
        )).collect(Collectors.toList());
    }

    //Update User details
    @Transactional
    public User updateUser(Long id, UserDTO userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();

            // Updating user fields
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setFirstname(userDetails.getFirstname());
            existingUser.setMiddlename(userDetails.getMiddlename());
            existingUser.setLastname(userDetails.getLastname());
            existingUser.setJoiningdate(userDetails.getJoiningdate());
            existingUser.setMobilenumber(userDetails.getMobilenumber());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setCompanyname(userDetails.getCompanyname());
            existingUser.setStreetname(userDetails.getStreetname());
            existingUser.setPlatnumber(userDetails.getPlatnumber());
            existingUser.setCity(userDetails.getCity());
            existingUser.setState(userDetails.getState());
            existingUser.setCountry(userDetails.getCountry());
            existingUser.setZipcode(userDetails.getZipcode());
            existingUser.setDbaname(userDetails.getDbaname());
            existingUser.setStatus(userDetails.getStatus());
            existingUser.setCreatedby(userDetails.getCreatedby());
            existingUser.setCreateddate(userDetails.getCreateddate());

            // Handling company association
            if (userDetails.getCompanyId() != null) {
                Optional<Company> companyOptional = companyRepository.findById(userDetails.getCompanyId());
                companyOptional.ifPresent(existingUser::setCompany);
            }

            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id: " + id);
        }
    }
    

    public UserDTO2 getUserById1(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User u = user.get();
            UserDTO2 userDTO = new UserDTO2();
            userDTO.setId(u.getId());
            userDTO.setUsername(u.getUsername());
            userDTO.setPassword(u.getPassword());
            userDTO.setFirstname(u.getFirstname());
            userDTO.setMiddlename(u.getMiddlename());
            userDTO.setLastname(u.getLastname());
            userDTO.setJoiningdate(u.getJoiningdate());
            userDTO.setMobilenumber(u.getMobilenumber());
            userDTO.setEmail(u.getEmail());
            userDTO.setCompanyname(u.getCompanyname());
            userDTO.setStreetname(u.getStreetname());
            userDTO.setPlatnumber(u.getPlatnumber());
            userDTO.setCity(u.getCity());
            userDTO.setState(u.getState());
            userDTO.setCountry(u.getCountry());
            userDTO.setZipcode(u.getZipcode());
            userDTO.setDbaname(u.getDbaname());
            userDTO.setStatus(u.getStatus());
            userDTO.setCreatedby(u.getCreatedby());
            userDTO.setCreateddate(u.getCreateddate());
            userDTO.setCompanyId(u.getCompany() != null ? u.getCompany().getId() : null);
            return userDTO;
        }
        return null;
    }
    
 
    
    }


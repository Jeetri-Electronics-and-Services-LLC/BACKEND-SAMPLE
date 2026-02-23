package com.sample.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.sample.entity.User;
import com.sample.entity.UsernameDTO;



import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Method to find a user by username
    Optional<User> findByUsername(String username);
    
    // Method to check if a username exists
    boolean existsByUsername(String username);
    
    //Method & Query-To Fetch Company_id By User_id
    @Query("SELECT u.company.id FROM User u WHERE u.id = :userId")
    Long findCompanyIdByUserId(@Param("userId") Long userId);
    
 // Method to get a list of usernames
    @Query("SELECT new com.sample.entity.UsernameDTO(u.username) FROM User u")
    List<UsernameDTO> findAllUsernames();
    
    // Method to Fetch username & Password for otp generation
    Optional<User> findByUsernameAndPassword(String username, String password);
    
    
    
    
    
}




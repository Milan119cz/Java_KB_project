package com.example.live.hashcode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/api/hashcode")

public class HashCodeController {

  @Autowired
  private HashCodeRepository hashCodeRepository;
  

  @GetMapping
  public List<HashCode> getAllUsers() {
    return hashCodeRepository.findAll();
  } 

  @GetMapping("/{id}")
  public HashCode getUserById(@PathVariable Long id) {
    return hashCodeRepository.findById(id).get();
  }
  
  @GetMapping("/{id}")
  public HashCode getUserByUserId(@PathVariable Long id) {
	    return hashCodeRepository.findById(id).get();
	  }


  
  public String createHachCode(String code, String userId, String startTime) {
	 HashCode hashCode= new HashCode();
	  hashCode.setHashcode(code);
	  hashCode.setUserID(userId);
	  hashCode.setStartTime(startTime);
	    try {
	    	hashCodeRepository.save(hashCode);
	        return "Hash code was added";
	        }
	       catch (Exception e) {
	       return e.getMessage();
	      }
  }
  
  
  @PutMapping("/{id}")
  public HashCode updateUser(@PathVariable Long id, @RequestBody HashCode hashCode) {
	  HashCode existingUser = hashCodeRepository.findById(id).get();
    existingUser.setHashcode(hashCode.getHashcode());
    existingUser.setUserID(hashCode.getUserID());
    existingUser.setStartTime(hashCode.getStartTime());
    return hashCodeRepository.save(existingUser);
  }

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    try {
    	hashCodeRepository.findById(id).get();
    	hashCodeRepository.deleteById(id);
      return "HashCode deleted successfully";
    } catch (Exception e) {
      return "User not found";
    }
  }
  
}

package com.example.live.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private EmailService emailService;
  @Autowired
  private HashCodeRepository hashCodeRepository;

  @GetMapping
  public List<User> getAllUsers() {
    return userRepository.findAll();
  } 

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userRepository.findById(id).get();
  }

  @PostMapping
  public String createUser(@RequestBody User user) {
	    try {
	        UserValidation.testEmail(user.getEmail());
	        UserValidation.testPhone(user.getPhone());
	        user.setAuthenticated(false);
	        userRepository.save(user);
	        int hashCode= user.getId().hashCode() + user.getName().hashCode()+ user.getEmail().hashCode() + user.getPhone().hashCode();
	        
	        emailService.sendEmail(user.getEmail(),"Verification email","Welocome to our service," +'\n'
	        										+"we are glad that you use our services \n Your verification code," + hashCode + "\n"+
	        										"You can use this link:"+ "http://localhost:8080/email/verification?id=" + user.getId() + "&hash=" + hashCode);
	        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
	        String message =createHachCode(hashCode, user.getId(), dtf.format(LocalDate.now()));
	        return "User was added   "+message;
	        }
	       catch (Exception e) {
	       return e.getMessage();
	      }
  }
  
 	  
	  public HashCode getHashCodeById(Long id) {
		    return hashCodeRepository.findById(id).get();
		  }


	  
	  public String createHachCode(int code, Long userId, String startTime) {
		 HashCode hashCode= new HashCode();
		  hashCode.setHashcode(code);
		  hashCode.setId(userId);
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
  public User updateUser(@PathVariable Long id, @RequestBody User user) {
    User existingUser = userRepository.findById(id).get();
    existingUser.setName(user.getName());
    existingUser.setSecondname(user.getSecondname());
    existingUser.setEmail(user.getEmail());
    existingUser.setPhone(user.getPhone());
    return userRepository.save(existingUser);
  }
  

  @DeleteMapping("/{id}")
  public String deleteUser(@PathVariable Long id) {
    try {
      userRepository.findById(id).get();
      userRepository.deleteById(id);
      return "User deleted successfully";
    } catch (Exception e) {
      return "User not found";
    }
  }
  
}

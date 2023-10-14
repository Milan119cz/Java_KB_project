package com.example.live.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/email")

public class EmailController {

	  @Autowired
	  private UserRepository userRepository;
	  @Autowired
	  private HashCodeRepository hashCodeRepository;


  @GetMapping("/verification")
  public ResponseEntity<String> VerifiedEmain(@RequestParam  Long id, @RequestParam Integer hash) {
	  System.out.println("spustilo se to");
     User user = userRepository.findById(id).get();
     HashCode hashCode = hashCodeRepository.findById(id).get();
     System.out.println(hashCode.getHashcode());
     System.out.println(hash);
     if (hashCode.getHashcode().equals(hash)) {
    	 System.out.println("stejne");
    	 user.setAuthenticated(true);
    	 userRepository.save(user);
		return ResponseEntity.ok("Email has been verified");
 
     }else {
    	 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }
    	 
  }



  
}

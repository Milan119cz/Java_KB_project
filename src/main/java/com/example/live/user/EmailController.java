package com.example.live.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/eamil")

public class EmailController {

	  @Autowired
	  private UserRepository userRepository;
	  @Autowired
	  private HashCodeRepository hashCodeRepository;


  @GetMapping("/verification?id={id}&hash={hash}")
  public void VerifiedEmain(@PathVariable Long id, @PathVariable Integer hash) throws Exception {
	  System.out.println("spustilo se to");
     User user = userRepository.findById(id).get();
     HashCode hashCode = hashCodeRepository.findById(id).get();
     if (hashCode.getHashcode()== hash) {
    	 System.out.println("stejne");
    	 user.setAuthenticated(true);
    	 throw new Exception("HashCode is the same");
     }else {
    	 throw new Exception("HashCode is not the same");
     }
    	 
  }



  
}

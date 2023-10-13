package com.example.live.user;

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
@RequestMapping("/api/eamil")

public class EmailController {

	  @Autowired
	  private UserRepository userRepository;

  @GetMapping("/verification?id={id}&hash={hash}")
  public void VerifiedEmain(@PathVariable Long id, @PathVariable String hash) {
     User user = userRepository.findById(id).get();
     
  }



  
}

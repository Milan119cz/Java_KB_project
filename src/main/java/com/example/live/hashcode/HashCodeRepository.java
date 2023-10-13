package com.example.live.hashcode;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashCodeRepository extends JpaRepository<HashCode, Long> {

}

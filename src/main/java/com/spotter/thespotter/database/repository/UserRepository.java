package com.spotter.thespotter.database.repository;

import com.spotter.thespotter.database.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  @Query("SELECT u FROM User u WHERE u.idpUserId = ?1")
  Optional<User> findByUserIdpId(String idpUserId);

}

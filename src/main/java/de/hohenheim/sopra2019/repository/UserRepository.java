package de.hohenheim.sopra2019.repository;

import de.hohenheim.sopra2019.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUsername(String username);

}

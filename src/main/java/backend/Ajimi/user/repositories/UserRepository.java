package backend.Ajimi.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import backend.Ajimi.user.entities.User;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  @Query("SELECT u FROM User u WHERE u.username = :username")
  List<User> findByUsername(String username);
}

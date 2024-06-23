package backend.Magazyn.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.Magazyn.user.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

  @Query("SELECT u FROM User u WHERE u.username = :username")
  List<User> findByUsername(String username);
}

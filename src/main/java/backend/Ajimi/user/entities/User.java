package backend.Ajimi.user.entities;

import backend.Ajimi.transaction.entities.Transaction;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Getter
@Entity
@Table(name = "app_user")
public class User {

  @Column(unique = true, name = "id")
  @GeneratedValue
  @Id
  private UUID id;

  @Column(name = "name")
  private String name;

  @Column(name = "surname")
  private String surname;

  @Column(name = "PESEL")
  private String PESEL;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @OneToMany
  private List<Transaction> transactions;

}

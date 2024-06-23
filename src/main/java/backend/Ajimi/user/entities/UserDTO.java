package backend.Ajimi.user.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

UUID id;
String name;
String surname;
String PESEL;
String username;
String password;
List<UUID> transactionsIds;
}

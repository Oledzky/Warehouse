package backend.Ajimi.enums;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

public enum Status {
  NEW,
  PENDING,
  COMPLETED,
  CANCELLED,

}

package backend.Ajimi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "backend.Ajimi")
public class Ajimi {

  public static void main(String[] args) {

    SpringApplication.run(Ajimi.class, args);
  }
}

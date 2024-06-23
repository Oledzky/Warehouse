package backend.Magazyn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "backend.Magazyn.*")
public class Magazyn {

  public static void main(String[] args) {

    SpringApplication.run(Magazyn.class, args);
  }
}

package backend.Ajimi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

  @RequestMapping("/")
  public String helloWorld() {
    return "Ajimi server is listening";
  }
}

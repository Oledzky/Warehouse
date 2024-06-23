package backend.Magazyn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {

  @RequestMapping("/")
  public String helloWorld() {
    return "Server is listening";
  }
}

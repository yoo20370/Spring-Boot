package week13.YOO;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SpringBootApplication
public class YooApplication {
	public static void main(String[] args) {
		SpringApplication.run(YooApplication.class, args);
	}
}

@Controller
class home {

	@GetMapping("/")
	public String home(@RequestParam(required = false, defaultValue = "") String msg, RedirectAttributes m){
		m.addFlashAttribute("msg",msg);
		return "index";
	}

}
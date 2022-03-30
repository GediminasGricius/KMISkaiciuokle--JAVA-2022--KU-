package lt.ku.kmiskaiciuokle.controllers;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@PostMapping("/")
	public String kmi(
			@RequestParam("svoris") Integer svoris, 
			@RequestParam("ugis") Integer ugis,
			Model model) {

		double kmi=svoris / Math.pow(ugis/100.0, 2);
		
		kmi=Math.round(kmi*100)/100.0;
		
		Integer level=1;
		if (kmi>=25 && kmi<30) level=2;
		if (kmi>=30) level=3;
		
		model.addAttribute("kmi", kmi);
		model.addAttribute("level", level);
		return home();
	}

}

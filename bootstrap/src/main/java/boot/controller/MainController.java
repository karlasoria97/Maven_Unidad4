package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("/tasks")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_TASKS");
		return "tasks";
	}
	
	@GetMapping("/tennis")
	public String tennis(HttpServletRequest request){
		request.setAttribute("mode", "MODE_TENNIS");
		return "tennis";
	}
	
	@GetMapping("/staffs")
	public String staff(HttpServletRequest request){
		request.setAttribute("mode", "MODE_STAFFS");
		return "staffs";
	}
	
	@GetMapping("/songs")
	public String song(HttpServletRequest request){
		request.setAttribute("mode", "MODE_SONGS");
		return "songs";
	}
	
	
 }
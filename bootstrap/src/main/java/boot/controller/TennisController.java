package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import boot.model.Tenni;
import boot.service.TenniService;

@Controller
public class TennisController {

	@Autowired
	private TenniService tenniService;

	@GetMapping("/all-tennis")
	public String allTennis(HttpServletRequest request) {
		request.setAttribute("tennis", tenniService.findAll());
		request.setAttribute("mode", "MODE_TENNIS");
		return "tennis";
	}

	@GetMapping("/new-tenni")
	public String newTenni(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW_TENNI");
		return "tennis";
	}

	@PostMapping("/save-tenni")
	public String saveTenni(@ModelAttribute Tenni tenni, BindingResult bindingResult, HttpServletRequest request) {
		tenniService.save(tenni);
		request.setAttribute("tennis", tenniService.findAll());
		request.setAttribute("mode", "MODE_TENNIS");
		return "tennis";
	}

	@GetMapping("/update-tenni")
	public String updateTenni(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("tenni", tenniService.findTenni(id));
		request.setAttribute("mode", "MODE_UPDATE_TENNIS");
		return "tennis";
	}

	@GetMapping("/delete-tenni")
	public String deleteTenni(@RequestParam int id, HttpServletRequest request) {
		tenniService.delete(id);
		request.setAttribute("tennis", tenniService.findAll());
		request.setAttribute("mode", "MODE_TENNIS");
		return "tennis";
	}
}

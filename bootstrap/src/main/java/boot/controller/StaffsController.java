package boot.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Staff;
import boot.service.StaffService;

@Controller
public class StaffsController {
	
	@Autowired
	private StaffService staffService;
	
	@GetMapping("/all-staffs")
	public String allStaffs(HttpServletRequest request){
		request.setAttribute("staffs", staffService.findAll());
		request.setAttribute("mode", "MODE_STAFFS");
		return "staffs";
	}
	
	@GetMapping("/new-staff")
	public String newStaff(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW_STAFF");
		return "staffs";
	}
	
	@PostMapping("/save-staff")
	public String saveStaff(@ModelAttribute Staff staff, 
			BindingResult bindingResult, HttpServletRequest request){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDay = new Date();
		try{
			birthDay= format.parse(request.getParameter("birthDay"));
					}catch(ParseException e){
						e.printStackTrace();
					}
		staff.setBirthDay(birthDay);
		staffService.save(staff);
		request.setAttribute("staffs", staffService.findAll());
		request.setAttribute("mode", "MODE_STAFFS");
		return "staffs";
	}
	
	@GetMapping("/update-staff")
	public String updateStaff(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("staff", staffService.findStaff(id));
		request.setAttribute("mode", "MODE_UPDATE_STAFFS");
		return "staffs";
	}
	
	@GetMapping("/delete-staff")
	public String deleteStaff(@RequestParam int id, HttpServletRequest request){
		staffService.delete(id);
		request.setAttribute("staffs", staffService.findAll());
		request.setAttribute("mode", "MODE_STAFFS");
		return "staffs";
	}


}

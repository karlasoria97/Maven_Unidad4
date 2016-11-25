package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.StaffRepository;
import boot.model.Staff;

@Service @Transactional
public class StaffService {
	
	private final StaffRepository staffRepository;

	public StaffService(StaffRepository staffRepository) {
		super();
		this.staffRepository = staffRepository;
	}
	public List<Staff> findAll(){
		List<Staff> staffs = new ArrayList<Staff>();
		for (Staff staff : staffRepository.findAll()) {
			staffs.add(staff);
		}
		return staffs;
	}
	
	public void save(Staff staff){
		staffRepository.save(staff);
	}
	
	public void delete(int id){
		staffRepository.delete(id);
	}
	
	public Staff findStaff(int id){
		return staffRepository.findOne(id);
	}
	

}

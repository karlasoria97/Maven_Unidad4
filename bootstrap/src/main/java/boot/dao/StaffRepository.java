package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Staff;

public interface StaffRepository extends CrudRepository<Staff, Integer>{

}

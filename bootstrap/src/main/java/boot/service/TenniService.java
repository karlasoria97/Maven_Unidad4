package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import boot.dao.TenniRepository;
import boot.model.Tenni;

@Service @Transactional
public class TenniService {
	private final TenniRepository tenniRepository;

	public TenniService(TenniRepository tenniRepository) {
		super();
		this.tenniRepository = tenniRepository;
	}
	public List<Tenni> findAll(){
		List<Tenni> tennis = new ArrayList<Tenni>();
		for (Tenni tenni : tenniRepository.findAll()) {
			tennis.add(tenni);
		}
		return tennis;
	}
	
	public void save(Tenni tenni){
		tenniRepository.save(tenni);
	}
	
	public void delete(int id){
		tenniRepository.delete(id);
	}
	
	public Tenni findTenni(int id){
		return tenniRepository.findOne(id);
	}

}

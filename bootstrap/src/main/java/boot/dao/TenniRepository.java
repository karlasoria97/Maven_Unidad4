package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Tenni;

public interface TenniRepository extends CrudRepository<Tenni, Integer> {

}

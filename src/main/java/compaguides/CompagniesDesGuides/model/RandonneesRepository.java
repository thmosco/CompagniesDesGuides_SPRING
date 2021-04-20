package compaguides.CompagniesDesGuides.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import compaguides.CompagniesDesGuides.model.RandonneesModel;

@Service
public interface RandonneesRepository extends CrudRepository<RandonneesModel, Integer>{

}

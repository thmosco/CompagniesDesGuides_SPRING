package projet.cdg.compagnieDesGuides.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import projet.cdg.compagnieDesGuides.model.AscensionsModel;
import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import projet.cdg.compagnieDesGuides.model.SommetsModel;

@Repository
public interface SommetsRepository extends CrudRepository<SommetsModel, Integer>{
	
	@Query(value="Select sommets.* from ascension,abris,sommets where ascension.code_Abris = abris.code_Abris and sommets.code_Sommets = ascension.code_Sommets AND  abris.code_Vallees = ?1 GROUP BY code_Sommets", nativeQuery=true)
	Iterable<SommetsModel> findSommetsByVallee(int id);
		
}

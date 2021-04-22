package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import projet.cdg.compagnieDesGuides.model.AscensionsModel;

@Repository
public interface AscensionsRepository extends CrudRepository<AscensionsModel, Integer>{
	
	@Query(value="Select ascension.* from ascension,abris where ascension.code_Abris = abris.code_Abris and abris.code_Vallees = ?1", nativeQuery=true)
	Iterable<AscensionsModel> findAscensionsByValleesId(int id);
}

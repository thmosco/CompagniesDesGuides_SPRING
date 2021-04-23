package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import projet.cdg.compagnieDesGuides.model.GuidesModel;
import projet.cdg.compagnieDesGuides.model.SommetsModel;

@Repository
public interface GuidesRepository extends CrudRepository<GuidesModel, Integer>{
	
	@Query(value="Select * from guides where  email_Guides = ?1", nativeQuery=true)
	GuidesModel findGuidesByMail(String mail);
	
}
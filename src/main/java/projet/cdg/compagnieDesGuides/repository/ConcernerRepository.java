package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projet.cdg.compagnieDesGuides.model.ConcernerModel;

@Repository
public interface ConcernerRepository extends CrudRepository<ConcernerModel, Integer>{
	@Query(value="DELETE FROM concerner where date_Concerner < ?1 or date_Concerner > ?2", nativeQuery=true)
	@Modifying
    @Transactional
	void updateConcerner(@Param(value = "dateDebut") String dateDebut, @Param(value = "dateFin") String dateFin);
	
	@Query(value="DELETE FROM concerner where code_Randonnees = ?2 AND code_Sommets = ?1", nativeQuery=true)
	@Modifying
    @Transactional
	void deleteConcerner(@Param(value = "code_Sommet") int code_Abris, @Param(value = "code_Randonnees") int code_Randonnees);
	
	
	@Query(value="UPDATE concerner set date_Concerner = ?3 where code_Randonnees = ?2 AND code_Sommets = ?1", nativeQuery=true)
	@Modifying
    @Transactional
	void updateConcerner1(@Param(value = "code_Sommet") int code_Abris, @Param(value = "code_Randonnees") int code_Randonnees,@Param(value = "date_Concerner") String date_Concerner);

}
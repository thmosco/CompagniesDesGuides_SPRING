package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projet.cdg.compagnieDesGuides.model.ConcernerModel;

@Repository
public interface ConcernerRepository extends CrudRepository<ConcernerModel, Integer>{
	@Query(value="DELETE FROM concerner where date_Concerner < ?1 or date_Concerner > ?2", nativeQuery=true)
	@Modifying
    @Transactional
	void updateConcerner(@Param(value = "dateDebut") String dateDebut, @Param(value = "dateFin") String dateFin);
}
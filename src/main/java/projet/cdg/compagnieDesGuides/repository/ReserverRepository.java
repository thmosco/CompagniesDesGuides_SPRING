package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import projet.cdg.compagnieDesGuides.model.ReserverModel;

public interface ReserverRepository extends CrudRepository<ReserverModel, Integer>{
	
	@Query(value="DELETE FROM reserver where date_Reserver < ?1 or date_Reserver > ?2", nativeQuery=true)
	@Modifying
    @Transactional
	void updateReserver(@Param(value = "dateDebut") String dateDebut, @Param(value = "dateFin") String dateFin);
}

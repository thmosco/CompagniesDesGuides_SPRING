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
	
	@Query(value="DELETE FROM reserver where code_Randonnees = ?2 AND code_Abris = ?1", nativeQuery=true)
	@Modifying
    @Transactional
	void deleteReserver(@Param(value = "code_Abris") int code_Abris, @Param(value = "code_Randonnees") int code_Randonnees);
	
	@Query(value="SELECT count(*) FROM reserver where code_Randonnees = ?2 AND code_Abris= ?1", nativeQuery=true)
	int countReserver(@Param(value = "code_Abris") int code_Sommet, @Param(value = "code_Randonnees") int code_Randonnees);

	@Query(value="UPDATE reserver set date_Reserver = ?3 , statut_Reserver = ?4 where code_Randonnees = ?2 AND code_Abris = ?1", nativeQuery=true)
	@Modifying
    @Transactional
	void updateReserver1(@Param(value = "code_Abris") int code_Abris, @Param(value = "code_Randonnees") int code_Randonnees,@Param(value = "date_Reserver") String date_Reserver, @Param(value = "statut_Reserver") String statut_Reserver);
}

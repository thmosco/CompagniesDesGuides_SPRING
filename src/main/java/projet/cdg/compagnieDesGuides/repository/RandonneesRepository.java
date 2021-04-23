package projet.cdg.compagnieDesGuides.repository;

import java.util.Date;

import org.hibernate.Transaction;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RandonneesRepository extends CrudRepository<RandonneesModel, Integer>{
	@Query(value="UPDATE randonnees set nbPersonnes_Randonnees = ?2 , dateDebut_Randonnees = ?3 , dateFin_Randonnees = ?4 where code_Randonnees = ?1", nativeQuery=true)
	@Modifying
    @Transactional
	void update(@Param(value = "id") int id, @Param(value = "nbPersonne") String nbPers, @Param(value = "dateDebut") String dateDebut, @Param(value = "dateFin") String dateFin);

	@Query(value="DELETE FROM randonnees where code_Randonnees = ?1", nativeQuery=true)
	@Modifying
    @Transactional
	void deleteFromId(@Param(value = "id") int id);

}

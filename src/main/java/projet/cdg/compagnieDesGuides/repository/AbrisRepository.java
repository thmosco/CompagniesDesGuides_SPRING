package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projet.cdg.compagnieDesGuides.model.AbrisModel;
import projet.cdg.compagnieDesGuides.model.AscensionsModel;

@Repository
public interface AbrisRepository extends CrudRepository<AbrisModel, Integer>{
	
	@Query(value="Select * from abris where code_Vallees = ?1", nativeQuery=true)
	Iterable<AbrisModel> findAbrisByVallees(int id);


}

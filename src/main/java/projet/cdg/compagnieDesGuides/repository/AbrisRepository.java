package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import projet.cdg.compagnieDesGuides.model.AbrisModel;

@Repository
public interface AbrisRepository extends CrudRepository<AbrisModel, Integer>{
	
	@Query(value="Select *from abris where code_Vallees = ?1", nativeQuery=true)
	Iterable<AbrisModel> findAbrisByValleeId(int id);
}
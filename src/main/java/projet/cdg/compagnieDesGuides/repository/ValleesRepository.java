package projet.cdg.compagnieDesGuides.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import projet.cdg.compagnieDesGuides.model.RandonneesModel;
import projet.cdg.compagnieDesGuides.model.SommetsModel;
import projet.cdg.compagnieDesGuides.model.ValleesModel;

@Repository
public interface ValleesRepository extends CrudRepository<ValleesModel, Integer>{
}

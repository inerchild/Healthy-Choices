package hello;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthyChoiceRepository extends JpaRepository<HealthyChoice, Long> {

	List<HealthyChoice> findByIdStartsWithIgnoreCase(String id);
	
	List<HealthyChoice> findByDescriptionStartsWithIgnoreCase(String description);
	
		}


/*package hello;

import org.springframework.data.repository.CrudRepository;

//import MyJAProject.seg_rehab.Contractor;

	
public interface HealthyChoiceRepository extends CrudRepository<HealthyChoice, Long> {

}*/
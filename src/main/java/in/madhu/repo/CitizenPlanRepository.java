package in.madhu.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.madhu.entities.Citizenplan;

public interface CitizenPlanRepository extends JpaRepository<Citizenplan, Integer> {
		@Query(value=" select distinct(planName) from Citizenplan")
		public List<String>getplaname();
		
		@Query(value="select distinct(planStatus)from Citizenplan")
		public List <String>getplanStatus();
		
	}



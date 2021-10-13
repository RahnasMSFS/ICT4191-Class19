package lk.ac.vau.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import lk.ac.vau.Model.Worker;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Integer>{
    //JPA Query
	
	@Query("select w from Worker w where w.Skill_type = ?1")
	List<Worker> findBySkillType(String skill);
	
	@Query("select w from Worker w where w.Worker_Name like %?1%")
	List<Worker> findByName(String name);
	
	@Query("select w.Supervisor from Worker w where w.Worker_ID = ?1")
	Worker findBySupervisor(int id);
	
	//@Query("select w from Worker w where w.hourly_rate")
}

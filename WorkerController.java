package lk.ac.vau.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.ac.vau.Model.Worker;
import lk.ac.vau.Repo.WorkerRepo;

@RestController
@RequestMapping("/worker")
public class WorkerController {

	@Autowired
	private WorkerRepo context;
	
	@GetMapping
	public List<Worker>getAll()
	{
		return context.findAll();
	}
	
	//  [http://localhost:8080/worker]
	@GetMapping("/id")
	public Worker get(@PathVariable("id") int id)
	{
		return context.findById(id).get();
	}
	
	//Que: return all electritions
	@GetMapping("skilltype/{skill}")
	public List<Worker>getSkill(@PathVariable("skill") String skill)
	{
		return context.findBySkillType(skill);
	}
	
	//Que: return name         [http://localhost:8080/worker/name/P.Mason]
	@GetMapping("name/{name}")
	public List<Worker>getName(@PathVariable("name") String name)
	{
		return context.findByName(name);
	}
	
	//Que: from the supervisor ID find the worker id   [http://localhost:8080/worker/sup/1235]
	@GetMapping("sup/{id}")
	public Worker getSupervisor(@PathVariable("id") int id)
	{
		return context.findBySupervisor(id);
	}
}

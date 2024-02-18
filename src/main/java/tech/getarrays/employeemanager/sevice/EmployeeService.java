package tech.getarrays.employeemanager.sevice;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.getarrays.employeemanager.model.Employe;
import tech.getarrays.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo empRepo;
	
	public Employe addEmploye(Employe emp) {
		emp.setEmployeeCode(UUID.randomUUID().toString());
		return empRepo.save(emp);
	}
	public List<Employe> findAllemploye(){
		return empRepo.findAll();
	}
	public Employe updateEmploye(Employe emp) {
		return empRepo.save(emp);
	}
	public void deleteEmpl(Long id) {
		empRepo.deleteEmpById(id);
	}

}

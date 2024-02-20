package tech.getarrays.employeemanager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.employeemanager.model.Employe;

public interface EmployeeRepo extends JpaRepository<Employe, Long>{

	void deleteEmpById(Long id);

	Optional<Employe> findEmployeById(Long id);
	

}

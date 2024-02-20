package tech.getarrays.employeemanager.ressource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.getarrays.employeemanager.model.Employe;
import tech.getarrays.employeemanager.sevice.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	@Autowired
     EmployeeService employeeService;

   

    @GetMapping("/all")
    public ResponseEntity<List<Employe>> getAllEmployees () {
        List<Employe> employees = employeeService.findAllemploye();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employe> getEmployeeById (@PathVariable("id") Long id) {
        Employe employee = employeeService.findEmployeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employe> addEmployee(@RequestBody Employe employee) {
        Employe newEmployee = employeeService.addEmploye(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employe> updateEmployee(@RequestBody Employe employee) {
        Employe updateEmployee = employeeService.updateEmploye(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmpl(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
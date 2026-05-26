package mg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mg.dto.EmployeeReqDto;
import mg.dto.EmployeeResDto;
import mg.entity.Employee;
import mg.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/")
	public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeReqDto reqDto) {
		Employee employee = employeeService.createEmployee(reqDto);

		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeResDto>> getAllEmployees() {
		return new ResponseEntity<List<EmployeeResDto>>(employeeService.getAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeResDto> getMethodName(@PathVariable ("id") int id) {
		return new ResponseEntity<EmployeeResDto>(employeeService.getSingleEmployee(id),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	private ResponseEntity<Employee> updateEmployee(@PathVariable ("id") int id ,@RequestBody EmployeeReqDto reqDto ) {
		return new ResponseEntity<Employee>(employeeService.updateEmployeeName(id, reqDto),HttpStatus.OK);
	}
	

}

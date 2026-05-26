package mg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import mg.dto.EmployeeReqDto;
import mg.dto.EmployeeResDto;
import mg.entity.Employee;

@Service
public interface EmployeeService {
	
	Employee createEmployee(EmployeeReqDto emp);
	
	List<EmployeeResDto> getAllEmployee();

	EmployeeResDto getSingleEmployee(int id);
	
	Employee updateEmployeeName(int id, EmployeeReqDto reqDto); 
	
	String deleteEmployee(int id); 
}


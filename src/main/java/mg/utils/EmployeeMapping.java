package mg.utils;

import org.springframework.stereotype.Service;

import mg.dto.EmployeeReqDto;
import mg.dto.EmployeeResDto;
import mg.entity.Employee;

@Service
public class EmployeeMapping {

	public static Employee toEmployee(EmployeeReqDto reqDto) {
		Employee emp = new Employee();
		emp.setName(reqDto.getName());
		return emp;
	}

	public static EmployeeResDto fromEmployee(Employee emp) {
		EmployeeResDto resDto = new EmployeeResDto();
		resDto.setId(emp.getId());
		resDto.setName(emp.getName());
		return resDto;
	}
}

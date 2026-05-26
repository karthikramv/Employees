package mg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import mg.dto.EmployeeReqDto;
import mg.dto.EmployeeResDto;
import mg.entity.Employee;
import mg.repository.EmployeeRepository;
import mg.utils.EmployeeMapping;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(EmployeeReqDto reqDto) {
		return employeeRepository.save(EmployeeMapping.toEmployee(reqDto));

	}

	@Override
	public List<EmployeeResDto> getAllEmployee() {
		return employeeRepository.findAll().stream().map(EmployeeMapping::fromEmployee).toList();

	}

	@Override
	public EmployeeResDto getSingleEmployee(int id) {
		Employee singleEmployee = employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee id not found"));
		return EmployeeMapping.fromEmployee(singleEmployee);
	}

	@Override
	public Employee updateEmployeeName(int id, EmployeeReqDto reqDto) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			Employee employee2 = employee.get();
			employee2.setName(reqDto.getName());
			return employeeRepository.save(employee2);
		}
		return null;
	}

	@Override
	public String deleteEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

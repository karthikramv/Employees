package mg.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeReqDto {

	@NotNull
	private String name;
}

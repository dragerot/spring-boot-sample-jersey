package sample.jersey;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {
	private Long id;
	// redundant validations, for testing
	@NotNull
	@Size(min = 5, max = 80, message = "First name too short")
	@NotBlank(message = "First name blank")
	@NotEmpty(message = "First name empty")
	private String firstName;

	@NotNull
	@Size(min = 2, max = 80, message = "Last name too short")
	private String lastName;

	@NotNull
	private String email;

}

package sample.jersey;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Component
@Path("/user")
public class UserEndpoint {
	@Context
	private UriInfo uriInfo;

	@GET
	public String reverse(@QueryParam("input") @NotNull String input) {
		return new StringBuilder(input).reverse().toString();
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	@Path("/registrer")
	public Response create(
			 UserDTO userDTO
			) {

		//@PathParam("navn")
		//@NotNull String navn,@RequestBody

		//@QueryParam()
		//,@Context UriInfo uriInfo
//		UserDTO userDTO = UserDTO.builder()
//				.email("qwqw@sds")
//				.firstName("Toregard")
//				.id(1L)
//				.lastName("lastName")
//				.build(); //.entity(userDTO)
		return Response.ok().entity(userDTO).build();
	}
}

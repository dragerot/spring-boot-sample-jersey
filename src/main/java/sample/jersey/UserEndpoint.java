package sample.jersey;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/*
https://stackoverflow.com/questions/34284373/valid-not-working-with-jax-rs-using-spring-boot
https://no.wikipedia.org/wiki/Liste_over_HTTP-statuskoder

get http://localhost:8080/user?input=test
post http://localhost:8080/user/registrer/1
Content-Type application/json
{
    "id": 1,
     "firstName": "12343434",
    "lastName": "lastName2",
    "email": "qwqw@sds"
}


 */
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
	@Path("/registrer/{navn}")
	public Response create(@PathParam("navn") @NotNull String navn,
			@Valid UserDTO userDTO,
			BindingResult bindingResult,
			@Context UriInfo uriInfo
			) {
//		if (bindingResult.hasErrors()) {
//			return Response.ok().entity(bindingResult.getTarget()).build(); // some error code, or however you want to handle validation errors
//		}

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

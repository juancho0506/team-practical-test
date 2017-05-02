/**
 * 
 */
package com.team.presentation.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.team.business.entity.Client;

/**
 * @author Rodrigo
 *
 */
@Path("/clients")
public class RestClientService {

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Client getTrackInJSON() {

		//Dummy client
		Client dummyClient = new Client();
		dummyClient.setId(1L);
		dummyClient.setClientId(10000);
		dummyClient.setName("Client name dummy");
		dummyClient.setAge(18);
		dummyClient.setAddress("Dummy address");

		return dummyClient;

	}

}

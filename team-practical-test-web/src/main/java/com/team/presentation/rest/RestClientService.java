/**
 * 
 */
package com.team.presentation.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.team.business.control.ClientTransactionalControl;
import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

/**
 * @author Rodrigo
 *
 */
@Path("/v1")
public class RestClientService {
	
	/** The Client Control **/
	//TODO: change this to fix the depedency injection problem with jersey.
	private ClientTransactionalControl clientService = new ClientTransactionalControl();

	@GET
	@Path("/clients")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Client>  listAllClients() {

		try {
			return clientService.fetchAllClients();
		} catch (TeamTransactionException e) {
			e.printStackTrace();
			return null;
		}

	}

}

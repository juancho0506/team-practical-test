package com.team.business.boundary;

import java.util.List;

import javax.ejb.Local;

import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

@Local
public interface IClientTransactionalBoundaryLocal {
	
	/**
	 * find a client given his client id.
	 * @param clientId
	 * @return
	 * @throws TeamTransactionException
	 */
	Client findClientByClientId(final Integer clientId) throws TeamTransactionException;
	
	/**
	 * Saves a new client
	 * @param client
	 * @return
	 * @throws TeamTransactionException
	 */
	Client saveClient(final Client client) throws TeamTransactionException;

	/**
	 * Get all the clients persisted so far..
	 * @return
	 * @throws TeamTransactionException
	 */
	List<Client> fetchAllClients() throws TeamTransactionException;
}

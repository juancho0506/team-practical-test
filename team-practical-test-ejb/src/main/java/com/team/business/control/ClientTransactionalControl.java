/**
 * 
 */
package com.team.business.control;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

/**
 * @author Rodrigo
 *
 */
public class ClientTransactionalControl {
	
	/** The JPA entity manager for persistence operations **/
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor
	 */
	public ClientTransactionalControl() {
		
	}
	
	/**
	 * Param constructor for test purposes
	 * @param em
	 */
	public ClientTransactionalControl(final EntityManager em) {
		super();
		this.em = em;
	}
	
	/**
	 * Fetchs a client given the client ID
	 * @param clientId
	 * @return
	 * @throws TeamTransactionException
	 */
	public Client findClientByCLientId(final Integer clientId) throws TeamTransactionException{
		try {
			return (Client) em.createNamedQuery("Client.findByClientId").setParameter("clientId", clientId).getSingleResult();
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new TeamTransactionException("Error fetching the client with client id: " + clientId, e);
		} catch (ClassCastException e){
			e.printStackTrace();
			throw new TeamTransactionException("Error fetching the client with client id: " + clientId, e);
		}
		
	}
	
	/**
	 * Saves a new client given the entity.
	 * @param client
	 * @return
	 * @throws TeamTransactionException
	 */
	public Client saveClient(Client client)  throws TeamTransactionException{
		try {
			 em.persist(client);
			 return client;
		} catch (PersistenceException e) {
			e.printStackTrace();
			throw new TeamTransactionException("Error fetching the client with client id: " + client.getClientId(), e);
		} catch (ClassCastException e){
			e.printStackTrace();
			throw new TeamTransactionException("Error fetching the client with client id: " + client.getClientId(), e);
		}
	}

	/**
	 * Fetchs all clients in persistence.
	 * @return a List of clients founded or null if the result is empty.
	 * @throws TeamTransactionException 
	 */
	@SuppressWarnings("unchecked")
	public List<Client> fetchAllClients() throws TeamTransactionException {
		try {
			return em.createNamedQuery("Client.findAll").getResultList();
		}catch (PersistenceException e) {
			e.printStackTrace();
			throw new TeamTransactionException("Error fetching all the client list", e);
		}	
	}
}

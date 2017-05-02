/**
 * 
 */
package com.team.business.control;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

/**
 * @author Rodrigo
 *
 */
@Model
public class ClientTransactionalControl {
	
	/** The JPA entity manager for persistence operations **/
	@PersistenceContext(unitName="team-pu")
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
	@SuppressWarnings("unchecked")
	public Client findClientByCLientId(final Integer clientId) throws TeamTransactionException{
		try {
			List<Client> clientList =  em.createNamedQuery("Client.findByClientId").setParameter("clientId", clientId).getResultList();
			return (clientList.size()>0 ? clientList.get(0) : null);
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
	@Transactional
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
	 * Updates an existing client given the entity with his Unique id.
	 * @param client a client with id not null.
	 * @return
	 * @throws TeamTransactionException
	 */
	@Transactional
	public Client updateClient(Client client)  throws TeamTransactionException{
		try {
			 em.merge(client);
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
			List<Client> clients = em.createNamedQuery("Client.findAll").getResultList();
			return (clients != null ? clients : new ArrayList<>());
		}catch (PersistenceException e) {
			e.printStackTrace();
			throw new TeamTransactionException("Error fetching all the client list", e);
		}	
	}
}

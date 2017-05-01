/**
 * 
 */
package com.team.service.boundary;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.mockito.Mockito;

import com.team.business.boundary.ClientTransactionalBoundaryLocal;
import com.team.business.control.ClientTransactionalControl;
import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

/**
 * @author Rodrigo
 *
 */
@FixMethodOrder(MethodSorters.JVM)
public class ClientTransactionalBoundaryLocalTest {
	
	/** Dummy list to mock the persistence functionality **/
	private static List<Client> clientPersistenceDummyList;
	
	/** A dummy client to persist. **/
	private static Client dummyClient;
	
	/** The service boundary class to test **/
	private static ClientTransactionalBoundaryLocal boundary;
	
	/** The entity manager to mock. **/
	private static ClientTransactionalControl control;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Mock the entity manager
		control = mock(ClientTransactionalControl.class);
		//Initialize boundary with mocked control
		boundary = new ClientTransactionalBoundaryLocal(control);
		//Initialize client list..
		clientPersistenceDummyList = new ArrayList<>();
		//Dummy client
		dummyClient = new Client();
		dummyClient.setId(1L);
		dummyClient.setClientId(10000);
		dummyClient.setName("Client name dummy");
		dummyClient.setAge(18);
		dummyClient.setAddress("Dummy address");
		//Add the dummy client to the list
		clientPersistenceDummyList.add(dummyClient);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		boundary = null;
		control = null;
		clientPersistenceDummyList = null;
		dummyClient = null;
	}
	
	@Test
	public void testFetchAllClients() throws TeamTransactionException{
		//change control methods
		when(control.fetchAllClients()).thenReturn(clientPersistenceDummyList);
		
		//Test method..
		final List<Client> clients = boundary.fetchAllClients();
		assertThat(clients).isNotNull();
		assertThat(clients).size().isGreaterThan(0);
		System.out.println("*** Current clients ***");
		for (Client client : clients) {
			System.out.println("- " + client.getClientId() + ": " + client.getName());
		}
	}
	
	@Test
	public void testfindClientByClientId() throws TeamTransactionException{
		//Test data
		final Integer clientId = dummyClient.getClientId();
		
		//change control methods
		when(control.findClientByCLientId(Mockito.anyInt())).thenReturn(this.findClientByClientId(clientId));
		
		//Test method..
		final Client client = boundary.findClientByClientId(clientId);
		assertThat(client).isNotNull();
		assertThat(client.getClientId()).isEqualTo(dummyClient.getClientId());
	}

	@Test
	public void testPersistNewClient() throws TeamTransactionException {
		//Test data:
		Client newClient = new Client();
		newClient.setClientId(10002);
		newClient.setName("New Client name");
		newClient.setAge(30);
		newClient.setAddress("test address");
		
		//change control method
		//Client is new so it has't to return any object.
		when(control.findClientByCLientId(Mockito.anyInt())).thenReturn(null);
		when(control.saveClient(newClient)).thenReturn(this.addNewClientToList(newClient));
		//Test method..
		final Client client = boundary.saveClient(newClient);
		assertThat(client).isNotNull();
		assertThat(client.getClientId()).isEqualTo(newClient.getClientId());
		
		this.testFetchAllClients();
		
	}
	
	@Test
	public void testPersistExistingClient() throws TeamTransactionException {
		//Test data:
		Client existing = new Client();
		existing.setId(1L);
		existing.setClientId(10002);
		existing.setName("Edited Client name");
		existing.setAge(30);
		existing.setAddress("test address edited");
		
		//change control method
		//Client already exists, so it has't to return the existing object.
		when(control.findClientByCLientId(Mockito.anyInt())).thenReturn(existing);
		when(control.updateClient(existing)).thenReturn(this.updateClientInList(existing));
		//Test method..
		final Client client = boundary.saveClient(existing);
		assertThat(client).isNotNull();
		assertThat(client.getClientId()).isEqualTo(existing.getClientId());
		
		this.testFetchAllClients();
		
	}
	
	/** Retrieves a client by client id from the list
	 * @param clientId The client id to search.
	 * @return
	 */
	private Client findClientByClientId(final int clientId){
		for (final Client client : clientPersistenceDummyList) {
			if(client.getClientId().intValue() == clientId){
				return client;
			}
		}
		return null;
	}
	
	/**
	 * private method to add a new client to the list.
	 * @param newClient
	 * @return
	 */
	private Client addNewClientToList(final Client newClient){
		clientPersistenceDummyList.add(newClient);
		return newClient;
	}
	
	/**
	 * private method to add a new client to the list.
	 * @param newClient
	 * @return
	 */
	private Client updateClientInList(final Client existing){
		Client previous = this.findClientByClientId(existing.getClientId());
		previous.setClientId(existing.getClientId());
		previous.setName(existing.getName());
		previous.setAge(existing.getAge());
		previous.setAddress(existing.getAddress());
		return previous;
	}
}

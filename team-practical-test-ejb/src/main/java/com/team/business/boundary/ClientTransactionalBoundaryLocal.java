package com.team.business.boundary;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.team.business.control.ClientTransactionalControl;
import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

/**
 * Session Bean implementation class ClientTransactionalBoundary
 */
@Stateless
@LocalBean
public class ClientTransactionalBoundaryLocal implements IClientTransactionalBoundaryLocal {
	
	/** This boundary control for persistence operations **/
	@Inject
	private ClientTransactionalControl control;
	
    /**
     * Default constructor. 
     */
    public ClientTransactionalBoundaryLocal() {
        
    }
    
    /**
     * Parameter constructor for test purposes.
     * @param em The entity manager to ser or mock
     */
	public ClientTransactionalBoundaryLocal(final ClientTransactionalControl control) {
		super();
		this.control = control;
	}

	@Override
	public Client findClientByClientId(Integer clientId) throws TeamTransactionException {
		return control.findClientByCLientId(clientId);
	}

	@Override
	@Transactional
	public Client saveClient(Client client) throws TeamTransactionException {
		return control.saveClient(client);
	}

	@Override
	public List<Client> fetchAllClients() throws TeamTransactionException {
		return control.fetchAllClients();
	}

}

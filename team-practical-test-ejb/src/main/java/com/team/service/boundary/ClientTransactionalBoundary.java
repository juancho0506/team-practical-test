package com.team.service.boundary;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class ClientTransactionalBoundary
 */
@Stateless
@LocalBean
public class ClientTransactionalBoundary implements ClientTransactionalBoundaryLocal {

    /**
     * Default constructor. 
     */
    public ClientTransactionalBoundary() {
        // TODO Auto-generated constructor stub
    }

}

package com.team.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.business.boundary.IClientTransactionalBoundaryLocal;
import com.team.business.entity.Client;
import com.team.business.exception.TeamTransactionException;

/**
 * Servlet implementation class to serve client http request operations.
 */
@WebServlet(name="ClientServlet", urlPatterns={"/ClientServlet"})
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/** The Client EJB **/
	@EJB
	private IClientTransactionalBoundaryLocal clientService;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println();
		try {
			//Add new client for testing purposes..
			Client c = new Client();
			c.setName("Client test");
			c.setAge(10);
			c.setAddress("Test");
			c.setClientId(1000);
			clientService.saveClient(c);
			
			List<Client> clientList = clientService.fetchAllClients();
			response.getWriter().println("Client list: ");
			response.getWriter().println();
			
			for (Client client : clientList) {
				response.getWriter().append("* ").append(client.getName());
				response.getWriter().println();
			}
			
			response.getWriter().println("end of list. ");
		} catch (TeamTransactionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package com.team.presentation.servlet;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/client")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	/** The Client EJB **/
	@EJB
	private IClientTransactionalBoundaryLocal clientService;
	
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//The request dispacher
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		req.removeAttribute("message");
		rd.forward(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//The request dispacher
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		try {
			//Obtain the client data...
			if(validateClientRequestParams(request)){
				//Add and validate new client...
				Client c = new Client();
				c.setName(request.getAttribute("clientName").toString());
				c.setAge(Integer.parseInt(request.getAttribute("clientAge").toString()));
				c.setAddress(request.getAttribute("clientAddress").toString());
				c.setClientId(Integer.parseInt(request.getAttribute("clientId").toString()));
				clientService.saveClient(c);
				request.setAttribute("message", "Client persisted successfully!");
				
			}else {
				request.setAttribute("message", "Error parsing the current parameters. Make sure you fill all the fields with valid information.");
			}
			
			List<Client> clientList = clientService.fetchAllClients();
			response.getWriter().println("Client list: ");
			response.getWriter().println();
			
			for (Client client : clientList) {
				response.getWriter().append("* ").append(client.getName());
				response.getWriter().println();
			}
			
			response.getWriter().println("end of list. ");
			rd.forward(request, response);
		} catch (TeamTransactionException e) {
			request.setAttribute("message", "Error parsing the current parameters. Make sure you fill all the fields with valid information.");
		}
	}
	
	/**
	 * Validates if all the params sent to the request are valid or not null.
	 * @param request
	 * @return
	 */
	private boolean validateClientRequestParams(HttpServletRequest request){
		try {
			Integer.parseInt(request.getAttribute("clientId").toString());
			request.getAttribute("clientName").toString();
			Integer.parseInt(request.getAttribute("clientAge").toString());
			request.getAttribute("clientAddress").toString();
			return true;
			
		} catch (NullPointerException e) {
			return false;
		} catch (NumberFormatException e){
			return false;
		}	
		
	}

}

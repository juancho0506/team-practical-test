package com.team.presentation.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.business.boundary.IClientTransactionalBoundaryLocal;

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

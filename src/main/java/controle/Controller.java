package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.*;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestTraitment(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestTraitment(request, response);
	}

	protected void requestTraitment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter("action");
		String destinationPage = "/views/General/error.jsp";
		String flashbag = "";
		String flashbagType = "";
		
		
		if ("index".equals(actionName)) {
			destinationPage = "/views/index.jsp";
		}
		
		if ("contact".equals(actionName)) {
			destinationPage = "/views/General/contact.jsp";
		}
		
		if("contactValidation".equals(actionName)) {
			try {
				SendEmail.sendMail("FROM" +request.getParameter("name")+" ( "+request.getParameter("mail")+" ) : "+request.getParameter("content"), "expo.polytech.lyon@gmail.com");
				
				SendEmail.sendMail("Votre message : \n\n "+request.getParameter("content")+"\n\n a été transféré avec succès, vous recevrez une réponse sous 48h.", request.getParameter("mail"));
				
				flashbag = "Le message a été envoyé.";
				flashbagType = "success";
			} catch (Exception e) {
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/General/contact.jsp";
		}
		
		if ("location".equals(actionName)) {
			destinationPage = "/views/General/location.jsp";
		}

		else {
			String errorMessage = "[" + actionName + "] n'est pas une action valide.";
			request.setAttribute("messageError", errorMessage);
		}
		// Redirection to the appropriate jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);

	}

}

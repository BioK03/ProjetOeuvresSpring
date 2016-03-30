package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdherentService;
import dao.BookingService;
import meserreurs.MyException;
import metier.Adherent;

/**
 * Servlet implementation class AdherentController
 */
@WebServlet("/AdherentController")
public class AdherentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdherentController() {
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
		requestTreatment(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestTreatment(request, response);
	}

	protected void requestTreatment(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String actionName = request.getParameter("action");
		String flashbag = "";
		String flashbagType = "";

		BookingService bookingService = new BookingService();
		AdherentService adherentService = new AdherentService();
		
		String destinationPage = "/views/index.jsp";
		// execute l'action
		if ("list".equals(actionName)) {
			try {
				request.setAttribute("adherents", adherentService.findAll());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Adherent/list.jsp";
		}

		else if ("add".equals(actionName)) {

			destinationPage = "/views/Adherent/add.jsp";
		} 
		
		else if ("details".equals(actionName)) {
			try {
				request.setAttribute("adherent", adherentService.findById(Integer.parseInt(request.getParameter("id"))));
				request.setAttribute("bookings", bookingService.findByAdherent(Integer.parseInt(request.getParameter("id"))));

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Adherent/details.jsp";
		}
		
		else if ("insertOrUpdate".equals(actionName)) {
			try {
				Adherent adherent = new Adherent();
				String id = request.getParameter("id");
				if(id!=null)
				{
					adherent.setId(Integer.parseInt(id));
					flashbag="L'adherent à été mise à jour correctement.";
				}
				else
				{
					flashbag="L'adherent à été crée correctement.";
				}
				adherent.setLastname(request.getParameter("lastname"));
				adherent.setFirstname(request.getParameter("firstname"));
				adherent.setCity(request.getParameter("city"));
				adherentService.insertOrUpdate(adherent);
				flashbagType="success";

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			try {
				request.setAttribute("adherents", adherentService.findAll());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			destinationPage = "/views/Adherent/list.jsp";
		}
		
		else if ("edit".equals(actionName)) {
			try {
				Adherent adherent = adherentService.findById(Integer.parseInt(request.getParameter("id")));
				if(adherent==null)
				{
					throw new MyException("Cet adherent n'existe pas");
				}
				request.setAttribute("adherent", adherent);

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/Adherent/edit.jsp";
		}
		
		else if ("deleteConfirmation".equals(actionName)) {
			try {
				Adherent adherent = adherentService.findById(Integer.parseInt(request.getParameter("id")));
				if(adherent==null)
				{
					throw new MyException("Cet adherent n'existe pas");
				}
				request.setAttribute("adherent", adherent);

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/Adherent/delete.jsp";
		}
		
		else if ("delete".equals(actionName)) {
			try {
				if(request.getParameter("id")==null)
				{
					throw new MyException("Cet adherent n'existe pas");
				}
				int adherentId = Integer.parseInt(request.getParameter("id"));
			
				adherentService.delete(adherentId);
				flashbag="L'adherent à été supprimé correctement.";
						flashbagType="success";

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			try {
				request.setAttribute("adherents", adherentService.findAll());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			destinationPage = "/views/Adherent/list.jsp";
		}

		else {
			flashbag = "[" + actionName + "] n'est pas une action valide.";
			flashbagType="error";
		}
		
		request.setAttribute("flashbag", flashbag);
		request.setAttribute("flashbagType", flashbagType);
	
		// Redirection to the appropriate jsp page
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(destinationPage);
		dispatcher.forward(request, response);		
	}

}

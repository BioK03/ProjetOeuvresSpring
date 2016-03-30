package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OwnerService;
import dao.OeuvreService;
import meserreurs.MyException;
import metier.Owner;

/**
 * Servlet implementation class AdherentController
 */
@WebServlet("/OwnerController")
public class OwnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OwnerController() {
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

		OeuvreService oeuvreService = new OeuvreService();
		OwnerService ownerService = new OwnerService();
		String destinationPage = "/views/index.jsp";
		// execute l'action
		if ("list".equals(actionName)) {
			try {
				request.setAttribute("owners", ownerService.findAll());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Owner/list.jsp";
		}
		
		else if ("details".equals(actionName)) {
			try {
				request.setAttribute("owner", ownerService.findById(Integer.parseInt(request.getParameter("id"))));
				request.setAttribute("loanOeuvres", oeuvreService.findLoanByOwner(Integer.parseInt(request.getParameter("id"))));
				request.setAttribute("sellOeuvres", oeuvreService.findSellByOwner(Integer.parseInt(request.getParameter("id"))));

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Owner/details.jsp";
		}

		else if ("add".equals(actionName)) {

			destinationPage = "/views/Owner/add.jsp";
		} 
		
		else if ("insertOrUpdate".equals(actionName)) {
			try {
				Owner owner = new Owner();
				String id = request.getParameter("id");
				if(id!=null)
				{
					owner.setId(Integer.parseInt(id));
					flashbag="Le proprietaire à été mise à jour correctement.";
				}
				else
				{
					flashbag="Le proprietaire à été crée correctement.";
				}
				owner.setLastname(request.getParameter("lastname"));
				owner.setFirstname(request.getParameter("firstname"));
				ownerService.insertOrUpdate(owner);
				flashbagType="success";

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			try {
				request.setAttribute("owners", ownerService.findAll());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			destinationPage = "/views/Owner/list.jsp";
		}
		
		else if ("edit".equals(actionName)) {
			try {
				Owner owner = ownerService.findById(Integer.parseInt(request.getParameter("id")));
				if(owner==null)
				{
					throw new MyException("Ce proprietaire n'existe pas");
				}
				request.setAttribute("owner", owner);

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/Owner/edit.jsp";
		}
		
		else if ("deleteConfirmation".equals(actionName)) {
			try {
				Owner owner = ownerService.findById(Integer.parseInt(request.getParameter("id")));
				if(owner==null)
				{
					throw new MyException("Ce propietaire n'existe pas");
				}
				request.setAttribute("owner", owner);
				request.setAttribute("loanOeuvres", oeuvreService.findLoanByOwner(owner.getId()));
				request.setAttribute("sellOeuvres", oeuvreService.findSellByOwner(owner.getId()));
				/*for(int i=0; i<oeuvreService.findLoanByOwner(owner.getId()).size(); i++)
				{
					System.out.println(oeuvreService.findLoanByOwner(owner.getId()).get(i).getTitle());
				}*/

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/Owner/delete.jsp";
		}
		
		else if ("delete".equals(actionName)) {
			try {
				if(request.getParameter("id")==null)
				{
					throw new MyException("Ce proprietaire n'existe pas");
				}
				int ownerId = Integer.parseInt(request.getParameter("id"));
			
				ownerService.delete(ownerId);
				flashbag="Le proprietaire à été supprimé correctement.";
						flashbagType="success";

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			try {
				request.setAttribute("adherents", ownerService.findAll());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			destinationPage = "/views/Owner/list.jsp";
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

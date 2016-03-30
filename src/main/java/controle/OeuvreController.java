package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OeuvreService;
import dao.OwnerService;
import dao.AdherentService;
import dao.BookingService;
import meserreurs.MyException;
import metier.LoanOeuvre;
import metier.SellOeuvre;


/**
 * Servlet implementation class OeuvreController
 */
@WebServlet("/OeuvreController")
public class OeuvreController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OeuvreController() {
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

		OwnerService ownerService = new OwnerService();
		BookingService bookingService = new BookingService();
		OeuvreService oeuvreService = new OeuvreService();
		
		String destinationPage = "/views/index.jsp";
		// execute l'action
		if ("listLoan".equals(actionName)) {
			try {
				request.setAttribute("loanOeuvres", oeuvreService.findAllLoan());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Oeuvre/loanList.jsp";
		}

		else if ("listSell".equals(actionName)) {
			try {
				request.setAttribute("sellOeuvres", oeuvreService.findAllSell());

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Oeuvre/sellList.jsp";
		}
		
		else if ("sellDetails".equals(actionName)) {
			try {
				request.setAttribute("oeuvre", oeuvreService.findSellById(Integer.parseInt(request.getParameter("id"))));
				request.setAttribute("bookings", bookingService.findByOeuvre(Integer.parseInt(request.getParameter("id"))));

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}

			destinationPage = "/views/Oeuvre/details.jsp";
		}
		
		else if ("add".equals(actionName)) {
			try {
				request.setAttribute("owners", ownerService.findAll());
			}
			catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			destinationPage = "/views/Oeuvre/add.jsp";
		} 
		
		else if ("insertOrUpdate".equals(actionName)) {
			try {
				String id = request.getParameter("id");
				LoanOeuvre loanOeuvre = new LoanOeuvre();
				SellOeuvre sellOeuvre = new SellOeuvre();
				
				if(id!=null)
				{
					if(request.getParameter("type")=="loan")
					{
						loanOeuvre.setId(Integer.parseInt(id));
					}
					else
					{
						sellOeuvre.setId(Integer.parseInt(id));
					}
					flashbag="L'oeuvre à été mise à jour correctement.";
				}
				else
				{
					flashbag="L'oeuvre à été créee correctement.";
				}
				flashbagType="success";
				
				//System.out.println(request.getParameter("type"));
				
				if(request.getParameter("type").equals("loan"))
				{
					loanOeuvre.setTitle(request.getParameter("title"));
					loanOeuvre.setOwner(ownerService.findById(Integer.parseInt(request.getParameter("owner"))));
					oeuvreService.insertOrUpdate(loanOeuvre);
					try {
						
						request.setAttribute("loanOeuvres", oeuvreService.findAllLoan());

					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						flashbag=e.getMessage();
						flashbagType="error";
					}
					destinationPage = "/views/Oeuvre/loanList.jsp";
				}
				else
				{
					System.out.println(request.getParameter("price"));
					sellOeuvre.setTitle(request.getParameter("title"));
					sellOeuvre.setCondition(request.getParameter("condition"));
					sellOeuvre.setPrice(Float.parseFloat((String)request.getParameter("price")));
					sellOeuvre.setOwner(ownerService.findById(Integer.parseInt(request.getParameter("owner"))));
					oeuvreService.insertOrUpdate(sellOeuvre);
					try {
						
						request.setAttribute("sellOeuvres", oeuvreService.findAllSell());

					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						flashbag=e.getMessage();
						flashbagType="error";
					}
					destinationPage = "/views/Oeuvre/sellList.jsp";
				}

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
		}
		
		else if ("edit".equals(actionName)) {
			try {
				request.setAttribute("owners", ownerService.findAll());
				
				if(request.getParameter("type").equals("loan"))
				{
					LoanOeuvre loanOeuvre = oeuvreService.findLoanLById(Integer.parseInt(request.getParameter("id")));
					if(loanOeuvre==null)
					{
						throw new MyException("Cette oeuvre n'existe pass");
					}
					request.setAttribute("oeuvre", loanOeuvre);
					request.setAttribute("type", "loan");
				}
				else
				{
					SellOeuvre sellOeuvre = oeuvreService.findSellById(Integer.parseInt(request.getParameter("id")));
					if(sellOeuvre==null)
					{
						throw new MyException("Cette oeuvre n'existe pas");
					}
					request.setAttribute("oeuvre", sellOeuvre);
					request.setAttribute("type", "sell");
				}

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/Oeuvre/edit.jsp";
		}
		
		else if ("deleteConfirmation".equals(actionName)) {
			try {				
				if(request.getParameter("type")=="loan")
				{
					LoanOeuvre loanOeuvre = oeuvreService.findLoanLById(Integer.parseInt(request.getParameter("id")));
					if(loanOeuvre==null)
					{
						throw new MyException("Cette oeuvre n'existe pas");
					}
					request.setAttribute("oeuvre", loanOeuvre);
					request.setAttribute("type", "loan");
					
				}
				else
				{
					SellOeuvre sellOeuvre = oeuvreService.findSellById(Integer.parseInt(request.getParameter("id")));
					if(sellOeuvre==null)
					{
						throw new MyException("Cette oeuvre n'existe pas");
					}
					request.setAttribute("oeuvre", sellOeuvre);
					request.setAttribute("type", "sell");
				}

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
			
			destinationPage = "/views/Oeuvre/delete.jsp";
		}
		
		else if ("delete".equals(actionName)) {
			try {
				String id = request.getParameter("id");
				LoanOeuvre loanOeuvre = new LoanOeuvre();
				SellOeuvre sellOeuvre = new SellOeuvre();
				
				flashbag = "L'oeuvre à été supprimée correctement";
				flashbagType = "success";
				
				if(request.getParameter("type")=="loan")
				{
					oeuvreService.deleteLoan(loanOeuvre.getId());
					try {
						
						request.setAttribute("loanOeuvres", oeuvreService.findAllLoan());

					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						flashbag=e.getMessage();
						flashbagType="error";
					}
					destinationPage = "/views/Oeuvre/loanList.jsp";
				}
				else
				{
					oeuvreService.deleteSell(sellOeuvre.getId());
					try {
						
						request.setAttribute("sellOeuvres", oeuvreService.findAllSell());

					} catch (MyException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						flashbag=e.getMessage();
						flashbagType="error";
					}
					destinationPage = "/views/Oeuvre/sellList.jsp";
				}

			} catch (MyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				flashbag=e.getMessage();
				flashbagType="error";
			}
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

package dao;

import meserreurs.MyException;
import java.util.*;

import metier.*;
import persistance.*;

public class OeuvreService {

	public void insertOrUpdate(LoanOeuvre loanOeuvre) throws MyException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			if(loanOeuvre.getId()!=0)
			{
				mysql = "update oeuvrepret set titre_oeuvrepret='"+ loanOeuvre.getTitle()+
											"',id_proprietaire='"+ loanOeuvre.getOwner().getId()+
											"' where id_oeuvrepret ="+loanOeuvre.getId();
			}
			else
			{
				mysql = "insert into oeuvrepret  (titre_oeuvrepret,id_proprietaire)  " + "values ('"
						+ loanOeuvre.getTitle();
				mysql += "','" + loanOeuvre.getOwner().getId() +"')";
			}

			unDialogueBd.insertionBD(mysql);
		} catch (MyException e) {
			throw e;
		}
	}
	
	public void insertOrUpdate(SellOeuvre sellOeuvre) throws MyException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			if(sellOeuvre.getId()!=0)
			{
				mysql = "update oeuvrevente set titre_oeuvrevente='"+ sellOeuvre.getTitle()+
											"',id_proprietaire='"+ sellOeuvre.getOwner().getId()+
											"',etat_oeuvrevente='"+ sellOeuvre.getCondition()+
											"',prix_oeuvrevente='"+ sellOeuvre.getPrice()+
											"' where id_oeuvrevente ="+sellOeuvre.getId();
			}
			else
			{
				mysql = "insert into oeuvrevente  (titre_oeuvrevente,id_proprietaire,etat_oeuvrevente,prix_oeuvrevente)  " + "values ('"
						+ sellOeuvre.getTitle();
				mysql += "','" + sellOeuvre.getOwner().getId() +"','" + sellOeuvre.getCondition() +"','" + sellOeuvre.getPrice() +"')";
			}

			unDialogueBd.insertionBD(mysql);
		} catch (MyException e) {
			throw e;
		}
	}
	
	public void deleteLoan(int loanOeuvreId) throws MyException {
		String mysql = "delete FROM oeuvrepret WHERE id_oeuvrepret="+loanOeuvreId;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		unDialogueBd.execute(mysql);		
	}
	
	public void deleteSell(int sellOeuvreId) throws MyException {
		String mysql = "delete FROM oeuvrevente WHERE id_oeuvrepret="+sellOeuvreId;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		unDialogueBd.execute(mysql);
		mysql = "delete FROM reservation WHERE id_oeuvrevente="+sellOeuvreId;
		unDialogueBd.execute(mysql);		
	}

	public LoanOeuvre findLoanLById(int id) throws MyException {
		String mysql = "select * from oeuvrepret where id_oeuvrepret=" + id;
		List<LoanOeuvre> loanOeuvres = findLoanBySQL(mysql);
		if (loanOeuvres.isEmpty())
			return null;
		else {
			return loanOeuvres.get(0);
		}
	}
	
	public List<LoanOeuvre> findLoanByOwner(int ownerId) throws MyException {
		String mysql = "select * from oeuvrepret where id_proprietaire=" + ownerId;
		List<LoanOeuvre> loanOeuvres = findLoanBySQL(mysql);
		if (loanOeuvres.isEmpty())
			return null;
		else {
			return loanOeuvres;
		}
	}
	
	public SellOeuvre findSellById(int id) throws MyException {
		String mysql = "select * from oeuvrevente where id_oeuvrevente=" + id;
		List<SellOeuvre> sellOeuvres = findSellBySQL(mysql);
		if (sellOeuvres.isEmpty())
			return null;
		else {
			return sellOeuvres.get(0);
		}
	}
	
	public List<SellOeuvre> findSellByOwner(int ownerId) throws MyException {
		String mysql = "select * from oeuvrevente where id_proprietaire=" + ownerId;
		List<SellOeuvre> sellOeuvres = findSellBySQL(mysql);
		if (sellOeuvres.isEmpty())
			return null;
		else {
			return sellOeuvres;
		}
	}

	public List<LoanOeuvre> findAllLoan() throws MyException {
		String mysql = "select * from oeuvrepret";
		return findLoanBySQL(mysql);
	}
	
	public List<SellOeuvre> findAllSell() throws MyException {
		String mysql = "select * from oeuvrevente";
		return findSellBySQL(mysql);
	}

	private List<LoanOeuvre> findLoanBySQL(String mysql) throws MyException {
		List<Object> rs;
		List<LoanOeuvre> loanOeuvres = new ArrayList<LoanOeuvre>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				LoanOeuvre loanOeuvre = new LoanOeuvre();
				loanOeuvre.setId(Integer.parseInt(rs.get(index + 0).toString()));
				loanOeuvre.setTitle(rs.get(index + 1).toString());
				OwnerService ownerService = new OwnerService();
				loanOeuvre.setOwner(ownerService.findById(Integer.parseInt(rs.get(index + 2).toString())));
				index += 3;
				loanOeuvres.add(loanOeuvre);
			}

			return loanOeuvres;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}
	
	private List<SellOeuvre> findSellBySQL(String mysql) throws MyException {
		List<Object> rs;
		List<SellOeuvre> sellOeuvres = new ArrayList<SellOeuvre>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				SellOeuvre sellOeuvre = new SellOeuvre();
				sellOeuvre.setId(Integer.parseInt(rs.get(index + 0).toString()));
				sellOeuvre.setTitle(rs.get(index + 1).toString());
				sellOeuvre.setCondition(rs.get(index + 2).toString());
				sellOeuvre.setPrice(Float.parseFloat(rs.get(index + 3).toString()));
				OwnerService ownerService = new OwnerService();
				sellOeuvre.setOwner(ownerService.findById(Integer.parseInt(rs.get(index + 4).toString())));
				index += 5;
				sellOeuvres.add(sellOeuvre);
			}

			return sellOeuvres;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

}

package dao;

import meserreurs.MyException;
import java.util.*;

import metier.*;
import persistance.*;

public class AdherentService {

	public void insertOrUpdate(Adherent adherent) throws MyException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			if(adherent.getId()!=0)
			{
				mysql = "update adherent set nom_adherent='"+ adherent.getLastname()+
											"',prenom_adherent='"+ adherent.getFirstname()+
											"',ville_adherent='"+ adherent.getCity()+
											"' where id_adherent ="+adherent.getId();
			}
			else
			{
				mysql = "insert into adherent  (nom_adherent,prenom_adherent,ville_adherent)  " + "values ('"
						+ adherent.getLastname();
				mysql += "','" + adherent.getFirstname() + "','" + adherent.getCity() + "')";
			}

			unDialogueBd.insertionBD(mysql);
		} catch (MyException e) {
			throw e;
		}
	}
	
	public boolean exist(Adherent adherent) throws MyException {
		return findById(adherent.getId())!=null;
	}
	
	public void delete(int adherentId) throws MyException {
		String mysql = "delete FROM adherent WHERE id_adherent="+adherentId;
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		unDialogueBd.execute(mysql);
		mysql = "delete FROM reservation WHERE id_adherent="+adherentId;
		unDialogueBd.execute(mysql);		
	}

	public Adherent findById(int id) throws MyException {
		String mysql = "select * from adherent where id_adherent=" + id;
		List<Adherent> adherents = findBySQL(mysql);
		if (adherents.isEmpty())
			return null;
		else {
			return adherents.get(0);
		}
	}

	public List<Adherent> findAll() throws MyException {
		String mysql = "select * from adherent";
		return findBySQL(mysql);
	}

	private List<Adherent> findBySQL(String mysql) throws MyException {
		List<Object> rs;
		List<Adherent> adherents = new ArrayList<Adherent>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Adherent adherent = new Adherent();
				adherent.setId(Integer.parseInt(rs.get(index + 0).toString()));
				adherent.setLastname(rs.get(index + 1).toString());
				adherent.setFirstname(rs.get(index + 2).toString());
				adherent.setCity(rs.get(index + 3).toString());
				index += 4;
				adherents.add(adherent);
			}

			return adherents;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

}

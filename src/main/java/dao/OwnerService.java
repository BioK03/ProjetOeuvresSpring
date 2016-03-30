package dao;

import meserreurs.MyException;
import java.util.*;

import metier.*;
import persistance.*;

public class OwnerService {

	public void insertOrUpdate(Owner owner) throws MyException {
		String mysql;

		DialogueBd unDialogueBd = DialogueBd.getInstance();
		try {
			if(owner.getId()!=0)
			{
				mysql = "update proprietaire set nom_proprietaire='"+ owner.getLastname()+
											"',prenom_proprietaire='"+ owner.getFirstname()+
											"' where id_proprietaire ="+owner.getId();
			}
			else
			{
				mysql = "insert into proprietaire  (nom_proprietaire,prenom_proprietaire)  " + "values ('"
						+ owner.getLastname();
				mysql += "','" + owner.getFirstname() + "')";
			}

			unDialogueBd.insertionBD(mysql);
		} catch (MyException e) {
			throw e;
		}
	}
	
	public void delete(int ownerId) throws MyException {
		DialogueBd unDialogueBd = DialogueBd.getInstance();
		String mysql = "delete FROM oeuvrevente WHERE id_proprietaire="+ownerId;
		unDialogueBd.execute(mysql);
		mysql = "delete FROM proprietaire WHERE id_proprietaire="+ownerId;
		unDialogueBd.execute(mysql);
	}
	

	public Owner findById(int id) throws MyException {
		String mysql = "select * from proprietaire where id_proprietaire=" + id;
		List<Owner> owners = findBySQL(mysql);
		if (owners.isEmpty())
			return null;
		else {
			return owners.get(0);
		}
	}

	public List<Owner> findAll() throws MyException {
		String mysql = "select * from proprietaire";
		return findBySQL(mysql);
	}

	private List<Owner> findBySQL(String mysql) throws MyException {
		List<Object> rs;
		List<Owner> owners = new ArrayList<Owner>();
		int index = 0;
		try {
			DialogueBd unDialogueBd = DialogueBd.getInstance();
			rs = DialogueBd.lecture(mysql);
			while (index < rs.size()) {
				Owner owner = new Owner();
				owner.setId(Integer.parseInt(rs.get(index + 0).toString()));
				owner.setLastname(rs.get(index + 1).toString());
				owner.setFirstname(rs.get(index + 2).toString());
				index += 3;
				owners.add(owner);
			}

			return owners;
		} catch (Exception exc) {
			throw new MyException(exc.getMessage(), "systeme");
		}
	}

}

package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proprietaire database table.
 * 
 */
@Entity(name="Proprietaire")
@NamedQuery(name="Proprietaire.findAll", query="SELECT p FROM Proprietaire p")
public class Owner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_proprietaire")
	private int idProprietaire;

	@Column(name="nom_proprietaire")
	private String nomProprietaire;

	@Column(name="prenom_proprietaire")
	private String prenomProprietaire;

	//bi-directional many-to-one association to Oeuvrepret
	@OneToMany(mappedBy="proprietaire")
	private List<LoanOeuvre> oeuvreprets;

	//bi-directional many-to-one association to Oeuvrevente
	@OneToMany(mappedBy="proprietaire")
	private List<SellOeuvre> oeuvreventes;

	public Owner() {
	}

	public int getId() {
		return this.idProprietaire;
	}

	public void setId(int idProprietaire) {
		this.idProprietaire = idProprietaire;
	}

	public String getLastname() {
		return this.nomProprietaire;
	}

	public void setLastname(String nomProprietaire) {
		this.nomProprietaire = nomProprietaire;
	}

	public String getFirstname() {
		return this.prenomProprietaire;
	}

	public void setFirstname(String prenomProprietaire) {
		this.prenomProprietaire = prenomProprietaire;
	}

	public List<LoanOeuvre> getOeuvreprets() {
		return this.oeuvreprets;
	}

	public void setOeuvreprets(List<LoanOeuvre> oeuvreprets) {
		this.oeuvreprets = oeuvreprets;
	}

	public LoanOeuvre addOeuvrepret(LoanOeuvre oeuvrepret) {
		getOeuvreprets().add(oeuvrepret);
		oeuvrepret.setOwner(this);

		return oeuvrepret;
	}

	public LoanOeuvre removeOeuvrepret(LoanOeuvre oeuvrepret) {
		getOeuvreprets().remove(oeuvrepret);
		oeuvrepret.setOwner(null);

		return oeuvrepret;
	}

	public List<SellOeuvre> getOeuvreventes() {
		return this.oeuvreventes;
	}

	public void setOeuvreventes(List<SellOeuvre> oeuvreventes) {
		this.oeuvreventes = oeuvreventes;
	}

	public SellOeuvre addOeuvrevente(SellOeuvre oeuvrevente) {
		getOeuvreventes().add(oeuvrevente);
		oeuvrevente.setOwner(this);

		return oeuvrevente;
	}

	public SellOeuvre removeOeuvrevente(SellOeuvre oeuvrevente) {
		getOeuvreventes().remove(oeuvrevente);
		oeuvrevente.setOwner(null);

		return oeuvrevente;
	}

}
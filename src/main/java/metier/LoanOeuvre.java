package metier;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the oeuvrepret database table.
 * 
 */
@Entity(name="OeuvrePret")
@NamedQuery(name="Oeuvrepret.findAll", query="SELECT o FROM OeuvrePret o")
public class LoanOeuvre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_oeuvrepret")
	private int idOeuvrepret;

	@Column(name="titre_oeuvrepret")
	private String titreOeuvrepret;

	//bi-directional many-to-one association to Proprietaire
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_proprietaire")
	private Owner proprietaire;

	public LoanOeuvre() {
	}

	public int getId() {
		return this.idOeuvrepret;
	}

	public void setId(int idOeuvrepret) {
		this.idOeuvrepret = idOeuvrepret;
	}

	public String getTitle() {
		return this.titreOeuvrepret;
	}

	public void setTitle(String titreOeuvrepret) {
		this.titreOeuvrepret = titreOeuvrepret;
	}

	public Owner getOwner() {
		return this.proprietaire;
	}

	public void setOwner(Owner proprietaire) {
		this.proprietaire = proprietaire;
	}

}
package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the oeuvrevente database table.
 * 
 */
@Entity(name="OeuvreVente")
@NamedQuery(name="Oeuvrevente.findAll", query="SELECT o FROM OeuvreVente o")
public class SellOeuvre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_oeuvrevente")
	private int idOeuvrevente;

	@Column(name="etat_oeuvrevente")
	private String etatOeuvrevente;

	@Column(name="prix_oeuvrevente")
	private float prixOeuvrevente;

	@Column(name="titre_oeuvrevente")
	private String titreOeuvrevente;

	//bi-directional many-to-one association to Proprietaire
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_proprietaire")
	private Owner proprietaire;

	//bi-directional many-to-one association to Reservation
	@OneToMany(mappedBy="oeuvrevente")
	private List<Booking> reservations;

	public SellOeuvre() {
	}

	public int getId() {
		return this.idOeuvrevente;
	}

	public void setId(int idOeuvrevente) {
		this.idOeuvrevente = idOeuvrevente;
	}

	public String getCondition() {
		return this.etatOeuvrevente;
	}

	public void setCondition(String etatOeuvrevente) {
		this.etatOeuvrevente = etatOeuvrevente;
	}

	public float getPrice() {
		return this.prixOeuvrevente;
	}

	public void setPrice(float prixOeuvrevente) {
		this.prixOeuvrevente = prixOeuvrevente;
	}

	public String getTitle() {
		return this.titreOeuvrevente;
	}

	public void setTitle(String titreOeuvrevente) {
		this.titreOeuvrevente = titreOeuvrevente;
	}

	public Owner getOwner() {
		return this.proprietaire;
	}

	public void setOwner(Owner proprietaire) {
		this.proprietaire = proprietaire;
	}

	public List<Booking> getReservations() {
		return this.reservations;
	}

	public void setReservations(List<Booking> reservations) {
		this.reservations = reservations;
	}

	public Booking addReservation(Booking reservation) {
		getReservations().add(reservation);
		reservation.setSellOeuvre(this);

		return reservation;
	}

	public Booking removeReservation(Booking reservation) {
		getReservations().remove(reservation);
		reservation.setSellOeuvre(null);

		return reservation;
	}

}
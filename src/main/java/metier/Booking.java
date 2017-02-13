package metier;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the reservation database table.
 * 
 */
@Entity(name="Reservation")
@NamedQuery(name="Reservation.findAll", query="SELECT r FROM Reservation r")
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ReservationPK id;

	@Temporal(TemporalType.DATE)
	@Column(name="date_reservation")
	private Date dateReservation;

	private String statut;

	//bi-directional many-to-one association to Oeuvrevente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_oeuvrevente")
	private SellOeuvre oeuvrevente;

	//bi-directional many-to-one association to Adherent
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_adherent")
	private Adherent adherent;

	public Booking() {
	}

	public Date getDate() {
		return this.dateReservation;
	}

	public void setDate(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public String getStatus() {
		return this.statut;
	}

	public void setStatus(String statut) {
		this.statut = statut;
	}

	public SellOeuvre getSellOeuvre() {
		return this.oeuvrevente;
	}

	public void setSellOeuvre(SellOeuvre oeuvrevente) {
		this.oeuvrevente = oeuvrevente;
	}

	public Adherent getAdherent() {
		return this.adherent;
	}

	public void setAdherent(Adherent adherent) {
		this.adherent = adherent;
	}

}
package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the HOUSEHOLDEARNERS database table.
 * 
 */
@Entity
@Table(name="HOUSEHOLDEARNERS", schema="APP")
public class HouseholdEarner implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(nullable=false)
	private String description;

	@OneToMany(mappedBy="householdEarner")
	private List<Household> households;

	public HouseholdEarner() {
	}

	public short getId() {
		return this.id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Household> getHouseholds() {
		return this.households;
	}

	public void setHouseholds(List<Household> households) {
		this.households = households;
	}

	public Household addHousehold(Household household) {
		getHouseholds().add(household);
		household.setHouseholdearner(this);

		return household;
	}

	public Household removeHousehold(Household household) {
		getHouseholds().remove(household);
		household.setHouseholdearner(null);

		return household;
	}

}
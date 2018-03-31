package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the HOUSEHOLDSBYAGERANGE database table.
 * 
 */
@Entity
@Table(name="HOUSEHOLDSBYAGERANGE", schema="APP")
public class HouseholdsByAgeRange implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(nullable=false)
	private String description;

	@OneToMany(mappedBy="householdsByAgeRange")
	private List<Household> households;

	public HouseholdsByAgeRange() {
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
		household.setHouseholdsByAgeRange(this);

		return household;
	}

	public Household removeHousehold(Household household) {
		getHouseholds().remove(household);
		household.setHouseholdsByAgeRange(null);

		return household;
	}

}
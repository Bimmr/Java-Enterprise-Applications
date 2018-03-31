package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the HOUSEHOLDTYPE database table.
 * 
 */
@Entity
@Table(name="HOUSEHOLDTYPE", schema="APP")
public class HouseholdType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(nullable=false)
	private String description;

	@OneToMany(mappedBy="householdType")
	private List<Household> households;

	public HouseholdType() {
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

	public Household addHouseholds(Household households) {
		getHouseholds().add(households);
		households.setHouseholdtype(this);

		return households;
	}

	public Household removeHouseholds(Household households) {
		getHouseholds().remove(households);
		households.setHouseholdtype(null);

		return households;
	}


}
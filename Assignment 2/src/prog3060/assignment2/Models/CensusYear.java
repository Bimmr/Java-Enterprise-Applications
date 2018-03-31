package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the CENSUSYEAR database table.
 * 
 */
@Entity
@Table(name="CENSUSYEAR", schema="APP")
public class CensusYear implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int censusYearID;

	@Column(nullable=false)
	private int censusYear;

	@OneToMany(mappedBy="censusYear")
	private List<Age> ages;

	@OneToMany(mappedBy="geographicArea")
	private List<Household> households;
	
	public CensusYear() {
	}


	public List<Household> getHouseholds() {
		return this.households;
	}

	public void setHouseholds(List<Household> households) {
		this.households = households;
	}

	public Household addHousehold(Household household) {
		getHouseholds().add(household);
		household.setCensusYear(this);

		return household;
	}

	public Household removeHousehold(Household household) {
		getHouseholds().remove(household);
		household.setCensusYear(null);

		return household;
	}
	public int getCensusYearID() {
		return this.censusYearID;
	}

	public void setCensusYearID(int censusyearid) {
		this.censusYearID = censusyearid;
	}

	public int getCensusYear() {
		return this.censusYear;
	}

	public void setCensusYear(int censusyear) {
		this.censusYear = censusyear;
	}

	public List<Age> getAges() {
		return this.ages;
	}

	public void setAges(List<Age> ages) {
		this.ages = ages;
	}

	public Age addAge(Age age) {
		getAges().add(age);
		age.setCensusYear(this);

		return age;
	}

	public Age removeAge(Age age) {
		getAges().remove(age);
		age.setCensusYear(null);

		return age;
	}

}
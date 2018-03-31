package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the GEOGRAPHICAREA database table.
 * 
 */
@Entity
@Table(name="GEOGRAPHICAREA", schema="APP")
public class GeographicArea implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int geographicAreaID;

	@Column(nullable=false)
	private int alternativeCode;

	@Column(nullable=false)
	private int code;

	@Column(nullable=false)
	private int level;

	@Column(nullable=false)
	private String name;

	@OneToMany(mappedBy="geographicArea")
	private List<Age> ages;

	@OneToMany(mappedBy="geographicArea")
	private List<Household> households;

	public GeographicArea() {
	}

	public int getGeographicAreaID() {
		return this.geographicAreaID;
	}

	public void setGeographicAreaID(int geographicareaid) {
		this.geographicAreaID = geographicareaid;
	}

	public int getAlternativeCode() {
		return this.alternativeCode;
	}

	public void setAlternativeCode(int alternativecode) {
		this.alternativeCode = alternativecode;
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Age> getAges() {
		return this.ages;
	}

	public void setAges(List<Age> ages) {
		this.ages = ages;
	}

	public Age addAge(Age age) {
		getAges().add(age);
		age.setGeographicArea(this);

		return age;
	}

	public Age removeAge(Age age) {
		getAges().remove(age);
		age.setGeographicArea(null);

		return age;
	}

	public List<Household> getHouseholds() {
		return this.households;
	}

	public void setHouseholds(List<Household> households) {
		this.households = households;
	}

	public Household addHousehold(Household household) {
		getHouseholds().add(household);
		household.setGeographicArea(this);

		return household;
	}

	public Household removeHousehold(Household household) {
		getHouseholds().remove(household);
		household.setGeographicArea(null);

		return household;
	}

}
package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the HOUSEHOLD database table.
 * 
 */
@Entity
@Table(name="HOUSEHOLD", schema="APP")
public class Household implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="CENSUSYEAR")
	private CensusYear censusYear;

	@Column(nullable=false)
	private int numberReported;

	@ManyToOne
	@JoinColumn(name="GEOGRAPHICAREA")
	private GeographicArea geographicArea;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDEARNERS")
	private HouseholdEarner householdEarner;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSBYAGERANGE")
	private HouseholdsByAgeRange householdsByAgeRange;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDSIZE")
	private HouseholdSize householdSize;

	@ManyToOne
	@JoinColumn(name="HOUSEHOLDTYPE")
	private HouseholdType householdType;
	
	@ManyToOne
	@JoinColumn(name="TOTALINCOME")
	private TotalIncome totalIncome;

	public Household() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CensusYear getCensusYear() {
		return this.censusYear;
	}

	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}

	public int getNumberReported() {
		return this.numberReported;
	}

	public void setNumberReported(int numberreported) {
		this.numberReported = numberreported;
	}

	public GeographicArea getGeographicArea() {
		return this.geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicareaBean) {
		this.geographicArea = geographicareaBean;
	}

	public HouseholdEarner getHouseholdearner() {
		return this.householdEarner;
	}

	public void setHouseholdearner(HouseholdEarner householdEarner) {
		this.householdEarner = householdEarner;
	}

	public HouseholdsByAgeRange getHouseholdsByAgeRange() {
		return this.householdsByAgeRange;
	}

	public void setHouseholdsByAgeRange(HouseholdsByAgeRange householdsbyagerangeBean) {
		this.householdsByAgeRange = householdsbyagerangeBean;
	}

	public HouseholdSize getHouseholdSize() {
		return this.householdSize;
	}

	public void setHouseholdSize(HouseholdSize householdsizeBean) {
		this.householdSize = householdsizeBean;
	}

	public HouseholdType getHouseholdtype() {
		return this.householdType;
	}

	public void setHouseholdtype(HouseholdType householdType) {
		this.householdType = householdType;
	}


	public TotalIncome getTotalIncome() {
		return this.totalIncome;
	}

	public void setTotalIncome(TotalIncome totalincomeBean) {
		this.totalIncome = totalincomeBean;
	}
}
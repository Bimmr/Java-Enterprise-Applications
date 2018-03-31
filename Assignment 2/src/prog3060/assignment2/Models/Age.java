package prog3060.assignment2.Models;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the AGE database table.
 * 
 */
@Entity
@Table(name="AGE", schema="APP")
public class Age implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ageID;

	@ManyToOne
	@JoinColumn(name="AGEGROUP")
	private AgeGroup ageGroup;

	@ManyToOne
	@JoinColumn(name="CENSUSYEAR")
	private CensusYear censusYear;

	@ManyToOne
	@JoinColumn(name="GEOGRAPHICAREA")
	private GeographicArea geographicArea;
	
	@Column(nullable=false)
	private int combined;

	@Column(nullable=false)
	private int female;

	@Column(nullable=false)
	private int male;


	public Age() {
	}

	public int getAgeID() {
		return this.ageID;
	}

	public void setAgeID(int ageid) {
		this.ageID = ageid;
	}

	public AgeGroup getAgeGroup() {
		return ageGroup;
	}

	public void setAgeGroup(AgeGroup agegroupBean) {
		this.ageGroup = agegroupBean;
	}

	public CensusYear getCensusYear() {
		return censusYear;
	}

	public void setCensusYear(CensusYear censusYear) {
		this.censusYear = censusYear;
	}

	public int getCombined() {
		return this.combined;
	}

	public void setCombined(int combined) {
		this.combined = combined;
	}

	public int getFemale() {
		return this.female;
	}

	public void setFemale(int female) {
		this.female = female;
	}

	public int getMale() {
		return this.male;
	}

	public void setMale(int male) {
		this.male = male;
	}

	public GeographicArea getGeographicArea() {
		return this.geographicArea;
	}

	public void setGeographicArea(GeographicArea geographicareaBean) {
		this.geographicArea = geographicareaBean;
	}

}
package prog3060.assignment2.Models;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.Set;


/**
 * The persistent class for the AGEGROUP database table.
 * 
 */
@Entity
@Table(name="AGEGROUP", schema="APP")
public class AgeGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ageGroupID;

	@Column(nullable=false)
	private String description;

	@OneToMany(mappedBy="ageGroup")
	private List<Age> ages;

	public AgeGroup() {
	}

	public int getAgeGroupID() {
		return this.ageGroupID;
	}

	public void setAgeGroupID(int agegroupid) {
		this.ageGroupID = agegroupid;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Age> getAges() {
		return this.ages;
	}

	public void setAges(List<Age> ages) {
		this.ages = ages;
	}

	public Age addAge(Age age) {
		getAges().add(age);
		age.setAgeGroup(this);

		return age;
	}

	public Age removeAge(Age age) {
		getAges().remove(age);
		age.setAgeGroup(this);

		return age;
	}

}
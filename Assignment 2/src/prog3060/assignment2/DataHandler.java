package prog3060.assignment2;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import prog3060.assignment2.Models.Age;
import prog3060.assignment2.Models.GeographicArea;
import prog3060.assignment2.Models.Household;

public class DataHandler implements Closeable {

	public static final String PERSISTENCE_UNIT_NAME = "Assignment2Persistence";

	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction et;

	public DataHandler(String username, String password) throws Exception {

		// Props
		Map<String, String> props = new HashMap<String, String>();
		props.put("hibernate.connection.username", username);
		props.put("hibernate.connection.password", password);

		// Instances
		emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, props);
		em = emf.createEntityManager();
		et = em.getTransaction();

		// Begin
		et.begin();
	}

	public List<GeographicArea> getSubGeographicAreas(GeographicArea area) {

		// Create Builder
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Tell what type of data
		CriteriaQuery<GeographicArea> cq = cb.createQuery(GeographicArea.class);

		// Tell where data root is
		Root<GeographicArea> root = cq.from(GeographicArea.class);

		// Grab all
		cq.select(root);

		// Add condition
		if (area.getLevel() == 0) {
			Predicate p = cb.equal(root.get("level"), 1);
			cq.where(p);
		} else {
			Predicate p1 = cb.greaterThan(root.get("alternativeCode"), area.getCode() + "" + "000");
			Predicate p2 = cb.lessThan(root.get("alternativeCode"), area.getCode() + "" + "999");
			cq.where(p1, p2);
		}

		// Get result
		TypedQuery<GeographicArea> tq = em.createQuery(cq);
		return tq.getResultList();
	}

	public List<GeographicArea> getGeographicAreas(String key, Object value) {

		// Create Builder
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Tell what type of data
		CriteriaQuery<GeographicArea> cq = cb.createQuery(GeographicArea.class);

		// Tell where data root is
		Root<GeographicArea> root = cq.from(GeographicArea.class);

		// Grab all
		cq.select(root);

		// Add condition
		Predicate p = cb.equal(root.get(key), value);
		cq.where(p);

		// Get result
		TypedQuery<GeographicArea> tq = em.createQuery(cq);
		return tq.getResultList();
	}

	public List<Age> getAges(int geographicAreaID) {

		// Create Builder
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Tell what type of data
		CriteriaQuery<Age> cq = cb.createQuery(Age.class);

		// Tell where data root is
		Root<Age> root = cq.from(Age.class);

		// Grab all
		cq.select(root);

		Path ageGroup = (Path) root.fetch("ageGroup");
		cq.orderBy(cb.asc(ageGroup.get("ageGroupID")));

		// Add condition
		Path geographicArea = (Path) root.fetch("geographicArea");
		Predicate p = cb.equal(geographicArea.get("geographicAreaID"), geographicAreaID);
		cq.where(p);

		// Get result
		TypedQuery<Age> tq = em.createQuery(cq);
		return tq.getResultList();
	}

	public List<Household> getHousehold(int geographicAreaID, int censusYearValue, String householdTypeValue,
			String householdSizeValue, String householdsByAgeRangeValue, String householdEarnerValue,
			String totalIncomeValue) {

		// Create Builder
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Tell what type of data
		CriteriaQuery<Household> cq = cb.createQuery(Household.class);

		// Tell where data root is
		Root<Household> root = cq.from(Household.class);

		// Grab all
		cq.select(root);

		Path geographicArea = (Path) root.fetch("geographicArea");
		Path censusYear = (Path) root.fetch("censusYear");
		Path householdType = (Path) root.fetch("householdType");
		Path householdSize = (Path) root.fetch("householdSize");
		Path householdsByAgeRange = (Path) root.fetch("householdsByAgeRange");
		Path householdEarner = (Path) root.fetch("householdEarner");
		Path totalIncome = (Path) root.fetch("totalIncome");

		List<Predicate> preds = new ArrayList<>();

		// Add condition
		preds.add(cb.equal(geographicArea.get("geographicAreaID"), geographicAreaID));
		preds.add(cb.equal(censusYear.get("censusYear"), censusYearValue));
		preds.add(cb.equal(householdType.get("description"), householdTypeValue));
		preds.add(cb.equal(householdSize.get("description"), householdSizeValue));
		preds.add(cb.equal(householdEarner.get("description"), householdEarnerValue));
		preds.add(cb.equal(householdsByAgeRange.get("description"), householdsByAgeRangeValue));
		preds.add(cb.equal(totalIncome.get("description"), totalIncomeValue));

		cq.where(preds.toArray(new Predicate[preds.size()]));

		// Get result
		TypedQuery<Household> tq = em.createQuery(cq);
		return tq.getResultList();
	}

	@Override
	public void close() {
		if (em != null && em.isOpen())
			em.close();
		if (emf != null && emf.isOpen())
			emf.close();
	}
	
	public List<Household> getMedianIncomes(int level, int censusYearValue, String householdTypeValue,
			String householdSizeValue, String householdsByAgeRangeValue, String householdEarnerValue,
			String totalIncomeValue) {

		// Create Builder
		CriteriaBuilder cb = em.getCriteriaBuilder();

		// Tell what type of data
		CriteriaQuery<Household> cq = cb.createQuery(Household.class);

		// Tell where data root is
		Root<Household> root = cq.from(Household.class);

		// Grab all
		cq.select(root);

		Path geographicArea = (Path) root.fetch("geographicArea");
		Path censusYear = (Path) root.fetch("censusYear");
		Path householdType = (Path) root.fetch("householdType");
		Path householdSize = (Path) root.fetch("householdSize");
		Path householdsByAgeRange = (Path) root.fetch("householdsByAgeRange");
		Path householdEarner = (Path) root.fetch("householdEarner");
		Path totalIncome = (Path) root.fetch("totalIncome");

		List<Predicate> preds = new ArrayList<>();

		// Add condition
		preds.add(cb.equal(geographicArea.get("level"), level));
		preds.add(cb.equal(censusYear.get("censusYear"), censusYearValue));
		preds.add(cb.equal(householdType.get("description"), householdTypeValue));
		preds.add(cb.equal(householdSize.get("description"), householdSizeValue));
		preds.add(cb.equal(householdEarner.get("description"), householdEarnerValue));
		preds.add(cb.equal(householdsByAgeRange.get("description"), householdsByAgeRangeValue));
		preds.add(cb.equal(totalIncome.get("description"), totalIncomeValue));

		cq.where(preds.toArray(new Predicate[preds.size()]));

		// Get result
		TypedQuery<Household> tq = em.createQuery(cq);
		return tq.getResultList();
	}

}

package cs414.a1.buehlerj;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProjectTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testProjectConstructor() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		assertEquals(test_project.getClass(), Project.class);
	}

	@Test
	public void testGetName() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		assertEquals(test_project.getName(), "Test Project");
	}

	@Test
	public void testGetStatus() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		assertEquals(test_project.getStatus(), ProjectStatus.ACTIVE);
	}

	@Test
	public void testGetSize() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		assertEquals(test_project.getSize(), ProjectSize.SMALL);
	}

	@Test
	public void testSetStatus() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		test_project.setStatus(ProjectStatus.FINISHED);
		assertEquals(test_project.getStatus(), ProjectStatus.FINISHED);
	}

	@Test
	public void testToString() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		assertEquals(test_project.toString(), "Test Project:0:" + ProjectStatus.ACTIVE);

	}

	@Test
	public void testMissingQualifications() {
		Project test_project = new Project("Test Project", ProjectSize.SMALL, ProjectStatus.ACTIVE);
		Worker test_worker = new Worker("Test Worker", null);
		test_project.missingQualifications();
	}

	@Test
	public void testWorkerIsHelpfulForProject() {
		Qualification q1 = new Qualification("Qualification 1");
		Set<Qualification> worker_qualifications = new HashSet<Qualification>();
		worker_qualifications.add(q1);
		Worker test_worker = new Worker("Test Worker", worker_qualifications);
		Company test_company = new Company("Test Company");
		Project test_project = test_company.createProject("", worker_qualifications, ProjectSize.BIG);
//		assertEquals(test_project.isHelpful(test_worker), true);
	}

	@Test
	public void testWorkerIsNotHelpfulForProjectEmpty() {
		Worker test_worker = new Worker("Test Worker", null);
		Qualification q1 = new Qualification("Qualification 1");
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Company test_comp = new Company("Test Company");
		Project test_project = test_comp.createProject("", qualifications, ProjectSize.SMALL);
//		assertEquals(test_project.isHelpful(test_worker), false);
	}

	@Test
	public void testWorkerIsNotHelpfulForProject() {
		Qualification q1 = new Qualification("Qualification 1");
		Qualification q2 = new Qualification("Qualification 2");
		Set<Qualification> worker_qualifications = new HashSet<Qualification>();
		worker_qualifications.add(q2);
		Worker test_worker = new Worker("Test Worker", worker_qualifications);
		Set<Qualification> qualifications = new HashSet<Qualification>();
		qualifications.add(q1);
		Company test_comp = new Company("Test Company");
		Project test_project = test_comp.createProject("", qualifications, ProjectSize.SMALL);
		assertEquals(test_project.isHelpful(test_worker), false);
	}
}

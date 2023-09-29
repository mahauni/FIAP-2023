package test;

import dao.EsgDAO;
import dao.PersonDAO;
import dao.ProblemDAO;
import factory.ConnectionFactory;
import model.Esg;
import model.Person;
import model.Problem;
import model.enumEsg;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class Teste {
	public static void main(String[] args) throws SQLException {
		Connection c = new ConnectionFactory().connection();
		loadValues(c);

		PersonDAO personDAO = new PersonDAO(c);
		EsgDAO esgDAO = new EsgDAO(c);
		ProblemDAO problemDAO = new ProblemDAO(c);

		// Person CRUD Test
		System.out.println("Person CRUD tests");
		Person personDelete = new Person("Person6", "person6@gmail.com", "66 99999-9999");
		System.out.println("Person to be inserted");
		System.out.println(personDelete);
		personDAO.insert(personDelete);
		Person personDeleteUpdate = personDAO.selectById(7);
		System.out.println("Person selected from database");
		System.out.println(personDeleteUpdate);
		personDeleteUpdate.setName("Person7");
		personDeleteUpdate.setEmail("person7@gmail.com");
		personDeleteUpdate.setTelephone("77 99999-9999");
		System.out.println("Person to be updated");
		System.out.println(personDeleteUpdate);
		personDAO.update(personDeleteUpdate);
		personDAO.delete(7);

		System.out.println();

		// ESG CRUD Test
		System.out.println("ESG CRUD tests");
		Esg esgDelete = new Esg(enumEsg.ENVIRONMENTAL, "Envi Delete");
		System.out.println("ESG to be inserted");
		System.out.println(esgDelete);
		esgDAO.insert(esgDelete);
		Esg esgDeleteUpdate = esgDAO.selectById(11);
		System.out.println("ESG selected from the database");
		System.out.println(esgDeleteUpdate);
		esgDeleteUpdate.setEsg(enumEsg.SOCIAL);
		esgDeleteUpdate.setDescription("Social Delete");
		System.out.println("ESG to be updated");
		System.out.println(esgDeleteUpdate);
		esgDAO.update(esgDeleteUpdate);
		esgDAO.delete(11);

		System.out.println();

		// Problem CRUD Test
		System.out.println("Problem CRUD tests");
		Problem problemDelete = new Problem("Desc Delete", 1, 1, 1);
		System.out.println("Problem to be inserted");
		System.out.println(problemDelete);
		problemDAO.insert(problemDelete);
		Problem problemDeleteUpdate = problemDAO.selectById(101);
		System.out.println("Problem selected from the database");
		System.out.println(problemDeleteUpdate);
		problemDeleteUpdate.setDescription("Description Delete");
		System.out.println("Problem to be updated");
		System.out.println(problemDeleteUpdate);
		problemDAO.update(problemDeleteUpdate);
		problemDAO.delete(101);

		List<Problem> problems = problemDAO.selectAll();
		List<Esg> esgs = esgDAO.selectAll();
		List<Person> persons = personDAO.selectAll();

		System.out.println();
		System.out.println("Numbers of Persons: " + persons.size());
		System.out.println("Numbers of ESG: " + esgs.size());
		System.out.println("Numbers of Problems: " + problems.size());
	}

	public static void loadValues(Connection c) {
		Random rand = new Random();

		Esg social = new Esg(enumEsg.SOCIAL, "Social 1");
		Esg govern = new Esg(enumEsg.GOVERNMENTAL, "Governmental 1");
		Esg enviro = new Esg(enumEsg.ENVIRONMENTAL, "Environmental 1");

		Esg[] Esgs = { social, govern, enviro };

		PersonDAO personDAO = new PersonDAO(c);

		Person person1 = new Person("Person1", "person1@gmail.com", "11 99999-9999");
		Person person2 = new Person("Person2", "person2@gmail.com", "22 99999-9999");
		Person person3 = new Person("Person3", "person3@gmail.com");
		Person person4 = new Person("Person4", "person4@gmail.com", "44 99999-9999");
		Person person5 = new Person("Person5", "person5@gmail.com");
		Person person6 = new Person("Person6", "person6@gmail.com", "66 99999-9999");

		personDAO.insert(person1);
		personDAO.insert(person2);
		personDAO.insert(person3);
		personDAO.insert(person4);
		personDAO.insert(person5);
		personDAO.insert(person6);

		EsgDAO esgDao = new EsgDAO(c);
		int numberEsg = 10;
		for (int i = 1; i <= numberEsg; i++) {
			int esgInt = rand.nextInt(3);

			Esg esg = new Esg(Esgs[esgInt].getEsg(), Integer.toString(i));

			esgDao.insert(esg);
		}

		ProblemDAO problemDAO = new ProblemDAO(c);
		int numberProblem = 100;
		for (int i = 1; i <= numberProblem; i++) {
			int esgID = rand.nextInt(numberEsg) + 1;
			int problemID = rand.nextInt(6) + 1;
			int completed = rand.nextInt(2);

			Problem problem = new Problem("Description " + i, completed, problemID, esgID);

			problemDAO.insert(problem);
		}
	}
}

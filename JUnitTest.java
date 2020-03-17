import static org.junit.Assert.*;
import org.junit.*;

public class JUnitTest {

	private static CalcModel m;
	private static int nrTesteExecutate = 0;
	private static int nrTesteCuSucces = 0;

	public Polinom p1 = new Polinom();
	public Polinom p2 = new Polinom();

	Monom m1 = new Monom(1, 2);
	Monom m2 = new Monom(2, 1);
	Monom m3 = new Monom(3, 0);
	Monom m4 = new Monom(1, 2);

	public JUnitTest() {
		System.out.println("Constructor inaintea fiecarui test!");
		p1.addMonom(m1);
		p1.addMonom(m2);
		p1.addMonom(m3);
		p2.addMonom(m4);
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("O singura data inaintea executiei setului de teste din clasa!");
		m = new CalcModel();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("O singura data dupa terminarea executiei setului de teste din clasa!");
		System.out.println(
				"S-au executat " + nrTesteExecutate + " teste din care " + nrTesteCuSucces + " au avut succes!");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Incepe un nou test!");
		nrTesteExecutate++;
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("S-a terminat testul curent!");
	}

	@Test
	public void testResetGetValue() {
		m.reset();
		String t = m.getValue();
		assertNotNull(t); // verifica t sa nu fie null
		assertEquals(t, "0"); // verifica continutul lui t sa fie identic cu "0"
		nrTesteCuSucces++;
	}

	@Test
	public void testAdd() {
		m.reset();
		String t = m.addValue(p1, p2);
		assertEquals(t, "  2.0X^2 +  2.0X +  3.0");// verifica daca rezultatul adunarii este identic cu 2.0X^2 + 2.0X +
													// 3.0
		nrTesteCuSucces++;
	}

	@Test
	public void testSub() {
		m.reset();
		String t = m.subValue(p1, p2);
		assertEquals(t, "  2.0X +  3.0");// verifica daca rezultatul adunarii este identic cu 2.0X^2 + 2.0X + 3.0
		nrTesteCuSucces++;
	}

	@Test
	public void testMultiplyBy0() {
		m.reset();
		m.multiplyBy("0");
		String t = m.getValue();
		assertNotNull(t); // verifica t sa nu fie null
		assertEquals(t, "0"); // verifica t sa nu fie null
		nrTesteCuSucces++;
	}

	@Test
	public void testMultiply() {
		m.reset();
		String t = m.mulValue(p1, p2);
		assertEquals(t, "  X^4 +  2.0X^3 +  3.0X^2");// verifica daca rezultatul adunarii este identic cu 2.0X^2 + 2.0X
														// + 3.0
		nrTesteCuSucces++;
	}

	@Test
	public void testSetValue2() {
		m.setValue("50");
		String t = m.getValue();
		assertNotNull(t); // verifica t sa nu fie null
		assertEquals(t, "50"); // verifica continutul lui t sa fie identic cu "50"
		nrTesteCuSucces++;
	}

	@Test
	public void testDivision() {
		m.reset();
		String t[] = m.divValue(p1, p2);
		assertEquals(t[0], "  1.0");// verifica daca rezultatul adunarii este identic cu 1.0
		assertEquals(t[1], "  2.0X +  3.0");
		nrTesteCuSucces++;
	}

	@Test
	public void testDerivare() {
		m.reset();
		String t = m.derivValue(p1);
		assertEquals(t, "  2.0X +  2.0");// verifica daca rezultatul adunarii este identic cu 2.0X^2 + 2.0X + 3.0
		nrTesteCuSucces++;
	}

	public void testIntegrare() {
		m.reset();
		String t = m.integrValue(p1);
		assertEquals(t, "  0.33333334X^3 +  X^2 +  3.0X");// verifica daca rezultatul adunarii este identic cu 2.0X^2 +
															// 2.0X + 3.0
		nrTesteCuSucces++;
	}

}

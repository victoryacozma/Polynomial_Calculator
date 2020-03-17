import java.math.BigInteger;

public class CalcModel {
	// ... Constants
	static final String INITIAL_VALUE = "0";

	// ... Member variable defining state of calculator.
	private BigInteger m_total; // The total current value state.

	// ==========================================================constructor
	/** Constructor */
	CalcModel() {
		reset();
	}

	// ===================================================================reset
	public void reset() {
		m_total = new BigInteger(INITIAL_VALUE);
	}

	// ==============================================================multiplyBy
	public void multiplyBy(String operand) {
		m_total = m_total.multiply(new BigInteger(operand));
	}

	// =========================================================add
	public String addValue(Polinom p1, Polinom p2) {
		Polinom p3 = p1.adunare(p2);
		String rezultat = p3.polinomToString();
		return rezultat;
	}

	// =============================================================sub
	public String subValue(Polinom p1, Polinom p2) {
		Polinom p3 = p1.scadere(p2);
		String rezultat = p3.polinomToString();
		return rezultat;
	}

	// ==============================================================mul
	public String mulValue(Polinom p1, Polinom p2) {
		Polinom p3 = p1.inmultire(p2);
		String rezultat = p3.polinomToString();
		return rezultat;
	}

	// ==============================================================division
	public String[] divValue(Polinom p1, Polinom p2) {
		Polinom[] p3 = p1.impartire(p1, p2);
		String rezultat[] = new String[2];
		rezultat[0] = p3[0].polinomToString();
		rezultat[1] = p3[1].polinomToString();
		return rezultat;
	}

	// ===============================================================derivare
	public String derivValue(Polinom p1) {
		Polinom p2 = p1.derivare();
		String rezultat = p2.polinomToString();
		return rezultat;
	}

	// ================================================================integrare
	public String integrValue(Polinom p1) {
		Polinom p2 = p1.integrare();
		String rezultat = p2.polinomToString();
		return rezultat;
	}

	// ================================================================setValue
	public void setValue(String value) {
		m_total = new BigInteger(value);
	}

	// =============================================================getValue
	public String getValue() {
		return m_total.toString();
	}
}
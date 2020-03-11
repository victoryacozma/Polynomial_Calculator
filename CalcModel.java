import java.math.BigInteger;
public class CalcModel {
 //... Constants
 static final String INITIAL_VALUE = "1";

 //... Member variable defining state of calculator.
 private BigInteger m_total; // The total current value state.

 //==========================================================constructor
 /** Constructor */
 CalcModel() {
 reset();
 }

 //===================================================================reset
 /** Reset to initial value. */
 public void reset() {
 m_total = new BigInteger(INITIAL_VALUE);
 }

 //==============================================================multiplyBy
 /** Multiply current total by a number.
 *@param operand Number (as string) to multiply total by.
 */
 public void multiplyBy(String operand) {
 m_total = m_total.multiply(new BigInteger(operand));
 }
 
 //=========================================================add
 public String addValue(Polinom p1, Polinom p2) {
	 Polinom p3 = p1.adunare(p2);
	 String rezultat = p3.polinomToString();
	 return rezultat;
 }
 
 //=============================================================sub
 public String subValue(Polinom p1, Polinom p2) {
	 Polinom p3 = p1.scadere(p2);
	 String rezultat = p3.polinomToString();
	 return rezultat;
 }

 //================================================================setValue
 /** Set the total value.
 *@param value New value that should be used for the calculator total.
 */
 public void setValue(String value) {
 m_total = new BigInteger(value);
 }

 //=============================================================getValue
 /** Return current calculator total. */
 public String getValue() {
 return m_total.toString();
 }
} 
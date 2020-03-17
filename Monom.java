
public class Monom implements Comparable<Monom> {
	private float coef;
	private int grad;
	boolean parcurs = false;

	Monom(float c, int g) {
		coef = c;
		grad = g;
	}

	public void setCoef(float c) {
		coef = c;
	}

	public void setGrad(int g) {
		grad = g;
	}

	public int getGradMonom() {
		return this.grad;
	}

	public float getCoefMonom() {
		return this.coef;
	}

	public String toStringMonom() {
		String s = " ";
		if (this.coef == 0) {
			s = "";
		} else if (this.grad == 0) {
			s = s + Float.toString(coef);
		} else if (this.grad == 1) {
			if (coef == 1) {
				s = s + "X^" + Integer.toString(grad);
			} else {
				s = s + Float.toString(coef) + "X";
			}
		} else if (coef == 1) {
			s = s + "X^" + Integer.toString(grad);
		} else if (coef == -1) {
			s = s + "-X^" + Integer.toString(grad);
		} else {
			s = s + Float.toString(coef) + "X^" + Integer.toString(grad);
		}
		return s;
	}

	public String afisMonom() {
		String s = " ";
		if (this.coef == 0) {
			System.out.print("0");
			s = " 0";
		} else if (this.grad == 0) {
			s = s + Float.toString(coef);
			System.out.print(coef);
		} else if (this.grad == 1) {
			if (coef == 1) {
				s = s + "X^" + Integer.toString(grad);
				System.out.print("X^" + grad);
			} else {
				s = s + Float.toString(coef) + "X";
				System.out.print(coef + "X");
			}
		} else if (coef == 1) {
			s = s + "X^" + Integer.toString(grad);
			System.out.print("X^" + grad);
		} else if (coef == -1) {
			s = s + "-X^" + Integer.toString(grad);
			System.out.print("-X^" + grad);
		} else {
			s = s + Float.toString(coef) + "X^" + Integer.toString(grad);
			System.out.print(coef + "X^" + grad);
		}
		return s;
	}

	@Override
	public int compareTo(Monom o) {
		if (this.grad > o.grad) {
			return -1;
		} else if (this.grad < o.grad) {
			return 1;
		} else
			return 0;
	}
}
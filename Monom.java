
public class Monom implements Comparable<Monom> {
	private int coef;
	private int grad;
	boolean parcurs = false;

	Monom(int c, int g) {
		coef = c;
		grad = g;
	}

	public void setCoef(int c) {
		coef = c;
	}

	public void setGrad(int g) {
		grad = g;
	}

	public int getGradMonom() {
		return this.grad;
	}

	public int getCoefMonom() {
		return this.coef;
	}

	public String afisMonom() {
		String s = " ";
		if(this.coef == 0) {
			System.out.print("");
		}
		else if (this.grad == 0) {
			s = s + Integer.toString(coef);
			System.out.print(coef);
		}
		else if(this.grad == 1) {
			s = s + Integer.toString(coef) + "X";
			System.out.print(coef + "X");
		}
		else if (coef == 1) {
			s = s + "X" + Integer.toString(grad);
			System.out.print("X^" + grad);
		}
		else {
			s = s + Integer.toString(coef) + "X^" + Integer.toString(grad);
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

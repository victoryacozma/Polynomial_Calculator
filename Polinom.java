import java.util.ArrayList;
import java.util.Collections;

public class Polinom {
	ArrayList<Monom> monoame = new ArrayList<Monom>();

	public void addMonom(Monom m) {
		monoame.add(m);
	}

	public void afisPolinom() {
		System.out.println();
		System.out.println("Polinomul este ");
		for (Monom m : monoame) {
			if((monoame.indexOf(m) != 0) && (m.getCoefMonom() > 0)) {
				System.out.print(" + ");
			}
			m.afisMonom();
		}
	}

	public Polinom adunare(Polinom p) {
		Polinom rez = new Polinom();
		boolean b = false;
		for (Monom i : monoame) {
			for (Monom j : p.monoame) {
				if (i.getGradMonom() == j.getGradMonom()) {
					Monom aux = new Monom(i.getCoefMonom() + j.getCoefMonom(), i.getGradMonom());
					rez.addMonom(aux);
					j.parcurs = true;
					i.parcurs = true;
					break;
				}
			}
			if (i.parcurs == false) {
				rez.addMonom(i);
			}
		}
		for (Monom i : p.monoame) {
			if (i.parcurs == false)
				rez.addMonom(i);
		}
		System.out.println();
		System.out.println("rezultatul adunarii este :");
		rez.sortare();
		rez.afisPolinom();
		return rez;
	}
	
	public Polinom scadere(Polinom p) {
		Polinom rez = new Polinom();
		boolean b = false;
		for (Monom i : monoame) {
			for (Monom j : p.monoame) {
				if (i.getGradMonom() == j.getGradMonom()) {
					Monom aux = new Monom(i.getCoefMonom() - j.getCoefMonom(), i.getGradMonom());
					rez.addMonom(aux);
					j.parcurs = true;
					i.parcurs = true;
					break;
				}
			}
			if (i.parcurs == false) {
				rez.addMonom(i);
			}
		}
		for (Monom i : p.monoame) {
			if (i.parcurs == false) {
				i.setCoef(-i.getCoefMonom());
				rez.addMonom(i);
			}
		}
		System.out.println();
		System.out.println("rezultatul scaderii este :");
		rez.sortare();
		rez.afisPolinom();
		return rez;
	}
	
	public void sortare() {
		Collections.sort(monoame);
	}
	
	public String polinomToString() {
		String output = new String(" ");
		for(Monom m : monoame) {
			if((monoame.indexOf(m) != 0) && (m.getCoefMonom() > 0)) {
				output += " + ";
			}
			output += m.afisMonom();
			}
		
		return output;
	}
}

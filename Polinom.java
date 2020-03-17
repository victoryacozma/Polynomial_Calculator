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
			if ((monoame.indexOf(m) != 0) && (m.getCoefMonom() > 0)) {
				System.out.print(" + ");
			}
			m.afisMonom();
		}
	}

	public Polinom adunare(Polinom p) {
		Polinom rez = new Polinom();
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
		rez.sortare();
		return rez;
	}

	public Polinom scadere(Polinom p) {
		Polinom rez = new Polinom();
		for (Monom i : monoame) {
			for (Monom j : p.monoame) {
				if (i.getGradMonom() == j.getGradMonom()) {
					Monom aux = new Monom(i.getCoefMonom() - j.getCoefMonom(), i.getGradMonom());
					rez.addMonom(aux);
					j.parcurs = true;
					i.parcurs = true;
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
		rez.sortare();
		rez.afisPolinom();
		return rez;
	}

	public Polinom inmultire(Polinom p) {
		Polinom rez = new Polinom();
		Polinom rez1 = new Polinom();
		if ((p.monoame.size() == 1) && (p.monoame.get(0).getCoefMonom() == 0)) {
			Monom m = new Monom(0, 0);
			rez.addMonom(m);
			return rez;
		}
		for (Monom i : monoame) {
			for (Monom j : p.monoame) {
				Monom aux = new Monom(i.getCoefMonom() * j.getCoefMonom(), i.getGradMonom() + j.getGradMonom());
				rez.addMonom(aux);
			}
		}
		rez1 = rez.reducereTermAsemenea();
		rez.sortare();
		rez.afisPolinom();
		return rez1;
	}

	public Polinom[] impartire(Polinom p1, Polinom p2) {
		Polinom result[] = new Polinom[2];
		Polinom cat = new Polinom();
		Polinom rest = new Polinom();
		Polinom aux1 = new Polinom();
		rest = p1;
		while ((!rest.monoame.isEmpty())
				&& ((rest.monoame.get(0).getGradMonom()) >= (p2.monoame.get(0).getGradMonom()))) {
			float coef1 = rest.monoame.get(0).getCoefMonom();
			float coef2 = p2.monoame.get(0).getCoefMonom();
			int grad1 = rest.monoame.get(0).getGradMonom();
			int grad2 = p2.monoame.get(0).getGradMonom();

			Monom aux = new Monom(coef1 / coef2, grad1 - grad2);
			cat.addMonom(aux);
			Polinom polToMon = new Polinom();
			polToMon.addMonom(aux);
			aux1 = polToMon.inmultire(p2);
			rest = rest.scadere(aux1);
			rest.sortare();
			rest.reducereTermeni();
		}
		result[0] = cat;
		result[1] = rest;
		return result;
	}

	public Polinom derivare() {
		Polinom rez = new Polinom();

		for (Monom i : monoame) {
			float coefNou = i.getCoefMonom() * i.getGradMonom();
			int gradNou = i.getGradMonom() - 1;
			Monom aux = new Monom(coefNou, gradNou);
			rez.addMonom(aux);
		}
		rez.afisPolinom();
		return rez;
	}

	public Polinom integrare() {
		Polinom rez = new Polinom();

		for (Monom i : monoame) {
			int gradNou = i.getGradMonom() + 1;
			float coefNou = i.getCoefMonom() / gradNou;
			Monom aux = new Monom(coefNou, gradNou);
			rez.addMonom(aux);
		}
		rez.afisPolinom();
		return rez;
	}

	public void sortare() {
		Collections.sort(monoame);
	}

	public String polinomToString() {
		String output = new String(" ");
		for (Monom m : monoame) {
			int prec = monoame.indexOf(m) - 1;
			if ((monoame.indexOf(m) != 0) && (m.getCoefMonom() > 0) && monoame.get(prec).getCoefMonom() != 0) {
				output += " + ";
			}

			output += m.toStringMonom();
		}
		return output;
	}

	public void reducereTermeni() {
		for (int i = 0; i < monoame.size(); i++) {
			if (monoame.get(i).getCoefMonom() == 0) {
				monoame.remove(i);
			}
		}
	}

	public Polinom reducereTermAsemenea() {
		Polinom rez = new Polinom();
		for (int i = 0; i < monoame.size(); i++) {
			for (int j = i + 1; j < monoame.size(); j++) {
				if (monoame.get(i).getCoefMonom() == 0) {
					monoame.remove(i);
				}
				if (monoame.get(i).getGradMonom() == monoame.get(j).getGradMonom()) {
					Monom aux = new Monom(monoame.get(i).getCoefMonom() + monoame.get(j).getCoefMonom(),
							monoame.get(i).getGradMonom());
					rez.addMonom(aux);
					monoame.get(j).parcurs = true;
					monoame.get(i).parcurs = true;
					break;
				}
			}
			if (monoame.get(i).parcurs == false) {
				rez.addMonom(monoame.get(i));
			}
		}
		rez.sortare();
		rez.afisPolinom();
		return rez;
	}
}
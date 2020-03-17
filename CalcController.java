import java.awt.event.*;

public class CalcController {
	// ... The Controller needs to interact with both the Model and View.
	private CalcModel m_model;
	private CalcView m_view;

	// =====================================================constructor
	CalcController(CalcModel model, CalcView view) {
		m_model = model;
		m_view = view;

		// ... Add listeners to the view.
		view.addMultiplyListener(new MultiplyListener());
		view.addClearListener(new ClearListener());
		view.addAddListener(new AddListener());
		view.addSubstractListener(new SubListener());
		view.addDivListener(new DivListener());
		view.addDeriv1Listener(new Deriv1Listener());
		view.addDeriv2Listener(new Deriv2Listener());
		view.addIntegr1Listener(new Integr1Listener());
		view.addIntegr2Listener(new Integr2Listener());

	}

	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			Polinom userInput2;
			String rezultat;
			
				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				userInput2 = m_view.getUserInput1(m_view.m_userInputTf2);
				rezultat = m_model.mulValue(userInput1, userInput2);
				m_view.setTotal(rezultat);
		}
	}

	class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			Polinom userInput2;
			String rezultat;

				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				userInput2 = m_view.getUserInput1(m_view.m_userInputTf2);
				rezultat = m_model.addValue(userInput1, userInput2);
				m_view.setTotal(rezultat);

		}
	}
	
	class SubListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			Polinom userInput2;
			String rezultat;

				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				userInput2 = m_view.getUserInput1(m_view.m_userInputTf2);
				rezultat = m_model.subValue(userInput1, userInput2);
				m_view.setTotal(rezultat);
		}
	}
	
	class DivListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			Polinom userInput2;
			String rezultat[] = new String[2];

				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				userInput2 = m_view.getUserInput1(m_view.m_userInputTf2);
				if(userInput2.monoame.size() == 1 && userInput2.monoame.get(0).getCoefMonom() == 0) {
					System.out.println("bad input");
					return;
				}
				rezultat = m_model.divValue(userInput1, userInput2);
				m_view.setTotal(rezultat[0]);
				m_view.setRest(rezultat[1]);
				

		}
	}
	
	class Deriv1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			String rezultat;

				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				rezultat = m_model.derivValue(userInput1);
				m_view.setTotal(rezultat);

		}
	}
	
	class Deriv2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput2;
			String rezultat;

				userInput2 = m_view.getUserInput1(m_view.m_userInputTf2);
				rezultat = m_model.derivValue(userInput2);
				m_view.setTotal(rezultat);

		}
	}
	
	class Integr1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			String rezultat;

				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				rezultat = m_model.integrValue(userInput1);
				m_view.setTotal(rezultat);

		}
	}
	
	class Integr2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			String rezultat;

				userInput1 = m_view.getUserInput1(m_view.m_userInputTf2);
				rezultat = m_model.integrValue(userInput1);
				m_view.setTotal(rezultat);

		}
	}

	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			m_model.reset();
			m_view.reset();
		}
	}
}
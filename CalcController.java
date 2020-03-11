import java.awt.event.*;

public class CalcController {
	// ... The Controller needs to interact with both the Model and View.
	private CalcModel m_model;
	private CalcView m_view;

	// =====================================================constructor
	/** Constructor */
	CalcController(CalcModel model, CalcView view) {
		m_model = model;
		m_view = view;

		// ... Add listeners to the view.
		view.addMultiplyListener(new MultiplyListener());
		view.addClearListener(new ClearListener());
		view.addAddListener(new AddListener());
		view.addSubstractListener(new SubListener());
	}

	////////////////////////////////////////// inner clasMultiplyListener
	/**
	 * When a mulitplication is requested. 1. Get the user input number from the
	 * View. 2. Call the model to mulitply by this number. 3. Get the result from
	 * the Model. 4. Tell the View to display the result. If there was an error,
	 * tell the View to display it.
	 */
	class MultiplyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Polinom userInput1;
			Polinom userInput2;
			
				userInput1 = m_view.getUserInput1(m_view.m_userInputTf1);
				userInput2 = m_view.getUserInput1(m_view.m_userInputTf2);
				//m_model.multiplyBy(userInput1);
				m_view.setTotal(m_model.getValue());

		}
	}// end inner class MultiplyListener

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

	//////////////////////////////////////////// inner class ClearListener
	/**
	 * 1. Reset model. 2. Reset View.
	 */
	class ClearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			m_model.reset();
			m_view.reset();
		}
	}// end inner class ClearListener
}
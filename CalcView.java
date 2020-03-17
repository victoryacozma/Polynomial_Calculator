import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import java.awt.event.*;

class CalcView extends JFrame {
	// ... Components
	public JTextField m_userInputTf1 = new JTextField(20);
	public JTextField m_userInputTf2 = new JTextField(20);
	private JTextField m_totalTf = new JTextField(20);
	private JTextField m_restTf = new JTextField(20);
	private JButton m_multiplyBtn = new JButton("Multiply");
	private JButton m_addBtn = new JButton("Add");
	private JButton m_subBtn = new JButton("Substract");
	private JButton m_divBtn = new JButton("Divide");
	private JButton m_clearBtn = new JButton("Clear");
	private JButton m_deriv1Btn = new JButton("Derivate input1");
	private JButton m_deriv2Btn = new JButton("Derivate input2");
	private JButton m_integr1Btn = new JButton("Integrate input1");
	private JButton m_integr2Btn = new JButton("Integrate input2");

	private CalcModel m_model;

	CalcView(CalcModel model) {
		// ... Set up the logic
		m_model = model;
		m_model.setValue(CalcModel.INITIAL_VALUE);

		// ... Initialize components
		m_totalTf.setText(m_model.getValue());
		m_totalTf.setEditable(false);
		m_restTf.setText("0");
		m_restTf.setEditable(false);

		// ... Layout the components.
		JPanel content = new JPanel();
		JPanel content1 = new JPanel();
		JPanel butoane = new JPanel();
		JPanel input1 = new JPanel();
		JPanel input2 = new JPanel();

		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));
		butoane.add(m_addBtn);
		butoane.add(m_subBtn);
		butoane.add(m_multiplyBtn);
		butoane.add(m_divBtn);

		input1.setLayout(new BoxLayout(input1, BoxLayout.Y_AXIS));
		input1.add(new JLabel(" Polinom 1 "));
		input1.add(m_userInputTf1);
		input1.add(m_deriv1Btn);
		input1.add(m_integr1Btn);

		input2.setLayout(new BoxLayout(input2, BoxLayout.Y_AXIS));
		input2.add(new JLabel(" Polinom 2 "));
		input2.add(m_userInputTf2);
		input2.add(m_deriv2Btn);
		input2.add(m_integr2Btn);

		content.setLayout(new FlowLayout());
		content.add(input1);
		content.add(input2);
		content.add(butoane);
		content.add(content1);

		content1.setLayout(new BoxLayout(content1, BoxLayout.Y_AXIS));
		content1.add(new JLabel("Total"));
		content1.add(m_totalTf);
		content1.add(new JLabel("Rest"));
		content1.add(m_restTf);
		content.add(m_clearBtn);

		// ... finalize layout
		this.setContentPane(content);
		this.pack();

		this.setTitle("Polinomyal Calculator - MVC");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void reset() {
		m_totalTf.setText(CalcModel.INITIAL_VALUE);
		m_totalTf.setText("0");
	}

	Polinom getUserInput1(JTextField m) {
		Polinom p1 = new Polinom();
		String s1 = m.getText();
		String coe = "";
		String putere = "";
		
		String s2 = s1.replace("X", "x");
		String s3 = s2.replace(" ", "");
		String replaceString = s3.replace("-", "+-");

		String[] arrOfStr = replaceString.split("\\+");
		

		for (int i = 0; i < arrOfStr.length; i++) {
			if (!arrOfStr[i].isEmpty()) {
				if (arrOfStr[i].indexOf('x') < 0) {
					arrOfStr[i] = arrOfStr[i] + "x^0";
				}
				if (arrOfStr[i].indexOf('^') < 0) {
					arrOfStr[i] = arrOfStr[i] + "^1";
				}
			}

		}

		for (String s : arrOfStr) {
			if (!s.isEmpty()) {
				String arrOfCoef[] = s.split("x\\^");
				if (arrOfCoef[0] == "-") {
					coe = "-1";
				} else if (!arrOfCoef[0].isEmpty()) {
					coe = arrOfCoef[0];
				} else {
					coe = "1";
				}
				putere = arrOfCoef[1];
				int coef;
				try {
					coef = Integer.parseInt(coe);
				} catch (Exception e) {
					coef = -1;
				}
				int puteref = Integer.parseInt(putere);
				Monom aux = new Monom(coef, puteref);
				p1.addMonom(aux);
			}
		}
		p1.afisPolinom();
		return p1;
	}

	void setTotal(String newTotal) {
		m_totalTf.setText(newTotal);
	}

	void setRest(String newTotal) {
		m_restTf.setText(newTotal);
	}

	void showError(String errMessage) {
		JOptionPane.showMessageDialog(this, errMessage);
	}

	void addMultiplyListener(ActionListener mal) {
		m_multiplyBtn.addActionListener(mal);
	}

	void addSubstractListener(ActionListener s) {
		m_subBtn.addActionListener(s);
	}

	void addClearListener(ActionListener cal) {
		m_clearBtn.addActionListener(cal);
	}

	void addAddListener(ActionListener a) {
		m_addBtn.addActionListener(a);
	}

	void addDivListener(ActionListener a) {
		m_divBtn.addActionListener(a);
	}

	void addDeriv1Listener(ActionListener a) {
		m_deriv1Btn.addActionListener(a);
	}

	void addDeriv2Listener(ActionListener a) {
		m_deriv2Btn.addActionListener(a);
	}

	void addIntegr1Listener(ActionListener a) {
		m_integr1Btn.addActionListener(a);
	}

	void addIntegr2Listener(ActionListener a) {
		m_integr2Btn.addActionListener(a);
	}
}
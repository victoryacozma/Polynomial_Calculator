import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class CalcView extends JFrame {
	// ... Components
	public JTextField m_userInputTf1 = new JTextField(20);
	public JTextField m_userInputTf2 = new JTextField(20);
	private JTextField m_totalTf = new JTextField(20);
	private JButton m_multiplyBtn = new JButton("Multiply");
	private JButton m_addBtn = new JButton("Add");
	private JButton m_subBtn = new JButton("Substract");
	private JButton m_clearBtn = new JButton("Clear");

	private CalcModel m_model;

	CalcView(CalcModel model) {
		// ... Set up the logic
		m_model = model;
		m_model.setValue(CalcModel.INITIAL_VALUE);

		// ... Initialize components
		m_totalTf.setText(m_model.getValue());
		m_totalTf.setEditable(false);

		// ... Layout the components.
		JPanel content = new JPanel();
		JPanel butoane = new JPanel();
		butoane.setLayout(new BoxLayout(butoane, BoxLayout.Y_AXIS));
		butoane.add(m_multiplyBtn);
		butoane.add(m_addBtn);
		butoane.add(m_subBtn);

		content.setLayout(new FlowLayout());
		content.add(new JLabel("Input"));
		content.add(m_userInputTf1);
		content.add(m_userInputTf2);
		content.add(butoane);
		content.add(new JLabel("Total"));
		content.add(m_totalTf);
		content.add(m_clearBtn);

		// ... finalize layout
		this.setContentPane(content);
		this.pack();

		this.setTitle("Simple Calc - MVC");
		// The window closing event should probably be passed to the
		// Controller in a real program, but this is a short example.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	void reset() {
		m_totalTf.setText(CalcModel.INITIAL_VALUE);
	}

	Polinom getUserInput1(JTextField m) {
		Polinom p1 = new Polinom();
		String s1 = m.getText();
		String coe = "";
		String putere = "";

		String replaceString = s1.replace("-", "+-");

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
				coe = arrOfCoef[0];
				putere = arrOfCoef[1];
				int coef = Integer.parseInt(coe);
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
}

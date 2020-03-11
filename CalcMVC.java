import javax.swing.*;

public class CalcMVC {
// ... Creeaza modelul, vizulizarea, si controlorul. Aceste sunt
// create aici o data si transmise partilor care au
// nevoie de ele astfel ca exista o singura copie din fiecare.
	public static void main(String[] args) {
		CalcModel model = new CalcModel();
		CalcView view = new CalcView(model);
		CalcController controller = new CalcController(model, view);
		view.setVisible(true);
	}
}
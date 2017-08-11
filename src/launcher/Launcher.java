package launcher;

import controller.MainController;
import domain.model.Facade;
import view.GameView;

public class Launcher {

	public static void main(String[] args) {
		MainController controller = new MainController(new GameView(), new Facade());
		controller.start();
		
	}

}

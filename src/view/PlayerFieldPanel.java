package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DiceController;
import controller.MainController;
import controller.PlayerFieldController;
import controller.PointsController;
import domain.model.Category;
import domain.model.Field;
import domain.model.observer.PlayerFieldObserver;

public class PlayerFieldPanel extends JPanel implements PlayerFieldObserver {

	JButton diceButton = new JButton("Roll Dice");
	JComboBox categories = new JComboBox(Category.getNames(Category.class));
	JButton nextButton = new JButton("OK");
	
	PlayerFieldController fieldController;
		
	public PlayerFieldPanel(MainController controller) {

		fieldController = new PlayerFieldController(controller.getGameView(), controller.getFacade());
		
		this.setBackground(Color.ORANGE);
		
		diceButton.addActionListener(fieldController);
		
		this.add(diceButton);
		
		categories.setSelectedIndex(0);
		
		this.add(categories);
		
		nextButton.addActionListener(new PointsController(controller.getGameView(), controller.getFacade()));
		
		this.add(nextButton);
		
		
	}
	
	public PlayerFieldController getFieldController() {
		return fieldController;
	}
	
	public String getCategory() {
		return categories.getSelectedItem().toString();
	}

	@Override
	public void updateField(Field field) {
		field.addFieldObserver(this);
		field.setPlayer(fieldController.getFacade().getCurrentPlayer());
		fieldController.getFacade().nextTurn();
	}

}

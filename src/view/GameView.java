package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;

import controller.MainController;
import controller.PlayerFieldController;
import domain.model.Game;
import domain.model.observer.PlayerTurnObserver;

public class GameView implements PlayerTurnObserver {

	private JFrame frame;
	private PlayerFieldPanel content;
	private List<PlayerFieldPanel> fieldPanels;
	private MainController controller;
	
	JLabel currentPlayer;
	
	public GameView() {

	}

	public void startConfig() {
		frame = new JFrame("Yahtzee");
		int playersAmount = Integer.parseInt(askPlayersAmount());
		askPlayerName(playersAmount);
		content = new PlayerFieldPanel(controller);
		startGame();
	}

	private String askPlayersAmount() {
		
		final String[] playerList = { "2", "3", "4", "5" };
		
		String playersAmount = (String) JOptionPane.showInputDialog(frame, 
		        "How many players?",
		        "Amount of players",
		        JOptionPane.QUESTION_MESSAGE, 
		        null, 
		        playerList, playerList[0]);
		controller.getFacade().setPlayersAmount(Integer.parseInt(playersAmount));
		return playersAmount;
		
	}
	
	private String[] askPlayerName(int playersAmount) {
		String[] playerNames = new String[playersAmount];
		for(int i=0;i<playersAmount;i++) {
			String playerName = (String) JOptionPane.showInputDialog(frame,"Name of player " + (i+1));
			if(playerName == null || playerName.trim().isEmpty() || Arrays.asList(playerNames).contains(playerName)) {
				i--;
			}
			else {
				controller.getFacade().addPlayer(playerName);
				playerNames[i] = playerName;
			}
		}
		return playerNames;
	}
	
	public void startGame() {
		
		frame.setLayout(new BorderLayout());
		frame.setSize(1280, 720);
		frame.setLocationRelativeTo(null); //zet scherm in het midden
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //stopt applicatie bij het sluiten
		
		makeField();
		
		//frame.pack();
		frame.setResizable(true);
		frame.setVisible(true);
	}

	private void makeField() {
		
		JPanel header = new JPanel();
		
		header.add(new JLabel("Yahtzee"), BorderLayout.PAGE_START);
		header.setBorder(BorderFactory.createEmptyBorder(10, frame.getWidth()/2, 10, frame.getWidth()/2));
		header.setBackground(Color.WHITE);
		
		frame.add(header, BorderLayout.PAGE_START);
		
		frame.add(content);
		
		JPanel footer = new JPanel(new FlowLayout());
		footer.setBorder(BorderFactory.createEmptyBorder(10, frame.getWidth()/2, 10, frame.getWidth()/2));
		footer.setBackground(Color.WHITE);
		
		currentPlayer = new JLabel(controller.getFacade().getCurrentPlayer().getName() + " is playing");
		
		footer.add(currentPlayer);
		
		frame.add(footer, BorderLayout.PAGE_END);
	}
	
	public PlayerFieldPanel getContent()  {
		return content;
	}
	
	public void setController(MainController controller) {
		this.controller = controller;
	}

	@Override
	public void nextTurn(Game game) {
		System.out.println(game.getPlayerTurn());
		frame.remove(content);
		controller.getFacade().resetRolls();
		content = new PlayerFieldPanel(controller);
		frame.add(content);
		currentPlayer.setText(controller.getFacade().getCurrentPlayer().getName() + " is playing");
	}
	
}

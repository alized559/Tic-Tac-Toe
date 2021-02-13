package Tic_Tac_Toe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class XO extends JFrame {

	private Container pane;
	private JButton[][] board;
	private String turn;
	private boolean winner;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem newGame;
	private JMenuItem quit;
	private int count;

	public XO() {
		super();
		count = 0;
		turn = "X";
		winner = false;
		board = new JButton[3][3];
		pane = getContentPane();
		pane.setLayout(new GridLayout(3, 3));
		pane.setBackground(Color.BLACK);
		setTitle("XO Game");
		setSize(400, 400);
		createBoard();
		createMenuBar();
		setVisible(true);
	}

	private void resetBoard() {
		turn = "X";
		count = 0;
		winner = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j].setText("");
			}
		}
	}
	
	private void createMenuBar() {
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		newGame = new JMenuItem("New Game");
		newGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetBoard();
			}
			
		});
		quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		menu.add(newGame);
		menu.add(quit);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}
	
	private void togglePlayer() {
		if (turn.equals("X"))
			turn = "O";
		else
			turn = "X";
	}
	
	private void createBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton button = new JButton("");
				button.setFont(new Font("Arial", Font.PLAIN, 100));
				board[i][j] = button;
				button.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						if (((JButton)e.getSource()).getText().equals("") && winner == false) {
							button.setText(turn);
							if (turn.equals("X"))
								button.setForeground(Color.BLUE);
							else
								button.setForeground(Color.RED);
							count++;
							win();
							togglePlayer();
						}
					}
	
				});
				pane.add(button);
			}
		}
	}
	
	private void win() {
        if (board[0][0].getText().equals(turn) && board[1][0].getText().equals(turn) && board[2][0].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[0][1].getText().equals(turn) && board[1][1].getText().equals(turn) && board[2][1].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[0][2].getText().equals(turn) && board[1][2].getText().equals(turn) && board[2][2].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[0][0].getText().equals(turn) && board[1][1].getText().equals(turn) && board[2][2].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[0][2].getText().equals(turn) && board[1][1].getText().equals(turn) && board[2][0].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[0][0].getText().equals(turn) && board[0][1].getText().equals(turn) && board[0][2].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[1][0].getText().equals(turn) && board[1][1].getText().equals(turn) && board[1][2].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (board[2][0].getText().equals(turn) && board[2][1].getText().equals(turn) && board[2][2].getText().equals(turn)) {
            JOptionPane.showMessageDialog(null, turn + " won");
            winner = true;
        } else if (count == 9)
        	JOptionPane.showMessageDialog(null, "Draw!");
	}
	
	public static void main(String[] args) {
		new XO();
	}
}

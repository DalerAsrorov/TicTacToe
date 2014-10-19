package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
public class Main extends JFrame implements ActionListener
{
	static JFrame fr;
	static JButton[] buttons;
	JPanel content;
	JTextPane text;
	JButton[] cell = new JButton[9];
	JButton restartGame;
	JPanel up;
	JPanel grid;
	JPanel bottom;
	static int counter = 0;
	static int num = -1;
	int cellNum = 0;
	static String symbol = ""; 
	static int row = 3, col = 3;
	static boolean win = false;
	public static void main(String [] args)
	{
		Main test = new Main();
	}
	public Main()
	{
		fr = this;
		fr = new JFrame("Tic-Tac-Toe");
		fr.setSize(450, 450);
		fr.setLocation(700, 200);
		//fr.setLayout(new BoxLayout(fr, BoxLayout.LINE_AXIS));
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setResizable(false);
		
		content = new JPanel();
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		up = new JPanel();
		up.setBackground(Color.BLACK);
		grid = new JPanel();
		bottom = new JPanel();
		bottom.setBackground(Color.BLACK);
		restartGame = new JButton("Restart Game");
		
		//first panel
		text = new JTextPane();
		SimpleAttributeSet attribs = new SimpleAttributeSet();  
		StyleConstants.setAlignment(attribs,StyleConstants.ALIGN_CENTER);  
		StyleConstants.setFontSize(attribs, 17);
		text.setParagraphAttributes(attribs,true);  
		text.setPreferredSize(new Dimension(480, 23));
		text.setEditable(false);
		up.add(text);
		
		//second panel 
		grid.setLayout(new GridLayout(3, 3));
		String str = "";
		for (int i = 0; i < 9; i++ )
		{
			cell[i] = new JButton("");
			cell[i].setPreferredSize(new Dimension(200, 200));
			str = String.valueOf(i);
			cell[i].addActionListener(this);
			grid.add(cell[i]);
		}
		
		restartGame.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{	
				for (int i = 0; i < 9; i++)
				{	
					cell[i].setText("");
					cell[i].setEnabled(true);
					text.setText("");
				}
				counter = 0;
			}
		});
		
		//third panel
		bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		restartGame.setPreferredSize(new Dimension(490, 40));
		bottom.add(restartGame);
	
		content.add(up);
		content.add(grid);
		content.add(bottom);
		
		fr.add(content);
		fr.setVisible(true);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		/*When X and when O*/
		if (counter == 0 || counter == 2 || counter == 4 || counter == 6 || counter == 8)
			symbol = "X";
		else if (counter == 1 || counter == 3 || counter == 5 || counter == 7 || counter == 9)	
			symbol = "O";
		
		if(e.getSource() == cell[0])
		{	
			cell[0].setText(symbol);
			cell[0].setEnabled(false);
		}
		if(e.getSource() == cell[1])
		{	
			cell[1].setText(symbol);
			cell[1].setEnabled(false);
		}
		if(e.getSource() == cell[2])
		{	
			cell[2].setText(symbol);
			cell[2].setEnabled(false);
		}
		else if(e.getSource() == cell[3])
		{	
			cell[3].setText(symbol);
			cell[3].setEnabled(false);
		}
		else if(e.getSource() == cell[4])
		{	
			cell[4].setText(symbol);
			cell[4].setEnabled(false);
		}
		else if(e.getSource() == cell[5])
		{	
			cell[5].setText(symbol);
			cell[5].setEnabled(false);
		}
		else if(e.getSource() == cell[6])
		{	
			cell[6].setText(symbol);
			cell[6].setEnabled(false);
		}
		else if(e.getSource() == cell[7])
		{	
			cell[7].setText(symbol);
			cell[7].setEnabled(false);
		}
		else if(e.getSource() == cell[8])
		{	
			cell[8].setText(symbol);
			cell[8].setEnabled(false);
		}

		/*Determine who wins*/
		
		//horizontal matching
		if(cell[0].getText() == cell[1].getText() && cell[1].getText() == cell[2].getText() & cell[1].getText() != "")
			win = true;
		else if (cell[3].getText() == cell[4].getText() && cell[4].getText() == cell[5].getText() & cell[3].getText() != "")
			win = true;
		else if (cell[6].getText() == cell[7].getText() && cell[7].getText() == cell[8].getText() & cell[7].getText() != "")
			win = true;
		
		//vertical match
		else if(cell[0].getText() == cell[3].getText() && cell[3].getText() == cell[6].getText() & cell[0].getText() != "")
			win = true;
		else if (cell[1].getText() == cell[4].getText() && cell[4].getText() == cell[7].getText() & cell[1].getText() != "")
			win = true;
		else if (cell[2].getText() == cell[5].getText() && cell[5].getText() == cell[8].getText() & cell[2].getText() != "")
			win = true;
		
		//diagonal match
		else if(cell[0].getText() == cell[4].getText() && cell[4].getText() == cell[8].getText() & cell[0].getText() != "")
			win = true;
		else if (cell[2].getText() == cell[4].getText() && cell[4].getText() == cell[6].getText() & cell[2].getText() != "")
			win = true;
		else
			win = false;
		
		if (win == true)
		{	
			text.setText(symbol + " won! ");
			for (int i = 0; i < 9; i++)
				cell[i].setEnabled(false);
		}
		else if (counter == 8 && win == false)
			text.setText("It's a draw!");
		
		counter++;
	}
}
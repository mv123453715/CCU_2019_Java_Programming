import javax.swing.ButtonGroup;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import  javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.Scanner;
import java.awt.Color;

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JApplet;


public class JAVA_HW3_TYPING_TUTOR extends JFrame 
{
	JTextArea textAreaUser;
	String pangram;
	char curChar = ' '; //now char
	int errcnt =0; //err_count
	static JLabel lblScore;
	Timer rollex; 
	int curTime = 0;
	JLabel lblTypo;
	int errLim; //errLim to end game
	int time;
	int idx = 0;
	List<JButton> buttons ; 
	List<Character> user_wrongs = new ArrayList<Character>(); 
	ImageIcon cat_right = new ImageIcon("cat_right.gif");     //right.gif 
	JLabel cat_rightLabel = new JLabel(cat_right);
	
	
	private class KeyEventHandler implements KeyListener 
	{
		
		@Override
		public void keyPressed(KeyEvent arg0) 
		{
			//
			for (JButton button : buttons)
			{
				
			    if(button.getText().equalsIgnoreCase(arg0.getKeyChar()+""))
	    		{
			    	
					System.out.println(button.getText());
			    	if ( button.getText().compareTo("A")  >= 0 && button.getText().compareTo("Z")  <= 0 )
						button.setBackground(Color.WHITE);
					else if (  button.getText().compareTo("a")  >= 0 && button.getText().compareTo("z")  <= 0  )
						button.setBackground(Color.WHITE);
					else 
						button.setBackground(Color.WHITE);
	    		}
			}

		}


		@Override
		public void keyTyped(KeyEvent arg0) 
		{
			char userChar = arg0.getKeyChar();
			curChar = pangram.charAt(idx);
			if(curChar == userChar )
			{
				textAreaUser.append(userChar + "");
				idx++;
				lblScore.setText(Integer.parseInt(lblScore.getText())+1 + "");	//updating score
				
				if(pangram.equals(textAreaUser.getText()))
				{
					endGame();
				}
						
			}
			else
			{
				ImageIcon cat_wrong = new ImageIcon("cat_wrong.gif"); ;
				JOptionPane.showMessageDialog(null, "Wrong character! Please try again", "Wrong", JOptionPane.INFORMATION_MESSAGE,cat_wrong);	//cat_wrong
				errcnt++;	
				
				user_wrongs.add( userChar );
				lblScore.setText(Integer.parseInt(lblScore.getText())-1 + "");	//updating score
				lblTypo.setText(Integer.parseInt(lblTypo.getText())-1 + "");	//updating allowed typos
				
		
				for (JButton button : buttons)
				{
					
				    if(button.getText().equalsIgnoreCase(arg0.getKeyChar()+""))
		    		{
				    	System.out.println(button.getText());
				    	button.setBackground(Color.BLACK);
		    		}
				}
				if(errcnt > errLim)
				{
					endGame();
				}
			}	
		}
		
		@Override
		public void keyReleased(KeyEvent arg0) 
		{
			for (JButton button : buttons)
			{
				
			    if(button.getText().equalsIgnoreCase(arg0.getKeyChar()+""))
	    		{
			    	System.out.println(button.getText());
			    	button.setBackground(Color.BLACK);
	    		}
			}
		}


	}

	private JPanel contentPane;

	 
	 

	
	public static void main(String[] args) 
	{
		boot();
		
	}
	
	private static void boot()
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					JAVA_HW3_TYPING_TUTOR frame = new JAVA_HW3_TYPING_TUTOR();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	public JAVA_HW3_TYPING_TUTOR() throws IOException 
	{
		BufferedReader br = null;
		
		
		errLim = 10;
		time = 60;
		
		try 
		{
			br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"\\"+"Question.txt"));
			System.out.println(System.getProperty("user.dir"));
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
		//CONFIG
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//contentPane.setLayout(null);
		addKeyListener(new KeyEventHandler());
		setFocusable(true);
		setTitle("Typing App");
		
		JLabel lblNewLabel = new JLabel("<html>Typing Tutuor Game \n vitual keyborad will highlight your input, please finish following settence in 60 seconds<br>\n Now Start!!!</html>");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		
		//one line
		JButton btnTilda= new JButton("~");
		btnTilda.setBackground(Color.BLACK);
		btnTilda.setForeground(Color.WHITE);
		
		JButton btn1= new JButton("1");
		btn1.setBackground(Color.BLACK);
		btn1.setForeground(Color.WHITE);
		JButton btn2= new JButton("2");
		btn2.setBackground(Color.BLACK);
		btn2.setForeground(Color.WHITE);
		JButton btn3= new JButton("3");
		btn3.setBackground(Color.BLACK);
		btn3.setForeground(Color.WHITE);
		JButton btn4= new JButton("4");
		btn4.setBackground(Color.BLACK);
		btn4.setForeground(Color.WHITE);
		JButton btn5= new JButton("5");
		btn5.setBackground(Color.BLACK);
		btn5.setForeground(Color.WHITE);
		JButton btn6= new JButton("6");
		btn6.setBackground(Color.BLACK);
		btn6.setForeground(Color.WHITE);
		JButton btn7= new JButton("7");
		btn7.setBackground(Color.BLACK);
		btn7.setForeground(Color.WHITE);
		JButton btn8= new JButton("8");
		btn8.setBackground(Color.BLACK);
		btn8.setForeground(Color.WHITE);
		JButton btn9= new JButton("9");
		btn9.setBackground(Color.BLACK);
		btn9.setForeground(Color.WHITE);
		JButton btn0= new JButton("0");
		btn0.setBackground(Color.BLACK);
		btn0.setForeground(Color.WHITE);
		JButton btnMinus= new JButton("-");
		btnMinus.setBackground(Color.BLACK);
		btnMinus.setForeground(Color.WHITE);
		JButton btnPlus= new JButton("+");
		btnPlus.setBackground(Color.BLACK);
		btnPlus.setForeground(Color.WHITE);
		JButton btnBackSpace= new JButton("Backspace");
		btnBackSpace.setBackground(Color.BLACK);
		btnBackSpace.setForeground(Color.WHITE);
		JButton btnTab= new JButton("Tab");
		btnTab.setBackground(Color.BLACK);
		btnTab.setForeground(Color.WHITE);
		
		//two line
		JButton btnQ= new JButton("Q");
		btnQ.setBackground(Color.BLACK);
		btnQ.setForeground(Color.WHITE);
		JButton btnW= new JButton("W");
		btnW.setBackground(Color.BLACK);
		btnW.setForeground(Color.WHITE);
		JButton btnE= new JButton("E");
		btnE.setBackground(Color.BLACK);
		btnE.setForeground(Color.WHITE);
		JButton btnR= new JButton("R");
		btnR.setBackground(Color.BLACK);
		btnR.setForeground(Color.WHITE);
		JButton btnT= new JButton("T");
		btnT.setBackground(Color.BLACK);
		btnT.setForeground(Color.WHITE);
		JButton btnY= new JButton("Y");
		btnY.setBackground(Color.BLACK);
		btnY.setForeground(Color.WHITE);	
		JButton btnU= new JButton("U");
		btnU.setBackground(Color.BLACK);
		btnU.setForeground(Color.WHITE);
		JButton btnI= new JButton("I");
		btnI.setBackground(Color.BLACK);
		btnI.setForeground(Color.WHITE);
		JButton btnO= new JButton("O");
		btnO.setBackground(Color.BLACK);
		btnO.setForeground(Color.WHITE);
		JButton btnP= new JButton("P");
		btnP.setBackground(Color.BLACK);
		btnP.setForeground(Color.WHITE);
		JButton btnLBracket= new JButton("[");
		btnLBracket.setBackground(Color.BLACK);
		btnLBracket.setForeground(Color.WHITE);
		JButton btnRBracket= new JButton("]");
		btnRBracket.setBackground(Color.BLACK);
		btnRBracket.setForeground(Color.WHITE);
		JButton btnBackSlash= new JButton("\\");
		btnBackSlash.setBackground(Color.BLACK);
		btnBackSlash.setForeground(Color.WHITE);
		
		//three line
		JButton btnCaps= new JButton("Caps Lock");
		btnCaps.setBackground(Color.BLACK);
		btnCaps.setForeground(Color.WHITE);
		JButton btnA= new JButton("A");
		btnA.setBackground(Color.BLACK);
		btnA.setForeground(Color.WHITE);
		JButton btnS= new JButton("S");
		btnS.setBackground(Color.BLACK);
		btnS.setForeground(Color.WHITE);
		JButton btnD= new JButton("D");
		btnD.setBackground(Color.BLACK);
		btnD.setForeground(Color.WHITE);
		JButton btnF= new JButton("F");
		btnF.setBackground(Color.BLACK);
		btnF.setForeground(Color.WHITE);
		JButton btnG= new JButton("G");
		btnG.setBackground(Color.BLACK);
		btnG.setForeground(Color.WHITE);
		JButton btnH= new JButton("H");
		btnH.setBackground(Color.BLACK);
		btnH.setForeground(Color.WHITE);
		JButton btnJ= new JButton("J");
		btnJ.setBackground(Color.BLACK);
		btnJ.setForeground(Color.WHITE);
		JButton btnK= new JButton("K");
		btnK.setBackground(Color.BLACK);
		btnK.setForeground(Color.WHITE);
		JButton btnL= new JButton("L");
		btnL.setBackground(Color.BLACK);
		btnL.setForeground(Color.WHITE);
		JButton btnSemiColon= new JButton(";");
		btnSemiColon.setBackground(Color.BLACK);
		btnSemiColon.setForeground(Color.WHITE);
		JButton btnQuote= new JButton("'");
		btnQuote.setBackground(Color.BLACK);
		btnQuote.setForeground(Color.WHITE);
		JButton btnEnter= new JButton("Enter");
		btnEnter.setBackground(Color.BLACK);
		btnEnter.setForeground(Color.WHITE);
		
		//four line
		JButton btnShift= new JButton("Shift");		
		btnShift.setBackground(Color.BLACK);
		btnShift.setForeground(Color.WHITE);
		btnShift.setHorizontalAlignment(SwingConstants.LEADING);//aline 
		JButton btnZ= new JButton("Z");
		btnZ.setHorizontalAlignment(SwingConstants.LEADING);
		btnZ.setBackground(Color.BLACK);
		btnZ.setForeground(Color.WHITE);
		JButton btnX= new JButton("X");
		btnX.setHorizontalAlignment(SwingConstants.LEFT);
		btnX.setBackground(Color.BLACK);
		btnX.setForeground(Color.WHITE);
		JButton btnC= new JButton("C");
		btnC.setHorizontalAlignment(SwingConstants.LEFT);
		btnC.setBackground(Color.BLACK);
		btnC.setForeground(Color.WHITE);
		JButton btnV= new JButton("V");
		btnV.setHorizontalAlignment(SwingConstants.LEFT);
		btnV.setBackground(Color.BLACK);
		btnV.setForeground(Color.WHITE);
		JButton btnB= new JButton("B");
		btnB.setHorizontalAlignment(SwingConstants.LEFT);
		btnB.setBackground(Color.BLACK);
		btnB.setForeground(Color.WHITE);
		JButton btnN= new JButton("N");
		btnN.setHorizontalAlignment(SwingConstants.LEFT);
		btnN.setBackground(Color.BLACK);
		btnN.setForeground(Color.WHITE);
		JButton btnM= new JButton("M");
		btnM.setHorizontalAlignment(SwingConstants.LEFT);
		btnM.setBackground(Color.BLACK);
		btnM.setForeground(Color.WHITE);
		JButton btnComma= new JButton(",");
		btnComma.setHorizontalAlignment(SwingConstants.LEFT);
		btnComma.setBackground(Color.BLACK);
		btnComma.setForeground(Color.WHITE);
		JButton btnDot= new JButton(".");
		btnDot.setHorizontalAlignment(SwingConstants.LEFT);
		btnDot.setBackground(Color.BLACK);
		btnDot.setForeground(Color.WHITE);
		JButton btnForwardSlash= new JButton("/");
		btnForwardSlash.setHorizontalAlignment(SwingConstants.LEFT);
		btnForwardSlash.setBackground(Color.BLACK);
		btnForwardSlash.setForeground(Color.WHITE);
		
		JButton btnUP= new JButton("^");
		btnUP.setBackground(Color.BLACK);
		btnUP.setForeground(Color.WHITE);
		
		JButton btnSpace= new JButton("                                  ");
		btnSpace.setBackground(Color.BLACK);
		btnSpace.setForeground(Color.WHITE);
		
		JButton btnLEFT= new JButton("<");
		btnLEFT.setBackground(Color.BLACK);
		btnLEFT.setForeground(Color.WHITE);
		
		JButton btnDOWN= new JButton("v");
		btnDOWN.setBackground(Color.BLACK);
		btnDOWN.setForeground(Color.WHITE);
		
		JButton btnRIGHT= new JButton(">");
		btnRIGHT.setBackground(Color.BLACK);
		btnRIGHT.setForeground(Color.WHITE);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnTab)
							.addGap(22)
							.addComponent(btnQ)
							.addGap(5)
							.addComponent(btnW)
							.addGap(5)
							.addComponent(btnE)
							.addGap(5)
							.addComponent(btnR)
							.addGap(5)
							.addComponent(btnT)
							.addGap(5)
							.addComponent(btnY)
							.addGap(5)
							.addComponent(btnU)
							.addGap(5)
							.addComponent(btnI)
							.addGap(5)
							.addComponent(btnO)
							.addGap(5)
							.addComponent(btnP)
							.addGap(5)
							.addComponent(btnLBracket)
							.addGap(5)
							.addComponent(btnRBracket)
							.addGap(5)
							.addComponent(btnBackSlash))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnTilda)
							.addGap(5)
							.addComponent(btn1)
							.addGap(5)
							.addComponent(btn2)
							.addGap(5)
							.addComponent(btn3)
							.addGap(5)
							.addComponent(btn4)
							.addGap(5)
							.addComponent(btn5)
							.addGap(5)
							.addComponent(btn6)
							.addGap(5)
							.addComponent(btn7)
							.addGap(5)
							.addComponent(btn8)
							.addGap(5)
							.addComponent(btn9)
							.addGap(5)
							.addComponent(btn0)
							.addGap(5)
							.addComponent(btnMinus)
							.addGap(5)
							.addComponent(btnPlus)
							.addGap(5)
							.addComponent(btnBackSpace))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCaps)
								.addComponent(btnShift))
							.addGap(24)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnA)
									.addGap(5)
									.addComponent(btnS)
									.addGap(5)
									.addComponent(btnD))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnZ)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnV)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnX)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnF)
										.addComponent(btnC))
									.addGap(5)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnG)
										.addComponent(btnB))
									.addGap(5)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnH)
										.addComponent(btnN))
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addGap(5)
											.addComponent(btnJ))
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnM)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnK)
										.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
											.addComponent(btnComma)
											.addGap(8)))
									.addGap(2)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnDot)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(btnForwardSlash))
										.addGroup(gl_panel.createSequentialGroup()
											.addComponent(btnL)
											.addGap(5)
											.addComponent(btnSemiColon)
											.addGap(5)
											.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(btnLEFT)
												.addComponent(btnQuote)))))
								.addComponent(btnSpace))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUP)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnDOWN)
									.addGap(6)
									.addComponent(btnRIGHT))
								.addComponent(btnEnter))))
					.addContainerGap(358, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btnTilda)
						.addComponent(btn1)
						.addComponent(btn2)
						.addComponent(btn3)
						.addComponent(btn4)
						.addComponent(btn5)
						.addComponent(btn6)
						.addComponent(btn7)
						.addComponent(btn8)
						.addComponent(btn9)
						.addComponent(btn0)
						.addComponent(btnMinus)
						.addComponent(btnPlus)
						.addComponent(btnBackSpace))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnQ)
							.addComponent(btnTab))
						.addComponent(btnW)
						.addComponent(btnE)
						.addComponent(btnR)
						.addComponent(btnT)
						.addComponent(btnY)
						.addComponent(btnU)
						.addComponent(btnI)
						.addComponent(btnO)
						.addComponent(btnP)
						.addComponent(btnLBracket)
						.addComponent(btnRBracket)
						.addComponent(btnBackSlash))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnA)
							.addComponent(btnCaps))
						.addComponent(btnS)
						.addComponent(btnD)
						.addComponent(btnF)
						.addComponent(btnG)
						.addComponent(btnH)
						.addComponent(btnJ)
						.addComponent(btnK)
						.addComponent(btnL)
						.addComponent(btnSemiColon)
						.addComponent(btnQuote)
						.addComponent(btnEnter))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnShift)
						.addComponent(btnZ)
						.addComponent(btnV)
						.addComponent(btnX)
						.addComponent(btnC)
						.addComponent(btnB)
						.addComponent(btnN)
						.addComponent(btnDot)
						.addComponent(btnUP)
						.addComponent(btnForwardSlash)
						.addComponent(btnComma)
						.addComponent(btnM))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSpace)
						.addComponent(btnLEFT)
						.addComponent(btnDOWN)
						.addComponent(btnRIGHT)))
		);
		panel.setLayout(gl_panel);
		
		//  bug error: incompatible types: ImageIcon cannot be converted to Color
		
		
		   
		
		JPanel panelMid = new JPanel();
		contentPane.add(panelMid, BorderLayout.CENTER);
		panelMid.setLayout(new BorderLayout(0, 0));
		
		JLabel lblPangram = new JLabel("New label");
		lblPangram.setForeground(Color.BLUE);
		panelMid.add(lblPangram, BorderLayout.SOUTH);
		
		textAreaUser = new JTextArea();
		textAreaUser.setEditable(false);
		panelMid.add(textAreaUser, BorderLayout.CENTER);
		
		//Loading pangram to screen (above keyboard as mentioned in project requirements
		String line = "";
		ArrayList<String> allString = new ArrayList<String>();
		while ((line = br.readLine()) != null) 
        {
            allString.add(line);
        }
		Random rand = new Random();
		pangram = allString.get(rand.nextInt((allString.size()-1) + 1));
		br.close();
		 lblPangram.setText("<html>The random sentence is : <br><h1>" + pangram + "</h1></html>");
		 
		 JPanel panel_1 = new JPanel();
		 panelMid.add(panel_1, BorderLayout.EAST);
		 
		 JLabel lblScoreLabel = new JLabel("Score:");
		 
		 lblScore = new JLabel("0");
		 lblScore.setForeground(Color.RED);
		 
		 JLabel lblTimerLabel = new JLabel("Timer:");
		 
		 final JLabel lblTimer = new JLabel(time+"");
		 
		 JLabel lblTypoLabel = new JLabel("Typos:");
		 
		 lblTypo = new JLabel(errLim+"");
		 GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		 gl_panel_1.setHorizontalGroup(
		 	gl_panel_1.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel_1.createSequentialGroup()
		 			.addContainerGap(16, Short.MAX_VALUE)
		 			.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
		 				.addComponent(lblScore, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
		 				.addComponent(lblScoreLabel)
		 				.addComponent(lblTimerLabel, Alignment.TRAILING))
		 			.addContainerGap())
		 		.addGroup(gl_panel_1.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(lblTimer)
		 			.addContainerGap(35, Short.MAX_VALUE))
		 		.addGroup(gl_panel_1.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(lblTypoLabel)
		 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		 		.addGroup(gl_panel_1.createSequentialGroup()
		 			.addContainerGap()
		 			.addComponent(lblTypo)
		 			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		 );
		 gl_panel_1.setVerticalGroup(
		 	gl_panel_1.createParallelGroup(Alignment.LEADING)
		 		.addGroup(gl_panel_1.createSequentialGroup()
		 			.addGap(47)
		 			.addComponent(lblScoreLabel)
		 			.addGap(18)
		 			.addComponent(lblScore)
		 			.addGap(18)
		 			.addComponent(lblTimerLabel)
		 			.addGap(18)
		 			.addComponent(lblTimer, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
		 			.addPreferredGap(ComponentPlacement.UNRELATED)
		 			.addComponent(lblTypoLabel)
		 			.addGap(26)
		 			.addComponent(lblTypo)
		 			.addContainerGap(114, Short.MAX_VALUE))
		 );
		 panel_1.setLayout(gl_panel_1);
		 ButtonGroup bg = new ButtonGroup();
		 
		 //getting all buttons to handle button highlighting effect while typing
		 Component[] components = panel.getComponents();	//getting all components
		 buttons =  new ArrayList<JButton>();	//creating buttons ArrayList 
		 
		 //loop over components and get the buttons only
		 for (Component component : components)
		 {
			 
		     if (component instanceof JButton)
		     {
		         buttons.add((JButton) component);
		         
		         
		     }
		 }
		 
		 //bg
		ImageIcon background = new ImageIcon("bg.jpg");     
		JLabel bgLabel = new JLabel(background);
        bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());    
        JPanel imagePanel = (JPanel) this.getContentPane();
        imagePanel.setOpaque(false);
        this.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));   
		
		
		
		//right gif 
		cat_rightLabel.setBounds(200, 100, cat_right.getIconWidth(), cat_right.getIconHeight());    
		JPanel imagePane2 = (JPanel) this.getContentPane();
		this.getLayeredPane().add(cat_rightLabel, new Integer(Integer.MAX_VALUE));  
			

			
			
		//timer action listener
		 ActionListener endGame = new ActionListener() 
		 {
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				curTime++;
				if(curTime == time)
				{
					endGame();
				}
				else
				{
					lblTimer.setText(Integer.parseInt(lblTimer.getText())-1 + "");	
				}
			}
		 };		 
		 rollex = new Timer(1000, endGame); 
		 rollex.start();
		 
		 
	}
	
	private void endGame()
	{
		rollex.stop();
		Object[] EndOp = {"Restart", "Exit"};
		double Acc = Double.valueOf(lblScore.getText())/ Double.valueOf(idx);
		if ( Acc <=0 )
			Acc = 0;
		int end =JOptionPane.showOptionDialog(null, "TYPING TUTOR Game end: \n Total score: "+ lblScore.getText() + "\n Total Accuracy : " + Double.toString(Acc*100.0) + "%\n" + "user_wrongs: " + user_wrongs
		, "TYPING TUTOR Game is Over", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,EndOp, EndOp[0]);
		
		if(end==0)
		{
			boot();		
		}
		this.dispose();
	}
}

	

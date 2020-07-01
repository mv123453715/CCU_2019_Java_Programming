

import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Java_HW4_BouncingBalls {
	private Java_HW4_Container contan; 
	private ArrayList<Java_HW4_Ball> balls_list;	 
	private JFrame fme;
	private Canvas can;
	public static final int win_w = 600;
	public static final int win_h = 600;
	

	public class Java_HW4_Ball {
		public static final int DEFAULT_RADIUS = 30;
		private int speX;
		private int speY;
		private int r;
		private int posX; 
		private int posY;
		private int mode;
		private Color background_color;


		public Java_HW4_Ball(Java_HW4_Container container, int pX, int pY, Color bg_color,int m) {
			Random ran = new Random();
			r = DEFAULT_RADIUS;
			posX = pX;
			posY = pY;
			speX = ran.nextInt(5) + 1; 
			speY = ran.nextInt(5) + 1;
			background_color = bg_color;
			mode = m ;
		}

		public void balldraw(Graphics g) {// 0 is ball ,1 is img
			
			
			
			
			if ( mode %2 == 0 ){
				g.setColor(background_color);
				g.fillOval((int)(posX - r), (int)(posY - r), (int)(2 * r), (int)(2 * r));
			}//if
			else{
				String filename = new String("ball");
				filename = filename + Integer.toString(((mode/2) %24) +1 ) + ".jpg";
				Image img = Toolkit.getDefaultToolkit().getImage(filename);
				g.drawImage(img, posX, posY,null);
			}//else if 
			
			
		}

		public void ballmove(Java_HW4_Container container) {
			// ballmove
			posX += speX;
			posY += speY;
			int maxX = container.getMaxX(); // the 4 boundaries of container
			int minX = container.getMinX();
			int maxY = container.getMaxY();
			int minY = container.getMinY();
			// check horizontal
			if(posX > (maxX - r)) {
				speX = -speX;
				posX = (maxX - r);
			} else if(posX < (minX + r)) {
				speX = -speX;
				posX = (minX + r);
			}
			// check vertical
			if(posY > (maxY - r)) {
				speY = -speY;
				posY = (maxY - r);
			} else if(posY < (minY + r)) {
				speY = -speY;
				posY = (minY + r);
			}
		}
	}

	class WindowMonitor extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}

	class Canvas extends JPanel implements MouseListener {
		int s_X, s_Y;

		public Canvas(int w, int h) {
			s_X = w - 60;
			s_Y = h - 60;
			setSize(s_X, s_Y);
			setLocation(20, 20);
			setLayout(null);
			addMouseListener(this);
		}

		public int getSizeX() {
			return s_X;
		}

		public int getSizeY() {
			return s_Y;
		}
		
		// mouse click listener
		@Override
		public void mouseClicked(MouseEvent e) {
			System.err.println("mouse clicked on " + e.getX() + ", " + e.getY());
			System.err.println("debug...");
			addBall(e.getX(), e.getY());
			System.err.println("balls_list.size() = " + balls_list.size());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// System.err.println("mouse exited on " + e.getX() + ", " + e.getY());
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// System.err.println("mouse entered on " + e.getX() + ", " + e.getY());
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// System.err.println("mouse released on " + e.getX() + ", " + e.getY());
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// System.err.println("mouse pressed on " + e.getX() + ", " + e.getY());
		}
	


		@Override
		public void paintComponent(Graphics g) {

			super.paintComponent(g);
			for(int i=0; i<balls_list.size(); i++){
				balls_list.get(i).balldraw(g);
			}//for
		}
	}

	public Java_HW4_BouncingBalls(int w, int h) {
		fme = new JFrame("Bouncing Balls");
		fme.addWindowListener(new WindowMonitor());
		fme.setSize(w*2, h*2);
		fme.setLayout(null);
		
		
		
		ImageIcon background = new ImageIcon("bg.jpg");     
		Image image = background.getImage(); // transform it 
		//Image newimg = image.getScaledInstance(1200, 1000,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		background = new ImageIcon(image);  // transform it back
		JLabel bgLabel = new JLabel(background);
        bgLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());    
        JPanel imagePanel = (JPanel) fme.getContentPane();
        imagePanel.setOpaque(false);
        //fme.getLayeredPane().add(bgLabel, new Integer(Integer.MIN_VALUE));   
		fme.getLayeredPane().add(bgLabel,new Integer(Integer.MIN_VALUE));
		
		

		
		can = new Canvas(w, h); 


		contan = new Java_HW4_Container(0, 0, can.getSizeX(), can.getSizeY());
		
		
		

		balls_list = new ArrayList<Java_HW4_Ball>();

		Color a_color = new Color(0,0,255);
		Java_HW4_Ball a_ball = new Java_HW4_Ball(contan, 640, 360, a_color,0);
		balls_list.add(a_ball);

        fme.setMinimumSize(new java.awt.Dimension(900, 675));
        fme.setLocationRelativeTo(null);
        fme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fme.setVisible(true);// show window
		fme.add(can);


		Thread thread = new Thread() {
			public void run() {
				while(true) {
					update();
					can.repaint();
					try {
						Thread.sleep(10);
					} catch(Exception ex) {}
				}
			}
		};
		thread.start();
	}

	private void update() {
		for(int i=0; i<balls_list.size(); i++) {
			balls_list.get(i).ballmove(contan);
		}
	}

	private void addBall(int px, int py) {
		System.err.println("in addBall() function...");
		Random ran = new Random();
		Color a_color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		int ran_tmp = ran.nextInt(47) + 1;
		Java_HW4_Ball a_ball = new Java_HW4_Ball(contan, px, py, a_color,ran_tmp);
		balls_list.add(a_ball);
		
	}

	public static void main(String[] argv) {
		Java_HW4_BouncingBalls bb = new Java_HW4_BouncingBalls(win_w, win_h);
	}
}

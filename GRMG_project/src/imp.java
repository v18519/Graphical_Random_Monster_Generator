import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EventObject;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class imp extends JFrame{
private JButton button_s;
private JButton button_g;
public JPanel mainPanel;
private BufferedImage imgg;
public String monster1;
public String monster;
private JPanel bottomPanel;
private JLabel lab;
private int n;
private int o;
private int p;
private JLabel l;
private boolean t, er=false;

public imp(){
	
}
public void panel() {
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	//mainPanel.setBackground(Color.WHITE);
	
	bottomPanel = new JPanel();
//	up = new JPanel();
	mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	//mainPanel.add(lab, BorderLayout.NORTH);
	//up.setBackground(Color.RED);
	
//	bottomPanel.setBackground(Color.YELLOW);
	button();
	System.out.println("PANEL");
}
public void button() {
	
	JTextField txt = new JTextField("monster");
	l = new JLabel();
	mainPanel.add(l, BorderLayout.CENTER);	
	txt.setPreferredSize(new Dimension(200,50));
	
	bottomPanel.add(txt);
	
//	monster = txt.getText();
	
	
	button_s=new JButton("save");
	button_s.setPreferredSize(new Dimension(100,50));
	bottomPanel.add(button_s);
	ActionListener listener_s=new ActionListener() {
	

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
			
			monster1 = txt.getText();
			File f = new File("output\\"+monster1+".png");
			if(f.exists() ) {
				if(er==false) {
				
				
						
				l.setText("ERROR: FILE NAME ALREADY EXIST");
				er=true;
				System.out.println("error ");	
				}
				else {
					l.setText("ERROR:PLEASE CHANGE FILE NAME ALREADY EXIST");
				}
				
			}
			else{
					l.setText("SAVED");
					
					if(er==true) {
						
						System.out.println("error cleared");
						er=false;
					}
				
		//	System.out.println("Now Laterst moster is : "+monster1);
			save();
		//	System.out.println(monster1);
			
			}
		}

	};
	button_s.addActionListener(listener_s);
	
	button_g=new JButton("generate");
	button_g.setPreferredSize(new Dimension(100,50));
	bottomPanel.add(button_g);
	ActionListener listener_g=new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub	
			
			try {
				//lab.setIcon(null);
				if(t==true) {
					delete();
				}
				image();
				display();
				
					
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		private void delete() {
			// TODO Auto-generated method stub
			
			lab.setIcon(null);
			l.setText(null);
		//	lab.setText(null);
		
		//	lab.setDisabledIcon(null);
			System.out.println("Delete");
		}
	};
	button_g.addActionListener(listener_g);
}

public void frame() throws IOException {
	panel();
	JFrame frame = new JFrame("Graphical Random Monster Generator");
	frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
	frame.setSize(960, 1050);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
}

public void display() throws IOException {
	lab = new JLabel();
	mainPanel.add(lab, BorderLayout.CENTER);
	//mainPanel.add(lab);
	
	BufferedImage image = ImageIO.read(new File("output\\"+monster1+".png"));
	Image newimg = image.getScaledInstance(1000, 1000,  java.awt.Image.SCALE_SMOOTH);
	lab.setIcon(new ImageIcon(newimg));
	//lab.setText(monster1);
	t= true;
	System.out.println("DISPLAY");
	
}

public void image() throws IOException {
	System.out.println("image again");
	n = (int) (Math.random() * (100/4)+1);
	o = (int) (Math.random() * (100/4)+1);
	p = (int) (Math.random() * (100/4)+1);
	if(n==o || o==p || p==n) {
		System.out.println("GO TO image again");
		image();
		
	}
	File file1 = new File("images\\"+n+"b.png");
	File file2 = new File("images\\"+o+"a.png");
	File file3 = new File("images\\"+p+"c.png");
	File file22 = new File("images\\"+n+"bb.png");
	
 
	System.out.println(n);
	System.out.println(o);
	System.out.println(p);
	
	BufferedImage img1 = ImageIO.read(file1);
	BufferedImage img2 = ImageIO.read(file2);
	BufferedImage img3 = ImageIO.read(file3);
	BufferedImage img22 = ImageIO.read(file22);
	
	//int widthImg1 = 500;
	//int heightImg1 = 500;
	int widthImg1 = img1.getWidth();
	int heightImg1 = img1.getHeight();
	System.out.println("widthImg1 "+ widthImg1);
	System.out.println("heightImg1 "+ heightImg1);
	
	
	imgg = new BufferedImage(
	widthImg1, // Final image will have width and height as
	heightImg1, // addition of widths and heights of the images we already have
	BufferedImage.TRANSLUCENT);
	
	imgg.createGraphics().drawImage(img1, 0, 0, null);

	imgg.createGraphics().drawImage(img2, 0, 0, null);

	imgg.createGraphics().drawImage(img3, 0, 0, null);
	
	imgg.createGraphics().drawImage(img22, 0, 0, null);
	System.out.println("GENERATED");
	//File final_image = new File("C:\\Users\\vandana\\Downloads\\image 3\\"+monster1+".png");
	save();
	
	
}

public void save() {
	
	new imp();

	File final_image = new File("output\\"+monster1+".png"); // “png can also be used here”
	//System.out.println("it should save as..........................: "+monster1);
	monster1=null;
	//System.out.println("it should save as!!!!!!!!!!!!!!!!!!!!!!!!!!!: "+monster1);
	System.out.println("print");
	File final_image2 = new File("output\\null.png");
	final_image2.deleteOnExit();
		
	try {
		ImageIO.write(imgg, "png", final_image);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}

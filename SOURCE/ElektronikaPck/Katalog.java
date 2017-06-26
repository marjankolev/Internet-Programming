package ElektronikaPck;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Katalog extends JApplet{
	String[] elektroniki = {"kamera1.jpg","kamera2.jpg","laptop1.jpg","laptop2.jpg","mobilen1.jpg","mobilen3.png","tablet1.jpg","tablet2.jpg","zvucnici3.jpg","zvucnici4.jpg"};
	
	JButton sledno = new JButton("Следно");
	JButton prethodno = new JButton("Prethodno");
	
	JLabel tekst = new JLabel("Разгледајте ги нашите производи");
	
	int indx = 0;
	
	BufferedImage slika;
	
	JPanel panel = new JPanel();
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		InputStream pat = Katalog.class.getResourceAsStream(elektroniki[indx]);
		try {
			slika = ImageIO.read(pat);
			g.drawImage(slika, 100, 20, 300,450,null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start() {
		super.start();
		panel.setLayout(new GridLayout(1,2));
		panel.add(prethodno);
		panel.add(sledno);
	}
	
	@Override
	public void init() {
		super.init();
		setLayout(new BorderLayout());
		
		add(tekst,BorderLayout.NORTH);
		add(panel,BorderLayout.SOUTH);
		
		setSize(500,500);
	
		sledno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(indx>=0 && indx<9){
					indx++;
				}
				else
				{
					indx=0;
				}
				
				repaint();
			}
		});
		
		prethodno.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(indx==0)
				{
					indx=9;
				}
				else
				if(indx<=9){
					indx--;
				}
				
				repaint();
			}
		});
	}
}

package ElektronikaPck;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Nitki extends JApplet implements ActionListener{	
	Object objekt = new Object();
	Thread t1, t2;
	
	JLabel tekst = new JLabel("Кликни на копчето и изненади се!");
	
	JButton klikni_me = new JButton("Кликни ме");
	
	public synchronized void iznenaduvanje1(){
		tekst.setText("Вие сте 1 000 000 посетител");
		tekst.setForeground(new Color(70,70,125));
	}
	
	public synchronized void iznenaduvanje2(){
		tekst.setText("Добивте награден ваучер од 10 000 денари за секаков вид на електроника");
		tekst.setForeground(new Color(70,125,70));
	}
	
	private class Nitka1 implements Runnable{

		@Override
		public void run() {
			while(true){
				synchronized(objekt){
					try{
						iznenaduvanje1();
						objekt.notify();
						objekt.wait();
						Thread.sleep(900);
					}catch(Exception e){
						
					}
				}
			}
		}
		
	}
	
	private class Nitka2 implements Runnable{

		@Override
		public void run() {
			while(true){
				synchronized(objekt){
					try{
						iznenaduvanje2();
						objekt.notify();
						objekt.wait();
						Thread.sleep(900);
					}catch(Exception e){
						
					}
				}
			}
		}
		
	}
	
	@Override
	public void start() {
		super.start();
		tekst.setForeground(new Color(0,0,255));
		tekst.setFont(new Font("Arial",1,20));
	}
	
	@Override
	public void init() {

		super.init();
		
		setSize(800,50);
		setLayout(new BorderLayout());
		
		add(tekst,BorderLayout.NORTH);
		add(klikni_me,BorderLayout.CENTER);
		
		Nitka1 n1 = new Nitka1();
		Nitka2 n2 = new Nitka2();
		
		 t1 = new Thread(n1);
		 t2 = new Thread(n2);
		
		klikni_me.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		t1.start();
		t2.start();
	}

}


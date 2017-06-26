package ElektronikaPck;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SpecijalnaPonuda extends JApplet {
	JLabel tekst = new JLabel(
			"Доколку во следните 10 минути купите еден наш прозивод добивате гратис подарок");

	JLabel tekst2 = new JLabel(
			"Внесете го бројот кој го добивте при купување на производот");

	JTextField broj = new JTextField();

	JLabel tekst3 = new JLabel("Изберете подарок");

	ButtonGroup podarok_grupa = new ButtonGroup();

	JRadioButton podarok1 = new JRadioButton("Биро за компјутер");
	JRadioButton podarok2 = new JRadioButton("Држач за мобилен");
	JRadioButton podarok3 = new JRadioButton("Слушалки за мобилен/компјутер");

	JLabel tekst4 = new JLabel("Адреса");

	JTextArea adresa = new JTextArea();

	JLabel tekst5 = new JLabel("Ве молиме обележете со што се согласувате");

	JCheckBox izbor1 = new JCheckBox("Онлајн продавницата е добро организирана");
	JCheckBox izbor2 = new JCheckBox("Нарачката стигнува во најбрз рок");
	JCheckBox izbor3 = new JCheckBox("Изборот на уреди е одличен");

	JLabel tekst6 = new JLabel("Други забелешки");

	JTextArea zabeleski = new JTextArea();

	JButton isprati = new JButton("Испрати");

	JPanel panel1 = new JPanel();
	JPanel panel2 = new JPanel();
	JPanel panel3 = new JPanel();
	JPanel panel4 = new JPanel();
	JPanel panel5 = new JPanel();

	@Override
	public void start() {
		super.start();
		panel1.setLayout(new GridLayout(14, 1));

		podarok_grupa.add(podarok1);
		podarok_grupa.add(podarok2);
		podarok_grupa.add(podarok3);

		panel2.setLayout(new FlowLayout());
		panel2.add(podarok1);
		panel2.add(podarok2);
		panel2.add(podarok3);

		panel1.add(tekst);
		panel1.add(tekst2);
		panel1.add(broj);
		panel1.add(tekst3);
		panel1.add(panel2);
		panel1.add(tekst4);
		panel1.add(adresa);
		panel1.add(tekst5);
		panel1.add(izbor1);
		panel1.add(izbor2);
		panel1.add(izbor3);
		panel1.add(tekst6);
		panel1.add(zabeleski);
		panel1.add(isprati);

	}

	@Override
	public void init() {
		super.init();

		add(panel1);
		setSize(500, 600);

		isprati.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (broj.getText().isEmpty()) {
					JOptionPane
							.showMessageDialog(
									null,
									"Ве молиме внесте број кој го добивте при купување на производот",
									"Грешка", JOptionPane.ERROR_MESSAGE);
				}else if (broj.getText().length() != 8) {
					JOptionPane.showMessageDialog(null,
							"Кодот мора да содржи точно 8 бројки", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				}else if (!podarok1.isSelected() && !podarok2.isSelected()
						&& !podarok3.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"Ве молиме изберете подарок", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				} else if (adresa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Ве молиме внесете адреса", "Грешка",
							JOptionPane.ERROR_MESSAGE);
				} else if (!izbor1.isSelected() && !izbor2.isSelected()
						&& !izbor3.isSelected()) {
					JOptionPane.showMessageDialog(null,
							"Ве молиме изберете со што се согласувате",
							"Грешка", JOptionPane.ERROR_MESSAGE);
				}  else {
					JOptionPane
							.showMessageDialog(
									null,
									"Вашиот подарок ќе биде доставен до вашиот дома во најбрз можен рок. Ви Благодариме",
									"Грешка", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		broj.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				char brojka = e.getKeyChar();

				if (brojka <= '0' || brojka >= '9') {
					getToolkit().beep();
					e.consume();
				}

			}

			@Override
			public void keyReleased(KeyEvent e) {

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
	}
}

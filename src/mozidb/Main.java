package mozidb;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class Main extends JPanel {
	private final Action action = new SwingAction();

	/**
	 * Create the panel.
	 */
	public Main() {
		setLayout(null);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setToolTipText("");
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_1.setBounds(46, 137, 147, 34);
		add(textArea_1);
		
		JLabel lblAdatok = new JLabel("Adat 1");
		lblAdatok.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdatok.setBounds(67, 101, 100, 25);
		add(lblAdatok);
		
		JList list = new JList();
		list.setToolTipText("");
		list.setBounds(212, 357, -129, -174);
		add(list);
		
		JLabel lblAdat = new JLabel("Adat 2");
		lblAdat.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdat.setBounds(234, 101, 100, 25);
		add(lblAdat);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setToolTipText("");
		textArea_2.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_2.setBounds(212, 130, 147, 34);
		add(textArea_2);
		
		JLabel lblAdat_1 = new JLabel("Adat 3");
		lblAdat_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdat_1.setBounds(398, 101, 100, 25);
		add(lblAdat_1);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setToolTipText("");
		textArea_3.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_3.setBounds(376, 130, 147, 34);
		add(textArea_3);
		
		JLabel lblAdat_2 = new JLabel("Adat 4");
		lblAdat_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdat_2.setBounds(574, 101, 100, 25);
		add(lblAdat_2);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setToolTipText("");
		textArea_4.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_4.setBounds(552, 130, 147, 34);
		add(textArea_4);
		
		JLabel lblAdat_3 = new JLabel("Adat 5");
		lblAdat_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdat_3.setBounds(749, 101, 100, 25);
		add(lblAdat_3);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setToolTipText("");
		textArea_5.setFont(new Font("Monospaced", Font.PLAIN, 16));
		textArea_5.setBounds(727, 130, 147, 34);
		add(textArea_5);
		
		JButton btnNewButton = new JButton("Bevitel\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(96, 273, 89, 23);
		add(btnNewButton);{
			System.out.print("Gomb megnyomva");
		}

	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}

public static void main(String[] args) {
	
}
}


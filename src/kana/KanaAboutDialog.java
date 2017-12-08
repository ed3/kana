package kana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class KanaAboutDialog extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public KanaAboutDialog(JFrame parent, final String op) {
		super(parent, parent.getTitle() + " " + op, true);
		setSize(320, 200);
		setLocationRelativeTo(parent.getParent());
		setAlwaysOnTop(true);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("OK");
		btnAdd.setBounds(114, 120, 90, 30);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		contentPane.add(btnAdd);
		
		JLabel lblAuthor = new JLabel("Author: Ed");
		lblAuthor.setBounds(15, 16, 280, 25);
		contentPane.add(lblAuthor);
		
		JLabel lblWeb = new JLabel("Web: https://github.com/ed3/kana");
		lblWeb.setBounds(15, 45, 280, 50);
		contentPane.add(lblWeb);
		setVisible(true);
	}
}
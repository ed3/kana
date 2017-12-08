package kana;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class Kana extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private JButton btnHiRo, btnKaRo, btnRoHi, btnRoKa;
	private JMenuItem mHiRo, mKaRo, mRoHi, mRoKa, mAbout, mExit;
	private JSpinner spinSlide, spinTest;

	public static void main(String[] args) {
		setUIFont(new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN, 18));
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		Kana frame = new Kana();
		frame.setIconImage(img("app").getImage());
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public Kana() {
		setTitle("Kana");
		setSize(700, 590);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - 700) / 2, (screen.height - 590) / 2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar mbar = new JMenuBar();
		mHiRo = new JMenuItem("Hiragana - Romaji");
		mHiRo.addActionListener(this);
		mKaRo = new JMenuItem("Katakana - Romaji");
		mKaRo.addActionListener(this);
		
		mRoHi = new JMenuItem("Romaji - Hiragana");
		mRoHi.addActionListener(this);
		mRoKa = new JMenuItem("Romaji - Katakana");
		mRoKa.addActionListener(this);

		mExit = new JMenuItem("Exit");
		mExit.addActionListener(this);

		JMenu mFile = new JMenu("File");
		mbar.add(mFile);
		mFile.add(mHiRo);
		mFile.add(mKaRo);
		mFile.add(mRoHi);
		mFile.add(mRoKa);
		mFile.add(new JSeparator());
		mFile.add(mExit);

		JMenu mHelp = new JMenu("Help");
		mbar.add(mHelp);
		mAbout = new JMenuItem("About");
		mAbout.addActionListener(this);
		mHelp.add(mAbout);
		
		setJMenuBar(mbar);

		
		spinSlide = new JSpinner(new SpinnerNumberModel(5, 5, 15, 5));// initial,min,max,step
		spinSlide.setBounds(357, 155, 46, 26);
		contentPane.add(spinSlide);
		
		spinTest = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
		spinTest.setBounds(356, 217, 46, 26);
		contentPane.add(spinTest);

		JLabel lblSlideSeconds = new JLabel("Slide / seconds");
		lblSlideSeconds.setBounds(127, 159, 128, 20);
		contentPane.add(lblSlideSeconds);

		JLabel lblTestDuration = new JLabel("Test duration / minutes");
		lblTestDuration.setBounds(127, 220, 190, 20);
		contentPane.add(lblTestDuration);

		btnHiRo = new JButton("Hiragana - Romaji");
		btnHiRo.addActionListener(this);
		btnHiRo.setBounds(88, 384, 250, 50);
		contentPane.add(btnHiRo);
		
		btnKaRo = new JButton("Katakana - Romaji");
		btnKaRo.addActionListener(this);
		btnKaRo.setBounds(356, 384, 250, 50);
		contentPane.add(btnKaRo);

		btnRoHi = new JButton("Romaji - Hiragana");
		btnRoHi.addActionListener(this);
		btnRoHi.setBounds(88, 450, 250, 50);
		contentPane.add(btnRoHi);
		
		btnRoKa = new JButton("Romaji - Katakana");
		btnRoKa.addActionListener(this);
		btnRoKa.setBounds(356, 450, 250, 50);
		contentPane.add(btnRoKa);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		if (e.getSource() == mHiRo || e.getSource() == btnHiRo) {
			new KanaTestDialog(this, 1, 0, (Integer) spinSlide.getValue(), (Integer) spinTest.getValue());//this,from,to,slide time,test time
		}
		if (e.getSource() == mKaRo || e.getSource() == btnKaRo) {
			new KanaTestDialog(this, 2, 0, (Integer) spinSlide.getValue(), (Integer) spinTest.getValue());
		}
		if(e.getSource() == mRoHi || e.getSource() == btnRoHi) {
			new KanaTestDialog(this, 0, 1, (Integer) spinSlide.getValue(), (Integer) spinTest.getValue());
		}
		if(e.getSource() == mRoKa || e.getSource() == btnRoKa) {
			new KanaTestDialog(this, 0, 2, (Integer) spinSlide.getValue(), (Integer) spinTest.getValue());
		}
		if (e.getSource() == mAbout) {
			new KanaAboutDialog(this, "About");
		}
	}

	private static ImageIcon img(String pic) {
		ImageIcon img = new ImageIcon(Kana.class.getResource("/img/" + pic + ".png"));
		return img;
	}

	public static void setUIFont(javax.swing.plaf.FontUIResource f) {
		Enumeration<?> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource)
				UIManager.put(key, f);
		}
	}
}
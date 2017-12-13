package kana;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class KanaTestDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblKana;
	private int from, to;
	private Timer timerS, timerT;
	public int maru = 0;
	public int batsu = 0;
	
	public KanaTestDialog(final JFrame parent, final int from, final int to, int spinS, int spinT) {
		super(parent, parent.getTitle(), true);
		this.from = from;
		this.to = to;
		setSize(700, 590);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation((screen.width - 700) / 2, (screen.height - 590) / 2);
		//setLocationRelativeTo(parent.getParent());
		setAlwaysOnTop(true);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblKana = new JLabel();
		lblKana.setHorizontalAlignment(SwingConstants.CENTER);
		timerS = new Timer(1000 * spinS, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblKana.setText(KanaSyllable.A.random().getType(from));
			}
		});
		timerS.setRepeats(true);
		timerS.setCoalesce(true);
		timerS.setInitialDelay(0);
		timerS.start();
		
		timerT = new Timer(1000 * 60 * spinT, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timerS.stop();
				setVisible(false);
				dispose();
				JOptionPane.showMessageDialog(null, "Maru: " + maru + ", Batsu: " + batsu, "Results", 1);
				timerT.stop();
			}
		});
		timerT.start();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				timerT.stop();
				setVisible(false);
				dispose();
			}
		});
		
		lblKana.setBounds(47, 26, 250, 150);
		lblKana.setFont(new Font("MS Mincho", Font.BOLD, 120));
		contentPane.add(lblKana);
		
		if(to != 0) {
			UIManager.put("Button.font", new Font("MS Mincho", Font.BOLD, 18));
		} else {
			UIManager.put("Button.font", new Font("Tahoma", Font.PLAIN, 18));
		}
		JButton btnA = new JButton(KanaSyllable.A.getType(to));
		btnA.addActionListener(this);
		btnA.setBounds(375, 16, 60, 30);
		contentPane.add(btnA);

		JButton btnI = new JButton(KanaSyllable.I.getType(to));
		btnI.addActionListener(this);
		btnI.setBounds(435, 16, 60, 30);
		contentPane.add(btnI);

		JButton btnU = new JButton(KanaSyllable.U.getType(to));
		btnU.addActionListener(this);
		btnU.setBounds(495, 16, 60, 30);
		contentPane.add(btnU);

		JButton btnE = new JButton(KanaSyllable.E.getType(to));
		btnE.addActionListener(this);
		btnE.setBounds(555, 16, 60, 30);
		contentPane.add(btnE);

		JButton btnO = new JButton(KanaSyllable.O.getType(to));
		btnO.addActionListener(this);
		btnO.setBounds(615, 16, 60, 30);
		contentPane.add(btnO);
		
		JButton btnKa = new JButton(KanaSyllable.KA.getType(to));
		btnKa.addActionListener(this);
		btnKa.setBounds(375, 51, 60, 30);
		contentPane.add(btnKa);
		
		JButton btnKi = new JButton(KanaSyllable.KI.getType(to));
		btnKi.addActionListener(this);
		btnKi.setBounds(435, 51, 60, 30);
		contentPane.add(btnKi);
		
		JButton btnKu = new JButton(KanaSyllable.KU.getType(to));
		btnKu.addActionListener(this);
		btnKu.setBounds(495, 51, 60, 30);
		contentPane.add(btnKu);
		
		JButton btnKe = new JButton(KanaSyllable.KE.getType(to));
		btnKe.addActionListener(this);
		btnKe.setBounds(555, 51, 60, 30);
		contentPane.add(btnKe);
		
		JButton btnKo = new JButton(KanaSyllable.KO.getType(to));
		btnKo.addActionListener(this);
		btnKo.setBounds(615, 51, 60, 30);
		contentPane.add(btnKo);
		
		JButton btnGa = new JButton(KanaSyllable.GA.getType(to));
		btnGa.addActionListener(this);
		btnGa.setBounds(375, 86, 60, 30);
		contentPane.add(btnGa);
		
		JButton btnGi = new JButton(KanaSyllable.GI.getType(to));
		btnGi.addActionListener(this);
		btnGi.setBounds(435, 86, 60, 30);
		contentPane.add(btnGi);
		
		JButton btnGu = new JButton(KanaSyllable.GU.getType(to));
		btnGu.addActionListener(this);
		btnGu.setBounds(495, 86, 60, 30);
		contentPane.add(btnGu);
		
		JButton btnGe = new JButton(KanaSyllable.GE.getType(to));
		btnGe.addActionListener(this);
		btnGe.setBounds(555, 86, 60, 30);
		contentPane.add(btnGe);
		
		JButton btnGo = new JButton(KanaSyllable.GO.getType(to));
		btnGo.addActionListener(this);
		btnGo.setBounds(615, 86, 60, 30);
		contentPane.add(btnGo);
		
		JButton btnSa = new JButton(KanaSyllable.SA.getType(to));
		btnSa.addActionListener(this);
		btnSa.setBounds(375, 121, 60, 30);
		contentPane.add(btnSa);
		
		JButton btnShi = new JButton(KanaSyllable.SHI.getType(to));
		btnShi.addActionListener(this);
		btnShi.setBounds(435, 121, 60, 30);
		contentPane.add(btnShi);
		
		JButton btnSu = new JButton(KanaSyllable.SU.getType(to));
		btnSu.addActionListener(this);
		btnSu.setBounds(495, 121, 60, 30);
		contentPane.add(btnSu);
		
		JButton btnSe = new JButton(KanaSyllable.SE.getType(to));
		btnSe.addActionListener(this);
		btnSe.setBounds(555, 121, 60, 30);
		contentPane.add(btnSe);
		
		JButton btnSo = new JButton(KanaSyllable.SO.getType(to));
		btnSo.addActionListener(this);
		btnSo.setBounds(615, 121, 60, 30);
		contentPane.add(btnSo);
		
		JButton btnZa = new JButton(KanaSyllable.ZA.getType(to));
		btnZa.addActionListener(this);
		btnZa.setBounds(375, 156, 60, 30);
		contentPane.add(btnZa);
		
		JButton btnJi = new JButton(KanaSyllable.JI.getType(to));
		btnJi.addActionListener(this);
		btnJi.setBounds(435, 156, 60, 30);
		contentPane.add(btnJi);
		
		JButton btnZu = new JButton(KanaSyllable.ZU.getType(to));
		btnZu.addActionListener(this);
		btnZu.setBounds(495, 156, 60, 30);
		contentPane.add(btnZu);
		
		JButton btnZe = new JButton(KanaSyllable.ZE.getType(to));
		btnZe.addActionListener(this);
		btnZe.setBounds(555, 156, 60, 30);
		contentPane.add(btnZe);
		
		JButton btnZo = new JButton(KanaSyllable.ZO.getType(to));
		btnZo.addActionListener(this);
		btnZo.setBounds(615, 156, 60, 30);
		contentPane.add(btnZo);

		JButton btnTa = new JButton(KanaSyllable.TA.getType(to));
		btnTa.addActionListener(this);
		btnTa.setBounds(375, 191, 60, 30);
		contentPane.add(btnTa);
		
		JButton btnChi = new JButton(KanaSyllable.CHI.getType(to));
		btnChi.addActionListener(this);
		btnChi.setBounds(435, 191, 60, 30);
		contentPane.add(btnChi);

		JButton btnTsu = new JButton(KanaSyllable.TSU.getType(to));
		btnTsu.addActionListener(this);
		btnTsu.setBounds(495, 191, 60, 30);
		contentPane.add(btnTsu);
		
		JButton btnTe = new JButton(KanaSyllable.TE.getType(to));
		btnTe.addActionListener(this);
		btnTe.setBounds(555, 191, 60, 30);
		contentPane.add(btnTe);

		JButton btnTo = new JButton(KanaSyllable.TO.getType(to));
		btnTo.addActionListener(this);
		btnTo.setBounds(615, 191, 60, 30);
		contentPane.add(btnTo);
		
		JButton btnDa = new JButton(KanaSyllable.DA.getType(to));
		btnDa.addActionListener(this);
		btnDa.setBounds(375, 226, 60, 30);
		contentPane.add(btnDa);
		
		JButton btnDe = new JButton(KanaSyllable.DE.getType(to));
		btnDe.addActionListener(this);
		btnDe.setBounds(555, 226, 60, 30);
		contentPane.add(btnDe);
		
		JButton btnDo = new JButton(KanaSyllable.DO.getType(to));
		btnDo.addActionListener(this);
		btnDo.setBounds(615, 226, 60, 30);
		contentPane.add(btnDo);
		
		JButton btnNa = new JButton(KanaSyllable.NA.getType(to));
		btnNa.addActionListener(this);
		btnNa.setBounds(375, 261, 60, 30);
		contentPane.add(btnNa);
		
		JButton btnNi = new JButton(KanaSyllable.NI.getType(to));
		btnNi.addActionListener(this);
		btnNi.setBounds(435, 261, 60, 30);
		contentPane.add(btnNi);
		
		JButton btnNu = new JButton(KanaSyllable.NU.getType(to));
		btnNu.addActionListener(this);
		btnNu.setBounds(495, 261, 60, 30);
		contentPane.add(btnNu);
		
		JButton btnNe = new JButton(KanaSyllable.NE.getType(to));
		btnNe.addActionListener(this);
		btnNe.setBounds(555, 261, 60, 30);
		contentPane.add(btnNe);
		
		JButton btnNo = new JButton(KanaSyllable.NO.getType(to));
		btnNo.addActionListener(this);
		btnNo.setBounds(615, 261, 60, 30);
		contentPane.add(btnNo);
		
		JButton btnHa = new JButton(KanaSyllable.HA.getType(to));
		btnHa.addActionListener(this);
		btnHa.setBounds(375, 296, 60, 30);
		contentPane.add(btnHa);
		
		JButton btnHi = new JButton(KanaSyllable.HI.getType(to));
		btnHi.addActionListener(this);
		btnHi.setBounds(435, 296, 60, 30);
		contentPane.add(btnHi);
		
		JButton btnFu = new JButton(KanaSyllable.FU.getType(to));
		btnFu.addActionListener(this);
		btnFu.setBounds(495, 296, 60, 30);
		contentPane.add(btnFu);
		
		JButton btnHe = new JButton(KanaSyllable.HE.getType(to));
		btnHe.addActionListener(this);
		btnHe.setBounds(555, 296, 60, 30);
		contentPane.add(btnHe);
		
		JButton btnHo = new JButton(KanaSyllable.HO.getType(to));
		btnHo.addActionListener(this);
		btnHo.setBounds(615, 296, 60, 30);
		contentPane.add(btnHo);
		
		JButton btnBa = new JButton(KanaSyllable.BA.getType(to));
		btnBa.addActionListener(this);
		btnBa.setBounds(375, 331, 60, 30);
		contentPane.add(btnBa);
		
		JButton btnBi = new JButton(KanaSyllable.BI.getType(to));
		btnBi.addActionListener(this);
		btnBi.setBounds(435, 331, 60, 30);
		contentPane.add(btnBi);
		
		JButton btnBu = new JButton(KanaSyllable.BU.getType(to));
		btnBu.addActionListener(this);
		btnBu.setBounds(495, 331, 60, 30);
		contentPane.add(btnBu);
		
		JButton btnBe = new JButton(KanaSyllable.BE.getType(to));
		btnBe.addActionListener(this);
		btnBe.setBounds(555, 331, 60, 30);
		contentPane.add(btnBe);
		
		JButton btnBo = new JButton(KanaSyllable.BO.getType(to));
		btnBo.addActionListener(this);
		btnBo.setBounds(615, 331, 60, 30);
		contentPane.add(btnBo);
		
		JButton btnPa = new JButton(KanaSyllable.PA.getType(to));
		btnPa.addActionListener(this);
		btnPa.setBounds(375, 366, 60, 30);
		contentPane.add(btnPa);
		
		JButton btnPi = new JButton(KanaSyllable.PI.getType(to));
		btnPi.addActionListener(this);
		btnPi.setBounds(435, 366, 60, 30);
		contentPane.add(btnPi);
		
		JButton btnPu = new JButton(KanaSyllable.PU.getType(to));
		btnPu.addActionListener(this);
		btnPu.setBounds(495, 366, 60, 30);
		contentPane.add(btnPu);
		
		JButton btnPe = new JButton(KanaSyllable.PE.getType(to));
		btnPe.addActionListener(this);
		btnPe.setBounds(555, 366, 60, 30);
		contentPane.add(btnPe);
		
		JButton btnPo = new JButton(KanaSyllable.PO.getType(to));
		btnPo.addActionListener(this);
		btnPo.setBounds(615, 366, 60, 30);
		contentPane.add(btnPo);
		
		JButton btnMa = new JButton(KanaSyllable.MA.getType(to));
		btnMa.addActionListener(this);
		btnMa.setBounds(375, 401, 60, 30);
		contentPane.add(btnMa);
		
		JButton btnMi = new JButton(KanaSyllable.MI.getType(to));
		btnMi.addActionListener(this);
		btnMi.setBounds(435, 401, 60, 30);
		contentPane.add(btnMi);
		
		JButton btnMu = new JButton(KanaSyllable.MU.getType(to));
		btnMu.addActionListener(this);
		btnMu.setBounds(495, 401, 60, 30);
		contentPane.add(btnMu);
		
		JButton btnMe = new JButton(KanaSyllable.ME.getType(to));
		btnMe.addActionListener(this);
		btnMe.setBounds(555, 401, 60, 30);
		contentPane.add(btnMe);
		
		JButton btnMo = new JButton(KanaSyllable.MO.getType(to));
		btnMo.addActionListener(this);
		btnMo.setBounds(615, 401, 60, 30);
		contentPane.add(btnMo);
		
		JButton btnYa = new JButton(KanaSyllable.YA.getType(to));
		btnYa.addActionListener(this);
		btnYa.setBounds(375, 436, 60, 30);
		contentPane.add(btnYa);

		JButton btnYu = new JButton(KanaSyllable.YU.getType(to));
		btnYu.addActionListener(this);
		btnYu.setBounds(495, 436, 60, 30);
		contentPane.add(btnYu);

		JButton btnYo = new JButton(KanaSyllable.YO.getType(to));
		btnYo.addActionListener(this);
		btnYo.setBounds(615, 436, 60, 30);
		contentPane.add(btnYo);
		
		JButton btnRa = new JButton(KanaSyllable.RA.getType(to));
		btnRa.addActionListener(this);
		btnRa.setBounds(375, 471, 60, 30);
		contentPane.add(btnRa);
		
		JButton btnRi = new JButton(KanaSyllable.RI.getType(to));
		btnRi.addActionListener(this);
		btnRi.setBounds(435, 471, 60, 30);
		contentPane.add(btnRi);
		
		JButton btnRu = new JButton(KanaSyllable.RU.getType(to));
		btnRu.addActionListener(this);
		btnRu.setBounds(495, 471, 60, 30);
		contentPane.add(btnRu);
		
		JButton btnRe = new JButton(KanaSyllable.RE.getType(to));
		btnRe.addActionListener(this);
		btnRe.setBounds(555, 471, 60, 30);
		contentPane.add(btnRe);
		
		JButton btnRo = new JButton(KanaSyllable.RO.getType(to));
		btnRo.addActionListener(this);
		btnRo.setBounds(615, 471, 60, 30);
		contentPane.add(btnRo);
		
		JButton btnWa = new JButton(KanaSyllable.WA.getType(to));
		btnWa.addActionListener(this);
		btnWa.setBounds(375, 506, 60, 30);
		contentPane.add(btnWa);
		
		JButton btnWo = new JButton(KanaSyllable.WO.getType(to));
		btnWo.addActionListener(this);
		btnWo.setBounds(615, 506, 60, 30);
		contentPane.add(btnWo);
		
		JButton btnN = new JButton(KanaSyllable.N.getType(to));
		btnN.addActionListener(this);
		btnN.setBounds(495, 506, 60, 30);
		contentPane.add(btnN);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		JButton btn = (JButton) e.getSource();
//		System.out.println(btn.getText());
		if(from == 1) {
		if(KanaSyllable.valueOf(e.getActionCommand().toUpperCase()).getHiragana() == lblKana.getText()) {
			maru += 1;
		} else {
			batsu += 1;
		}
		}
		if(from == 2) {
		if(KanaSyllable.valueOf(e.getActionCommand().toUpperCase()).getKatakana() == lblKana.getText()) {
			maru += 1;
		} else {
			batsu += 1;
		}
		}
		if(to == 1) {
		if(e.getActionCommand() == KanaSyllable.valueOf(lblKana.getText().toUpperCase()).getHiragana()) {
			maru += 1;
		} else {
			batsu += 1;
		}
		}
		if(to == 2) {
		if(e.getActionCommand() == KanaSyllable.valueOf(lblKana.getText().toUpperCase()).getKatakana()) {
			maru += 1;
		} else {
			batsu += 1;
		}
		}
		lblKana.setText(KanaSyllable.A.random().getType(from));
		timerS.restart();
		timerS.start();
	}
}
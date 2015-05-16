import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;


public class TestGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestGUI window = new TestGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TestGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel container = new JPanel();
		container.setBounds(0, 0, 784, 442);
		frame.getContentPane().add(container);
		container.setLayout(null);
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 0, 784, 60);
		container.add(menuPanel);
		menuPanel.setLayout(null);
		
		JButton btnNewRecoding = new JButton("new Recoding");
		btnNewRecoding.setBounds(0, 37, 153, 23);
		menuPanel.add(btnNewRecoding);
		
		JButton btnPlayOld = new JButton("load file");
		btnPlayOld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPlayOld.setBounds(157, 37, 89, 23);
		menuPanel.add(btnPlayOld);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 784, 26);
		menuPanel.add(toolBar);
		
		JButton btnFile = new JButton("File");
		btnFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnFile);
		
		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(SystemColor.activeCaption);
		optionPanel.setBounds(0, 60, 177, 382);
		container.add(optionPanel);
		optionPanel.setLayout(null);
		
		JButton btnRecord = new JButton("record");
		btnRecord.setBounds(10, 24, 89, 23);
		optionPanel.add(btnRecord);
		
		JButton btnStart = new JButton("start");
		btnStart.setBounds(10, 58, 89, 23);
		optionPanel.add(btnStart);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setBounds(10, 91, 89, 23);
		optionPanel.add(btnStop);
		
		JLabel lblSave = new JLabel("Save:");
		lblSave.setBounds(10, 185, 46, 14);
		optionPanel.add(lblSave);
		
		JPanel pianoKeysPanel = new JPanel();
		pianoKeysPanel.setBackground(SystemColor.controlHighlight);
		pianoKeysPanel.setBounds(176, 60, 608, 382);
		container.add(pianoKeysPanel);
		pianoKeysPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(60, 101, 514, 200);
		pianoKeysPanel.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("c");
		btnNewButton.setBounds(0, 0, 50, 200);
		panel.add(btnNewButton);
		
		JButton btnD = new JButton("d");
		btnD.setBounds(58, 0, 50, 200);
		panel.add(btnD);
		
		JButton btnE = new JButton("e");
		btnE.setBounds(108, 0, 50, 200);
		panel.add(btnE);
		
		JButton btnF = new JButton("f");
		btnF.setBounds(161, 0, 50, 200);
		panel.add(btnF);
		
		JButton btnG = new JButton("g");
		btnG.setBounds(216, 0, 50, 200);
		panel.add(btnG);
		
		JButton btnA = new JButton("a");
		btnA.setBounds(272, 0, 50, 200);
		panel.add(btnA);
		
		JButton btnB = new JButton("b");
		btnB.setBounds(332, 0, 50, 200);
		panel.add(btnB);
		
	}
}

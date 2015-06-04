package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

import javafx.scene.layout.Border;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToggleButton;

import dataModel.PlaySound;

import javax.swing.event.MenuKeyListener;
import javax.swing.event.MenuKeyEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PianoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PianoMainFrame frame;
	private static AllPanels panels;
	private JTextField txtPianoPanel;
	private JTextField txtRecording;
	private JMenuBar menuBar = new JMenuBar();
	private JMenuItem openItem, saveAsItem, QuitItem;

	// Nickle's variables

	private static PrintWriter pw;
	private static BufferedReader br;
	private static boolean isSaveFile = false;
	private static boolean isRecording = false;
	public static String line;
	public static String Save1 = "";
	public static String Save2 = "";
	public static String Save3 = "";
	public static String Save4 = "";
	private static File file;
	private static JButton btnA;
	private static JButton btnB;
	private static JButton btnC;
	private static JButton btnD;
	private static JButton btnE;
	private static JButton btnF;
	private static JButton btnG;
	private JTextField fileName;
	private static JToggleButton tglbtnSave1;
	private static JToggleButton tglbtnSave2;
	private static JToggleButton tglbtnSave3;
	private static JToggleButton tglbtnSave4;
	private static int selected = 1;
	private static String recording = "";
	private static String[] SoundPaths = new String[] {
			"/Java143/src/SoundFiles/Piano.pp.A2.aiff",
			"/Java143/src/SoundFiles/Piano.pp.B2.aiff",
			"SoundFiles/Piano.pp.C2.aiff", "SoundFiles/Piano.pp.D2.aiff",
			"SoundFiles/Piano.pp.E2.aiff", "SoundFiles/Piano.pp.F2.aiff",
			"SoundFiles/Piano.pp.G2.aiff" };
	private static JRadioButton rdbtnRecording;
	private static JButton btnStart;
	private static JButton btnStop;
	private static JButton btnPlay;

	public PianoPanel(PianoMainFrame mainFrame, AllPanels allPanels)
			throws IOException {
		setLayout(null);

		// adds the PianoMainFrame
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(SystemColor.textHighlight);
		// card layout is very important when adding the panels to the main
		// frame
		setLayout(new CardLayout(0, 0));

		// add all buttons, labels, etc., to this JPanel(container)
		JPanel container = new JPanel();
		container.setBackground(new Color(128, 0, 0));
		add(container, "containerOne");
		container.setLayout(null);

		// Menu Bar

		JToolBar toolBar = new JToolBar();
		toolBar.setEnabled(false);
		toolBar.setFloatable(false);
		toolBar.setRollover(true);
		toolBar.setBackground(new Color(160, 82, 45));
		toolBar.setBounds(0, 0, 800, 34);
		container.add(toolBar);

		JPanel menuPanel = new JPanel();
		menuPanel.setBackground(new Color(143, 188, 143));
		menuPanel.setBounds(0, 34, 800, 45);
		container.add(menuPanel);
		menuPanel.setLayout(null);

		JMenu fileMenu = new JMenu("File");
		fileMenu.setBackground(new Color(128, 0, 0));
		fileMenu.setBounds(0, 5, 50, 45);
		JMenu elementMenu = new JMenu("Elements");
		openItem = fileMenu.add("Open");

		saveAsItem = fileMenu.add("Save As...");
		fileMenu.addSeparator();
		QuitItem = fileMenu.add("Quit");
		ButtonGroup types = new ButtonGroup();
		elementMenu.addSeparator();
		menuBar.setBackground(new Color(245, 222, 179));
		menuBar.add(fileMenu);
		toolBar.add(menuBar);

		// Menu Panel

		btnStart = new JButton("Start");
		btnStart.setBackground(new Color(245, 222, 179));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selected == 0) {
					JOptionPane.showMessageDialog(null,
							"Please select what to record to first.");
				} else {
					btnStart.setEnabled(false);
					btnStop.setEnabled(true);
					btnPlay.setEnabled(false);
					tglbtnSave1.setEnabled(false);
					tglbtnSave2.setEnabled(false);
					tglbtnSave3.setEnabled(false);
					tglbtnSave4.setEnabled(false);
					isRecording = true;
					rdbtnRecording.setSelected(true);
				}
			}
		});
		btnStart.setBounds(200, 0, 89, 23);
		btnStart.setBorderPainted(false);
		menuPanel.add(btnStart);

		JButton btnPause = new JButton("pause");
		btnPause.setBackground(new Color(245, 222, 179));
		btnPause.setBounds(299, 0, 89, 23);
		btnPause.setBorderPainted(false);
		menuPanel.add(btnPause);

		btnStop = new JButton("Stop");
		btnStop.setBackground(new Color(245, 222, 179));
		btnStop.setEnabled(false);
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnStart.setEnabled(true);
				btnStop.setEnabled(false);
				btnPlay.setEnabled(true);
				tglbtnSave1.setEnabled(true);
				tglbtnSave2.setEnabled(true);
				tglbtnSave3.setEnabled(true);
				tglbtnSave4.setEnabled(true);
				if (selected == 1) {
					if (!Save1.equals("")) {
						Object[] options = { "Yes", "No" };
						if (JOptionPane
								.showOptionDialog(
										null,
										"This save already exists, do you wish to ovedide it?",
										"Question", JOptionPane.DEFAULT_OPTION,
										JOptionPane.QUESTION_MESSAGE, null,
										options, options[0]) == 0) {
							Save1 = recording;
						}
					} else {
						Save1 = recording;
					}
				} else if (selected == 2) {
					Save2 = recording;
				} else if (selected == 3) {
					Save3 = recording;
				} else if (selected == 4) {
					Save4 = recording;
				}
				recording = "";
				isRecording = false;
				rdbtnRecording.setSelected(false);
			}
		});
		btnStop.setBounds(398, 0, 89, 23);
		btnStop.setBorderPainted(false);
		menuPanel.add(btnStop);

		btnPlay = new JButton("Play");
		btnPlay.setBackground(new Color(245, 222, 179));
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				if (selected == 1) {
					for (int i = 0; i < Save1.length(); i++) {
						x = Integer.parseInt((String) Save1.subSequence(i,
								i + 1));
						playSound(x);
						wait1();
					}
				} else if (selected == 2) {
					for (int i = 0; i < Save2.length(); i++) {
						x = Integer.parseInt((String) Save2.subSequence(i,
								i + 1));
						playSound(x);
						wait1();
					}
				} else if (selected == 3) {
					for (int i = 0; i < Save3.length(); i++) {
						x = Integer.parseInt((String) Save3.subSequence(i,
								i + 1));
						playSound(x);
						wait1();
					}
				} else if (selected == 4) {
					for (int i = 0; i < Save4.length(); i++) {
						x = Integer.parseInt((String) Save4.subSequence(i,
								i + 1));
						playSound(x);
						wait1();
					}
				}
			}
		});
		btnPlay.setBounds(497, 0, 89, 23);
		btnPlay.setBorderPainted(false);
		menuPanel.add(btnPlay);

		JPanel pianoPanel = new JPanel();
		pianoPanel.setBackground(new Color(255, 235, 205));
		pianoPanel.setBounds(0, 80, 800, 310);
		container.add(pianoPanel);
		pianoPanel.setLayout(null);

		JPanel stylePanelOne = new JPanel();
		stylePanelOne.setBackground(new Color(204, 255, 204));
		stylePanelOne.setBounds(0, 0, 800, 15);
		pianoPanel.add(stylePanelOne);
		stylePanelOne.setLayout(null);

		JPanel stylePanelTwo = new JPanel();
		stylePanelTwo.setLayout(null);
		stylePanelTwo.setBackground(new Color(204, 255, 204));
		stylePanelTwo.setBounds(0, 295, 800, 15);
		pianoPanel.add(stylePanelTwo);

		JPanel PianoPanelTwo = new JPanel();
		PianoPanelTwo.setBounds(85, 26, 595, 258);
		pianoPanel.add(PianoPanelTwo);
		PianoPanelTwo.setLayout(null);

		// black keys

		JPanel blackKey_1 = new JPanel();
		blackKey_1.setBackground(Color.BLACK);
		blackKey_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("B1");
			}
		});
		blackKey_1.setBounds(55, 0, 55, 110);
		PianoPanelTwo.add(blackKey_1);

		JPanel blackKey_2 = new JPanel();
		blackKey_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("B2");
			}
		});
		blackKey_2.setBackground(Color.BLACK);
		blackKey_2.setBounds(137, 0, 58, 110);
		PianoPanelTwo.add(blackKey_2);

		JPanel blackKey_3 = new JPanel();
		blackKey_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("B3");
			}
		});
		blackKey_3.setBackground(Color.BLACK);
		blackKey_3.setBounds(310, 0, 58, 110);
		PianoPanelTwo.add(blackKey_3);

		JPanel blackKey_4 = new JPanel();
		blackKey_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("B4");
			}
		});
		blackKey_4.setBackground(Color.BLACK);
		blackKey_4.setBounds(395, 0, 58, 110);
		PianoPanelTwo.add(blackKey_4);

		JPanel blackKey_5 = new JPanel();
		blackKey_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("B5");
			}
		});
		blackKey_5.setBackground(Color.BLACK);
		blackKey_5.setBounds(480, 0, 58, 110);
		PianoPanelTwo.add(blackKey_5);

		// White keys

		JPanel whiteKey_1 = new JPanel();
		whiteKey_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("0");
				if (isRecording) {
					recording = recording + "0";
				}
				playSound(0);

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// whiteKey_1.setBorder(new LineBorder(new Color(255, 255, 0)));
			}
		});
		whiteKey_1.setBackground(new Color(255, 255, 255));
		whiteKey_1.setBounds(0, 0, 85, 258);
		whiteKey_1.setLayout(null);
		PianoPanelTwo.add(whiteKey_1);

		JPanel whiteKey_2 = new JPanel();
		whiteKey_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("1");
				if (isRecording) {
					recording = recording + "1";
				}
				playSound(0);
			}
		});
		whiteKey_2.setBackground(new Color(255, 255, 255));
		whiteKey_2.setBounds(84, 0, 85, 258);
		PianoPanelTwo.add(whiteKey_2);
		whiteKey_2.setLayout(null);

		JPanel whiteKey_3 = new JPanel();
		whiteKey_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("2");
				if (isRecording) {
					recording = recording + "2";
				}
				playSound(0);
			}
		});
		whiteKey_3.setLayout(null);
		whiteKey_3.setBackground(new Color(255, 255, 255));
		whiteKey_3.setBounds(169, 0, 85, 258);
		PianoPanelTwo.add(whiteKey_3);

		JPanel whiteKey_4 = new JPanel();
		whiteKey_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("3");
				if (isRecording) {
					recording = recording + "3";
				}
				playSound(0);
			}
		});
		whiteKey_4.setLayout(null);
		whiteKey_4.setBackground(new Color(255, 255, 255));
		whiteKey_4.setBounds(254, 0, 85, 258);
		PianoPanelTwo.add(whiteKey_4);

		JPanel whiteKey_5 = new JPanel();
		whiteKey_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("4");
				if (isRecording) {
					recording = recording + "4";
				}
				playSound(0);
			}
		});
		whiteKey_5.setLayout(null);
		whiteKey_5.setBackground(new Color(255, 255, 255));
		whiteKey_5.setBounds(339, 0, 85, 258);
		PianoPanelTwo.add(whiteKey_5);

		JPanel whiteKey_6 = new JPanel();
		whiteKey_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("5");
				if (isRecording) {
					recording = recording + "5";
				}
				playSound(0);
			}
		});
		whiteKey_6.setLayout(null);
		whiteKey_6.setBackground(new Color(255, 255, 255));
		whiteKey_6.setBounds(424, 0, 85, 258);
		PianoPanelTwo.add(whiteKey_6);

		JPanel whiteKey_7 = new JPanel();
		whiteKey_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		whiteKey_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("6");
				if (isRecording) {
					recording = recording + "0";
				}
				playSound(0);
			}
		});
		whiteKey_7.setLayout(null);
		whiteKey_7.setBackground(Color.WHITE);
		whiteKey_7.setBounds(509, 0, 85, 258);
		PianoPanelTwo.add(whiteKey_7);

		// Bottom Panels

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(160, 82, 45));
		bottomPanel.setBounds(0, 390, 800, 50);
		container.add(bottomPanel);
		bottomPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("images/onLight.png"));
		lblNewLabel.setBounds(20, 0, 100, 100);
		bottomPanel.add(lblNewLabel);


		txtRecording = new JTextField();
		txtRecording.setBackground(new Color(245, 222, 179));
		txtRecording.setEditable(false);
		txtRecording.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtRecording.setHorizontalAlignment(SwingConstants.CENTER);
		txtRecording.setText("Recording");
		txtRecording.setBounds(405, 11, 134, 28);
		bottomPanel.add(txtRecording);
		txtRecording.setColumns(10);

	}

	class LeftAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("111");

		}
	}

	public static void saveFile(String fileName) {

		try {
			FileOutputStream fileOut = new FileOutputStream(fileName);
			fileOut.close();

		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	public static void resetToggle() {
		tglbtnSave1.setSelected(false);
		tglbtnSave2.setSelected(false);
		tglbtnSave3.setSelected(false);
		tglbtnSave4.setSelected(false);
	}

	public static void playSound(int x) {
		PlaySound play = new PlaySound(SoundPaths[x]);
		play.start();
	}

	public static void wait1() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
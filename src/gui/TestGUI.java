package gui;

import java.awt.EventQueue;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Font;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.JTextField;
import javax.swing.JToggleButton;

import dataModel.PlaySound;


public class TestGUI {

	private JFrame frame;
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
	private static int selected = 0;
	private static String recording = "";
	private static String[] SoundPaths = new String[] {"Piano.pp.A2.aiff","Piano.pp.B2.aiff","Piano.pp.C2.aiff","Piano.pp.D2.aiff","Piano.pp.E2.aiff","Piano.pp.F2.aiff","Piano.pp.G2.aiff"};
	private static JRadioButton rdbtnRecording;
	private static JButton btnStart;
	private static JButton btnStop;
	private static JButton btnPlay;

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

		JButton btnPlayOld = new JButton("Read Save File");
		btnPlayOld.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(fileName.getText().equals(""))){
					try {
						file = new File(fileName.getText());
						br = new BufferedReader(new FileReader(file));
						while((line = br.readLine()) != null){
							if(!(line.trim().equals(""))){
								if(!(line.trim().substring(0, 1).equals("'"))){
									line = line.trim();
									if(line.indexOf("Save1:")>0){
										Save1 = line.substring(6);
									}else if(line.indexOf("Save2:")>0){
										Save2 = line.substring(6);
									}else if(line.indexOf("Save3:")>0){
										Save3 = line.substring(6);
									}else if(line.indexOf("Save4:")>0){
										Save4 = line.substring(6);
									}else{
									}
								}
							}
						}
						isSaveFile = true;
					} catch (FileNotFoundException noFile) {
						JOptionPane.showMessageDialog(null, "The file could not be found!\nPlease revise your file path.");
					} catch (Exception z) {
						System.out.println("Something went wrong?!");
						System.out.println(z);
					} 
				}else{
					JOptionPane.showMessageDialog(null, "Please enter a file path.");
				}
			}
		});
		btnPlayOld.setBounds(449, 30, 130, 23);
		menuPanel.add(btnPlayOld);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 784, 26);
		menuPanel.add(toolBar);

		JButton btnFile = new JButton("File");
		btnFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnFile);

		fileName = new JTextField();
		fileName.setEditable(false);
		fileName.setBounds(55, 30, 384, 23);
		menuPanel.add(fileName);
		fileName.setColumns(10);

		JLabel lblFile = new JLabel("File:");
		lblFile.setBounds(10, 30, 35, 23);
		menuPanel.add(lblFile);

		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				try {
					JOptionPane.showMessageDialog(null,"Please choose the read file.");
					int userR = jfc.showDialog(null,"Select");
					if(userR != JFileChooser.APPROVE_OPTION){
						return;
					}else{
						fileName.setText(jfc.getSelectedFile()+"");
					}
				}catch (Exception a){
					System.out.println("Exception: "+a);
				}
			}
		});
		button.setBounds(729, 30, 45, 23);
		menuPanel.add(button);

		JButton btnSaveToFile = new JButton("Save To File");
		btnSaveToFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isSaveFile==true||!(fileName.getText().equals(""))){
					Object[] options = { "Yes", "No" };
					if(isSaveFile&&!(fileName.getText().equals(""))){
						options[0] = "File From Read.";
						options[1] = "File in Text Box";
						int s = JOptionPane.showOptionDialog(null, "Which file would you like to wright to?", "Question",
								JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null, options, options[0]);
						if(s==0||s==1){
							try{
								if(s==2) file = new File(fileName.getText());							
								pw = new PrintWriter(file);	
								pw.println("Save1:"+Save1);
								pw.println("Save2:"+Save2);
								pw.println("Save3:"+Save3);
								pw.println("Save4:"+Save4);
							}catch(Exception ex){
								System.out.println("Somthing when wrong. File?");
								System.out.println(ex);
							} finally{
								if (pw != null) {
									pw.close();
								}
							}
						}
					}else if(isSaveFile){
						if(JOptionPane.showOptionDialog(null, "This file allready exists. Would you like to replace it?", "Warning",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0])==0){
							try{
								pw = new PrintWriter(file);
								pw.println("Save1:"+Save1);
								pw.println("Save2:"+Save2);
								pw.println("Save3:"+Save3);
								pw.println("Save4:"+Save4);
							}catch(Exception ex){
								System.out.println("Somthing when wrong. File?");
								System.out.println(ex);
							} finally{
								if (pw != null) {
									pw.close();
								}
							}
						}
					}else if(!(fileName.getText().equals(""))){
						if(JOptionPane.showOptionDialog(null, "This file allready exists. Would you like to replace it?", "Warning",
								JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,null, options, options[0])==0){
							file = new File(fileName.getText());
							try{
								pw = new PrintWriter(file);
								pw.println("Save1:"+Save1);
								pw.println("Save2:"+Save2);
								pw.println("Save3:"+Save3);
								pw.println("Save4:"+Save4);
							}catch(Exception ex){
								System.out.println("Somthing when wrong. File?");
								System.out.println(ex);
							} finally{
								if (pw != null) {
									pw.close();
								}
							}
						}
					}
				}else{
					JOptionPane.showMessageDialog(null, "Please choose a file to read first!");
				}
			}
		});
		btnSaveToFile.setBounds(589, 30, 130, 23);
		menuPanel.add(btnSaveToFile);

		JPanel optionPanel = new JPanel();
		optionPanel.setBackground(SystemColor.activeCaption);
		optionPanel.setBounds(0, 60, 177, 382);
		container.add(optionPanel);
		optionPanel.setLayout(null);

		btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				if(selected == 1){
					for(int i = 0;i<Save1.length();i++){
						x = Integer.parseInt((String)Save1.subSequence(i, i+1));						
						playSound(x);
						wait1();
					}
				}else if(selected == 2){
					for(int i = 0;i<Save2.length();i++){
						x = Integer.parseInt((String)Save2.subSequence(i, i+1));						
						playSound(x);
						wait1();
					}
				}else if(selected == 3){
					for(int i = 0;i<Save3.length();i++){
						x = Integer.parseInt((String)Save3.subSequence(i, i+1));						
						playSound(x);
						wait1();
					}
				}else if(selected == 4){					
					for(int i = 0;i<Save4.length();i++){
						x = Integer.parseInt((String)Save4.subSequence(i, i+1));						
						playSound(x);
						wait1();
					}
				}
			}
		});
		btnPlay.setBounds(10, 24, 89, 23);
		optionPanel.add(btnPlay);

		btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(selected==0){
					JOptionPane.showMessageDialog(null, "Please select what to record to first.");
				}else{
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
		btnStart.setBounds(10, 58, 89, 23);
		optionPanel.add(btnStart);

		btnStop = new JButton("Stop");
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
				if(selected==1){
					if(!Save1.equals("")){
						Object[] options = { "Yes", "No" };
						if(JOptionPane.showOptionDialog(null, "This save already exists, do you wish to ovedide it?", "Question",
								JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0])==0){
							Save1 = recording;}
					}else{
						Save1 = recording;
					}
				}else if(selected==2){
					Save2 = recording;
				}else if(selected==3){
					Save3 = recording;
				}else if(selected==4){
					Save4 = recording;
				}
				recording = "";
				isRecording = false;
				rdbtnRecording.setSelected(false);				
			}
		});
		btnStop.setBounds(10, 91, 89, 23);
		optionPanel.add(btnStop);

		JLabel lblSave = new JLabel("Save:");
		lblSave.setBounds(10, 185, 46, 14);
		optionPanel.add(lblSave);

		tglbtnSave1 = new JToggleButton("Save 1");
		tglbtnSave1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnSave1.isSelected()){
					resetToggle();
					tglbtnSave1.setSelected(true);
					selected = 1;				
				}else{
					tglbtnSave1.setSelected(false);
					selected = 0;
				}
			}
		});
		tglbtnSave1.setBounds(10, 208, 157, 23);
		optionPanel.add(tglbtnSave1);

		tglbtnSave2 = new JToggleButton("Save 2");
		tglbtnSave2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnSave2.isSelected()){
					resetToggle();
					tglbtnSave2.setSelected(true);
					selected = 2;
				}else{
					tglbtnSave2.setSelected(false);
					selected = 0;
				}
			}
		});
		tglbtnSave2.setBounds(10, 237, 157, 23);
		optionPanel.add(tglbtnSave2);

		tglbtnSave3 = new JToggleButton("Save 3");
		tglbtnSave3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnSave3.isSelected()){
					resetToggle();
					tglbtnSave3.setSelected(true);
					selected = 3;
				}else{
					tglbtnSave3.setSelected(false);
					selected = 0;
				}
			}
		});
		tglbtnSave3.setBounds(10, 266, 157, 23);
		optionPanel.add(tglbtnSave3);

		tglbtnSave4 = new JToggleButton("Save 4");
		tglbtnSave4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnSave4.isSelected()){
					resetToggle();
					tglbtnSave4.setSelected(true);
					selected = 4;
				}else{
					tglbtnSave4.setSelected(false);
					selected = 0;
				}
			}
		});
		tglbtnSave4.setBounds(10, 295, 157, 23);
		optionPanel.add(tglbtnSave4);

		JPanel pianoKeysPanel = new JPanel();
		pianoKeysPanel.setBackground(SystemColor.controlHighlight);
		pianoKeysPanel.setBounds(176, 60, 608, 382);
		container.add(pianoKeysPanel);
		pianoKeysPanel.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(60, 101, 514, 200);
		pianoKeysPanel.add(panel);
		panel.setLayout(null);

		btnA = new JButton("a");
		btnA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"0";
				}
				playSound(0);
			}
		});
		btnA.setBounds(298, 0, 50, 200);
		panel.add(btnA);

		btnB = new JButton("b");
		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"1";
				}
				playSound(1);
			}
		});
		btnB.setBounds(358, 0, 50, 200);
		panel.add(btnB);

		btnC = new JButton("c");
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"2";
				}
				playSound(2);
			}
		});
		btnC.setBounds(0, 0, 50, 200);
		panel.add(btnC);

		btnD = new JButton("d");
		btnD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"3";
				}
				playSound(3);
			}
		});
		btnD.setBounds(58, 0, 50, 200);
		panel.add(btnD);

		btnE = new JButton("e");
		btnE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"4";
				}
				playSound(4);
			}
		});
		btnE.setBounds(118, 0, 50, 200);
		panel.add(btnE);

		btnF = new JButton("f");
		btnF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"5";
				}
				playSound(5);
			}
		});
		btnF.setBounds(178, 0, 50, 200);
		panel.add(btnF);

		btnG = new JButton("g");
		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isRecording){
					recording = recording+"6";
				}
				playSound(6);
			}
		});
		btnG.setBounds(238, 0, 50, 200);
		panel.add(btnG);


		rdbtnRecording = new JRadioButton("");
		rdbtnRecording.setEnabled(false);
		rdbtnRecording.setForeground(Color.WHITE);
		rdbtnRecording.setBackground(SystemColor.controlHighlight);
		rdbtnRecording.setBounds(579, 7, 23, 23);
		pianoKeysPanel.add(rdbtnRecording);
		//UIManager.put("RadioButton.focus",Color.RED);

	}
	public static void resetToggle(){
		tglbtnSave1.setSelected(false);
		tglbtnSave2.setSelected(false);
		tglbtnSave3.setSelected(false);
		tglbtnSave4.setSelected(false);
	}
	public static void playSound(int x){
		PlaySound play = new PlaySound(SoundPaths[x]);
		play.start();
	}
	public static void wait1(){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
import java.awt.EventQueue;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JTextField;

public class test {

	static String[] SoundPaths = new String[] {"file1","file2","file3"};
	static JRadioButton rdbtnRecord;
	private JFrame frame;
	private JTextField textField;
	static JButton btnTestButton;
	static JButton btnTestButton_1;
	static JButton btnTestButton_2;
	static JButton btnTestButton_3;
	static JToggleButton tglbtnCustom;
	static JToggleButton tglbtnCustom_1;
	static JToggleButton tglbtnCustom_2;
	static JToggleButton tglbtnCustom_3;
	private JLabel lblSaveTo;
	private JButton btnPlayCurrentRecording;
	static String recording = 0+"";
	private JButton btnStart;
	private JButton btnStop;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
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
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		rdbtnRecord = new JRadioButton("Record");
		rdbtnRecord.setBounds(381, 7, 97, 31);
		frame.getContentPane().add(rdbtnRecord);
		
		JToggleButton tglbtnCustom = new JToggleButton("Custom 1");
		tglbtnCustom.setBounds(357, 64, 121, 23);
		frame.getContentPane().add(tglbtnCustom);
		
		tglbtnCustom_1 = new JToggleButton("Custom 2");
		tglbtnCustom_1.setBounds(357, 98, 121, 23);
		frame.getContentPane().add(tglbtnCustom_1);
		
		JToggleButton tglbtnCustom_2 = new JToggleButton("Custom 3");
		tglbtnCustom_2.setBounds(357, 132, 121, 23);
		frame.getContentPane().add(tglbtnCustom_2);
		
		JToggleButton tglbtnCustom_3 = new JToggleButton("Custom 4");
		tglbtnCustom_3.setBounds(357, 166, 121, 23);
		frame.getContentPane().add(tglbtnCustom_3);
		
		btnTestButton = new JButton("Test button 1");
		btnTestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recording = recording+","+1;
			}
		});
		btnTestButton.setBounds(10, 98, 139, 23);
		frame.getContentPane().add(btnTestButton);
		
		btnTestButton_1 = new JButton("Test button 2");
		btnTestButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recording = recording+","+2;
			}
		});
		btnTestButton_1.setBounds(10, 132, 139, 23);
		frame.getContentPane().add(btnTestButton_1);
		
		btnTestButton_2 = new JButton("Test button 3");
		btnTestButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recording = recording+","+3;
			}
		});
		btnTestButton_2.setBounds(10, 166, 139, 23);
		frame.getContentPane().add(btnTestButton_2);
		
		btnTestButton_3 = new JButton("Test button 4");
		btnTestButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recording = recording+","+4;
			}
		});
		btnTestButton_3.setBounds(10, 197, 139, 23);
		frame.getContentPane().add(btnTestButton_3);
		
		JLabel lblSounds = new JLabel("Sounds");
		lblSounds.setBounds(66, 68, 46, 14);
		frame.getContentPane().add(lblSounds);
		
		JButton btnNewButton = new JButton("Save Recordings");
		btnNewButton.setBounds(331, 429, 147, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(10, 429, 147, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnReadRecordingFile = new JButton("Read Recording File");
		btnReadRecordingFile.setBounds(177, 429, 144, 23);
		frame.getContentPane().add(btnReadRecordingFile);
		
		lblSaveTo = new JLabel("Save to:");
		lblSaveTo.setBounds(357, 43, 71, 14);
		frame.getContentPane().add(lblSaveTo);
		
		btnPlayCurrentRecording = new JButton("Play Current Recording");
		btnPlayCurrentRecording.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(recording);
			}
		});
		btnPlayCurrentRecording.setBounds(149, 11, 183, 23);
		frame.getContentPane().add(btnPlayCurrentRecording);
		
		btnStart = new JButton("Start");
		btnStart.setBounds(357, 259, 89, 23);
		frame.getContentPane().add(btnStart);
		
		btnStop = new JButton("Stop");
		btnStop.setBounds(357, 293, 89, 23);
		frame.getContentPane().add(btnStop);
	}
	public static void saveRecording(int x){
		//playSound(x);
		if(rdbtnRecord.isSelected() == true){
			int CustomNum = 0;
			if(tglbtnCustom.isSelected()==true){
				CustomNum = 1;
			}else if(tglbtnCustom_1.isSelected()==true){
				CustomNum = 2;
			}else if(tglbtnCustom_2.isSelected()==true){
				CustomNum = 3;
			}else if(tglbtnCustom_3.isSelected()==true){
				CustomNum = 4;
			}else{
				
			}
			
			
		}
	}
	public static void playSound(int x){
	String fileName = SoundPaths[x];
		try {
			Clip clip = AudioSystem.getClip();
	        clip.open(AudioSystem.getAudioInputStream(new File(fileName)));
	        clip.start();
	        Thread.sleep(1000);
	        clip.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

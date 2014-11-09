import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
* @author  Feliz Kristianto
* @modifier Chien-Ming Chou
*/
public class tigerConvert extends JFrame {

	private String filename = "untitled";
	private int osenv;
	static JFileChooser chooser;

	private JButton OKButton;
	private JButton cancelButton;
	private JMenu helpMenu;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JMenuBar jMenuBar;
	private JButton openOutput;
	private JButton openTiger;
	private JTextField outputPath;
	private JMenuItem quickHelpButton;
	private JTextField tigerPath;

	public tigerConvert(String sumoPath, int os) {
		osenv = os;
		initComponents(sumoPath,os);
	}

	private void initComponents(String sumoPath, int os) {
		GridBagConstraints gridBagConstraints;
		setTitle("Generate map from TIGER");

		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		tigerPath = new JTextField();
		outputPath = new JTextField();
		openTiger = new JButton();
		openOutput = new JButton();
		OKButton = new JButton();
		cancelButton = new JButton();
		jMenuBar = new JMenuBar();
		helpMenu = new JMenu();
		quickHelpButton = new JMenuItem();

		getContentPane().setLayout(new GridBagLayout());
		
		if(chooser == null) {
			chooser = new JFileChooser("Open File");
		}
		
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setFont(new Font("Tahoma", 1, 12));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("TIGER Map Conversion");
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 4;
		gridBagConstraints.ipadx = 40;
		gridBagConstraints.insets = new Insets(20, 0, 10, 0);
		getContentPane().add(jLabel1, gridBagConstraints);

		jLabel2.setText("TIGER File (*.dat)");
		jLabel2.setPreferredSize(new Dimension(60, 14));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.ipady = 3;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 20, 0, 0);
		getContentPane().add(jLabel2, gridBagConstraints);

		jLabel3.setText("Set Output File");
		jLabel3.setPreferredSize(new Dimension(60, 14));
		jLabel3.setRequestFocusEnabled(false);
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 50;
		gridBagConstraints.ipady = 3;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 20, 0, 0);
		getContentPane().add(jLabel3, gridBagConstraints);

		tigerPath.setPreferredSize(new Dimension(51, 19));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipadx = 150;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(tigerPath, gridBagConstraints);
		
		outputPath.setPreferredSize(new Dimension(51, 19));
		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 150;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 0, 0, 0);
		getContentPane().add(outputPath, gridBagConstraints);

		openTiger.setText("...");
		openTiger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openTigerActionPerformed(evt);
			}
		});

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.ipady = -3;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 0, 0, 10);
		getContentPane().add(openTiger, gridBagConstraints);

		openOutput.setText("...");
		openOutput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				openOutputActionPerformed(evt);
			}
		});

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipady = -3;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(10, 0, 0, 10);
		getContentPane().add(openOutput, gridBagConstraints);
		filename = sumoPath;
		OKButton.setText("OK");
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				OKButtonActionPerformed(evt, filename, osenv);
			}
		});

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.ipadx = 9;
		gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
		gridBagConstraints.insets = new Insets(20, 20, 20, 10);
		getContentPane().add(OKButton, gridBagConstraints);

		cancelButton.setText("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});

		gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
		gridBagConstraints.insets = new Insets(20, 0, 20, 0);
		getContentPane().add(cancelButton, gridBagConstraints);

		helpMenu.setText("Help");
		quickHelpButton.setText("Quick Help");
		quickHelpButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quickHelpButtonActionPerformed(evt);
			}
		});

		helpMenu.add(quickHelpButton);
/*Quick help is disabled for now*/
		//jMenuBar.add(helpMenu);

		setJMenuBar(jMenuBar);

		pack();
		setVisible(true);
	}


	private void quickHelpButtonActionPerformed(ActionEvent evt) {
		JOptionPane.showMessageDialog(this, "Not yet available");
	}

	private void OKButtonActionPerformed(ActionEvent evt, String sumoPath, int envos) {
		tiger t = new tiger(tigerPath.getText(),outputPath.getText());
		t.convertData();
		String cmd;
		construct netcconstruction = new construct(outputPath.getText() + ".netc.cfg",
		outputPath.getText() + ".nod.xml",
		outputPath.getText() + ".edg.xml","",
		outputPath.getText() + ".net.xml",1,"Unknown","2","25","75");
		if (envos == 0){
			//cmd = "cmd /c " + sumoPath + "netconvert -v -c " + outputPath.getText() + ".netc.cfg";
			cmd = "\"" + sumoPath + System.getProperty("file.separator") + "netconvert.exe" + "\""; 
			cmd += " -v -c ";
			cmd += "\"" + outputPath.getText() + ".netc.cfg" + "\""; 
		}
		else {
			cmd = "netconvert -v -c " + outputPath.getText() + ".netc.cfg";
		}

		try {
			Process process = Runtime.getRuntime().exec(cmd);
			java.io.InputStream in = process.getInputStream();
		}
		catch (Exception err) {
			err.printStackTrace();
		}
		this.dispose();
	}

	private void cancelButtonActionPerformed(ActionEvent evt) {
		this.dispose();
	}

	private void openOutputActionPerformed(ActionEvent evt) {
		String extension = "";		
		chooser.setFileFilter( new JaveFileFilter(extension) );
		int returnVal = chooser.showDialog(this,"Create");
		if(returnVal == JFileChooser.APPROVE_OPTION)
		outputPath.setText( chooser.getSelectedFile().getPath() );
	}

	private void openTigerActionPerformed(ActionEvent evt) {
		String extension = ".dat";		
		chooser.setFileFilter( new JaveFileFilter(extension) );
		int returnVal = chooser.showOpenDialog(this);
		if(returnVal == JFileChooser.APPROVE_OPTION)
		tigerPath.setText( chooser.getSelectedFile().getPath() );
	}
}

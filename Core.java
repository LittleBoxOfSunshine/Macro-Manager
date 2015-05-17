import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;

import java.awt.CardLayout;

import javax.swing.JTabbedPane;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

import javax.swing.Action;


public class Core extends JFrame{

	private JTable table = new JTable();
	private Map<String, String> settings;
	private Map<String,String> defaultSettings;
	
	public static void main(String[] args) {
		if(args.length==0){
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Core frame = new Core();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		else{//runs macro identified by runline command (exec macro)
			
		}
		
	}

	public Core() {
		setTitle("Macro Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 483);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnCreate = new JMenu("Create");
		menuBar.add(mnCreate);
		
		JMenuItem mntmAction = new JMenuItem("Action");
		mntmAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create(0);
			}
		});
		mnCreate.add(mntmAction);
		
		JMenuItem mntmMacro = new JMenuItem("Macro");
		mntmMacro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create(2);
			}
		});
		mnCreate.add(mntmMacro);
		
		JMenuItem mntmRobot = new JMenuItem("Robot");
		mntmRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				create(3);
			}
		});
		mnCreate.add(mntmRobot);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		
		JMenuItem mntmAction_1 = new JMenuItem("Action");
		mntmAction_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Action");
			}
		});
		mnEdit.add(mntmAction_1);
		
		JMenuItem mntmMacro_1 = new JMenuItem("Macro");
		mntmMacro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Macro");
			}
		});
		mnEdit.add(mntmMacro_1);
		
		JMenuItem menuItem_8 = new JMenuItem("Robot");
		menuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Edit Macro");
			}
		});
		mnEdit.add(menuItem_8);
		
		JMenu mnClone = new JMenu("Clone");
		mnClone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnClone);
		
		JMenuItem menuItem_1 = new JMenuItem("Action");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnClone.add(menuItem_1);
		
		JMenuItem menuItem = new JMenuItem("Macro");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnClone.add(menuItem);
		
		JMenuItem menuItem_9 = new JMenuItem("Robot");
		menuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnClone.add(menuItem_9);
		
		JMenu mnDelete = new JMenu("Delete");
		mnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnDelete);
		
		JMenuItem menuItem_3 = new JMenuItem("Action");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDelete.add(menuItem_3);
		
		JMenuItem menuItem_2 = new JMenuItem("Macro");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDelete.add(menuItem_2);
		
		JMenuItem menuItem_10 = new JMenuItem("Robot");
		menuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnDelete.add(menuItem_10);
		
		JMenu mnImport = new JMenu("Import");
		mnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnImport);
		
		JMenuItem mntmOnlineFile = new JMenuItem("Online File");
		mntmOnlineFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnImport.add(mntmOnlineFile);
		
		JMenuItem mntmLocalFile = new JMenuItem("Local File");
		mntmLocalFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnImport.add(mntmLocalFile);
		
		JMenu mnExport = new JMenu("Export");
		mnExport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		menuBar.add(mnExport);
		
		JMenuItem menuItem_4 = new JMenuItem("Local File");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JMenuItem menuItem_5 = new JMenuItem("Online File");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnExport.add(menuItem_5);
		mnExport.add(menuItem_4);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmStorageDirectory = new JMenuItem("Active Robots");
		mntmStorageDirectory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnSettings.add(mntmStorageDirectory);
		
		JMenuItem mntmVisibleMacros = new JMenuItem("Visible Macros");
		mntmVisibleMacros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JMenuItem menuItem_6 = new JMenuItem("Storage Directory");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mnSettings.add(menuItem_6);
		mnSettings.add(mntmVisibleMacros);
		
		JMenu mnInfo = new JMenu("Info");
		menuBar.add(mnInfo);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				About g = new About();
				g.setTitle("V1.0");
				g.setSize(200, 150);
				g.pack();
				g.setLocation(750, 300);
				g.setVisible(true);
				g.setResizable(false);
			}
		});
		mnInfo.add(mntmAbout);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mntmHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Help g = new Help();
				g.setTitle("Macro Manager Help");
				g.setSize(450, 450);
				g.pack();
				g.setLocation(750, 300);
				g.setVisible(true);
				g.setResizable(false);
			}
		});
		mnInfo.add(mntmHelp);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		
		renderTable();
	}

	private void renderTable() {
		Object[][] data = {{"test1","tuesday","42"},{"test2","thursday","47"}};
		String[] collumnNames = {"Name","Date","Age"};
		JTable test = new JTable(data, collumnNames);
		GridBagLayout layout = new GridBagLayout();
		JButton button;
		JPanel test2 = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		for(int i=0; i<1; i++)
			for(int p=0; p<3; p++){
		button = new JButton("Button 1");
		c.weightx = 0.5;
		c.gridx = p;
		c.gridy = i;
		test2.add(button, c);

		button = new JButton("Button 2");
		c.gridx = p;
		c.gridy = i;
		test2.add(button, c);

		JLabel buttonZ = new JLabel("Button 3");
		c.gridx = p;
		c.gridy = i;
		test2.add(buttonZ, c);
	}

		///
		JScrollPane container = new JScrollPane(test2);
		getContentPane().add(container);
	}
	
	private void loadSettings(){
		String path = System.getenv("APPDATA")+"\\MacroManager\\manage.conf";
		File f = new File(path);
		if(!f.exists()){//Create Default File
			try {
				File container = new File(System.getenv("APPDATA")+"\\MacroManager");
				if(!container.exists())
					container.mkdir();
				FileWriter fw = new FileWriter(path);
				defaultSettings = getAllDefaults();
				for(String x: defaultSettings.keySet())
					fw.write(x+" = "+defaultSettings.get(x)+";");
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void saveSettings(){
		try{
			FileWriter fw = new FileWriter(settings.get("APPDATA")+"\\MacroManager\\manage.conf");
			for(String x: settings.keySet())
				fw.write(x+" = "+settings.get(x)+";");
			fw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Map<String, String> getAllDefaults(){
		Map<String, String> temp = new HashMap<String, String>();
		temp.put("STORAGE DIRECTORY", System.getenv("APPDATA")+"\\MacroManager");
		temp.put("ACTIVE MACROS", "ALL");
		return temp;
	}
	
	private void create(int type){
		Create g = new Create(type);
		g.setSize(450, 450);
		g.pack();
		g.setLocation(750, 300);
		g.setVisible(true);
		g.setResizable(false);
	}
	
	private void edit(int type){
		Edit g = new Edit(type);
		g.setSize(450, 450);
		g.pack();
		g.setLocation(750, 300);
		g.setVisible(true);
		g.setResizable(false);
	}
	
	private void cloner(int type){
		Clone g = new Clone(type);
		g.setSize(450, 450);
		g.pack();
		g.setLocation(750, 300);
		g.setVisible(true);
		g.setResizable(false);
	}

	private void importer(int type){
		Import g = new Import(type);
		g.setSize(450, 450);
		g.pack();
		g.setLocation(750, 300);
		g.setVisible(true);
		g.setResizable(false);
	}
	
	private void export(int type){
		Export g = new Export(type);
		g.setSize(450, 450);
		g.pack();
		g.setLocation(750, 300);
		g.setVisible(true);
		g.setResizable(false);
	}
	
	private void settings(int type){
		Export g = new Export(type);
		g.setSize(450, 450);
		g.pack();
		g.setLocation(750, 300);
		g.setVisible(true);
		g.setResizable(false);
	}
	
}

class About extends JFrame{
	public About(){
		add(new JLabel("<html><body style='width: 450px; padding-left:5px; padding-bottom:5px;'>"
				+ "Macro Manager is a software utility written, published, and owned by BMCA Tech.<br></br>"
				+ "It is free for use in residential settings.<br></br>"
				+ "At this time it is not avaliable for commercial use<br></br>"
				+ "Visit BMCATech.com to learn more and view our other products.<br></br>"
				+ "Copyright 2014. All Rights Reserved.</br>"));

	}
}

class Help extends JFrame{
	public Help(){
		add(new JLabel("<html><body style='width: 450px; padding-left:5px; padding-bottom:5px;'>"
				+ "<h4>General:</h4>"
				+ "Macro Manager is a one click solution for launching simple and repetitive tasks in a more efficient manner. It also can be used to create robots that will automatically run macros based on the settings you provide. This is intended to provide functionality"
				+ "similar to cron and python scripts without the need for linux or programming."
				+ "<h4>Terms:</h4>"
				+ "<ul>"
				+ "<li>Actions - A step or group of steps that performs some task</li>"
				+ "<li>Macros - A group of actions that can be grouped together and run in a specific order.</li>"
				+ "<li>Exec Macros - A macro that can be launched via a automatically generated batch script (or other equivalent script on non Windows operating systems). These are \"portable\" in the sense that other programs can launch them. Itended to be a crossplatform and crossdevice"
				+ "method of binding macros to keyboard and mice macro keys with their bind program launch to button functionality.</li>"
				+ "<li>Robots - A simple background process that launches a macro when user entered conditions are met.</li>"
				+ "</ul>"
				+ "<h4>Further Help:</h4>"
				+ "For detailed instructions, examples, and other great software visit BMCATech.com!"));
	}
}
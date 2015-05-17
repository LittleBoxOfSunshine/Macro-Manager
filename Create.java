import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Create extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public Create(int type) {
		setMinimumSize(new Dimension(450,300));
		String mod = "";
		if(type==0)
			mod = "Action";
		else if(type==2)
			mod = "Macro";
		else if(type==3)
			mod = "Robot";
		setTitle("Create"+mod);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 114, 130, 20);
		comboBox.addItem("Copy");
		comboBox.addItem("Move");
		comboBox.addItem("Delete");
		comboBox.addItem("Rename");
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(150, 114, 130, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 114, 121, 20);
		contentPane.add(textField_1);
		
		JButton create = new JButton("Create");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String title = textField.getText();
				String src = textField.getText();
				String des = textField.getText();
				String type = comboBox.getSelectedItem().toString();
				System.out.println(type);
				//create action
				if(isValidInput(title, type, src, des))
					JOptionPane.showMessageDialog(null, "Action "+title+" Created!");
			}

			private boolean isValidInput(String title, String type, String src, String des) {
				return true;
			}
		});
		create.setBounds(322, 174, 89, 23);
		contentPane.add(create);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(10, 30, 46, 14);
		contentPane.add(lblTitle);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 55, 220, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblActionType = new JLabel("Action Type");
		lblActionType.setBounds(10, 89, 104, 14);
		contentPane.add(lblActionType);
		
		JLabel lblParameter = new JLabel("Parameter 1");
		lblParameter.setBounds(150, 89, 104, 14);
		contentPane.add(lblParameter);
		
		JLabel lblParameter_1 = new JLabel("Parameter 2");
		lblParameter_1.setBounds(290, 89, 134, 14);
		contentPane.add(lblParameter_1);
		
		JLabel lblParameterIs = new JLabel("Parameter 1 is usually \"source\"");
		lblParameterIs.setBounds(10, 178, 302, 14);
		contentPane.add(lblParameterIs);
		
		JLabel lblParameterIs_1 = new JLabel("Parameter 2 is usually \"destination\"");
		lblParameterIs_1.setBounds(10, 203, 302, 14);
		contentPane.add(lblParameterIs_1);
		
		JLabel lblNoteParameter = new JLabel("NOTE: Parameter 2 is not always applicable (ex. action type delete)");
		lblNoteParameter.setBounds(10, 228, 401, 14);
		contentPane.add(lblNoteParameter);
	}
}

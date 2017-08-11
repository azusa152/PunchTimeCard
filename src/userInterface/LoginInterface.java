package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.Action;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class LoginInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUserId;
	private JTextField txtUser;
	private JTextField txtOfficer;
	private JTextField textFieldOfficerPassword;
	static Calendar cal = Calendar.getInstance( TimeZone.getDefault() );
	private JButton btnManager;
	private JButton btnUser;
	private JTextField txtid;
	private JTextField txtr;
	private static JTextPane textFieldTime;
	private JButton btnEnd;
	private String PasswordOfManager="root";
	private ManageInterface manageInterface;
	private EmployeeInterface userInterface;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginInterface frame = new LoginInterface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
			cal.setTime( new Date() );
			int y=cal.get( Calendar.YEAR );
			int m=cal.get( Calendar.MONTH )+1;
			int d=cal.get( Calendar.DATE );
			int h = cal.get( Calendar.HOUR_OF_DAY );
			int min = cal.get( Calendar.MINUTE );
			int sec = cal.get( Calendar.SECOND );
			String s = ( y+"/"+m+"/"+d+" "+h + ":" + min + ":" + sec);
			textFieldTime.setText(s);
			SwingUtilities.invokeLater(this);
			}
			});
	}

	/**
	 * Create the frame.
	 */
	public LoginInterface() {
		
		
		setTitle("\u6253\u5361\u7CFB\u7D71");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);
		
		txtUser = new JTextField();
		txtUser.setText("員工ID");
		txtUser.setEditable(false);
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.insets = new Insets(0, 0, 5, 5);
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.gridx = 0;
		gbc_txtUser.gridy = 2;
		contentPane.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		textFieldUserId = new JTextField();
		GridBagConstraints gbc_textFieldUserId = new GridBagConstraints();
		gbc_textFieldUserId.weighty = 1.0;
		gbc_textFieldUserId.weightx = 1.0;
		gbc_textFieldUserId.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldUserId.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldUserId.gridx = 1;
		gbc_textFieldUserId.gridy = 2;
		contentPane.add(textFieldUserId, gbc_textFieldUserId);
		textFieldUserId.setColumns(10);
		
		btnUser = new JButton("員工登入");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldUserId.getText().equals(""))
				{
					userInterface=new EmployeeInterface(textFieldUserId.getText());
					userInterface.setVisible(true);
					dispose();
				}
				
			}
		});
		
		txtid = new JTextField();
		txtid.setText("員工輸入ID後登入");
		txtid.setEditable(false);
		GridBagConstraints gbc_txtid = new GridBagConstraints();
		gbc_txtid.weighty = 3.0;
		gbc_txtid.weightx = 1.0;
		gbc_txtid.insets = new Insets(0, 0, 5, 5);
		gbc_txtid.fill = GridBagConstraints.BOTH;
		gbc_txtid.gridx = 0;
		gbc_txtid.gridy = 3;
		contentPane.add(txtid, gbc_txtid);
		txtid.setColumns(10);
		GridBagConstraints gbc_btnUser = new GridBagConstraints();
		gbc_btnUser.weighty = 1.0;
		gbc_btnUser.weightx = 3.0;
		gbc_btnUser.fill = GridBagConstraints.BOTH;
		gbc_btnUser.insets = new Insets(0, 0, 5, 0);
		gbc_btnUser.gridx = 1;
		gbc_btnUser.gridy = 3;
		contentPane.add(btnUser, gbc_btnUser);
		
		txtOfficer = new JTextField();
		txtOfficer.setEditable(false);
		txtOfficer.setText("\u7BA1\u7406\u8005\u5BC6\u78BC");
		GridBagConstraints gbc_txtOfficer = new GridBagConstraints();
		gbc_txtOfficer.weightx = 1.0;
		gbc_txtOfficer.insets = new Insets(0, 0, 5, 5);
		gbc_txtOfficer.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtOfficer.gridx = 0;
		gbc_txtOfficer.gridy = 4;
		contentPane.add(txtOfficer, gbc_txtOfficer);
		txtOfficer.setColumns(10);
		
		textFieldOfficerPassword = new JTextField();
		GridBagConstraints gbc_textFieldOfficerPassword = new GridBagConstraints();
		gbc_textFieldOfficerPassword.weighty = 1.0;
		gbc_textFieldOfficerPassword.weightx = 1.0;
		gbc_textFieldOfficerPassword.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldOfficerPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldOfficerPassword.gridx = 1;
		gbc_textFieldOfficerPassword.gridy = 4;
		contentPane.add(textFieldOfficerPassword, gbc_textFieldOfficerPassword);
		textFieldOfficerPassword.setColumns(10);
		
		btnManager = new JButton("管理者登入");
		btnManager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(verification())
				{
					manageInterface=new ManageInterface();
					manageInterface.setVisible(true);
					dispose();
				}
				else
					System.out.println(textFieldOfficerPassword.getText());
			}
		});
		
		txtr = new JTextField();
		txtr.setText("管理者輸入密碼後登入");
		txtr.setEditable(false);
		GridBagConstraints gbc_txtr = new GridBagConstraints();
		gbc_txtr.weighty = 3.0;
		gbc_txtr.weightx = 1.0;
		gbc_txtr.insets = new Insets(0, 0, 5, 5);
		gbc_txtr.fill = GridBagConstraints.BOTH;
		gbc_txtr.gridx = 0;
		gbc_txtr.gridy = 5;
		contentPane.add(txtr, gbc_txtr);
		txtr.setColumns(10);
		GridBagConstraints gbc_btnManager = new GridBagConstraints();
		gbc_btnManager.weighty = 1.0;
		gbc_btnManager.weightx = 3.0;
		gbc_btnManager.insets = new Insets(0, 0, 5, 0);
		gbc_btnManager.fill = GridBagConstraints.BOTH;
		gbc_btnManager.gridx = 1;
		gbc_btnManager.gridy = 5;
		contentPane.add(btnManager, gbc_btnManager);
		
		textFieldTime = new JTextPane();
		textFieldTime.setBackground(UIManager.getColor("Button.background"));
		GridBagConstraints gbc_textFieldTime = new GridBagConstraints();
		gbc_textFieldTime.gridheight = 3;
		gbc_textFieldTime.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldTime.fill = GridBagConstraints.BOTH;
		gbc_textFieldTime.gridx = 0;
		gbc_textFieldTime.gridy = 6;
		contentPane.add(textFieldTime, gbc_textFieldTime);
		
		btnEnd = new JButton("結束");
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnEnd = new GridBagConstraints();
		gbc_btnEnd.weighty = 2.0;
		gbc_btnEnd.weightx = 3.0;
		gbc_btnEnd.fill = GridBagConstraints.BOTH;
		gbc_btnEnd.gridheight = 3;
		gbc_btnEnd.insets = new Insets(5, 0, 0, 0);
		gbc_btnEnd.gridx = 1;
		gbc_btnEnd.gridy = 6;
		contentPane.add(btnEnd, gbc_btnEnd);
	}
	private boolean verification()
	{
		if(textFieldOfficerPassword.getText().equals(PasswordOfManager))
		    return true;
		else
			return false;
	}


}

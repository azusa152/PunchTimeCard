package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import punchTimeCardSystem.PunchIn;
import punchTimeCardSystem.PunchOut;

import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class EmployeeInterface extends JFrame {

	private JPanel contentPane;
	static Calendar cal = Calendar.getInstance( TimeZone.getDefault() );
	private String currentTime;
	private PunchIn punchIn;
	private PunchOut punchOut;
	private LoginInterface logIn;
	



	/**
	 * Create the frame.
	 */
	public EmployeeInterface(String userId ) {
		setTitle("員工打卡");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textResult = new JTextPane();
		textResult.setEditable(false);
		
		JTextPane textPaneTime = new JTextPane();
		textPaneTime.setBackground(UIManager.getColor("Button.background"));
		SwingUtilities.invokeLater(new Runnable() {
			public void run(){
			cal.setTime( new Date() );
			int y=cal.get( Calendar.YEAR );
			int m=cal.get( Calendar.MONTH )+1;
			int d=cal.get( Calendar.DATE );
			int h = cal.get( Calendar.HOUR_OF_DAY );
			int min = cal.get( Calendar.MINUTE );
			int sec = cal.get( Calendar.SECOND );
			currentTime = ( y+"/"+m+"/"+d+" "+h + ":" + min + ":" + sec);
			textPaneTime.setText(currentTime);
			SwingUtilities.invokeLater(this);
			}
			});
		
        JButton btnPunchIn = new JButton("\u4E0A\u73ED");
        btnPunchIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textResult.setText("上班打卡"+"\r"+"ID:"+userId+"\r"+"於"+currentTime);
				try {
					 punchIn=new PunchIn(userId, currentTime);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
        
        JButton btnPunchOut = new JButton("\u4E0B\u73ED");
        btnPunchOut.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textResult.setText("下班打卡"+"\r"+"ID:"+userId+"\r"+"於"+currentTime);
        		try {
					punchOut=new PunchOut(userId, currentTime);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
		
		JButton btnLogOut = new JButton("\u767B\u51FA");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logIn = new LoginInterface();
				logIn.setVisible(true);
				dispose();
			}
		});
		
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnPunchIn, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnPunchOut, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLogOut, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
						.addComponent(textPaneTime, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
						.addComponent(textResult, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnPunchIn, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
				.addComponent(btnPunchOut, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(textResult, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textPaneTime, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}

}

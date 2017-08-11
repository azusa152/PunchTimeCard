package userInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import punchTimeCardSystem.ManagePunchIn;
import punchTimeCardSystem.ManagePunchOut;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ManageInterface extends JFrame {

	private JPanel contentPane;
	private JButton buttonCheckIn;
	private JButton buttonCheckOut;
	static Calendar cal = Calendar.getInstance( TimeZone.getDefault() );
	private String currentTime;
	private String[] data=new String[10000];
	private JScrollPane scrollPane;
	private LoginInterface logIn;
	private ManagePunchIn managePunchIn;
	private ManagePunchOut managePunchOut;
	private String PunchInLimitTime="09:00:00";
	private String PunchOutLimitTime="18:00:00";
	java.text.DateFormat df=new java.text.SimpleDateFormat("HH:mm:ss");
	java.util.Calendar c1=java.util.Calendar.getInstance();
	java.util.Calendar c2=java.util.Calendar.getInstance();
	
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ManageInterface() {
		setTitle("主管管理");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setBackground(UIManager.getColor("Button.background"));
		
		JButton btnReturnButton = new JButton("\u8FD4\u56DE");
		btnReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logIn = new LoginInterface();
				logIn.setVisible(true);
				dispose();
			}
		});
		JTextPane textResult = new JTextPane();
		buttonCheckIn = new JButton("\u4E0A\u73ED\u8A18\u9304");
		buttonCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textResult.setText("");
				try {
					managePunchIn=new ManagePunchIn();
					data=managePunchIn.getData();
					for(int i=0;i<managePunchIn.getNumberOfData();i++)
					{
						
						if(!textResult.getText().equals(""))
						{
							String temp=textResult.getText();
							String[] tokens = data[i].split(" ");
							c1.setTime(df.parse(tokens[2]));
							c2.setTime(df.parse(PunchInLimitTime));
							int result=c1.compareTo(c2);
							if(result>0)
								{
								textResult.setText(temp+"\r"+data[i]+" 遲到!!");
								}
							else
							{
								textResult.setText(temp+"\r"+data[i]);
							}
							
						}
						else
						{
							String[] tokens = data[i].split(" ");
							c1.setTime(df.parse(tokens[2]));
							c2.setTime(df.parse(PunchInLimitTime));
							int result=c1.compareTo(c2);
							if(result>0)
								{
								textResult.setText(data[i]+" 遲到!!");
								}
							else
							{
								textResult.setText(data[i]);
							}
						}
							
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.err.println("格是錯誤");
				}
				
				
			}
		});
		
		buttonCheckOut = new JButton("\u4E0B\u73ED\u8A18\u9304");
		buttonCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textResult.setText("");
				try {
					managePunchOut=new ManagePunchOut();
					data=managePunchOut.getData();
					for(int i=0;i<managePunchOut.getNumberOfData();i++)
					{
						if(!textResult.getText().equals(""))
						{
							String temp=textResult.getText();
							String[] tokens = data[i].split(" ");
							c1.setTime(df.parse(tokens[2]));
							c2.setTime(df.parse(PunchOutLimitTime));
							int result=c1.compareTo(c2);
							if(result<0)
								{
								textResult.setText(temp+"\r"+data[i]+" 早下班!!");
								}
							else
							{
								textResult.setText(temp+"\r"+data[i]);
							}
							
						}
						else
						{
							String[] tokens = data[i].split(" ");
							c1.setTime(df.parse(tokens[2]));
							c2.setTime(df.parse(PunchOutLimitTime));
							int result=c1.compareTo(c2);
							if(result<0)
								{
								textResult.setText(data[i]+" 早下班!!");
								}
							else
							{
								textResult.setText(data[i]);
							}
						}
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		
		scrollPane = new JScrollPane();
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(buttonCheckIn, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addComponent(buttonCheckOut, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
							.addComponent(btnReturnButton, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(buttonCheckIn, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonCheckOut, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnReturnButton, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(textPane, GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addGap(10))
		);
		
		
		textResult.setEditable(false);
		scrollPane.setViewportView(textResult);
		contentPane.setLayout(gl_contentPane);
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
			textPane.setText(currentTime);
			SwingUtilities.invokeLater(this);
			}
			});
		
	}
}

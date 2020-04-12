/** @author Thomas Grant
 *  @date	3/30/2020
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.SystemColor;

public class LeavittApp {
	
	//Declare the frame and panels
	JFrame frame;
	JPanel navigationPanel;
	JPanel notificationPanel;
	JPanel contentPanel;
	JPanel copyrightsPanel;
	
	//Declare buttons
	static JButton homeButton;
	static JButton adminButton;
	static JButton searchButton;
	static JButton clientButton;
	static JButton accountButton;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public LeavittApp() {
		
		//Set frame and panels
		frame = new JFrame();
		frame.setBounds(0, 0, 1216, 839);
		
		navigationPanel = new JPanel();
		navigationPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		navigationPanel.setBounds(0, 0, 1200, 100);
		navigationPanel.setLayout(null);
		
		notificationPanel = new JPanel();
		notificationPanel.setBackground(SystemColor.info);
		notificationPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		notificationPanel.setBounds(0, 100, 200, 650);
		notificationPanel.setLayout(null);
		
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.setBounds(200, 100, 1000, 650);
		contentPanel.setLayout(null);
		
		copyrightsPanel = new JPanel();
		copyrightsPanel.setBackground(SystemColor.controlDkShadow);
		copyrightsPanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		copyrightsPanel.setBounds(200, 750, 1000, 50);
		copyrightsPanel.setLayout(null);
		
		//Add to navigation panel
		homeButton = new JButton("HOME");
		homeButton.setBackground(SystemColor.activeCaption);
		homeButton.setForeground(SystemColor.text);
		homeButton.setFont(new Font("Verdana", Font.BOLD, 25));
		homeButton.setBounds(0, 0, 240, 100);
		navigationPanel.add(homeButton);
		
		adminButton = new JButton("ADMIN");
		adminButton.setBackground(SystemColor.activeCaption);
		adminButton.setForeground(SystemColor.text);
		adminButton.setFont(new Font("Verdana", Font.BOLD, 25));
		adminButton.setBounds(240, 0, 240, 100);
		navigationPanel.add(adminButton);
		
		searchButton = new JButton("SEARCH");
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setFont(new Font("Verdana", Font.BOLD, 25));
		searchButton.setForeground(SystemColor.text);
		searchButton.setBounds(480, 0, 240, 100);
		navigationPanel.add(searchButton);
		
		clientButton = new JButton("CLIENT");
		clientButton.setForeground(SystemColor.text);
		clientButton.setFont(new Font("Verdana", Font.BOLD, 25));
		clientButton.setBackground(SystemColor.activeCaption);
		clientButton.setBounds(720, 0, 240, 100);
		navigationPanel.add(clientButton);
		
		accountButton = new JButton("ACCOUNT");
		accountButton.setForeground(SystemColor.text);
		accountButton.setFont(new Font("Verdana", Font.BOLD, 25));
		accountButton.setBackground(SystemColor.activeCaption);
		accountButton.setBounds(960, 0, 240, 100);
		navigationPanel.add(accountButton);
		
		//Add to notification panel
		JLabel notif = new JLabel("Notifications");
		notif.setHorizontalAlignment(SwingConstants.CENTER);
		notif.setFont(new Font("Songti TC", Font.BOLD, 22));
		notif.setForeground(new Color(70, 130, 180));
		notif.setBounds(0, 20, 200, 50);
		notificationPanel.add(notif);
		
		//Payments -- unpaid
		JLabel paymentLabel = new JLabel("Unpaid: 0");
		paymentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		paymentLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		paymentLabel.setForeground(new Color(70, 130, 180));
		paymentLabel.setBounds(30, 100, 140, 50);
		paymentLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		notificationPanel.add(paymentLabel);
		
		JButton unpaidButton = new JButton("Details");
		unpaidButton.setFont(new Font("Dubai Medium", Font.ITALIC, 14));
		unpaidButton.setBackground(SystemColor.activeCaption);
		unpaidButton.setBounds(30, 150, 140, 30);
		notificationPanel.add(unpaidButton);
		
		//Contracts -- Soon expired
		JLabel contractLabel = new JLabel("Contract: 0");
		contractLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contractLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		contractLabel.setForeground(new Color(70, 130, 180));
		contractLabel.setBounds(30, 230, 140, 50);
		contractLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		notificationPanel.add(contractLabel);
		
		JButton contractButton = new JButton("Details");
		contractButton.setFont(new Font("Dubai Medium", Font.ITALIC, 14));
		contractButton.setBackground(SystemColor.activeCaption);
		contractButton.setBounds(30, 280, 140, 30);
		notificationPanel.add(contractButton);
		
		//Maintenances -- Status open
		JLabel maintenanceLabel = new JLabel("Maintenance: 0");
		maintenanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maintenanceLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 19));
		maintenanceLabel.setForeground(new Color(70, 130, 180));
		maintenanceLabel.setBounds(30, 360, 140, 50);
		maintenanceLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		notificationPanel.add(maintenanceLabel);
		
		JButton maintenanceButton = new JButton("Details");
		maintenanceButton.setFont(new Font("Dubai Medium", Font.ITALIC, 14));
		maintenanceButton.setBackground(SystemColor.activeCaption);
		maintenanceButton.setBounds(30, 410, 140, 30);
		notificationPanel.add(maintenanceButton);
		
		//Time info
		JLabel timeLabel = new JLabel("Date: "+java.time.LocalDate.now());
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		timeLabel.setFont(new Font("Songti TC", Font.BOLD, 15));
		timeLabel.setForeground(new Color(128, 128, 128));
		timeLabel.setBounds(0, 550, 200, 50);
		notificationPanel.add(timeLabel);
		
		//Add to content panel --> By default, home page
		homePage();
		
		//Add to copyrights panel
		JLabel copyrights = new JLabel("Copyrights");
		copyrights.setBackground(SystemColor.BLACK);
		copyrights.setHorizontalAlignment(SwingConstants.CENTER);
		copyrights.setFont(new Font("Dialog", Font.PLAIN, 12));
		copyrights.setForeground(SystemColor.text);
		copyrights.setBounds(0, 750, 1200, 50);
		copyrightsPanel.add(copyrights);
		
		//Button Calls
		//Nav bar
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage();
				colorCurrentPage(homeButton);
				frame.repaint();
			}
		});
		
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				adminPage();
				colorCurrentPage(adminButton);
				frame.repaint();
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPage();
				colorCurrentPage(searchButton);
				frame.repaint();
			}
		});
		
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientPage();
				colorCurrentPage(clientButton);
				frame.repaint();
			}
		});
		
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPage();
				colorCurrentPage(accountButton);
				frame.repaint();
			}
		});
		
		//Notification bar
		unpaidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unpaidPage();
				colorCurrentPage(homeButton);
				frame.repaint();
			}
		});
		
		contractButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contractPage();
				colorCurrentPage(homeButton);
				frame.repaint();
			}
		});
		
		maintenanceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				maintenancePage();
				colorCurrentPage(homeButton);
				frame.repaint();
			}
		});
		
		
		
		
		//Add the main panel and display the frame
		frame.getContentPane().add(navigationPanel);
		frame.getContentPane().add(notificationPanel);
		frame.getContentPane().add(contentPanel);
		frame.getContentPane().add(copyrightsPanel);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Leavitt 2.0");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);
	}
	
	private void homePage() {
		contentPanel.removeAll();
		
		//Housing content
		int housingX = 40;
		int housingY = 40;
		//Columns
		JLabel housingTabLabel = new JLabel("HOUSING");
		housingTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		housingTabLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		housingTabLabel.setBackground(SystemColor.activeCaption);
		housingTabLabel.setForeground(SystemColor.text);
		housingTabLabel.setForeground(new Color(0, 0, 0));
		housingTabLabel.setBounds(housingX, housingY, 100, 50);
		housingTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housingTabLabel.setOpaque(true);
		
		JLabel availableTabLabel = new JLabel("Available");
		availableTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		availableTabLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		availableTabLabel.setBackground(SystemColor.activeCaption);
		availableTabLabel.setForeground(SystemColor.text);
		availableTabLabel.setForeground(new Color(0, 0, 0));
		availableTabLabel.setBounds(housingX + 100, housingY, 100, 50);
		availableTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		availableTabLabel.setOpaque(true);
		
		JLabel totalTabLabel = new JLabel("Total");
		totalTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalTabLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		totalTabLabel.setBackground(SystemColor.activeCaption);
		totalTabLabel.setForeground(SystemColor.text);
		totalTabLabel.setForeground(new Color(0, 0, 0));
		totalTabLabel.setBounds(housingX + 200, housingY, 100, 50);
		totalTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		totalTabLabel.setOpaque(true);
		
		JLabel rangeTabLabel = new JLabel("$ Range");
		rangeTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rangeTabLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		rangeTabLabel.setBackground(SystemColor.activeCaption);
		rangeTabLabel.setForeground(SystemColor.text);
		rangeTabLabel.setForeground(new Color(0, 0, 0));
		rangeTabLabel.setBounds(housingX + 300, housingY, 100, 50);
		rangeTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rangeTabLabel.setOpaque(true);
		
		JLabel averageTabLabel = new JLabel("$ Average");
		averageTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		averageTabLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		averageTabLabel.setBackground(SystemColor.activeCaption);
		averageTabLabel.setForeground(SystemColor.text);
		averageTabLabel.setForeground(new Color(0, 0, 0));
		averageTabLabel.setBounds(housingX + 400, housingY, 100, 50);
		averageTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		averageTabLabel.setOpaque(true);
		
		//Rows
		JLabel doubleRLabel = new JLabel("Double rooms");
		doubleRLabel.setHorizontalAlignment(SwingConstants.CENTER);
		doubleRLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		doubleRLabel.setBackground(SystemColor.activeCaption);
		doubleRLabel.setForeground(SystemColor.text);
		doubleRLabel.setForeground(new Color(0, 0, 0));
		doubleRLabel.setBounds(housingX, housingY + 50, 100, 100);
		doubleRLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		doubleRLabel.setOpaque(true);
		
		JLabel singleRLabel = new JLabel("Single rooms");
		singleRLabel.setHorizontalAlignment(SwingConstants.CENTER);
		singleRLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		singleRLabel.setBackground(SystemColor.activeCaption);
		singleRLabel.setForeground(SystemColor.text);
		singleRLabel.setForeground(new Color(0, 0, 0));
		singleRLabel.setBounds(housingX, housingY + 150, 100, 100);
		singleRLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		singleRLabel.setOpaque(true);
		
		JLabel apartLabel = new JLabel("Apartments");
		apartLabel.setHorizontalAlignment(SwingConstants.CENTER);
		apartLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		apartLabel.setBackground(SystemColor.activeCaption);
		apartLabel.setForeground(SystemColor.text);
		apartLabel.setForeground(new Color(0, 0, 0));
		apartLabel.setBounds(housingX, housingY + 250, 100, 100);
		apartLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		apartLabel.setOpaque(true);
		
		JLabel houseLabel = new JLabel("Houses");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		houseLabel.setBackground(SystemColor.activeCaption);
		houseLabel.setForeground(SystemColor.text);
		houseLabel.setForeground(new Color(0, 0, 0));
		houseLabel.setBounds(housingX, housingY + 350, 100, 100);
		houseLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		houseLabel.setOpaque(true);
		
		JLabel allLabel = new JLabel("All");
		allLabel.setHorizontalAlignment(SwingConstants.CENTER);
		allLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		allLabel.setBackground(SystemColor.activeCaption);
		allLabel.setForeground(SystemColor.text);
		allLabel.setForeground(new Color(0, 0, 0));
		allLabel.setBounds(housingX, housingY + 450, 100, 100);
		allLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		allLabel.setOpaque(true);
		
		//Data
		//x,y: (1,1)
		//JLabel housing11label = new JLabel(Integer.toString(SqlCon.getCountSingleR()));
		JLabel housing11label = new JLabel("1,1");
		housing11label.setHorizontalAlignment(SwingConstants.CENTER);
		housing11label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing11label.setBackground(SystemColor.info);
		housing11label.setForeground(new Color(70, 130, 180));
		housing11label.setBounds(housingX + 100, housingY + 50, 100, 100);
		housing11label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing11label.setOpaque(true);
		
		//x,y: (2,1)
		JLabel housing21label = new JLabel("2,1");
		housing21label.setHorizontalAlignment(SwingConstants.CENTER);
		housing21label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing21label.setBackground(SystemColor.info);
		housing21label.setForeground(new Color(70, 130, 180));
		housing21label.setBounds(housingX + 100, housingY + 150, 100, 100);
		housing21label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing21label.setOpaque(true);
		
		//x,y: (3,1)
		JLabel housing31label = new JLabel("3,1");
		housing31label.setHorizontalAlignment(SwingConstants.CENTER);
		housing31label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing31label.setBackground(SystemColor.info);
		housing31label.setForeground(new Color(70, 130, 180));
		housing31label.setBounds(housingX + 100, housingY + 250, 100, 100);
		housing31label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing31label.setOpaque(true);
		
		//x,y: (4,1)
		JLabel housing41label = new JLabel("4,1");
		housing41label.setHorizontalAlignment(SwingConstants.CENTER);
		housing41label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing41label.setBackground(SystemColor.info);
		housing41label.setForeground(new Color(70, 130, 180));
		housing41label.setBounds(housingX + 100, housingY + 350, 100, 100);
		housing41label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing41label.setOpaque(true);
		
		//x,y: (5,1)
		JLabel housing51label = new JLabel("5,1");
		housing51label.setHorizontalAlignment(SwingConstants.CENTER);
		housing51label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing51label.setBackground(SystemColor.info);
		housing51label.setForeground(new Color(70, 130, 180));
		housing51label.setBounds(housingX + 100, housingY + 450, 100, 100);
		housing51label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing51label.setOpaque(true);
		
		//x,y: (1,2)
		JLabel housing12label = new JLabel("1,2");
		housing12label.setHorizontalAlignment(SwingConstants.CENTER);
		housing12label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing12label.setBackground(SystemColor.info);
		housing12label.setForeground(new Color(70, 130, 180));
		housing12label.setBounds(housingX + 200, housingY + 50, 100, 100);
		housing12label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing12label.setOpaque(true);
		
		//x,y: (2,2)
		JLabel housing22label = new JLabel("2,2");
		housing22label.setHorizontalAlignment(SwingConstants.CENTER);
		housing22label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing22label.setBackground(SystemColor.info);
		housing22label.setForeground(new Color(70, 130, 180));
		housing22label.setBounds(housingX + 200, housingY + 150, 100, 100);
		housing22label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing22label.setOpaque(true);
		
		//x,y: (3,2)
		JLabel housing32label = new JLabel("3,2");
		housing32label.setHorizontalAlignment(SwingConstants.CENTER);
		housing32label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing32label.setBackground(SystemColor.info);
		housing32label.setForeground(new Color(70, 130, 180));
		housing32label.setBounds(housingX + 200, housingY + 250, 100, 100);
		housing32label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing32label.setOpaque(true);
		
		//x,y: (4,2)
		JLabel housing42label = new JLabel("4,2");
		housing42label.setHorizontalAlignment(SwingConstants.CENTER);
		housing42label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing42label.setBackground(SystemColor.info);
		housing42label.setForeground(new Color(70, 130, 180));
		housing42label.setBounds(housingX + 200, housingY + 350, 100, 100);
		housing42label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing42label.setOpaque(true);
		
		//x,y: (5,2)
		JLabel housing52label = new JLabel("5,2");
		housing52label.setHorizontalAlignment(SwingConstants.CENTER);
		housing52label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing52label.setBackground(SystemColor.info);
		housing52label.setForeground(new Color(70, 130, 180));
		housing52label.setBounds(housingX + 200, housingY + 450, 100, 100);
		housing52label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing52label.setOpaque(true);
		
		//x,y: (1,3)
		JLabel housing13label = new JLabel("1,3");
		housing13label.setHorizontalAlignment(SwingConstants.CENTER);
		housing13label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing13label.setBackground(SystemColor.info);
		housing13label.setForeground(new Color(70, 130, 180));
		housing13label.setBounds(housingX + 300, housingY + 50, 100, 100);
		housing13label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing13label.setOpaque(true);
		
		//x,y: (2,3)
		JLabel housing23label = new JLabel("2,3");
		housing23label.setHorizontalAlignment(SwingConstants.CENTER);
		housing23label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing23label.setBackground(SystemColor.info);
		housing23label.setForeground(new Color(70, 130, 180));
		housing23label.setBounds(housingX + 300, housingY + 150, 100, 100);
		housing23label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing23label.setOpaque(true);
		
		//x,y: (3,3)
		JLabel housing33label = new JLabel("3,3");
		housing33label.setHorizontalAlignment(SwingConstants.CENTER);
		housing33label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing33label.setBackground(SystemColor.info);
		housing33label.setForeground(new Color(70, 130, 180));
		housing33label.setBounds(housingX + 300, housingY + 250, 100, 100);
		housing33label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing33label.setOpaque(true);
		
		//x,y: (4,3)
		JLabel housing43label = new JLabel("4,3");
		housing43label.setHorizontalAlignment(SwingConstants.CENTER);
		housing43label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing43label.setBackground(SystemColor.info);
		housing43label.setForeground(new Color(70, 130, 180));
		housing43label.setBounds(housingX + 300, housingY + 350, 100, 100);
		housing43label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing43label.setOpaque(true);
		
		//x,y: (5,3)
		JLabel housing53label = new JLabel("5,3");
		housing53label.setHorizontalAlignment(SwingConstants.CENTER);
		housing53label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing53label.setBackground(SystemColor.info);
		housing53label.setForeground(new Color(70, 130, 180));
		housing53label.setBounds(housingX + 300, housingY + 450, 100, 100);
		housing53label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing53label.setOpaque(true);
		
		//x,y: (1,4)
		JLabel housing14label = new JLabel("1,4");
		housing14label.setHorizontalAlignment(SwingConstants.CENTER);
		housing14label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing14label.setBackground(SystemColor.info);
		housing14label.setForeground(new Color(70, 130, 180));
		housing14label.setBounds(housingX + 400, housingY + 50, 100, 100);
		housing14label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing14label.setOpaque(true);
		
		//x,y: (2,4)
		JLabel housing24label = new JLabel("2,4");
		housing24label.setHorizontalAlignment(SwingConstants.CENTER);
		housing24label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing24label.setBackground(SystemColor.info);
		housing24label.setForeground(new Color(70, 130, 180));
		housing24label.setBounds(housingX + 400, housingY + 150, 100, 100);
		housing24label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing24label.setOpaque(true);
		
		//x,y: (3,4)
		JLabel housing34label = new JLabel("3,4");
		housing34label.setHorizontalAlignment(SwingConstants.CENTER);
		housing34label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing34label.setBackground(SystemColor.info);
		housing34label.setForeground(new Color(70, 130, 180));
		housing34label.setBounds(housingX + 400, housingY + 250, 100, 100);
		housing34label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing34label.setOpaque(true);
		
		//x,y: (4,4)
		JLabel housing44label = new JLabel("4,4");
		housing44label.setHorizontalAlignment(SwingConstants.CENTER);
		housing44label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing44label.setBackground(SystemColor.info);
		housing44label.setForeground(new Color(70, 130, 180));
		housing44label.setBounds(housingX + 400, housingY + 350, 100, 100);
		housing44label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing44label.setOpaque(true);
		
		//x,y: (5,4)
		JLabel housing54label = new JLabel("5,4");
		housing54label.setHorizontalAlignment(SwingConstants.CENTER);
		housing54label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing54label.setBackground(SystemColor.info);
		housing54label.setForeground(new Color(70, 130, 180));
		housing54label.setBounds(housingX + 400, housingY + 450, 100, 100);
		housing54label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing54label.setOpaque(true);

      	//Add columns to panel
      	contentPanel.add(housingTabLabel);
      	contentPanel.add(availableTabLabel);
      	contentPanel.add(totalTabLabel);
      	contentPanel.add(rangeTabLabel);
      	contentPanel.add(averageTabLabel);
      	//Add rows to panel
      	contentPanel.add(doubleRLabel);
      	contentPanel.add(singleRLabel);
      	contentPanel.add(apartLabel);
      	contentPanel.add(houseLabel);
      	contentPanel.add(allLabel);
      	//Add data to panel
      	contentPanel.add(housing11label);
      	contentPanel.add(housing21label);
      	contentPanel.add(housing31label);
      	contentPanel.add(housing41label);
      	contentPanel.add(housing51label);
      	contentPanel.add(housing12label);
      	contentPanel.add(housing22label);
      	contentPanel.add(housing32label);
      	contentPanel.add(housing42label);
      	contentPanel.add(housing52label);
      	contentPanel.add(housing13label);
      	contentPanel.add(housing23label);
      	contentPanel.add(housing33label);
      	contentPanel.add(housing43label);
      	contentPanel.add(housing53label);
      	contentPanel.add(housing14label);
      	contentPanel.add(housing24label);
      	contentPanel.add(housing34label);
      	contentPanel.add(housing44label);
      	contentPanel.add(housing54label);
      	
      //Customer content
      	int customerX = 600;
      	int customerY = 40;
		//Columns
		JLabel customerTabLabel = new JLabel("CUSTOMER");
		customerTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerTabLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		customerTabLabel.setBackground(SystemColor.activeCaption);
		customerTabLabel.setForeground(SystemColor.text);
		customerTabLabel.setForeground(new Color(0, 0, 0));
		customerTabLabel.setBounds(customerX, customerY, 120, 50);
		customerTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customerTabLabel.setOpaque(true);
		
		JLabel currentTabLabel = new JLabel("Current");
		currentTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		currentTabLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		currentTabLabel.setBackground(SystemColor.activeCaption);
		currentTabLabel.setForeground(SystemColor.text);
		currentTabLabel.setForeground(new Color(0, 0, 0));
		currentTabLabel.setBounds(customerX + 120, customerY, 120, 50);
		currentTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		currentTabLabel.setOpaque(true);
		
		JLabel totalCTabLabel = new JLabel("Total");
		totalCTabLabel.setHorizontalAlignment(SwingConstants.CENTER);
		totalCTabLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		totalCTabLabel.setBackground(SystemColor.activeCaption);
		totalCTabLabel.setForeground(SystemColor.text);
		totalCTabLabel.setForeground(new Color(0, 0, 0));
		totalCTabLabel.setBounds(customerX + 240, customerY, 120, 50);
		totalCTabLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		totalCTabLabel.setOpaque(true);
		
		//Rows
		JLabel gradeRLabel = new JLabel("Grade Range");
		gradeRLabel.setHorizontalAlignment(SwingConstants.CENTER);
		gradeRLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		gradeRLabel.setBackground(SystemColor.activeCaption);
		gradeRLabel.setForeground(SystemColor.text);
		gradeRLabel.setForeground(new Color(0, 0, 0));
		gradeRLabel.setBounds(customerX, customerY + 50, 120, 100);
		gradeRLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		gradeRLabel.setOpaque(true);
		
		JLabel gradeALabel = new JLabel("Grade Average");
		gradeALabel.setHorizontalAlignment(SwingConstants.CENTER);
		gradeALabel.setFont(new Font("Dubai Medium", Font.PLAIN, 16));
		gradeALabel.setBackground(SystemColor.activeCaption);
		gradeALabel.setForeground(SystemColor.text);
		gradeALabel.setForeground(new Color(0, 0, 0));
		gradeALabel.setBounds(customerX, customerY + 150, 120, 100);
		gradeALabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		gradeALabel.setOpaque(true);
		
		//Data
		//x,y: (1,1)
		//JLabel customer11label = new JLabel(Integer.toString(SqlCon.getCountSingleR()));
		JLabel customer11label = new JLabel("1,1");
		customer11label.setHorizontalAlignment(SwingConstants.CENTER);
		customer11label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer11label.setBackground(SystemColor.info);
		customer11label.setForeground(new Color(70, 130, 180));
		customer11label.setBounds(customerX + 120, customerY + 50, 120, 100);
		customer11label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer11label.setOpaque(true);
		
		//x,y: (2,1)
		JLabel customer21label = new JLabel("2,1");
		customer21label.setHorizontalAlignment(SwingConstants.CENTER);
		customer21label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer21label.setBackground(SystemColor.info);
		customer21label.setForeground(new Color(70, 130, 180));
		customer21label.setBounds(customerX + 120, customerY + 150, 120, 100);
		customer21label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer21label.setOpaque(true);
		
		//x,y: (1,2)
		JLabel customer12label = new JLabel("1,2");
		customer12label.setHorizontalAlignment(SwingConstants.CENTER);
		customer12label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer12label.setBackground(SystemColor.info);
		customer12label.setForeground(new Color(70, 130, 180));
		customer12label.setBounds(customerX + 240, customerY + 50, 120, 100);
		customer12label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer12label.setOpaque(true);
		
		//x,y: (2,2)
		JLabel customer22label = new JLabel("2,2");
		customer22label.setHorizontalAlignment(SwingConstants.CENTER);
		customer22label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer22label.setBackground(SystemColor.info);
		customer22label.setForeground(new Color(70, 130, 180));
		customer22label.setBounds(customerX + 240, customerY + 150, 120, 100);
		customer22label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer22label.setOpaque(true);
		
		//Add columns to panel
      	contentPanel.add(customerTabLabel);
      	contentPanel.add(currentTabLabel);
      	contentPanel.add(totalCTabLabel);
      	//Add rows to panel
      	contentPanel.add(gradeRLabel);
      	contentPanel.add(gradeALabel);
      	//Add data to panel
      	contentPanel.add(customer11label);
      	contentPanel.add(customer21label);
      	contentPanel.add(customer12label);
      	contentPanel.add(customer22label);
      	
      //Refresh button
      	JButton refreshButton = new JButton("Refresh");
		refreshButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		refreshButton.setBackground(SystemColor.activeCaption);
		refreshButton.setBounds(600, 520, 360, 70);
		refreshButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(refreshButton);
		
		refreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.repaint();
			}
		});
      	
      	//Powered by Leavitt
      	
      	JLabel poweredByLabel = new JLabel("Powered by");
      	poweredByLabel.setHorizontalAlignment(SwingConstants.CENTER);
      	poweredByLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	poweredByLabel.setBounds(620, 360, 120, 50);
      	contentPanel.add(poweredByLabel);
      	
      	try {
      	JLabel leavittLogo = new JLabel();
      	leavittLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("Leavitt-Group-Logo.png")));
      	leavittLogo.setBounds(620, 260, 380, 390);
      	contentPanel.add(leavittLogo);
      	}
      	catch (Exception e){
      		System.out.println(e);
      	}
      	
	}
	
	private void adminPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel adminLabel = new JLabel("Admin page!");
		adminLabel.setHorizontalAlignment(SwingConstants.CENTER);
		adminLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		adminLabel.setForeground(new Color(0, 0, 0));
		adminLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(adminLabel);
	}
	
	private void searchPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel searchLabel = new JLabel("Search page!");
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		searchLabel.setForeground(new Color(0, 0, 0));
		searchLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(searchLabel);
		}
	
	private void clientPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel clientLabel = new JLabel("Client page!");
		clientLabel.setHorizontalAlignment(SwingConstants.CENTER);
		clientLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		clientLabel.setForeground(new Color(0, 0, 0));
		clientLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(clientLabel);
	}
	
	private void accountPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		//Welcome
		JLabel welcomeLabel = new JLabel("Welcome user,");
		welcomeLabel.setHorizontalAlignment(SwingConstants.LEFT);
		welcomeLabel.setFont(new Font("Dubai Medium", Font.BOLD, 40));
		welcomeLabel.setForeground(SystemColor.activeCaption);
		welcomeLabel.setBounds(40, 20, 500, 80);
		contentPanel.add(welcomeLabel);
		
		//Username
		JLabel usernameLabel = new JLabel("Username: ");
		usernameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		usernameLabel.setBounds(40, 120, 200, 50);
		contentPanel.add(usernameLabel);
		
		JLabel usernameRLabel = new JLabel("admin");
		usernameRLabel.setHorizontalAlignment(SwingConstants.LEFT);
		usernameRLabel.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		usernameRLabel.setForeground(SystemColor.activeCaption);
		usernameRLabel.setBounds(240, 120, 300, 50);
		contentPanel.add(usernameRLabel);
		
		//Date of birth
		JLabel dateBirthLabel = new JLabel("Date of birth: ");
		dateBirthLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateBirthLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		dateBirthLabel.setBounds(40, 170, 200, 50);
		contentPanel.add(dateBirthLabel);
		
		JLabel dateBirthRLabel = new JLabel("08/05/1983");
		dateBirthRLabel.setHorizontalAlignment(SwingConstants.LEFT);
		dateBirthRLabel.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		dateBirthRLabel.setForeground(SystemColor.activeCaption);
		dateBirthRLabel.setBounds(240, 170, 300, 50);
		contentPanel.add(dateBirthRLabel);
		
		//Position
		JLabel positionLabel = new JLabel("Position: ");
		positionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		positionLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		positionLabel.setBounds(40, 220, 200, 50);
		contentPanel.add(positionLabel);
		
		JLabel positionRLabel = new JLabel("Help Desk");
		positionRLabel.setHorizontalAlignment(SwingConstants.LEFT);
		positionRLabel.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		positionRLabel.setForeground(SystemColor.activeCaption);
		positionRLabel.setBounds(240, 220, 300, 50);
		contentPanel.add(positionRLabel);
		
		//Phone
		JLabel phoneLabel = new JLabel("Phone number: ");
		phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		phoneLabel.setBounds(40, 270, 200, 50);
		contentPanel.add(phoneLabel);
		
		JLabel phoneRLabel = new JLabel("435-865-5214");
		phoneRLabel.setHorizontalAlignment(SwingConstants.LEFT);
		phoneRLabel.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		phoneRLabel.setForeground(SystemColor.activeCaption);
		phoneRLabel.setBounds(240, 270, 300, 50);
		contentPanel.add(phoneRLabel);
		
		//Email
		JLabel emailLabel = new JLabel("Email: ");
		emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 25));
		emailLabel.setBounds(40, 320, 200, 50);
		contentPanel.add(emailLabel);
		
		JLabel emailRLabel = new JLabel("admin@leavitt.com");
		emailRLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailRLabel.setFont(new Font("Dubai Medium", Font.BOLD, 35));
		emailRLabel.setForeground(SystemColor.activeCaption);
		emailRLabel.setBounds(240, 320, 300, 50);
		contentPanel.add(emailRLabel);
		
		//Reset password
		JLabel resetPassLabel = new JLabel("Reset password");
		resetPassLabel.setHorizontalAlignment(SwingConstants.LEFT);
		resetPassLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 35));
		resetPassLabel.setBounds(40, 400, 300, 50);
		contentPanel.add(resetPassLabel);
		
		JLabel oldPassLabel = new JLabel("Old password: ");
		oldPassLabel.setHorizontalAlignment(SwingConstants.LEFT);
		oldPassLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		oldPassLabel.setBounds(40, 460, 200, 50);
		contentPanel.add(oldPassLabel);
		
		JPasswordField oldPass = new JPasswordField();
		oldPass.setBounds(250, 475, 150, 25);
		contentPanel.add(oldPass);
		
		JLabel newPassLabel = new JLabel("New password: ");
		newPassLabel.setHorizontalAlignment(SwingConstants.LEFT);
		newPassLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		newPassLabel.setBounds(40, 510, 200, 50);
		contentPanel.add(newPassLabel);
		
		JPasswordField newPass = new JPasswordField();
		newPass.setBounds(250, 525, 150, 25);
		contentPanel.add(newPass);
		
		JLabel newPass2Label = new JLabel("New password: ");
		newPass2Label.setHorizontalAlignment(SwingConstants.LEFT);
		newPass2Label.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		newPass2Label.setBounds(40, 560, 200, 50);
		contentPanel.add(newPass2Label);
		
		JPasswordField newPass2 = new JPasswordField();
		newPass2.setBounds(250, 575, 150, 25);
		contentPanel.add(newPass2);
		
		//Cancel reset pass
      	JButton cancelButton = new JButton("Cancel");
      	cancelButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	cancelButton.setBackground(new Color(128, 128, 128));
      	cancelButton.setForeground(SystemColor.WHITE);
      	cancelButton.setBounds(430, 475, 80, 50);
      	cancelButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(cancelButton);
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldPass.setText("");
				newPass.setText("");
				newPass2.setText("");
				frame.repaint();
			}
		});
		
		//Submit reset pass
      	JButton submitButton = new JButton("Submit");
      	submitButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	submitButton.setBackground(new Color(63, 150, 63));
      	submitButton.setForeground(SystemColor.WHITE);
      	submitButton.setBounds(430, 550, 80, 50);
      	submitButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(submitButton);
		
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Will save the new password for this person
				//Will display flash text "wrong password" or "submitted"
			}
		});
		
		
		//logout
      	JButton logOutButton = new JButton("Log out");
      	logOutButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	logOutButton.setBackground(new Color(153, 0, 0));
      	logOutButton.setForeground(SystemColor.WHITE);
      	logOutButton.setBounds(620, 560, 340, 70);
      	logOutButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(logOutButton);
		
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Image and info
		JTextArea bioText = new JTextArea ("Our clients benefit from competitive,\nsophisticated insurance and risk management\nsolutions. Leavitt Group's team of insurance\nprofessionals consists of individuals with a wide\nrange of experience, many of whom are\nconsidered regional and national leaders in their\nrespective fields.");
		bioText.setFont(new Font("Dubai Medium", Font.BOLD, 14));
		bioText.setBounds(630, 360, 350, 200);
      	contentPanel.add(bioText);
      	
      	try {
  		JLabel leavittPhoto = new JLabel();
  		leavittPhoto.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("Cedar-Leavitt.jpg")).getImage().getScaledInstance(340, 200, Image.SCALE_SMOOTH)));
      	leavittPhoto.setBounds(620, 20, 340, 200);
      	contentPanel.add(leavittPhoto);
          	
      	JLabel leavittLogo = new JLabel();
      	leavittLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("Leavitt-Group-Logo.png")));
      	leavittLogo.setBounds(630, 180, 320, 200);
      	contentPanel.add(leavittLogo);
      	}
      	catch (Exception e){
      		System.out.println(e);
      	}
		
	}
	
	private void unpaidPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel unpaidLabel = new JLabel("Unpaid page!");
		unpaidLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		unpaidLabel.setForeground(new Color(0, 0, 0));
		unpaidLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(unpaidLabel);
	}
	
	private void contractPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel contractLabel = new JLabel("Contract page!");
		contractLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contractLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		contractLabel.setForeground(new Color(0, 0, 0));
		contractLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(contractLabel);
	}
	
	private void maintenancePage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel maintenanceLabel = new JLabel("Maintenance page!");
		maintenanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maintenanceLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		maintenanceLabel.setForeground(new Color(0, 0, 0));
		maintenanceLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(maintenanceLabel);
	}
	
	//Hover effect method for the navigation bar
	public static void colorCurrentPage(JButton button){
		homeButton.setBackground(SystemColor.activeCaption);
		homeButton.setForeground(SystemColor.text);
		adminButton.setBackground(SystemColor.activeCaption);
		adminButton.setForeground(SystemColor.text);
		searchButton.setBackground(SystemColor.activeCaption);
		searchButton.setForeground(SystemColor.text);
		clientButton.setBackground(SystemColor.activeCaption);
		clientButton.setForeground(SystemColor.text);
		accountButton.setBackground(SystemColor.activeCaption);
		accountButton.setForeground(SystemColor.text);
		
		if(button == homeButton) {
			homeButton.setBackground(SystemColor.text);
			homeButton.setForeground(SystemColor.activeCaption);
		}
		else if(button == adminButton) {
			adminButton.setBackground(SystemColor.text);
			adminButton.setForeground(SystemColor.activeCaption);
		}
		else if(button == searchButton) {
			searchButton.setBackground(SystemColor.text);
			searchButton.setForeground(SystemColor.activeCaption);
		}
		else if(button == clientButton) {
			clientButton.setBackground(SystemColor.text);
			clientButton.setForeground(SystemColor.activeCaption);
		}
		else if(button == accountButton) {
			accountButton.setBackground(SystemColor.text);
			accountButton.setForeground(SystemColor.activeCaption);
		}
	}
}
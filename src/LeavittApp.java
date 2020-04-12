/** @author Thomas Grant
 *  @date	3/30/2020
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	static JPanel contentPanel;
	JPanel copyrightsPanel;
	
	//Declare buttons
	//Nav bar
	static JButton homeButton;
	static JButton adminButton;
	static JButton searchButton;
	static JButton clientButton;
	static JButton accountButton;
	//Admin
	static JButton housingAdminButton;
	static JButton housingAddButton;
	static JButton housingModButton;
	static JButton housingDelButton;
	static JButton customerAdminButton;
	static JButton customerAddButton;
	static JButton customerModButton;
	static JButton customerDelButton;
	
	//Add Stuff in admin
	//Search
	static JLabel idLabel;
	static JTextField idText;
	static JButton searchIDButton;
	//Add Housing
	static JLabel housingIDLabel;
	static JTextField housingIDText;
	static JLabel addressLabel;
	static JTextField addressText;
	static JLabel typeLabel;
	static JTextField typeText;
	static JLabel rentPriceLabel;
	static JTextField rentPriceText;
	static JLabel numOfRoomsLabel;
	static JTextField numOfRoomsText;
	static JLabel numOfBathroomsLabel;
	static JTextField numOfBathroomsText;
	static JButton confirmHousingAddButton;
	//Add Customer
	static JLabel customerIDLabel;
	static JTextField customerIDText;
	static JLabel firstNameLabel;
	static JTextField firstNameText;
	static JLabel lastNameLabel;
	static JTextField lastNameText;
	static JLabel dateBirthLabel;
	static JTextField dateBirthText;
	static JLabel gradeLabel;
	static JTextField gradeText;
	static JLabel phoneLabel;
	static JTextField phoneText;
	static JLabel emailLabel;
	static JTextField emailText;
	static JLabel dateRegisteredLabel;
	static JTextField dateRegisteredText;
	static JButton confirmCustomerAddButton;
	
	//Declare variables
	//Admin
	static boolean housingBool = false;
	static boolean housingAdd = false;
	static boolean housingMod = false;
	static boolean housingDel = false;
	
	static boolean customerBool = false;
	static boolean customerAdd = false;
	static boolean customerMod = false;
	static boolean customerDel = false;
	
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
	    //Housing button
      	housingAdminButton = new JButton("HOUSING");
      	housingAdminButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	housingAdminButton.setBackground(SystemColor.activeCaption);
      	housingAdminButton.setForeground(SystemColor.text);
      	housingAdminButton.setBounds(40, 40, 180, 80);
      	housingAdminButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(housingAdminButton);
		
		housingAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetColorAdmin();
				resetValChange();
				housingBool = true;
				housingAdminButton.setBackground(SystemColor.text);
				housingAdminButton.setForeground(SystemColor.activeCaption);
				removeHousingAdd();
				removeCustomerAdd();
				removeSearch();
				contentPanel.revalidate();
				contentPanel.repaint();
				//printValues();
				frame.repaint();
			}
		});
		
	    //Housing Add button
      	housingAddButton = new JButton("Add");
      	housingAddButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	housingAddButton.setBackground(new Color(128,128,128));
      	housingAddButton.setForeground(SystemColor.WHITE);
      	housingAddButton.setBounds(40, 130, 180, 80);
      	housingAddButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(housingAddButton);
		
		housingAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(housingBool) {
					resetColorAdmin();
					resetValChange();
					housingBool = true;
					housingAdminButton.setBackground(SystemColor.text);
					housingAdminButton.setForeground(SystemColor.activeCaption);
					housingAdd = true;
					housingAddButton.setBackground(new Color(63, 150, 63));
					addHousingAdd();
					removeCustomerAdd();
					removeSearch();
					contentPanel.revalidate();
					contentPanel.repaint();
					//printValues();
					frame.repaint();
				}
			}
		});
		
	    //Housing Modify button
      	housingModButton = new JButton("Modify");
      	housingModButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	housingModButton.setBackground(new Color(128,128,128));
      	housingModButton.setForeground(SystemColor.WHITE);
      	housingModButton.setBounds(40, 220, 180, 80);
      	housingModButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(housingModButton);
		
		housingModButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(housingBool) {
					resetColorAdmin();
					resetValChange();
					housingBool = true;
					housingAdminButton.setBackground(SystemColor.text);
					housingAdminButton.setForeground(SystemColor.activeCaption);
					housingMod = true;
					housingModButton.setBackground(new Color(245, 181, 46));
					addSearch();
					removeHousingAdd();
					removeCustomerAdd();
					contentPanel.revalidate();
					contentPanel.repaint();
					//printValues();
					frame.repaint();
				}
			}
		});
		
	    //Housing Delete button
      	housingDelButton = new JButton("Delete");
      	housingDelButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	housingDelButton.setBackground(new Color(128,128,128));
      	housingDelButton.setForeground(SystemColor.WHITE);
      	housingDelButton.setBounds(40, 310, 180, 80);
      	housingDelButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(housingDelButton);
		
		housingDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(housingBool) {
					resetColorAdmin();
					resetValChange();
					housingBool = true;
					housingAdminButton.setBackground(SystemColor.text);
					housingAdminButton.setForeground(SystemColor.activeCaption);
					housingDel = true;
					housingDelButton.setBackground(new Color(153, 0, 0));
					addSearch();
					removeHousingAdd();
					removeCustomerAdd();
					contentPanel.revalidate();
					contentPanel.repaint();
					//printValues();
					frame.repaint();
				}
			}
		});
		
		//Customer button
      	customerAdminButton = new JButton("CUSTOMER");
      	customerAdminButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	customerAdminButton.setBackground(SystemColor.activeCaption);
      	customerAdminButton.setForeground(SystemColor.text);
      	customerAdminButton.setBounds(230, 40, 180, 80);
      	customerAdminButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(customerAdminButton);
		
		customerAdminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetColorAdmin();
				resetValChange();
				customerBool = true;
				customerAdminButton.setBackground(SystemColor.text);
				customerAdminButton.setForeground(SystemColor.activeCaption);
				housingAdminButton.setBackground(SystemColor.activeCaption);
				housingAdminButton.setForeground(SystemColor.text);
				removeCustomerAdd();
				removeHousingAdd();
				removeSearch();
				contentPanel.revalidate();
				contentPanel.repaint();
				//printValues();
				frame.repaint();
			}
		});
		
	    //Customer Add button
      	customerAddButton = new JButton("Add");
      	customerAddButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	customerAddButton.setBackground(new Color(128,128,128));
      	customerAddButton.setForeground(SystemColor.WHITE);
      	customerAddButton.setBounds(230, 130, 180, 80);
      	customerAddButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(customerAddButton);
		
		customerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customerBool) {
					resetColorAdmin();
					resetValChange();
					customerBool = true;
					customerAdminButton.setBackground(SystemColor.text);
					customerAdminButton.setForeground(SystemColor.activeCaption);
					customerAdd = true;
					customerAddButton.setBackground(new Color(63, 150, 63));
					addCustomerAdd();
					removeHousingAdd();
					removeSearch();
					contentPanel.revalidate();
					contentPanel.repaint();
					//printValues();
					frame.repaint();
				}
			}
		});
		
		//Customer Modify button
      	customerModButton = new JButton("Modify");
      	customerModButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	customerModButton.setBackground(new Color(128,128,128));
      	customerModButton.setForeground(SystemColor.WHITE);
      	customerModButton.setBounds(230, 220, 180, 80);
      	customerModButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(customerModButton);
		
		customerModButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customerBool) {
					resetColorAdmin();
					resetValChange();
					customerBool = true;
					customerAdminButton.setBackground(SystemColor.text);
					customerAdminButton.setForeground(SystemColor.activeCaption);
					customerMod = true;
					customerModButton.setBackground(new Color(245, 181, 46));
					addSearch();
					removeHousingAdd();
					removeCustomerAdd();
					contentPanel.revalidate();
					contentPanel.repaint();
					//printValues();
					frame.repaint();
				}
			}
		});
		
		//Customer Delete button
      	customerDelButton = new JButton("Delete");
      	customerDelButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
      	customerDelButton.setBackground(new Color(128,128,128));
      	customerDelButton.setForeground(SystemColor.WHITE);
      	customerDelButton.setBounds(230, 310, 180, 80);
      	customerDelButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(customerDelButton);
		
		customerDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(customerBool) {
					resetColorAdmin();
					resetValChange();
					customerBool = true;
					customerAdminButton.setBackground(SystemColor.text);
					customerAdminButton.setForeground(SystemColor.activeCaption);
					customerDel = true;
					customerDelButton.setBackground(new Color(153, 0, 0));
					addSearch();
					removeHousingAdd();
					removeCustomerAdd();
					contentPanel.revalidate();
					contentPanel.repaint();
					//printValues();
					frame.repaint();
				}
			}
		});
		
		//ID search
		idLabel = new JLabel("ID: ");
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		idLabel.setForeground(new Color(0, 0, 0));
		idLabel.setBounds(40, 450, 50, 60);
		
		
		idText = new JTextField();
		idText.setHorizontalAlignment(SwingConstants.CENTER);
		idText.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		idText.setForeground(SystemColor.BLACK);
		idText.setBounds(100, 450, 310, 60);
		
		searchIDButton = new JButton("Search");
		searchIDButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		searchIDButton.setBackground(new Color(128,128,128));
		searchIDButton.setForeground(SystemColor.WHITE);
		searchIDButton.setBounds(230, 520, 180, 50);
		searchIDButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		searchIDButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(housingBool && housingMod) {
						//displayHousingModifier();
					}
					else if(housingBool && housingDel) {
						//displayHousingDeleter();
					}
					else if(customerBool && customerMod) {
						//displayCustomerModifier();
					}
					else if(customerBool && customerDel) {
						//displayCustomerDeleter();
					}
				}
				catch(Exception e2) {
					// Should output flash message Invalid ID as well
					System.out.println(e2);
				}
				frame.repaint();
			}
		});
		
		//Add Housing
		int housingAddX = 550;
		int housingAddY = 50;
		int housingAddWidth = 250;
		int housingAddHeight = 40;
		
		housingIDLabel = new JLabel("Housing ID: ");
		housingIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		housingIDLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		housingIDLabel.setForeground(new Color(0, 0, 0));
		housingIDLabel.setBounds(housingAddX, housingAddY, 150, 60);
		
		housingIDText = new JTextField();
		housingIDText.setHorizontalAlignment(SwingConstants.CENTER);
		housingIDText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		housingIDText.setForeground(SystemColor.BLACK);
		housingIDText.setBounds(housingAddX + 160, housingAddY + 10, housingAddWidth, housingAddHeight);
		
		addressLabel = new JLabel("Address: ");
		addressLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		addressLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		addressLabel.setForeground(new Color(0, 0, 0));
		addressLabel.setBounds(housingAddX, housingAddY + 70, 150, 60);
		
		addressText = new JTextField();
		addressText.setHorizontalAlignment(SwingConstants.CENTER);
		addressText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		addressText.setForeground(SystemColor.BLACK);
		addressText.setBounds(housingAddX + 160, housingAddY + 80, housingAddWidth, housingAddHeight);
		
		typeLabel = new JLabel("Type: ");
		typeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		typeLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		typeLabel.setForeground(new Color(0, 0, 0));
		typeLabel.setBounds(housingAddX, housingAddY + 140, 150, 60);
		
		typeText = new JTextField();
		typeText.setHorizontalAlignment(SwingConstants.CENTER);
		typeText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		typeText.setForeground(SystemColor.BLACK);
		typeText.setBounds(housingAddX + 160, housingAddY + 150, housingAddWidth, housingAddHeight);
		
		rentPriceLabel = new JLabel("Rent Price: ");
		rentPriceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		rentPriceLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		rentPriceLabel.setForeground(new Color(0, 0, 0));
		rentPriceLabel.setBounds(housingAddX, housingAddY + 210, 150, 60);
		
		rentPriceText = new JTextField();
		rentPriceText.setHorizontalAlignment(SwingConstants.CENTER);
		rentPriceText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		rentPriceText.setForeground(SystemColor.BLACK);
		rentPriceText.setBounds(housingAddX + 160, housingAddY + 220, housingAddWidth, housingAddHeight);
		
		numOfRoomsLabel = new JLabel("Number of Rooms: ");
		numOfRoomsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numOfRoomsLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		numOfRoomsLabel.setForeground(new Color(0, 0, 0));
		numOfRoomsLabel.setBounds(housingAddX-50, housingAddY + 280, 200, 60);
		
		numOfRoomsText = new JTextField();
		numOfRoomsText.setHorizontalAlignment(SwingConstants.CENTER);
		numOfRoomsText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		numOfRoomsText.setForeground(SystemColor.BLACK);
		numOfRoomsText.setBounds(housingAddX + 160, housingAddY + 290, housingAddWidth, housingAddHeight);
		
		numOfBathroomsLabel = new JLabel("Number of Bathrooms: ");
		numOfBathroomsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		numOfBathroomsLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		numOfBathroomsLabel.setForeground(new Color(0, 0, 0));
		numOfBathroomsLabel.setBounds(housingAddX-80, housingAddY + 350, 230, 60);
		
		numOfBathroomsText = new JTextField();
		numOfBathroomsText.setHorizontalAlignment(SwingConstants.CENTER);
		numOfBathroomsText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		numOfBathroomsText.setForeground(SystemColor.BLACK);
		numOfBathroomsText.setBounds(housingAddX + 160, housingAddY + 360, housingAddWidth, housingAddHeight);
		
		confirmHousingAddButton = new JButton("Add");
		confirmHousingAddButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmHousingAddButton.setBackground(new Color(63, 150, 63));
		confirmHousingAddButton.setForeground(SystemColor.WHITE);
		confirmHousingAddButton.setBounds(housingAddX + 160, housingAddY + 435, housingAddWidth, housingAddHeight + 10);
		confirmHousingAddButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmHousingAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				// otherwise, add successful, clear the textfields
				frame.repaint();
			}
		});
		
		
		//Add Customer
		int customerAddX = 550;
		int customerAddY = 50;
		int customerAddWidth = 250;
		int customerAddHeight = 40;

		customerIDLabel = new JLabel("Customer ID: ");
		customerIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		customerIDLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		customerIDLabel.setForeground(new Color(0, 0, 0));
		customerIDLabel.setBounds(customerAddX, customerAddY, 150, 60);
		
		customerIDText = new JTextField();
		customerIDText.setHorizontalAlignment(SwingConstants.CENTER);
		customerIDText.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		customerIDText.setForeground(SystemColor.BLACK);
		customerIDText.setBounds(customerAddX + 160, customerAddY + 10, customerAddWidth, customerAddHeight);
		
		firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		firstNameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		firstNameLabel.setForeground(new Color(0, 0, 0));
		firstNameLabel.setBounds(customerAddX, customerAddY + 70, 150, 60);
		
		firstNameText = new JTextField();
		firstNameText.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameText.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		firstNameText.setForeground(SystemColor.BLACK);
		firstNameText.setBounds(customerAddX + 160, customerAddY + 80, customerAddWidth, customerAddHeight);
		
		lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lastNameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		lastNameLabel.setForeground(new Color(0, 0, 0));
		lastNameLabel.setBounds(customerAddX, customerAddY + 140, 150, 60);
		
		lastNameText = new JTextField();
		lastNameText.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameText.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		lastNameText.setForeground(SystemColor.BLACK);
		lastNameText.setBounds(customerAddX + 160, customerAddY + 150, customerAddWidth, customerAddHeight);
		
		dateBirthLabel = new JLabel("Date of Birth: ");
		dateBirthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateBirthLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		dateBirthLabel.setForeground(new Color(0, 0, 0));
		dateBirthLabel.setBounds(customerAddX, customerAddY + 210, 150, 60);
		
		dateBirthText = new JTextField();
		dateBirthText.setHorizontalAlignment(SwingConstants.CENTER);
		dateBirthText.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		dateBirthText.setForeground(SystemColor.BLACK);
		dateBirthText.setBounds(customerAddX + 160, customerAddY + 220, customerAddWidth, customerAddHeight);
		
		phoneLabel = new JLabel("Phone Number: ");
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		phoneLabel.setForeground(new Color(0, 0, 0));
		phoneLabel.setBounds(customerAddX-50, customerAddY + 280, 200, 60);
		
		phoneText = new JTextField();
		phoneText.setHorizontalAlignment(SwingConstants.CENTER);
		phoneText.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		phoneText.setForeground(SystemColor.BLACK);
		phoneText.setBounds(customerAddX + 160, customerAddY + 290, customerAddWidth, customerAddHeight);
		
		emailLabel = new JLabel("Email: ");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setBounds(customerAddX-80, customerAddY + 350, 230, 60);
		
		emailText = new JTextField();
		emailText.setHorizontalAlignment(SwingConstants.CENTER);
		emailText.setFont(new Font("Dubai Medium", Font.PLAIN, 14));
		emailText.setForeground(SystemColor.BLACK);
		emailText.setBounds(customerAddX + 160, customerAddY + 360, customerAddWidth, customerAddHeight);
		
		confirmCustomerAddButton = new JButton("Add");
		confirmCustomerAddButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmCustomerAddButton.setBackground(new Color(63, 150, 63));
		confirmCustomerAddButton.setForeground(SystemColor.WHITE);
		confirmCustomerAddButton.setBounds(customerAddX + 160, customerAddY + 435, customerAddWidth, customerAddHeight + 10);
		confirmCustomerAddButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmCustomerAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				// otherwise, add successful, clear the textfields
				frame.repaint();
			}
		});

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
	
	//Reset Color Admin
	public static void resetColorAdmin() {
		
      	housingAdminButton.setBackground(SystemColor.activeCaption);
      	housingAdminButton.setForeground(SystemColor.text);
      	customerAdminButton.setBackground(SystemColor.activeCaption);
      	customerAdminButton.setForeground(SystemColor.text);
      	
		housingAddButton.setBackground(new Color(128, 128, 128));
		housingModButton.setBackground(new Color(128, 128, 128));
		housingDelButton.setBackground(new Color(128, 128, 128));
		customerAddButton.setBackground(new Color(128, 128, 128));
		customerModButton.setBackground(new Color(128, 128, 128));
		customerDelButton.setBackground(new Color(128, 128, 128));
	}
	
	//Reset changeValAdmin
	public static void resetValChange() {
		housingBool = false;
		housingAdd = false;
		housingMod = false;
		housingDel = false;
		customerBool = false;
		customerAdd = false;
		customerMod = false;
		customerDel = false;
	}
	
	//Add search feature in Admin
	public static void addSearch() {
		contentPanel.add(idLabel);
		contentPanel.add(idText);
		contentPanel.add(searchIDButton);
	}
	
	//Remove search feature in Admin
	public static void removeSearch() {
		contentPanel.remove(idLabel);
		contentPanel.remove(idText);
		contentPanel.remove(searchIDButton);
	}
	
	//Add add housing feature in Admin
	public static void addHousingAdd() {
		contentPanel.add(housingIDLabel);
		contentPanel.add(housingIDText);
		contentPanel.add(addressLabel);
		contentPanel.add(addressText);
		contentPanel.add(typeLabel);
		contentPanel.add(typeText);
		contentPanel.add(rentPriceLabel);
		contentPanel.add(rentPriceText);
		contentPanel.add(numOfRoomsLabel);
		contentPanel.add(numOfRoomsText);
		contentPanel.add(numOfBathroomsLabel);
		contentPanel.add(numOfBathroomsText);
		contentPanel.add(confirmHousingAddButton);
	}
	
	//Remove add housing feature in Admin
	public static void removeHousingAdd() {
		contentPanel.remove(housingIDLabel);
		contentPanel.remove(housingIDText);
		contentPanel.remove(addressLabel);
		contentPanel.remove(addressText);
		contentPanel.remove(typeLabel);
		contentPanel.remove(typeText);
		contentPanel.remove(rentPriceLabel);
		contentPanel.remove(rentPriceText);
		contentPanel.remove(numOfRoomsLabel);
		contentPanel.remove(numOfRoomsText);
		contentPanel.remove(numOfBathroomsLabel);
		contentPanel.remove(numOfBathroomsText);
		contentPanel.remove(confirmHousingAddButton);
	}
	
	
	//Add add customer feature in Admin
	public static void addCustomerAdd() {
		contentPanel.add(customerIDLabel);
		contentPanel.add(customerIDText);
		contentPanel.add(firstNameLabel);
		contentPanel.add(firstNameText);
		contentPanel.add(lastNameLabel);
		contentPanel.add(lastNameText);
		contentPanel.add(dateBirthLabel);
		contentPanel.add(dateBirthText);
		contentPanel.add(phoneLabel);
		contentPanel.add(phoneText);
		contentPanel.add(emailLabel);
		contentPanel.add(emailText);
		contentPanel.add(confirmCustomerAddButton);
	}
	
	//Remove add customer feature in Admin
	public static void removeCustomerAdd() {
		contentPanel.remove(customerIDLabel);
		contentPanel.remove(customerIDText);
		contentPanel.remove(firstNameLabel);
		contentPanel.remove(firstNameText);
		contentPanel.remove(lastNameLabel);
		contentPanel.remove(lastNameText);
		contentPanel.remove(dateBirthLabel);
		contentPanel.remove(dateBirthText);
		contentPanel.remove(phoneLabel);
		contentPanel.remove(phoneText);
		contentPanel.remove(emailLabel);
		contentPanel.remove(emailText);
		contentPanel.remove(confirmCustomerAddButton);
	}
	

	//displayHousingModifier() method
	public static void displayHousingModifier(int housingID) {
		
	}

	//displayHousingDeleter() method
	public static void displayHousingDeleter(int housingID) {
		
	}
	
	//displayCustomerModifier() method
	public static void displayCustomerModifier(int customerID) {
		
	}
	
	//displayCustomerDeleter() method
	public static void displayCustomerDeleter(int customerID) {
		
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
	
	//Test print value
	public static void printValues() {
		System.out.println("Housing Bool -> "+housingBool);
		System.out.println("Housing Add -> "+housingAdd);
		System.out.println("Housing Mod -> "+housingMod);
		System.out.println("Housing Del -> "+housingDel);
		System.out.println();
		System.out.println("Customer Bool -> "+customerBool);
		System.out.println("Customer Add -> "+customerAdd);
		System.out.println("Customer Mod -> "+customerMod);
		System.out.println("Customer Del -> "+customerDel);
		System.out.println();
		System.out.println();
	}
}
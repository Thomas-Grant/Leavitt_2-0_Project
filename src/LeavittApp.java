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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

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
	static JLabel vacantLabel;
	static JTextField vacantText;
	static JButton confirmHousingAddButton;
	static JButton confirmHousingModButton;
	static JButton confirmHousingDelButton;
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
	static JButton confirmCustomerModButton;
	static JButton confirmCustomerDelButton;
	
	//Search
	static JButton goButton;
	static CreateTable table;
	
	//Client
	static JButton goClientButton;
	static JLabel customerIDInfoText;
	static JLabel firstNameInfoText;
	static JLabel lastNameInfoText;
	static JLabel dateBirthInfoText;
	static JLabel phoneInfoText;
	static JLabel emailInfoText;
	static JLabel customerSinceLabel;
	static JLabel customerSinceInfoText;
	static JLabel complaintsCountLabel;
	static JLabel complaintsCountInfoText;
	static JLabel unpaidCountLabel;
	static JLabel unpaidCountInfoText;
	static JLabel customerGradeLabel;
	static JLabel customerGradeInfoText;
	static JTextField customerIDVal;
	static JLabel customerIDFindLabel;
	
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
	
	//Faded text
	private static JLabel denied; // Acount page
	private static JLabel failure; // Admin page
	private static JLabel notFound; // Client Page
	private static JLabel invalidInput; //Search Page
	private static int alpha = 255;
	private static int increment = -5;
	
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
		JLabel paymentLabel = new JLabel("Unpaid: "+SqlCon.getCountUnpaidRent());
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
		JLabel contractLabel = new JLabel("Contract: "+SqlCon.getCountExpiringSoon());
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
		JLabel maintenanceLabel = new JLabel("Maintenance: "+SqlCon.getCountOnGoingMaintenance());
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
		JLabel copyrights = new JLabel("Copyrights \u0040 SUU Students 2019-2020");
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
		JLabel housing11label = new JLabel(Integer.toString(SqlCon.getCountAvailaibleDoubleHousing()));
		housing11label.setHorizontalAlignment(SwingConstants.CENTER);
		housing11label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing11label.setBackground(SystemColor.info);
		housing11label.setForeground(new Color(70, 130, 180));
		housing11label.setBounds(housingX + 100, housingY + 50, 100, 100);
		housing11label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing11label.setOpaque(true);
		
		//x,y: (2,1)
		JLabel housing21label = new JLabel(Integer.toString(SqlCon.getCountAvailaibleSingleHousing()));
		housing21label.setHorizontalAlignment(SwingConstants.CENTER);
		housing21label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing21label.setBackground(SystemColor.info);
		housing21label.setForeground(new Color(70, 130, 180));
		housing21label.setBounds(housingX + 100, housingY + 150, 100, 100);
		housing21label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing21label.setOpaque(true);
		
		//x,y: (3,1)
		JLabel housing31label = new JLabel(Integer.toString(SqlCon.getCountAvailaibleApartmentHousing()));
		housing31label.setHorizontalAlignment(SwingConstants.CENTER);
		housing31label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing31label.setBackground(SystemColor.info);
		housing31label.setForeground(new Color(70, 130, 180));
		housing31label.setBounds(housingX + 100, housingY + 250, 100, 100);
		housing31label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing31label.setOpaque(true);
		
		//x,y: (4,1)
		JLabel housing41label = new JLabel(Integer.toString(SqlCon.getCountAvailaibleHouseHousing()));
		housing41label.setHorizontalAlignment(SwingConstants.CENTER);
		housing41label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing41label.setBackground(SystemColor.info);
		housing41label.setForeground(new Color(70, 130, 180));
		housing41label.setBounds(housingX + 100, housingY + 350, 100, 100);
		housing41label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing41label.setOpaque(true);
		
		//x,y: (5,1)
		JLabel housing51label = new JLabel(Integer.toString(SqlCon.getCountAvailaibleHousing()));
		housing51label.setHorizontalAlignment(SwingConstants.CENTER);
		housing51label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing51label.setBackground(SystemColor.info);
		housing51label.setForeground(new Color(70, 130, 180));
		housing51label.setBounds(housingX + 100, housingY + 450, 100, 100);
		housing51label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing51label.setOpaque(true);
		
		//x,y: (1,2)
		JLabel housing12label = new JLabel(Integer.toString(SqlCon.getCountAllDoubleHousing()));
		housing12label.setHorizontalAlignment(SwingConstants.CENTER);
		housing12label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing12label.setBackground(SystemColor.info);
		housing12label.setForeground(new Color(70, 130, 180));
		housing12label.setBounds(housingX + 200, housingY + 50, 100, 100);
		housing12label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing12label.setOpaque(true);
		
		//x,y: (2,2)
		JLabel housing22label = new JLabel(Integer.toString(SqlCon.getCountAllSingleHousing()));
		housing22label.setHorizontalAlignment(SwingConstants.CENTER);
		housing22label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing22label.setBackground(SystemColor.info);
		housing22label.setForeground(new Color(70, 130, 180));
		housing22label.setBounds(housingX + 200, housingY + 150, 100, 100);
		housing22label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing22label.setOpaque(true);
		
		//x,y: (3,2)
		JLabel housing32label = new JLabel(Integer.toString(SqlCon.getCountAllApartmentHousing()));
		housing32label.setHorizontalAlignment(SwingConstants.CENTER);
		housing32label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing32label.setBackground(SystemColor.info);
		housing32label.setForeground(new Color(70, 130, 180));
		housing32label.setBounds(housingX + 200, housingY + 250, 100, 100);
		housing32label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing32label.setOpaque(true);
		
		//x,y: (4,2)
		JLabel housing42label = new JLabel(Integer.toString(SqlCon.getCountAllHouseHousing()));
		housing42label.setHorizontalAlignment(SwingConstants.CENTER);
		housing42label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing42label.setBackground(SystemColor.info);
		housing42label.setForeground(new Color(70, 130, 180));
		housing42label.setBounds(housingX + 200, housingY + 350, 100, 100);
		housing42label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing42label.setOpaque(true);
		
		//x,y: (5,2)
		JLabel housing52label = new JLabel(Integer.toString(SqlCon.getCountAllHousing()));
		housing52label.setHorizontalAlignment(SwingConstants.CENTER);
		housing52label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing52label.setBackground(SystemColor.info);
		housing52label.setForeground(new Color(70, 130, 180));
		housing52label.setBounds(housingX + 200, housingY + 450, 100, 100);
		housing52label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing52label.setOpaque(true);
		
		//x,y: (1,3)
		JLabel housing13label = new JLabel(Integer.toString((int)SqlCon.getRangeDoubleHousing()[0]));
		housing13label.setHorizontalAlignment(SwingConstants.CENTER);
		housing13label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing13label.setBackground(SystemColor.info);
		housing13label.setForeground(new Color(70, 130, 180));
		housing13label.setBounds(housingX + 300, housingY + 50, 100, 50);
		housing13label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing13label.setOpaque(true);
		
		//x,y: (1,3-2)
		JLabel housing132label = new JLabel(Integer.toString((int)SqlCon.getRangeDoubleHousing()[1]));
		housing132label.setHorizontalAlignment(SwingConstants.CENTER);
		housing132label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing132label.setBackground(SystemColor.info);
		housing132label.setForeground(new Color(70, 130, 180));
		housing132label.setBounds(housingX + 300, housingY + 100, 100, 50);
		housing132label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing132label.setOpaque(true);
		
		
		//x,y: (2,3)
		JLabel housing23label = new JLabel(Integer.toString((int)SqlCon.getRangeSingleHousing()[0]));
		housing23label.setHorizontalAlignment(SwingConstants.CENTER);
		housing23label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing23label.setBackground(SystemColor.info);
		housing23label.setForeground(new Color(70, 130, 180));
		housing23label.setBounds(housingX + 300, housingY + 150, 100, 50);
		housing23label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing23label.setOpaque(true);
		
		//x,y: (2,3-2)
		JLabel housing232label = new JLabel(Integer.toString((int)SqlCon.getRangeSingleHousing()[1]));
		housing232label.setHorizontalAlignment(SwingConstants.CENTER);
		housing232label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing232label.setBackground(SystemColor.info);
		housing232label.setForeground(new Color(70, 130, 180));
		housing232label.setBounds(housingX + 300, housingY + 200, 100, 50);
		housing232label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing232label.setOpaque(true);
		
		//x,y: (3,3)
		JLabel housing33label = new JLabel(Integer.toString((int)SqlCon.getRangeApartmentHousing()[0]));
		housing33label.setHorizontalAlignment(SwingConstants.CENTER);
		housing33label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing33label.setBackground(SystemColor.info);
		housing33label.setForeground(new Color(70, 130, 180));
		housing33label.setBounds(housingX + 300, housingY + 250, 100, 50);
		housing33label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing33label.setOpaque(true);
		
		//x,y: (3,3-2)
		JLabel housing332label = new JLabel(Integer.toString((int)SqlCon.getRangeApartmentHousing()[1]));
		housing332label.setHorizontalAlignment(SwingConstants.CENTER);
		housing332label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing332label.setBackground(SystemColor.info);
		housing332label.setForeground(new Color(70, 130, 180));
		housing332label.setBounds(housingX + 300, housingY + 300, 100, 50);
		housing332label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing332label.setOpaque(true);
		
		//x,y: (4,3)
		JLabel housing43label = new JLabel(Integer.toString((int)SqlCon.getRangeHouseHousing()[0]));
		housing43label.setHorizontalAlignment(SwingConstants.CENTER);
		housing43label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing43label.setBackground(SystemColor.info);
		housing43label.setForeground(new Color(70, 130, 180));
		housing43label.setBounds(housingX + 300, housingY + 350, 100, 50);
		housing43label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing43label.setOpaque(true);
		
		//x,y: (4,3-2)
		JLabel housing432label = new JLabel(Integer.toString((int)SqlCon.getRangeHouseHousing()[1]));
		housing432label.setHorizontalAlignment(SwingConstants.CENTER);
		housing432label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing432label.setBackground(SystemColor.info);
		housing432label.setForeground(new Color(70, 130, 180));
		housing432label.setBounds(housingX + 300, housingY + 400, 100, 50);
		housing432label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing432label.setOpaque(true);
		
		//x,y: (5,3)
		JLabel housing53label = new JLabel(Integer.toString((int)SqlCon.getRangeHousing()[0]));
		housing53label.setHorizontalAlignment(SwingConstants.CENTER);
		housing53label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing53label.setBackground(SystemColor.info);
		housing53label.setForeground(new Color(70, 130, 180));
		housing53label.setBounds(housingX + 300, housingY + 450, 100, 50);
		housing53label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing53label.setOpaque(true);
		
		//x,y: (5,3-2)
		JLabel housing532label = new JLabel(Integer.toString((int)SqlCon.getRangeHousing()[1]));
		housing532label.setHorizontalAlignment(SwingConstants.CENTER);
		housing532label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing532label.setBackground(SystemColor.info);
		housing532label.setForeground(new Color(70, 130, 180));
		housing532label.setBounds(housingX + 300, housingY + 500, 100, 50);
		housing532label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing532label.setOpaque(true);
		
		//x,y: (1,4)
		JLabel housing14label = new JLabel(Double.toString(SqlCon.getAverageDoubleHousing()));
		housing14label.setHorizontalAlignment(SwingConstants.CENTER);
		housing14label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing14label.setBackground(SystemColor.info);
		housing14label.setForeground(new Color(70, 130, 180));
		housing14label.setBounds(housingX + 400, housingY + 50, 100, 100);
		housing14label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing14label.setOpaque(true);
		
		//x,y: (2,4)
		JLabel housing24label = new JLabel(Double.toString(SqlCon.getAverageSingleHousing()));
		housing24label.setHorizontalAlignment(SwingConstants.CENTER);
		housing24label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing24label.setBackground(SystemColor.info);
		housing24label.setForeground(new Color(70, 130, 180));
		housing24label.setBounds(housingX + 400, housingY + 150, 100, 100);
		housing24label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing24label.setOpaque(true);
		
		//x,y: (3,4)
		JLabel housing34label = new JLabel(Double.toString(SqlCon.getAverageApartmentHousing()));
		housing34label.setHorizontalAlignment(SwingConstants.CENTER);
		housing34label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing34label.setBackground(SystemColor.info);
		housing34label.setForeground(new Color(70, 130, 180));
		housing34label.setBounds(housingX + 400, housingY + 250, 100, 100);
		housing34label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing34label.setOpaque(true);
		
		//x,y: (4,4)
		JLabel housing44label = new JLabel(Double.toString(SqlCon.getAverageHouseHousing()));
		housing44label.setHorizontalAlignment(SwingConstants.CENTER);
		housing44label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		housing44label.setBackground(SystemColor.info);
		housing44label.setForeground(new Color(70, 130, 180));
		housing44label.setBounds(housingX + 400, housingY + 350, 100, 100);
		housing44label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		housing44label.setOpaque(true);
		
		//x,y: (5,4)
		JLabel housing54label = new JLabel(Double.toString(SqlCon.getAverageHousing()));
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
      	contentPanel.add(housing132label);
      	contentPanel.add(housing23label);
      	contentPanel.add(housing232label);
      	contentPanel.add(housing33label);
      	contentPanel.add(housing332label);
      	contentPanel.add(housing43label);
      	contentPanel.add(housing432label);
      	contentPanel.add(housing53label);
      	contentPanel.add(housing532label);
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
		JLabel gradeRLabel = new JLabel("Counter");
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
		JLabel customer11label = new JLabel(Integer.toString(SqlCon.getCountCurrentCustomer()));
		customer11label.setHorizontalAlignment(SwingConstants.CENTER);
		customer11label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer11label.setBackground(SystemColor.info);
		customer11label.setForeground(new Color(70, 130, 180));
		customer11label.setBounds(customerX + 120, customerY + 50, 120, 100);
		customer11label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer11label.setOpaque(true);

		
		//x,y: (2,1)
		JLabel customer21label = new JLabel(Double.toString(SqlCon.getAverageGradeCurrentCustomer()));
		customer21label.setHorizontalAlignment(SwingConstants.CENTER);
		customer21label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer21label.setBackground(SystemColor.info);
		customer21label.setForeground(new Color(70, 130, 180));
		customer21label.setBounds(customerX + 120, customerY + 150, 120, 100);
		customer21label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer21label.setOpaque(true);
		
		//x,y: (1,2)
		JLabel customer12label = new JLabel(Integer.toString(SqlCon.getCountAllCustomer()));
		customer12label.setHorizontalAlignment(SwingConstants.CENTER);
		customer12label.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		customer12label.setBackground(SystemColor.info);
		customer12label.setForeground(new Color(70, 130, 180));
		customer12label.setBounds(customerX + 240, customerY + 50, 120, 100);
		customer12label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customer12label.setOpaque(true);
		
		//x,y: (2,2)
		JLabel customer22label = new JLabel(Double.toString(SqlCon.getAverageGradeAllCustomer()));
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
				homePage();
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
				removeStuff();
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
					removeStuff();
					addHousingAdd();
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
					removeStuff();
					addSearch();
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
					removeStuff();
					addSearch();
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
				removeStuff();
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
					removeStuff();
					addCustomerAdd();
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
					removeStuff();
					addSearch();
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
					removeStuff();
					addSearch();
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
						removeStuff();
						addSearch();
						displayHousingModifier(idText.getText());
						contentPanel.revalidate();
						contentPanel.repaint();
					}
					else if(housingBool && housingDel) {
						removeStuff();
						addSearch();
						displayHousingDeleter(idText.getText());
						contentPanel.revalidate();
						contentPanel.repaint();
					}
					else if(customerBool && customerMod) {
						removeStuff();
						addSearch();
						displayCustomerModifier(idText.getText());
						contentPanel.revalidate();
						contentPanel.repaint();
					}
					else if(customerBool && customerDel) {
						removeStuff();
						addSearch();
						displayCustomerDeleter(idText.getText());
						contentPanel.revalidate();
						contentPanel.repaint();
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
		
		vacantLabel = new JLabel("Vacant: ");
		vacantLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		vacantLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		vacantLabel.setForeground(new Color(0, 0, 0));
		vacantLabel.setBounds(housingAddX, housingAddY + 420, 150, 60);
		
		vacantText = new JTextField();
		vacantText.setHorizontalAlignment(SwingConstants.CENTER);
		vacantText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		vacantText.setForeground(SystemColor.BLACK);
		vacantText.setBounds(housingAddX + 160, housingAddY + 430, housingAddWidth, housingAddHeight);
		
		failure = new JLabel("");
		failure.setBounds(housingAddX + 170, housingAddY + 560, housingAddWidth, housingAddHeight);
		failure.setForeground(new Color(255,0,0));
		contentPanel.add(failure);
		
		confirmHousingAddButton = new JButton("Add");
		confirmHousingAddButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmHousingAddButton.setBackground(new Color(63, 150, 63));
		confirmHousingAddButton.setForeground(SystemColor.WHITE);
		confirmHousingAddButton.setBounds(housingAddX + 160, housingAddY + 505, housingAddWidth, housingAddHeight + 10);
		confirmHousingAddButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmHousingAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				if (SqlCon.createHousing(housingIDText.getText(), addressText.getText(), typeText.getText(), rentPriceText.getText(), numOfRoomsText.getText(), numOfBathroomsText.getText())) {
					addHousingAdd();
					frame.repaint();
				}
				else {
					failure.setText("Failure");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	failure.setText("");
					        }
					        failure.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
				}	
			}
		});
		
		confirmHousingModButton = new JButton("Modify");
		confirmHousingModButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmHousingModButton.setBackground(new Color(245, 181, 46));
		confirmHousingModButton.setForeground(SystemColor.WHITE);
		confirmHousingModButton.setBounds(housingAddX + 160, housingAddY + 505, housingAddWidth, housingAddHeight + 10);
		confirmHousingModButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmHousingModButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				if (SqlCon.updateHousing(idText.getText(), housingIDText.getText(), addressText.getText(), typeText.getText(), rentPriceText.getText(), numOfRoomsText.getText(), numOfBathroomsText.getText(), vacantText.getText())) {
					clearHousingModifier();
					frame.repaint();
				}
				else {
					failure.setText("Failure");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	failure.setText("");
					        }
					        failure.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
				}
			}
		});
		
		confirmHousingDelButton = new JButton("Delete");
		confirmHousingDelButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmHousingDelButton.setBackground(new Color(153, 0, 0));
		confirmHousingDelButton.setForeground(SystemColor.WHITE);
		confirmHousingDelButton.setBounds(housingAddX + 160, housingAddY + 505, housingAddWidth, housingAddHeight + 10);
		confirmHousingDelButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmHousingDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				if (SqlCon.deleteHousing(idText.getText())) {
					clearHousingDeleter();
					frame.repaint();
				}
				else {
					failure.setText("Failure");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	failure.setText("");
					        }
					        failure.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
				}
			}
		});
		
		//Add Customer
		int customerAddX = 550;
		int customerAddY = 50;
		int customerAddWidth = 250;
		int customerAddHeight = 40;

		customerIDLabel = new JLabel("Customer ID: ");
		customerIDLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		customerIDLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		customerIDLabel.setForeground(new Color(0, 0, 0));
		customerIDLabel.setBounds(customerAddX, customerAddY, 150, 60);
		
		customerIDText = new JTextField();
		customerIDText.setHorizontalAlignment(SwingConstants.CENTER);
		customerIDText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		customerIDText.setForeground(SystemColor.BLACK);
		customerIDText.setBounds(customerAddX + 160, customerAddY + 10, customerAddWidth, customerAddHeight);
		
		firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		firstNameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		firstNameLabel.setForeground(new Color(0, 0, 0));
		firstNameLabel.setBounds(customerAddX, customerAddY + 70, 150, 60);
		
		firstNameText = new JTextField();
		firstNameText.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		firstNameText.setForeground(SystemColor.BLACK);
		firstNameText.setBounds(customerAddX + 160, customerAddY + 80, customerAddWidth, customerAddHeight);
		
		lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lastNameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		lastNameLabel.setForeground(new Color(0, 0, 0));
		lastNameLabel.setBounds(customerAddX, customerAddY + 140, 150, 60);
		
		lastNameText = new JTextField();
		lastNameText.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		lastNameText.setForeground(SystemColor.BLACK);
		lastNameText.setBounds(customerAddX + 160, customerAddY + 150, customerAddWidth, customerAddHeight);
		
		dateBirthLabel = new JLabel("Date of Birth: ");
		dateBirthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		dateBirthLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		dateBirthLabel.setForeground(new Color(0, 0, 0));
		dateBirthLabel.setBounds(customerAddX, customerAddY + 210, 150, 60);
		
		dateBirthText = new JTextField();
		dateBirthText.setHorizontalAlignment(SwingConstants.CENTER);
		dateBirthText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		dateBirthText.setForeground(SystemColor.BLACK);
		dateBirthText.setBounds(customerAddX + 160, customerAddY + 220, customerAddWidth, customerAddHeight);
		
		phoneLabel = new JLabel("Phone Number: ");
		phoneLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		phoneLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		phoneLabel.setForeground(new Color(0, 0, 0));
		phoneLabel.setBounds(customerAddX-50, customerAddY + 280, 200, 60);
		
		phoneText = new JTextField();
		phoneText.setHorizontalAlignment(SwingConstants.CENTER);
		phoneText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		phoneText.setForeground(SystemColor.BLACK);
		phoneText.setBounds(customerAddX + 160, customerAddY + 290, customerAddWidth, customerAddHeight);
		
		emailLabel = new JLabel("Email: ");
		emailLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emailLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		emailLabel.setForeground(new Color(0, 0, 0));
		emailLabel.setBounds(customerAddX-80, customerAddY + 350, 230, 60);
		
		emailText = new JTextField();
		emailText.setHorizontalAlignment(SwingConstants.CENTER);
		emailText.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
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
				if (SqlCon.createCustomer(customerIDText.getText(), firstNameText.getText(), lastNameText.getText(), dateBirthText.getText(), phoneText.getText(), emailText.getText())) {
					addCustomerAdd();
					frame.repaint();
				}
				else {
					failure.setText("Failure");
					failure.setBounds(customerAddX + 170, customerAddY + 505, customerAddWidth, customerAddHeight + 10);
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	failure.setText("");
					        }
					        failure.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
					failure.setBounds(customerAddX + 170, customerAddY + 560, customerAddWidth, customerAddHeight + 10);
				}	
			}
		});
		
		confirmCustomerModButton = new JButton("Modify");
		confirmCustomerModButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmCustomerModButton.setBackground(new Color(245, 181, 46));
		confirmCustomerModButton.setForeground(SystemColor.WHITE);
		confirmCustomerModButton.setBounds(customerAddX + 160, customerAddY + 435, customerAddWidth, customerAddHeight + 10);
		confirmCustomerModButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmCustomerModButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				if (SqlCon.updateCustomer(idText.getText(), customerIDText.getText(), firstNameText.getText(), lastNameText.getText(), dateBirthText.getText(), phoneText.getText(), emailText.getText())) {
					clearCustomerModifier();
					frame.repaint();
				}
				else {
					failure.setText("Failure");
					failure.setBounds(customerAddX + 170, customerAddY + 505, customerAddWidth, customerAddHeight + 10);
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	failure.setText("");
					        }
					        failure.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
					failure.setBounds(customerAddX + 170, customerAddY + 560, customerAddWidth, customerAddHeight + 10);
				}
			}
		});
		
		confirmCustomerDelButton = new JButton("Delete");
		confirmCustomerDelButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		confirmCustomerDelButton.setBackground(new Color(153, 0, 0));
		confirmCustomerDelButton.setForeground(SystemColor.WHITE);
		confirmCustomerDelButton.setBounds(customerAddX + 160, customerAddY + 435, customerAddWidth, customerAddHeight + 10);
		confirmCustomerDelButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		confirmCustomerDelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				if (SqlCon.deleteCustomer(idText.getText())) {
					clearCustomerDeleter();
					frame.repaint();
				}
				else {
					failure.setText("Failure");
					failure.setBounds(customerAddX + 170, customerAddY + 505, customerAddWidth, customerAddHeight + 10);
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	failure.setText("");
					        }
					        failure.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
					failure.setBounds(customerAddX + 170, customerAddY + 560, customerAddWidth, customerAddHeight + 10);
				}
			}
		});

	}
	
	private void searchPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel numberAvailableLabel = new JLabel("Available Housings");
		numberAvailableLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numberAvailableLabel.setFont(new Font("Dubai Medium", Font.BOLD, 18));
		numberAvailableLabel.setBackground(SystemColor.activeCaption);
		numberAvailableLabel.setForeground(SystemColor.WHITE);
		numberAvailableLabel.setBounds(20, 10, 160, 50);
		numberAvailableLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		numberAvailableLabel.setOpaque(true);
      	contentPanel.add(numberAvailableLabel);
		
		JLabel numberAvailableVal = new JLabel(Integer.toString(SqlCon.getCountAvailaibleHousing()));
		numberAvailableVal.setHorizontalAlignment(SwingConstants.CENTER);
		numberAvailableVal.setFont(new Font("Dubai Medium", Font.BOLD, 24));
		numberAvailableVal.setBackground(SystemColor.info);
		numberAvailableVal.setForeground(new Color(70, 130, 180));
		numberAvailableVal.setBounds(20, 60, 160, 50);
		numberAvailableVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		numberAvailableVal.setOpaque(true);
		contentPanel.add(numberAvailableVal);
		
		JLabel filerLabel = new JLabel("FILTER");
		filerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		filerLabel.setFont(new Font("Dubai Medium", Font.BOLD, 12));
		filerLabel.setBackground(SystemColor.activeCaption);
		filerLabel.setForeground(SystemColor.WHITE);
		filerLabel.setBounds(200, 10, 720, 15);
		filerLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		filerLabel.setOpaque(true);
		contentPanel.add(filerLabel);
		
		JLabel cityLabel = new JLabel("CITY");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		cityLabel.setBackground(SystemColor.activeCaption);
		cityLabel.setForeground(SystemColor.WHITE);
		cityLabel.setBounds(200, 25, 144, 30);
		cityLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		cityLabel.setOpaque(true);
		contentPanel.add(cityLabel);
		
		JTextField cityVal = new JTextField();
		cityVal.setHorizontalAlignment(SwingConstants.CENTER);
		cityVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		cityVal.setBackground(SystemColor.WHITE);
		cityVal.setForeground(new Color(70, 130, 180));
		cityVal.setBounds(200, 55, 144, 55);
		cityVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		cityVal.setOpaque(true);
		contentPanel.add(cityVal);
		
		JLabel rentPriceLabel = new JLabel("RENT PRICE");
		rentPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		rentPriceLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		rentPriceLabel.setBackground(SystemColor.activeCaption);
		rentPriceLabel.setForeground(SystemColor.WHITE);
		rentPriceLabel.setBounds(344, 25, 144, 30);
		rentPriceLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rentPriceLabel.setOpaque(true);
		contentPanel.add(rentPriceLabel);
		
		JTextField rentPriceMinVal = new JTextField();
		rentPriceMinVal.setHorizontalAlignment(SwingConstants.CENTER);
		rentPriceMinVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		rentPriceMinVal.setBackground(SystemColor.WHITE);
		rentPriceMinVal.setForeground(new Color(70, 130, 180));
		rentPriceMinVal.setBounds(344, 55, 72, 55);
		rentPriceMinVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rentPriceMinVal.setOpaque(true);
		contentPanel.add(rentPriceMinVal);
		
		JTextField rentPriceMaxVal = new JTextField();
		rentPriceMaxVal.setHorizontalAlignment(SwingConstants.CENTER);
		rentPriceMaxVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		rentPriceMaxVal.setBackground(SystemColor.WHITE);
		rentPriceMaxVal.setForeground(new Color(70, 130, 180));
		rentPriceMaxVal.setBounds(416, 55, 72, 55);
		rentPriceMaxVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		rentPriceMaxVal.setOpaque(true);
		contentPanel.add(rentPriceMaxVal);
		
		JLabel typeLabel = new JLabel("TYPE");
		typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		typeLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		typeLabel.setBackground(SystemColor.activeCaption);
		typeLabel.setForeground(SystemColor.WHITE);
		typeLabel.setBounds(488, 25, 144, 30);
		typeLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		typeLabel.setOpaque(true);
		contentPanel.add(typeLabel);
		
		JTextField typeVal = new JTextField();
		typeVal.setHorizontalAlignment(SwingConstants.CENTER);
		typeVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		typeVal.setBackground(SystemColor.WHITE);
		typeVal.setForeground(new Color(70, 130, 180));
		typeVal.setBounds(488, 55, 144, 55);
		typeVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		typeVal.setOpaque(true);
		contentPanel.add(typeVal);
		
		JLabel numRoomsLabel = new JLabel("NUM ROOMS");
		numRoomsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numRoomsLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		numRoomsLabel.setBackground(SystemColor.activeCaption);
		numRoomsLabel.setForeground(SystemColor.WHITE);
		numRoomsLabel.setBounds(632, 25, 144, 30);
		numRoomsLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		numRoomsLabel.setOpaque(true);
		contentPanel.add(numRoomsLabel);
		
		JTextField numRoomsVal = new JTextField();
		numRoomsVal.setHorizontalAlignment(SwingConstants.CENTER);
		numRoomsVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		numRoomsVal.setBackground(SystemColor.WHITE);
		numRoomsVal.setForeground(new Color(70, 130, 180));
		numRoomsVal.setBounds(632, 55, 144, 55);
		numRoomsVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		numRoomsVal.setOpaque(true);
		contentPanel.add(numRoomsVal);
		
		JLabel numBathroomsLabel = new JLabel("NUM BATHROOMS");
		numBathroomsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numBathroomsLabel.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		numBathroomsLabel.setBackground(SystemColor.activeCaption);
		numBathroomsLabel.setForeground(SystemColor.WHITE);
		numBathroomsLabel.setBounds(776, 25, 144, 30);
		numBathroomsLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		numBathroomsLabel.setOpaque(true);
		contentPanel.add(numBathroomsLabel);
		
		JTextField numBathroomsVal = new JTextField();
		numBathroomsVal.setHorizontalAlignment(SwingConstants.CENTER);
		numBathroomsVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		numBathroomsVal.setBackground(SystemColor.WHITE);
		numBathroomsVal.setForeground(new Color(70, 130, 180));
		numBathroomsVal.setBounds(776, 55, 144, 55);
		numBathroomsVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		numBathroomsVal.setOpaque(true);
		contentPanel.add(numBathroomsVal);
		
		invalidInput = new JLabel("");
		invalidInput.setBounds(910, 115, 80, 30);
		invalidInput.setForeground(new Color(255,0,0));
		contentPanel.add(invalidInput);
		
		String [] columnNames = {"Housing ID", "Address", "Housing Type", "Rent Price", "Num of Rooms", "Num of Bathrooms"};
		String [][] data = SqlCon.searchList(cityVal.getText(), rentPriceMinVal.getText(), rentPriceMaxVal.getText(), typeVal.getText(), numRoomsVal.getText(), numBathroomsVal.getText());
		table = new CreateTable(data, columnNames);
		table.setBounds(30, 150, 940, 450);
		table.setVisible(true);
		contentPanel.add(table);

		goButton = new JButton("GO");
		goButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		goButton.setBackground(SystemColor.activeCaption);
		goButton.setForeground(SystemColor.WHITE);
		goButton.setBounds(930, 10, 50, 100);
		goButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(goButton);
		
		
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				// otherwise, add successful, clear the textfields

				String [] columnNames = {"Housing ID", "Address", "Housing Type", "Rent Price", "Num of Rooms", "Num of Bathrooms"};
				String [][] data = SqlCon.searchList(cityVal.getText(), rentPriceMinVal.getText(), rentPriceMaxVal.getText(), typeVal.getText(), numRoomsVal.getText(), numBathroomsVal.getText());

				if(data.length != 0) {
					
					invalidInput.setText(" ");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	invalidInput.setText("");
					        }
					        invalidInput.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
					
					contentPanel.remove(table);
					table = new CreateTable(data, columnNames);
					table.setBounds(30, 150, 940, 450);
					table.setVisible(true);
					contentPanel.add(table);
				}
				else {
					invalidInput.setText("invalid input");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	invalidInput.setText("");
					        }
					        invalidInput.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;

					contentPanel.remove(table);
					
					String [][] data2 = SqlCon.searchList("","","","","","");
					table = new CreateTable(data2, columnNames);
					table.setBounds(30, 150, 940, 450);
					table.setVisible(true);
					contentPanel.add(table);
				}

				frame.repaint();
			}		
		});
		
	}
	
	
	private void clientPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		customerIDFindLabel = new JLabel("Customer ID: ");
		customerIDFindLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerIDFindLabel.setFont(new Font("Dubai Medium", Font.BOLD, 20));
		customerIDFindLabel.setBackground(SystemColor.activeCaption);
		customerIDFindLabel.setForeground(SystemColor.WHITE);
		customerIDFindLabel.setBounds(30, 30, 300, 80);
		customerIDFindLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customerIDFindLabel.setOpaque(true);
		contentPanel.add(customerIDFindLabel);
		
		customerIDVal = new JTextField("");
		customerIDVal.setHorizontalAlignment(SwingConstants.CENTER);
		customerIDVal.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		customerIDVal.setBackground(SystemColor.WHITE);
		customerIDVal.setForeground(new Color(70, 130, 180));
		customerIDVal.setBounds(340, 30, 520, 80);
		customerIDVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		customerIDVal.setOpaque(true);
		contentPanel.add(customerIDVal);
		
		int customerAddX = 30;
		int customerAddY = 130;
		int customerAddWidth = 250;
		int customerAddHeight = 40;
		
		firstNameLabel = new JLabel("First Name: ");
		firstNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		firstNameLabel.setForeground(new Color(70, 130, 180));
		firstNameLabel.setBounds(customerAddX, customerAddY, 150, customerAddHeight);
		firstNameLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		firstNameInfoText = new JLabel("");
		firstNameInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		firstNameInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		firstNameInfoText.setBackground(SystemColor.activeCaption);
		firstNameInfoText.setForeground(SystemColor.WHITE);
		firstNameInfoText.setBounds(customerAddX + 150, customerAddY, customerAddWidth, customerAddHeight);
		firstNameInfoText.setOpaque(true);
		firstNameInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		lastNameLabel = new JLabel("Last Name: ");
		lastNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		lastNameLabel.setForeground(new Color(70, 130, 180));
		lastNameLabel.setBounds(customerAddX, customerAddY + 70, 150, customerAddHeight);
		lastNameLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		lastNameInfoText = new JLabel("");
		lastNameInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		lastNameInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		lastNameInfoText.setBackground(SystemColor.activeCaption);
		lastNameInfoText.setForeground(SystemColor.WHITE);
		lastNameInfoText.setBounds(customerAddX + 150, customerAddY + 70, customerAddWidth, customerAddHeight);
		lastNameInfoText.setOpaque(true);
		lastNameInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		dateBirthLabel = new JLabel("Date of Birth: ");
		dateBirthLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dateBirthLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		dateBirthLabel.setForeground(new Color(70, 130, 180));
		dateBirthLabel.setBounds(customerAddX, customerAddY + 140, 150, customerAddHeight);
		dateBirthLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		dateBirthInfoText = new JLabel("");
		dateBirthInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		dateBirthInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		dateBirthInfoText.setBackground(SystemColor.activeCaption);
		dateBirthInfoText.setForeground(SystemColor.WHITE);
		dateBirthInfoText.setBounds(customerAddX + 150, customerAddY + 140, customerAddWidth, customerAddHeight);
		dateBirthInfoText.setOpaque(true);
		dateBirthInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		phoneLabel = new JLabel("Phone Number: ");
		phoneLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phoneLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		phoneLabel.setForeground(new Color(70, 130, 180));
		phoneLabel.setBounds(customerAddX, customerAddY + 210, 150, customerAddHeight);
		phoneLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		phoneInfoText = new JLabel("");
		phoneInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		phoneInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		phoneInfoText.setBackground(SystemColor.activeCaption);
		phoneInfoText.setForeground(SystemColor.WHITE);
		phoneInfoText.setBounds(customerAddX + 150, customerAddY + 210, customerAddWidth, customerAddHeight);
		phoneInfoText.setOpaque(true);
		phoneInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		emailLabel = new JLabel("Email: ");
		emailLabel.setHorizontalAlignment(SwingConstants.CENTER);
		emailLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		emailLabel.setForeground(new Color(70, 130, 180));
		emailLabel.setBounds(customerAddX, customerAddY + 280, 150, customerAddHeight);
		emailLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		emailInfoText = new JLabel("");
		emailInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		emailInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		emailInfoText.setBackground(SystemColor.activeCaption);
		emailInfoText.setForeground(SystemColor.WHITE);
		emailInfoText.setBounds(customerAddX + 150, customerAddY + 280, customerAddWidth, customerAddHeight);
		emailInfoText.setOpaque(true);
		emailInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		customerSinceLabel = new JLabel("Customer since");
		customerSinceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerSinceLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		customerSinceLabel.setForeground(new Color(70, 130, 180));
		customerSinceLabel.setBounds(customerAddX + 500, customerAddY, 330, customerAddHeight);
		customerSinceLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		customerSinceInfoText = new JLabel("");
		customerSinceInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		customerSinceInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		customerSinceInfoText.setBackground(SystemColor.activeCaption);
		customerSinceInfoText.setForeground(SystemColor.WHITE);
		customerSinceInfoText.setBounds(customerAddX + 500, customerAddY+customerAddHeight, 330, customerAddHeight+10);
		customerSinceInfoText.setOpaque(true);
		customerSinceInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		complaintsCountLabel = new JLabel("Complaints");
		complaintsCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		complaintsCountLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		complaintsCountLabel.setForeground(new Color(70, 130, 180));
		complaintsCountLabel.setBounds(customerAddX + 500, customerAddY + 110, 330, customerAddHeight);
		complaintsCountLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		complaintsCountInfoText = new JLabel("");
		complaintsCountInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		complaintsCountInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		complaintsCountInfoText.setBackground(SystemColor.activeCaption);
		complaintsCountInfoText.setForeground(SystemColor.WHITE);
		complaintsCountInfoText.setBounds(customerAddX + 500, customerAddY+110+customerAddHeight, 330, customerAddHeight+10);
		complaintsCountInfoText.setOpaque(true);
		complaintsCountInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		unpaidCountLabel = new JLabel("Unpaids");
		unpaidCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidCountLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		unpaidCountLabel.setForeground(new Color(70, 130, 180));
		unpaidCountLabel.setBounds(customerAddX + 500, customerAddY + 220, 330, customerAddHeight);
		unpaidCountLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		unpaidCountInfoText = new JLabel("");
		unpaidCountInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidCountInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 16));
		unpaidCountInfoText.setBackground(SystemColor.activeCaption);
		unpaidCountInfoText.setForeground(SystemColor.WHITE);
		unpaidCountInfoText.setBounds(customerAddX + 500, customerAddY+220+customerAddHeight, 330, customerAddHeight+10);
		unpaidCountInfoText.setOpaque(true);
		unpaidCountInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		customerGradeLabel = new JLabel("Customer's Grade:");
		customerGradeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		customerGradeLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 18));
		customerGradeLabel.setForeground(new Color(70, 130, 180));
		customerGradeLabel.setBounds(customerAddX, customerAddY + 370, customerAddX + 130 + customerAddWidth, 110);
		customerGradeLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		customerGradeInfoText = new JLabel("");
		customerGradeInfoText.setHorizontalAlignment(SwingConstants.CENTER);
		customerGradeInfoText.setFont(new Font("Dubai Medium", Font.BOLD, 60));
		customerGradeInfoText.setBackground(SystemColor.activeCaption);
		customerGradeInfoText.setForeground(SystemColor.WHITE);
		customerGradeInfoText.setBounds(2*customerAddX + 130 + customerAddWidth, customerAddY + 370, 420, 110);
		customerGradeInfoText.setOpaque(true);
		customerGradeInfoText.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		notFound = new JLabel("");
		notFound.setBounds(870, 120, 90, 30);
		notFound.setForeground(new Color(255,0,0));
		contentPanel.add(notFound);
		
		goClientButton = new JButton("GO");
		goClientButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		goClientButton.setBackground(SystemColor.activeCaption);
		goClientButton.setForeground(SystemColor.WHITE);
		goClientButton.setBounds(870, 30, 90, 80);
		goClientButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(goClientButton);
		
		goClientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//try query, if error, display flash message "wrong input"
				// otherwise, add successful, clear the textfields
				if(SqlCon.customerExists(customerIDVal.getText())) {
					displayCustomerSheet(customerIDVal.getText());
					frame.repaint();
				}
				else {
					notFound.setText("Not found");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					        	notFound.setText("");
					        }
					        notFound.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
				}
			}
		});
		
	}
	
	private void accountPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		//Welcome
		JLabel welcomeLabel = new JLabel("Welcome "+SqlCon.getEmployeeFullName());
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

		JLabel usernameRLabel = new JLabel(Login.accountUsername);
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
		
		JLabel dateBirthRLabel = new JLabel(SqlCon.getEmployeeBirthday());
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
		
		JLabel positionRLabel = new JLabel(SqlCon.getEmployeePosition());
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
		
		JLabel phoneRLabel = new JLabel(SqlCon.getEmployeePhone());
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
		
		JLabel emailRLabel = new JLabel(SqlCon.getEmployeeEmail());
		emailRLabel.setHorizontalAlignment(SwingConstants.LEFT);
		emailRLabel.setFont(new Font("Dubai Medium", Font.BOLD, 25));
		emailRLabel.setForeground(SystemColor.activeCaption);
		emailRLabel.setBounds(240, 320, 350, 50);
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
		
		denied = new JLabel("");
		denied.setBounds(400, 600, 110, 50);
		denied.setForeground(new Color(255,0,0));
		contentPanel.add(denied);
		
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
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//Will save the new password for this person
				//Will display flash text "wrong password"
				
				if(SqlCon.userExists(Login.accountUsername, oldPass.getText())) {
					if(newPass.getText().contentEquals(newPass2.getText())) {
						SqlCon.updatePassword(Login.accountUsername, newPass.getText());
					}
					else {
						denied.setText("Not matching");
						new Timer(100, new ActionListener() {
							 public void actionPerformed(ActionEvent e) {
							        alpha += increment;
							        if (alpha <= 0) {
							        	alpha = 0;
							          denied.setText("");
							        }
							        denied.setForeground(new Color(255, 0, 0, alpha));
							      }
							    }).start();
							alpha = 255;
						}
				}
				else {
					denied.setText("Wrong password");
					new Timer(100, new ActionListener() {
						 public void actionPerformed(ActionEvent e) {
					        alpha += increment;
					        if (alpha <= 0) {
					        	alpha = 0;
					          denied.setText("");
					        }
					        denied.setForeground(new Color(255, 0, 0, alpha));
						 }
					}).start();
					alpha = 255;
				}
				
				oldPass.setText("");
				newPass.setText("");
				newPass2.setText("");
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
		JLabel unpaidCountLabel = new JLabel("Rent Unpaid: ");
		unpaidCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidCountLabel.setFont(new Font("Dubai Medium", Font.BOLD, 25));
		unpaidCountLabel.setBackground(SystemColor.activeCaption);
		unpaidCountLabel.setForeground(Color.WHITE);
		unpaidCountLabel.setBounds(50, 30, 450, 70);
		unpaidCountLabel.setOpaque(true);
		unpaidCountLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(unpaidCountLabel);
		
		JLabel unpaidCountVal = new JLabel(Integer.toString(SqlCon.getCountUnpaidRent()));
		unpaidCountVal.setHorizontalAlignment(SwingConstants.CENTER);
		unpaidCountVal.setFont(new Font("Dubai Medium", Font.BOLD, 30));
		unpaidCountVal.setBackground(SystemColor.info);
		unpaidCountVal.setForeground(SystemColor.activeCaption);
		unpaidCountVal.setBounds(500, 30, 450, 70);
		unpaidCountVal.setOpaque(true);
		unpaidCountVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(unpaidCountVal);
		
		denied = new JLabel("");
		denied.setBounds(400, 600, 110, 50);
		denied.setForeground(new Color(255,0,0));
		contentPanel.add(denied);
		
		denied.setText(" ");
		new Timer(100, new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        alpha += increment;
			        if (alpha <= 0) {
			        	alpha = 0;
			          denied.setText("");
			        }
			        denied.setForeground(new Color(255, 0, 0, alpha));
			      }
			    }).start();
			alpha = 255;
		
		String [] columnNames = {"Customer ID", "Customer Name", "Number of unpaid", "Deadline"};
		String [][] data = SqlCon.searchListUnpaid();
		table = new CreateTable(data, columnNames);
		table.setBounds(30, 150, 940, 450);
		table.setVisible(true);
		contentPanel.add(table);
	}
	
	private void contractPage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel contractCountLabel = new JLabel("Contract Expiring Soon: ");
		contractCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contractCountLabel.setFont(new Font("Dubai Medium", Font.BOLD, 25));
		contractCountLabel.setBackground(SystemColor.activeCaption);
		contractCountLabel.setForeground(Color.WHITE);
		contractCountLabel.setBounds(50, 30, 450, 70);
		contractCountLabel.setOpaque(true);
		contractCountLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(contractCountLabel);
		
		JLabel contractCountVal = new JLabel(Integer.toString(SqlCon.getCountExpiringSoon()));
		contractCountVal.setHorizontalAlignment(SwingConstants.CENTER);
		contractCountVal.setFont(new Font("Dubai Medium", Font.BOLD, 30));
		contractCountVal.setBackground(SystemColor.info);
		contractCountVal.setForeground(SystemColor.activeCaption);
		contractCountVal.setBounds(500, 30, 450, 70);
		contractCountVal.setOpaque(true);
		contractCountVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(contractCountVal);
		
		denied = new JLabel("");
		denied.setBounds(400, 600, 110, 50);
		denied.setForeground(new Color(255,0,0));
		contentPanel.add(denied);
		
		denied.setText(" ");
		new Timer(100, new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        alpha += increment;
			        if (alpha <= 0) {
			        	alpha = 0;
			          denied.setText("");
			        }
			        denied.setForeground(new Color(255, 0, 0, alpha));
			      }
			    }).start();
			alpha = 255;
		
		String [] columnNames = {"Customer ID", "Customer Name", "ContractID", "End Date"};
		String [][] data = SqlCon.searchListContract();
		table = new CreateTable(data, columnNames);
		table.setBounds(30, 150, 940, 450);
		table.setVisible(true);
		contentPanel.add(table);
		
	}
	
	private void maintenancePage() {
		contentPanel.removeAll();
		
		//Add to content panel
		JLabel maintenanceCountLabel = new JLabel("Maintenance Requested (On-going): ");
		maintenanceCountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		maintenanceCountLabel.setFont(new Font("Dubai Medium", Font.BOLD, 25));
		maintenanceCountLabel.setBackground(SystemColor.activeCaption);
		maintenanceCountLabel.setForeground(Color.WHITE);
		maintenanceCountLabel.setBounds(50, 30, 450, 70);
		maintenanceCountLabel.setOpaque(true);
		maintenanceCountLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(maintenanceCountLabel);
		
		JLabel maintenanceCountVal = new JLabel(Integer.toString(SqlCon.getCountOnGoingMaintenance()));
		maintenanceCountVal.setHorizontalAlignment(SwingConstants.CENTER);
		maintenanceCountVal.setFont(new Font("Dubai Medium", Font.BOLD, 30));
		maintenanceCountVal.setBackground(SystemColor.info);
		maintenanceCountVal.setForeground(SystemColor.activeCaption);
		maintenanceCountVal.setBounds(500, 30, 450, 70);
		maintenanceCountVal.setOpaque(true);
		maintenanceCountVal.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		contentPanel.add(maintenanceCountVal);
		
		denied = new JLabel("");
		denied.setBounds(400, 600, 110, 50);
		denied.setForeground(new Color(255,0,0));
		contentPanel.add(denied);
		
		denied.setText(" ");
		new Timer(100, new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			        alpha += increment;
			        if (alpha <= 0) {
			        	alpha = 0;
			          denied.setText("");
			        }
			        denied.setForeground(new Color(255, 0, 0, alpha));
			      }
			    }).start();
			alpha = 255;
		
		String [] columnNames = {"House ID", "Maintenance ID", "Reason"};
		String [][] data = SqlCon.searchListMaintenance();
		table = new CreateTable(data, columnNames);
		table.setBounds(30, 150, 940, 450);
		table.setVisible(true);
		contentPanel.add(table);
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
		housingIDText.setText("");
		housingIDText.setEditable(true);
		contentPanel.add(housingIDText);

		contentPanel.add(addressLabel);
		addressText.setText("");
		addressText.setEditable(true);
		contentPanel.add(addressText);

		contentPanel.add(typeLabel);
		typeText.setText("");
		typeText.setEditable(true);
		contentPanel.add(typeText);

		contentPanel.add(rentPriceLabel);
		rentPriceText.setText("");
		rentPriceText.setEditable(true);
		contentPanel.add(rentPriceText);

		contentPanel.add(numOfRoomsLabel);
		numOfRoomsText.setText("");
		numOfRoomsText.setEditable(true);
		contentPanel.add(numOfRoomsText);
		
		contentPanel.add(numOfBathroomsLabel);
		numOfBathroomsText.setText("");
		numOfBathroomsText.setEditable(true);
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

	//displayHousingModifier() method
	public static void displayHousingModifier(String idText) {
		contentPanel.add(housingIDLabel);
		housingIDText.setText(idText);
		housingIDText.setEditable(true);
		contentPanel.add(housingIDText);

		contentPanel.add(addressLabel);
		addressText.setText(SqlCon.getHousingAddress(idText));
		addressText.setEditable(true);
		contentPanel.add(addressText);

		contentPanel.add(typeLabel);
		typeText.setText(SqlCon.getHousingRoomType(idText));
		typeText.setEditable(true);
		contentPanel.add(typeText);

		contentPanel.add(rentPriceLabel);
		rentPriceText.setText(SqlCon.getHousingRentPrice(idText));
		rentPriceText.setEditable(true);
		contentPanel.add(rentPriceText);

		contentPanel.add(numOfRoomsLabel);
		numOfRoomsText.setText(SqlCon.getHousingNumOfRooms(idText));
		numOfRoomsText.setEditable(true);
		contentPanel.add(numOfRoomsText);
		
		contentPanel.add(numOfBathroomsLabel);
		numOfBathroomsText.setText(SqlCon.getHousingNumOfBathrooms(idText));
		numOfBathroomsText.setEditable(true);
		contentPanel.add(numOfBathroomsText);
		
		contentPanel.add(vacantLabel);
		vacantText.setText(SqlCon.getHousingVacant(idText));
		vacantText.setEditable(true);
		contentPanel.add(vacantText);
		
		contentPanel.add(confirmHousingModButton);
		
	}
	
	//ClearHousingModifier() method
	public static void clearHousingModifier() {
		contentPanel.add(housingIDLabel);
		housingIDText.setText("");
		housingIDText.setEditable(true);
		contentPanel.add(housingIDText);

		contentPanel.add(addressLabel);
		addressText.setText("");
		addressText.setEditable(true);
		contentPanel.add(addressText);

		contentPanel.add(typeLabel);
		typeText.setText("");
		typeText.setEditable(true);
		contentPanel.add(typeText);

		contentPanel.add(rentPriceLabel);
		rentPriceText.setText("");
		rentPriceText.setEditable(true);
		contentPanel.add(rentPriceText);

		contentPanel.add(numOfRoomsLabel);
		numOfRoomsText.setText("");
		numOfRoomsText.setEditable(true);
		contentPanel.add(numOfRoomsText);
		
		contentPanel.add(numOfBathroomsLabel);
		numOfBathroomsText.setText("");
		numOfBathroomsText.setEditable(true);
		contentPanel.add(numOfBathroomsText);
		
		contentPanel.add(vacantLabel);
		vacantText.setText("");
		vacantText.setEditable(true);
		contentPanel.add(vacantText);
		
		contentPanel.add(confirmHousingDelButton);
	}
	
	//Remove Housing Modifier
	public static void removeHousingModifier() {
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
		contentPanel.remove(vacantLabel);
		contentPanel.remove(vacantText);
		contentPanel.remove(confirmHousingModButton);
	}

	//displayHousingDeleter() method
	public static void displayHousingDeleter(String idText) {
		contentPanel.add(housingIDLabel);
		housingIDText.setText(idText);
		housingIDText.setEditable(false);
		contentPanel.add(housingIDText);

		contentPanel.add(addressLabel);
		addressText.setText(SqlCon.getHousingAddress(idText));
		addressText.setEditable(false);
		contentPanel.add(addressText);

		contentPanel.add(typeLabel);
		typeText.setText(SqlCon.getHousingRoomType(idText));
		typeText.setEditable(false);
		contentPanel.add(typeText);

		contentPanel.add(rentPriceLabel);
		rentPriceText.setText(SqlCon.getHousingRentPrice(idText));
		rentPriceText.setEditable(false);
		contentPanel.add(rentPriceText);

		contentPanel.add(numOfRoomsLabel);
		numOfRoomsText.setText(SqlCon.getHousingNumOfRooms(idText));
		numOfRoomsText.setEditable(false);
		contentPanel.add(numOfRoomsText);
		
		contentPanel.add(numOfBathroomsLabel);
		numOfBathroomsText.setText(SqlCon.getHousingNumOfBathrooms(idText));
		numOfBathroomsText.setEditable(false);
		contentPanel.add(numOfBathroomsText);
		
		contentPanel.add(vacantLabel);
		vacantText.setText(SqlCon.getHousingVacant(idText));
		vacantText.setEditable(false);
		contentPanel.add(vacantText);
		
		contentPanel.add(confirmHousingDelButton);
	}
	
	//ClearHousingDeleter() method
	public static void clearHousingDeleter() {
		contentPanel.add(housingIDLabel);
		housingIDText.setText("");
		housingIDText.setEditable(false);
		contentPanel.add(housingIDText);

		contentPanel.add(addressLabel);
		addressText.setText("");
		addressText.setEditable(false);
		contentPanel.add(addressText);

		contentPanel.add(typeLabel);
		typeText.setText("");
		typeText.setEditable(false);
		contentPanel.add(typeText);

		contentPanel.add(rentPriceLabel);
		rentPriceText.setText("");
		rentPriceText.setEditable(false);
		contentPanel.add(rentPriceText);

		contentPanel.add(numOfRoomsLabel);
		numOfRoomsText.setText("");
		numOfRoomsText.setEditable(false);
		contentPanel.add(numOfRoomsText);
		
		contentPanel.add(numOfBathroomsLabel);
		numOfBathroomsText.setText("");
		numOfBathroomsText.setEditable(false);
		contentPanel.add(numOfBathroomsText);
		
		contentPanel.add(vacantLabel);
		vacantText.setText("");
		vacantText.setEditable(false);
		contentPanel.add(vacantText);
		
		contentPanel.add(confirmHousingDelButton);
	}
	
	//Remove Housing Deleter
	public static void removeHousingDeleter() {
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
		contentPanel.remove(vacantLabel);
		contentPanel.remove(vacantText);
		contentPanel.remove(confirmHousingDelButton);

	}
	
	//Add add customer feature in Admin
	public static void addCustomerAdd() {
		contentPanel.add(customerIDLabel);
		customerIDText.setText("");
		customerIDText.setEditable(true);
		contentPanel.add(customerIDText);
		
		contentPanel.add(firstNameLabel);
		firstNameText.setText("");
		firstNameText.setEditable(true);
		contentPanel.add(firstNameText);
		
		contentPanel.add(lastNameLabel);
		lastNameText.setText("");
		lastNameText.setEditable(true);
		contentPanel.add(lastNameText);
		
		contentPanel.add(dateBirthLabel);
		dateBirthText.setText("");
		dateBirthText.setEditable(true);
		contentPanel.add(dateBirthText);
		
		contentPanel.add(phoneLabel);
		phoneText.setText("");
		phoneText.setEditable(true);
		contentPanel.add(phoneText);
		
		contentPanel.add(emailLabel);
		emailText.setText("");
		emailText.setEditable(true);
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
		
	
	//displayCustomerModifier() method
	public static void displayCustomerModifier(String idText) {
		contentPanel.add(customerIDLabel);
		customerIDText.setText(idText);
		customerIDText.setEditable(true);
		contentPanel.add(customerIDText);
		
		contentPanel.add(firstNameLabel);
		firstNameText.setText(SqlCon.getCustomerFirstName(idText));
		firstNameText.setEditable(true);
		contentPanel.add(firstNameText);
		
		contentPanel.add(lastNameLabel);
		lastNameText.setText(SqlCon.getCustomerLastName(idText));
		lastNameText.setEditable(true);
		contentPanel.add(lastNameText);
		
		contentPanel.add(dateBirthLabel);
		dateBirthText.setText(SqlCon.getCustomerDoB(idText));
		dateBirthText.setEditable(true);
		contentPanel.add(dateBirthText);
		
		contentPanel.add(phoneLabel);
		phoneText.setText(SqlCon.getCustomerPhone(idText));
		phoneText.setEditable(true);
		contentPanel.add(phoneText);
		
		contentPanel.add(emailLabel);
		emailText.setText(SqlCon.getCustomerEmail(idText));
		emailText.setEditable(true);
		contentPanel.add(emailText);
		
		contentPanel.add(confirmCustomerModButton);
	}
	
	//clearCustomerModifier() method
	public static void clearCustomerModifier() {
		contentPanel.add(customerIDLabel);
		customerIDText.setText("");
		customerIDText.setEditable(true);
		contentPanel.add(customerIDText);
		
		contentPanel.add(firstNameLabel);
		firstNameText.setText("");
		firstNameText.setEditable(true);
		contentPanel.add(firstNameText);
		
		contentPanel.add(lastNameLabel);
		lastNameText.setText("");
		lastNameText.setEditable(true);
		contentPanel.add(lastNameText);
		
		contentPanel.add(dateBirthLabel);
		dateBirthText.setText("");
		dateBirthText.setEditable(true);
		contentPanel.add(dateBirthText);
		
		contentPanel.add(phoneLabel);
		phoneText.setText("");
		phoneText.setEditable(true);
		contentPanel.add(phoneText);
		
		contentPanel.add(emailLabel);
		emailText.setText("");
		emailText.setEditable(true);
		contentPanel.add(emailText);
		
		contentPanel.add(confirmCustomerModButton);
	}
	
	//Remove Customer Modifier
	public static void removeCustomerModifier() {
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
		contentPanel.remove(confirmCustomerModButton);
	}
	
	//displayCustomerDeleter() method
	public static void displayCustomerDeleter(String idText) {
		contentPanel.add(customerIDLabel);
		customerIDText.setText(idText);
		customerIDText.setEditable(false);
		contentPanel.add(customerIDText);
		
		contentPanel.add(firstNameLabel);
		firstNameText.setText(SqlCon.getCustomerFirstName(idText));
		firstNameText.setEditable(false);
		contentPanel.add(firstNameText);
		
		contentPanel.add(lastNameLabel);
		lastNameText.setText(SqlCon.getCustomerLastName(idText));
		lastNameText.setEditable(false);
		contentPanel.add(lastNameText);
		
		contentPanel.add(dateBirthLabel);
		dateBirthText.setText(SqlCon.getCustomerDoB(idText));
		dateBirthText.setEditable(false);
		contentPanel.add(dateBirthText);
		
		contentPanel.add(phoneLabel);
		phoneText.setText(SqlCon.getCustomerPhone(idText));
		phoneText.setEditable(false);
		contentPanel.add(phoneText);
		
		contentPanel.add(emailLabel);
		emailText.setText(SqlCon.getCustomerEmail(idText));
		emailText.setEditable(false);
		contentPanel.add(emailText);
		
		contentPanel.add(confirmCustomerDelButton);
	}
	
	//clearCustomerDeleter() method
	public static void clearCustomerDeleter() {
		contentPanel.add(customerIDLabel);
		customerIDText.setText("");
		customerIDText.setEditable(false);
		contentPanel.add(customerIDText);
		
		contentPanel.add(firstNameLabel);
		firstNameText.setText("");
		firstNameText.setEditable(false);
		contentPanel.add(firstNameText);
		
		contentPanel.add(lastNameLabel);
		lastNameText.setText("");
		lastNameText.setEditable(false);
		contentPanel.add(lastNameText);
		
		contentPanel.add(dateBirthLabel);
		dateBirthText.setText("");
		dateBirthText.setEditable(false);
		contentPanel.add(dateBirthText);
		
		contentPanel.add(phoneLabel);
		phoneText.setText("");
		phoneText.setEditable(false);
		contentPanel.add(phoneText);
		
		contentPanel.add(emailLabel);
		emailText.setText("");
		emailText.setEditable(false);
		contentPanel.add(emailText);
		
		contentPanel.add(confirmCustomerDelButton);
	}
	
	//Remove Customer Deleter
	public static void removeCustomerDeleter() {
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
		contentPanel.remove(confirmCustomerDelButton);
	}
	
	//Remove Stuff Method
	public static void removeStuff() {
		removeSearch();
		removeHousingAdd();
		removeCustomerAdd();
		removeHousingModifier();
		removeCustomerModifier();
		removeHousingDeleter();
		removeCustomerDeleter();
	}
	
	//displaySearchAvailable() method
	public static void displaySearchAvailable() {
		
	}
	
	//displayCustomer
	public static void displayCustomerSheet(String customerID) {
		//If valid query, then
		contentPanel.add(firstNameLabel);
		firstNameInfoText.setText(SqlCon.getCustomerFirstName(customerID));
		contentPanel.add(firstNameInfoText);
		
		contentPanel.add(lastNameLabel);
		lastNameInfoText.setText(SqlCon.getCustomerLastName(customerID));
		contentPanel.add(lastNameInfoText);
		
		contentPanel.add(dateBirthLabel);
		dateBirthInfoText.setText(SqlCon.getCustomerDoB(customerID));
		contentPanel.add(dateBirthInfoText);
		
		contentPanel.add(phoneLabel);
		phoneInfoText.setText(SqlCon.getCustomerPhone(customerID));
		contentPanel.add(phoneInfoText);
		
		contentPanel.add(emailLabel);
		emailInfoText.setText(SqlCon.getCustomerEmail(customerID));
		contentPanel.add(emailInfoText);
		
		contentPanel.add(customerSinceLabel);
		customerSinceInfoText.setText(SqlCon.getCustomerRegisteredSince(customerID));
		contentPanel.add(customerSinceInfoText);
		
		contentPanel.add(complaintsCountLabel);
		complaintsCountInfoText.setText(SqlCon.getCustomerComplaintsNum(customerID));
		contentPanel.add(complaintsCountInfoText);
		
		contentPanel.add(unpaidCountLabel);
		unpaidCountInfoText.setText(SqlCon.getCustomerUnpaidsNum(customerID));
		contentPanel.add(unpaidCountInfoText);
		
		contentPanel.add(customerGradeLabel);
		customerGradeInfoText.setText(SqlCon.getCustomerGrade(customerID));
		contentPanel.add(customerGradeInfoText);
		
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
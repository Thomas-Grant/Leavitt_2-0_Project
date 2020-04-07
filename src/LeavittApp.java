/** @author Thomas Grant
 *  @date	3/30/2020
 */

// test 

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
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
	
	//Declare variables
	private int countPage = 1;
	
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
		JLabel notif = new JLabel("notifications");
		notif.setHorizontalAlignment(SwingConstants.CENTER);
		notif.setFont(new Font("Songti TC", Font.BOLD, 22));
		notif.setForeground(new Color(70, 130, 180));
		notif.setBounds(0, 0, 200, 50);
		notificationPanel.add(notif);
		
		JLabel countLabel = new JLabel("page visited: "+ countPage);
		countLabel.setHorizontalAlignment(SwingConstants.CENTER);
		countLabel.setFont(new Font("Songti TC", Font.BOLD, 12));
		countLabel.setForeground(new Color(128, 128, 128));
		countLabel.setBounds(0, 50, 200, 50);
		notificationPanel.add(countLabel);
		
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
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homePage();
				countPage ++;
				countLabel.setText("page visited: "+ countPage);;
				colorCurrentPage(homeButton);
				frame.repaint();
			}
		});
		
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPanel.removeAll();
				adminPage();
				countPage ++;
				countLabel.setText("page visited: "+ countPage);
				colorCurrentPage(adminButton);
				
				frame.repaint();
			}
		});
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchPage();
				countPage ++;
				countLabel.setText("page visited: "+ countPage);
				colorCurrentPage(searchButton);
				frame.repaint();
			}
		});
		
		clientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientPage();
				countPage ++;
				countLabel.setText("page visited: "+ countPage);
				colorCurrentPage(clientButton);
				frame.repaint();
			}
		});
		
		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accountPage();
				countPage ++;
				countLabel.setText("page visited: "+ countPage);
				colorCurrentPage(accountButton);
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
		
		//Add to content panel
		JLabel homeLabel = new JLabel("Home page!");
		homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		homeLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		homeLabel.setForeground(new Color(0, 0, 0));
		homeLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(homeLabel);
		
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
		JLabel accountLabel = new JLabel("Account page!");
		accountLabel.setHorizontalAlignment(SwingConstants.CENTER);
		accountLabel.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		accountLabel.setForeground(new Color(0, 0, 0));
		accountLabel.setBounds(0, 0, 1000, 650);
		contentPanel.add(accountLabel);
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
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Login implements ActionListener{
	
	private static JFrame frame;
	private static JPanel panel;
	private static JLabel userLabel;
	private static JTextField userText;
	private static JLabel passwordLabel;
	private static JPasswordField passwordText;
	private static JButton logButton;
	private static JButton resetButton;
	private static JLabel denied;
	private static int alpha = 255;
	private static int increment = -5;
	
	public static String accountUsername = "";
	
	public static void main(String [] args){
		
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(500,240);
		frame.add(panel);
		
		panel.setLayout(null);
		panel.setBounds(0,0,500,240);
		panel.setBackground(Color.WHITE);
		
      	try {
      		BufferedImage logoS = ImageIO.read(new File("src/Leavitt-Just-Logo.png"));
      		JLabel logoLabel = new JLabel(new ImageIcon(logoS));
      		logoLabel.setBounds(10,10,180,190);
      		panel.add(logoLabel);
      	}
      	catch (Exception e){
      		System.out.println(e);
      	}
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(210, 30, 80, 30);
		userLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		userLabel.setForeground(new Color(0, 74, 148));
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(300,30,165,30);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(210,70,80,30);
		passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordLabel.setForeground(new Color(0, 74, 148));
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(300,70,165,30);
		panel.add(passwordText);
		
		denied = new JLabel("");
		denied.setBounds(200,125,100,30);
		denied.setForeground(new Color(255,0,0));
		panel.add(denied);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(300,120,75,40);
		resetButton.setBackground(Color.WHITE);
		resetButton.setForeground(new Color(0, 74, 148));
		resetButton.addActionListener(new Login());
		panel.add(resetButton);
		
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userText.setText("");
				passwordText.setText("");
			}
		});
		
		logButton = new JButton("Login");
		logButton.setBounds(390,120,75,40);
		logButton.setBackground(new Color(0, 74, 148));
		logButton.setForeground(Color.WHITE);
		logButton.addActionListener(new Login());
		panel.add(logButton);
		
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = userText.getText();
				@SuppressWarnings("deprecation")
				String password = passwordText.getText();
				if(isValidUser(user, password)) {
					accountUsername = user;
					denied.setText("");
					frame.setVisible(false);
					new LeavittApp();
				}
				else {

					denied.setText("Access denied");
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
		});

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Leavitt 2.0 - Login");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	private static boolean isValidUser(String username, String password) {
		return SqlCon.userExists(username, password);
	}
}

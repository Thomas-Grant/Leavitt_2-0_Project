import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
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
	private static JLabel denied;
	
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
		
		logButton = new JButton("Login");
		logButton.setBounds(385,120,80,40);
		logButton.setBackground(new Color(0, 74, 148));
		logButton.setForeground(Color.WHITE);
		logButton.addActionListener(new Login());
		panel.add(logButton);
		
		denied = new JLabel("");
		denied.setBounds(230,125,100,30);
		denied.setForeground(Color.RED);
		panel.add(denied);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Leavitt 2.0 - Login");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String user = userText.getText();
		@SuppressWarnings("deprecation")
		String password = passwordText.getText();
		if(!user.equals("admin") || !password.equals("pass")) {
			denied.setText("Access denied");
		}
		else {
			denied.setText("");
			frame.setVisible(false);
			new LeavittApp();
		}
	}

}

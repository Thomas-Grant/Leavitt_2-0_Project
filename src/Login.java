import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
		frame.setSize(300,180);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel = new JLabel("Username");
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText = new JTextField(20);
		userText.setBounds(100,20,165,25);
		panel.add(userText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(10,50,80,25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel.add(passwordText);
		
		logButton = new JButton("Login");
		logButton.setBounds(185,90,80,25);
		logButton.addActionListener(new Login());
		panel.add(logButton);
		
		denied = new JLabel("");
		denied.setBounds(40,90,100,25);
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

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login1 extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Login1 frame = new Login1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 259, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setVerticalAlignment(SwingConstants.TOP);
		lblLoginPage.setBounds(10, 25, 223, 23);
		contentPane.add(lblLoginPage);

		user = new JTextField();
		user.setBounds(21, 103, 212, 20);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(21, 84, 130, 14);
		contentPane.add(lblUsername);

		JLabel password = new JLabel("Password");
		password.setFont(new Font("Tahoma", Font.BOLD, 14));
		password.setBounds(21, 149, 130, 14);
		contentPane.add(password);

		pass = new JPasswordField();
		pass.setBounds(21, 174, 212, 20);
		contentPane.add(pass);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/madhesh_subramani?useSSL=false", "root", "Password@123");

					Statement statement = connection.createStatement();
					String sql = "select * from login_details where username='" + user.getText() + "'and password='"
							+ pass.getText() + "'";

					ResultSet result = statement.executeQuery(sql);

					if (result.next()) {

						JOptionPane.showMessageDialog(null, "Login Successfully...");
					} else {
						JOptionPane.showMessageDialog(null, "Invalid Username and Password");
					}
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnLogin.setBounds(87, 224, 89, 23);
		contentPane.add(btnLogin);
	}

}

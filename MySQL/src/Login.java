import java.awt.Color;
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

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 236, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setBackground(Color.DARK_GRAY);
		lblLoginPage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoginPage.setBounds(10, 22, 200, 26);
		contentPane.add(lblLoginPage);

		JLabel lblUserName = new JLabel("Username");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUserName.setBackground(Color.GRAY);
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setBounds(10, 81, 99, 26);
		contentPane.add(lblUserName);

		user = new JTextField();
		user.setBounds(10, 106, 200, 20);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassword.setBackground(Color.GRAY);
		lblPassword.setBounds(10, 137, 99, 20);
		contentPane.add(lblPassword);

		pass = new JPasswordField();
		pass.setBounds(10, 156, 200, 20);
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

					String sql = "select * from login_details where username ='" + user.getText() + "'and password='"
							+ pass.getText().toString() + "'";

					ResultSet result = statement.executeQuery(sql);

					if (result.next()) {
						JOptionPane.showMessageDialog(null, "Login successfully");
					} else {
						JOptionPane.showMessageDialog(null, " Incorrect Username and Password");
					}
					connection.close();
				} catch (Exception e1) {
					System.out.print(e1);
				}

			}
		});
		btnLogin.setBounds(58, 198, 89, 23);
		contentPane.add(btnLogin);
	}
}

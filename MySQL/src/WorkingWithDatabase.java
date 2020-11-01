import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class WorkingWithDatabase {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/selenium_database?useSSL=false", "root", "Password@123");

			Statement statement = connection.createStatement();

			statement.executeUpdate("create table selenium(id int, name varchar(20),parentName varchar(20))");
			statement.executeUpdate("insert into selenium values(1, 'Madhesh', 'Subramani')");
			statement.executeUpdate("insert into selenium values(2,'Guna','selvi')");
			/*
			 * statement.
			 * executeUpdate("update selenium_table set parentName='subramani' where id=2");
			 * 
			 * statement.executeUpdate("delete from selenium_table where id=2");
			 */

			ResultSet rs = statement.executeQuery("select * from selenium_table");

			while (rs.next()) {

				int id = rs.getInt(1);
				String name = rs.getString(2);
				String parentName = rs.getString("parentName");

				System.out.println("id " + id + " name " + name + " parentname " + parentName);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}

import java.sql.Connection;

public class databaseBridgeConnect {

	public static Connection connect() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/final_project_lnt", "root", "");
		}catch(Exception e) {
			System.out.println("Failed to connect!");
			e.printStackTrace();
		}
		return connection;
	}

}
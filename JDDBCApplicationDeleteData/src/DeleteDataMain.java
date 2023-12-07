import java.sql.*;
public class DeleteDataMain {
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        public static final String DB_URL = "jdbc:mysql://localhost/emp";
        // Database credentials
        static final String USER = "root";
        static final String PASS = "root";
        public static void main(String[] args) {
            Connection conn = null;
            Statement stmt = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Deleting Data...");
                conn = DriverManager.getConnection(DB_URL, "root", "root");
                String sql;
                sql = "DELETE FROM students WHERE id IN (100,120)";
                stmt = conn.prepareStatement(sql);
                stmt.execute(sql);
                stmt.close();
                conn.close();
            } catch(SQLException se){
//Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
//Handle errors for Class.forName
                e.printStackTrace();
            } finally {
//finally block used to close resources
                try {
                    if (stmt != null)
                        stmt.close();
                } catch (SQLException se2) {
                }// nothing can be done
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }//end finally try
            }//end try
            System.out.println("Goodbye!");
        }
}

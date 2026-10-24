import java.sql.*;

public class JDBCPractice {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // import package
        // load and register driver
        // create the connection
        // create statement
        // execute statement
        // process result
        // close the connection

        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/student";
        String uname = "postgres";
        String pass = "";
        String selectName = "SELECT sname FROM student WHERE sid = 1";
        String selectAll = "SELECT * FROM student";
        String insertData = "INSERT INTO student VALUES(4, 'Suresh', 70)";
        String updateData = "UPDATE student SET sname = 'Kalpes' WHERE sid = 4";
        String deleteData = "DELETE FROM student WHERE sid = 4";
        int sid = 102;
        String sname = "John";
        int marks = 52;
        String preparedInsert = "INSERT INTO student VALUES(?,?,?)";

        Connection con = DriverManager.getConnection(url, uname, pass);
        System.out.println("Connection established");
        Statement st = con.createStatement();

        ResultSet resName = st.executeQuery(selectName); // for insert/update/delet - use st.execute()
        resName.next(); // moves the cursor to the next row, i.e. 1st row in this case
        String name = resName.getString("sName");
        System.out.println("Name: " + name);

        ResultSet resAll = st.executeQuery(selectAll);
        while (resAll.next()) {
            System.out.print(resAll.getInt(1) + " - ");
            System.out.print(resAll.getString(2) + " - ");
            System.out.println(resAll.getInt(3));
        }

        boolean status = st.execute(insertData);
        System.out.println("Status: " + status); // print true if it returns a resultSet else prints false

        st.execute(updateData);
        st.execute(deleteData);

        PreparedStatement ps = con.prepareStatement(preparedInsert);
        ps.setInt(1, sid);
        ps.setString(2, sname);
        ps.setInt(3, marks);
        ps.execute();

        con.close();
        System.out.println("Connection Closed");
    }
}
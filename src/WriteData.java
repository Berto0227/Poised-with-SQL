//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class WriteData {

    static String url = "jdbc:mysql://localhost:3306/poised_final?autoReconnect=true&useSSL=false";
    static String user = "user";
    static String password = "Us3r@123";

    //File writer class and method. Data that has been edited and has been replaced will now be written back to the file.
    public static void writeProject() {
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);

            String sqlInsert = "INSERT INTO projects (project_num, project_name, build_type, project_address, erf_num, due_date, " +
                    " customer_name, customer_tel, customer_email, customer_address, tot_fee, tot_paid, architect_name, architect_tel, " +
                    " architect_email, architect_address, contract_name, contract_tel, contract_email, contract_address, completed)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = myConn.prepareStatement(sqlInsert);

            pstmt.setInt(1, NewProject.project_num);
            pstmt.setString(2, NewProject.project_name);
            pstmt.setString(3, NewProject.build_type);
            pstmt.setString(4, NewProject.project_address);
            pstmt.setString(5, NewProject.erf_num);
            pstmt.setString(6, NewProject.due_date);
            pstmt.setString(7, NewProject.customer_name);
            pstmt.setString(8, NewProject.customer_tel);
            pstmt.setString(9, NewProject.customer_email);
            pstmt.setString(10, NewProject.customer_address);
            pstmt.setDouble(11, NewProject.tot_fee);
            pstmt.setDouble(12, NewProject.tot_paid);
            pstmt.setString(13, NewProject.architect_name);
            pstmt.setString(14, NewProject.architect_tel);
            pstmt.setString(15, NewProject.architect_email);
            pstmt.setString(16, NewProject.architect_address);
            pstmt.setString(17, NewProject.contract_name);
            pstmt.setString(18, NewProject.contract_tel);
            pstmt.setString(19, NewProject.contract_email);
            pstmt.setString(20, NewProject.contract_address);
            pstmt.setString(21, NewProject.completed);
            pstmt.executeUpdate(); //Execute update of database.
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
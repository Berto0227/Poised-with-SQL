//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.sql.*;
import java.util.Scanner;

public class UpdateData {

    static String url = "jdbc:mysql://localhost:3306/poised_final?autoReconnect=true&useSSL=false";
    static String user = "user";
    static String password = "Us3r@123";
    static Scanner sc = new Scanner(System.in);
    static int projectChosen;

    private static int getQuestionInput() {
        int result;
        System.out.println("Please enter the Project Number of the project that you wish to update: ");
        result = sc.nextInt();
        return result;
    }

    public static void updateArchitect(){

        //Ask the user, which project do they wish to update.
        projectChosen = getQuestionInput();
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);

            String sqlInsert = "UPDATE projects " +
                    " SET architect_name = ?, architect_tel = ?, architect_email = ?, architect_address = ?" +
                    "WHERE project_num = " +projectChosen;

            PreparedStatement pstmt = myConn.prepareStatement(sqlInsert);
            pstmt.setString(1, NewProject.architect_name);
            pstmt.setString(2, NewProject.architect_tel);
            pstmt.setString(3, NewProject.architect_email);
            pstmt.setString(4, NewProject.architect_address);
            pstmt.executeUpdate(); //Execute update of database.
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateContractor(){

        //Ask the user, which project do they wish to update.
        projectChosen = getQuestionInput();
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);

            String sqlInsert = "UPDATE projects" +
                    " SET contract_name = ?, contract_tel = ?, contract_email = ?, contract_address = ?" +
                    "WHERE project_num = " +projectChosen;

            PreparedStatement pstmt = myConn.prepareStatement(sqlInsert);
            pstmt.setString(1, NewProject.contract_name);
            pstmt.setString(2, NewProject.contract_tel);
            pstmt.setString(3, NewProject.contract_email);
            pstmt.setString(4, NewProject.contract_address);
            pstmt.executeUpdate(); //Execute update of database.
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateDueDate(){

        //Ask the user, which project do they wish to update.
        projectChosen = getQuestionInput();
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            String sqlInsert = "UPDATE projects SET due_date = ? " +
                    "WHERE project_num = " + projectChosen;

            PreparedStatement pstmt = myConn.prepareStatement(sqlInsert);
            pstmt.setString(1, NewProject.due_date);
            pstmt.executeUpdate(); //Execute update of database.
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updatePayment(){

        //Ask the user, which project do they wish to update.
        projectChosen = getQuestionInput();
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);

            String sqlInsert = "UPDATE projects SET tot_paid = ?" +
                            "WHERE project_num = " + projectChosen;

            PreparedStatement pstmt = myConn.prepareStatement(sqlInsert);
            pstmt.setDouble(1, NewProject.tot_paid);
            pstmt.executeUpdate(); //Execute update of database.
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateFinal(){

        //Ask the user, which project do they wish to update.
        projectChosen = getQuestionInput();
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);

            String sqlInsert = "UPDATE projects" +
                    " SET completed = ?" +
                    "WHERE project_num = " + projectChosen;

            PreparedStatement pstmt = myConn.prepareStatement(sqlInsert);
            pstmt.setString(1, "YES");
            pstmt.executeUpdate(); //Execute update of database.
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void printInvoice(){
        int pro_num = 0;
        String cust_name = null;
        String cust_tel = null;
        String cust_email = null;
        String cust_address = null;
        double total_fee = 0;
        double remain_fee = 0;

        //Ask the user, which project do they wish to update.
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            String sqlInsert = "SELECT * FROM poised_final.projects WHERE project_num = " + projectChosen;
            Statement st = myConn.createStatement();
            ResultSet rs = st.executeQuery(sqlInsert);
            while (rs.next()){
                pro_num = rs.getInt(1);
                cust_name = rs.getString(7);
                cust_tel = rs.getString(8);
                cust_email = rs.getString(9);
                cust_address = rs.getString(10);
                total_fee = rs.getDouble(11);
                remain_fee = rs.getDouble(12);
            }
            PrintWriter writer = new PrintWriter("Invoice.txt", StandardCharsets.UTF_8);

            String invoice = "Project Number: \t\t" + pro_num;
            invoice += "\nCustomer name: \t\t\t" + cust_name;
            invoice += "\nCustomer Telephone Number: \t" + cust_tel;
            invoice += "\nCustomer Email Address: \t" + cust_email;
            invoice += "\nCustomer Address: \t\t" + cust_address;
            invoice += "\nTotal amount outstanding: \t" + (total_fee - remain_fee);

            writer.write(invoice);
            writer.close();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}

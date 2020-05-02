//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ReadData {
    //Create variable for later use.
    static String project_num;
    static String project_name;
    static String build_type;
    static String project_address;
    static String erf_num;
    static String due_date;
    static String customer_name;
    static String customer_tel;
    static String customer_email;
    static String customer_address;
    static double tot_fee;
    static double tot_paid;
    static String completed;
    static String architect_name;
    static String architect_tel;
    static String architect_email;
    static String architect_address;
    static String contract_name;
    static String contract_tel;
    static String contract_email;
    static String contract_address;
    static Scanner sc = new Scanner(System.in);

    static String url = "jdbc:mysql://localhost:3306/poised_final?autoReconnect=true&useSSL=false";
    static String user = "user";
    static String password = "Us3r@123";

    //This is the reading class and method. The database is accessed and every line is read and then placed into the variables for
    //data manipulation. At some stage the program uses a user's input as a find in line that needs to be updated.
    public static void readProject() {
        //Ask the user, which project do they wish to update.
        System.out.println("Please enter the Project Number you wish to view: ");
        String userChosen = sc.next();

        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();
            String strSearch = "SELECT * FROM projects WHERE project_num =" + userChosen;
            ResultSet rs = myStmt.executeQuery(strSearch);
            while (rs.next()) {
                project_num = rs.getString(1);
                project_name = rs.getString(2);
                build_type = rs.getString(3);
                project_address = rs.getString(4);
                erf_num = rs.getString(5);
                due_date = rs.getString(6);
                customer_name = rs.getString(7);
                customer_tel = rs.getString(8);
                customer_email = rs.getString(9);
                customer_address = rs.getString(10);
                tot_fee = rs.getDouble(11);
                tot_paid = rs.getDouble(12);
                completed = rs.getString(13);
                architect_name = rs.getString(13);
                architect_tel = rs.getString(14);
                architect_email = rs.getString(15);
                architect_address = rs.getString(16);
                contract_name = rs.getString(17);
                contract_tel = rs.getString(18);
                contract_email = rs.getString(19);
                contract_address = rs.getString(20);
                completed = rs.getString(21);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //This is the reading class and method. The database is accessed and every line is read and then placed into the variables for
    //data manipulation. At some stage the program uses a user's input as a find in line that needs to be updated.
    public static void readDue() {
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();

            Date date = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strDate = formatter.format(date);

            String strSearch = "SELECT * FROM projects WHERE due_date < " + strDate;
            ResultSet rs = myStmt.executeQuery(strSearch);
            while (rs.next()) {
                project_num = rs.getString(1);
                project_name = rs.getString(2);
                build_type = rs.getString(3);
                project_address = rs.getString(4);
                erf_num = rs.getString(5);
                due_date = rs.getString(6);
                customer_name = rs.getString(7);
                customer_tel = rs.getString(8);
                customer_email = rs.getString(9);
                customer_address = rs.getString(10);
                tot_fee = rs.getDouble(11);
                tot_paid = rs.getDouble(12);
                completed = rs.getString(13);
                architect_name = rs.getString(13);
                architect_tel = rs.getString(14);
                architect_email = rs.getString(15);
                architect_address = rs.getString(16);
                contract_name = rs.getString(17);
                contract_tel = rs.getString(18);
                contract_email = rs.getString(19);
                contract_address = rs.getString(20);
                completed = rs.getString(21);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    //This is the reading class and method. The database is accessed and every line is read and then placed into the variables for
    //data manipulation. At some stage the program uses a user's input as a find in line that needs to be updated.
    public static void readAll() {
        try {
            Connection myConn = DriverManager.getConnection(url, user, password);
            Statement myStmt = myConn.createStatement();
            String strSearch = "SELECT * FROM projects";
            ResultSet rs = myStmt.executeQuery(strSearch);
            while (rs.next()) {
                project_num = rs.getString(1);
                project_name = rs.getString(2);
                build_type = rs.getString(3);
                project_address = rs.getString(4);
                erf_num = rs.getString(5);
                due_date = rs.getString(6);
                customer_name = rs.getString(7);
                customer_tel = rs.getString(8);
                customer_email = rs.getString(9);
                customer_address = rs.getString(10);
                tot_fee = rs.getDouble(11);
                tot_paid = rs.getDouble(12);
                completed = rs.getString(13);
                architect_name = rs.getString(13);
                architect_tel = rs.getString(14);
                architect_email = rs.getString(15);
                architect_address = rs.getString(16);
                contract_name = rs.getString(17);
                contract_tel = rs.getString(18);
                contract_email = rs.getString(19);
                contract_address = rs.getString(20);
                completed = rs.getString(21);

                System.out.println("*** Detailed Information about Projects***");
                System.out.println("Project Number:\t\t\t\t\t " + ReadData.project_num);
                System.out.println("Project Name:\t\t\t\t\t " + ReadData.project_name);
                System.out.println("Project Building Type:\t\t\t " + ReadData.build_type);
                System.out.println("Project Address:\t\t\t\t " + ReadData.project_address);
                System.out.println("Project ERF Number:\t\t\t\t " + ReadData.erf_num);
                System.out.println("Customer's Name:\t\t\t\t " + ReadData.contract_name);
                System.out.println("Customer's Telephone Number:\t " + ReadData.contract_tel);
                System.out.println("Customer's Email Address:\t\t " + ReadData.customer_email);
                System.out.println("Customer's Address:\t\t\t\t " + ReadData.contract_address);
                System.out.println("Architect's Name:\t\t\t\t " + ReadData.architect_name);
                System.out.println("Architect's Telephone Number:\t " + ReadData.architect_tel);
                System.out.println("Architect's Email Address:\t\t " + ReadData.architect_email);
                System.out.println("Architect's Address:\t\t\t " + ReadData.architect_address);
                System.out.println("Contractor's Name:\t\t\t\t " + ReadData.architect_name);
                System.out.println("Contractor's Telephone Number:\t " + ReadData.architect_tel);
                System.out.println("Contractor's Email Address:\t\t " + ReadData.architect_email);
                System.out.println("Contractor's Address:\t\t\t " + ReadData.architect_address);
                System.out.println("Project Total Fee:\t\t\t\t " + ReadData.tot_fee);
                System.out.println("Project Total Paid to date:\t\t " + ReadData.tot_paid);
                System.out.println("Project Deadline:\t\t\t\t " + ReadData.due_date);
                System.out.println("Project Finalised:\t\t\t\t " + ReadData.completed);
                System.out.println("\n");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

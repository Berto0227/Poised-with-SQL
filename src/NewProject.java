//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewProject {
    //Create a new project class and method. The user is asked a set of questions. The data given by the user is then
    //stored to a variable and saved into and array and written to a file.
    static int project_num;
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
    static String architect_name;
    static String architect_tel;
    static String architect_email;
    static String architect_address;
    static String contract_name;
    static String contract_tel;
    static String contract_email;
    static String contract_address;
    static String completed;

    public static void Register(){

        //The program asks the user a set of questions as seen below.
        project_num = Integer.parseInt(getInput("Please enter the Project Number: "));

        project_name = getInput("Please enter the Project Name: ");

        build_type = getInput("Please enter the Building Type: ");

        project_address = getInput("Please enter the Project's Address: ");

        erf_num = getInput("Please enter the Project's ERF Number: ");

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        due_date = getInput("Please enter the due date for this project(dd/mm/yyyy): ");

        customer_name = getInput("Please enter the name of the customer: ");

        customer_tel = getInput("Please enter the telephone number of the customer: ");

        customer_email = getInput("Please enter the email of the customer: ");

        customer_address = getInput("Please enter the address of the customer: ");

        tot_fee = Double.parseDouble(getInput("Please enter the total price for this Project: "));

        tot_paid = Double.parseDouble(getInput("Please enter the deposit amount: "));

        architect_name = getInput("Please enter the name of the architect: ");

        architect_tel = getInput("Please enter the telephone number of the architect: ");

        architect_email = getInput("Please enter the email of the architect: ");

        architect_address = getInput("Please enter the address of the architect: ");

        contract_name = getInput("Please enter the name of the contractor: ");

        contract_tel = getInput("Please enter the telephone number of the contractor: ");

        contract_email = getInput("Please enter the email of the contractor: ");

        contract_address = getInput("Please enter the address of the contractor: ");

        completed = "NO";

        WriteData.writeProject();
        MainMenu.startMenu();

    }
    //Input method to get users input. Scanner is very unstable compared to inputstreamer.
    private static String getInput(String prompt){
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(prompt);
        System.out.flush();

        try{
            return stdin.readLine();
        } catch (Exception e){
            return "Error: " + e.getMessage();
        }
    }
}
//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UpdateProject {

    //Update any project class and methods. If the user wants to update any of the existing projects it will be done here.
    //Again the user get a display to choose from the following.
    static Scanner sc = new Scanner(System.in);

    public static void updateMenu(){
        System.out.println("**** OPTIONS ****\n1) Change Architect\n2) Change Contractor\n"
                + "3) Change the due date\n4) Update payment\n5) Finalise Project\n6) Return to START MENU\n");
        System.out.println("Please choose one of the following: ");
        int userChoice = sc.nextInt();      //Get user input.

        switch (userChoice) {
            case 1:
                architect();
                updateMenu();
                break;
            case 2:
                contractors();
                updateMenu();
                break;
            case 3:
                dateDue();
                updateMenu();
                break;
            case 4:
                amountPaid();
                updateMenu();
                break;
            case 5:
                projectFinalize();
                updateMenu();
                break;
            case 6:
                MainMenu.startMenu();    //Return to the start of the program.
                break;
        }
    }

    public static void architect() {

        //Replace the changed fields and update the contents of inputFileContent to the data file
        NewProject.architect_name = getInput("Please enter the NEW name of the architect: ");

        NewProject.architect_tel = getInput("Please enter the NEW telephone number of the architect: ");

        NewProject.architect_email = getInput("Please enter the NEW email of the architect: ");

        NewProject.architect_address = getInput("Please enter the NEW address of the architect: ");

        UpdateData.updateArchitect();
        updateMenu();	//Return back to previous menu.
    }

    public static void contractors(){

        //Replace the changed fields and update the contents of inputFileContent to the data file
        NewProject.contract_name = getInput("Please enter the NEW name of the contractor:");

        NewProject.contract_tel = getInput("Please enter the NEW telephone number of the contractor:");

        NewProject.contract_email = getInput("Please enter the NEW email of the contractor:");

        NewProject.contract_address = getInput("Please enter the NEW email of the contractor:");

        UpdateData.updateContractor();
        updateMenu();	//Return back to previous menu.
    }

    public static void dateDue() {

        //Replace the changed fields and update the contents of inputFileContent to the data file
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(date);
        NewProject.due_date = getInput("Please enter the due date for this project(dd/mm/yyyy): ");

        UpdateData.updateDueDate();
        updateMenu();	//Return back to previous menu.
    }

    public static void amountPaid(){

        //Replace the changed fields and update the contents of inputFileContent to the data file
        NewProject.tot_paid = Double.parseDouble(getInput("Please enter NEW amount paid to date: "));

        UpdateData.updatePayment();
        updateMenu();	//Return back to previous menu.

    }

    public static void projectFinalize(){

        NewProject.completed = getInput("Do you wish to mark this project as FINISHED?(Type YES if TRUE): ");

        if (NewProject.completed.equals("YES")){
            UpdateData.updateFinal();
            UpdateData.printInvoice();
        }
        updateMenu();	//Return back to previous menu.
    }
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
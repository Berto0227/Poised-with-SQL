//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.util.Scanner;

public class ProjectInfo {
    static String projectDetails;
    static Scanner sc = new Scanner(System.in);

    public static void ViewInfo(){
        //Display the following screen and allow user to choose on of the following.
        System.out.println("**** OPTIONS ****\n1) View a specific project\n2) View all Projects over due\n"
                + "3) View all Projects\n4) Return to START MENU");
        System.out.println("Please choose one of the following: ");
        int userChoice = sc.nextInt();
        //Based on user choice execute accordingly.
        switch (userChoice) {
            case 1:
                DisplayInfo();
                ViewInfo();

            case 2:
                OverDue();
                ViewInfo();

            case 3:
                DisplayAll();
                ViewInfo();

            case 4:
                MainMenu.startMenu();
                break;
        }
    }

    public static void DisplayInfo(){
        //Display only the project that the user wishes to view.
        ReadData.readProject();
        System.out.println(ScreenDisplay());
    }

    public static void OverDue(){
        //Search the file and display all projects that are overdue.
        ReadData.readDue();
        System.out.println(ScreenDisplay());
    }

    public static void DisplayAll(){
        //Display all the tasks that are saved in the file.
        ReadData.readAll();
    }

    public static String ScreenDisplay() {
        //Display all detail in a professional way.
        projectDetails = "*** Detailed Information about Projects***";
        projectDetails += "\nProject Number:\t\t\t\t\t " + ReadData.project_num;
        projectDetails += "\nProject Name:\t\t\t\t\t " + ReadData.project_name;
        projectDetails += "\nProject Building Type:\t\t\t " + ReadData.build_type;
        projectDetails += "\nProject Address:\t\t\t\t " + ReadData.project_address;
        projectDetails += "\nProject ERF Number:\t\t\t\t " + ReadData.erf_num;
        projectDetails += "\nCustomer's Name:\t\t\t\t " + ReadData.contract_name;
        projectDetails += "\nCustomer's Telephone Number:\t " + ReadData.contract_tel;
        projectDetails += "\nCustomer's Email Address:\t\t " + ReadData.customer_email;
        projectDetails += "\nCustomer's Address:\t\t\t\t " + ReadData.contract_address;
        projectDetails += "\nArchitect's Name:\t\t\t\t " + ReadData.architect_name;
        projectDetails += "\nArchitect's Telephone Number:\t " + ReadData.architect_tel;
        projectDetails += "\nArchitect's Email Address:\t\t " + ReadData.architect_email;
        projectDetails += "\nArchitect's Address:\t\t\t " + ReadData.architect_address;
        projectDetails += "\nContractor's Name:\t\t\t\t " + ReadData.architect_name;
        projectDetails += "\nContractor's Telephone Number:\t " + ReadData.architect_tel;
        projectDetails += "\nContractor's Email Address:\t\t " + ReadData.architect_email;
        projectDetails += "\nContractor's Address:\t\t\t " + ReadData.architect_address;
        projectDetails += "\nProject Total Fee:\t\t\t\t " + ReadData.tot_fee;
        projectDetails += "\nProject Total Paid to date:\t\t " + ReadData.tot_paid;
        projectDetails += "\nProject Deadline:\t\t\t\t " + ReadData.due_date;
        projectDetails += "\nProject Finalised:\t\t\t\t " + ReadData.completed;
        projectDetails += "\n";

        return projectDetails;
    }
}
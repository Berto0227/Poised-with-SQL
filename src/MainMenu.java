//Programmer: Berto Swanepoel
//This program is to show my mentor what i have read and learned for the reading material.

import java.util.Scanner;

public class MainMenu {
    //Display welcome screen and ask user to start by selecting which one of the following option they would like to go to.
    //based on the users choice the program will take them to that specific class and contintue.
    public static void startMenu(){

        System.out.println("Welcome to Poised Project Management.");
        System.out.println
                ("Please choose one of the following:\n1) Add New Project\n2) Update Project\n3) Project Information\n4) Exit\n");

        Scanner sc = new Scanner(System.in);
        int userChoice = sc.nextInt();
        switch (userChoice) {

            case 1:
                NewProject.Register();      //This will ask you to register a new project.

            case 2:
                UpdateProject.updateMenu();         //This will ask you to register a new architect.

            case 3:
                ProjectInfo.ViewInfo();      //This will ask you to register a new contractor.

            case 4:
                System.exit(0);      //This will ask you to register a new customer.

            startMenu();
        }
    }

    //Main Method. Start of the program.
    public static void main(String[] args){

        MainMenu.startMenu();
    }
}
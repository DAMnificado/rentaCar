package org.example.view;

import org.example.controller.ClientController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {

    private ClientController clientController;
    private Scanner scanner;
    public Dialog() {
        clientController = new ClientController();
    }


    public void getStarted(){
        do {
            System.out.println("\n********************** Welcome to Rent A Car *****************************");
            System.out.println("\n\t1. Manage Clients.\t\t\t\t\t4. Manage Models.");
            System.out.println("\n\t2. Manage Cars.\t\t\t\t\t\t5. Manage Rents.");
            System.out.println("\n\t3. Manage Offices.\t\t\t\t\t0. Exit.");
            System.out.println("\n**************************************************************************");
            scanner = new Scanner(System.in);

            try {
                int choice = scanner.nextInt();
                if (choice == 1) {
                    clientManager();
                } else if (choice == 2) {
                    //TODO
                } else if (choice == 3) {
                    //TODO
                } else if (choice == 4) {
                    //TODO
                } else if (choice == 5) {
                    //TODO
                }else if(choice==0) {
                    System.out.println("Bye!!");
                    System.exit(0);;
                } else {
                    System.err.println("[ERROR] Your option is incorrect!! Try again!!");
                }

            } catch (
            InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

    public void clientManager(){
        do {
            System.out.println("\n************************** Client Manager ********************************");
            System.out.println("\n\t1. Create Client.\t\t\t\t4. Search Client.");
            System.out.println("\n\t2. Remove Client.\t\t\t\t5. See All Clients.");
            System.out.println("\n\t3. Update Client.\t\t\t\t0. Back.");
            System.out.println("\n**************************************************************************");
            int choice = scanner.nextInt();
            try {
                if(choice == 1){
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Surname: ");
                    String surname = scanner.nextLine();
                    clientController.add(dni, name, surname);
                } else if (choice == 2) {
                    System.out.println("Client ID: ");
                    int id = scanner.nextInt();
                    clientController.deleteById((long) id);
                } else if (choice == 3) {
                    System.out.println(clientController.findAll());
                    System.out.println("Client ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println("Name: ");
                    String name = scanner.nextLine();
                    System.out.println("Surname: ");
                    String surname = scanner.nextLine();
                    clientController.update((long) id, dni, name, surname);
                } else if (choice == 4) {
                    scanner.nextLine();
                    System.out.println("Dni: ");
                    String dni = scanner.nextLine();
                    System.out.println(clientController.findByDni(dni));
                } else if (choice == 5) {
                    System.out.println(clientController.findAll());
                } else if(choice==0) {
                    getStarted();
            } else {
                System.err.println("[ERROR] Your option is incorrect!! Try again!!");
            }

            } catch (InputMismatchException e) {
                System.err.println("[ERROR] You must type a number!!!");
                scanner.next();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } while (true);
    }

}

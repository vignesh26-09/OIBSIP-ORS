package main;

import java.util.Scanner;
import service.AuthService;
import service.ReservationService;
import service.CancellationService;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AuthService auth = new AuthService();

        System.out.println("===== Online Reservation System =====");

        System.out.print("Enter Username: ");
        String user = sc.next();

        System.out.print("Enter Password: ");
        String pass = sc.next();

        if (!auth.login(user, pass)) {
            System.out.println("Invalid Credentials. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\n==============================");
            System.out.println("   ONLINE RESERVATION SYSTEM  ");
            System.out.println("==============================");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. View Ticket (PNR Search)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    new ReservationService().bookTicket(sc);
                    break;

                case 2:
                    new CancellationService().cancelTicket(sc);
                    break;

                case 3:
                    new ReservationService().searchTicket(sc);
                    break;

                case 4:
                    System.out.println("Thank you for using the system!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
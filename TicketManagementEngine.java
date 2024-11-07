import java.util.Scanner;

public class TicketManagementEngine {

    private static final Scanner keyboard= new Scanner(System.in);

    public static void main(String[] args){

        TicketManagementEngine tme = new TicketManagementEngine();
        tme.displayMessage();
        if (args.length != 4 || Integer.parseInt(args[0]) <=0 || Integer.parseInt(args[1]) <=0 || Integer.parseInt(args[2]) <=0 || Integer.parseInt(args[3]) <=0) {
            System.out.println("Invalid Inputs to set layout. Exiting the program now.");
            // return;
            System.exit(1);
        }
        tme.mainList();

        // write your code here
        int option = keyboard.nextInt();
        
        
        boolean bool = true;
        while(bool){
            switch (option){
                case 1:
                    tme.showTimings();
                    tme.mainList();
                    System.out.println(" Goodbye from the Ticket Management System! See you next time!");
                    option = keyboard.nextInt();
                    bool = false;
                    break;
                case 2:
                    tme.showCost();
                    tme.mainList();
                    bool = false;
                    System.out.println(" Goodbye from the Ticket Management System! See you next time!");
                    break;
                case 3:
                    Venue venue = new Venue();
                    venue.seatLayout(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                    tme.mainList();
                    bool = false;
                    System.out.println(" Goodbye from the Ticket Management System! See you next time!");
                    break;

                case 4:
                    keyboard.nextLine();
                    Venue venue1 = new Venue();
                    venue1.TicketBooking(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
                            String move;
                            System.out.println(" Continue to the seat selection! ");
                            System.out.println("You can select the seat that are empty and marked by _");
                            do {
                                venue1.displaySeat();
                                System.out.println("Press W to move up.");
                                System.out.println("Press A to move left.");
                                System.out.println("Press S to move down.");
                                System.out.println("Press D to move right.");
                                System.out.println("Press Q to exit");
                                move = keyboard.nextLine();
                                if (move.equalsIgnoreCase("q")) {
                                    System.out.println("> Your seat selection is saved.");
                                    tme.mainList();
                                    System.out.print(" ");
                                    venue1.displaySeat();
                                    tme.mainList();
                                    break;
                                } else {
                                    System.out.print("> ");
                                    venue1.moveSeat(move.charAt(0));
                                }
                                    } while (true);
                                keyboard.close();
                case 5:
                    System.out.println(" Goodbye from the Ticket Management System! See you next time!");
                    bool = false;
                    break;
                default:
                    System.out.println("Invalid Input.");
                    tme.mainList();
                    option = keyboard.nextInt();
                    break;
                
            }
            
        }

    }



    public void showTimings() {
        System.out.println(" Show Timings");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-30s%10s\n","Date", "Artist Name", "Timing","Venue Name","Total Seats"); //complete the code here);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-30s%10s\n","2024-05-01", "Taylor Swift", "1700 - 2100","Melbourne Cricket Ground","100"); //complete the code here);
        System.out.printf("%-15s%-15s%-15s%-30s%10s\n","2024-05-02", "Taylor Swift", "1700 - 2100","Melbourne Cricket Ground","100"); //complete the code here);
        System.out.printf("%-15s%-15s%-15s%-30s%10s\n","2024-05-03", "Taylor Swift", "1700 - 2100","Melbourne Cricket Ground","100"); //complete the code here);
        System.out.println("----------------------------------------------------------------------------------------");

    }

    public void showCost() {
        System.out.println(" Seat Costs");
        System.out.println("--------------------");
        System.out.printf("%-13s%-1s\n","Left Zone:", "AUD 200");
        System.out.printf("%-13s%-1s\n","Right Zone:", "AUD 200");
        System.out.printf("%-13s%-1s\n","Middle Zone:", "AUD 500");
        System.out.println("--------------------");

    }



    public void displayMessage(){
        System.out.println("Welcome to a revised version of Taylor Swift's Eras tour.");
    }
    public void mainList(){
        System.out.println("Select an option to get started!");
        System.out.println("Press 1 to look at the show timings");
        System.out.println("Press 2 to look at the ticket costs");
        System.out.println("Press 3 to view the layout of the concert");
        System.out.println("Press 4 to book a seat");
        System.out.println("Press 5 to exit");
        System.out.print(">");
    }
}
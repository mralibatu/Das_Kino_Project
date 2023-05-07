import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Movie movie1 = new Movie("Bur","lee",2018,148);
        Movie m2 = new Movie("Spr","hayo",2001,125);

        Hall h1 = new Hall(1,50);
        Hall h2 = new Hall(2,20);

        Session s2 = new Session(movie1,h2,"Monday","15:00");

        Client c1 = new Client("Batuhan",25,111253614);
        Client c2 = new Client("Hediye",23,121253614);
        Client c3 = new Client("Akif",15,121425263);


        Reservation r1 = new Reservation(s2,c1,numOfTickets(c1));
        r1.createReservation(r1);

        Reservation r2 = new Reservation(s2,c2,numOfTickets(c2));
        r2.createReservation(r2);

        Reservation r3 = new Reservation(s2,c3,numOfTickets(c3));
        r3.createReservation(r3);

    }

    public static int numOfTickets(Client c){
        Scanner input = new Scanner(System.in);
        System.out.println("Hello Dear " + c.getName() + " your membership status is " + c.checkMembership(c.getMember_id()));
        System.out.print("Enter number of tickets that you want to book : ");
        return input.nextInt();
    }
}

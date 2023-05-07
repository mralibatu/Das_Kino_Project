import java.util.Random;
import java.util.Scanner;

public class Reservation {
    private Session session;
    private Client client;
    private int cost;
    private int ticketPrice = 100;
    private int numOfTickets;
    private int[] seatsBooked;

    public Reservation() {
    }

    public Reservation(Session session, Client client, int numOfTickets) {
        this.session = session;
        this.client = client;
        this.numOfTickets = numOfTickets;
        seatsBooked = new int[numOfTickets];
    }

    public Reservation bookASeatRandom(Reservation reservation, int numOfTickets){
        Random rnd = new Random();
        for (int i = 0; i < numOfTickets; i++) {
            int randomNumber = 0;
            do{
                randomNumber = rnd.nextInt(this.session.getCapacity());
            }
            while(this.session.getSeats()[randomNumber] == 'B');
            this.session.getSeats()[randomNumber] = 'B';
            seatsBooked[i] = randomNumber;
        }
        return reservation;
    }
    public Reservation bookASeatBySeatNumber(Reservation reservation, int numOfTickets, int[] wantedSeats){
        for (int i = 0; i < numOfTickets; i++) {
            reservation.session.getSeats()[wantedSeats[i]] = 'B';
        }
        seatsBooked = wantedSeats;
        return reservation;
    }

    public void createReservation(Reservation reservation){

        if(this.client.checkMembership(this.client.getMember_id())){
            int[] wantedSeats = new int[reservation.numOfTickets];
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the seat number of tickets that you wanna book between 0 to " + reservation.session.getCapacity());
            for (int i = 0; i < numOfTickets; i++) {
                int seatNumber = input.nextInt();
                wantedSeats[i] = seatNumber;
            }

            bookASeatBySeatNumber(reservation,reservation.numOfTickets,wantedSeats);
            cost = calculateCost(reservation);

            System.out.println("Your reservation to " + reservation.session.getMovie() + " on " + reservation.session.getDay() +
                    " at " + reservation.session.getTime() + " for " + reservation.numOfTickets + " people is successfully made.");
            System.out.println("Your seat numbers are : ");
            for (int i = 0; i < seatsBooked.length; i++) {
                System.out.println(seatsBooked[i]);
            }
            System.out.println("Your ticket cost is: " + reservation.cost);
        }else{
            bookASeatRandom(reservation,reservation.numOfTickets);
            cost = calculateCost(reservation);

            System.out.println("Your reservation to " + reservation.session.getMovie() + " on " + reservation.session.getDay() +
                    " at " + reservation.session.getTime() + " for " + reservation.numOfTickets + " people is successfully made.");
            System.out.println("Your ticket numbers : ");
            for (int i = 0; i < seatsBooked.length; i++) {
                System.out.println(seatsBooked[i]);
            }
            System.out.println("Your ticket cost is: " + reservation.cost);
        }
    }

    public int calculateCost(Reservation reservation){

        if(reservation.client.checkMembership(reservation.client.getMember_id())){
            return ((reservation.seatsBooked.length * ticketPrice) * 80) / ticketPrice;
        }else{
            if(reservation.client.getAge() < 18){
                return ((reservation.seatsBooked.length * ticketPrice) * 95) / ticketPrice;
            }else{
                return reservation.seatsBooked.length * ticketPrice;
            }
        }
    }
}

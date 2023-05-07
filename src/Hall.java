public class Hall {
    private int hall_id;
    private int capacity;
    private char[] seats;

    public Hall(){

    }

    public Hall(int hall_id, int capacity) {
        this.hall_id = hall_id;
        this.capacity = capacity;
        this.seats = new char[capacity];
        fillHallUnbooked(this.getSeats());
    }

    public void fillHallUnbooked(char[] seats){
        for (int i = 0; i < seats.length; i++) {
            seats[i] = 'U';
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public char[] getSeats() {
        return seats;
    }
}

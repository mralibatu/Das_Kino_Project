public class Session {
    private Movie movie;
    private Hall hall;
    private String day;
    private String time;

    public Session(){

    }

    public Session(Movie movie, Hall hall, String day, String time) {
        this.movie = movie;
        this.hall = hall;
        this.day = day;
        this.time = time;
    }

    public int getCapacity(){
        return this.hall.getCapacity();
    }

    public char[] getSeats(){
        return this.hall.getSeats();
    }

    public Movie getMovie() {
        return movie;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
}

package model;

public class Reservation {

    public String pnr;
    public Passenger passenger;
    public int trainNo;
    public String trainName;
    public String classType;
    public String from;
    public String to;
    public String date;

    public Reservation(String pnr, Passenger passenger, int trainNo, String trainName,
                       String classType, String from, String to, String date) {
        this.pnr = pnr;
        this.passenger = passenger;
        this.trainNo = trainNo;
        this.trainName = trainName;
        this.classType = classType;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    public String toString() {
        return pnr + "," + passenger.name + "," + passenger.age + "," + passenger.gender + "," +
               trainNo + "," + trainName + "," + classType + "," + from + "," + to + "," + date;
    }
}
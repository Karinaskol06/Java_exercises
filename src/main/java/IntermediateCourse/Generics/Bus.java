package IntermediateCourse.Generics;

//bus can carry school person or any of its subclasses
//generic type <T> ensures that the bus is specifically associated with one type of SchoolPerson
public class Bus <T extends SchoolPerson>{
    private T rider;

    public Bus(T rider) {
        this.rider = rider;
    }

    public T getRider() {
        return rider;
    }
    public void setRider(T rider) {
        this.rider = rider;
    }

    public void printRider(){
        System.out.println(rider.toString());
    }
}

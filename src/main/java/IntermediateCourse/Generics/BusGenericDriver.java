package IntermediateCourse.Generics;

public class BusGenericDriver {
    public static void main(String[] args) {

        //creating instances of classes
        SchoolPerson person = new SchoolPerson("Peter");
        Teacher teacher1 = new Teacher("Regina", "Philosophy");
        Student student1 = new Student("Karina", "Literature");

        //creating instances of buses for every type of person
        Bus<SchoolPerson> busWPerson = new Bus<>(person);
        Bus<Teacher> busTeacher = new Bus<>(teacher1);
        Bus<Student> busStud = new Bus<>(student1);

        //calling methods which Bus class contains
        busWPerson.printRider();
        busTeacher.printRider();
        busStud.printRider();

        System.out.println();

        transferData(busStud, busWPerson);
    }

    //changing student and other school person
    //extends Student because we are reading
    //super SchoolPerson because we are writing
    public static void transferData(Bus<? extends Student> src, Bus<? super SchoolPerson> dsc) {
        System.out.print("dsc bus rider before switch: ");
        dsc.printRider();
        Student studentInSrcBus = src.getRider();
        System.out.print("dsc bus rider after switch: ");
        dsc.setRider(studentInSrcBus);
        dsc.printRider();
    }
}

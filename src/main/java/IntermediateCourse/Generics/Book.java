package IntermediateCourse.Generics;

//non-generic class as it takes String as a parameter for Retriever, and not T
public class Book implements Retriever<String>{
    private String name;

    public Book(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    //non-generic so datatype is already defined
    @Override
    public String retrieveData(){
        return this.name;
    }
}
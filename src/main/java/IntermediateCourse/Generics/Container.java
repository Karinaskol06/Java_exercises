package IntermediateCourse.Generics;

//generic class
public class Container<T> implements Retriever<T>{
    private T data;

    public Container(T data) {
        this.data = data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    //generic, so the data type is defined when instantiating
    @Override
    public T retrieveData(){
        return this.data;
    }
}
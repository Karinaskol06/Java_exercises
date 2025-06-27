package AlgorithmsJava;

class Queue{
    char[] q; //array which consists of chars
    private int putspot, getspot; //where the next elements will be stored and obtained

    Queue(int qSize){
        this.q = new char[qSize]; //creating new queue with given size
        putspot = getspot = 0; //first index
    }

    Queue(Queue obj){
        q = new char[obj.q.length];
        putspot = obj.putspot;
        getspot = obj.getspot;

        for(int i = getspot; i < putspot; i++){
            q[i] = obj.q[i];
        }
    }

    Queue(char[] a) {
        putspot = 0;
        getspot = 0;
        q = new char[a.length];
        for(int i = 0; i < a.length; i++) putMeth(a[i]);
    }

    void putMeth(char element){
        if (putspot == q.length){ //if a place to put is the same as longevity, then there are no space
            System.out.println("Queue is full");
            return;
        }
        q[putspot] = element; //insert element to the index of putspot in queue
        putspot++;
    }

    char getMeth(){
        if (putspot == getspot){ //if the first place equals the last place, then the queue is empty
            System.out.println("Queue is empty");
            return (char) 0;
        }
        return q[getspot++];
    }
}

public class QDemo {
    public static void main(String[] args) {
        Queue alphQ = new Queue(26);
        Queue errQ = new Queue(4);
        char el;

        System.out.println("***Filling the queue with elements***");
        for(int i = 0; i < 26; i++){
            alphQ.putMeth((char) ('A' + i));
        }

        System.out.println("Retrieving elements from the queue: ");
        for(int i = 0; i < 26; i++){
            el = alphQ.getMeth();
            if (el != 0) System.out.print(el + " ");
        }

        System.out.println("\n");

        System.out.println("***Filling smaller queue***");
        for(int i = 0; i < 4; i++){
            errQ.putMeth((char) ('Z' - i));
        }

        System.out.println("Retrieving elements from the smaller queue: ");
        for(int i = 0; i < 4; i++){
            el = errQ.getMeth();
            if (el != (char) 0) System.out.print(el + " ");
        }
    }
}

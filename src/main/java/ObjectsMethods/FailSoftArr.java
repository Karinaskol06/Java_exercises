package ObjectsMethods;

class ArrClass{
    private int[] arr; //create array of 5 elements
    private int errVal = 404; //error value
    int len;

    ArrClass(int size){ //constructor with parameter size to create an array
        arr = new int[size];
        len = size;
    }

    public int getVal(int indget){ //getter with param index
        if (indexOK(indget)) return arr[indget]; //checks if the output of the function is true
        //if so, returns the value at index ind
        return errVal; //otherwise returns 404
    }

    public boolean setVal(int indset, int val){
        if (indexOK(indset)){
            arr[indset] = val; //setting the value of val at the index ind
            return true; //boolean function returns true
        }
        return false; //if value wasn't put returns false
    }

    private boolean indexOK(int indok){ //indexOK method with param ind
        //checking index
        return indok >= 0 && indok < arr.length; //if the conditions are valid it automatically returns true
    }
}

//main class
class FailSoftArr {
    public static void main(String[] args) {
        ArrClass newArr = new ArrClass(6);
        int temp = 0; //auxiliary variable

        for (int i = 0; i < (newArr.len + 3); i++) { //there must be 3 out-of-bounds
            newArr.setVal(i, i + 11);
        }
        for (int i = 0; i < (newArr.len + 3); i++) {
            temp = newArr.getVal(i);
            if (temp != 404) System.out.print(newArr.getVal(i) + " ");
        }

        System.out.println(" ");

        for (int i = 0; i < (newArr.len + 3); i++) {
            if (!newArr.setVal(i, i + 11)) {
                System.out.println(i + " out of bound");
            }
        }
    }
}

/*
class FailSoftArray {
    private int[] a; // reference to array
    private int errval = 404; // value to return if get() fails
    public int length; // length is public


    //Construct array given its size and the value to
    //return if get() fails.
    public FailSoftArray(int size) {
        a = new int[size]; //create a new array
        length = size;
    }


    // Return value at given index.
    public int get(int index) {
        if(indexOK(index)) return a[index];
        return errval;
    }


    // Put a value at an index. Return false on failure.
    public boolean put(int index, int val) {
        if(indexOK(index)) {
            a[index] = val;
            return true;
        }
        return false;
    }


    // Return true if index is within bounds.
    private boolean indexOK(int index) {
        if(index >= 0 & index < length) return true;
        return false;
    }
}


// Demonstrate the fail-soft array.
class FailSoftArr {
    public static void main(String[] args) {
        FailSoftArray fs = new FailSoftArray(5);
        int x;

        // show quiet failures
        System.out.println("Fail quietly.");
        for(int i=0; i < (fs.length * 2); i++)
            fs.put(i, i*10); //generates values (right and wrong ones) and adds to the array right ones
        for(int i=0; i < (fs.length * 2); i++) {
            x = fs.get(i); //retrieves values and separates them from 404 mistakes out of bound
            if(x != 404) System.out.print(x + " ");
        }
        System.out.println();


        // now, handle failures
        System.out.println("\nFail with error reports.");
        for(int i=0; i < (fs.length * 2); i++)
            if(!fs.put(i, i*10)) //adding values on indices 0 to 4
                System.out.println("Index " + i + " out-of-bounds"); //displayed when index > 4

        System.out.print("\nArray within the bounds: ");
        for(int i=0; i < (fs.length * 2); i++) {
            x = fs.get(i);
            if(x != 404) System.out.print(x + " ");
        }
    }
}*/


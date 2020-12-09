package assigment6;

class testing {
    public static class Test<T> 
{ 
    // An object of type T is declared 
    T obj; 
    Test(T obj) {  this.obj = obj;  }  // constructor 
    public T getObject()  { return this.obj; } 
} 
   
        public static void main (String[] args) 
        { 
            // instance of Integer type
            var outerClass = new testing(); 
            Test <Integer> iObj = Test<Integer>(15); 
            System.out.println(iObj.getObject()); 
    
            // instance of String type 
            Test <String> sObj = 
                            new Test<String>("GeeksForGeeks"); 
            System.out.println(sObj.getObject()); 
        } 
    }


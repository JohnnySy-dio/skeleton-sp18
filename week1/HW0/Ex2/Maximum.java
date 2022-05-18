

public class Maximum {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int n = 0;
        for(int i = 0; i < m.length; i++){
            if(n < m[i])
            n = m[i];
        }
        return n;
    }
    public static void main(String[] args) {
        
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};      
       System.out.print(max(numbers));
    }
}

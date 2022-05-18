public class Triangle {
    public static void DisplayTriangle(int n){
    
       for(int i = 1; i <= n ;i++){
        for(int j = 0; j < i ;j++){

        System.out.print('*');

        }
        System.out.print('\n');
    }
    }
    public static void main (String[] args)
    {
        DisplayTriangle(12);
    }
}
import java.util.Arrays;

public class discussion3_2 {
    public static int[] flatten(int[][] x){
        int totalLength = 0;
        for(int i = 0; i < x.length; i++){
            totalLength += x[i].length;
        }
        int [] a = new int[totalLength];
        int aIndex = 0;

        for(int i = 0 ; i < x.length; i++){
            for(int j = 0; j < x[i].length; j++){
                Integer value = Integer.valueOf(x[i][j]);
                if(value != null){
                    a[aIndex] = x[i][j];
                    aIndex++;
                }
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[][] input = {{1, 2, 3},{},{7,8}};
        System.out.println(Arrays.toString(flatten(input)));
    }
}

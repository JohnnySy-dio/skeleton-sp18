import java.math.BigInteger;

/**
 * Created by jug on 1/22/18.
 */
public class DebugExercise3 {
    public static BigInteger countTurnips(In in) {
        BigInteger totalTurnips = new BigInteger("0");
        while (!in.isEmpty()) {
            String vendor = in.readString();
            String foodType = in.readString();
            double cost = in.readDouble();
            Integer num_test = in.readInt();
            BigInteger num1 = new BigInteger(Integer.toString(num_test));
            BigInteger Max = new BigInteger("2147483647");
            BigInteger numAvailable = new BigInteger(Integer.toString(num_test));
            if (num_test < 0)
               numAvailable = Max.subtract(num1);

            if (foodType.equals("turnip")) {
                totalTurnips = totalTurnips.add(numAvailable);
            }
            in.readLine();
        }
        return totalTurnips;
    }

    public static void main(String[] args) {
        In in = new In("foods.csv");
        System.out.println(countTurnips(in));
    }
}

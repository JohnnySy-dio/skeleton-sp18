public class OffByN implements CharacterComparator{
    private int number;
    public OffByN(int N) {
        this.number = N;
    }
    @Override
    public boolean equalChars(char x, char y){
        return Math.abs(x - y) == number;
    }


}

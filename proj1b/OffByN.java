public class OffByN implements CharacterComparator{
    private int number;
    @Override
    public boolean equalChars(char x, char y){
        int value = Character.valueOf(x) - Character.valueOf(y);
        return value == number|| value == -number;
    }

    public OffByN(int N){
        number = N;
    }
}

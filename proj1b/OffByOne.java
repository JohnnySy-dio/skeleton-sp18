public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
       Character x1 = Character.valueOf(x);
       Character y1 = Character.valueOf(y);
       return x1.equals(y1);
    }
}

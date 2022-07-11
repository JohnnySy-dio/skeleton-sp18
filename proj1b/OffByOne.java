public class OffByOne implements CharacterComparator{
    @Override
    public boolean equalChars(char x, char y) {
        int value = Character.valueOf(x) - Character.valueOf(y);
        return value == 1 || value == -1;
    }


}

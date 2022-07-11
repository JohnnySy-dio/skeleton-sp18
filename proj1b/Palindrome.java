
public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> dq = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++){
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    public boolean isPalindrome(String word){
       Deque<Character> P = wordToDeque(word);
       String actual = "";

        if (word == null || word.length() <= 1) {
        return true;
    }
       for (int i = 0; i < word.length();i++){
           actual += P.removeLast();
       }
      return word.equals(actual);
    }

    public boolean isPalindrome(String word, CharacterComparator cc){

        for (int i = 0; i < word.length()/2; i++){
            if (!cc.equalChars(word.charAt(i),word.charAt(word.length()-i-1))){
                return false;
            }
        }
        return true;
    }
//    public boolean isPalindrome(String word) {
//        if (word == null || word.length() <= 1) {
//            return true;
//        }
//        int len = word.length();
//        for (int i = 0; i < len / 2; i++) {
//            if (word.charAt(i) != word.charAt(len - i - 1)) {
//                return false;
//            }
//        }
//        return true;
//}
}

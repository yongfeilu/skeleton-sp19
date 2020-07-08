/** This class outputs all palindromes in the words file in the current directory. */
public class PalindromeFinder {



    public static void main(String[] args) {
        CharacterComparator cc = new OffByN(3);
        int minLength = 4;
        In in = new In("../library-sp19/data/words.txt");
        Palindrome palindrome = new Palindrome();

        System.out.println("With CharacterComparator: OffByOne");
        while (!in.isEmpty()) {
            String word = in.readString();
            if (word.length() >= minLength && palindrome.isPalindrome(word, cc)) {
                System.out.println(word);
            }
        }

//        System.out.println();
//        System.out.println("Standard");
//        while (!in.isEmpty()) {
//            String word = in.readString();
//            if (word.length() >= minLength && palindrome.isPalindrome(word)) {
//                System.out.println(word);
//            }
//        }

    }
}
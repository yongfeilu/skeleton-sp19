public class Palindrome {


    public Deque<Character> wordToDeque(String word) {

        Deque<Character> returnDeque = new LinkedListDeque<>();
        if (word == null) {
            return  returnDeque;
        }
        for (int i = 0; i < word.length(); i++) {
            returnDeque.addLast(word.charAt(i));
        }
        return returnDeque;
    }


    public boolean isPalindrome(String word) {
        Deque<Character> wordDeque= wordToDeque(word);
        return isDequePalindrome(wordDeque);

        /* iteratively
        while (wordDeque.size() > 1) {
            Character first = wordDeque.removeFirst();
            Character last = wordDeque.removeLast();
            if (first != last) {
                return false;
            }
        }
        return true; */
    }

    private boolean isDequePalindrome(Deque<Character> wordDeque) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        Character first = wordDeque.removeFirst();
        Character last = wordDeque.removeLast();
        return (first == last) && isDequePalindrome(wordDeque);

    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> wordDeque= wordToDeque(word);
        return isDequePalindrome(wordDeque, cc);

    }

    private boolean isDequePalindrome(Deque<Character> wordDeque, CharacterComparator cc) {
        if (wordDeque.size() <= 1) {
            return true;
        }
        Character first = wordDeque.removeFirst();
        Character last = wordDeque.removeLast();
        return (cc.equalChars(first, last)) && isDequePalindrome(wordDeque, cc);
    }
}

public class OffByOne implements CharacterComparator {


    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }

    public static void main(String[] args) {
    }


}



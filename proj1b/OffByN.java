public class OffByN implements CharacterComparator {
    private int offN;

    public OffByN(int N) {
        offN = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        return Math.abs(diff) == offN;
    }

    public static void main(String[] args) {
        CharacterComparator offBy5 = new OffByN(5);
        System.out.print(offBy5.equalChars('a', 'f'));
    }
}

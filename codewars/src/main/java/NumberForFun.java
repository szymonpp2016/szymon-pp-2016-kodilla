public class NumberForFun {
    private static long findNextSquare(long sq) {
        long result=0L;
        double findNextSquareDouble = Math.sqrt((double) sq);
        int findNextSquareInt = (int) Math.sqrt((double) sq);
        return findNextSquareDouble == findNextSquareInt ? (long) Math.pow(findNextSquareInt + 1, 2) :  -1L;
    }

    public static void main(String[] args) {
        System.out.println(findNextSquare(121));
    }

    //best answer
    public class NumberFunBest {
        public long findNextSquare(long sq) {
            long root = (long) Math.sqrt(sq);
            return root * root == sq ? (root + 1) * (root + 1) : -1;
        }
    }
}


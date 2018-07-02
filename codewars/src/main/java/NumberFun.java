public class NumberFun {


    private static long findNextSquare(long sq) {
        int result;
        double findNextSquareDouble = Math.sqrt((double) sq);
        int findNextSquareInt = (int) Math.sqrt((double) sq);
        if (findNextSquareDouble == findNextSquareInt) result = (int) Math.pow(findNextSquareInt + 1, 2);
        else result = -1;
        return result;
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
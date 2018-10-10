public class testPraca {

    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {

    if (items <0) throw new UnsupportedOperationException("Waiting to be implemented.");
        {

            int tempPacked = items - availableLargePackages * 6;
            if (tempPacked > 0) {
                return availableLargePackages + tempPacked;
            } else {
                int tempDivine = items / 5;
                return tempDivine + items - tempDivine;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(minimalNumberOfPackages(16, 2, 10));
    }
}



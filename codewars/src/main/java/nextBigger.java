import java.util.*;

public class nextBigger {

    public static long nextBiggerNumber(long n) {
        String word = Long.toString(n);
        int wordLenght = word.length();
        int wordEnd;
        if (wordLenght < 5) wordEnd = wordLenght;
        else wordEnd = wordLenght - 5;
        String wordtmp1 = word.substring(0, wordEnd);
        String wordtmp2 = word.substring(wordEnd, wordLenght);

        ArrayList<String> arrayStringList = new ArrayList<>(word.length());
        ArrayList<String> temparrayStringList;
        ArrayList<String> temparrayStringList2;
        ArrayList<String> temparrayStringListShort = new ArrayList<>(wordtmp2.length());
        List<Long> newTemporaryList = new ArrayList<>();

        Random random = new Random();
        Long answer;
        int randomNumber;

        for (int i = 0; i < word.length(); i++) {
            arrayStringList.add(word.substring(i, i + 1));
        }

        for (int i = 0; i < 100000; i++) {
            temparrayStringList = (ArrayList<String>) arrayStringList.clone();
            String biggerNumber = "";
            for (int a = 0; a < word.length(); a++) {
                randomNumber = random.nextInt(temparrayStringList.size());
                biggerNumber += temparrayStringList.get(randomNumber);
                temparrayStringList.remove(randomNumber);
            }
            if (Long.parseLong(biggerNumber) > n) {
                newTemporaryList.add(Long.parseLong(biggerNumber));
            }
        }

        for (int i = 0; i < wordtmp2.length(); i++) {
            temparrayStringListShort.add(wordtmp2.substring(i, i + 1));
        }

        for (int i = 0; i < 1000; i++) {
            temparrayStringList2 = (ArrayList<String>) temparrayStringListShort.clone();
            String biggerNumber = "";
            for (int a = 0; a < wordtmp2.length(); a++) {
                randomNumber = random.nextInt(temparrayStringList2.size());
                biggerNumber += temparrayStringList2.get(randomNumber);
                temparrayStringList2.remove(randomNumber);
            }
            if (Long.parseLong(wordtmp1 + biggerNumber) > n) {
                newTemporaryList.add(Long.parseLong(wordtmp1 + biggerNumber));
            }
        }

        if (newTemporaryList.isEmpty()) {
            answer = Long.valueOf(-1);
        } else {
            answer = Collections.min(newTemporaryList);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(nextBiggerNumber(1782109079));
    }


    //best
    public static long nextBiggerNumberBEST (long n) {
        char[] digits = String.valueOf(n).toCharArray();
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] > digits[i - 1]) {
                int nBiggerIndex = i;
                for (int j = digits.length - 1; j > i; j--) {
                    if (digits[j] > digits[i - 1]) {
                        nBiggerIndex = j;
                        break;
                    }
                }
                char temp = digits[nBiggerIndex];
                digits[nBiggerIndex] = digits[i - 1];
                digits[i - 1] = temp;
                Arrays.sort(digits, i, digits.length);
                return Long.parseLong(new String(digits));
            }
        }
        return -1;
    }
}
import java.util.Arrays;

public class FindOutlier {

    private static int find(int[] integers) {

        int even[] = Arrays.stream(integers)
                .filter(s->s%2==0)
                .toArray();

        int odd[] = Arrays.stream(integers)
                .filter(s->s%2!=0)
                .toArray();

        return even.length==1? even[0]: odd[0];
    }

    public static void main(String[] args) {
        int[] integers ={2, 4, 0, 100, 4, 11, 2602, 36};
        System.out.println(find(integers));
    }
}

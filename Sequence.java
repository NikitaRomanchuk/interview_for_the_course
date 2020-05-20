import java.util.Scanner;

/**
 * @author Nikita Romanchuk
 * Test task
 * KPFU, ITIS Higher School
 * 11-905
 */

public class Sequence {
    public static void main(String[] args) {
        Sequence s = new Sequence();
        StringBuilder str = new StringBuilder("1");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of the last item");
        int n = sc.nextInt();

        System.out.println(str);
        for (int i = 0; i < n; i++) {
            str = s.sequence(str);
            System.out.println(str);
        }
    }

    public StringBuilder sequence(StringBuilder str) {
        StringBuilder temp = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        int i = 0;
        int k = 1;
        boolean entrance = false;
        int COUNT = str.length();

        if (COUNT == 1) return answer.append(1).append(str);

        while (i != COUNT) {
            if (k < COUNT) {
                while (str.charAt(i) == str.charAt(k)) {
                    temp.append(str.charAt(k - 1));
                    if (k + 1 < COUNT) k++;
                    else {
                        temp.append(str.charAt(k - 1));
                        i = k + 1;
                        k = k + 2;
                        entrance = true;
                        break;
                    }
                }
            }

            i = i + 1 < k ? k - 1 : i;
            if (!entrance) {
                temp.append(str.charAt(i));
                i++;
                k++;
            }
            if (temp.length() > 1) {
                answer.append(temp.length()).append(temp.charAt(0));
            } else {
                answer.append(1).append(temp.charAt(0));
            }

            temp.setLength(0);
            entrance = false;
        }
        return answer;
    }
}

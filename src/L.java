import java.util.*;

public class L {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        sc.nextLine();
        List<Integer> reinos = new ArrayList<Integer>();
        String[] temp = sc.nextLine().split(" ");
        for (int i = 0; i < size; i++){
            reinos.add(Integer.parseInt(temp[i]));
        }
        temp = sc.nextLine().split(" ");
        for (int i = 0; i < size; i++){
            reinos.add(Integer.parseInt(temp[i]));
        }
        //System.out.println(reinos);

        Collections.sort(reinos);
        //System.out.println(reinos);

        System.out.println(
                ((double) reinos.get(size-1) + (double) reinos.get(size))/2
        );
    }
}

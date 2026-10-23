import java.util.Arrays;

public class Main {

    static void changeInt(int x){
        x = 100;
    }

    static void changeName(StringBuilder sb){
        sb.append("world");
    }

    static void reassign(StringBuilder sb){
        sb = new StringBuilder("new");
    }

    static void changeArray(int[] arr){
        arr[0] = 999;
    }

    public static void main(String[] args) {
        int num = 10;
        changeInt(num);
        System.out.println("int after : "+num);

        StringBuilder sb = new StringBuilder("Hello");
        changeName(sb);
        System.out.println("sb after : "+sb);

        reassign(sb);
        System.out.println("sb reassigned : "+sb);

        int[] arr = {1,2,3};
        changeArray(arr);
        System.out.println("arr[0] : "+arr[0]);
        System.out.println("arr : "+Arrays.toString(arr));
    }
}

public class Main {
    static int case1(){
        try {
            return 10;
        } finally {
            return 20;
        }
    }

    static int case2(){
        try {
            throw new RuntimeException("original");
        } finally {
            throw new IllegalStateException("from finally");
        }
    }

    static int case3(){
        int x = 10;
        try {
            return x;
        } finally {
            x = 20;
        }
    }

    static void case4(){
        try {
            System.out.println("try");
            System.exit(0);
        } finally {
            System.out.println("finally (won't print)");
        }
    }

    static int case5(){
        try{
            return 100;
        }finally{
            System.out.println("finally runs before return");
        }
    }

    static void case6(){
        try {
            throw new RuntimeException("boom");
        } catch (RuntimeException e) {
            System.out.println("Caught: "+e.getMessage());
        } finally {
            System.out.println("Finally after caught");
        }
    }

    public static void main(String[] args) {
        System.out.println("Case1: "+case1());

        try {
            System.out.println("Case2: "+case2());
        } catch (Exception e) {
            System.out.println("Case2 Caught: "+e.getMessage());
        }

        System.out.println("Case 3: "+case3());

        System.out.println("Case 4: Skips JVM");
        //case4();

        System.out.println("Case 5: "+case5());

        System.out.println("Case 6: ");
        case6();
    }
}

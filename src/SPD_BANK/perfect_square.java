package SPD_BANK;

public class perfect_square {
    public static void main(String[] args) {
        System.out.println(isPerfectSquare(2147483647));
        //System.out.println(isPerfectSquare(26));
    }

    public static boolean isPerfectSquare(int num) {
        if(num == 0)
            return true;

        if(num == 1)
            return true;

        long l = 1;
        long r = num-1;
        long m = 0;

        while(l <= r){

            m = (l + r) >> 1;

            if(m*m == num){
                return true;
            }

            if(m*m > num){
                r = m - 1;
            }else{
                l = m + 1;
            }
        }

        return false;
    }
}


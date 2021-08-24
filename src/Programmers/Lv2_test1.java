package programmers;

public class Lv2_test1 {
    public static void main(String[] args) {
        long answer = 0;

        int a = 3;
        int b = 5;
        
        int max = Math.max(a, b);
        int min = Math.min(a, b);

        for (int i=min; i<=max; i++) {
            answer += i;
        }
        System.out.println(answer);
    }
}
//1774919424

/*
    public long solution(int w, int h) {
        long answer = 0;

        if (h<w) {
            int temp = w;
            w = h;
            h = temp;
        }

        long total = w*h;
        long unit = (long)Math.ceil((double)h/w);
        System.out.println(unit);
        long waste = unit*w;

        answer = total-waste;

        return answer;
    }
 */

/*
    public long solution(int w, int h) {
        int answer;
		int gcd = getGcd(w,h);

		if(gcd == 1){
			answer = w + h - 1;
		}else {
			answer = w + h - gcd;
		}

		return w*h - answer;
    }

    private static int getGcd(int a, int b){
		BigInteger num1 = BigInteger.valueOf(a);
		BigInteger num2 = BigInteger.valueOf(b);
		BigInteger gcd = num1.gcd(num2);
		return gcd.intValue();
	}
 */
//1774919424
//1774919424


/*

public long solution(int w, int h) {
        long answer=0;
        long min = (long)h;
		long max = (long)w;
		if (w < h) {
			min = (long)w;
			max = (long)h;
		}

		long value = 1;
		while (value > 0) {
			value = max % min;
			max = min;
			min = value;
		}

		answer = (long)w * (long)h - ((long)w + (long)h - max);
        return answer;
    }
 */
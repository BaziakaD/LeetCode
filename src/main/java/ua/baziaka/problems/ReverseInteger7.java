package ua.baziaka.problems;

public class ReverseInteger7 {

    public int reverse(int x) {

        int answer = 0;

        while (x != 0) {

            try {
                answer = Math.multiplyExact(answer, 10);
                answer = Math.addExact(answer, x % 10);
            } catch (ArithmeticException e) {
                answer = 0;
                break;
            }

            x /= 10;
        }

        return answer;
    }

    public int fastReverse(int x) {

        int answer = 0;

        while (x != 0) {

            int tail = x % 10;
            int maybe = answer * 10 + tail;

            if (answer != (maybe - tail) / 10) {
                answer = 0;
                break;
            }
            answer = maybe;

            x /= 10;
        }

        return answer;
    }
}

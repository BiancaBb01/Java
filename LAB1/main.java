public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};

        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        int result = n * 3;
        result += 10101;
        result += 0xFF;
        result *= 6;

        int sum = 0;
        while (result > 0) {
            sum += result % 10;
            result = result / 10;
        }

        while (sum > 9) {
            int temp = sum;
            sum = 0;
            while (temp > 0) {
                sum += temp % 10;
                temp = temp / 10;
            }
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }
}

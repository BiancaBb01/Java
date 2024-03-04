package lab1;
class KReductibleNumbers {
    KReductibleNumbers() {
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java KReductibleNumbers a b k");
        } else {
            int a;
            int b;
            int k;
            try {
                a = Integer.parseInt(args[0]);
                b = Integer.parseInt(args[1]);
                k = Integer.parseInt(args[2]);
            } catch (NumberFormatException var6) {
                System.out.println("Invalid arguments. Please provide integers for a, b, and k.");
                return;
            }

            if (a > b) {
                System.out.println("Invalid interval. 'a' must be less than or equal to 'b'.");
            } else if (k < 0) {
                System.out.println("Invalid value for k. 'k' must be a non-negative integer.");
            } else {
                StringBuilder result = new StringBuilder();

                for(int i = a; i <= b; ++i) {
                    if (isKReductible(i, k)) {
                        result.append(i).append(" ");
                    }
                }

                System.out.println("K-reductible numbers in the interval [" + a + ", " + b + "]: " + result.toString());
            }
        }
    }

    private static boolean isKReductible(int num, int k) {
        while(num >= 10) {
            int sum;
            for(sum = 0; num > 0; num /= 10) {
                int digit = num % 10;
                sum += digit * digit;
            }

            num = sum;
        }

        return num == k;
    }
}

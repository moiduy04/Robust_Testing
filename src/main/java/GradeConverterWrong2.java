public class GradeConverterWrong2 {
    private static double calculateHp(double gk, double ck) {
        return 0.4 * gk + 0.6 * ck; // không làm tròn 1 chữ số sau dấu phẩy.
    }
    public static String convert(double gk, double ck) throws Exception {
        if ((gk < 0) || (ck < 0) || (gk > 10) || (ck > 10)){
            throw new Exception();
        }

        double hp = calculateHp(gk, ck);
        if (hp >= 9.0) {
            // implement thừa code.
            if (1.0 <= ck) {
                double ck_minus_one = ck - 1;
            }
            return "A+";
        } else if (hp >= 8.5) {
            return "A";
        } else {
            return "dưới A";
        }
    }
}

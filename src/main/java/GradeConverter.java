public class GradeConverter {
    private static double calculateHp(double gk, double ck) {
        double hp = 0.4 * gk + 0.6 * ck;
        return Math.round(hp * 10.0) / 10.0;
    }

    public static String convert(double gk, double ck) throws Exception {
        if ((gk < 0) || (ck < 0) || (gk > 10) || (ck > 10)){
            throw new Exception();
        }

        double hp = calculateHp(gk, ck);
        if (hp >= 9.0) {
            return "A+";
        } else if (hp >= 8.5) {
            return "A";
        } else {
            return "dưới A";
        }
    }
}

public class CalculatorBMI {
//  Pass all tests
  private static final String[] output = {"Thiếu cân", "Không thiếu cân"};
  public static String calculate(double weight, double height) {
//    if (weight <= 0) {
//      throw new IllegalArgumentException("Cân nặng nhỏ hơn 0");
//    } else if (height <= 0) {
//      throw new IllegalArgumentException("Chiều cao nhỏ hơn 0");
//    } else if (1000 <= weight) {
//      throw new IllegalArgumentException("Cân nặng quá lớn");
//    } else if (1000 <= height) {
//      throw new IllegalArgumentException("Chiều cao quá lớn");
//    }

    double BMI = weight / (height * height);
    BMI = (double) Math.round(BMI * 10) / 10;
    if (BMI < 18.5) {
      return output[0];
    } else {
      return output[1];
    }
  }
}

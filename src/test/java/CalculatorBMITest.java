import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class CalculatorBMITest {
  private double weight;
  private double height;
  private boolean exceptionExpected;
  private String expectedOutput;

  public CalculatorBMITest(double weight, double height, boolean exceptionExpected, String expectedOutput) {
    this.weight = weight;
    this.height = height;
    this.exceptionExpected = exceptionExpected;
    this.expectedOutput = expectedOutput;
  }

  @Test
  public void testCalculatorBMI() {
    try {
      String answer = CalculatorBMI.calculate(weight, height);
      if (exceptionExpected) {
        Assert.fail("Expected exception with output `" + expectedOutput + "`");
      }
      Assert.assertEquals(expectedOutput, answer);
    } catch (IllegalArgumentException e) {
      Assert.assertEquals(expectedOutput, e.getMessage());
    } catch (Exception e) {
      if (!exceptionExpected) {
        Assert.fail("Expected NO exception, and output `" + expectedOutput + "`");
      }
      Assert.fail("Expected exception's output to be `" + expectedOutput + "`");
    }
  }

  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] {
            { 867.213,  570.170, false, "Thiếu cân"},
            {  -1.123,  792.124,  true, "Cân nặng nhỏ hơn 0"},
            { 191.329,   -0.314,  true, "Chiều cao nhỏ hơn 0"},
            {6509.653,  564.939,  true, "Cân nặng quá lớn"},
            { 210.803, 8952.701,  true, "Chiều cao quá lớn"},
    });
  }
}

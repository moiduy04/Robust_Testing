import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class GradeConverterTest {
  private static final Class<?>[] CLASSES = {
          GradeConverter.class,
          GradeConverterWrong1.class,
          GradeConverterWrong2.class
  };

  private double gk;
  private double ck;
  private boolean throwException;
  private String expectedOutput;
  private Class<?> converterClass;

  public GradeConverterTest(double gk, double ck, boolean throwException, String expectedOutput, Class<?> converterClass) {
    this.gk = gk;
    this.ck = ck;
    this.throwException = throwException;
    this.expectedOutput = expectedOutput;
    this.converterClass = converterClass;
  }

  @Test
  public void testGradeConverter() {
    try {
      String answer = (String) converterClass.getMethod("convert", double.class, double.class).invoke(null, gk, ck);
      if (throwException) {
        Assert.fail("Expected Exception" +
                "\nInstead got output `" + answer + "`");
      }
      Assert.assertEquals(expectedOutput, answer);
    } catch (Exception e) {
      Assert.assertTrue("Expected output `" + expectedOutput + "`" +
              "\nInstead got Exception", throwException);
    }
  }

  public static void addTest(List<Object[]> testCases, Object[][] testToAdd, int testClassId) {
      for (Object[] objects : testToAdd) {
          testCases.add(
                  new Object[]{objects[0], objects[1], objects[2], objects[3], CLASSES[testClassId]}
          );
      }
  }

  @Parameters(name = "{index}: Test with gk={0}, ck={1}, throwException={2}, expectedOutput={3}, converterClass={4}")
  public static Collection<Object[]> data() {
    // IMPORTANT: Which class to test?
    // 0 = GradeConverter (correct)
    // 1 = GradeConverterWrong1 (thiếu kiểm tra invalid input)
    // 2 = GradeConverterWrong2 (thiếu làm tròn + thừa code)
    int testClassId = 0;
    //  set the `testClassId` and run.

    final String Aplus = "A+";
    final String A = "A";
    final String belowA = "dưới A";

    Object[][] test_BVA = {
            { 5.0, 10.0, false, belowA},
            { 5.0,  0.0, false, belowA},
            { 5.0, 10.1,  true, ""},
            { 5.0,  9.9, false, belowA},
            { 5.0,  0.1, false, belowA},
            { 5.0, -0.1,  true, ""},
            {10.0,  5.0, false, belowA},
            { 0.0,  5.0, false, belowA},
            {10.1,  5.0,  true, ""},
            { 9.9,  5.0, false, belowA},
            { 0.1,  5.0, false, belowA},
            {-0.1,  5.0,  true, ""},
            { 5.0,  5.0, false, belowA},
    };
    Object[][] test_EP_input = {
            {     6.3,     8.1, false, belowA},
            {-19867.8,     0.7,  true, ""},
            {     3.2, 57501.5,  true, ""},
    };
    Object[][] test_EP_output = {
            {8.4, 9.8, false, Aplus},
            {8.9, 8.3, false, A},
            {0.8, 6.7, false, belowA},
            {40510.3, -87683.0, true, ""},
    };
    Object[][] test_CFG0 = {};
    Object[][] test_CFG1 = {};
    Object[][] test_CFG2 = {};

    List<Object[]> testCases = new ArrayList<>();
    addTest(testCases, test_BVA, testClassId);
    addTest(testCases, test_EP_input, testClassId);
    addTest(testCases, test_EP_output, testClassId);
//    if (testClassId == 0) {
//      addTest(testCases, test_CFG0, testClassId);
//    } else if (testClassId == 1) {
//      addTest(testCases, test_CFG1, testClassId);
//    } else if (testClassId == 2) {
//      addTest(testCases, test_CFG2, testClassId);
//    } else {
//      throw new IllegalArgumentException("testClassId must be either 0, 1 or 2");
//    }

    return testCases;
  }
}

package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.math.BigInteger;
import java.util.Random;

// 类名改为被测试类+Test，符合规范
public class SolutionTest {
    private final Solution solution = new Solution();

    // 固定测试用例（必选，覆盖已知场景）
    @Test
    public void testMultiplyWithExamples() {
        assertEquals("6", solution.multiply("2", "3"));
        assertEquals("56088", solution.multiply("123", "456"));
        assertEquals("0", solution.multiply("0", "12345"));
        assertEquals("0", solution.multiply("12345", "0"));
        assertEquals("0", solution.multiply("0", "0"));
    }

    // 随机测试用例（可选，增强覆盖）
    @Test
    public void testMultiplyWithRandomCases() {
        Random random = new Random();
        int total = 10;

        for (int i = 0; i < total; i++) {
            String num1 = generateRandomNumberString(random, 1, 10);
            String num2 = generateRandomNumberString(random, 1, 10);

            String result = solution.multiply(num1, num2);
            BigInteger expectedBig = new BigInteger(num1).multiply(new BigInteger(num2));
            String expected = expectedBig.toString();

            // 使用断言判断结果，失败时会自动抛出异常
            assertEquals(
                    "测试用例失败: num1=" + num1 + ", num2=" + num2,
                    expected,
                    result
            );
        }
    }

    // 复用随机数生成方法
    private static String generateRandomNumberString(Random random, int minLen, int maxLen) {
        int length = minLen + random.nextInt(maxLen - minLen + 1);
        if (random.nextDouble() < 0.1) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int firstDigit = 1 + random.nextInt(9);
        sb.append(firstDigit);
        for (int i = 1; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}
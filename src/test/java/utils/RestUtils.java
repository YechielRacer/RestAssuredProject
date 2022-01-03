package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

    public static String employeeName() {
        return new Faker().name().fullName();
    }

    public static String employeeSalary() {
        return RandomStringUtils.randomNumeric(5);
    }

    public static String employeeAge() {
        return RandomStringUtils.randomNumeric(2);
    }

}

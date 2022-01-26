package utils;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	Faker faker = new Faker();
	
    public static String employeeName() {
        return new Faker().name().fullName();
    }

    public static String employeeSalary() {
        return RandomStringUtils.randomNumeric(5);
    }

    public static String employeeAge() {
        return RandomStringUtils.randomNumeric(2);
    }
    
    public String firstName() {
        return faker.name().firstName();
    }
    
    public String lastName() {
        return faker.name().lastName();
    }
    
    public String fullName() {
        return faker.name().fullName();
    }
    
    public String userName() {
        return faker.name().username();
    }
    
    public String email() {
        return faker.internet().emailAddress();
    }
    
    public String password() {
        return faker.internet().password();
    }


}

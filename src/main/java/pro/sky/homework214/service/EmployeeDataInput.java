package pro.sky.homework214.service;

import org.apache.commons.lang3.StringUtils;
import pro.sky.homework214.exception.EmployeeInputBadRequest;

public class EmployeeDataInput {
    public static String checkName(String n) {

        if (!StringUtils.isAlpha(n)) {
            throw new EmployeeInputBadRequest();
        } else {
            return StringUtils.capitalize(StringUtils.lowerCase(n));
        }

    }

}

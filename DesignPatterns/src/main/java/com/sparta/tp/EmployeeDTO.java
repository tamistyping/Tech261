package com.sparta.tp;

import java.time.LocalDate;

/**
 * @param name these fields should be final
 */
public record EmployeeDTO(String name, Integer salary, LocalDate dob) {

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dob=" + dob +
                '}';
    }

}

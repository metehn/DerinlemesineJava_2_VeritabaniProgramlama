package DatabaseProgramming008.bean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

    private long employeeId;
    private String employeeName;
    private double monthlySalary;
    private Department department;
}

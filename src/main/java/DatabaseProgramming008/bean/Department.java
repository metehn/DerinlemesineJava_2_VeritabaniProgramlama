package DatabaseProgramming008.bean;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Department {

    private long departmentId;
    private String departmentName;
    private List<Employee> employeeList;


}

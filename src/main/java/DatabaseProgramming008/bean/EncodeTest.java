package DatabaseProgramming008.bean;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class EncodeTest {

    public static void main(String[] args) throws FileNotFoundException {

        String path = "src/main/java/documents/department.xml";

        Department departmentA = new Department().builder()
                .departmentId(123)
                .departmentName("Muhasebe")
                .employeeList(new ArrayList<Employee>())
                .build();

        Employee employee0 = new Employee().builder()
                .employeeId(332)
                .employeeName("Metehan Ersoy")
                .monthlySalary(15000).department(departmentA)
                .build();
        departmentA.getEmployeeList().add(employee0);

        Employee employee1 = new Employee().builder()
                .employeeId(421)
                .employeeName("Mustafa Kemal")
                .monthlySalary(25000).department(departmentA)
                .build();
        departmentA.getEmployeeList().add(employee1);

        Employee employee2 = new Employee().builder()
                .employeeId(213)
                .employeeName("Atilla Ersoy")
                .monthlySalary(12000).department(departmentA)
                .build();
        departmentA.getEmployeeList().add(employee2);

        FileOutputStream fos = new FileOutputStream(path);
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        XMLEncoder encoder = new XMLEncoder(bos); // girdi olarak direkt FileOutputStream verilebilir ama daha performanslı olması için BufferedOutputStream veriyorum

        encoder.writeObject(departmentA);
        encoder.close();


    }

}

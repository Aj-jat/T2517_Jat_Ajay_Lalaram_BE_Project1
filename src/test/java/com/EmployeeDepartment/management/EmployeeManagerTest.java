package com.EmployeeDepartment.management;
import com.EmployeeDepartment.management.model.Department;
import com.EmployeeDepartment.management.model.Employee;
import com.EmployeeDepartment.management.repository.EmployeeRepository;
import com.EmployeeDepartment.management.service.EmployeeService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.context.ActiveProfiles;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class EmployeeManagerTest {
    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private EmployeeService employeeService;
    List<Employee> employeeList=new ArrayList<>();
    final Department department=new Department("deptPG","deptPG");
    final Employee employee=new Employee("employee1","Ajay",department);
    final Employee employee2=new Employee("employee2","Vijay",department);

    @Test
    public void addEmployeeTest(){
        employeeList.add(employee);
        Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
        Assert.assertEquals(employee,employeeService.addEmployee(employee));
    }
    @Test
    public void getEmployeesTest(){
        employeeList.add(employee);
        employeeList.add(employee2);
        Mockito.when(employeeRepository.findAll()).thenReturn(employeeList);
        Employee employeeTest=employeeService.addEmployee(employee);
        Assert.assertEquals(2,employeeService.getEmployees().size());
    }
    @Test
    public void deleteEmployeeTest(){
        employeeList.add(employee);
        employeeList.add(employee2);
        Mockito.doNothing().when(employeeRepository).deleteById("deptPG");
        employeeService.deleteEmployee("deptPG");
        Mockito.verify(employeeRepository).deleteById("deptPG");
    }
    @Test
    public void findEmployeeByIdTest(){
        employeeList.add(employee);
        employeeList.add(employee2);
        Mockito.when(employeeRepository.findById("employee1")).thenReturn(Optional.of(employee));
        Assert.assertEquals(Optional.of(employee),employeeService.findEmployeeById("employee1"));
    }
}

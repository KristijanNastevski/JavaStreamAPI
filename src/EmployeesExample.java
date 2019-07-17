import java.sql.SQLOutput;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeesExample {


    public static void main(String []args)
    {

        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        //Generating employees and showing them grouped by their working position

        Map<String,List<Employee>> map=employeeList.stream()
            //.filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800)
            .collect(Collectors.groupingBy(employee -> employee.getWorkingPosition(),Collectors.toList()));

        System.out.println(map.entrySet()
            .stream()
            .map(entry->entry.getKey()+" - "+entry.getValue().toString())
            .collect(Collectors.joining("\n","","\n")));

        //Finding the number of employees in Bitola

        System.out.println("======= Number of Employees in Bitola =======");

        List<Employee> list1 = employeeList.stream()
                .filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary()>800)
                .collect(Collectors.toList());

        System.out.println("Broj na vraboteni vo Bitola: " + list1.size() + "\n");

        //Finding the sum of Salary for employees that work in Skopje

        System.out.println("===== Sum of salaries for employees working in Skopje =====");

        int sum = employeeList.stream()
                .filter(employee -> employee.getCity().equals("Skopje"))
                .collect(Collectors.summingInt(employee -> employee.getSalary()));
        System.out.println("Suma na vkupna plata na vraboteni koi rabotat vo Skopje: " + sum + "\n");

        List<Employee> list = employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("======== Printing the employees in ascending order: ========== \n ");
        list.forEach(System.out::println);

        Optional<Employee> max = employeeList.stream()
                .filter(employee -> employee.getCity().equals("Skopje"))
                .collect(Collectors.maxBy(Comparator.comparing(Employee::getSalary)));

        System.out.println("\n =========Vraboteniot od Skopje so najgolema plata e: =============");
        System.out.println(max.get());

    }
}


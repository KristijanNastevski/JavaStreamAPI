import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeExampleTraditional {


    private static boolean checkCondition(Employee e)
    {
        return e.getCity().equals("Skopje") && e.getSalary()>=900;
    }

    public static void main(String []args)
    {
        List<Employee> employeeList=GenerateEmployees.generateEmployees(30);

        //filter the employees that have salary> 900 euros and live in Skopje
        //show them grouped by their working position

        Map<String,List<Employee>> employeesByPosition=new HashMap<>();

        for(int i=0;i<employeeList.size();++i)
        {
            Employee e=employeeList.get(i);
            if(checkCondition(e))
            {
                if(!employeesByPosition.containsKey(e.getWorkingPosition()))
                {
                    employeesByPosition.put(e.getWorkingPosition(),new ArrayList<>());
                }

                employeesByPosition.get(e.getWorkingPosition()).add(e);

            }
        }


        for(Map.Entry<String,List<Employee>> entry :employeesByPosition.entrySet())
        {
            System.out.println(entry.getKey()+" - "+entry.getValue());
        }

    }
}
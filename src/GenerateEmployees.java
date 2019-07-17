import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateEmployees {

    private static String[] names= {"Tamara","Ana","Vojo","Danie","Petar","Mile","Kristina","John","Kire","Slobodan",
        "George","Jan","Aleksandar","Miroslav","Adam","Elena","Marija","Suzan","Sofija"};

    private static String[] cities={"Skopje","Bitola","Strumica","Berovo","London","Ohrid","Kumanovo"};

    private static int[] salaries={1000,450,2000,1500,600,950,2500,1500,1400,1800,600,500,750};


    private static String[] positions={"Database Admin","FrontEnd","BackEnd","Software Architect","DevOps","Business Analyst",
        "Graphic designer"};


    public static List<Employee> generateEmployees(int n)
    {
        Random r=new Random();

        return IntStream.range(0,n)
            .mapToObj(i->{

                String name = names[r.nextInt(names.length)];

                String city = cities[r.nextInt(cities.length)];

                int salary = salaries[r.nextInt(salaries.length)];

                String pos = positions[r.nextInt(positions.length)];

                return new Employee(name,city,salary,pos);
            })
            .collect(Collectors.toList());
    }
}
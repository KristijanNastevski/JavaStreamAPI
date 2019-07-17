public class Employee {

    private String name;

    private String city;

    private int salary;

    private String workingPosition;


    public Employee(String name, String city, int salary, String workingPosition) {
        this.name = name;
        this.city = city;
        this.salary = salary;
        this.workingPosition = workingPosition;
    }

    public Employee() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkingPosition() {
        return workingPosition;
    }

    public void setWorkingPosition(String workingPosition) {
        this.workingPosition = workingPosition;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(name).append("- ").append(workingPosition).append(", city: ").append(city)
            .append(", salary: ").append(salary).toString();
    }
}
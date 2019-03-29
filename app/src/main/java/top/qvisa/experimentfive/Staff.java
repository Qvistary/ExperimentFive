package top.qvisa.experimentfive;

public class Staff {
    public String name;
    public String sex;
    public String department;
    public float salary;

    public Staff(String name,String sex,String department,Float salary)
    {
        this.name= name;
        this.sex = sex;
        this.department =department;
        this.salary=salary;
    }

    public String getSex() {
        return sex;
    }

    public String getDepartment() {
        return department;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public String getSalary_String() {
        String salary_string = Float.toString(salary);
        return salary_string;
    }
}


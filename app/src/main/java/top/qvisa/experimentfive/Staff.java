package top.qvisa.experimentfive;

public class Staff {
    public String name;
    public String sex;
    public String department;
    public String salary;

    public Staff(String name,String sex,String department,String salary)
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

    public String getSalary() {
        return salary;
    }
}


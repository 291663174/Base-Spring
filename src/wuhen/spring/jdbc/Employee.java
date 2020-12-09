package wuhen.spring.jdbc;

public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer dpetId;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", dpetId=" + dpetId +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getDpetId() {
        return dpetId;
    }

    public void setDpetId(Integer dpetId) {
        this.dpetId = dpetId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*
    public Department getDepartment() {
        return department;
    }
    */

    /*
    public void setDepartment(Department department) {
        this.department = department;
    }
    */

    //private Department department;

}

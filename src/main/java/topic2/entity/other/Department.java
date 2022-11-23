package topic2.entity.other;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import topic2.entity.people.Employee;
import topic2.entity.people.Manager;

public class Department {

    private static int DEPARTMENT_AMOUNT = 0;
    private String name;
    private List<Employee> employeeList = new ArrayList<>(); // Danh sách các nhân viên trực thuộc phòng ban này

    {
        DEPARTMENT_AMOUNT++;
    }

    public Department(String name) {
        this.name = name;
    }

    public Department(String name, List<Employee> employeeList) {
        this.name = name;
        this.employeeList = employeeList;
    }

    public static int getDepartmentAmount() {
        return DEPARTMENT_AMOUNT;
    }

    public static void decreaseDepartmentAmount(int x) {
        DEPARTMENT_AMOUNT -= x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        this.employeeList.remove(employee);
    }

    /**
     * Kiểm tra phòng ban đã có quản lý hay chưa
     *
     * @return True nếu phòng ban đã có quản lý. False nếu chưa có
     */
    public boolean hasManager() {
        for (Employee e : this.employeeList) {
            if (e instanceof Manager) {
                return true;
            }
        }
        return false;
    }

    /**
     * Kiểm tra nhân viên đã có trong phòng ban này hay chưa
     *
     * @param employee Nhân viên
     * @return True nếu nhân viên có trong phòng ban. False nếu chưa
     */
    public boolean hasEmployee(Employee employee) {
        for (Employee e : this.employeeList) {
            if (e.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    public void showInfo() {
        System.out.printf("== Thông tin phòng ban %s ==", name.toUpperCase());
        System.out.println(this);
        this.showEmployeeList();
    }

    public void showEmployeeList() {
        System.out.println("-- DANH SÁCH NHÂN VIÊN --");
        this.employeeList.forEach(employee -> {
            System.out.println();
            employee.showInfo();
        });
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return String.format("\n- Tên phòng ban: %s", name);
    }
}
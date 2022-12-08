package topic2.entity;

import static topic2.ui.Factory.SCANNER;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import topic2.ui.Factory;

public class Department {

    private static int DEPARTMENT_AMOUNT = 0;
    private String departmentName;
    private List<Employee> employeeList = new ArrayList<>(); // Danh sách các nhân viên trực thuộc phòng ban này

    {
        DEPARTMENT_AMOUNT++;
    }

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department(String departmentName, List<Employee> employeeList) {
        this.departmentName = departmentName;
        this.employeeList = employeeList;
    }

    public static int getDepartmentAmount() {
        return DEPARTMENT_AMOUNT;
    }

    public static void decreaseDepartmentAmount(int x) {
        DEPARTMENT_AMOUNT -= x;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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
        return this.employeeList.stream().anyMatch(employee -> employee instanceof Manager);
    }

    /**
     * Kiểm tra nhân viên đã có trong phòng ban này hay chưa
     *
     * @param employee Nhân viên
     * @return True nếu nhân viên có trong phòng ban. False nếu chưa
     */
    public boolean hasEmployee(Employee employee) {
        return this.employeeList.stream().anyMatch(e -> e.equals(employee));
    }

    public void setInfo() {
        System.out.print("- Tên phòng ban: ");
        this.departmentName = SCANNER.nextLine();
    }

    public void showInfo() {
        System.out.printf("** Thông tin phòng ban %s **\n", departmentName.toUpperCase());
        System.out.printf("- Tên phòng ban: %s\n", departmentName);
        System.out.println("== DANH SÁCH NHÂN VIÊN ==");
        this.showEmployeeList();
    }

    public void showEmployeeList() {
        Factory.employeeMenuHeader();
        this.employeeList.forEach(employee -> {
            System.out.println(employee);
            Factory.printLine(140, "-");
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
        return departmentName.equals(that.departmentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentName);
    }

    @Override
    public String toString() {
        return String.format("\n- Tên phòng ban: %s", departmentName);
    }
}

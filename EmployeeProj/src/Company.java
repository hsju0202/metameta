public class Company {

    Employee[] employees = new Employee[10];
    int cnt;

    public void regBusinessTrip(IBusinessTrip emp, int day) {
        emp.goBusinessTrip(day);
    }

    public void addEmployee(Employee employee) {
        employees[cnt++] = employee;
    }

    public void allEmpInfo() {
        for (int i = 0; i < cnt; i++) {
            System.out.println(employees[i].toString());
        }
    }

    public int allTotalPay() {
        int sum = 0;
        for (int i = 0; i < cnt; i++) {
            sum += employees[i].getPay();
        }
        return sum;
    }

    public static void main(String[] args) {
        Company company = new Company();
        Permanent permanent = new Permanent("10001", "홍길동", 5000000);
        company.addEmployee(permanent);
        Sales sales = new Sales("10002", "김길동", 3000000, 3000000);
        company.addEmployee(sales);
        PartTime partTime = new PartTime("10003", "고길동", 160, 50000);
        company.addEmployee(partTime);

        company.regBusinessTrip(permanent, 10);
        company.regBusinessTrip(sales, 10);
        company.regBusinessTrip(partTime, 10);

        company.allEmpInfo();
        System.out.println("총급여액: " + company.allTotalPay());
    }
}
/*출력결과
사번 이름 급여
총급여액
 */

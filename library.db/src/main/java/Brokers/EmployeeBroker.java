package Brokers;

import Entities.LoginData;
import EntityManager.PersistenceManager;
import Dtos.EmployeeDto;
import Entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeBroker implements BrokerIf<EmployeeDto>{

    private EntityManager entityManager = PersistenceManager.emf.createEntityManager();
    private String GET_ALL_EMPLOYEE = "SELECT e FROM Employee e";

    @Override
    public List<EmployeeDto> getAll() {
        List<Employee> employees = entityManager.createQuery(GET_ALL_EMPLOYEE).getResultList();
        return employees.stream()
                .map(EmployeeDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void commitChanges(List<EmployeeDto> employeeDtos) {

        employeeDtos.stream()
                .filter(employeeDto -> !employeeDto.isPersisted())
                .forEach(employeeDto -> {
                    Employee employee = new Employee();
                    entityManager.persist(employee);
                    employeeDto.setEmployee(employee);
                    LoginData loginData = new LoginData();
                    entityManager.persist(loginData);
                    employee.setLoginData(loginData);
                });

        employeeDtos.stream()
                .forEach(EmployeeDto::commitChanges);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(List<EmployeeDto> employeeDtos) {
        employeeDtos.stream()
                .map(EmployeeDto::getEmployee)
                .forEach(entityManager::remove);
    }

    @Override
    public EmployeeDto create() {
        return new EmployeeDto();
    }
}

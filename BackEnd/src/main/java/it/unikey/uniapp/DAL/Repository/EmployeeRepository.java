package it.unikey.uniapp.DAL.Repository;

import it.unikey.uniapp.DAL.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

    List<EmployeeEntity> findEmployeeEntitiesByName(String name);
    List<EmployeeEntity> findAllByDepartmentId(Integer id);
    boolean existsEmployeeEntitiesByDepartmentId(Integer id);

    boolean existsByNameAndSurname(String name, String surname);

}

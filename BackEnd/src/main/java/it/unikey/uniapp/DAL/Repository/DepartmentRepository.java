package it.unikey.uniapp.DAL.Repository;

import it.unikey.uniapp.DAL.Entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

    List<DepartmentEntity> findDepartmentEntityByName(String name);
    boolean existsDepartmentEntityByName(String name);

}

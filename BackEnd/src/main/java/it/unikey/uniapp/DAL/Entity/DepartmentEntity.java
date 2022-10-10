package it.unikey.uniapp.DAL.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity(name = "Department")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private String tel;

    @Column(nullable = false)
    @NotNull
    private String address;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @ToString.Exclude
    List<EmployeeEntity> employees;

}
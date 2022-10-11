package it.unikey.uniapp.DAL.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity(name = "Employee")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @NotNull
    private String name;

    @Column(nullable = false)
    @NotNull
    private String surname;

    @Column(nullable = false)
    @NotNull
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private DepartmentEntity department;

}
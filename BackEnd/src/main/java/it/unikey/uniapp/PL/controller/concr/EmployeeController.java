package it.unikey.uniapp.PL.controller.concr;

import it.unikey.uniapp.BLL.DTO.EmployeeDTO;
import it.unikey.uniapp.BLL.service.general.EmployeeService;
import it.unikey.uniapp.PL.controller.abstr.GenericController;
import it.unikey.uniapp.PL.mapper.impl.EmployeeRestMapper;
import it.unikey.uniapp.PL.rest.EmployeeRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController implements GenericController<EmployeeRest> {

    private final EmployeeService service;
    private final EmployeeRestMapper mapper;


    @Override
    @PostMapping
    public ResponseEntity<EmployeeRest> post(@RequestBody EmployeeRest rest) {
        EmployeeDTO employeeDTO= service.insert(mapper.fromRestToDto(rest));
        EmployeeRest employeeRest= mapper.fromDtoToRest(employeeDTO);
        return new ResponseEntity<>(employeeRest, HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<EmployeeRest> getById(@PathVariable Integer id) {
        EmployeeDTO employeeDTO= service.getById(id);
        EmployeeRest employeeRest= mapper.fromDtoToRest(employeeDTO);
        return new ResponseEntity<>(employeeRest,HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmployeeRest>> getAll() {
        List<EmployeeDTO> list= service.getAll();
        List<EmployeeRest> restList= mapper.fromDtoListToRestList(list);
        return new ResponseEntity<>(restList,HttpStatus.OK);
    }

    @GetMapping(path = "/employees_by_dep/{id}")
    private ResponseEntity<List<EmployeeRest>> getByDepartmentId(@PathVariable Integer id){
        try {
            List<EmployeeDTO> dtoList = service.getListByDepartmentId(id);
            List<EmployeeRest> employeeRests = mapper.fromDtoListToRestList(dtoList);
            return new ResponseEntity<>(employeeRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<EmployeeRest> put(@RequestBody EmployeeRest rest) {
        EmployeeDTO employeeDTO= service.update(mapper.fromRestToDto(rest));
        EmployeeRest employeeRest= mapper.fromDtoToRest(employeeDTO);
        return new ResponseEntity<>(employeeRest, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Integer id) {
        try{
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



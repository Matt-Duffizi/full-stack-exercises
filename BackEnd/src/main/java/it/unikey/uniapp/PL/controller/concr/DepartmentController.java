package it.unikey.uniapp.PL.controller.concr;
import it.unikey.uniapp.BLL.DTO.DepartmentDTO;
import it.unikey.uniapp.BLL.service.general.DepartmentService;
import it.unikey.uniapp.PL.controller.abstr.GenericController;
import it.unikey.uniapp.PL.mapper.impl.DepartmentRestMapper;
import it.unikey.uniapp.PL.rest.DepartmentRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/department")
public class DepartmentController implements GenericController<DepartmentRest> {

    private final DepartmentService service;
    private final DepartmentRestMapper mapper;

    @Override
    @PostMapping
    public ResponseEntity<DepartmentRest> post(@RequestBody DepartmentRest rest) {
        DepartmentDTO departmentDTO= service.insert(mapper.fromRestToDto(rest));
        DepartmentRest departmentRest= mapper.fromDtoToRest(departmentDTO);
        return new ResponseEntity<>(departmentRest, HttpStatus.CREATED);
    }

    @Override
    @GetMapping(path = "/{id}")
    public ResponseEntity<DepartmentRest> getById(@PathVariable Integer id) {
        DepartmentDTO departmentDTO= service.getById(id);
        DepartmentRest departmentRest= mapper.fromDtoToRest(departmentDTO);
        return new ResponseEntity<>(departmentRest,HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<DepartmentRest>> getAll() {
        List<DepartmentDTO> list= service.getAll();
        List<DepartmentRest> restList= mapper.fromDtoListToRestList(list);
        return new ResponseEntity<>(restList,HttpStatus.OK);
    }

    @GetMapping(path = "/department_name")
    private ResponseEntity<List<DepartmentRest>> getByName(@RequestParam("department_name") String department){
        try {
            List<DepartmentDTO> dtoList = service.getByName(department);
            List<DepartmentRest> departmentRests = mapper.fromDtoListToRestList(dtoList);
            return new ResponseEntity<>(departmentRests, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    @PutMapping
    public ResponseEntity<DepartmentRest> put(@RequestBody DepartmentRest rest) {
        DepartmentDTO departmentDTO= service.update(mapper.fromRestToDto(rest));
        DepartmentRest departmentRest= mapper.fromDtoToRest(departmentDTO);
        return new ResponseEntity<>(departmentRest, HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById( Integer id) {
        try{
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

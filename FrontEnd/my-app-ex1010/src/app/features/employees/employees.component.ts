import { Component, OnInit } from '@angular/core';
import {EmployeeModel} from "../../shared/models/employee.model";
import {FormBuilder, FormGroup} from "@angular/forms";
import {EmployeeStore} from "../../core/store/employee.store";
import {EmployeeService} from "../../core/services/employee.service";

@Component({
  selector: 'app-employees',
  templateUrl: './employees.component.html',
  styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

  employees: EmployeeModel[] = [];
  displayedColumns: string[] = ['name', 'surname', 'date'];
  form: FormGroup | undefined;


  tempId: number = 0;

  constructor(private fb: FormBuilder,
              private employeeStore: EmployeeStore,
              private employeeService: EmployeeService) {
  }

  ngOnInit() {
    this.employeeService.getAll().subscribe(employees => {
      this.employeeStore.setUsers(employees);
      this.employees = [...employees];
    })

    this.form = this.fb.group({
      id: this.fb.control(''),
      name: this.fb.control(''),
      surname: this.fb.control(''),
      date: this.fb.control(''),
      department: this.fb.control('')
    })
  }

  addEmployee(employee: EmployeeModel) {
    employee.id = this.employees[this.employees.length - 1].id + 1
    this.employeeService.post(employee).subscribe();
    this.employees.push(employee);
    this.employeeStore.setUsers(this.employees);
  }

  async deleteEmployee(employee: EmployeeModel) {
    let id = employee?.id
    await this.employeeService.delete(id).subscribe(data => {console.log(data)})
    this.employees.splice(this.employees.indexOf(employee),1)
  }
}


/*
    selectEmployee(employee: EmployeeModel) {
      this.form = this.fb.group({
        id: this.fb.control(employee.id),
        name: this.fb.control(employee.name),
        surname: this.fb.control(employee.surname),
        date: this.fb.control(employee.date ),
        department: this.fb.control(employee.department)
      });
    }

    editEmployee(employee: EmployeeModel) {
      const index = this.employees.findIndex(u => u.id === employee.id);
      this.employees[index] = employee;
      this.employeeStore.setUsers(this.employees);
    }

}*/

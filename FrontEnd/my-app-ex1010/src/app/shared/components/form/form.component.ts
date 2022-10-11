import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {EmployeeModel} from "../../models/employee.model";
import {DepartmentStore} from "../../../core/store/department.store";
import {DepartmentService} from "../../../core/services/department.service";
import {DepartmentModel} from "../../models/department.model";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss']
})
export class FormComponent implements OnInit {
  departments: DepartmentModel[] = []

  @Input() form: FormGroup | undefined;

  @Output() addEmitter: EventEmitter<EmployeeModel> = new EventEmitter<EmployeeModel>();
  @Output() editEmitter: EventEmitter<EmployeeModel> = new EventEmitter<EmployeeModel>();

  constructor(private departmentStore: DepartmentStore,
              private departmentService: DepartmentService ) {
    }

  ngOnInit(): void {
    this.departmentService.getAll().subscribe(departments => {
      this.departmentStore.setUsers(departments);
      this.departments = [...departments];
    })
  }

  addEventEmitter() {
    let id = this.form?.get('department')?.value
    let element: EmployeeModel =  this.form?.value
    let ids = []
    for(let e of this.departments){
      ids.push(e.id)
    }
    if (id in ids && this.departments){
      element.department = this.departments.find(i=>i.id=id)
      this.addEmitter.emit(element);
      this.resetForm();

    } else {this.resetForm();}
  }

  editEventEmitter() {
    this.editEmitter.emit(this.form?.value)
    this.resetForm();
  }

  resetForm() {
    this.form?.reset();
  }

}

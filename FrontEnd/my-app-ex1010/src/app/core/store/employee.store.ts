import {EmployeeModel} from "../../shared/models/employee.model";
import {Injectable} from "@angular/core";
import {formatDate, getLocaleDateFormat} from "@angular/common";

@Injectable({
  providedIn: 'root'
})
export class EmployeeStore {
  private employee: EmployeeModel[] = [];

  getUsers(): EmployeeModel[] {
    return this.employee;
  }

  setUsers(elementArray: EmployeeModel[]): void {
    this.employee = elementArray;
  }

  getById(id: number): EmployeeModel | undefined {
    return this.employee.find(u => u.id == id);
  }
}

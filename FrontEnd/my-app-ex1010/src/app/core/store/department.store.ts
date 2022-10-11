import {Injectable} from "@angular/core";
import {DepartmentModel} from "../../shared/models/department.model";

@Injectable({
  providedIn: 'root'
})
export class DepartmentStore {
  private department: DepartmentModel[] = [];

  getUsers(): DepartmentModel[] {
    return this.department;
  }

  setUsers(elementArray: DepartmentModel[]): void {
    this.department = elementArray;
  }

  getById(id: number): DepartmentModel | undefined {
    return this.department.find(u => u.id == id);
  }
}

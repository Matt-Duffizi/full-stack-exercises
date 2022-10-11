import {DepartmentModel} from "./department.model";

export interface EmployeeModel {
  id:number;
  name: string;
  surname: string;
  date: Date;
  department: DepartmentModel | undefined;
}

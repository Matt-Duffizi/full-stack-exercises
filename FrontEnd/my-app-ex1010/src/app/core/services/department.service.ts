import {Injectable} from "@angular/core";
import {DepartmentStore} from "../store/department.store";
import {Observable} from "rxjs";
import {DepartmentModel} from "../../shared/models/department.model";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class DepartmentService {

  // @ts-ignore
  constructor(private http: HttpClient,
              private departmentStore: DepartmentStore) {
  }


  getAll(): Observable<DepartmentModel[]> {
    return this.http.get<DepartmentModel[]>(environment.server + '/department');
  }

  post(department: DepartmentModel) {
    this.http.post(environment.server + '/department', department);
  }
}

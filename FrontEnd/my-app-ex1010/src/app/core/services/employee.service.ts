import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {EmployeeStore} from "../store/employee.store";
import {EmployeeModel} from "../../shared/models/employee.model";
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  // @ts-ignore
  constructor(private http: HttpClient,
              private employeeStore: EmployeeStore) {
  }

  getAll(): Observable<EmployeeModel[]> {
    return this.http.get<EmployeeModel[]>(environment.server + '/employee');
  }

  post(employee: EmployeeModel): Observable<EmployeeModel> {
    const httpOptions = {
      headers: new HttpHeaders(
        { 'Content-Type': 'application/json' }
      )
    };
    let employeeJSON = JSON.stringify(employee);
    return  this.http.post<EmployeeModel>(environment.server + '/employee', employeeJSON,httpOptions);
   }

  delete(id: number): Observable<number>{
    let httpHeaders=new HttpHeaders()
      .set('Content-type','application/Json');
    let options={
      headers:httpHeaders
    };
    let string = environment.server + '/employee/{id}?id='+ id
    return this.http.delete<number>(string,options);
  }
}

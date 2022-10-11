import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ErrorComponent} from "./features/error/error.component";
import {EmployeesComponent} from "./features/employees/employees.component";
import {DepartmentsComponent} from "./features/departments/departments.component";
import {HomeComponent} from "./features/home/home.component";

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'departments', component: DepartmentsComponent},
  { path: 'employees', component: EmployeesComponent},
  { path: '', pathMatch: 'full', redirectTo: 'employees' },
  { path: '**', pathMatch: 'full', component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmployeesComponent } from './employees.component';
import {ComponentsModule} from "../../shared/components/components.module";



@NgModule({
  declarations: [
    EmployeesComponent
  ],
    imports: [
        CommonModule,
        ComponentsModule,
    ]
})
export class EmployeesModule { }

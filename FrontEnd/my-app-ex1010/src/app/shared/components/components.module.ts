import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FormComponent} from "./form/form.component";
import {TableComponent} from "./table/table.component";
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [FormComponent,
    TableComponent],
  exports: [
    FormComponent,
    TableComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class ComponentsModule { }

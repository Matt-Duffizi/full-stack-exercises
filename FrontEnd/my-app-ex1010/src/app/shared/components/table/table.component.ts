import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {EmployeeModel} from "../../models/employee.model";

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.scss']
})
export class TableComponent implements OnInit {

  @Input() displayedColumns: string[] | undefined;
  @Input() datasource: any[] | undefined;

  @Output() clickEmitter: EventEmitter<any> = new EventEmitter<any>();
  @Output() emitterDelete: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  editEventEmitter(element: any) {
    this.clickEmitter.emit(element);
  }

  onClickDeleteElement(element: EmployeeModel) {
    this.emitterDelete.emit(element)

  }
}

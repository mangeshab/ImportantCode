import { Component, OnInit } from '@angular/core';
import { CommonService } from 'src/app/shared/common.service';

@Component({
  selector: 'app-document',
  templateUrl: './document.component.html',
  styleUrls: ['./document.component.css']
})
export class DocumentComponent implements OnInit {

  constructor(public commonservice:CommonService) { }
  fileList:Document[];

  ngOnInit(): void {
    this.commonservice.getData().subscribe((data:Document[])=>{
      this.fileList=data;
    })
  }

}

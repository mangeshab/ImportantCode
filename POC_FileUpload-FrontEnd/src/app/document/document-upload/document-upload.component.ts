import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { CommonService } from 'src/app/shared/common.service';
import { Location } from '@angular/common';
@Component({
  selector: 'app-document-upload',
  templateUrl: './document-upload.component.html',
  styleUrls: ['./document-upload.component.css']
})
export class DocumentUploadComponent implements OnInit {


  constructor(private formBuilder:FormBuilder,private location:Location,private common:CommonService) { }

  docForm!:FormGroup;
  doc=new Document();
  document_id:any;
  customer_id:any;
  photo:any;
  signature:any;
  address_proof:any;
  thumb:any;
  
  
  ngOnInit(): void {

    this.docForm=this.formBuilder.group({

      customer_id:[]
    })
    
  }

  onselectedFile1(event:any){this.photo=event.target.files[0];}
  onselectedFile2(event:any){this.signature=event.target.files[0];}
  onselectedFile3(event:any){this.address_proof=event.target.files[0];}
  onselectedFile4(event:any){this.thumb=event.target.files[0];}
 
  save()
  {
    const document1=JSON.stringify(this.docForm.value);
    const uploadDocument= new FormData();
    uploadDocument.append("customer_id",this.customer_id);
    uploadDocument.append("photo",this.photo);
    uploadDocument.append("signature",this.signature);
    uploadDocument.append("address_proof",this.address_proof);
    uploadDocument.append("thumb",this.thumb);
    uploadDocument.append("doc",document1);
    this.common.postDocument(uploadDocument).subscribe();
    console.log("Upload Method")
  }
}

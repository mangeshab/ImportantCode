import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DocumentUploadComponent } from './document/document-upload/document-upload.component';
import { DocumentComponent } from './document/document/document.component';

const routes: Routes = [
  {
    path:'',component:DocumentComponent
  },
  {
    path:'document',component:DocumentComponent
  },
  {
    path:'document-upload',component:DocumentUploadComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

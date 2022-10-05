import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class CommonService {

  constructor(private httpclient:HttpClient) { }

  private serverurl=environment.url;

  getData():Observable<Document[]>
  {
    return this.httpclient.get<Document[]>(this.serverurl+"/document/files")
  }
  postDocument(uploadDocument:FormData):Observable<Document>
  {
    
      return this.httpclient.post<Document>(this.serverurl+"/document/adddoc",uploadDocument)
  }
}

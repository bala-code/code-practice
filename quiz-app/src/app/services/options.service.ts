import { Injectable } from '@angular/core';
import { options } from '../datamodel/Options';
//import { Options } from '../datamodel/options'
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OptionsService {

  url_op  = "http://localhost:8080/quiz-rest-api/rest/questions/mcq";
  
  //const response = this.http.put(url, data, { responseType: 'text'}).toPromise();

  constructor(private httpClient: HttpClient) { }

  getOptionsList(criterion_op : string): Observable<options[]> {
    
    var optionsList :options[];

    //const response = this.httpClient.put(url_op + "?aCont=", { responseType: 'text'}).toPromise();

   // return response;

    return this.httpClient.get(this.url_op + "?aCont=" + criterion_op) as Observable<options[]>
  }

  save(options : options) {
    this.httpClient.post(this.url_op,options ).subscribe((data) =>
      console.log(data)
      );

}
}

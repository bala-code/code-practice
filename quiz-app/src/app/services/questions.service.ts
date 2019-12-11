import { Injectable } from '@angular/core';
import { Question } from '../datamodel/question';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class QuestionsService {

  url  = "http://localhost:8080/quiz-rest-api/rest/questions";
  
  constructor(private httpClient: HttpClient) { }

  getQuestionList(criterion : string): Observable<Question[]> {
    
    var questionList :Question[];
    return this.httpClient.get(this.url + "?qContent=" + criterion) as Observable<Question[]>
  }

  save(question : Question) {
    this.httpClient.post(this.url,question ).subscribe((data) =>
      console.log(data)
      );
  }
  
  delete(id) {
   console.log("in Delete service")
   this.httpClient.delete("http://localhost:8080/quiz-rest-api/rest/questions/delete?id="+id ).subscribe((data) =>
     console.log("Delete Worked ")
     );
    }

    update(id){
    console.log("in update section")
    this.httpClient.put("http://localhost:8080/quiz-rest-api/rest/questions/update",id)
    console.log("update working");
    
  }


  }
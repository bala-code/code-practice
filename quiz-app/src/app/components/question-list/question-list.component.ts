import { Component, OnInit } from '@angular/core';
import { QuestionsService } from 'src/app/services/questions.service';
import { Question } from 'src/app/datamodel/question';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {


  questionList : Question[];
  criterion : string;
  

  constructor(private questionService : QuestionsService) { }

  ngOnInit() {
   
    this.search();
   // this.delete();
   //this.update();
  }
 
  delete(){
    console.log("delete methord");
    this.questionService.delete(5);
  }
  search() {
  this.questionService.getQuestionList(this.criterion).subscribe((data) => {

    this.questionList =data;

    console.log(this.questionList);
  });
  }
  
  update(id) {
    console.log("update method");
    this.questionService.update(id);
    
  }

}
import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/datamodel/question';
import { QuestionsService } from 'src/app/services/questions.service';

@Component({
  selector: 'app-question-form',
  templateUrl: './question-form.component.html',
  styleUrls: ['./question-form.component.css']
})
export class QuestionFormComponent implements OnInit {

  question : Question = new Question(" ");
  constructor(private questionService : QuestionsService) { }

  ngOnInit() {

  }

  save(){
    this.questionService.save(this.question);
  }

}

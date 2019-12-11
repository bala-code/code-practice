import { Component, OnInit } from '@angular/core';
import { options } from 'src/app/datamodel/options';
import { OptionsService } from 'src/app/services/options.service';


@Component({
  selector: 'app-option-form',
  templateUrl: './option-form.component.html',
  styleUrls: ['./option-form.component.css']
})

export class OptionFormComponent implements OnInit {


  options : options = new options(" ");
  
  constructor(private optionsService : OptionsService) { }

  ngOnInit() {
  }

  save(){
    this.optionsService.save(this.options);
  }

}

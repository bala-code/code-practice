import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { QuestionFormComponent } from './components/question-form/question-form.component';
import {HttpClientModule } from '@angular/common/http';
import{ AppRoutingModule } from './app-routing.module';


import { QuestionListComponent } from './components/question-list/question-list.component';
import { OptionFormComponent } from './components/option-form/option-form.component';
import { AdminLoginComponent } from './components/admin-login/admin-login.component';
import { UserLoginComponent } from './components/user-login/user-login.component';
import { UserComponent } from './user/user.component';
import { AdminComponent } from './admin/admin.component';

@NgModule({
  declarations: [
    AppComponent,
    QuestionFormComponent,
    QuestionListComponent,
    OptionFormComponent,
    AdminLoginComponent,
    UserLoginComponent,
    UserComponent,
    AdminComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SignupComponent } from './signup/signup.component';
import { SigninComponent } from './signin/signin.component';
import { LandingComponent } from './landing/landing.component';
import { ViewCoursesComponent } from './view-courses/view-courses.component';
import { ViewStudentsComponent } from './view-students/view-students.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'home', component: HomeComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'signin', component: SigninComponent},
  {path: 'landing', component: LandingComponent},
  {path: 'allCourses', component: ViewCoursesComponent},
  {path: 'allStudents', component: ViewStudentsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {}
export const routingComponents = [SignupComponent, SigninComponent, HomeComponent, LandingComponent, ViewCoursesComponent, ViewStudentsComponent]
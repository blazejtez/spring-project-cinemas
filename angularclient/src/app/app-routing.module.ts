import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {CinemaFormComponent} from "./component/cinema-form/cinema-form.component";
import {CinemaEditComponent} from "./component/cinema-edit/cinema-edit.component";
import {CinemaViewComponent} from "./component/cinema-view/cinema-view.component";
import {ShowtimeFormComponent} from "./component/showtime-form/showtime-form.component";
import {ShowtimeEditComponent} from "./component/showtime-edit/showtime-edit.component";
import {ShowtimeViewComponent} from "./component/showtime-view/showtime-view.component";


const routes: Routes = [
  { path: 'cinemas/new_cinema', component: CinemaFormComponent},
  { path: 'cinemas/', component: CinemaFormComponent},
  { path: 'cinemas/:uuid', component: CinemaViewComponent},
  { path: 'cinemas/:uuid/edit', component: CinemaEditComponent},
  { path: 'cinemas/:uuid/showtimes/new', component: ShowtimeFormComponent},
  { path: 'cinemas/:uuid/showtimes/:showtimeUuid/edit', component: ShowtimeEditComponent},
  { path: 'cinemas/:uuid/showtimes/:showtimeUuid', component: ShowtimeViewComponent}
];

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [ RouterModule ]
})
export class AppRoutingModule { }

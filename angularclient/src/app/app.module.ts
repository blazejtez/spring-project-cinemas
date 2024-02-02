import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CinemasListComponent } from './component/cinemas-list/cinemas-list.component';
import {HttpClientModule} from "@angular/common/http";
import { CinemaFormComponent } from './component/cinema-form/cinema-form.component';
import { NavigationBarComponent } from './component/navigation-bar/navigation-bar.component';
import { BodyComponent } from './component/body/body.component';
import { CinemaEditComponent } from './component/cinema-edit/cinema-edit.component';
import { CinemaViewComponent } from './component/cinema-view/cinema-view.component';
import {FormsModule} from "@angular/forms";
import { ShowtimeFormComponent } from './component/showtime-form/showtime-form.component';
import { ShowtimeEditComponent } from './component/showtime-edit/showtime-edit.component';
import { ShowtimeViewComponent } from './component/showtime-view/showtime-view.component';

@NgModule({
  declarations: [
    AppComponent,
    CinemaFormComponent,
    NavigationBarComponent,
    BodyComponent,
    CinemaEditComponent,
    CinemaViewComponent,
    ShowtimeFormComponent,
    ShowtimeEditComponent,
    ShowtimeViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CinemasListComponent,
    HttpClientModule,
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

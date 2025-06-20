import {Component, OnInit} from '@angular/core';
import {DetailedShowtime} from "../../model/detailed-showtime";
import {ShowtimeService} from "../../service/showtime.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-showtime-form',
  templateUrl: './showtime-form.component.html',
  styleUrl: './showtime-form.component.css'
})
export class ShowtimeFormComponent implements OnInit {
  router: Router
  showtimeService: ShowtimeService
  showtime: DetailedShowtime | undefined
  backUrl: string | undefined;

  constructor(showtimeService: ShowtimeService, router: Router) {
    this.showtimeService = showtimeService;
    this.router = router;
  }

ngOnInit(): void {
    const url = this.router.url;
    const urlSegments = url.split('/');
    urlSegments.pop();
    urlSegments.pop();
    this.backUrl = urlSegments.join('/');

    this.showtime = {
      "movieTitle": "Aliens",
      "showRoomName": "Small Hall",
      "ticketPrice": 9.99,
      "screeningTime": "2019-01-03T22:08:28.097832"
    };

}

onSubmit(): void {
  const currentUrl = this.router.url;

  const urlSegments = currentUrl.split('/');
  urlSegments.pop();
  urlSegments[0] = 'api';
  const newUrl = urlSegments.join('/');
  urlSegments[0] = '';
  urlSegments.pop();
  const newNavUrl = urlSegments.join('/');
  console.log(newNavUrl);

  this.showtimeService.postShowtime(newUrl, this.showtime!)
    .subscribe( () => this.router.navigate([newNavUrl]));
    //window.location.reload();
}
}

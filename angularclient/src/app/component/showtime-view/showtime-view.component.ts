import { Component } from '@angular/core';
import {CinemaService} from "../../service/cinema.service";
import {ShowtimeService} from "../../service/showtime.service";
import {DetailedCinema} from "../../model/detailed-cinema";
import {Showtimes} from "../../model/showtimes";
import {ActivatedRoute, Router} from "@angular/router";
import {DetailedShowtime} from "../../model/detailed-showtime";

@Component({
  selector: 'app-showtime-view',
  templateUrl: './showtime-view.component.html',
  styleUrl: './showtime-view.component.css'
})
export class ShowtimeViewComponent {
  showtimeService: ShowtimeService
  cinemaService: CinemaService
  showtime: DetailedShowtime | undefined
  cinemaUuid: string | undefined;
  showtimeUuid: string | undefined;
  route: ActivatedRoute
  router: Router;
  backUrl: string | undefined;

  constructor(cinemaService: CinemaService, showtimeService: ShowtimeService, router: Router, route: ActivatedRoute) {
    this.cinemaService = cinemaService;
    this.showtimeService = showtimeService
    this.router = router;
    this.route = route;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const currentUrl = this.router.url;
      const urlSegments = currentUrl.split('/');
      this.cinemaUuid = urlSegments[2];
      this.showtimeService.getShowtime(this.cinemaUuid, params['showtimeUuid'])
        .subscribe(showtime => {
          this.cinemaUuid = params['cinemaUuid'];
          this.showtimeUuid = params['showtimeUuid'];
          urlSegments.pop();
          urlSegments.pop();
          this.backUrl = urlSegments.join('/');
          this.showtime = {
            movieTitle: showtime.movieTitle,
            showRoomName: showtime.showRoomName,
            ticketPrice: showtime.ticketPrice,
            screeningTime: showtime.screeningTime
          };
        });
    });
  }
}

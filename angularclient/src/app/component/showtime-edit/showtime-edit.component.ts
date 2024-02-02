import {Component, OnInit} from '@angular/core';
import {DetailedShowtime} from "../../model/detailed-showtime";
import {ActivatedRoute, Router} from "@angular/router";
import {ShowtimeService} from "../../service/showtime.service";

@Component({
  selector: 'app-showtime-edit',
  templateUrl: './showtime-edit.component.html',
  styleUrl: './showtime-edit.component.css'
})
export class ShowtimeEditComponent implements OnInit {

  showtime: DetailedShowtime | undefined;
  route: ActivatedRoute;
  router: Router;
  showtimeService: ShowtimeService;
  cinemaUuid: string | undefined;
  showtimeUuid: string | undefined;
  backUrl: string | undefined;


  constructor(route: ActivatedRoute, showtimeService: ShowtimeService, router: Router) {
    this.route = route;
    this.showtimeService = showtimeService;
    this.router = router;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      const currentUrl = this.router.url;
      const urlSegments = currentUrl.split('/');
      this.cinemaUuid = urlSegments[2];
      urlSegments.pop();
      urlSegments.pop();
      urlSegments.pop();
      this.backUrl = urlSegments.join('/');
      this.showtimeService.getShowtime(this.cinemaUuid, params['showtimeUuid'])
        .subscribe(showtime => {
          this.cinemaUuid = params['cinemaUuid'];
          this.showtimeUuid = params['showtimeUuid'];
          this.showtime = {
            movieTitle: showtime.movieTitle,
            showRoomName: showtime.showRoomName,
            ticketPrice: showtime.ticketPrice,
            screeningTime: showtime.screeningTime
          };
        });
    });
  }


  onSubmit() {
    const currentUrl = this.router.url;
    const urlSegments = currentUrl.split('/');
    urlSegments[0] = 'api';
    urlSegments.pop();
    const url = urlSegments.join('/');
    urlSegments[0] = '';
    urlSegments.pop();
    urlSegments.pop();
    const navigateUrl = urlSegments.join('/')
    this.showtimeService.putShowtime(url, this.showtime)
      .subscribe( () => this.router.navigate([navigateUrl]));
  }
}

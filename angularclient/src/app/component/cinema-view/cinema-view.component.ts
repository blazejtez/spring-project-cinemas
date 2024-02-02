import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../service/cinema.service";
import {Cinemas} from "../../model/cinemas";
import {ActivatedRoute, Router} from "@angular/router";
import {DetailedCinema} from "../../model/detailed-cinema";
import {map, Observable} from "rxjs";
import {Showtimes} from "../../model/showtimes";
import {ShowtimeService} from "../../service/showtime.service";
import {Showtime} from "../../model/showtime";
import {Cinema} from "../../model/cinema";

@Component({
  selector: 'app-cinema-view',
  templateUrl: './cinema-view.component.html',
  styleUrl: './cinema-view.component.css'
})
export class CinemaViewComponent implements OnInit {
  cinemaService: CinemaService
  showtimeService: ShowtimeService
  cinema: DetailedCinema | undefined
  showtimes: Showtimes | undefined
  cinemaUuid: string | undefined;
  route: ActivatedRoute
  router: Router;

  constructor(cinemaService: CinemaService, showtimeService: ShowtimeService, router: Router, route: ActivatedRoute) {
    this.cinemaService = cinemaService;
    this.showtimeService = showtimeService
    this.router = router;
    this.route = route;
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.showtimeService.getShowtimes(params['uuid'])
        .subscribe(showtimes => this.showtimes = showtimes);

      this.cinemaService.getCinema(params['uuid'])
        .subscribe(cinema => {
          this.cinemaUuid = params['uuid'];
          this.cinema = {
            name: cinema.name,
            street: cinema.street,
            city: cinema.city,
            zipCode: cinema.zipCode,
            employeesNumber: cinema.employeesNumber,
            phoneNumber: cinema.phoneNumber,
            openingDate: cinema.openingDate
          };
        });
    });
  }

  onDelete(id: string): void {
    this.showtimeService.deleteShowtime(id).subscribe(() => this.ngOnInit());
  }

  newShowtime() {
    const previousUrl = this.router.url;
    const newUrl = `${previousUrl}/showtimes/new`;
    this.router.navigate([newUrl]);
  }
}

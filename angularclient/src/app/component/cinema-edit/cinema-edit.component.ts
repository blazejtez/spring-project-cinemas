import { Component, OnInit } from '@angular/core';
import {DetailedCinema} from "../../model/detailed-cinema";
import {CinemaService} from "../../service/cinema.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-cinema-edit',
  templateUrl: './cinema-edit.component.html',
  styleUrl: './cinema-edit.component.css'
})
export class CinemaEditComponent implements OnInit {
  uuid: string | undefined;
  cinema: DetailedCinema | undefined;

  constructor(
    private cinemaService: CinemaService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
     this.route.params.subscribe(params => {
      this.cinemaService.getCinema(params['uuid'])
        .subscribe(cinema => {
          this.uuid = params['uuid'];
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
  onSubmit(): void {
      this.cinemaService.putCinema(this.uuid!, this.cinema!)
        .subscribe( () => this.router.navigate(['/cinemas']));
      window.location.reload()
  }

}

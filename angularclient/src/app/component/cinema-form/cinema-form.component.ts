import {Component, OnInit} from '@angular/core';
import {DetailedCinema} from "../../model/detailed-cinema";
import {CinemaService} from "../../service/cinema.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-cinema-form',
  templateUrl: './cinema-form.component.html',
  styleUrl: './cinema-form.component.css'
})
export class CinemaFormComponent implements OnInit {
  cinema:DetailedCinema | undefined;

  constructor(
    private cinemaService: CinemaService,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.cinema = {
            name: "Krewetka",
            street: "Sezamkowa",
            city: "Gdansk",
            zipCode: "00-000",
            employeesNumber: 10,
            phoneNumber: "123-456",
            openingDate: "2020-10-20"
          };
  }

  onSubmit(): void {
    this.cinemaService.postCinema(this.cinema!);
  }
}

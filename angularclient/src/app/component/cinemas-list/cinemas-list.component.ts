import {Component, OnInit} from '@angular/core';
import {CinemaService} from "../../service/cinema.service";
import {Cinemas} from "../../model/cinemas";
import { NgForOf, NgIf} from "@angular/common";
import {Cinema} from "../../model/cinema";
import {ActivatedRoute, Router, RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-cinemas-list',
  standalone: true,
  imports: [
    NgIf,
    NgForOf,
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './cinemas-list.component.html',
  styleUrl: './cinemas-list.component.css'
})
export class CinemasListComponent implements OnInit {
  service:CinemaService
  cinemas: Cinemas | undefined
  router: Router;
  constructor(service: CinemaService, router: Router) {
    this.service=service;
    this.router=router;
  }

  ngOnInit() {
    this.service.getCinemas().subscribe(cinemas => this.cinemas = cinemas);
  }

  onDelete(cinema: Cinema): void {
    this.service.deleteCinema(cinema.id).subscribe(() => this.ngOnInit());
  }

  onInspect(cinema: Cinema) {
    this.service.getCinema(cinema.id)
  }
  newCinema() {
    this.router.navigate(['cinemas/new_cinema']);
  }

  onEdit(cinema: Cinema) {
    this.router.navigate(['cinemas/', cinema.id, '/edit'])
  }

  getCinema(cinema: Cinema) {
    this.router.navigate(['cinemas/', cinema.id])
  }
}

import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Cinema} from "./cinema";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class CinemaServiceService {
  private cinemaUrl: string;

  constructor(private http: HttpClient) {
    this.cinemaUrl = 'http://localhost:8085/api/cinemas';
  }
  public findAll(): Observable<Cinema[]> {
    return this.http.get<Cinema[]>(this.cinemaUrl);
  }

  public save(cinema: Cinema) {
    return this.http.post<Cinema>(this.cinemaUrl, cinema);
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cinemas} from "../model/cinemas";
import {DetailedCinema} from "../model/detailed-cinema";

@Injectable({
  providedIn: 'root'
})
export class CinemaService {
  http: HttpClient;
  constructor(http: HttpClient) {
    this.http = http;
  }

  getCinemas(): Observable<Cinemas> {
    return this.http.get<Cinemas>('/api/cinemas');
  }

  deleteCinema(uuid: string): Observable<any> {
    return this.http.delete('/api/cinemas/' + uuid);
  }

  getCinema(uuid: string): Observable<DetailedCinema> {
    return this.http.get<DetailedCinema>('/api/cinemas/' + uuid);
  }

  putCinema(uuid: string, detailedCinema: DetailedCinema) {
    return this.http.put('/api/cinemas/' + uuid, detailedCinema);
  }

  postCinema(detailedCinema: DetailedCinema) {
    return this.http.post('/api/cinemas', detailedCinema).subscribe(
      () => {
        window.location.href = '/cinemas';
      });
  }
}

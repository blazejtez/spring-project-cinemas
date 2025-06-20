import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cinemas} from "../model/cinemas";
import {Showtimes} from "../model/showtimes";
import {DetailedShowtime} from "../model/detailed-showtime";

@Injectable({
  providedIn: 'root'
})
export class ShowtimeService {
  http: HttpClient;
  constructor(http: HttpClient) {
    this.http = http;
  }

  getShowtimes(uuid: string): Observable<Showtimes> {
    return this.http.get<Showtimes>('/api/cinemas/'+uuid+'/showtimes');
  }

  getShowtime(cinemaUuid: string, showtimeUuid:string): Observable<DetailedShowtime> {
    return this.http.get<DetailedShowtime>('/api/cinemas/'+ cinemaUuid+'/showtimes/'+showtimeUuid);
  }

  deleteShowtime(uuid: string) {
    return this.http.delete('/api/showtimes/'+uuid);
  }

  postShowtime(url: string, detailedShowtime: DetailedShowtime) {
    return this.http.post(url, detailedShowtime);
  }

  putShowtime(url: string, detailedShowtime: DetailedShowtime | undefined) {
    return this.http.put(url, detailedShowtime);
  }
}

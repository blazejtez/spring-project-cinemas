export class DetailedShowtime {
  constructor(movieTitle: string, showRoomName: string, ticketPrice: number, screeningTime: string) {
    this.movieTitle = movieTitle;
    this.showRoomName = showRoomName;
    this.ticketPrice = ticketPrice;
    this.screeningTime = screeningTime;
  }
  movieTitle: string;
  showRoomName: string;
  ticketPrice: number;
  screeningTime: string;
}

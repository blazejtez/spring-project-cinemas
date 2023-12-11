//package pl.edu.pg.menu.cinemashowtimes.util;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import pl.edu.pg.menu.cinemashowtimes.entity.Showtime;
//import pl.edu.pg.menu.cinemashowtimes.entity.Cinema;
//import pl.edu.pg.menu.cinemashowtimes.service.ShowtimeService;
//import pl.edu.pg.menu.cinemashowtimes.service.CinemaService;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Scanner;
//import java.util.UUID;
//
//@Component
//public class CommandLine implements CommandLineRunner {
//
//    private final ShowtimeService showtimeService;
//    private final CinemaService cinemaService;
//
//    public CommandLine(ShowtimeService showtimeService, CinemaService cinemaService) {
//        this.showtimeService = showtimeService;
//        this.cinemaService = cinemaService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//        String command;
//        main_loop:
//        while(true)
//        {
//            System.out.println("Available commands:");
//            System.out.println("1. list_menus");
//            System.out.println("2. list_dishes");
//            System.out.println("3. add_dish");
//            System.out.println("4. delete_dish");
//            System.out.println("5. quit");
//            System.out.print("Enter command: ");
//            command = scanner.next();
//            switch (command) {
//                case "1" -> {
//                    List<Cinema> response = this.cinemaService.findAll();
//                    response.forEach(System.out::println);
//                }
//                case "2" -> {
//                    List<Showtime> response = this.showtimeService.findAll();
//                    response.forEach(System.out::println);
//                }
//                case "3" -> {
//                    System.out.print("Enter dish UUID: ");
//                    UUID uuid = null;
//                    try
//                    {
//                        uuid = UUID.fromString(scanner.next());
//                    }
//                    catch (IllegalArgumentException e)
//                    {
//                        System.out.println("Wrong UUID");
//                        continue;
//                    }
//                    System.out.print("Enter dish name: ");
//                    String name = scanner.next();
//                    System.out.print("Enter dish price: ");
//                    BigDecimal price;
//                    try
//                    {
//                        price = new BigDecimal(scanner.next());
//                    }
//                    catch (NumberFormatException e)
//                    {
//                        System.out.println("Wrong number");
//                        continue;
//                    }
//                    System.out.print("Enter menu UUID: ");
//                    UUID cinemaUuid;
//                    try
//                    {
//                        cinemaUuid = UUID.fromString(scanner.next());
//                    }
//                    catch (IllegalArgumentException e)
//                    {
//                        System.out.println("Wrong Menu UUID");
//                        continue;
//                    }
//
//                    Cinema cinema = this.cinemaService.findById(cinemaUuid);
//                    Showtime showtime = Showtime.builder()
//                            .id(uuid)
//                            .name(name)
//                            .price(price)
//                            .cinema(cinema)
//                            .build();
//                    try {
//                        this.showtimeService.create(showtime);;
//                    } catch (Exception e) {
//                        System.out.println("Bad Request");
//                    }
//
//                }
//                case "4" -> {
//                    System.out.println("Enter showtime UUID");
//                    String uuid = scanner.next();
//                    this.showtimeService.delete(UUID.fromString(uuid));
//                }
//                case "5" -> {
//                    break main_loop;
//                }
//            }
//
//        }
//
//    }
//}

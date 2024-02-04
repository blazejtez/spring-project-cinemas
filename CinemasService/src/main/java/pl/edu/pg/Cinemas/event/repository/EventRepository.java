package pl.edu.pg.Cinemas.event.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.edu.pg.Cinemas.dto.CinemaCreateDTO;
import pl.edu.pg.Cinemas.entity.Cinema;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Repository
@Slf4j
public class EventRepository {
    private final LoadBalancerClient loadBalancerClient;
    private final RestTemplate restTemplate;

//    @Value("${isa.showtime.url}")
//    private String baseUrl;
    @Value("${eureka.client.serviceurl.defaultzone}")
    private String eurekaUrl;
    @Value("${isa.showtime.url}")
    private String baseUrl;

    @Autowired
    public EventRepository(RestTemplate restTemplate, LoadBalancerClient loadBalancerClient) {
        this.restTemplate = restTemplate;
        this.loadBalancerClient = loadBalancerClient;
    }

    public void delete(UUID uuid) {
        String uri = loadBalancerClient.choose("showtimes-service").getUri().toString();
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error(uri + "/api/cinemas/" + uuid);
        restTemplate.delete("lb://showtimes-service:8080" + "/api/showtimes/cinemas/" + uuid);

    }

    public void create(Cinema cinema) {
        String uri = loadBalancerClient.choose("showtimes-service").getUri().toString();
        CinemaCreateDTO cinemaCreateDTO = new CinemaCreateDTO();
        String uuid = cinema.getId().toString();
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error("NOTICE ME SENPAI");
        log.error(uri + "/api/cinemas/" + uuid);
        restTemplate.postForLocation("lb://showtimes-service:8080" + "/api/showtimes/cinemas/" + uuid, cinemaCreateDTO);
    }

}

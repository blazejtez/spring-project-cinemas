package pl.edu.pg.Cinemas.event.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import pl.edu.pg.Cinemas.dto.CinemaCreateDTO;
import pl.edu.pg.Cinemas.entity.Cinema;

import java.net.URI;
import java.util.UUID;

@Repository
public class EventRepository {

    private LoadBalancerClient loadBalancerClient;
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
        URI uri = loadBalancerClient.choose("lb://cinemas").getUri();
        String uuidASString = uuid.toString();
        restTemplate.delete(uri + "/api/cinemas/" + uuidASString);
    }

    public void create(Cinema cinema) {
        String uuid = cinema.getId().toString();
        CinemaCreateDTO cinemaCreateDTO = new CinemaCreateDTO();
        restTemplate.postForLocation(baseUrl + "/api/cinemas/" + uuid, cinemaCreateDTO);
    }

}

package dev.verosampedro.aniproject.requests;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/requests")
@CrossOrigin(origins = "http://localhost:5173")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @GetMapping
    public List<Request> listAll() {
        return requestService.getAllRequest();

    }

    @GetMapping("/{id}")
    public Request getIncidence(@PathVariable Long id) {
        return requestService.getRequestById(id);
    }

    @PostMapping
    public Request creatRequest(@RequestBody Request request) {
        return requestService.createRequest(request);
    }

    @PutMapping("/{id}")
    public Request updateRequest(@RequestBody Request request, @PathVariable Long id) {
        request.setId(id);
        return requestService.updateRequest(request);
    }

    @DeleteMapping("/{id}")
    public void deleteRequest(@PathVariable Long id) {
        requestService.deleteRequestById(id);
    }
}

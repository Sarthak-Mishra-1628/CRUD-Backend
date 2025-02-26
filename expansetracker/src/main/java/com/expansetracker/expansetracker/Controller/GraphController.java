package com.expansetracker.expansetracker.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.expansetracker.expansetracker.DTO.GraphDTO;
import com.expansetracker.expansetracker.DTO.StasDTO;
import com.expansetracker.expansetracker.Service.Graph.GraphService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/graph")
@CrossOrigin("http://localhost:5173/")
@RequiredArgsConstructor
public class GraphController {
    private final GraphService graphService;

    @GetMapping("/data")
    public GraphDTO getData(){
        return graphService.getData();
    }

    @GetMapping("/stats")
    public StasDTO getStats(){
        return graphService.getStats();
    }
}

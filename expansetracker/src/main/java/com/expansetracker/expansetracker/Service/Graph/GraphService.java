package com.expansetracker.expansetracker.Service.Graph;

import com.expansetracker.expansetracker.DTO.GraphDTO;
import com.expansetracker.expansetracker.DTO.StasDTO;

public interface GraphService {
    GraphDTO getData();
    StasDTO getStats();
}

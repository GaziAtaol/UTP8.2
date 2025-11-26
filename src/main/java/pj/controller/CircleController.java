package pj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pj.service.CircleFileService;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/circles")
@CrossOrigin(origins = "*")
public class CircleController {

    @Autowired
    private CircleFileService circleFileService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<int[]> getCircles() {
        try {
            int[] circles = circleFileService.loadCircles();
            return ResponseEntity.ok(circles);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/count")
    public ResponseEntity<Integer> getCirclesCount() {
        try {
            int count = circleFileService.getCirclesCount();
            return ResponseEntity.ok(count);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getCircleInfo() {
        try {
            Map<String, Object> info = new HashMap<String, Object>();
            info.put("fileExists", circleFileService.fileExists());
            info.put("circlesCount", circleFileService.getCirclesCount());
            return ResponseEntity.ok(info);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}

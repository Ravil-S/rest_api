package rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.service.CalculateService;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RestAPIController {

    @Autowired
    CalculateService calculateService;

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> calcCharFreq(@RequestBody String str){
        String json = calculateService.getCharFreqJSON(str);
        if (json != null) return new ResponseEntity<>(json, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping (value = "/map", produces = MediaType.APPLICATION_JSON_VALUE , consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Map<Character, Long>> calcCharFreqMap(@RequestBody String str){
        Map<Character, Long> json = calculateService.getCharFreqMap(str);
        if (json != null) return new ResponseEntity<>(json, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

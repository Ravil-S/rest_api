package rest.controller;

import lombok.RequiredArgsConstructor;
import openapi.api.DefaultApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.service.CalculateService;

import java.util.Map;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class RestAPIController implements DefaultApi {

    private final CalculateService calculateService;

    @Override
    public ResponseEntity<Map<String, Long>> calcCharFreqMap(@RequestBody String str){
        Map<String, Long> json = calculateService.getCharFreqMap(str);
        if (json != null) return new ResponseEntity<>(json, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

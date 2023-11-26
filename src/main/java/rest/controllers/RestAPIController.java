package rest.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rest.service.CalculateService;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class RestAPIController {

    @Autowired
    CalculateService calculateService;

    @PostMapping (produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> send(@RequestBody String str){
        return new ResponseEntity<>(calculateService.getCharFreqJSON(str), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<String> read(){
        String str="ololo";
        return new ResponseEntity<>(str, HttpStatus.OK);
    }

}

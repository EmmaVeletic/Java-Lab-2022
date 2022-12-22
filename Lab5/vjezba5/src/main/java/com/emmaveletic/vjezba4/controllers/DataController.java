package com.emmaveletic.vjezba4.controllers;


import com.emmaveletic.vjezba4.entities.Client;
import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.services.DataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RequestMapping("/data")
@AllArgsConstructor
@RestController
public class DataController {
    @Autowired
    private DataService service;

    @GetMapping()
    public Iterable<Data> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Data> getById(@PathVariable Long id){
        return service.findById(id);
    }

    @RequestMapping(value="/year", method=RequestMethod.GET) //@ResponseBody
    public  ResponseEntity<String> getYear(@RequestParam("search") Optional<Integer> search){
            try{
                List<Data> allData = (List<Data>) service.findAll();
                double sum = 0;
                for (Data data : allData) {
                    System.out.print(data.toString());
                    String[] date = data.getDate().split(".");
                    System.out.print(date[0]);
                    System.out.print(date[1]);
                    System.out.print(date[2]);
                    Optional<Integer> yearInDate = Optional.of(Integer.parseInt(date[2]));
                    if (search==yearInDate) {
                        sum += data.getValue();
                    }
                }
                System.out.print("year " + search + " total spent " + sum);
                return new ResponseEntity<>("year " + search + " total spent " + sum,HttpStatus.OK);
            }
            catch (NoSuchElementException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

    @RequestMapping(value="/year+month", method=RequestMethod.GET) //@ResponseBody
    public  ResponseEntity<String> getYearAndMonth(@RequestParam("searchYear") Optional<Integer> searchYear, @RequestParam("searchMonth") Optional<Integer> searchMonth) {
            try{
                List<Data> allData = (List<Data>) service.findAll();
                double sum = 0;
                for (Data data : allData) {
                    System.out.print(data.toString());
                    String[] date = data.getDate().split(".");
                    System.out.print(date[0]);
                    System.out.print(date[1]);
                    System.out.print(date[2]);
                    Optional<Integer> monthInDate = Optional.of(Integer.parseInt(date[1]));
                    Optional<Integer> yearInDate = Optional.of(Integer.parseInt(date[2]));
                    if (searchYear==yearInDate && searchMonth==monthInDate) {
                        sum += data.getValue();
                    }
                }
                System.out.print("year " + searchYear + "month " + searchMonth + " total spent " + sum);
                return new ResponseEntity<>("year " + searchYear + "month " + searchMonth + " total spent " + sum,HttpStatus.OK);
            }
            catch (NoSuchElementException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @RequestMapping(value="/all_year", method=RequestMethod.GET) //@ResponseBody
    public  ResponseEntity<String> getYearByMonths(@RequestParam("searchYear") Optional<Integer> searchYear) {
        try {
            List<Data> allData = (List<Data>) service.findAll();
            double sum1 = 0;
            double sum2 = 0;
            double sum3 = 0;
            double sum4 = 0;
            double sum5 = 0;
            double sum6 = 0;
            double sum7 = 0;
            double sum8 = 0;
            double sum9 = 0;
            double sum10 = 0;
            double sum11 = 0;
            double sum12 = 0;
            for (Data data : allData) {
                System.out.print(data.toString());
                String[] date = data.getDate().split(".");
                System.out.print(date[0]);
                System.out.print(date[1]);
                System.out.print(date[2]);
                Optional<Integer> monthInDate = Optional.of(Integer.parseInt(date[1]));
                Optional<Integer> yearInDate = Optional.of(Integer.parseInt(date[2]));
                if (searchYear == yearInDate) {
                    if (monthInDate == Optional.of(1)) {
                        sum1 += data.getValue();
                    } else if (monthInDate == Optional.of(2)) {
                        sum2 += data.getValue();
                    } else if (monthInDate == Optional.of(3)) {
                        sum3 += data.getValue();
                    } else if (monthInDate == Optional.of(4)) {
                        sum4 += data.getValue();
                    } else if (monthInDate == Optional.of(5)) {
                        sum5 += data.getValue();
                    } else if (monthInDate == Optional.of(6)) {
                        sum6 += data.getValue();
                    } else if (monthInDate == Optional.of(7)) {
                        sum7 += data.getValue();
                    } else if (monthInDate == Optional.of(8)) {
                        sum8 += data.getValue();
                    } else if (monthInDate == Optional.of(9)) {
                        sum9 += data.getValue();
                    } else if (monthInDate == Optional.of(10)) {
                        sum10 += data.getValue();
                    } else if (monthInDate == Optional.of(11)) {
                        sum11 += data.getValue();
                    } else if (monthInDate == Optional.of(12)) {
                        sum12 += data.getValue();
                    }
                }
            }
            String message = "year " + searchYear + " by month: ";
            for (int i = 1; i <= 12; i++) {
                switch (i) {
                    case 1:
                        message += "\nJanuary: " + sum1;
                        break;
                    case 2:
                        message += "\nFebruary: " + sum2;
                        break;
                    case 3:
                        message += "\nMarch: " + sum3;
                        break;
                    case 4:
                        message += "\nApril: " + sum4;
                        break;
                    case 5:
                        message += "\nMay: " + sum5;
                        break;
                    case 6:
                        message += "\nJune: " + sum6;
                        break;
                    case 7:
                        message += "\nJuly: " + sum7;
                        break;
                    case 8:
                        message += "\nAugust: " + sum8;
                        break;
                    case 9:
                        message += "\nSeptember: " + sum9;
                        break;
                    case 10:
                        message += "\nOctober: " + sum10;
                        break;
                    case 11:
                        message += "\nNovember: " + sum11;
                        break;
                    default:
                        message += "\nDecember: " + sum12;
                        break;
                }

                return new ResponseEntity<>(message, HttpStatus.OK);
            }
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping()
    public ResponseEntity<Data> postElectricityData(@RequestBody Data newData){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data> update(@RequestBody Data elData, @PathVariable Long id){
        try{
            Optional<Data> temp = service.findById(id);
            elData.setId(id);
            service.save(elData);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.deleteById(id);
    }
}
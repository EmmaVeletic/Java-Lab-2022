package com.emmaveletic.vjezba4.controllers;

import java.util.HashMap;


import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.entities.DataDTO;
import com.emmaveletic.vjezba4.entities.Device;
import com.emmaveletic.vjezba4.services.DataService;
import com.emmaveletic.vjezba4.services.DeviceService;

import net.minidev.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("/data")
@RestController
public class DataController {
    
	@Autowired
    private DataService service;
	private DeviceService deviceService;

    @GetMapping()
    public List<Data> getAll(Pageable page){
        return service.findAll(page);
    }

    @GetMapping("/{id}")
    public Data getById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping(value="/year")
    @ResponseBody
    public  ResponseEntity<JSONObject> getYear(@RequestParam("year") Integer searchYear, Pageable page){ 
            try{
                List<Data> allData = service.findAll(page);
                double sumAll = 0.0;
                for (Data data : allData) {
                    Calendar cal = Calendar.getInstance();
                    try {
						cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(data.getDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    Integer yearInDate = cal.get(Calendar.YEAR);
                    if (searchYear.equals(yearInDate)) {
                        sumAll = Double.sum(sumAll,data.getValue());
                    }
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("year",searchYear);
                map.put("sum", sumAll);
                JSONObject json = new JSONObject(map);
                return new ResponseEntity<>(json, HttpStatus.OK);
            }
            catch (NoSuchElementException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
    

    @RequestMapping(value="/year+month", method=RequestMethod.GET) //@ResponseBody
    public  ResponseEntity<JSONObject> getYearAndMonth(@RequestParam("year") Integer searchYear, @RequestParam("month") Integer searchMonth, Pageable page) {
    		HashMap<String, Object> map = new HashMap<>();
    		try{
                List<Data> allData = service.findAll(page);
                double sumAll = 0.0;
                for (Data data : allData) {
                    System.out.print(data.toString());
                    Calendar cal = Calendar.getInstance();
                    try {
						cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(data.getDate()));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    Integer monthInDate = cal.get(Calendar.MONTH) + 1;
                    Integer yearInDate = cal.get(Calendar.YEAR);
                    if (searchYear.equals(yearInDate) && searchMonth.equals(monthInDate)) {
                        sumAll = Double.sum(sumAll,data.getValue());
                    }
                }
                map.put("year",searchYear);
                map.put("month", searchMonth);
                map.put("sum", sumAll);
                JSONObject json = new JSONObject(map);
                
                return new ResponseEntity<>(json,HttpStatus.OK);
            }
            catch (NoSuchElementException e){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
    }

    @GetMapping(value="/all_year")
    @ResponseBody
    public  ResponseEntity<JSONObject> getYearByMonths(@RequestParam("year") Integer searchYear, Pageable page) {
        try {
            List<Data> allData = service.findAll(page);
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
                Calendar cal = Calendar.getInstance();
                try {
					cal.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(data.getDate()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                Integer monthInDate = cal.get(Calendar.MONTH) + 1;
                Integer yearInDate = cal.get(Calendar.YEAR);
                if (searchYear.equals(yearInDate)) {
                    switch (monthInDate) {
                        case 1:
                            sum1 += data.getValue();
                            break;
                        case 2:
                            sum2 += data.getValue();
                            break;
                        case 3:
                            sum3 += data.getValue();
                            break;
                        case 4:
                            sum4 += data.getValue();
                            break;
                        case 5:
                            sum5 += data.getValue();
                            break;
                        case 6:
                            sum6 += data.getValue();
                            break;
                        case 7:
                            sum7 += data.getValue();
                            break;
                        case 8:
                            sum8 += data.getValue();
                            break;
                        case 9:
                            sum9 += data.getValue();
                            break;
                        case 10:
                            sum10 += data.getValue();
                            break;
                        case 11:
                            sum11 += data.getValue();
                            break;
                        case 12:
                            sum12 += data.getValue();
                            break;
                        default:
                            break;
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
                    case 12:
                        message += "\nDecember: " + sum12;
                        break;
                    default:
                        break;
                }
            }
            HashMap<String, Object> map = new HashMap<>();
            map.put("year", searchYear);
            HashMap<String, Object> mapMonths = new HashMap<>();
            mapMonths.put("January",sum1);
            mapMonths.put("February",sum2);
            mapMonths.put("March",sum3);
            mapMonths.put("April",sum4);
            mapMonths.put("May",sum5);
            mapMonths.put("June",sum6);
            mapMonths.put("July",sum7);
            mapMonths.put("August",sum8);
            mapMonths.put("September",sum9);
            mapMonths.put("October",sum10);
            mapMonths.put("November",sum11);
            mapMonths.put("December",sum12);
            map.put("months", mapMonths);
            JSONObject json = new JSONObject(map);
            return new ResponseEntity<>(json, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

   /* @PostMapping()
    public ResponseEntity<Data> postElectricityData(@RequestBody Data newData){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(newData));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Data> update(@RequestBody Data elData, @PathVariable Long id){
        try{
            Data temp = service.findById(id);
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
    }*/
    
    
}
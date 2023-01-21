package com.emmaveletic.vjezba4.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import com.emmaveletic.vjezba4.entities.Data;
import com.emmaveletic.vjezba4.entities.DataDTO;
import com.emmaveletic.vjezba4.entities.Device;
import com.emmaveletic.vjezba4.services.DataService;
import com.emmaveletic.vjezba4.services.DeviceService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	@Autowired
	RestTemplate restTemplate;
	@Autowired
	private DataService dataService;
	private DeviceService deviceService;

	
	@GetMapping("/datas")
	public String showDataList(Model model, Pageable page) {
		Data[] response = restTemplate.getForObject("http://localhost:8080/data", Data[].class);
    	//List<Data> list = dataService.findAll(page);
		model.addAttribute("datas", response);
		return "list";
	}
	
	@GetMapping("/createData")
	public String showDataForm(Model model, Pageable page) {
		model.addAttribute("data", new DataDTO());
        List<Device> devices = deviceService.findAll(page);
        model.addAttribute("devices",devices);
        return "form";
	}
	
	@PostMapping("/saveData")
    public String saveData(@ModelAttribute("data") DataDTO dataDTO, BindingResult result) throws ParseException {
        if(result.hasErrors()) {
            return "form";
        }
        dataService.save(dataDTO);
        return "redirect:/datas";
    }

}

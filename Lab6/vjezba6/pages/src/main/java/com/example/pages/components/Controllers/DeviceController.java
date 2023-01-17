package com.example.pages.components.Controllers;

import com.example.pages.components.Services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class DeviceController {
    @Autowired
    DeviceService service;

    @GetMapping("/devices")
    String getDevices(Model model,
                      @RequestParam(value = "sortDir", defaultValue = "none", required = false) String sortDir,
                      @RequestParam(value = "pageNum", defaultValue = "0", required = false) String pageNum,
                      @RequestParam(value = "pageSize", defaultValue = "10", required = false) String pageSize) throws IOException, InterruptedException {
        model.addAttribute("something", service.GetData(sortDir, pageNum, pageSize));
        return "devices";
    }

    @GetMapping("/form")
    String formthing(Model model) throws IOException, InterruptedException {
        return "form";
    }
    @PostMapping("/form")
    String postman(@RequestParam String id,
                   @RequestParam String year,
                   @RequestParam String month,
                   @RequestParam String day,
                   @RequestParam String gg,
                   @RequestParam String dg) throws IOException, InterruptedException {
        service.AddData(id, year, month, day, gg, dg);
        return "redirect:/devices";
    }
}

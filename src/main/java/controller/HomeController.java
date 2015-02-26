package controller;

import model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.RecordService;

import java.util.List;

/**
 * Created by Austin on 2/9/2015.
 */

@Controller
public class HomeController {

    @Autowired
    RecordService recordService;

    @RequestMapping(value="/home.html", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String homePage(Model m) {
        String name = "Taylor";
        m.addAttribute("name", name);
        return "home";
    }

    @RequestMapping(value = "/viewRecords.html", method = {RequestMethod.GET, RequestMethod.HEAD})
    public String viewRecords(Model m) {
        //List<Record> records = recordService.getAllRecords();
        List<Record> records = recordService.getRecordsByJobTitle();
        m.addAttribute("records", records);
        return "viewRecords";
    }
}

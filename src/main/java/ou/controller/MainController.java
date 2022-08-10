package ou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ou.entity.RecordSpravka;
import ou.service.RecordService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class MainController {
    private final RecordService recordService;

    @Autowired
    public MainController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public String main(Model model) {
        model.addAttribute("records", recordService.getAllRecords());
        model.addAttribute("newRecord", new RecordSpravka("",new Date().toString(),""));
        return "index";
    }

    @PostMapping
    public String addRecord(@Valid @ModelAttribute("newRecord") RecordSpravka recordSpravka,
                            BindingResult bindingResult,
                            Model model) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        recordSpravka.setDate(simpleDateFormat.format(new Date()));
        if (bindingResult.hasErrors()) {
            model.addAttribute("records", recordService.getAllRecords());
            return "index";
        }
        recordService.addRecord(recordSpravka);
        return "redirect:/";
    }
}

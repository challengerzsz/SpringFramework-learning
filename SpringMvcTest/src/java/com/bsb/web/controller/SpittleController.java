package com.bsb.web.controller;


import com.bsb.data.ISpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private ISpittleRepository spittleRepository;

//    @Autowired
//    public SpittleController(ISpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }


    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model) {
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
        return "spittles";
    }
}

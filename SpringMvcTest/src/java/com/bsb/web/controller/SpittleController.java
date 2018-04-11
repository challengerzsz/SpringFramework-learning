package com.bsb.web.controller;


import com.bsb.data.ISpittleRepository;
import com.bsb.data.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/spittle")
public class SpittleController {
    private ISpittleRepository spittleRepository;

//    @Autowired
//    public SpittleController(ISpittleRepository spittleRepository) {
//        this.spittleRepository = spittleRepository;
//    }


    @RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
    public String spittles(@PathVariable("spittleId") long spittleId, Model model) {
        model.addAttribute(spittleRepository.findOne(spittleId));
        return "spittles";
    }

    //可在@RequestParam内加入default属性以便为没有指定的参数使用默认值
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max") long max,
                                  @RequestParam("count") int count) {
        return spittleRepository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showSpittle(@RequestParam("spittle_id") long id, Model model) {
        model.addAttribute(spittleRepository.findOne(id));
        return "spittle";
    }

    //处理对/spittle/register
    @RequestMapping("/register")
    public String showRegistrationForm() {
        return "registerForm";
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpittleProfile(@PathVariable String username, Model model) {
        Spittle spittle = spittleRepository.findByUsername(username);
        model.addAttribute(spittle);
        return "profile";
    }

}

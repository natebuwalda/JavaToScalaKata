package com.jyc.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StaffController {

    @RequestMapping(value = "/staff")
    @ResponseBody
    public String showCurrentStaff(){
        return "staff shown here";
    }


}

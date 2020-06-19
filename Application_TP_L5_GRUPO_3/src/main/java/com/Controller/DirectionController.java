package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DirectionController {
	
	@RequestMapping("redirectIndex.html")
	public ModelAndView redirectIndex() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping("redirectTransfers.html")
	public ModelAndView redirectTransfers() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("transfers");
		return MV;
	}


}

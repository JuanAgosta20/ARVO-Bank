package com.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DirectionController {
	
	@RequestMapping("redirectIndex.do")
	public ModelAndView redirectIndex() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping("index")
	public ModelAndView Index() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("index");
		return MV;
	}
	
	@RequestMapping("redirectTransfers")
	public ModelAndView redirectTransfers() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("transfers");
		return MV;
	}


}

package com.ymzhu.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymzhu.domain.SensorData;
import com.ymzhu.service.SensorDataService;

@Controller
@RequestMapping("/web")
public class WebController extends AbstractBaseController {
	
	@Autowired
	private SensorDataService sensorDataService;

	@RequestMapping("/charts")
	public String charts(HttpServletRequest request, Model model) throws Exception{
		String temp = sensorDataService.getAllSensorData(0);
		String humi = sensorDataService.getAllSensorData(1);
		model.addAttribute("temp", temp);
		model.addAttribute("humi", humi);
		return AccessPrefix.BCS + "/charts";
	}
	
	@RequestMapping("/data")
	public String data(HttpServletRequest request, Model model) throws Exception{
		SensorData sensorData = sensorDataService.getRealTimeData();
		sensorData.setRecordtime(new Date());
		model.addAttribute("sensorData", sensorData);
		return AccessPrefix.BCS + "/data";
	}
	
	@RequestMapping("/search")
	public String search(HttpServletRequest request, Model model) throws Exception{
		SensorData sensorData = sensorDataService.getConfigData();
		model.addAttribute("sensorData", sensorData);
		return AccessPrefix.BCS + "/search";
	}
	
	@RequestMapping("/video")
	public String video(HttpServletRequest request, Model model) throws Exception{
		return AccessPrefix.BCS + "/video";
	}
	
	@RequestMapping("/home")
	public String home(HttpServletRequest request, Model model) throws Exception{
		return AccessPrefix.BCS + "/home";
	}
	
	@RequestMapping("/getRealTimeData")
	@ResponseBody
	public String getRealTimeData(Model model, HttpServletRequest request) {
		SensorData sensorData = sensorDataService.getRealTimeData();
		sensorData.setRecordtime(new Date());
		return sensorData.toJSONString();
	}
	
	@RequestMapping("/modifyConfig")
	@ResponseBody
	public String modifyConfig(@ModelAttribute() SensorData sensorData, HttpServletRequest request, BindingResult result) {
		if (sensorData == null) {
			return getLoginJSONResult(3).toJSONString();
		}
		if (sensorDataService.updateConfigData(sensorData) != 1) {
			return getLoginJSONResult(3).toJSONString();
		}
		return getLoginJSONResult(2).toJSONString();
	}
}

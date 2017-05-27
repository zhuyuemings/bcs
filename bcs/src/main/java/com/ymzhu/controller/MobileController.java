package com.ymzhu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ymzhu.domain.SensorData;
import com.ymzhu.service.SensorDataService;

/**
 * 客户端控制器
 * 
 * @author ZhuYueMing
 */

@Controller
@RequestMapping("/app")
public class MobileController extends AbstractBaseController {

	@Autowired
	private SensorDataService sensorDataService;

	@RequestMapping("/getData")
	@ResponseBody
	public Map<String, Object> getData(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> obj = new HashMap<String, Object>();
		SensorData sensorData = sensorDataService.getRealTimeData();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		String time = sdf.format(new Date());
		obj.put("recordtime", "时间：" + time);
		obj.put("temperature", "温度(摄氏度):" + sensorData.getTemperature());
		obj.put("humidity", "湿度(百分比):" + sensorData.getHumidity());
		obj.put("sound", "声音(分贝):" + sensorData.getSound());
		obj.put("outvalue", sensorDataService.isOutValue());
		return obj;
	}

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response) {

	}

}

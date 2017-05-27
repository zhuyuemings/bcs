package com.ymzhu.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.ymzhu.dao.SensorDataMapper;
import com.ymzhu.domain.SensorData;
import com.ymzhu.service.SensorDataService;

@Service("sensorDataService")
public class SensorDataServiceImpl implements SensorDataService {

	@Resource
	private SensorDataMapper sensorDataMapper;

	@Override
	public SensorData getRealTimeData() {
		return sensorDataMapper.getRealTimeData();
	}

	@Override
	public String getAllSensorData(int x) {
		List<SensorData> sensorDatas = sensorDataMapper.getAllSensorData();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONArray all = new JSONArray();
		for (SensorData sensorData : sensorDatas) {
			JSONArray one = new JSONArray();
			one.add(sdf.format(sensorData.getRecordtime()));
			if (x == 0) {
				one.add(Integer.parseInt(sensorData.getTemperature()));
			} else {
				one.add(Integer.parseInt(sensorData.getHumidity()));
			}
			all.add(one);
		}
		return all.toJSONString();
	}

	@Override
	public List<SensorData> getSensorDataList() {
		List<SensorData> sensorDatas = sensorDataMapper.getAllSensorData();
		return sensorDatas;
	}

	@Override
	public SensorData getConfigData() {
		return sensorDataMapper.getConfigData();
	}

	@Override
	public int updateConfigData(SensorData sensorData) {
		return sensorDataMapper.updateConfigData(sensorData);
	}

	@Override
	public boolean isOutValue() {
		SensorData r = sensorDataMapper.getRealTimeData();
		SensorData c = sensorDataMapper.getConfigData();
		if(r == null || c == null){
			return false;
		}
		if( Integer.parseInt(r.getTemperature()) >= Integer.parseInt(c.getTemperature())){
			return true;
		}
		if( Integer.parseInt(r.getHumidity()) >= Integer.parseInt(c.getHumidity())){
			return true;
		}
		if( Integer.parseInt(r.getSound()) >= Integer.parseInt(c.getSound())){
			return true;
		}
		return false;
	}

}

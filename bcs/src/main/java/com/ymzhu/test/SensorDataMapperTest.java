package com.ymzhu.test;

import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONArray;
import com.ymzhu.dao.SensorDataMapper;
import com.ymzhu.domain.SensorData;

import jdk.nashorn.internal.ir.annotations.Ignore;

/**
 * 传感器数据记录Mapper测试
 * @author ymzhu
 */
public class SensorDataMapperTest extends BaseTest {
	
	@Autowired
	private SensorDataMapper sensorDataMapper;
	
	@Test
	@Ignore
	public void insertTest(){
		SensorData sensorData = new SensorData("21","6","63");
		if(sensorDataMapper.insertSensorData(sensorData) != 1){
			System.out.println("insert failed！");
			return;
		}
	}
	
	@Test
	@Ignore
	public void selectByIdTest(){
		int id = 2;
		SensorData sensorData = sensorDataMapper.selectSensorDataById(id);
		if(sensorData != null){
			System.out.println(sensorData);
		}
	}
	
	@Test
	@Ignore
	public void getRealTimeDataTest(){
		SensorData sensorData = sensorDataMapper.getRealTimeData();
		if(sensorData != null){
			System.out.println(sensorData);
		}
	}
	
	@Test
	public void getConfigData(){
		SensorData sensorData = sensorDataMapper.getConfigData();
		if(sensorData != null){
			System.out.println(sensorData);
		}
	}
	
	@Test
	public void getAllSensorData(){
		List<SensorData> sensorDatas = sensorDataMapper.getAllSensorData();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		JSONArray all = new JSONArray();
		for (SensorData sensorData : sensorDatas) {
			JSONArray one = new JSONArray();
			one.add(sdf.format(sensorData.getRecordtime()));
			one.add(sensorData.getTemperature());
			one.add(sensorData.getHumidity());
			all.add(one);
		}
		System.out.println(all.toString());
	}
	
	@Test
	public void updateConfigData(){
		SensorData sensorData = new SensorData("36", "300", "33");
		int update = sensorDataMapper.updateConfigData(sensorData);
		System.out.println(update);
	}

}

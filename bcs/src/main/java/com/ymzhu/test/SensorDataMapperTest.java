package com.ymzhu.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ymzhu.dao.SensorDataMapper;
import com.ymzhu.domain.SensorData;

/**
 * 传感器数据记录Mapper测试
 * @author ymzhu
 */
public class SensorDataMapperTest extends BaseTest {
	
	@Autowired
	private SensorDataMapper sensorDataMapper;
	
	@Test
	public void insertTest(){
		SensorData sensorData = new SensorData("21","6","63");
		if(sensorDataMapper.insertSensorData(sensorData) != 1){
			System.out.println("insert failed！");
			return;
		}
	}
	
	@Test
	public void selectTest(){
		int id = 2;
		SensorData sensorData = sensorDataMapper.selectSensorDataById(id);
		if(sensorData != null){
			System.out.println(sensorData);
		}
	}

}

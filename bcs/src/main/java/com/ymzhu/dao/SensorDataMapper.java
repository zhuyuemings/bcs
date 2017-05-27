package com.ymzhu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ymzhu.domain.SensorData;

/**
 * 传感器数据记录Mapper
 * @author ymzhu
 */
public interface SensorDataMapper {
	int insertSensorData(@Param("sensorData") SensorData sensorData);
	
	SensorData selectSensorDataById(@Param("id") int id);
	
	SensorData getRealTimeData();
	
	SensorData getConfigData();
	
	List<SensorData> getAllSensorData();
	
	int updateConfigData(@Param("sensorData") SensorData sensorData);
}

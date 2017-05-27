package com.ymzhu.service;

import java.util.List;
import com.ymzhu.domain.SensorData;

public interface SensorDataService {
	
	/**
	 * 获取实时数据
	 * @return SensorData
	 */
	public SensorData getRealTimeData();
	
	/**
	 * 获取配置数据
	 * @return SensorData
	 */
	public SensorData getConfigData();
	
	/**
	 * 获取全部数据（用于图标显示）
	 * @return String
	 */
	public String getAllSensorData(int x);
	
	/**
	 * 获取全部数据（用于列表显示）
	 * @return List<SensorData>
	 */
	public List<SensorData> getSensorDataList();
	
	/**
	 * 修改配置
	 * @param sensorData
	 * @return int
	 */
	int updateConfigData(SensorData sensorData);
	
	/**
	 * 查看是否超出阈值
	 * @return boolean
	 */
	boolean isOutValue();
}

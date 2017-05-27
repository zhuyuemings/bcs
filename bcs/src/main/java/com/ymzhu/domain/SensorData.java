package com.ymzhu.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;

/**
 * 传感器数据记录实体类
 * 
 * @author ymzhu
 */
public class SensorData {
	/**
	 * 记录ID
	 */
	private int id;

	/**
	 * 记录时间
	 */
	private Date recordtime;

	/**
	 * 记录温度
	 */
	private String temperature;

	/**
	 * 记录湿度
	 */
	private String humidity;

	/**
	 * 记录声音
	 */
	private String sound;

	/**
	 * 传感器数据记录实体类构造器
	 */
	public SensorData() {
		super();
	}
	
	/**
	 * 传感器数据记录实体类构造器
	 * @param temperature
	 * @param humidity
	 * @param sound
	 */
	public SensorData(String temperature, String humidity, String sound) {
		super();
		this.recordtime = new Date();
		this.temperature = temperature;
		this.humidity = humidity;
		this.sound = sound;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	@Override
	public String toString() {
		return "SensorData [" + id + "," + recordtime + "," + temperature + "," + humidity + "," + sound + "]";
	}
	
	public String toJSONString(){
		JSONObject obj = new JSONObject();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
		if(this.recordtime != null){
			String time = sdf.format(this.recordtime);
			obj.put("recordtime", "时间：" + time);
		}else{
			String time = sdf.format(new Date());
			obj.put("recordtime", "时间：" + time);
		}
		obj.put("temperature", "温度(摄氏度):" + this.temperature);
		obj.put("humidity", "湿度(百分比):" + this.humidity);
		obj.put("sound", "声音(分贝):" + this.sound);
		return obj.toJSONString();
	}

}

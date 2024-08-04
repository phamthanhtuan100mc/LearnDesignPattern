package WeatherForecast;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	
	private List<Observer> observers;
	private float temperature;
	private float humidity;
	private float pressure;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		int position = observers.indexOf(observer);
		if (position >= 0) {
			observers.remove(position);
		}
	}

	@Override
	public void notifyObserver() {
		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged() {
		notifyObserver();
	}
	
	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChanged();
	}

	public void getTemperature(float tempurature) {
		this.temperature = tempurature;
	}
	public void getHumidity(float humidity) {
		this.humidity = humidity;
	}
	public void getPressure(float pressure) {
		this.pressure = pressure;
	}
	
	
}

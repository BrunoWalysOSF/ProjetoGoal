package digital.osf.hackazillians.dto.chat;

import digital.osf.hackazillians.constant.WeatherUnit;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeatherResponse {

    public String location;
    public WeatherUnit unit;
    public int temperature;
    public String description;
}

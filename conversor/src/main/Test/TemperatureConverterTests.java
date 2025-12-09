import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TemperatureConverterTest {

    TemperatureConverter tempConverter = new TemperatureConverter();

    @Test
    void testCelsiusToKelvin() {
        float result = tempConverter.convert(0, TemperatureConverter.ConversionType.CELSIUS_TO_KELVIN);
        assertEquals(TemperatureConverter.KELVIN_CONSTANT, result);
    }

    @Test
    void testKelvinToCelsius() {
        float result = tempConverter.convert(300, TemperatureConverter.ConversionType.KELVIN_TO_CELSIUS);
        assertEquals(300 - TemperatureConverter.KELVIN_CONSTANT, result);
    }

    @Test
    void testKelvinToCelsius_TemperatureBelowZero() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> tempConverter.convert(-1, TemperatureConverter.ConversionType.KELVIN_TO_CELSIUS)
        );
    }

    @Test
    void testCelsiusToKelvin_TemperatureBelowZero() {
        float num = -TemperatureConverter.KELVIN_CONSTANT - 1;

        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> tempConverter.convert(num, TemperatureConverter.ConversionType.CELSIUS_TO_KELVIN)
        );
        assertEquals(TemperatureConverter.INVALID_TEMPERATURE, ex.getMessage());
    }

    @Test
    void testNullConversionType() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class, () -> tempConverter.convert(10, null)
        );
        assertEquals("Invalid conversion type", ex.getMessage());
    }
}





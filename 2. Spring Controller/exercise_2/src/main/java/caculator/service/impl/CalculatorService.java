package caculator.service.impl;

import caculator.service.ICalculatorService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("calculator")
public class CalculatorService implements ICalculatorService {
    @Override
    public String calculator(Map<String, String> calculator) {
        String result = "";
        try {
            int number1 = Integer.parseInt(calculator.get("number1"));
            int number2 = Integer.parseInt(calculator.get("number2"));
            String cal = calculator.get("calculator");
            switch (cal) {
                case "addition": {
                    result = Integer.toString(number1 + number2);
                    break;
                }
                case "subtraction": {
                    result = Integer.toString(number1 - number2);
                    break;
                }
                case "multiplication": {
                    result = Integer.toString(number1 * number2);
                    break;
                }
                case "division": {
                    if (number2 != 0) {
                        result = Integer.toString(number1 / number2);
                    } else {
                        result = "The denominator must be other than 0, please enter again!";
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

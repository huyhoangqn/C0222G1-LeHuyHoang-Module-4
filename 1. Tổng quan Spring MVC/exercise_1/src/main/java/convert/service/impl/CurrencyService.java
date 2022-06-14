package convert.service.impl;

import convert.service.ICurrencyService;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService implements ICurrencyService {
    @Override
    public float currencyResult(float usd, float rate) {
        return (usd * rate);
    }
}

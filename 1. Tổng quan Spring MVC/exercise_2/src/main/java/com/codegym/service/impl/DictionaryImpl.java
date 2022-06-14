package com.codegym.service.impl;

import com.codegym.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryImpl implements IDictionaryService {
    @Override
    public String dictionary(String word) {
        Map<String, String> dic = new HashMap<>();
        dic.put("hello", "Xin chào");
        dic.put("how", "Thế nào");
        dic.put("book", "Quyển vở");
        dic.put("computer", "Máy tính");

        word = word.toLowerCase();
        String result = dic.get(word);
        if (result != null) {
            return result;
        } else {
            return "Not found";
        }
    }
}

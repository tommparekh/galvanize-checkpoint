package com.cts.galvanize.checkpoint;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class EncodeController {
    //message=a little of this and a little of that&key=mcxrstunopqabyzdefghijklvw
    @PostMapping("/encode")
    public String encoded(@RequestParam String message, @RequestParam String key) {
        String baseKey = "abcdefghijklmnopqrstuvwxyz";
        char[] baseKeyArray = baseKey.toCharArray();
        char[] keyArray = key.toCharArray();
        HashMap<String, String> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder(message);
        int i = 0;
        for (char c : baseKeyArray) {
            hashMap.put(String.valueOf(baseKeyArray[i]), String.valueOf(keyArray[i]));
            i++;
        }
        sb.append(" ");

        for (i = 0; i < message.length(); i++) {
            String charAt = String.valueOf(sb.charAt(i));
            if (charAt.equals(" ") || charAt.isEmpty() || charAt.trim().equals("")) {
                continue;
            }
            String temp = (hashMap.get(charAt));
            sb.replace(i, i + 1, temp);
        }

        return sb.toString().trim();
    }

}

package com.cts.galvanize.checkpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CamelizeController {

    @GetMapping("/camelize")
    public String camelize(@RequestParam String original
            , @RequestParam(required = false) boolean initialCap) throws Exception {

        String[] originalArr = original.split("_");
        StringBuilder builder = new StringBuilder();
        int startIndex = 0;

        if (initialCap) {
            return getCamelizeStr(originalArr, builder, 0);
        } else {
            builder.append(originalArr[0]);
            startIndex = 1;
            return getCamelizeStr(originalArr, builder, startIndex);
        }

    }

    private String getCamelizeStr(String[] originalArr, StringBuilder builder, int startIndex) {
        for (int i = startIndex; i < originalArr.length; i++) {
            String str = originalArr[i];
            String c = str.substring(0, 1).toUpperCase();
            builder.append(c).append(str.substring(1));
        }

        return builder.toString();
    }
}

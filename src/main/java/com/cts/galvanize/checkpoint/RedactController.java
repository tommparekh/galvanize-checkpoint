package com.cts.galvanize.checkpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RedactController {
    @GetMapping("/redact")

    public String redact(@RequestParam String original,
                         @RequestParam(value="badwords") List<String> badwords)
    {
        //original.replace()
        for (String word:badwords)
        {
            StringBuilder strbuilder = new StringBuilder();

            for (int i=0;i<word.length();i++)
            {
                strbuilder.append("*");
            }
            original = original.replace(word,strbuilder.toString());

        }
        return original;

    }

}

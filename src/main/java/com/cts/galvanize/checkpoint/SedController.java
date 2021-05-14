package com.cts.galvanize.checkpoint;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SedController {
    @PostMapping("/sed/{find}/{replace}")
    public String sed(@PathVariable String find, @PathVariable String replace
            , @RequestBody String message) {
        StringBuilder sb = new StringBuilder();
        sb.append(message);

        StringBuilder finalSb = new StringBuilder();

        while (true) {
            int i = sb.indexOf(find);
            if (i < 0) {
                break;
            }
            sb.replace(i, i + find.length(), replace);
        }
        return sb.toString();
    }
}

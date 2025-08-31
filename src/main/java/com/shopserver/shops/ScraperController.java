package com.shopserver.shops;

import java.io.File;
import java.io.IOException;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScraperController {

    @PostMapping("/scrape")
    public String scrape(@RequestParam String shopName) {

        try (Context context = Context.create()) {

            if (shopName == null || shopName.isBlank()) {
                return "Shop name is required.";
            }

            Source tescoSrc = Source.newBuilder("python", new File("src/python-resources/" + shopName + ".py")).build();
            context.eval(tescoSrc);

            Value pyClass = context.getBindings("python").getMember(shopName);
            Value instance = pyClass.newInstance(shopName);
            Value result = instance.invokeMember("run", shopName);

            return result.asString();
        }catch (IOException e) {
            return null;
        }

    }// End of scrape()

}// End of ScraperController.java

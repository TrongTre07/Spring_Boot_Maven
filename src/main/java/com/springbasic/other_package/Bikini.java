package com.springbasic.other_package;

import com.springbasic.Outfit;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Bikini implements Outfit {
    @Override
    public void wear() {
        System.out.println("Wearing");
    }
}

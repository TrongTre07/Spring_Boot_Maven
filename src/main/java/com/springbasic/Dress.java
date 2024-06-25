package com.springbasic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Dress implements Outfit {

    @Override
    public void wear() {
        System.out.println("PRINTING");
    }
}

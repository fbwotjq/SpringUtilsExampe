package com.example.demo.sample;

import org.springframework.stereotype.Service;

@Service
public class HahaService {

    public String typeAaa() {
        return "aaa";
    }

    public String typeBbb(String input) {
        return "bbb";
    }

    public String typeCcc(String input, String other) {
        return "ccc";
    }

}

package com.example.demo.sample;

import com.example.demo.mapper.EventMapper;
import com.example.demo.pojo.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KukuService {

    @Autowired EventMapper eventMapper;

    public Event selectOneEvent(String id) {
        return eventMapper.findById(Integer.parseInt(id));
    }

}

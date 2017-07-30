package com.example.demo.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HahaController {

    @Autowired ApplicationContext applicationContext;

    @RequestMapping(value = "/haha", method = RequestMethod.GET)
    @ResponseBody public Map<String, Object> haha(String requestCode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<String, Object> result = new HashMap<>();

        Class<?> clazz = Class.forName("com.example.demo.sample.HahaService");
        Object target = clazz.newInstance();

        final Method getEventMethod = ReflectionUtils.findMethod(HahaService.class, "typeAaa");
        ReflectionUtils.makeAccessible(getEventMethod);
        Object returnValue = ReflectionUtils.invokeMethod(getEventMethod, target);

        result.put("result", returnValue);

        return result;

    }

    @RequestMapping(value = "/hoho", method = RequestMethod.GET)
    @ResponseBody public Map<String, Object> hoho(String requestCode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<String, Object> result = new HashMap<>();

        Class<?> clazz = Class.forName("com.example.demo.sample.HahaService");
        Object target = clazz.newInstance();

        final Method getEventMethod = ReflectionUtils.findMethod(HahaService.class, "typeBbb", String.class);
        ReflectionUtils.makeAccessible(getEventMethod);
        Object returnValue = ReflectionUtils.invokeMethod(getEventMethod, target, "aaa");

        result.put("result", returnValue);

        return result;

    }

    @RequestMapping(value = "/keke", method = RequestMethod.GET)
    @ResponseBody public Map<String, Object> keke(String requestCode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<String, Object> result = new HashMap<>();

        Class<?> clazz = Class.forName("com.example.demo.sample.HahaService");
        Object target = clazz.newInstance();

        final Method getEventMethod = ReflectionUtils.findMethod(HahaService.class, "typeCcc", String.class, String.class);
        ReflectionUtils.makeAccessible(getEventMethod);
        Object returnValue = ReflectionUtils.invokeMethod(getEventMethod, target, "aaa", "bbb");

        result.put("result", returnValue);

        return result;

    }

    @RequestMapping(value = "/kuku", method = RequestMethod.GET)
    @ResponseBody public Map<String, Object> kuku(String requestCode) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Map<String, Object> result = new HashMap<>();

        Object target = applicationContext.getBean(KukuService.class);

        final Method getEventMethod = ReflectionUtils.findMethod(KukuService.class, "selectOneEvent", String.class);
        ReflectionUtils.makeAccessible(getEventMethod);
        Object returnValue = ReflectionUtils.invokeMethod(getEventMethod, target, "1");
        result.put("result", returnValue);

        return result;

    }

}

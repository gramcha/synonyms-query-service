package com.gramcha.controller;

import com.gramcha.services.DatamuseClientService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;

/**
 * Created by gramachandran on 26/10/18.
 */
@RestController
public class SynonymsQueryController {
    @Autowired
    DatamuseClientService datamuseClientService;

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(path = "/synonyms/{word}")
    public String synonyms(@PathVariable String word) throws UnknownHostException {
        return datamuseClientService.getSynonyms(word);
    }

    public String fallback(String word, Throwable hystrixCommand){
        System.out.println(hystrixCommand.toString());
        return word;
    }
}

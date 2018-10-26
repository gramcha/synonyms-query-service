package com.gramcha.controller;

import com.gramcha.services.DatamuseClientService;
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

    @RequestMapping(path = "/synonyms/{word}")
    public String synonyms(@PathVariable String word) throws UnknownHostException {
        return datamuseClientService.getSynonyms(word);
    }
}

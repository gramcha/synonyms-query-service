package com.gramcha.services;

import com.gramcha.model.SynonymsResult;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Created by gramachandran on 26/10/18.
 */
@Service
public class DatamuseClientService {
    RestTemplate client = new RestTemplate();
    public String getSynonyms(String word) {
        String url = "https://api.datamuse.com/"+"words?rel_syn="+word;
        ResponseEntity<List<SynonymsResult>> response = client.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SynonymsResult>>(){});
        return getBestSynonyms(response.getBody(),word);
    }
    public String getBestSynonyms(List<SynonymsResult> synonymsResultList,String word){
        Optional<SynonymsResult> result = synonymsResultList
                .stream()
                .max(Comparator.comparing(SynonymsResult::getScore));
        return result.isPresent()?result.get().getWord():word;
    }
}

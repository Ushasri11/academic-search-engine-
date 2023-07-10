package com.academicSearchEngine.search.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.academicSearchEngine.search.commons.utils.Utils;
import com.academicSearchEngine.search.dto.DuckDuckGoRelatedTopic;
import com.academicSearchEngine.search.dto.DuckDuckGoResponse;
import com.academicSearchEngine.search.dto.DuckDuckGoSaveDto;


@Service
public class WebScrapingService{

	@Value("${duckduckgo.api.url}")
	private String duckDuckGoApiUrl;

	public List<DuckDuckGoRelatedTopic> getAllResult(String search) {

		List<DuckDuckGoRelatedTopic> responseList = new ArrayList<>();
		try {
			List<DuckDuckGoRelatedTopic> searchRelatedResults = getAllResultsBasesOnSearch(search);
			if (Utils.checkCollectionIsNotEmpty(searchRelatedResults)) {
				for (DuckDuckGoRelatedTopic relatedTopic : searchRelatedResults) {
					if ((StringUtils.isNotBlank(relatedTopic.getName())
							&& relatedTopic.getName().equalsIgnoreCase("See also"))) {
						break;
					} else {
						responseList.add(relatedTopic);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseList;
	}

	private List<DuckDuckGoRelatedTopic> getAllResultsBasesOnSearch(String search) {
		ResponseEntity<DuckDuckGoResponse> duckDuckGoResponse = null;
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		messageConverters.add(converter);

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(headers);

		ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(
				HttpClients.createDefault());
		RestTemplate template = new RestTemplate(requestFactory);
		template.setMessageConverters(messageConverters);
		String url = duckDuckGoApiUrl + "?q=" + search + "&format=json";
		duckDuckGoResponse = template.exchange(url, HttpMethod.GET, entity, DuckDuckGoResponse.class);
		return duckDuckGoResponse.getBody().getRelatedTopics();
	}

	public String saveAllResult(List<DuckDuckGoSaveDto> requestDto, String fileName) {

		try {

			File file = new File("H:\\Syracuse sem 3\\OOD\\" + fileName + ".json");
			String json = Utils.toJsonString(requestDto);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(json);
			bw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Search Result Data Saved";
	}

}

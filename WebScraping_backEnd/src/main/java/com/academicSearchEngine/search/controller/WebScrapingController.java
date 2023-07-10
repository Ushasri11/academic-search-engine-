package com.academicSearchEngine.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.academicSearchEngine.search.commons.utils.RestResponse;
import com.academicSearchEngine.search.commons.utils.RestUtils;
import com.academicSearchEngine.search.dto.DuckDuckGoRelatedTopic;
import com.academicSearchEngine.search.dto.DuckDuckGoResponse;
import com.academicSearchEngine.search.dto.DuckDuckGoSaveDto;
import com.academicSearchEngine.search.service.WebScrapingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/web-scraping")
@Api(value = "/web-scraping", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"Web Scarping Api's" }, hidden = false)
@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
		@ApiResponse(code = 401, message = "Not Authorized"), @ApiResponse(code = 403, message = "Not Authenticated"),
		@ApiResponse(code = 404, message = "Not found"), @ApiResponse(code = 500, message = "Internal Server Error") })
public class WebScrapingController {

	@Autowired
	private WebScrapingService webScrapingService;

	
	@ApiOperation(value = "Get All Results", response = DuckDuckGoResponse.class, httpMethod = "GET", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = DuckDuckGoResponse.class) })
	@GetMapping(path = "/")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public ResponseEntity<RestResponse<List<DuckDuckGoRelatedTopic>>> getAllResults(
			@RequestParam(required = true)  String search) {
		System.out.print("entered the function:");
		return RestUtils.successResponse(webScrapingService.getAllResult(search));
	}
	
	@ApiOperation(value = "Save All Results", response = String.class, httpMethod = "POST", notes = "")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "", response = DuckDuckGoResponse.class) })
	@PostMapping(path = "/")
	@CrossOrigin(origins = "http://localhost:3000")
	@ResponseBody
	public ResponseEntity<RestResponse<String>> saveAllResults(
			@RequestBody List<DuckDuckGoSaveDto> requestDto,
			@RequestParam(required = true) String fileName) {
		System.out.println(fileName);
		return RestUtils.successResponse(webScrapingService.saveAllResult(requestDto, fileName));
	}
	


}

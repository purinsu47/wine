package com.flexisource.winery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flexisource.winery.model.Wine;
import com.flexisource.winery.service.WineService;
import com.flexisource.winery.util.Success;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/")
public class RestWineController {

	@Autowired
	private WineService wineService;

	@ApiOperation(value = "Add a new Wine details.")
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ResponseEntity<?> addNewWine(@RequestBody Wine wine) {
		wineService.saveWine(wine);
		Success success = new Success(true, "Successfully Added");
		return new ResponseEntity<Success>(success, HttpStatus.OK);

	}

}

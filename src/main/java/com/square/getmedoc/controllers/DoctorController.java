package com.square.getmedoc.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.swing.SortOrder;

import org.hibernate.dialect.function.ConvertFunction;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.hateoas.DoctorRA;
import com.square.getmedoc.services.AppuserService;
import com.square.getmedoc.util.AppUrlConstants;
import com.square.getmedoc.util.RequestUtil;

@Controller
@RequestMapping(value = AppUrlConstants.ROOT_DOCTORS, produces = MediaType.APPLICATION_JSON_VALUE)
public class DoctorController {
	
	private AppuserService appuserService;
	private DoctorRA doctorRA;
	
	@Inject
	public DoctorController(AppuserService appuserService, DoctorRA doctorRA){
		this.appuserService = appuserService;
		this.doctorRA = doctorRA;
	}
	
	/*@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<Resources<Resource<Appuser>>> getAllDoctors(@RequestParam(value="sortBy") String sortField, @RequestParam(value="order") String sortOrder, @RequestParam(value="pageNo") int pageNo, @RequestParam(value="pageSize") int pageSize){
		Collection<Resource<Appuser>> userResCollection = new ArrayList<Resource<Appuser>>();
		List<Appuser> users = appuserService.findByUsertype(1);
		for(Appuser u : users){
			userResCollection.add(doctorRA.toResource(u));
		}
		Link self = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DoctorController.class).getAllDoctors(sortField, sortOrder, pageNo, pageSize)).withSelfRel();
		Resources<Resource<Appuser>> userResources = new Resources<Resource<Appuser>>(userResCollection, self);
		return new ResponseEntity<Resources<Resource<Appuser>>>(userResources, HttpStatus.OK);
	}*/
	
	@RequestMapping(method=RequestMethod.GET, value=AppUrlConstants.URL_DOCTORS_DOCTOR)
	public HttpEntity<Resource<Appuser>> getDoctor(@PathVariable(value="doctor") Long doctorId){
		return new ResponseEntity<Resource<Appuser>>(doctorRA.toResource(appuserService.findOne(doctorId)), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public HttpEntity<Resources<Resource<Appuser>>> getFilteredDoctors(@RequestParam Map<String, String> requestParams){
	//public HttpEntity<Resources<Resource<Appuser>>> getFilteredDoctors(@RequestParam(value="_search") String filterStr, 
		//@RequestParam(value="sortBy") String sortField, @RequestParam(value="order") String sortOrder, 
		//@RequestParam(value="pageNo") int pageNo, @RequestParam(value="pageSize") int pageSize){
		
		Collection<Resource<Appuser>> userResCollection = new ArrayList<Resource<Appuser>>();
		int pageNo = requestParams.containsKey("pageNo") ? Integer.parseInt(requestParams.get("pageNo")) : 0;
		int pageSize = requestParams.containsKey("pageSize") ? Integer.parseInt(requestParams.get("pageSize")) : 0;
		String sortField = requestParams.containsKey("sortField") ? requestParams.get("pageNo") : null;
		String sortOrder = requestParams.containsKey("sortOrder") ? requestParams.get("sortOrder") : null;
		
		List<Appuser> users = appuserService.loadDoctors(pageNo, pageSize, sortField, "desc".equalsIgnoreCase(sortOrder) ? SortOrder.DESCENDING : SortOrder.ASCENDING, requestParams);
		for(Appuser u : users){
			userResCollection.add(doctorRA.toResource(u));
		}
		Link self = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DoctorController.class).getFilteredDoctors(requestParams)).withSelfRel();
		Resources<Resource<Appuser>> userResources = new Resources<Resource<Appuser>>(userResCollection, self);
		return new ResponseEntity<Resources<Resource<Appuser>>>(userResources, HttpStatus.OK);
	}
}

package com.square.getmedoc.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;

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

import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.hateoas.DoctorRA;
import com.square.getmedoc.services.AppuserService;
import com.square.getmedoc.util.AppUrlConstants;

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
	
	@RequestMapping(method = RequestMethod.GET)
	public HttpEntity<Resources<Resource<Appuser>>> getAllDoctors(){
		Collection<Resource<Appuser>> userResCollection = new ArrayList<Resource<Appuser>>();
		List<Appuser> users = appuserService.findByUsertype(1);
		for(Appuser u : users){
			userResCollection.add(doctorRA.toResource(u));
		}
		Link self = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DoctorController.class).getAllDoctors()).withSelfRel();
		Resources<Resource<Appuser>> userResources = new Resources<Resource<Appuser>>(userResCollection, self);
		return new ResponseEntity<Resources<Resource<Appuser>>>(userResources, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value=AppUrlConstants.URL_DOCTORS_DOCTOR)
	public HttpEntity<Resource<Appuser>> getDoctor(@PathVariable(value="doctor") Long doctorId){
		return new ResponseEntity<Resource<Appuser>>(doctorRA.toResource(appuserService.findOne(doctorId)), HttpStatus.OK);
	}
}

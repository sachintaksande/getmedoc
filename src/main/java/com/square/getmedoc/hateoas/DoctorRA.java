package com.square.getmedoc.hateoas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Component;

import com.square.getmedoc.controllers.DoctorController;
import com.square.getmedoc.db.model.Appuser;
import com.square.getmedoc.util.ObjectCopy;

@Component
public class DoctorRA implements ResourceAssembler<Appuser, Resource<Appuser>>{

	@Override
	public Resource<Appuser> toResource(Appuser u) {
		Appuser user = new Appuser();
		user = (Appuser)ObjectCopy.copyObject(u, user, Appuser.class, Arrays.asList("password,enabled,username"), null);
		long userId = user.getAppuserid();
		user.setAppuserid(0);
		List<Link> links = new ArrayList<Link>(0);
		links.add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(DoctorController.class).getDoctor(userId)).withSelfRel());
		return new Resource<Appuser>(user, links);
	}

}

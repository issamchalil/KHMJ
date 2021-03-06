package com.KHMJ.API;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;

import KHMJ.DataLayer.Member;
import KHMJ.DataLayer.MemberDL;

@Path("/Members")
public class MemberAPI {
	@Path("/GetMembers")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String GetMembers() {
		List<Member> members = new MemberDL().GetMembers();

		String jsonString = "";

		try {
			ObjectMapper om = new ObjectMapper();
			jsonString = om.writeValueAsString(members);
		} catch (Exception ex) {

		}

		return jsonString;
	}

	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello World RESTful Jersey"
				+ "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello() {
		return "<html> " + "<title>" + "Hello World RESTful Jersey"
				+ "</title>" + "<body><h1>" + "Hello World RESTful Jersey"
				+ "</body></h1>" + "</html> ";
	}
}

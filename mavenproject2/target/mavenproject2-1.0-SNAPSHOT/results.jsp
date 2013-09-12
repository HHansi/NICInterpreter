
<%@page import="cse.maven.sample.exception.InvalidNICPropException"%>
<%@page import="cse.maven.sample.NICProp"%>
<%@page import="cse.maven.sample.NIC_Interpreter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>NIC interpreter</title>
</head>
<h1>Results of NIC interpretation</h1>

<%
	String NIC = request.getParameter("NIC");
	
	NIC_Interpreter nic = new NIC_Interpreter();
	
	try {
                NICProp nicProp= nic.createNICProp(NIC);
		String output = nic.Output(nicProp);
		out.println("NIC: " + NIC);
                out.print("\n");
                out.println(" [ " +output +" ] ");
	} catch (InvalidNICPropException ex) {
		out.println(ex.getMessage());
	}	
%>

</html>
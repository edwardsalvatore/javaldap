package com.example.AD;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.Attribute;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Properties;
import java.util.jar.Attributes;

import javax.naming.AuthenticationException;

import javax.naming.NamingException;


@RestController
public class controller {
DirContext connection;
testAd a=new testAd();
Object lapEnv = a.hello();
Hashtable<?, ?> ldapEnv=(Hashtable<?, ?>) lapEnv;
@RequestMapping("/")

	public ModelAndView getReportsByCategory1() throws Exception{

		   ModelAndView modelAndView = new ModelAndView();
		   modelAndView.setViewName("index.html");
		   return modelAndView;

		}
	
//	https://github.com/talenteddeveloper/LDAPWithJava/blob/master/src/main/java/ldap/learn/App.java  
	
	


@RequestMapping("/getall")
public ArrayList<String> getall() throws NamingException{
			try {
		
				connection = new InitialDirContext(ldapEnv);
				String searchFilter = Varible.SEARCH;
				String[] reqAtt = { "cn", "sn" };
				SearchControls controls = new SearchControls();
				controls.setSearchScope(SearchControls.SUBTREE_SCOPE);
				controls.setReturningAttributes(reqAtt);
			      NamingEnumeration<SearchResult> answer = connection.search(Varible.AD, searchFilter, controls);
			      ArrayList<String> list = new ArrayList<String>();  
			      //Loop through the search results
			      while (answer.hasMoreElements())
			      {
			        SearchResult sr = (SearchResult)answer.next();
			        String m=new String();
			        javax.naming.directory.Attributes attrs = sr.getAttributes();
			        m=sr.getName();
			        list.add(m);
			        System.out.println(">>>" + sr.getName());
			      }
			      return list;
			} catch (AuthenticationException ex) {
				System.out.println(ex.getMessage());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
		
}

@RequestMapping("/adduser")
public String addUser() {
	BasicAttributes attributes = new BasicAttributes();
	Attribute attribute = new BasicAttribute("objectClass");
	attribute.add("person");
	attributes.put(attribute);
	attributes.put("sn", "Ricky");
	try {
		connection = new InitialDirContext(ldapEnv);
		connection.createSubcontext(Varible.ADDUSER, attributes);
		System.out.println("success");
		return "user added";
	} catch (NamingException e) {
		e.printStackTrace();
	}
	return "probelm";

}

@RequestMapping("/deluser")
public String deleteUser()
{
	try {
		connection = new InitialDirContext(ldapEnv);
		connection.destroySubcontext(Varible.DELUSER);
		System.out.println("success");
		return "suscess in deleteing user";
	} catch (NamingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
}
//@RequestMapping(value ="/hey")
//public ModelAndView getReportsByCategory() throws Exception{
//
//   ModelAndView modelAndView = new ModelAndView();
//   modelAndView.setViewName("index.html");
//   return modelAndView;
//
//}
}



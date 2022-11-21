package com.example.AD;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

public class testAd {
	@SuppressWarnings("unchecked")
	public <ldapEnv> ldapEnv hello() {
		
	 try
	    {
	      

	      Hashtable<String, String> ldapEnv = new Hashtable<String, String>(500);
	      ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	
	      ldapEnv.put(Context.PROVIDER_URL,  Varible.URL);
	      ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");

	      ldapEnv.put(Context.SECURITY_PRINCIPAL, Varible.PARENTROOT);
	      ldapEnv.put(Context.SECURITY_CREDENTIALS, Varible.Password);


	     return (ldapEnv) ldapEnv;
	    }
	    catch (Exception e)
	    {
	      System.out.println(" Search error: " + e);
	      e.printStackTrace();
	      System.exit(-1);
	    }
	return null;
	  }

}

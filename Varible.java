package com.example.AD;

public class Varible {

	//Connection
	public static final String URL ="ldap://192.168.18.75:389";
	public static final String root="dc=simeiolab,dc=in";
	public static final String PARENTROOT= "uid=mjawaad,ou=trainingusers,"+root;
	public static final String Password = "ldap$321";

	//AD
	public static final String AD= "ou=jaw,ou=mjawaad,"+root;
	public static final String SEARCH= "(&(objectClass=person))";


	
	//USER
	public static final String ADDUSER = "cn=Tommy,ou=mjawaad,"+root;	
	public static final String DELUSER="cn=Tommy,ou=mjawaad,"+root ;
	
	


}

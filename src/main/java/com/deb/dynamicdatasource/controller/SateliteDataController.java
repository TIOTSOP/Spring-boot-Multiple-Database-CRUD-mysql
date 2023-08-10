package com.deb.dynamicdatasource.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.deb.dynamicdatasource.enums.Satelites;
import com.deb.dynamicdatasource.service.AryabhataDataService;
import com.deb.dynamicdatasource.service.SARALDataService;

import com.deb.dynamicdatasource.service.ProclistService;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.deb.dynamicdatasource.config.DataBaseContextHolder;
import com.deb.dynamicdatasource.enums.DatabaseContext;
import com.deb.dynamicdatasource.enums.Satelites;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.swing.*;
import java.awt.*;

//modif du 03/06/2022
import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Collections;
import java.util.Iterator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.BasicFileAttributes;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  
import java.text.SimpleDateFormat;


import com.deb.dynamicdatasource.service.TicketService;

//modif du 16/09/2022
import org.springframework.web.bind.annotation.PathVariable;
//@RestController
@Controller
@Log4j2
public class SateliteDataController {

	@Autowired
	private SARALDataService saralDataService;

	@Autowired
	private AryabhataDataService aryabhatDataService;
	
	@Autowired
	private ProclistService proclistService;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired 
	private Environment env;
	
/* 	@GetMapping("/")
	public ModelAndView test() {
		ModelAndView view = new ModelAndView();
		view.setViewName("procreps");
		return view;
	} */
	
	@GetMapping("/")
	public String test(Model model) {
		// ModelAndView view = new ModelAndView();
		// view.setViewName("procreps");
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
		log.info("Databse context holder :{}", DataBaseContextHolder.getCurrentDb());
		try{
		model.addAttribute("masterproc", proclistService.showprocesslistrep());
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			model.addAttribute("masterprocno", env.getProperty("replication.master") +"Is not running");
		}
		//MODIF DU 28/06/2022
		DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE0);
		log.info("Databse context holder :{}", DataBaseContextHolder.getCurrentDb());
		try{
		model.addAttribute("slave0proc", proclistService.showprocesslistrepcli());
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			model.addAttribute("slave0procno", env.getProperty("replication.slave0") +"Is not running");
		}
		DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE1);
		log.info("Databse context holder :{}", DataBaseContextHolder.getCurrentDb());
		try{
		model.addAttribute("slave1proc", proclistService.showprocesslistrepcli());
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			model.addAttribute("slave1procno", env.getProperty("replication.slave1") +"Is not running");
		}
		DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE2);
		log.info("Databse context holder :{}", DataBaseContextHolder.getCurrentDb());
		try{
		model.addAttribute("slave2proc", proclistService.showprocesslistrepcli());
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			model.addAttribute("slave2procno", env.getProperty("replication.slave2") +"Is not running");
		}
		DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE3);
		log.info("Databse context holder :{}", DataBaseContextHolder.getCurrentDb());
		try{
		model.addAttribute("slave3proc", proclistService.showprocesslistrepcli());
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
			model.addAttribute("slave3procno", env.getProperty("replication.slave3") +"Is not running");
		}
		
		System.out.println ("recherche properties");
		model.addAttribute("masterip", env.getProperty("replication.master"));
		model.addAttribute("slave1ip", env.getProperty("replication.slave1"));
		model.addAttribute("slave2ip", env.getProperty("replication.slave2"));
		model.addAttribute("slave3ip", env.getProperty("replication.slave3"));
		model.addAttribute("slave0ip", env.getProperty("replication.slave0"));
		System.out.println ("ajout properties dans le model");
		 List<String> terms = new ArrayList<String>();
		 List<String> terms25 = new ArrayList<String>();
		 
        /*for (int i = 1; i < 51; i++) {
            terms.add(t + i);
        }
		 */
		System.out.println ("lecture fichier des erreurs");
		//  try{
		// // Open the file that is the first 
		// // command line parameter
		// FileInputStream fstream = new FileInputStream(env.getProperty("replication.patherror"));
		// // Get the object of DataInputStream
		// DataInputStream in = new DataInputStream(fstream);
        // BufferedReader br = new BufferedReader(new InputStreamReader(in));
		// String strLine;
		// terms.add("Debut fichier erreur");
		// terms25.add("Debut fichier erreur");
		// //Read File Line By Line
		// // while ((strLine = br.readLine()) != null) 	{
		// // 	// Print the content on the console
		// // 	//System.out.println (strLine);
		// // 	 //terms.add(strLine);
		// // }
		// //Close the input stream
		// in.close();
		// }catch (Exception e){//Catch exception if any
		// 	System.err.println("Error: " + e.getMessage());
		// }
		// String path=env.getProperty("replication.patherror");
		// int n_lines = 25;
		// ReversedLinesFileReader object = new ReversedLinesFileReader(new File(path));
		// String result="";
		// for(int i=0;i<n_lines;i++){
		// 	String line=object.readLine();
		// 	if(line==null)
		// 		break;
		// 	result+=line;
		// }
		// return result;	
		long lines=25;	
		String lastLine ="";
		String fileerr=env.getProperty("replication.patherror");
		java.io.RandomAccessFile fileHandler = null;
		try {
			fileHandler = 
				new java.io.RandomAccessFile( fileerr, "r" );
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder();
			int line = 0;
	
			for(long filePointer = fileLength; filePointer != -1; filePointer--){
				fileHandler.seek( filePointer );
				int readByte = fileHandler.readByte();
				//System.out.println(fileHandler.readLine());
	
				 if( readByte == 0xA ) {
					if (filePointer < fileLength) {
						line = line + 1;
						lastLine=sb.reverse().toString();
						System.out.println(lastLine);	
						terms25.add(lastLine);		
						sb = new StringBuilder();
					}
				} else if( readByte == 0xD ) {
					if (filePointer < fileLength-1) {
						line = line + 1;
						lastLine=sb.reverse().toString();
						System.out.println(lastLine);
						terms25.add(lastLine);			
						sb = new StringBuilder();
					}
				}else{
					sb.append( ( char ) readByte );
				}

				if (line >= lines) {
					break;
				}
			
				//impression
				//System.out.println(sb.toString());			
			}
			
			if (sb.length()>0){
				lastLine=sb.reverse().toString();
				System.out.println(lastLine);	
				terms25.add(lastLine);		
				sb = new StringBuilder();
				
			}

			//lastLine = sb.reverse().toString();
			//return lastLine;
			//terms25.add(lastLine);
		} catch( java.io.FileNotFoundException e ) {
			e.printStackTrace();
			//return null;
		} catch( java.io.IOException e ) {
			e.printStackTrace();
			//return null;
		}
		finally {
			if (fileHandler != null )
				try {
					fileHandler.close();
				} catch (IOException e) {
				}
		}


		 for (int i = terms25.size()-1; i >=0; i--) {
             terms.add(terms25.get(i));
         }
		
		model.addAttribute("mysqlerrors", terms);


		String pathsave=env.getProperty("replication.pathsav");
		//gestion des fichiers dans le repertoire
		 List<String> savs = new ArrayList<String>();
		File folder = new File(pathsave);
		File[] listOfFiles = folder.listFiles();
		//Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified).reversed());
		Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified));
		System.err.println("After list files");
		
		/* for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			System.out.println("File " + listOfFiles[i].getName());
		  } else if (listOfFiles[i].isDirectory()) {
			System.out.println("Directory " + listOfFiles[i].getName());
		  }
		} */
		//FileTime creationTime ;//'=  (FileTime) Files.getAttribute(file, "creationTime");
		//modif du 01/07/2022
		System.out.println ("lecture fichier de sauvegrde");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		//SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		BasicFileAttributes attr;
		 Path file;
		System.out.println(" nombre de dossier " +listOfFiles.length);
		 for (int i = listOfFiles.length-1 ; i > listOfFiles.length-15; i--) {
		  if (listOfFiles[i].isFile()) {
			 
			 // Path file = Paths.get(listOfFiles[i].getName());
			// creationTime = (FileTime) Files.getAttribute(file, "creationTime");
			 //Path 
			 try {
			 file = Paths.get(pathsave+listOfFiles[i].getName());

            //BasicFileAttributes 
			attr = Files.readAttributes(file, BasicFileAttributes.class);
			//System.out.println( attr.creationTime() +" " + listOfFiles[i].getName());
			 //savs.add(attr.creationTime().toMillis() +"  " + listOfFiles[i].getName() +" " +listOfFiles[i].length());
			savs.add(df.format(attr.creationTime().toMillis()) +"  " + listOfFiles[i].getName() +" " +listOfFiles[i].length());
				} catch (IOException e) {
            e.printStackTrace();
			}
			
		  } else if (listOfFiles[i].isDirectory()) {
			System.out.println("Directory " + listOfFiles[i].getName());
		  }
		} 
		System.err.println(" after boucle liste dossier");
		
		model.addAttribute("saves", savs);
		
		//gestion du temps
		
	   LocalDateTime now = LocalDateTime.now();  
	   //System.out.println("Le now " +dtf.format(now));  


		//model.addAttribute("savesips", savsips);
		model.addAttribute("lenow", dtf.format(now));
		DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
		model.addAttribute("leslastsavs", proclistService.showlastsav());
		//modif du 05/07/2022
		// DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE1);
		// model.addAttribute("tickets", ticketService.showticketfull());
		
		return "procreps";
	}
	
	@GetMapping("/iplist")
	public String testip(Model model) {
		// ModelAndView view = new ModelAndView();
		// view.setViewName("procreps");
	DataBaseContextHolder.setCurrentDb(DatabaseContext.MASTER);
	List<String> savsips = new ArrayList<String>();
	List<String> savsipsm = new ArrayList<String>();
	//  InetAddress localHost;
	// try {
	// 	localHost = InetAddress.getLocalHost();
	// 	System.out.println(localHost.getHostAddress());
	// 	String subnet="192.168.137";
	// 	int timeout=10;
	// 	for (int i=1;i<255;i++){
	// 		String host=subnet+ "." + i;
	// 		if (InetAddress.getByName(host).isReachable(timeout)){
	// 			//System.out.println(host + " is reachable");
	// 			savsips.add(host);
	// 		}
	// 	}
	// 	subnet="172.25.51";
	// 	//int timeout=10;
	// 	for (int i=1;i<255;i++){
	// 		String host=subnet+ "." + i;
	// 		if (InetAddress.getByName(host).isReachable(timeout)){
	// 			//System.out.println(host + " is reachable");
	// 			savsips.add(host);
	// 		}
	// 	}


	// } catch (UnknownHostException e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// } catch (IOException e) {
	// 	// TODO Auto-generated catch block
	// 	e.printStackTrace();
	// }
  
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
	LocalDateTime now = LocalDateTime.now();  

	// try {
	// 	InetAddress localhost = InetAddress.getLocalHost();
	// 	System.out.println("localhost"+ localhost.getHostAddress());
	// 	//savsips.add();
	// 	// Just in case this host has multiple IP addresses....
	// 	InetAddress[] allMyIps = InetAddress.getAllByName(localhost.getCanonicalHostName());
	// 	if (allMyIps != null && allMyIps.length > 1) {
	// 		System.out.println(" Full list of IP addresses:");

	// 	  for (int i = 0; i < allMyIps.length; i++) {
	// 		System.out.println("    " + allMyIps[i]);
	// 	  }
	// 	}
	//   } catch (UnknownHostException e) {
	// 	System.out.println(" (error retrieving server host name)");
	//   }
	  
	//   try {
	// 	System.out.println("Full list of Network Interfaces:");
	// 	for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements();) {
	// 	  NetworkInterface intf = en.nextElement();
	// 	  System.out.println("    " + intf.getName() + " " + intf.getDisplayName());
	// 	  for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
	// 		System.out.println("        " + enumIpAddr.nextElement().toString());
	// 	  }
	// 	}
	//   } catch (SocketException e) {
	// 	System.out.println(" (error retrieving network interface list)");
	//   }

	  model.addAttribute("lenow", dtf.format(now));
	  //modif du 05/07/2022
	  // DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE1);
	  // model.addAttribute("tickets", ticketService.showticketfull());
	  System.out.println("Found by  socket!");

	Socket socket = new Socket();
    Process process;
	byte[] ipb;
	try {
		process = Runtime.getRuntime().exec("arp -a ");

		try {
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	
		while (reader.ready()) {
			String ip = reader.readLine();
			//System.out.println("Found ligne !"+ip);
			//if(!(ip.contains("Inter")) && !(ip.contains("Adres")) && !(ip.length()==0)){
				if((ip.contains("192.168.137")) && !(ip.contains("Interface"))){

					if(ip.contains("192.168.137.1")){
						savsipsm.add("Ip 192.168.137.1 is online.");
					}else if (!(ip.contains("192.168.137.255"))){
						//ipb=ip.substring(2, 18).trim();
						//System.out.println(ip.substring(2, 18).trim()+ip.substring(2, 18).trim());
						//System.out.println(ipb.toString()+ipb.toString());
						InetAddress address = InetAddress.getByName(ip.substring(2, 18).trim());
						// String output = address.getHostName();
						// System.out.println(address.getHostName());
						// System.out.println(address.getCanonicalHostName());
						savsips.add("Ip :"+ip.substring(2, 18)+" Mac :"+ip.substring(22, 41)+ " Name "+address.getHostName());
						//savsips.add(output);
					}
				//try {
					// boolean online = InetAddress.getByName(ip).isReachable(10);
					// if (online) {
						
						//savsips.add(ip.subSequence(2, 18)+"Ip is online.");
						//savsips.add(ip.subSequence(18, 18)+"Ip is online.");
						//savsips.add("Mac"+ip.substring(22, 17));
					// }
				// } catch (IOException e) {
				// 	// TODO Auto-generated catch block
				// 	e.printStackTrace();
				// }

			
		}
			// ip = ip.substring(3, ip.indexOf(')'));
	
			// try {
			//     socket.connect(new InetSocketAddress(ip, 1234), 1000);
			//     System.out.println("Found socket!");
			// } catch (ConnectException | SocketTimeoutException ignored) {
	
			// }
		}

	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
   

	

    // if (socket == null) {
	// 		System.err.println("Could not find socket.");
	// 	}
	// } catch (Exception e) {
	// 	e.printStackTrace();
	// }
	try {
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	// System.err.println("Enumeration");
	// Enumeration e;
	// try {
	// 	e = NetworkInterface.getNetworkInterfaces();

	// 	while(e.hasMoreElements())
	// {
	// 	NetworkInterface n = (NetworkInterface) e.nextElement();
	// 	Enumeration ee = n.getInetAddresses();
	// 	while (ee.hasMoreElements())
	// 	{
	// 		InetAddress i = (InetAddress) ee.nextElement();
	// 		String ip = i.getHostAddress();
	// 		System.err.println("ip network"+ip);
	// 		String sip = ip.substring(0, ip.indexOf('.',ip.indexOf('.',ip.indexOf('.')+1) + 1) + 1);
	// 		try {
	// 			for(int it=1;it<=255;it++)
	// 			{
	// 				String ipToTest = sip+it;
	// 				boolean online = InetAddress.getByName(ipToTest).isReachable(100);
	// 				if (online) {
	// 					System.out.println(ipToTest+" is online");
	// 				}

	// 			}
	// 		} catch (IOException e1) {
	// 			System.out.println(sip);
	// 		}
	// 	}
	// }



	// } catch (SocketException e2) {
	// 	// TODO Auto-generated catch block
	// 	e2.printStackTrace();
	// }
	
	model.addAttribute("savesips", savsips);
	model.addAttribute("savesipsm", savsipsm);
	  return "procrepsip";
  }

	@GetMapping("/ticketslist")
	public String testtickets(Model model) {
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		 LocalDateTime now = LocalDateTime.now();  
	   //System.out.println("Le now " +dtf.format(now));  
	   
		model.addAttribute("lenow", dtf.format(now));
		
		DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE1);
		model.addAttribute("tickets", ticketService.showticketfull());
		
		return "tickets";
	}
	
	@GetMapping("/scanfolding/{clssrc}/{clsdes}")
	public String testticketsscan(Model model,@PathVariable String clssrc,@PathVariable String clsdes) {
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		 LocalDateTime now = LocalDateTime.now();  
	   //System.out.println("Le now " +dtf.format(now));  
		model.addAttribute("lenow", dtf.format(now));
		DataBaseContextHolder.setCurrentDb(DatabaseContext.SLAVE1);
		List<String> savsips = new ArrayList<String>();
		savsips.add(clssrc);
		savsips.add(clsdes);

		File file = new File("");
    	String srcpath=file.getAbsolutePath();
		savsips.add(srcpath);
	    String pathenty=srcpath+"\\src\\main\\java\\com\\deb\\dynamicdatasource\\entity";
		savsips.add(pathenty+"\\"+clssrc+".java");
		savsips.add(pathenty+"\\"+clsdes+".java");
		savsips.add("entity");
		copyFileLineLine(pathenty,clssrc.substring(0,1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0,1).toUpperCase()+clsdes.substring(1).toLowerCase(),"");
		pathenty=srcpath+"\\src\\main\\java\\com\\deb\\dynamicdatasource\\repo";
		savsips.add("repo");
		copyFileLineLine(pathenty,clssrc.substring(0,1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0,1).toUpperCase()+clsdes.substring(1).toLowerCase(),"Repo");

		pathenty=srcpath+"\\src\\main\\java\\com\\deb\\dynamicdatasource\\service";
		savsips.add("service");
		copyFileLineLine(pathenty,clssrc.substring(0,1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0,1).toUpperCase()+clsdes.substring(1).toLowerCase(),"Service");

		pathenty=srcpath+"\\src\\main\\java\\com\\deb\\dynamicdatasource\\service\\impl";
		savsips.add("serviceImpl");
		copyFileLineLine(pathenty,clssrc.substring(0,1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0,1).toUpperCase()+clsdes.substring(1).toLowerCase(),"ServiceImpl");

		pathenty=srcpath+"\\src\\main\\java\\com\\deb\\dynamicdatasource\\controller";
		savsips.add("controller");
		copyFileLineLine(pathenty,clssrc.substring(0,1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0,1).toUpperCase()+clsdes.substring(1).toLowerCase(),"Controller");

		pathenty=srcpath+"\\src\\main\\resources\\templates";
		savsips.add("templates");
		copyFileLineLinehtml(pathenty,clssrc.toLowerCase(),clsdes.toLowerCase());



		 String pathrepo=srcpath+"/src/main/java/com/deb/dynamicdatasource/repo";
		 savsips.add(pathrepo+""+clsdes);

		model.addAttribute("savesips", savsips);
		//model.addAttribute("tickets", ticketService.showticketfull());
	
		return "procrepsip";
	}

	private void copyFileLineLine(String chemin,String clssrc, String clsdes,String extension)  {
		
		String  sourceFileName = chemin+"\\"+clssrc+extension+".java";
		String  destinationFileName = chemin+"\\"+clsdes+extension+".java";

		// if(evt.getSource() == btnProcess)
		// {
			BufferedReader br = null;
			PrintWriter pw = null; 
			try {
				br = new BufferedReader(new FileReader(sourceFileName));
				pw =  new PrintWriter(new FileWriter(destinationFileName));
				String line;
				String line1;
				while ((line = br.readLine()) != null) {
						line1=line.replace(clssrc,clsdes);
						line1=line1.replace(clssrc.toLowerCase(),clsdes.toLowerCase());
						pw.println(line1);
						pw.flush();
						//Thread.sleep(1000);
				}
				br.close();
				pw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		// }

	}
	private void copyFileLineLinehtml(String chemin,String clssrc, String clsdes)  {
		
		String  sourceFileName = chemin+"\\"+clssrc+"s.html";
		String  destinationFileName = chemin+"\\"+clsdes+"s.html";

		
			BufferedReader br = null;
			PrintWriter pw = null; 
			try {
				br = new BufferedReader(new FileReader(sourceFileName));
				pw =  new PrintWriter(new FileWriter(destinationFileName));
				String line;
				String line1;
				while ((line = br.readLine()) != null) {
						line1=line.replace(clssrc.substring(0, 1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0, 1).toUpperCase()+clsdes.substring(1).toLowerCase());
						line1=line1.replace(clssrc.toLowerCase(),clsdes.toLowerCase());
						pw.println(line1);
						pw.flush();
						//Thread.sleep(1000);
				}
				br.close();
				pw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		//le show
		  sourceFileName = chemin+"\\"+clssrc+"show.html";
		  destinationFileName = chemin+"\\"+clsdes+"show.html";

		
			 br = null;
			 pw = null; 
			try {
				br = new BufferedReader(new FileReader(sourceFileName));
				pw =  new PrintWriter(new FileWriter(destinationFileName));
				String line;
				String line1;
				while ((line = br.readLine()) != null) {
						// line1=line.replace(clssrc,clsdes);
						// line1=line1.replace(clssrc.toLowerCase(),clsdes.toLowerCase());
						line1=line.replace(clssrc.substring(0, 1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0, 1).toUpperCase()+clsdes.substring(1).toLowerCase());
						line1=line1.replace(clssrc.toLowerCase(),clsdes.toLowerCase());
						pw.println(line1);
						pw.flush();
						//Thread.sleep(1000);
				}
				br.close();
				pw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			//form
		  sourceFileName = chemin+"\\"+clssrc+"form.html";
		 destinationFileName = chemin+"\\"+clsdes+"form.html";

		
			 br = null;
			 pw = null; 
			try {
				br = new BufferedReader(new FileReader(sourceFileName));
				pw =  new PrintWriter(new FileWriter(destinationFileName));
				String line;
				String line1;
				while ((line = br.readLine()) != null) {
						// line1=line.replace(clssrc,clsdes);
						// line1=line1.replace(clssrc.toLowerCase(),clsdes.toLowerCase());
						line1=line.replace(clssrc.substring(0, 1).toUpperCase()+clssrc.substring(1).toLowerCase(),clsdes.substring(0, 1).toUpperCase()+clsdes.substring(1).toLowerCase());
						line1=line1.replace(clssrc.toLowerCase(),clsdes.toLowerCase());
						pw.println(line1);
						pw.flush();
						//Thread.sleep(1000);
				}
				br.close();
				pw.close();
			}catch (Exception e) {
				e.printStackTrace();
			}

	}

	/* @GetMapping("/files")
	public ResponseEntity<String> getFilesByType(@RequestParam(name = "type") String type) {
		String baseFilePath = null;
		Satelites sateLiteType = Satelites.getSatelite(type);
		
		if (Objects.nonNull(sateLiteType)) {
			switch (sateLiteType) {
			case SARAL:
				baseFilePath = saralDataService.getFtpPath();
				break;
			case ARAYABHAT:
				baseFilePath = aryabhatDataService.getFtpPath();
				break;
			default:
				baseFilePath = "ftp://ftp.mosdac.gov.in/2020";
				break;
			}
		} else {
			baseFilePath = "ftp://ftp.mosdac.gov.in/2020";
		}

		return ResponseEntity.ok(baseFilePath);
	} */

}

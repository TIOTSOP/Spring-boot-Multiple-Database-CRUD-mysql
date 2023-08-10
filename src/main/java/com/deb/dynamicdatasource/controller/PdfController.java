package com.deb.dynamicdatasource.controller;

import com.deb.dynamicdatasource.entity.Ticket;
import com.deb.dynamicdatasource.entity.MySeachZone;

import com.deb.dynamicdatasource.repo.TicketRepo;
import com.deb.dynamicdatasource.service.TicketService;
/* import com.hendisantika.springbootmysqlreport.domain.Fournisseur;
import com.hendisantika.springbootmysqlreport.repository.FournisseurRepository;
 */


import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

//import jakarta.annotation.processing.Filer;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.web.bind.annotation.PathVariable;
//12/06/2020
import jakarta.servlet.http.HttpSession;
//modif du 06/07/2022 importation du holder
import com.deb.dynamicdatasource.config.DataBaseContextHolder;
import com.deb.dynamicdatasource.enums.DatabaseContext;
import com.deb.dynamicdatasource.enums.Satelites;


//20/07/2022
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-mysql-report
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/02/18
 * Time: 19.17
 * To change this template use File | Settings | File Templates.
 */

@RestController
public class PdfController {

//    private Logger logger = LogManager.getLogManager(PdfController.class);

    @Autowired
    ApplicationContext context;

    @Autowired
     TicketService ticketService;
	
	 
	 
	// @Autowired
    // CaisseService caisseService;
	
	
    //    @GetMapping(path = "pdf/{jrxml}")
    /* @GetMapping(path = "/pdf/fournisseur")
    @ResponseBody
//    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
    public void getPdf(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        Resource resource = context.getResource("classpath:reports/fournisseur.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

        List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();

        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(fournisseurs);
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    } */
	
// 	@GetMapping(path = "/report/pdf/mvtent/{id}")
//     @ResponseBody
// //    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
//     public void getPdffour(HttpServletResponse response,@PathVariable("id") Long id, HttpSession session,HttpServletRequest request) throws Exception {
//         //Get JRXML template from resources folder
// //        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
		
// 		String messsolde=regentService.checksolde(id);
// 		System.out.println(messsolde);
// 		String destination;
// 		if((messsolde.equals(""))) {
// 				//s'il est systeme laisse le c 'est sa chose
				
// 		Resource resource = context.getResource("classpath:reports/facture1.jrxml");
//         //Compile to jasperReport
//         InputStream inputStream = resource.getInputStream();
//         JasperReport report = JasperCompileManager.compileReport(inputStream);
//         //Parameters Set mvtdetfromidentlist
//         Map<String, Object> params = new HashMap<>();
// 		System.out.println("report before list");
//        //List<Mvtdet> fournisseurs =  mvtdetService.mvtdetfromidentlist(id);
	   
// 	   //List<Mvtent> fournisseurs =  mvtdetService.mvtdetfromidentlist(id);
// 	   //List<Mvtentfact> fournisseurs = (List<Mvtentfact>) regentService.listmvtentfactfromid(id);
// 	   List<Mvtentfact> fournisseurs = (List<Mvtentfact>) regentService.listmvtentfactfromid(id);
// 	   // @Autowired
    
// 		System.out.println("report after list");
//         //Data source Set
//         JRDataSource dataSource = new JRBeanCollectionDataSource(fournisseurs);
//         params.put("datasource", dataSource);
// 		params.put("nument", "11111");
// 		String datejour =session.getAttribute("nomutil").toString();
// 		params.put("thprintuser", datejour);
// 		long prtdoc=regentService.setmvtentprt(id);
// 		if (prtdoc>0) {
// 			params.put("theduplicata", "DUPLICATE N "+ prtdoc);
// 		}else{
// 			params.put("theduplicata", "");
// 		}
// 		System.out.println("report after params");
//         //Make jasperPrint
//         JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
//         //Media Type
// 		//System.out.println("report jasperprint");
//         response.setContentType(MediaType.APPLICATION_PDF_VALUE);
//         //Export PDF Stream
// 		//System.out.println("report after content");
//         JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
// 		//System.out.println("report after topdfstream");
		
			
// 		}else {
// 			//met les message
// 			request.getSession().setAttribute("messagemvtdet",messsolde);	
// 		}

//     }
	
// 		@GetMapping(path = "/report/pdf/regent/{id}")
//     @ResponseBody
// //    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
//     public void getPdffourreg(HttpServletResponse response,@PathVariable("id") Long id, HttpSession session) throws Exception {
//         //Get JRXML template from resources folder
// //        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
//         Resource resource = context.getResource("classpath:reports/recu1.jrxml");
//         //Compile to jasperReport
//         InputStream inputStream = resource.getInputStream();
//         JasperReport report = JasperCompileManager.compileReport(inputStream);
//         //Parameters Set mvtdetfromidentlist
//         Map<String, Object> params = new HashMap<>();
// 		System.out.println("report before list");
//        //List<Mvtdet> fournisseurs =  mvtdetService.mvtdetfromidentlist(id);
	   
// 	   //List<Mvtent> fournisseurs =  mvtdetService.mvtdetfromidentlist(id);
// 	   //List<Mvtentfact> fournisseurs = (List<Mvtentfact>) regentService.listmvtentfactfromid(id);
// 	   List<Regentfact> fournisseurs = (List<Regentfact>) regentService.listregentfactfromid(id);
// 	   // @Autowired
    
// 		System.out.println("report after list");
//         //Data source Set
//         JRDataSource dataSource = new JRBeanCollectionDataSource(fournisseurs);
//         params.put("datasource", dataSource);
// 		params.put("nument", "11111");
// 		String datejour =session.getAttribute("nomutil").toString();
// 		params.put("thprintuser", datejour);
// 		long prtdoc=regentService.setregentprt(id);
// 		if (prtdoc>0) {
// 			params.put("theduplicata", "DUPLICATE N "+ prtdoc);
// 		}else{
// 			params.put("theduplicata", "");
// 		}
// 		System.out.println("report after params");
//         //Make jasperPrint
//         JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
//         //Media Type
// 		System.out.println("report jasperprint");
//         response.setContentType(MediaType.APPLICATION_PDF_VALUE);
//         //Export PDF Stream
// 		System.out.println("report after content");
//         JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
// 		System.out.println("report after topdfstream");
//     }
	
	//@GetMapping(path = "/report/pdf/treso",params="imprimer")
    //@RequestMapping(value = "/tresoreries",params="Imprimer")
	  
    //@RequestMapping(value = "/tresoreries", method = RequestMethod.POST,params="Imprimer")
    @RequestMapping(value = "/pdf/tickets")
    @ResponseBody
    public void getPdftresorerie(HttpServletResponse response,  HttpSession session) throws Exception {
	//public void getPdftresorerie(@PathVariable String id, HttpServletResponse response,  HttpSession session) throws Exception {
        Resource resource = context.getResource("classpath:reports/ticket1.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set mvtdetfromidentlist
        Map<String, Object> params = new HashMap<>();
		System.out.println("report tresorerie  before list");
	
        DataBaseContextHolder.setCurrentDb(DatabaseContext.POSTE1);
	    List<Ticket> tickets = ticketService.listticketfull();
       //List<Ticket> tickets =(List<Ticket>)  ticketService.showticketfull();
        

	   // @Autowired
    
		System.out.println("report tresorerie after list");
        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(tickets,false);
        //JRDataSource dataSource = new JRBeanCollectionDataSource(tickets);
        params.put("datasource", dataSource);
		params.put("nument", "Liste des tickets");
		
		
		/* String thprintuser =session.getAttribute("nomutil").toString();
		params.put("thprintuser", thprintuser); */
		
		System.out.println("report after params");
        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
      //  if (id.equals("PDF")){

        
    
		System.out.println("report jasperprint");
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
		System.out.println("report after content");
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
		System.out.println("report after topdfstream");
        
     //}else if  (id.equals("EXCEL")){

        
    
        //  Filer destFile = new File(sourceFile.getParent(), jasperPrint.getName() + ".xlsx");
   
        // JRXlsxExporter exporter = new JRXlsxExporter();
       
        // exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        // exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
        // exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.FALSE);
       
        // exporter.exportReport();
    
        // System.err.println("XLSX creation time : " + (System.currentTimeMillis() - start)); 


/* 
        File destFile = new File(System.currentTimeMillis() + "_xls-export.xls");
        destFile.deleteOnExit();
        exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, destFile.toString());
        exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
        Boolean.TRUE);

        exporter.exportReport(); */

     //}

    }
	
	
	
	
	
	
/* 	@PostMapping(path = "/pdf/caisse" )
    @ResponseBody
//    public void getPdf(@PathVariable String jrxml, HttpServletResponse response) throws Exception {
    public void getPdfcaisse(HttpServletResponse response,MySeachSql searchForm) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        Resource resource = context.getResource("classpath:reports/caisselist.jrxml");
        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report = JasperCompileManager.compileReport(inputStream);
        //Parameters Set
        Map<String, Object> params = new HashMap<>();

       //List<Caisse> caisses = (List<Caisse>) caisseService.listAllCaisses();
		List<Caisse> caisses = (List<Caisse>) caisseService.caisseCompteDate(searchForm.getCompte(),searchForm.getLadate(),searchForm.getFindate());
        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(caisses);
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        //Media Type
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        //Export PDF Stream
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    } */

/*     @GetMapping(path = "/excel")
    @ResponseBody
    public void getExcel(HttpServletResponse response) throws Exception {
        //Get JRXML template from resources folder
//        Resource resource = context.getResource("classpath:reports/" + jrxml + ".jrxml");
        InputStream jasperStream = this.getClass().getResourceAsStream("/reports/fournisseur.jrxml");
        JasperDesign design = JRXmlLoader.load(jasperStream);
        JasperReport report = JasperCompileManager.compileReport(design);

        Map<String, Object> params = new HashMap<>();

        List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();

        //Data source Set
        JRDataSource dataSource = new JRBeanCollectionDataSource(fournisseurs);

        Resource resource = context.getResource("classpath:reports/fournisseur.xlsx");
        params.put("datasource", dataSource);

        //Make jasperPrint
        JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
        response.setContentType("application/x-xlsx");
        response.setHeader("Content-Disposition", "inline: filename: fournisseur.xlsx");

        //Compile to jasperReport
        InputStream inputStream = resource.getInputStream();
        JasperReport report2 = JasperCompileManager.compileReport(inputStream);
        //Parameters Set

        final OutputStream ops = response.getOutputStream();

        //Media Type
//        response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
        //Export Excel Stream
        JRXlsExporter xls = new JRXlsExporter();
        xls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        xls.setParameter(JRExporterParameter.OUTPUT_STREAM, ops);
    } */

    /* @GetMapping(path = "/excel2")
    @ResponseBody
    private void getDownloadReportXlsx(HttpServletRequest request, HttpServletResponse response) {
        try {
            //uncomment this codes if u are want to use servlet output stream
            ServletOutputStream servletOutputStream = response.getOutputStream();

            Map<String, Object> params = new HashMap<>();

            List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();

            //Data source Set
            JRDataSource dataSource = new JRBeanCollectionDataSource(fournisseurs);
            params.put("datasource", dataSource);

            //get real path for report
            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/fournisseur.jrxml");
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);

            JRXlsxExporter xlsxExporter = new JRXlsxExporter();
            ByteArrayOutputStream os = new ByteArrayOutputStream();

            xlsxExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            xlsxExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "fournisseur.xls");

            //uncomment this codes if u are want to use servlet output stream
//        xlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);

            xlsxExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
//        xlsxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
//        xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput("fournisseur.xlsx"));
//        xlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(os));
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            xlsxExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
//        xlsxExporter.exportReport();


            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=fournisseur.xls");

            //uncomment this codes if u are want to use servlet output stream
//        servletOutputStream.write(os.toByteArray());

            response.getOutputStream().write(os.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();
            response.flushBuffer();
        } catch (JRException ex) {
            System.out.println("Error : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    }

    @GetMapping(path = "/excel3")
    @ResponseBody
    private void getDownloadReportXls(HttpServletResponse response) {
        try {
            //get real path for report
            InputStream jasperStream = this.getClass().getResourceAsStream("/reports/fournisseur.jrxml");
            JasperDesign design = JRXmlLoader.load(jasperStream);
            JasperReport report = JasperCompileManager.compileReport(design);

            Map<String, Object> params = new HashMap<>();
            List<Fournisseur> fournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();

            //Data source Set
            JRDataSource dataSource = new JRBeanCollectionDataSource(fournisseurs);
            params.put("datasource", dataSource);

            JasperPrint jasperPrint = JasperFillManager.fillReport(report, params, dataSource);
            response.setContentType("application/x-xls");
            response.setHeader("Content-Disposition", "attachment; filename=fournisseur.xls");

            final OutputStream ops = response.getOutputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            JRXlsExporter xlsExporter = new JRXlsExporter();
            xlsExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//            xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ops);
            xlsExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
//            xlsExporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, ops);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS, Boolean.TRUE);
            xlsExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, Boolean.TRUE);

            xlsExporter.exportReport();
            ops.write(byteArrayOutputStream.toByteArray());
            ops.flush();
            ops.close();

        } catch (JRException ex) {
            System.out.println("Error : " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        }
    } */
}

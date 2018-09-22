package com.chw.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.StreamingOutput;

@Path("/book-order")
public class OrderManagementResource {

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/newOrder/in")
	public StreamingOutput newOrder(InputStream is) throws IOException {
		StringBuffer sbuffer = null;
		DataWriter dataWriter = null;
		int c = -1;

		sbuffer = new StringBuffer();
		while ((c = is.read()) != -1) {
			sbuffer.append((char) c);
		}

		dataWriter = new DataWriter(sbuffer.toString());
		return dataWriter;

	}//http://localhost:8082/ContentHandlerWeb/resource/book-order/newOrder/in
		// then type any text in payload part of Advance Rest Client like
		// Fruits: Apple or anything

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/order/reader")
	public StreamingOutput newOrder(Reader reader) throws IOException {
		StringBuffer sbuffer = null;
		DataWriter dataWriter = null;
		char[] cbuffer = null;

		sbuffer = new StringBuffer();
		cbuffer = new char[256];
		while ((reader.read(cbuffer)) != -1) {
			sbuffer.append(cbuffer);
		}

		dataWriter = new DataWriter(sbuffer.toString());
		return dataWriter;

	}// http://localhost:8082/ContentHandlerWeb/resource/book-order/order/reader
		// in Payload section write Fruits: Apple,Mango,Orange or anything you
		// write

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/order/bytes")
	public StreamingOutput newOrder(byte[] raw) {
		StringBuffer buffer = null;
		DataWriter dataWriter = null;
		buffer = new StringBuffer();
		for (byte c : raw) {
			buffer.append((char) c);
		}

		dataWriter = new DataWriter(buffer.toString());
		return dataWriter;

	}// http://localhost:8082/ContentHandlerWeb/resource/book-order/order/bytes

	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new/form")
	public StreamingOutput newOrder(
			MultivaluedMap<String, String> requestParamMap) {
		StringBuffer sbuffer = null;
		DataWriter dataWriter = null;
		sbuffer = new StringBuffer();
		for(String paramName: requestParamMap.keySet()){
			sbuffer.append(paramName+": ");
			List<String> paramValues = requestParamMap.get(paramName);
			for(String paramValue: paramValues){
				sbuffer.append(paramValue+",");
			}
		}
		
		dataWriter = new DataWriter(sbuffer.toString());
		return dataWriter;
	}
	
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new/string")
	public StreamingOutput newOrder(String order){
		
		return new DataWriter(order);
		
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new/char")
	public StreamingOutput newOrder(char[] order){
		
		return new DataWriter(new String(order));
		
	}
	
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/newBulk/file")
	public StreamingOutput newBulkOrder(File file) throws IOException{
		InputStream is = null;
		StringBuffer sbuffer = null;
		DataWriter dataWriter = null;
		int count = 0;
		
		is = new FileInputStream(file);
		sbuffer = new StringBuffer();
		while((count=is.read()) != -1){
			sbuffer.append((char)count);
		}
		
		dataWriter = new DataWriter(sbuffer.toString());
		return dataWriter;
		
	}
	
	/**
	 * Working with Response Body
	 * @author RAAJ
	 *
	 */
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new/out/byte")
	public byte[] newByteOutputOrder(String data){
		
		return data.getBytes();
		
	}
	
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new/out/string")
	public String newStringOutputOrder(String data){
		
		return data;
	}
	
	//right now it will not working we will see it later
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("new/out/chars")
	public char[] newCharOutputOrder(String data){
		
		return data.toCharArray();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/new/out/file")
	public File newFileOutputOrder(String data) throws IOException{
		FileOutputStream fos = new FileOutputStream(new File("F:\\product.txt"));
		fos.write(data.getBytes());
		fos.close();
		
		File outFile = new File("F:\\product.txt");
		return outFile;
		
	}
	
	
	
	
	
	
	

	// private method
	private final class DataWriter implements StreamingOutput {

		private String dataInfo;

		public DataWriter(String dataInfo) {
			super();
			this.dataInfo = dataInfo;
		}

		@Override
		public void write(OutputStream out) throws IOException,
				WebApplicationException {

			out.write(dataInfo.getBytes());
			out.close();
		}

	}

}

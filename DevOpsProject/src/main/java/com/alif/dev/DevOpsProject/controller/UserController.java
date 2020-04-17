package com.alif.dev.DevOpsProject.controller;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alif.dev.DevOpsProject.model.User;
import com.alif.dev.DevOpsProject.util.PasswordEncriptor;

@Controller
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class.getName());
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="saveUser.htm", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute(value="userDetails") User user, @RequestParam(value="usrimage") MultipartFile image, Model model) {
		logger.info("=================POST Request for saveUser method=================");
		String saveUserSQL = "insert into DEVOPSDB.USER_DETAILS(USER_NAME,USER_PASSWORD,USER_FULL_NAME,CREATION_DATE,USER_IMAGE) "
				+ "values(?,?,?,CURRENT_TIMESTAMP,?)";
		
		try {
			user.setUserImage(compressBytes(image.getBytes()));
			user.setUserPassword(PasswordEncriptor.getSHA256(user.getUserPassword()));
		
			int res = jdbcTemplate.execute(saveUserSQL, new PreparedStatementCallback<Integer>() {
	
				@Override
				public Integer doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
					pst.setString(1, user.getUserName());
					pst.setString(2, user.getUserPassword());
					pst.setString(3, user.getUserFullName());
					pst.setBytes(4, user.getUserImage());
					return pst.executeUpdate();
				}
			});
			
			if(res==1) {
				model.addAttribute("msg", "User saved successfully!");
			}
		}catch (IOException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "login";
	}
	
	// compress the image bytes before storing it in the database
	    public static byte[] compressBytes(byte[] data) {
	        Deflater deflater = new Deflater();
	        deflater.setInput(data);
	        deflater.finish();
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	        byte[] buffer = new byte[1024];
	        while (!deflater.finished()) {
	            int count = deflater.deflate(buffer);
	            outputStream.write(buffer, 0, count);
	        }
	        try {
	            outputStream.close();
	        } catch (IOException e) {
	        }
	        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
	        return outputStream.toByteArray();
	    }
	    
	    // uncompress the image bytes before returning it to the angular application
	    public static byte[] decompressBytes(byte[] data) {
	        Inflater inflater = new Inflater();
	        inflater.setInput(data);
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
	        byte[] buffer = new byte[1024];
	        try {
	            while (!inflater.finished()) {
	                int count = inflater.inflate(buffer);
	                outputStream.write(buffer, 0, count);
	            }
	            outputStream.close();
	        } catch (IOException ioe) {
	        } catch (DataFormatException e) {
	        }
	        return outputStream.toByteArray();
	    }

}

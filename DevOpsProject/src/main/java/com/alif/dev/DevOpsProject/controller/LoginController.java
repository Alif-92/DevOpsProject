package com.alif.dev.DevOpsProject.controller;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Enumeration;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alif.dev.DevOpsProject.model.User;
import com.alif.dev.DevOpsProject.util.PasswordEncriptor;

@Controller
public class LoginController {
	
private static final Logger logger = Logger.getLogger(LoginController.class.getName());
	
private static SimpleDateFormat FORMATTER = new SimpleDateFormat("MM/dd/yyyy 'at' HH:mma z");

	@Autowired
    JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="doAppLogin.htm", method = RequestMethod.POST)
	public String doAppLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			@ModelAttribute(value="userDetails") User user, Model model) {
		logger.info("=================POST Request for doAppLogin method=================");
		String getUserSQL = "SELECT * FROM DEVOPSDB.USER_DETAILS where USER_NAME =? and USER_PASSWORD =?";
		
		try {
			user.setUserPassword(PasswordEncriptor.getSHA256(user.getUserPassword()));
			User loggedInUser = jdbcTemplate.queryForObject(getUserSQL, new Object[]{user.getUserName(),user.getUserPassword()}, new RowMapper<User>() {

				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
					User u = new User();
					u.setUserId(rs.getInt("USER_ID"));
					u.setUserName(rs.getString("USER_NAME"));
					u.setUserFullName(rs.getString("USER_FULL_NAME"));
					u.setUserImage(UserController.decompressBytes(rs.getBytes("USER_IMAGE")));
					return u;
				}
			});
			
			if(loggedInUser == null) {
				model.addAttribute("msg", "Error, Userid and/or Password wrong!");
			}else {
				LocalDateTime todayIndia = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
				System.out.println("Current Date in IST="+todayIndia);
				//System.out.println(todayIndia.getHour());
				
				LocalDateTime todayUs = LocalDateTime.now(ZoneId.of("US/Central"));
				System.out.println("Current Date in UST="+todayUs);
				//System.out.println(todayUs.getHour());
				
				int time = todayIndia.getHour();
				String greetings = "";
				if(time >=0 && time < 12) {
					greetings = " Good Morning";
				}else if(time >= 12 && time < 16) {
					greetings = " Good Afternoon";
				}else if(time >= 16 && time < 21) {
					greetings = " Good Evening";
				}else if(time >= 21 && time < 24) {
					greetings = " Good Night";
				}
				
				session.setAttribute("sessionUserId", loggedInUser.getUserId());
				model.addAttribute("loggedInUser", loggedInUser);
				byte[] encodeBase64Image = Base64.encodeBase64(loggedInUser.getUserImage());
	            String base64EncodedImageStr = new String(encodeBase64Image, "UTF-8");
	            model.addAttribute("loggedInUserImage", base64EncodedImageStr);
	            model.addAttribute("greetings", greetings);
				return "home";
			}
			
		}catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (EmptyResultDataAccessException e1) {
			model.addAttribute("msg", "Error, Userid and/or Password wrong!");
		}catch (Exception e2) {
			e2.printStackTrace();
		}
		
		return "login";
	}
	
	@GetMapping("doAppLogout.htm")
	public String destroySession(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		logger.info("=================GET Request for destroySession method=================");
		Enumeration<String> e = session.getAttributeNames();
		while(e.hasMoreElements()) {
			String attrName = e.nextElement();
			session.removeAttribute(attrName);
			logger.info("########Session Attribute "+attrName+" is removed from current session#########");
		}
		session.invalidate();
		response.setHeader("SET-COOKIE", "; HttpOnly; Secure");
		return response.encodeURL("redirect:/login.htm");
	}

}

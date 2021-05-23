package com.ssafy.happyhouse.service;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.util.MailUtil;

@Service("mss")
public class MailSendService {
	
	@Autowired
    private JavaMailSenderImpl mailSender;
	private int size;

    //인증키 생성
    private String getKey(int size) {
        this.size = size;
        return getAuthCode();
    }

    //인증코드 난수 발생
    private String getAuthCode() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        int num = 0;

        while(buffer.length() < size) {
            num = random.nextInt(10);
            buffer.append(num);
        }

        return buffer.toString();
    }

    //인증메일 보내기
    public String sendAuthMail(String email) {
        //6자리 난수 인증번호 생성
        String authKey = getKey(6);

        //인증메일 보내기
        try {
            MailUtil sendMail = new MailUtil(mailSender);
            sendMail.setSubject("HappyHouse 이메일 인증");
            sendMail.setText(new StringBuffer()
            	.append(" <div" 																																																	+ 
						"	style=\"font-family: 'Apple SD Gothic Neo', 'sans-serif' !important; width: 400px; height: 600px; border-top: 4px solid #3588b8; margin: 100px auto; padding: 30px 0; box-sizing: border-box;\">"		+ 
						"	<h1 style=\"margin: 0; padding: 0 5px; font-size: 28px; font-weight: 400;\">"																															+ 
						"		<span style=\"font-size: 15px; margin: 0 0 10px 3px;\">Happy House</span><br />"																													+ 
						"		<span style=\"color: #3588b8\">메일인증</span> 안내입니다."																																				+ 
						"	</h1>\n"																																																+ 
						"	<p style=\"font-size: 16px; line-height: 26px; margin-top: 50px; padding: 0 5px;\">"																													+ 
						"		안녕하세요.<br />"																																														+ 
						"		아래 <b style=\"color: #3588b8\">'이메일 인증 확인'</b> 링크를 클릭하시면 <br />이메일 인증이 완료됩니다.<br />"																											+ 
						"		감사합니다."																																															+ 
						"	</p>"																																																	+ 
						"	<a style=\"color: #FFF; text-decoration: none; text-align: center;\""																																	+
						"	href='http://localhost:8080/member/confirm?email=" + email + "&authkey=" + authKey + "\" 'target=\"_blank\">"																							+ 
						"		<p"																																																	+
						"			style=\"display: inline-block; width: 210px; height: 45px; margin: 30px 5px 40px; background: #3588b8; line-height: 45px; vertical-align: middle; font-size: 16px;\">"							+ 
						"			이메일 인증 확인</p>"																																												+ 
						"	</a>"																																																	+
						"	<div style=\"border-top: 1px solid #DDD; padding: 5px;\"></div>"																																		+
						" </div>")
	            .toString());
            sendMail.setFrom("alb7979s@gamil.com", "이메일 인증");
            sendMail.setTo(email);
            sendMail.send();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return authKey;
    }
}

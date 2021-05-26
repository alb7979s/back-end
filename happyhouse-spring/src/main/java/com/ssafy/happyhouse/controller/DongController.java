package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.dto.Apt;
import com.ssafy.happyhouse.dto.Dong;
import com.ssafy.happyhouse.service.AptService;
import com.ssafy.happyhouse.service.DongServiceImpl;


@Controller
public class DongController extends HttpServlet {
	
	@Autowired
	private DongServiceImpl dongService;

	@Autowired
	private AptService aptService;
	
	@RequestMapping(value="/dongInfo", method=RequestMethod.POST)
	@ResponseBody
	public List<Dong> list(@RequestBody String dong){
		//System.out.println(dong);
		return makePercent(dongService.getDongInfo(dong));
	}

	private List<Dong> makePercent(List<Dong> dongInfo) {
		int total=0;
		for(Dong dong : dongInfo)
			total+=dong.getCount();
		
		for(Dong dong : dongInfo) {
			dong.setPercent(Math.round((double) dong.getCount() / (double) total * 100.0));
			//System.out.println(dong.getPercent());
		}
		
		return dongInfo;
	}
	
	@RequestMapping(value="/compare", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> compareinfo(@RequestBody Map<String, String> param){
		System.out.println(param);
		Map<String, Object> result = new HashMap<String, Object>();
		
		int dongcnt = aptService.getDealCnt(param);
		int comparecnt = aptService.getCmpDealCnt(param);
		result.put("dongcnt", dongcnt);
		result.put("comparecnt", comparecnt);
		
		result.put("dongamount", getAmount(aptService.getDealAmount(param), dongcnt));
		result.put("compareamount", getAmount(aptService.getCmpDealAmount(param), comparecnt));
		
		result.put("dongmax", change(aptService.getMaxDealAmount(param)));
		result.put("comparemax", change(aptService.getMaxCmpDealAmount(param)));
		
		result.put("dongmin", change(aptService.getMinDealAmount(param)));
		result.put("comparemin", change(aptService.getMinCmpDealAmount(param)));
		
		System.out.println(result);
		return result;
		//return result;
	}

	public String change(String price){
		if(price.equals("")) return "0";
		String t = price.substring(price.length()-4, price.length());
		String m = price.substring(0, price.length()-4);
					
		String t1=t;
		for(int i=0;i<4; i++) {
			if(t.charAt(i)=='0') {
				t1=t1.substring(1,t1.length());
			}
			else break;
		}
					
		price = m+"억 "+t1;
					
				
		return price;
	}
	
	private String getAmount(List<Apt> dealAmount, int cnt) {
		int total = 0;
		for(Apt apt : dealAmount) {
			String temp = apt.getDealAmount().trim();
			temp = temp.replace(",", "");
			int price = Integer.parseInt(temp);
			total+=price;
		}
		if(cnt==0) {
			return change(""+total);
		}
		return change(""+total/cnt);
	}
}

package find.bus;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value="find.spring")
public class BusController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String get(@ModelAttribute("BusModel") BusModel input,HttpServletRequest request)
	{
		String source = request.getParameter("Source");
		String dest = request.getParameter("Destination");
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		SimpleDateFormat format = new SimpleDateFormat("EEE");
		Date d = new Date();
		String date = request.getParameter("Date");
		try {
			d=df.parse(date);
			String day = format.format(d);
			System.out.println(day);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("date format is wrong");
			e.printStackTrace();
			return "FindBusTest";
			}
		BusDetail inputGot = new BusDetail("", source, dest, 0, 0, 0, 0);
		
		
		
		BusDetail bus1 = new BusDetail("12345", "bangalore", "mangalore", 7, 8, 12, 60);
		BusDetail bus2 = new BusDetail("23456", "bangalore", "mangalore", 7, 12, 20, 30);
		BusDetail bus3 = new BusDetail("34567", "hyderabad", "bangalore", 7, 8, 12, 60);
		List<BusDetail> buslst = new ArrayList<BusDetail>();
		buslst.add(bus1);
		buslst.add(bus2);
		buslst.add(bus3);
		BusDetail bs = new BusDetail();
		List<BusDetail> gotOut = new ArrayList<BusDetail>();
		Iterator it = buslst.iterator();
		while(it.hasNext())
		{
			bs = (BusDetail)it.next();
			if(bs.getSource().equals(inputGot.getSource()) && bs.getDestination().equals(inputGot.getDestination()))
			{
				gotOut.add(bs);
			}
		
		}
		request.setAttribute("found", gotOut);
		if(gotOut.size()!=0)
			return "find";
		else
			return "notfound";
		
		
		/*int index = buslst.indexOf(inputGot);
		if(index==0)
		{
			System.out.println("Bus FOund");
			request.setAttribute("found", buslst.get(index));
			return "find";
		}
		else
		{
		System.out.println("no bus found of specific source and destination");
		return "notfound";
		}*/
		
	}
	

}

package register;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.support.RequestContextUtils;


@Controller
@RequestMapping(value="/register.spring")
public class RegisterController {
	
	@RequestMapping(method=RequestMethod.POST)
	public String get(@ModelAttribute("RegisterModel")RegisterModel reg,@ModelAttribute("UserModel") UserModel user,HttpServletRequest request)
	{
		WebApplicationContext context = RequestContextUtils.getWebApplicationContext(request);
		
		
		return null;
	}

}

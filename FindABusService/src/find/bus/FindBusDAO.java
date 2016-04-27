package find.bus;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class FindBusDAO extends HibernateDaoSupport {

	public List<BusDetail> getAll()
	{
		return getHibernateTemplate().find("from BusDetail");
	}
}

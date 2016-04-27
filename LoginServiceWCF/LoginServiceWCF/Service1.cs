using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;
using DataBaseLayer;

namespace LoginServiceWCF
{

    public class CService1 : IService1
    {
        UserDBEntities ustab = new UserDBEntities();
        public string Login(string username, string password)
        {
            LoginNow log = new LoginNow();
            string message = "wrong";
            var e = (from s in ustab.UsersTabs where s.UserName == username && s.Password == password select new LoginNow { Username = s.UserName, Password = s.Password,Type=s.Type});
            foreach (var item in e)
            {
                if (item.Username != null)
                {
                    log.Username = item.Username;
                    log.Password = item.Password;
                    if (log.Username.Equals(username) && log.Password.Equals(password))
                    {
                        message = "login";
                        return message;
                    }
                    else
                        return message;
                }
            }
            return message;
        }
    }
       
}

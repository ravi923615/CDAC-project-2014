using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace LoginServiceWCF
{
   
    [ServiceContract]
    public interface IService1
    {
        [OperationContract]
        string Login(string username, string password);
    }

    [DataContract]
    public class LoginNow
    {
        [DataMember]
        public String Username { get; set; }


        [DataMember]
        public string Password { get; set; }

        [DataMember]
        public string Type { get; set; }
    }
}

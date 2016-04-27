using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using LoginPage.ServiceReference1;

namespace LoginPage
{
    /// <summary>
    /// Interaction logic for Page1.xaml
    /// </summary>
    public partial class Page1 : Page
    {
        public Page1()
        {
            InitializeComponent();
        }

        Service1Client proxy = new Service1Client();
        private void button1_Click(object sender, RoutedEventArgs e)
        {
            LoginDetail log = new LoginDetail();
            log.username = user.Text;
            log.password = pass.Password;
            string check = proxy.Login(log.username, log.password);
            if (check.Equals("Login"))
            {
                NavigationService nav = NavigationService.GetNavigationService(this);
                nav.Navigate(new System.Uri("http://localhost:8080/test/index.html", UriKind.Absolute));
            }
            else
            {
                NavigationService na = NavigationService.GetNavigationService(this);
                na.Navigate(new System.Uri("http://localhost:8080/test/index.html", UriKind.Absolute));
            }
        }
    }
}

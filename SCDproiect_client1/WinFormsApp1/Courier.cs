using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using System.Xml.XPath;

namespace WinFormsApp1
{
    internal class Courier
    {
        public int id { get; set; }
        public string name { get; set; }

        public string email { get; set; }
    }
    internal class ManagerStats
    {
        public string managerName { get; set; }
        public int deliveredCount { get; set; }
    }

}

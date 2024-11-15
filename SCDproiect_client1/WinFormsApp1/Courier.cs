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
    }
    internal class ManagerStats
    {
        public string ManagerName { get; set; }
        public int DeliveredCount { get; set; }
    }

}

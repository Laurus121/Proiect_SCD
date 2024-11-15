using System.Net.Http.Headers;
using System.Text;
using System.Text.Json;

namespace WinFormsApp1
{
    internal class PackageService
    {
        static HttpClient client = new HttpClient();

        public void createConnection()
        {
            // Update port # in the following line.
            client.BaseAddress = new Uri("http://localhost:8083/");
            client.DefaultRequestHeaders.Accept.Clear();
            client.DefaultRequestHeaders.Accept.Add(
                new MediaTypeWithQualityHeaderValue("application/json"));
        }

        public List<Package> GetPackages()
        {
            List<Package> packages = null;
            HttpResponseMessage response = client.GetAsync("package").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                Console.WriteLine("received : " + resultString);
                packages = JsonSerializer.Deserialize<List<Package>>(resultString);
                return packages;

            }
            return null;
        }

        public List<Courier> GetBusyCouriers()
        {
            List<Package> packages = this.GetPackages();
            return packages.Select(p => p.courier).DistinctBy(c => c.name).ToList();
        }
        public List<Courier> GetCouriersWithoutPendingPackages()
        {
            List<Courier> couriers = null;
            HttpResponseMessage response = client.GetAsync("couriers/without-pending-packages").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                couriers = JsonSerializer.Deserialize<List<Courier>>(resultString);
            }
            return couriers;
        }

        public List<ManagerStats> GetManagersAndDeliveredNumbers()
        {
            List<ManagerStats> managers = null;
            HttpResponseMessage response = client.GetAsync("couriers/managers-delivered").Result;
            if (response.IsSuccessStatusCode)
            {
                string resultString = response.Content.ReadAsStringAsync().Result;
                managers = JsonSerializer.Deserialize<List<ManagerStats>>(resultString);
            }
            return managers;
        }

        public bool SendEmail(List<string> emails, string subject, string body)
        {
            var emailData = new
            {
                Emails = emails,
                Subject = subject,
                Body = body
            };

            var jsonContent = new StringContent(JsonSerializer.Serialize(emailData), Encoding.UTF8, "application/json");
            HttpResponseMessage response = client.PostAsync("email/send", jsonContent).Result;

            return response.IsSuccessStatusCode;
        }
    }
}

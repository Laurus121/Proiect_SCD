namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        private readonly PackageService packageService;

        public Form1()
        {
            InitializeComponent();
            packageService = new PackageService();
            packageService.createConnection();
        }

        private async void button1_Click(object sender, EventArgs e)
        {
            try
            {
                var couriersList = packageService.GetBusyCouriers();
                var managers = packageService.GetManagersAndDeliveredNumbers();
                var couriersList_pend = packageService.GetCouriersWithoutPendingPackages();

                PopulateComboBox(comboBox2, couriersList_pend, "name");
                PopulateComboBox(comboBox1, couriersList, "name");
                PopulateComboBox(comboBox3, managers, "managerName", "deliveredCount");

                comboBox3.SelectedIndexChanged -= ComboBox3_SelectedIndexChanged;
                comboBox3.SelectedIndexChanged += ComboBox3_SelectedIndexChanged;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error: {ex.Message}");
            }
        }

        private void ComboBox3_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBox3.SelectedItem is ManagerStats selectedManager)
            {
                label_numarpachete.Text = selectedManager.deliveredCount.ToString();
            }
        }

        private void PopulateComboBox(ComboBox comboBox, object dataSource, string displayMember, string valueMember = null)
        {
            comboBox.DataSource = null;
            comboBox.Items.Clear();
            comboBox.DataSource = dataSource;
            comboBox.DisplayMember = displayMember;
            if (!string.IsNullOrEmpty(valueMember))
            {
                comboBox.ValueMember = valueMember;
            }
        }

        private void buttonOpenEmailForm_Click(object sender, EventArgs e)
        {
            var emailLoginForm = new EmailLoginForm();
            if (emailLoginForm.ShowDialog() == DialogResult.OK)
            {
                string email = emailLoginForm.Email;
                string password = emailLoginForm.Password;

                EmailForm emailForm = new EmailForm(packageService, email, password);
                emailForm.ShowDialog();
            }
        }


    }
}

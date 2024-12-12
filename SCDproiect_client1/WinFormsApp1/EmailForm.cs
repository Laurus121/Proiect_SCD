namespace WinFormsApp1
{
    public partial class EmailForm : Form
    {
        private List<Courier> couriers;
        private readonly PackageService packageService;
        private bool areAllSelected = false;
        private string email;
        private string password;

        internal EmailForm(PackageService packageService, string email, string password)
        {
            InitializeComponent();
            this.packageService = packageService;
            this.email = email;
            this.password = password;

            var couriersList = packageService.GetCouriers();
            this.couriers = couriersList;
            checkedListBoxCouriers.DataSource = couriers;
            checkedListBoxCouriers.DisplayMember = "name";
            checkedListBoxCouriers.ValueMember = "email";
        }

        private async void buttonSendEmail_Click(object sender, EventArgs e)
        {
            try
            {
                var selectedEmails = checkedListBoxCouriers.CheckedItems.Cast<Courier>()
                                              .Select(c => c.email)
                                              .Where(Email => !string.IsNullOrEmpty(Email))
                                              .ToList();

                if (!selectedEmails.Any())
                {
                    MessageBox.Show("Selectați cel puțin un curier!");
                    return;
                }

                string subject = "Informații livrări";
                string body = textBoxMessage.Text;
                bool success = await packageService.SendEmailAsync(selectedEmails, subject, body, email, password);

                if (success)
                {
                    MessageBox.Show("E-mailurile au fost trimise cu succes!");
                    this.Close();
                }
                else
                {
                    MessageBox.Show("A apărut o eroare la trimiterea e-mailurilor.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Eroare: {ex.Message}");
            }
        }

        private void buttonSelectAll_Click(object sender, EventArgs e)
        {
            areAllSelected = !areAllSelected;

            for (int i = 0; i < checkedListBoxCouriers.Items.Count; i++)
            {
                checkedListBoxCouriers.SetItemChecked(i, areAllSelected);
            }
            buttonSelectAll.Text = areAllSelected ? "Deselect All" : "Select All";
        }
    }
}

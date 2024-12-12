using System;
using System.Windows.Forms;

namespace WinFormsApp1
{
    public partial class EmailLoginForm : Form
    {
        public string Email { get; private set; }
        public string Password { get; private set; }

        public EmailLoginForm()
        {
            InitializeComponent();
        }

        private void buttonSubmit_Click(object sender, EventArgs e)
        {
            Email = textBoxEmail.Text;
            Password = textBoxPassword.Text;

            if (string.IsNullOrEmpty(Email) || string.IsNullOrEmpty(Password))
            {
                MessageBox.Show("Please enter both email and password.");
            }
            else
            {
                this.DialogResult = DialogResult.OK;
                this.Close();
            }
        }
    }
}

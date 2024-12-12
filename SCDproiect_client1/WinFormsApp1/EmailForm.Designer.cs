namespace WinFormsApp1
{
    partial class EmailForm
    {
        /// <summary>
        /// Variabilele necesare pentru suportul Designer.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Curăță toate resursele utilizate.
        /// </summary>
        /// <param name="disposing">True dacă resursele manevrate de acest obiect trebuie să fie eliminate; altfel, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region "Codul generat de Windows Form Designer"

        /// <summary>
        /// Necesită variabilele pentru designer.
        /// </summary>
        private void InitializeComponent()
        {
            textBoxMessage = new TextBox();
            buttonSendEmail = new Button();
            labelManagers = new Label();
            labelMessage = new Label();
            checkedListBoxCouriers = new CheckedListBox();
            buttonSelectAll = new Button();
            SuspendLayout();
            // 
            // textBoxMessage
            // 
            textBoxMessage.Location = new Point(268, 29);
            textBoxMessage.Multiline = true;
            textBoxMessage.Name = "textBoxMessage";
            textBoxMessage.Size = new Size(320, 212);
            textBoxMessage.TabIndex = 1;
            // 
            // buttonSendEmail
            // 
            buttonSendEmail.Location = new Point(268, 247);
            buttonSendEmail.Name = "buttonSendEmail";
            buttonSendEmail.Size = new Size(320, 40);
            buttonSendEmail.TabIndex = 2;
            buttonSendEmail.Text = "Trimite E-mail";
            buttonSendEmail.UseVisualStyleBackColor = true;
            buttonSendEmail.Click += buttonSendEmail_Click;
            // 
            // labelManagers
            // 
            labelManagers.AutoSize = true;
            labelManagers.Location = new Point(12, 9);
            labelManagers.Name = "labelManagers";
            labelManagers.Size = new Size(102, 15);
            labelManagers.TabIndex = 3;
            labelManagers.Text = "Selectează Curieri:";
            // 
            // labelMessage
            // 
            labelMessage.AutoSize = true;
            labelMessage.Location = new Point(265, 9);
            labelMessage.Name = "labelMessage";
            labelMessage.Size = new Size(79, 15);
            labelMessage.TabIndex = 4;
            labelMessage.Text = "Scrie mesajul:";
            // 
            // checkedListBoxCouriers
            // 
            checkedListBoxCouriers.FormattingEnabled = true;
            checkedListBoxCouriers.Location = new Point(12, 29);
            checkedListBoxCouriers.Name = "checkedListBoxCouriers";
            checkedListBoxCouriers.Size = new Size(247, 184);
            checkedListBoxCouriers.TabIndex = 0;
            // 
            // buttonSelectAll
            // 
            buttonSelectAll.Location = new Point(89, 219);
            buttonSelectAll.Name = "buttonSelectAll";
            buttonSelectAll.Size = new Size(100, 30);
            buttonSelectAll.TabIndex = 1;
            buttonSelectAll.Text = "Select All";
            buttonSelectAll.UseVisualStyleBackColor = true;
            buttonSelectAll.Click += buttonSelectAll_Click;
            // 
            // EmailForm
            // 
            ClientSize = new Size(609, 305);
            Controls.Add(buttonSelectAll);
            Controls.Add(checkedListBoxCouriers);
            Controls.Add(labelMessage);
            Controls.Add(labelManagers);
            Controls.Add(buttonSendEmail);
            Controls.Add(textBoxMessage);
            Name = "EmailForm";
            Text = "Trimitere E-mailuri";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private System.Windows.Forms.TextBox textBoxMessage;
        private System.Windows.Forms.Button buttonSendEmail;
        private System.Windows.Forms.Label labelManagers;
        private System.Windows.Forms.Label labelMessage;
        private CheckedListBox checkedListBoxCouriers;
        private Button buttonSelectAll;
    }
}

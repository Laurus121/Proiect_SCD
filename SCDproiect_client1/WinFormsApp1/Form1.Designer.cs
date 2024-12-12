namespace WinFormsApp1
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            comboBox1 = new ComboBox();
            label1 = new Label();
            button1 = new Button();
            label2 = new Label();
            comboBox2 = new ComboBox();
            label3 = new Label();
            label_numarpachete = new Label();
            comboBox3 = new ComboBox();
            label4 = new Label();
            buttonOpenEmailForm = new Button();
            SuspendLayout();
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Location = new Point(173, 49);
            comboBox1.Margin = new Padding(3, 2, 3, 2);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(133, 23);
            comboBox1.TabIndex = 0;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(65, 52);
            label1.Name = "label1";
            label1.Size = new Size(77, 15);
            label1.TabIndex = 1;
            label1.Text = "busy couriers";
            // 
            // button1
            // 
            button1.Location = new Point(255, 290);
            button1.Margin = new Padding(3, 2, 3, 2);
            button1.Name = "button1";
            button1.Size = new Size(161, 22);
            button1.TabIndex = 2;
            button1.Text = "load";
            button1.UseVisualStyleBackColor = true;
            button1.Click += button1_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(12, 96);
            label2.Name = "label2";
            label2.Size = new Size(147, 15);
            label2.TabIndex = 3;
            label2.Text = "without pending packages";
            // 
            // comboBox2
            // 
            comboBox2.FormattingEnabled = true;
            comboBox2.Location = new Point(173, 93);
            comboBox2.Margin = new Padding(3, 2, 3, 2);
            comboBox2.Name = "comboBox2";
            comboBox2.Size = new Size(133, 23);
            comboBox2.TabIndex = 4;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(12, 138);
            label3.Name = "label3";
            label3.Size = new Size(259, 15);
            label3.TabIndex = 6;
            label3.Text = "Get all managers and their number of packages:";
            // 
            // label_numarpachete
            // 
            label_numarpachete.AutoSize = true;
            label_numarpachete.Location = new Point(347, 162);
            label_numarpachete.Name = "label_numarpachete";
            label_numarpachete.Size = new Size(0, 15);
            label_numarpachete.TabIndex = 9;
            // 
            // comboBox3
            // 
            comboBox3.FormattingEnabled = true;
            comboBox3.Location = new Point(65, 159);
            comboBox3.Margin = new Padding(3, 2, 3, 2);
            comboBox3.Name = "comboBox3";
            comboBox3.Size = new Size(133, 23);
            comboBox3.TabIndex = 11;
            comboBox3.SelectedIndexChanged += ComboBox3_SelectedIndexChanged;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(221, 162);
            label4.Name = "label4";
            label4.Size = new Size(120, 15);
            label4.TabIndex = 12;
            label4.Text = "Number of packages:";
            // 
            // buttonOpenEmailForm
            // 
            buttonOpenEmailForm.Location = new Point(452, 289);
            buttonOpenEmailForm.Name = "buttonOpenEmailForm";
            buttonOpenEmailForm.Size = new Size(139, 23);
            buttonOpenEmailForm.TabIndex = 13;
            buttonOpenEmailForm.Text = "Send E-mail";
            buttonOpenEmailForm.UseVisualStyleBackColor = true;
            buttonOpenEmailForm.Click += buttonOpenEmailForm_Click;
            // 
            // Form1
            //
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(700, 338);
            Controls.Add(buttonOpenEmailForm);
            Controls.Add(label4);
            Controls.Add(comboBox3);
            Controls.Add(label_numarpachete);
            Controls.Add(label3);
            Controls.Add(comboBox2);
            Controls.Add(label2);
            Controls.Add(button1);
            Controls.Add(label1);
            Controls.Add(comboBox1);
            Margin = new Padding(3, 2, 3, 2);
            Name = "Form1";
            Text = "Package tracking";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox comboBox1;
        private Label label1;
        private Button button1;
        private Label label2;
        private ComboBox comboBox2;
        private Label label3;
        private Label label_numarpachete;
        private ComboBox comboBox3;
        private Label label4;
        private Button buttonOpenEmailForm;
    }
}
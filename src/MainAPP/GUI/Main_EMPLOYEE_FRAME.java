/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainAPP.GUI;

import static MainAPP.GUI.Main_STUDENT_FRAME.updateDatabase;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vincent
 */
public class Main_EMPLOYEE_FRAME extends javax.swing.JFrame {
    Connection con = null;
    private boolean isEditing = false;
    
    private String mapStatusToLabel_Gender(String gender) {
        switch (gender) {
            case "F":
                return "Female";
            case "M":
                return "Male";
            // Add more cases as needed
            default:
                return gender; // Return original value if no mapping is defined
        }
    }    
    
    private String mapLabelToStatus_Gender(String label) {
        switch (label) {
            case "Female":
                return "F";
            case "Male":
                return "M";
            // Add more cases as needed
            default:
                return label; // Return original value if no mapping is defined
        }
    }   
    
    private String mapStatusToLabel_Status(String status) {
        switch (status) {
            case "A":
                return "Active";
            case "I":
                return "Inactive";
            // Add more cases as needed
            default:
                return status; // Return original value if no mapping is defined
        }
    }    
    
    /**
     * Creates new form STUDENT_FRAME
     */
    public Main_EMPLOYEE_FRAME() {
        initComponents();
        this.setLocationRelativeTo(null);
        //SIDEBAR MENU STYLES
        label_overview_tab.setForeground(Color.WHITE);
        overview_active.setVisible(true);
        tab2_active.setVisible(false);
        panel_2.setVisible(false);
        label_overview_tab.setForeground(Color.WHITE);
        employee_firstname_fld.setEditable(false);
        employee_firstname_fld.setEditable(false);
        employee_lastname_fld.setEditable(false);
        employee_gender_fld.setEditable(false);
        employee_phone_num_fld.setEditable(false);
        employee_address_fld.setEditable(false);
        employee_bday_fld.setEditable(false);    
        illness_description_fld.setEditable(false);  
        attending_physician_fld.setEditable(false);  
        prepared_by_fld.setEditable(false);  
        date_consulted_fld.setEditable(false);  
        diagnosis_fld.setEditable(false);  
        save_lbl.setVisible(false);
        discard_lbl.setVisible(false);

    }

    public Main_EMPLOYEE_FRAME(String employee_id, String firstName, String lastName, String email, String address, String bday, String cp_num, String gender, String status) {
        initComponents();
        this.setLocationRelativeTo(null);
        // SIDEBAR MENU STYLES
        label_overview_tab.setForeground(Color.WHITE);
        overview_active.setVisible(true);
        tab2_active.setVisible(false);
        panel_2.setVisible(false);
        label_overview_tab.setForeground(Color.WHITE);
        dateChooser1.setVisible(false);
        
        // MAKE FIELDS NON EDITABLE
        employee_firstname_fld.setEditable(false);
        employee_firstname_fld.setEditable(false);
        employee_lastname_fld.setEditable(false);
        employee_gender_fld.setEditable(false);
        employee_phone_num_fld.setEditable(false);
        employee_address_fld.setEditable(false);
        employee_bday_fld.setEditable(false);
        illness_description_fld.setEditable(false);
        attending_physician_fld.setEditable(false);
        prepared_by_fld.setEditable(false);
        date_consulted_fld.setEditable(false);
        diagnosis_fld.setEditable(false);
        save_lbl.setVisible(false);
        discard_lbl.setVisible(false);
        employee_gender_cb.setVisible(false);

        // SHOW INFORMATION
        welcome_lbl_id.setText(employee_id + " !");
        employee_id_fld.setText(employee_id);
        employee_firstname_fld.setText(firstName);
        employee_lastname_fld.setText(lastName);
        employee_email_fld.setText(email);
        employee_phone_num_fld.setText(cp_num);
        
        // Gender Mapping
        employee_gender_fld.setText(mapStatusToLabel_Gender(gender));
        employee_gender_cb.setSelectedItem(mapStatusToLabel_Gender(gender));

        employee_address_fld.setText(address);

        employee_bday_fld.setText(bday);

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            Date birthdate = dateFormat.parse(bday);
            dateChooser1.setSelectedDate(birthdate);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the ParseException appropriately in your application
        }

        // Status Mapping
        employee_status_fld.setText(mapStatusToLabel_Status(status));

    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser1 = new com.raven.datechooser.DateChooser();
        tab1 = new javax.swing.JPanel();
        icon_overview = new javax.swing.JLabel();
        label_overview_tab = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        tab2_icon = new javax.swing.JLabel();
        tab2_label = new javax.swing.JLabel();
        Exit_Btn = new javax.swing.JPanel();
        label_exit_tab = new javax.swing.JLabel();
        icon_exit = new javax.swing.JLabel();
        overview_active = new javax.swing.JPanel();
        tab2_active = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        edit_student_btn = new javax.swing.JButton();
        discard_btn_student = new javax.swing.JButton();
        save_btn_student = new javax.swing.JButton();
        save_lbl = new javax.swing.JLabel();
        discard_lbl = new javax.swing.JLabel();
        welcome_lbl = new javax.swing.JLabel();
        welcome_lbl_id = new javax.swing.JLabel();
        panel_1 = new javax.swing.JPanel();
        employee_gender_cb = new javax.swing.JComboBox<>();
        employee_lastname_fld = new javax.swing.JTextField();
        employee_gender_fld = new javax.swing.JTextField();
        employee_firstname_fld = new javax.swing.JTextField();
        employee_email_fld = new javax.swing.JTextField();
        employee_address_fld = new javax.swing.JTextField();
        employee_status_fld = new javax.swing.JTextField();
        employee_bday_fld = new javax.swing.JTextField();
        employee_phone_num_fld = new javax.swing.JTextField();
        employee_id_fld = new javax.swing.JTextField();
        P1_LAYOUT = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        panel_2 = new javax.swing.JPanel();
        date_consulted_fld = new javax.swing.JTextField();
        prepared_by_fld = new javax.swing.JTextField();
        attending_physician_fld = new javax.swing.JTextField();
        illness_description_fld = new javax.swing.JTextField();
        diagnosis_fld = new javax.swing.JTextField();
        P2_LAYOUT = new javax.swing.JLabel();
        LAYOUT = new javax.swing.JLabel();

        dateChooser1.setForeground(new java.awt.Color(51, 108, 251));
        dateChooser1.setDateFormat("yyyy-MM-dd");
        dateChooser1.setFont(new java.awt.Font("Lato", 0, 13)); // NOI18N
        dateChooser1.setTextRefernce(employee_bday_fld);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tab1.setBackground(new java.awt.Color(0,0,0,0));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        icon_overview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/patienticon.png"))); // NOI18N

        label_overview_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_overview_tab.setText("My Information");

        javax.swing.GroupLayout tab1Layout = new javax.swing.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icon_overview, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_overview_tab)
                .addContainerGap(152, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(icon_overview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_overview_tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(641, 641, 641))
        );

        getContentPane().add(tab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 300, 40));

        tab2.setBackground(new java.awt.Color(0,0,0,0));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        tab2_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/appointmenticon.png"))); // NOI18N

        tab2_label.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        tab2_label.setText("Appointment Information");

        javax.swing.GroupLayout tab2Layout = new javax.swing.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tab2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tab2_icon, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tab2_label)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(tab2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tab2_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tab2_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(641, 641, 641))
        );

        getContentPane().add(tab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 300, 40));

        Exit_Btn.setBackground(new java.awt.Color(0,0,0,0));
        Exit_Btn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Exit_BtnMouseClicked(evt);
            }
        });

        label_exit_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_exit_tab.setText("Exit");

        icon_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/exiticon.png"))); // NOI18N

        javax.swing.GroupLayout Exit_BtnLayout = new javax.swing.GroupLayout(Exit_Btn);
        Exit_Btn.setLayout(Exit_BtnLayout);
        Exit_BtnLayout.setHorizontalGroup(
            Exit_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Exit_BtnLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(icon_exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_exit_tab)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        Exit_BtnLayout.setVerticalGroup(
            Exit_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Exit_BtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Exit_BtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_exit)
                    .addComponent(label_exit_tab))
                .addGap(83, 83, 83))
        );

        getContentPane().add(Exit_Btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 300, 40));

        overview_active.setBackground(new java.awt.Color(51, 108, 251));
        overview_active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                overview_activeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout overview_activeLayout = new javax.swing.GroupLayout(overview_active);
        overview_active.setLayout(overview_activeLayout);
        overview_activeLayout.setHorizontalGroup(
            overview_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        overview_activeLayout.setVerticalGroup(
            overview_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(overview_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 125, 301, 40));

        tab2_active.setBackground(new java.awt.Color(51, 108, 251));
        tab2_active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2_activeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout tab2_activeLayout = new javax.swing.GroupLayout(tab2_active);
        tab2_active.setLayout(tab2_activeLayout);
        tab2_activeLayout.setHorizontalGroup(
            tab2_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        tab2_activeLayout.setVerticalGroup(
            tab2_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(tab2_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 301, 40));

        jLabel2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel2.setText("STUDENT MENU");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 100, -1, -1));

        edit_student_btn.setOpaque(false);
        edit_student_btn.setContentAreaFilled(false); //to make the content area transparent
        edit_student_btn.setBorderPainted(false);
        edit_student_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit_student_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_student_btnActionPerformed(evt);
            }
        });
        getContentPane().add(edit_student_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 40, 160, 30));

        discard_btn_student.setOpaque(false);
        discard_btn_student.setContentAreaFilled(false); //to make the content area transparent
        discard_btn_student.setBorderPainted(false);
        discard_btn_student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        discard_btn_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discard_btn_studentActionPerformed(evt);
            }
        });
        getContentPane().add(discard_btn_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 80, 30));

        save_btn_student.setOpaque(false);
        save_btn_student.setContentAreaFilled(false); //to make the content area transparent
        save_btn_student.setBorderPainted(false);
        save_btn_student.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save_btn_student.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_btn_studentActionPerformed(evt);
            }
        });
        getContentPane().add(save_btn_student, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 80, 30));

        save_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/save_btn_student.png"))); // NOI18N
        getContentPane().add(save_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, -1, -1));

        discard_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/discard_btn_student.png"))); // NOI18N
        getContentPane().add(discard_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 40, -1, -1));

        welcome_lbl.setFont(new java.awt.Font("Lato", 1, 13)); // NOI18N
        welcome_lbl.setText("Welcome,");
        getContentPane().add(welcome_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(1061, 40, -1, -1));

        welcome_lbl_id.setFont(new java.awt.Font("Lato", 1, 13)); // NOI18N
        welcome_lbl_id.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        welcome_lbl_id.setText("Name");
        getContentPane().add(welcome_lbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 280, -1));

        panel_1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee_gender_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        employee_gender_cb.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_gender_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        panel_1.add(employee_gender_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(687, 410, 107, 50));

        employee_lastname_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_lastname_fld.setText("jTextField1");
        employee_lastname_fld.setBorder(null);
        panel_1.add(employee_lastname_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 330, -1));

        employee_gender_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_gender_fld.setText("jTextField1");
        employee_gender_fld.setBorder(null);
        panel_1.add(employee_gender_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 422, 80, -1));

        employee_firstname_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_firstname_fld.setText("jTextField1");
        employee_firstname_fld.setBorder(null);
        panel_1.add(employee_firstname_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 330, -1));

        employee_email_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_email_fld.setText("jTextField1");
        employee_email_fld.setBorder(null);
        employee_email_fld.setRequestFocusEnabled(false);
        panel_1.add(employee_email_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 248, 710, -1));

        employee_address_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_address_fld.setText("jTextField1");
        employee_address_fld.setBorder(null);
        panel_1.add(employee_address_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 335, 710, -1));

        employee_status_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_status_fld.setText("jTextField1");
        employee_status_fld.setBorder(null);
        employee_status_fld.setRequestFocusEnabled(false);
        panel_1.add(employee_status_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 510, 330, -1));

        employee_bday_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_bday_fld.setBorder(null);
        panel_1.add(employee_bday_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 422, 200, -1));

        employee_phone_num_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_phone_num_fld.setText("jTextField1");
        employee_phone_num_fld.setBorder(null);
        employee_phone_num_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employee_phone_num_fldKeyTyped(evt);
            }
        });
        panel_1.add(employee_phone_num_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 422, 330, -1));

        employee_id_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employee_id_fld.setText("jTextField1");
        employee_id_fld.setBorder(null);
        employee_id_fld.setRequestFocusEnabled(false);
        panel_1.add(employee_id_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 330, -1));

        P1_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/EMPLOYEE_FRAME_INFO.png"))); // NOI18N
        panel_1.add(P1_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        discard_btn_student.setOpaque(false);
        discard_btn_student.setContentAreaFilled(false); //to make the content area transparent
        discard_btn_student.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        panel_1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, 160, 30));

        getContentPane().add(panel_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 770));

        panel_2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        date_consulted_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        date_consulted_fld.setText("jTextField1");
        date_consulted_fld.setBorder(null);
        panel_2.add(date_consulted_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 710, -1));

        prepared_by_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        prepared_by_fld.setText("jTextField1");
        prepared_by_fld.setBorder(null);
        panel_2.add(prepared_by_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 245, 330, -1));

        attending_physician_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        attending_physician_fld.setText("jTextField1");
        attending_physician_fld.setBorder(null);
        panel_2.add(attending_physician_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 245, 330, -1));

        illness_description_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        illness_description_fld.setText("jTextField1");
        illness_description_fld.setBorder(null);
        panel_2.add(illness_description_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 333, 710, -1));

        diagnosis_fld.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        diagnosis_fld.setText("jTextField1");
        diagnosis_fld.setBorder(null);
        diagnosis_fld.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        panel_2.add(diagnosis_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 422, 710, 290));
        diagnosis_fld.getAccessibleContext().setAccessibleDescription("");

        P2_LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/STUDENT_FRAME_APPOINTMENT.png"))); // NOI18N
        panel_2.add(P2_LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(panel_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 850, 770));

        LAYOUT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/STUDENT_FRAME_SIDE.png"))); // NOI18N
        getContentPane().add(LAYOUT, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void overview_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overview_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_overview_activeMouseClicked

    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        label_overview_tab.setForeground(Color.WHITE);
        tab2_label.setForeground(Color.BLACK);
        panel_1.setVisible(true);
        panel_2.setVisible(false);
        overview_active.setVisible(true);
        tab2_active.setVisible(false);
    }//GEN-LAST:event_tab1MouseClicked

    private void Exit_BtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Exit_BtnMouseClicked
        Main_EMPLOYEE_FRAME.this.setVisible(false);
        new Login_FRAME().setVisible(true);
    }//GEN-LAST:event_Exit_BtnMouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        tab2_label.setForeground(Color.WHITE);
        label_overview_tab.setForeground(Color.BLACK);
        panel_1.setVisible(false);
        panel_2.setVisible(true);
        tab2_active.setVisible(true);
        overview_active.setVisible(false);
    }//GEN-LAST:event_tab2MouseClicked

    private void tab2_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tab2_activeMouseClicked

    private void edit_student_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_student_btnActionPerformed
        if(isEditing){
            JOptionPane.showMessageDialog(this, "You are currently editing. Please save or discard changes.", "", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "You can now edit your information !\nThe fields highlighted in red cannot be edited", "", JOptionPane.WARNING_MESSAGE);
            dateChooser1.showPopup();
            employee_id_fld.setForeground(Color.red);
            employee_gender_cb.setVisible(true);
            employee_firstname_fld.setEditable(true);
            employee_lastname_fld.setEditable(true);
            employee_gender_fld.setEditable(true);
            employee_phone_num_fld.setEditable(true);
            employee_address_fld.setEditable(true);
            employee_bday_fld.setEditable(false);
            employee_email_fld.setForeground(Color.red);
            employee_status_fld.setForeground(Color.red);
            save_lbl.setVisible(true);
            discard_lbl.setVisible(true);
            dateChooser1.setVisible(true);
            isEditing = true;
        }
    }//GEN-LAST:event_edit_student_btnActionPerformed

    private void save_btn_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_btn_studentActionPerformed
        JOptionPane.showMessageDialog(this, "The changes you made were saved !", "", JOptionPane.WARNING_MESSAGE);
        save_lbl.setVisible(false);
        discard_lbl.setVisible(false);
        dateChooser1.setVisible(false);

        String studentNo = employee_id_fld.getText();
        String newFirstname = employee_firstname_fld.getText();
        String newLastname = employee_lastname_fld.getText();
        String newAddress = employee_address_fld.getText();
        String newContactNumber = employee_phone_num_fld.getText();
        String newBirthdate = employee_bday_fld.getText();
        String newGenderLabel = (String) employee_gender_cb.getSelectedItem();
        String newGenderStatus = mapLabelToStatus_Gender(newGenderLabel);
        
        // Call the updateDatabase method with multiple fields
        updateEmployeeDatabase(studentNo, newFirstname, newLastname, newAddress, newContactNumber, newBirthdate, newGenderStatus);
        
        employee_firstname_fld.setEditable(false);
        employee_firstname_fld.setEditable(false);
        employee_lastname_fld.setEditable(false);
        employee_gender_fld.setEditable(false);
        employee_gender_cb.setVisible(false);
        employee_phone_num_fld.setEditable(false);
        employee_address_fld.setEditable(false);
        employee_bday_fld.setEditable(false);
        employee_id_fld.setForeground(Color.black);
        employee_email_fld.setForeground(Color.black);
        employee_status_fld.setForeground(Color.black);
        resetEditingState();
        resetFieldsToOriginalData();
    }//GEN-LAST:event_save_btn_studentActionPerformed

    private void discard_btn_studentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discard_btn_studentActionPerformed
        JOptionPane.showMessageDialog(this, "No changes were saved !", "", JOptionPane.WARNING_MESSAGE);
        save_lbl.setVisible(false);
        discard_lbl.setVisible(false);
        dateChooser1.setVisible(false);

        employee_firstname_fld.setEditable(false);
        employee_firstname_fld.setEditable(false);
        employee_lastname_fld.setEditable(false);
        employee_gender_fld.setEditable(false);
        employee_gender_cb.setVisible(false);
        employee_phone_num_fld.setEditable(false);
        employee_address_fld.setEditable(false);
        employee_bday_fld.setEditable(false);
        employee_id_fld.setForeground(Color.black);
        employee_email_fld.setForeground(Color.black);
        employee_status_fld.setForeground(Color.black);
        resetEditingState();
        resetFieldsToOriginalData();
    }//GEN-LAST:event_discard_btn_studentActionPerformed

    private void employee_phone_num_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_phone_num_fldKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        
        // Check if the total number of digits is less than 10
        if (employee_phone_num_fld.getText().length() >= 11) {
            evt.consume();
        }

        // Check if it's the first digit and it's not 0
        if (employee_phone_num_fld.getText().isEmpty() && c != '0') {
            evt.consume();
        }
        
        // TODO add your handling code here:       // TODO add your handling code here:
    }//GEN-LAST:event_employee_phone_num_fldKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main_EMPLOYEE_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_EMPLOYEE_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_EMPLOYEE_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_EMPLOYEE_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_EMPLOYEE_FRAME().setVisible(true);
            }
        });
    }

    public static void updateEmployeeDatabase(String employeeId, String newFirstname, String newLastname, String newAddress, String newContactNumber, String newBirthdate, String newGender) {
        try {
            // Directly include connection details
            Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/CLINIC_FinalProject", "clinicadmin", "clinicadmin");

            // Assuming you have a table named "DT_EMPLOYEE" with columns "employee_id", "lastname", "firstname", "gender", "cp_num", "address", and "bday"
            String updateQuery = "UPDATE DT_EMPLOYEE SET lastname = ?, firstname = ?, gender = ?, cp_num = ?, address = ?, bday = ? WHERE employee_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newLastname);
                preparedStatement.setString(2, newFirstname);
                preparedStatement.setString(3, newGender);
                preparedStatement.setString(4, newContactNumber);
                preparedStatement.setString(5, newAddress);
                preparedStatement.setString(6, newBirthdate);
                preparedStatement.setString(7, employeeId);

                preparedStatement.executeUpdate();
            }

            // Close the connection
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
    }

    private void resetEditingState() {
        isEditing = false;
        // Add code to reset the editable state of fields or any other necessary cleanup
    }
    
    private void resetFieldsToOriginalData() {
        // Replace "your_table_name" with the actual table name in your database

        // Assuming student_id is the primary key for your student records
        String student_no = employee_id_fld.getText(); // Replace with the actual field holding the student_id

        try (Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/CLINIC_FinalProject", "clinicadmin", "clinicadmin")) {
            String selectQuery = "SELECT * FROM DT_EMPLOYEE WHERE employee_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setString(1, student_no);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        // Assuming these are column names in your database, replace with actual column names
                        // ... (repeat for other fields)

                        // Set the text fields with the original data
                        employee_firstname_fld.setText(resultSet.getString("firstname"));
                        employee_lastname_fld.setText(resultSet.getString("lastname"));
                        employee_address_fld.setText(resultSet.getString("address"));
                        employee_phone_num_fld.setText(resultSet.getString("cp_num"));
                        employee_address_fld.setText(resultSet.getString("address"));
                        employee_bday_fld.setText(resultSet.getString("bday"));
                        employee_gender_fld.setText(mapStatusToLabel_Gender(resultSet.getString("gender")));

                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Exit_Btn;
    private javax.swing.JLabel LAYOUT;
    private javax.swing.JLabel P1_LAYOUT;
    private javax.swing.JLabel P2_LAYOUT;
    private javax.swing.JTextField attending_physician_fld;
    private com.raven.datechooser.DateChooser dateChooser1;
    private javax.swing.JTextField date_consulted_fld;
    private javax.swing.JTextField diagnosis_fld;
    private javax.swing.JButton discard_btn_student;
    private javax.swing.JLabel discard_lbl;
    private javax.swing.JButton edit_student_btn;
    private javax.swing.JTextField employee_address_fld;
    private javax.swing.JTextField employee_bday_fld;
    private javax.swing.JTextField employee_email_fld;
    private javax.swing.JTextField employee_firstname_fld;
    private javax.swing.JComboBox<String> employee_gender_cb;
    private javax.swing.JTextField employee_gender_fld;
    private javax.swing.JTextField employee_id_fld;
    private javax.swing.JTextField employee_lastname_fld;
    private javax.swing.JTextField employee_phone_num_fld;
    private javax.swing.JTextField employee_status_fld;
    private javax.swing.JLabel icon_exit;
    private javax.swing.JLabel icon_overview;
    private javax.swing.JTextField illness_description_fld;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_exit_tab;
    private javax.swing.JLabel label_overview_tab;
    private javax.swing.JPanel overview_active;
    private javax.swing.JPanel panel_1;
    private javax.swing.JPanel panel_2;
    private javax.swing.JTextField prepared_by_fld;
    private javax.swing.JButton save_btn_student;
    private javax.swing.JLabel save_lbl;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab2_active;
    private javax.swing.JLabel tab2_icon;
    private javax.swing.JLabel tab2_label;
    private javax.swing.JLabel welcome_lbl;
    private javax.swing.JLabel welcome_lbl_id;
    // End of variables declaration//GEN-END:variables
}

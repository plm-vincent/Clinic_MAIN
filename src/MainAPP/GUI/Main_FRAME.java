/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MainAPP.GUI;
import com.raven.datechooser.DateChooser;
import javax.swing.JScrollPane;
import static javax.swing.ScrollPaneConstants.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.swing.table.Table;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Vincent
 */
public class Main_FRAME extends javax.swing.JFrame {
    private Connection con;
    private boolean isEditing = false;
    /**
     * Creates new form Main_FRAME
     */
    public Main_FRAME() {
        initComponents();
        this.setLocationRelativeTo(null);
        //SIDEBAR MENU STYLES
        label_overview_tab.setForeground(Color.WHITE);
        overview_active.setVisible(true);
        patients_active.setVisible(false);
        employees_active.setVisible(false);
        illness_active.setVisible(false);
        appointments_active.setVisible(false);
        
        //student, employee, illness fields disable editing
        textFieldEditFalse();
        student_college_fld.setEditable(false);
        student_course_fld.setEditable(false);
        student_bday_chooser.setVisible(false);
        employee_bday_chooser.setVisible(false);
        
        hideComboBoxes();

        //discard and save buttons (labels)
        hideSaveAndDiscardButtons();
//        save_btn_appointment_lbl.setVisible(false);
//        discard_btn_appointment_lbl.setVisible(false);

        //Action Listener for student_table1
        student_table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = student_table1.getSelectedRow();
                    // Now you have the index of the selected row
                    // Retrieve the data from the model and update your text fields
                    updateTextFieldStudent(selectedRow);

                    // Check if the student_no is present in the FT_CONSULTATION table
                    String studentNo = student_no_fld.getText();
                    if (isStudentInConsultationTable(studentNo)) {
                        student_no_fld.setEditable(false);
                        student_no_fld.setForeground(Color.red);
                    } else {
                        student_no_fld.setForeground(Color.black);
                    }
                }
            }
        });
        
        //Action Listener for employee_table1
        employee_table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = employee_table1.getSelectedRow();
                    // Now you have the index of the selected row
                    // Retrieve the data from the model and update your text fields
                    updateTextFieldEmployee(selectedRow);

                    // Check if the student_no is present in the FT_CONSULTATION table
                    String employeeNo = employee_no_fld.getText();
                    if (isEmployeeInConsultationTable(employeeNo)) {
                        employee_no_fld.setEditable(false);
                        employee_no_fld.setForeground(Color.red);
                    } else {
                        employee_no_fld.setForeground(Color.black);
                    }
                }
            }
        });
        
        //Action Listener for illness_table1
        illness_table1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = illness_table1.getSelectedRow();
                    // Now you have the index of the selected row
                    // Retrieve the data from the model and update your text fields
                    updateTextFieldIllness(selectedRow);

                    // Check if the student_no is present in the FT_CONSULTATION table
                    String illnessCode = illness_code_fld.getText();
                    if (isIllnessInConsultationTable(illnessCode)) {
                        illness_code_fld.setEditable(false);
                        illness_code_fld.setForeground(Color.red);
                    } else {
                        illness_code_fld.setForeground(Color.black);
                    }
                }
            }
        });

        if(!student_course_list_cb.isVisible()){
            resetAllTextFields();
        }
        
        // Action Listener for student_course_list_cb
        student_course_list_cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected course
                String selectedCourse = (String) student_course_list_cb.getSelectedItem();

                // Call a method to update the JTextField with the corresponding college
                updateCollegeTextField(student_college_fld, student_course_list_cb);
            }
        });
        

        
//        overview_panel.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
//        patients_panel.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
//        employees_panel.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
//        appointments_panel.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        student_bday_chooser = new com.raven.datechooser.DateChooser();
        employee_bday_chooser = new com.raven.datechooser.DateChooser();
        jLabel2 = new javax.swing.JLabel();
        overview_tab = new javax.swing.JPanel();
        icon_overview = new javax.swing.JLabel();
        label_overview_tab = new javax.swing.JLabel();
        students_tab = new javax.swing.JPanel();
        label_patients_tab = new javax.swing.JLabel();
        icon_patients = new javax.swing.JLabel();
        employees_tab = new javax.swing.JPanel();
        label_employees_tab = new javax.swing.JLabel();
        icon_doctor = new javax.swing.JLabel();
        illness_tab = new javax.swing.JPanel();
        label_illness_tab = new javax.swing.JLabel();
        icon_illness = new javax.swing.JLabel();
        appointment_tab = new javax.swing.JPanel();
        label_appointments_tab = new javax.swing.JLabel();
        icon_appointment = new javax.swing.JLabel();
        exit_tab = new javax.swing.JPanel();
        label_exit_tab = new javax.swing.JLabel();
        icon_exit = new javax.swing.JLabel();
        overview_active = new javax.swing.JPanel();
        patients_active = new javax.swing.JPanel();
        employees_active = new javax.swing.JPanel();
        illness_active = new javax.swing.JPanel();
        appointments_active = new javax.swing.JPanel();
        SIDE_TAB = new javax.swing.JLabel();
        overview_panel = new MainAPP.GUI.ScrollPaneWin11();
        overview_panel_main = new javax.swing.JPanel();
        appointments_total = new javax.swing.JLabel();
        patients_total = new javax.swing.JLabel();
        employees_total = new javax.swing.JLabel();
        illness_total = new javax.swing.JLabel();
        appointment_table_pane = new MainAPP.GUI.ScrollPaneWin11();
        appointment_table = new javaswingdev.swing.table.Table();
        student_table_pane = new MainAPP.GUI.ScrollPaneWin11();
        student_table = new javaswingdev.swing.table.Table();
        employee_table_pane = new MainAPP.GUI.ScrollPaneWin11();
        employee_table = new javaswingdev.swing.table.Table();
        illness_table_pane = new MainAPP.GUI.ScrollPaneWin11();
        illness_table = new javaswingdev.swing.table.Table();
        jLabel1 = new javax.swing.JLabel();
        patient_panel = new MainAPP.GUI.ScrollPaneWin11();
        patient_panel_main = new javax.swing.JPanel();
        student_course_list_cb = new javax.swing.JComboBox<>();
        student_discard_btn = new javax.swing.JButton();
        student_edit_save_btn = new javax.swing.JButton();
        student_add_save_btn = new javax.swing.JButton();
        save_btn_student_lbl = new javax.swing.JLabel();
        discard_btn_student_lbl = new javax.swing.JLabel();
        student_cmd_add = new javax.swing.JButton();
        student_cmd_edit = new javax.swing.JButton();
        student_cmd_delete = new javax.swing.JButton();
        add_btn_lbl = new javax.swing.JLabel();
        edit_btn_lbl = new javax.swing.JLabel();
        delete_btn_lbl = new javax.swing.JLabel();
        student_status_cb = new javax.swing.JComboBox<>();
        student_gender_cb = new javax.swing.JComboBox<>();
        student_firstname_fld = new javax.swing.JTextField();
        student_lastname_fld = new javax.swing.JTextField();
        student_email_fld = new javax.swing.JTextField();
        student_address_fld = new javax.swing.JTextField();
        student_cp_no_fld = new javax.swing.JTextField();
        student_birthdate_fld = new javax.swing.JTextField();
        student_gender_fld = new javax.swing.JTextField();
        student_status_fld = new javax.swing.JTextField();
        student_course_fld = new javax.swing.JTextField();
        student_college_fld = new javax.swing.JTextField();
        student_no_fld = new javax.swing.JTextField();
        student_table_pane1 = new MainAPP.GUI.ScrollPaneWin11();
        student_table1 = new javaswingdev.swing.table.Table();
        jLabel3 = new javax.swing.JLabel();
        student_no_fld1 = new javax.swing.JTextField();
        employees_panel = new MainAPP.GUI.ScrollPaneWin11();
        employee_panel_main = new javax.swing.JPanel();
        employee_discard_btn = new javax.swing.JButton();
        employee_edit_save_btn = new javax.swing.JButton();
        employee_add_save_btn = new javax.swing.JButton();
        save_btn_employee_lbl = new javax.swing.JLabel();
        discard_btn_employee_lbl = new javax.swing.JLabel();
        employee_cmd_add = new javax.swing.JButton();
        employee_cmd_edit = new javax.swing.JButton();
        employee_cmd_delete = new javax.swing.JButton();
        add_btn_lbl1 = new javax.swing.JLabel();
        edit_btn_lbl1 = new javax.swing.JLabel();
        delete_btn_lbl1 = new javax.swing.JLabel();
        employee_status_cb = new javax.swing.JComboBox<>();
        employee_gender_cb = new javax.swing.JComboBox<>();
        employee_firstname_fld = new javax.swing.JTextField();
        employee_lastname_fld = new javax.swing.JTextField();
        employee_email_fld = new javax.swing.JTextField();
        employee_address_fld = new javax.swing.JTextField();
        employee_cp_no_fld = new javax.swing.JTextField();
        employee_birthdate_fld = new javax.swing.JTextField();
        employee_gender_fld = new javax.swing.JTextField();
        employee_status_fld = new javax.swing.JTextField();
        employee_no_fld = new javax.swing.JTextField();
        employee_table_pane1 = new MainAPP.GUI.ScrollPaneWin11();
        employee_table1 = new javaswingdev.swing.table.Table();
        jLabel4 = new javax.swing.JLabel();
        employee_no_fld1 = new javax.swing.JTextField();
        illness_panel = new MainAPP.GUI.ScrollPaneWin11();
        illness_panel_main = new javax.swing.JPanel();
        illness_discard_btn = new javax.swing.JButton();
        illness_add_save_btn = new javax.swing.JButton();
        illness_edit_save_btn = new javax.swing.JButton();
        save_btn_illness_lbl = new javax.swing.JLabel();
        discard_btn_illness_lbl = new javax.swing.JLabel();
        illness_cmd_add = new javax.swing.JButton();
        illness_cmd_edit = new javax.swing.JButton();
        illness_cmd_delete = new javax.swing.JButton();
        add_btn_lbl2 = new javax.swing.JLabel();
        edit_btn_lbl2 = new javax.swing.JLabel();
        delete_btn_lbl2 = new javax.swing.JLabel();
        illness_status_cb = new javax.swing.JComboBox<>();
        illness_status_fld = new javax.swing.JTextField();
        illness_code_fld = new javax.swing.JTextField();
        illness_description_fld = new javax.swing.JTextField();
        illness_table_pane1 = new MainAPP.GUI.ScrollPaneWin11();
        illness_table1 = new javaswingdev.swing.table.Table();
        jLabel5 = new javax.swing.JLabel();
        illness_code_fld1 = new javax.swing.JTextField();

        student_bday_chooser.setForeground(new java.awt.Color(51, 108, 251));
        student_bday_chooser.setDateFormat("yyyy-MM-dd");
        student_bday_chooser.setTextRefernce(student_birthdate_fld);

        employee_bday_chooser.setForeground(new java.awt.Color(51, 108, 251));
        employee_bday_chooser.setDateFormat("yyyy-MM-dd");
        employee_bday_chooser.setTextRefernce(employee_birthdate_fld);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1230, 768));
        setPreferredSize(new java.awt.Dimension(1800, 770));
        setResizable(false);
        setSize(new java.awt.Dimension(1800, 768));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Lato", 0, 14)); // NOI18N
        jLabel2.setText("ADMIN MENU");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 100, -1, -1));

        overview_tab.setBackground(new java.awt.Color(0,0,0,0));
        overview_tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        overview_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                overview_tabMouseClicked(evt);
            }
        });

        icon_overview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/overviewicon.png"))); // NOI18N

        label_overview_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_overview_tab.setText("Overview");

        javax.swing.GroupLayout overview_tabLayout = new javax.swing.GroupLayout(overview_tab);
        overview_tab.setLayout(overview_tabLayout);
        overview_tabLayout.setHorizontalGroup(
            overview_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(overview_tabLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icon_overview, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_overview_tab)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        overview_tabLayout.setVerticalGroup(
            overview_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, overview_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(overview_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(icon_overview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_overview_tab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(83, 83, 83))
        );

        getContentPane().add(overview_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 300, 40));

        students_tab.setBackground(new java.awt.Color(0,0,0,0));
        students_tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        students_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                students_tabMouseClicked(evt);
            }
        });

        label_patients_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_patients_tab.setText("Students");

        icon_patients.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/patienticon.png"))); // NOI18N

        javax.swing.GroupLayout students_tabLayout = new javax.swing.GroupLayout(students_tab);
        students_tab.setLayout(students_tabLayout);
        students_tabLayout.setHorizontalGroup(
            students_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(students_tabLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icon_patients)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_patients_tab)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        students_tabLayout.setVerticalGroup(
            students_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, students_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(students_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_patients)
                    .addComponent(label_patients_tab))
                .addGap(83, 83, 83))
        );

        getContentPane().add(students_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 300, 40));

        employees_tab.setBackground(new java.awt.Color(0,0,0,0));
        employees_tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employees_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employees_tabMouseClicked(evt);
            }
        });

        label_employees_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_employees_tab.setText("Employees");

        icon_doctor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/doctoricon.png"))); // NOI18N

        javax.swing.GroupLayout employees_tabLayout = new javax.swing.GroupLayout(employees_tab);
        employees_tab.setLayout(employees_tabLayout);
        employees_tabLayout.setHorizontalGroup(
            employees_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employees_tabLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icon_doctor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_employees_tab)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        employees_tabLayout.setVerticalGroup(
            employees_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, employees_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(employees_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(icon_doctor)
                    .addComponent(label_employees_tab))
                .addGap(83, 83, 83))
        );

        getContentPane().add(employees_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 300, 40));

        illness_tab.setBackground(new java.awt.Color(0,0,0,0));
        illness_tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                illness_tabMouseClicked(evt);
            }
        });

        label_illness_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_illness_tab.setText("Illnesses");

        icon_illness.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/illnessicon.png"))); // NOI18N
        icon_illness.setPreferredSize(new java.awt.Dimension(14, 18));

        javax.swing.GroupLayout illness_tabLayout = new javax.swing.GroupLayout(illness_tab);
        illness_tab.setLayout(illness_tabLayout);
        illness_tabLayout.setHorizontalGroup(
            illness_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(illness_tabLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icon_illness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_illness_tab)
                .addContainerGap(198, Short.MAX_VALUE))
        );
        illness_tabLayout.setVerticalGroup(
            illness_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, illness_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(illness_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_illness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_illness_tab))
                .addGap(83, 83, 83))
        );

        getContentPane().add(illness_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 300, 40));

        appointment_tab.setBackground(new java.awt.Color(0,0,0,0));
        appointment_tab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        appointment_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointment_tabMouseClicked(evt);
            }
        });

        label_appointments_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_appointments_tab.setText("Appointments");

        icon_appointment.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/appointmenticon.png"))); // NOI18N
        icon_appointment.setPreferredSize(new java.awt.Dimension(14, 18));

        javax.swing.GroupLayout appointment_tabLayout = new javax.swing.GroupLayout(appointment_tab);
        appointment_tab.setLayout(appointment_tabLayout);
        appointment_tabLayout.setHorizontalGroup(
            appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(appointment_tabLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(icon_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_appointments_tab)
                .addContainerGap(161, Short.MAX_VALUE))
        );
        appointment_tabLayout.setVerticalGroup(
            appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, appointment_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(appointment_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_appointment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_appointments_tab))
                .addGap(83, 83, 83))
        );

        getContentPane().add(appointment_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 325, 300, 40));

        exit_tab.setBackground(new java.awt.Color(0,0,0,0));
        exit_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_tabMouseClicked(evt);
            }
        });

        label_exit_tab.setFont(new java.awt.Font("Lato", 1, 14)); // NOI18N
        label_exit_tab.setText("Exit");

        icon_exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/exiticon.png"))); // NOI18N

        javax.swing.GroupLayout exit_tabLayout = new javax.swing.GroupLayout(exit_tab);
        exit_tab.setLayout(exit_tabLayout);
        exit_tabLayout.setHorizontalGroup(
            exit_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exit_tabLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(icon_exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(label_exit_tab)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        exit_tabLayout.setVerticalGroup(
            exit_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, exit_tabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(exit_tabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(icon_exit)
                    .addComponent(label_exit_tab))
                .addGap(83, 83, 83))
        );

        getContentPane().add(exit_tab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 300, 40));

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

        patients_active.setBackground(new java.awt.Color(51, 108, 251));
        patients_active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patients_activeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout patients_activeLayout = new javax.swing.GroupLayout(patients_active);
        patients_active.setLayout(patients_activeLayout);
        patients_activeLayout.setHorizontalGroup(
            patients_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        patients_activeLayout.setVerticalGroup(
            patients_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(patients_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 175, 301, 40));

        employees_active.setBackground(new java.awt.Color(51, 108, 251));
        employees_active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employees_activeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout employees_activeLayout = new javax.swing.GroupLayout(employees_active);
        employees_active.setLayout(employees_activeLayout);
        employees_activeLayout.setHorizontalGroup(
            employees_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        employees_activeLayout.setVerticalGroup(
            employees_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(employees_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 225, 301, 40));

        illness_active.setBackground(new java.awt.Color(51, 108, 251));
        illness_active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                illness_activeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout illness_activeLayout = new javax.swing.GroupLayout(illness_active);
        illness_active.setLayout(illness_activeLayout);
        illness_activeLayout.setHorizontalGroup(
            illness_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        illness_activeLayout.setVerticalGroup(
            illness_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(illness_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 301, 40));

        appointments_active.setBackground(new java.awt.Color(51, 108, 251));
        appointments_active.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                appointments_activeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout appointments_activeLayout = new javax.swing.GroupLayout(appointments_active);
        appointments_active.setLayout(appointments_activeLayout);
        appointments_activeLayout.setHorizontalGroup(
            appointments_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 301, Short.MAX_VALUE)
        );
        appointments_activeLayout.setVerticalGroup(
            appointments_activeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        getContentPane().add(appointments_active, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 301, 40));

        SIDE_TAB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/TEST4.png"))); // NOI18N
        SIDE_TAB.setLabelFor(SIDE_TAB);
        getContentPane().add(SIDE_TAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 770));

        overview_panel.setPreferredSize(new java.awt.Dimension(927, 768));

        overview_panel_main.setPreferredSize(new java.awt.Dimension(925, 1800));
        overview_panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointments_total.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        appointments_total.setForeground(new java.awt.Color(51, 108, 251));
        appointments_total.setText("jLabel3");
        overview_panel_main.add(appointments_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(135, 155, -1, -1));

        patients_total.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        patients_total.setForeground(new java.awt.Color(51, 108, 251));
        patients_total.setText("jLabel3");
        overview_panel_main.add(patients_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 155, -1, -1));

        employees_total.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        employees_total.setForeground(new java.awt.Color(51, 108, 251));
        employees_total.setText("jLabel3");
        overview_panel_main.add(employees_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 155, -1, -1));

        illness_total.setFont(new java.awt.Font("Lato", 0, 20)); // NOI18N
        illness_total.setForeground(new java.awt.Color(51, 108, 251));
        illness_total.setText("jLabel3");
        overview_panel_main.add(illness_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1215, 155, -1, -1));

        appointment_table_pane.setBorder(null);

        appointment_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Semester", "Student No", "Illness", "Attending Physician", "Prepared By", "Date Consulted", "Diagnosis"
            }
        ));
        appointment_table.setSelectionBackground(new java.awt.Color(50, 107, 251));
        appointment_table_pane.setViewportView(appointment_table);

        overview_panel_main.add(appointment_table_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, 1390, 300));

        student_table_pane.setBorder(null);

        student_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        student_table_pane.setViewportView(student_table);

        overview_panel_main.add(student_table_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 645, 1390, 300));

        employee_table_pane.setBorder(null);

        employee_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        employee_table.setPreferredSize(new java.awt.Dimension(300, 1000));
        employee_table_pane.setViewportView(employee_table);

        overview_panel_main.add(employee_table_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1020, 1390, 300));

        illness_table_pane.setBorder(null);

        illness_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        illness_table.setPreferredSize(new java.awt.Dimension(300, 1000));
        illness_table_pane.setViewportView(illness_table);

        overview_panel_main.add(illness_table_pane, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 1400, 1390, 300));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/ADMIN-PAGE-OVERVIEW-LAYOUT5.png"))); // NOI18N
        overview_panel_main.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        overview_panel.setViewportView(overview_panel_main);

        getContentPane().add(overview_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, -5, 1500, -1));

        patient_panel.setPreferredSize(new java.awt.Dimension(927, 768));

        patient_panel_main.setPreferredSize(new java.awt.Dimension(925, 1400));
        patient_panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        student_course_list_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        student_course_list_cb.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        patient_panel_main.add(student_course_list_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 600, 41));

        student_discard_btn.setOpaque(false);
        student_discard_btn.setContentAreaFilled(false); //to make the content area transparent
        student_discard_btn.setBorderPainted(false);
        student_discard_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_discard_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_discard_btnActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_discard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 80, 40));

        student_edit_save_btn.setOpaque(false);
        student_edit_save_btn.setContentAreaFilled(false); //to make the content area transparent
        student_edit_save_btn.setBorderPainted(false);
        student_edit_save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_edit_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_edit_save_btnActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_edit_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 40));

        student_add_save_btn.setOpaque(false);
        student_add_save_btn.setContentAreaFilled(false); //to make the content area transparent
        student_add_save_btn.setBorderPainted(false);
        student_add_save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_add_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_add_save_btnActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_add_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 40));

        save_btn_student_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/save_btn_student.png"))); // NOI18N
        patient_panel_main.add(save_btn_student_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, 40));

        discard_btn_student_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/discard_btn_student.png"))); // NOI18N
        patient_panel_main.add(discard_btn_student_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(965, 30, -1, 40));

        student_cmd_add.setOpaque(false);
        student_cmd_add.setContentAreaFilled(false); //to make the content area transparent
        student_cmd_add.setBorderPainted(false);
        student_cmd_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_cmd_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_cmd_addActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_cmd_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 120, 40));

        student_cmd_edit.setOpaque(false);
        student_cmd_edit.setContentAreaFilled(false); //to make the content area transparent
        student_cmd_edit.setBorderPainted(false);
        student_cmd_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_cmd_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_cmd_editActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_cmd_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 120, 40));

        student_cmd_delete.setOpaque(false);
        student_cmd_delete.setContentAreaFilled(false); //to make the content area transparent
        student_cmd_delete.setBorderPainted(false);
        student_cmd_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        student_cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_cmd_deleteActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_cmd_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 130, 40));

        add_btn_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn1_add.png"))); // NOI18N
        patient_panel_main.add(add_btn_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        edit_btn_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn2_edit.png"))); // NOI18N
        patient_panel_main.add(edit_btn_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        delete_btn_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn3_delete.png"))); // NOI18N
        patient_panel_main.add(delete_btn_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        student_status_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        student_status_cb.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_status_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        patient_panel_main.add(student_status_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1274, 220, 166, 40));

        student_gender_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        student_gender_cb.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_gender_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        patient_panel_main.add(student_gender_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 220, 100, 40));

        student_firstname_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_firstname_fld.setBorder(null);
        student_firstname_fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_firstname_fldActionPerformed(evt);
            }
        });
        patient_panel_main.add(student_firstname_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 270, -1));

        student_lastname_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_lastname_fld.setBorder(null);
        patient_panel_main.add(student_lastname_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 260, -1));

        student_email_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_email_fld.setBorder(null);
        patient_panel_main.add(student_email_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 750, -1));

        student_address_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_address_fld.setBorder(null);
        patient_panel_main.add(student_address_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 570, -1));

        student_cp_no_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_cp_no_fld.setBorder(null);
        student_cp_no_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_cp_no_fldKeyTyped(evt);
            }
        });
        patient_panel_main.add(student_cp_no_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 260, -1));

        student_birthdate_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_birthdate_fld.setBorder(null);
        patient_panel_main.add(student_birthdate_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 230, 160, -1));

        student_gender_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_gender_fld.setBorder(null);
        patient_panel_main.add(student_gender_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 230, 70, -1));

        student_status_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_status_fld.setBorder(null);
        patient_panel_main.add(student_status_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 230, 140, -1));

        student_course_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_course_fld.setBorder(null);
        patient_panel_main.add(student_course_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 312, 570, -1));

        student_college_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_college_fld.setBorder(null);
        patient_panel_main.add(student_college_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 312, 570, -1));

        student_no_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_no_fld.setBorder(null);
        student_no_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_no_fldKeyTyped(evt);
            }
        });
        patient_panel_main.add(student_no_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 312, 150, -1));

        student_table_pane1.setBorder(null);

        student_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        student_table1.setPreferredSize(new java.awt.Dimension(300, 2000));
        student_table_pane1.setViewportView(student_table1);

        patient_panel_main.add(student_table_pane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 1390, 900));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/ADMIN-PAGE-PATIENT-LAYOUT.png"))); // NOI18N
        patient_panel_main.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        student_no_fld1.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        student_no_fld1.setBorder(null);
        student_no_fld1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                student_no_fld1KeyTyped(evt);
            }
        });
        patient_panel_main.add(student_no_fld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 312, 150, -1));

        patient_panel.setViewportView(patient_panel_main);

        getContentPane().add(patient_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, -5, 1500, -1));

        employees_panel.setPreferredSize(new java.awt.Dimension(927, 768));

        employee_panel_main.setPreferredSize(new java.awt.Dimension(925, 1400));
        employee_panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        employee_discard_btn.setOpaque(false);
        employee_discard_btn.setContentAreaFilled(false); //to make the content area transparent
        employee_discard_btn.setBorderPainted(false);
        employee_discard_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_discard_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_discard_btnActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_discard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 80, 40));

        employee_edit_save_btn.setOpaque(false);
        employee_edit_save_btn.setContentAreaFilled(false); //to make the content area transparent
        employee_edit_save_btn.setBorderPainted(false);
        employee_edit_save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_edit_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_edit_save_btnActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_edit_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 40));

        employee_add_save_btn.setOpaque(false);
        employee_add_save_btn.setContentAreaFilled(false); //to make the content area transparent
        employee_add_save_btn.setBorderPainted(false);
        employee_add_save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_add_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_add_save_btnActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_add_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 40));

        save_btn_employee_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/save_btn_student.png"))); // NOI18N
        employee_panel_main.add(save_btn_employee_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, 40));

        discard_btn_employee_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/discard_btn_student.png"))); // NOI18N
        employee_panel_main.add(discard_btn_employee_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(965, 30, -1, 40));

        employee_cmd_add.setOpaque(false);
        employee_cmd_add.setContentAreaFilled(false); //to make the content area transparent
        employee_cmd_add.setBorderPainted(false);
        employee_cmd_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_cmd_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_cmd_addActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_cmd_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 120, 40));

        employee_cmd_edit.setOpaque(false);
        employee_cmd_edit.setContentAreaFilled(false); //to make the content area transparent
        employee_cmd_edit.setBorderPainted(false);
        employee_cmd_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_cmd_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_cmd_editActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_cmd_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 120, 40));

        employee_cmd_delete.setOpaque(false);
        employee_cmd_delete.setContentAreaFilled(false); //to make the content area transparent
        employee_cmd_delete.setBorderPainted(false);
        employee_cmd_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        employee_cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_cmd_deleteActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_cmd_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 130, 40));

        add_btn_lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn1_add.png"))); // NOI18N
        employee_panel_main.add(add_btn_lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        edit_btn_lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn2_edit.png"))); // NOI18N
        employee_panel_main.add(edit_btn_lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        delete_btn_lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn3_delete.png"))); // NOI18N
        employee_panel_main.add(delete_btn_lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        employee_status_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        employee_status_cb.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_status_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        employee_panel_main.add(employee_status_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1274, 220, 166, 40));

        employee_gender_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        employee_gender_cb.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_gender_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        employee_panel_main.add(employee_gender_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 220, 100, 40));

        employee_firstname_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_firstname_fld.setBorder(null);
        employee_firstname_fld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                employee_firstname_fldActionPerformed(evt);
            }
        });
        employee_panel_main.add(employee_firstname_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 270, -1));

        employee_lastname_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_lastname_fld.setBorder(null);
        employee_panel_main.add(employee_lastname_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 260, -1));

        employee_email_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_email_fld.setBorder(null);
        employee_panel_main.add(employee_email_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 150, 560, -1));

        employee_address_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_address_fld.setBorder(null);
        employee_panel_main.add(employee_address_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 570, -1));

        employee_cp_no_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_cp_no_fld.setBorder(null);
        employee_cp_no_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employee_cp_no_fldKeyTyped(evt);
            }
        });
        employee_panel_main.add(employee_cp_no_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 260, -1));

        employee_birthdate_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_birthdate_fld.setBorder(null);
        employee_panel_main.add(employee_birthdate_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 230, 160, -1));

        employee_gender_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_gender_fld.setBorder(null);
        employee_panel_main.add(employee_gender_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1175, 230, 70, -1));

        employee_status_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_status_fld.setBorder(null);
        employee_panel_main.add(employee_status_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 230, 140, -1));

        employee_no_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_no_fld.setBorder(null);
        employee_no_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employee_no_fldKeyTyped(evt);
            }
        });
        employee_panel_main.add(employee_no_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 150, 150, -1));

        employee_table_pane1.setBorder(null);

        employee_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        employee_table1.setPreferredSize(new java.awt.Dimension(300, 1000));
        employee_table_pane1.setViewportView(employee_table1);

        employee_panel_main.add(employee_table_pane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 1390, 980));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/ADMIN-PAGE-EMPLOYEE-LAYOUT.png"))); // NOI18N
        employee_panel_main.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        employee_no_fld1.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        employee_no_fld1.setBorder(null);
        employee_no_fld1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                employee_no_fld1KeyTyped(evt);
            }
        });
        employee_panel_main.add(employee_no_fld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1285, 150, 150, -1));

        employees_panel.setViewportView(employee_panel_main);

        getContentPane().add(employees_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, -5, 1500, -1));

        illness_panel.setPreferredSize(new java.awt.Dimension(927, 768));

        illness_panel_main.setPreferredSize(new java.awt.Dimension(925, 1400));
        illness_panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        illness_discard_btn.setOpaque(false);
        illness_discard_btn.setContentAreaFilled(false); //to make the content area transparent
        illness_discard_btn.setBorderPainted(false);
        illness_discard_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_discard_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illness_discard_btnActionPerformed(evt);
            }
        });
        illness_panel_main.add(illness_discard_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, 80, 40));

        illness_add_save_btn.setOpaque(false);
        illness_add_save_btn.setContentAreaFilled(false); //to make the content area transparent
        illness_add_save_btn.setBorderPainted(false);
        illness_add_save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_add_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illness_add_save_btnActionPerformed(evt);
            }
        });
        illness_panel_main.add(illness_add_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 40));

        illness_edit_save_btn.setOpaque(false);
        illness_edit_save_btn.setContentAreaFilled(false); //to make the content area transparent
        illness_edit_save_btn.setBorderPainted(false);
        illness_edit_save_btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_edit_save_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illness_edit_save_btnActionPerformed(evt);
            }
        });
        illness_panel_main.add(illness_edit_save_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, 90, 40));

        save_btn_illness_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/save_btn_student.png"))); // NOI18N
        illness_panel_main.add(save_btn_illness_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 30, -1, 40));

        discard_btn_illness_lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/discard_btn_student.png"))); // NOI18N
        illness_panel_main.add(discard_btn_illness_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(965, 30, -1, 40));

        illness_cmd_add.setOpaque(false);
        illness_cmd_add.setContentAreaFilled(false); //to make the content area transparent
        illness_cmd_add.setBorderPainted(false);
        illness_cmd_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_cmd_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illness_cmd_addActionPerformed(evt);
            }
        });
        illness_panel_main.add(illness_cmd_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 120, 40));

        illness_cmd_edit.setOpaque(false);
        illness_cmd_edit.setContentAreaFilled(false); //to make the content area transparent
        illness_cmd_edit.setBorderPainted(false);
        illness_cmd_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_cmd_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illness_cmd_editActionPerformed(evt);
            }
        });
        illness_panel_main.add(illness_cmd_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 120, 40));

        illness_cmd_delete.setOpaque(false);
        illness_cmd_delete.setContentAreaFilled(false); //to make the content area transparent
        illness_cmd_delete.setBorderPainted(false);
        illness_cmd_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        illness_cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                illness_cmd_deleteActionPerformed(evt);
            }
        });
        illness_panel_main.add(illness_cmd_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, 130, 40));

        add_btn_lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn1_add.png"))); // NOI18N
        illness_panel_main.add(add_btn_lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        edit_btn_lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn2_edit.png"))); // NOI18N
        illness_panel_main.add(edit_btn_lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, -1, -1));

        delete_btn_lbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/btn3_delete.png"))); // NOI18N
        illness_panel_main.add(delete_btn_lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        illness_status_cb.setBackground(new Color(255, 255, 255, 128)); // Set alpha for transparency
        illness_status_cb.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        illness_status_cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Inactive" }));
        illness_panel_main.add(illness_status_cb, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 140, 170, 40));

        illness_status_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        illness_status_fld.setBorder(null);
        illness_panel_main.add(illness_status_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 150, 140, -1));

        illness_code_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        illness_code_fld.setBorder(null);
        illness_code_fld.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                illness_code_fldKeyTyped(evt);
            }
        });
        illness_panel_main.add(illness_code_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 270, -1));

        illness_description_fld.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        illness_description_fld.setBorder(null);
        illness_panel_main.add(illness_description_fld, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 860, -1));

        illness_table_pane1.setBorder(null);

        illness_table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        illness_table1.setPreferredSize(new java.awt.Dimension(300, 1000));
        illness_table_pane1.setViewportView(illness_table1);

        illness_panel_main.add(illness_table_pane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 1390, 1060));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainAPP/assets/ADMIN-PAGE-ILLNESS-LAYOUT.png"))); // NOI18N
        illness_panel_main.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        illness_code_fld1.setFont(new java.awt.Font("Lato", 0, 16)); // NOI18N
        illness_code_fld1.setBorder(null);
        illness_code_fld1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                illness_code_fld1KeyTyped(evt);
            }
        });
        illness_panel_main.add(illness_code_fld1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 270, -1));

        illness_panel.setViewportView(illness_panel_main);

        getContentPane().add(illness_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, -5, 1500, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void overview_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overview_tabMouseClicked
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing !\nPlease save or discard your changes.", "", JOptionPane.ERROR_MESSAGE);
    } else {
        label_overview_tab.setForeground(Color.WHITE);
        label_patients_tab.setForeground(Color.BLACK);
        label_employees_tab.setForeground(Color.BLACK);
        label_illness_tab.setForeground(Color.BLACK);
        label_appointments_tab.setForeground(Color.BLACK);
        overview_panel.setVisible(true);
        patient_panel.setVisible(false);
        employees_panel.setVisible(false);
        illness_panel.setVisible(false);  
//      appointments_panel.setVisible(false);
        overview_active.setVisible(true);
        patients_active.setVisible(false);
        employees_active.setVisible(false);
        illness_active.setVisible(false);
        appointments_active.setVisible(false);
        }
    }//GEN-LAST:event_overview_tabMouseClicked

    private void students_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_students_tabMouseClicked
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing !\nPlease save or discard your changes.", "", JOptionPane.ERROR_MESSAGE);
    } else {
        label_patients_tab.setForeground(Color.WHITE);
        label_overview_tab.setForeground(Color.BLACK);
        label_employees_tab.setForeground(Color.BLACK);
        label_illness_tab.setForeground(Color.BLACK);
        label_appointments_tab.setForeground(Color.BLACK);
        patient_panel.setVisible(true);
        overview_panel.setVisible(false);
        employees_panel.setVisible(false);
        illness_panel.setVisible(false);  
//      appointments_panel.setVisible(false);  
        patients_active.setVisible(true);
        overview_active.setVisible(false);
        employees_active.setVisible(false);
        illness_active.setVisible(false);
        appointments_active.setVisible(false);
    }
    }//GEN-LAST:event_students_tabMouseClicked

    private void employees_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employees_tabMouseClicked
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing !\nPlease save or discard your changes.", "", JOptionPane.ERROR_MESSAGE);
    } else {
        label_employees_tab.setForeground(Color.WHITE);
        label_patients_tab.setForeground(Color.BLACK);
        label_overview_tab.setForeground(Color.BLACK);
        label_illness_tab.setForeground(Color.BLACK);
        label_appointments_tab.setForeground(Color.BLACK);
        employees_panel.setVisible(true);
        overview_panel.setVisible(false);
        patient_panel.setVisible(false);
        illness_panel.setVisible(false);  
//      appointments_panel.setVisible(false);        
        employees_active.setVisible(true);
        patients_active.setVisible(false);
        overview_active.setVisible(false);
        illness_active.setVisible(false);
        appointments_active.setVisible(false);
    }
    }//GEN-LAST:event_employees_tabMouseClicked

    private void illness_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_illness_tabMouseClicked
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing !\nPlease save or discard your changes.", "", JOptionPane.ERROR_MESSAGE);
    } else {
        label_illness_tab.setForeground(Color.WHITE);
        label_patients_tab.setForeground(Color.BLACK);
        label_employees_tab.setForeground(Color.BLACK);
        label_overview_tab.setForeground(Color.BLACK);
        label_appointments_tab.setForeground(Color.BLACK);
//        appointments_panel.setVisible(true);
        overview_panel.setVisible(false);
        patient_panel.setVisible(false);
        employees_panel.setVisible(false);
        illness_panel.setVisible(true);
        illness_active.setVisible(true);
        patients_active.setVisible(false);
        overview_active.setVisible(false);
        employees_active.setVisible(false);
        appointments_active.setVisible(false);
    }
    }//GEN-LAST:event_illness_tabMouseClicked

    private void overview_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_overview_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_overview_activeMouseClicked

    private void patients_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patients_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_patients_activeMouseClicked

    private void employees_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employees_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_employees_activeMouseClicked

    private void illness_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_illness_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_illness_activeMouseClicked

    private void exit_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_tabMouseClicked
        Main_FRAME.this.setVisible(false);
        new Login_FRAME().setVisible(true);
    }//GEN-LAST:event_exit_tabMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        fetchDataAndPopulateTable("SELECT * FROM STUDENTVIEW", student_table,
                new String[]{"Student No", "First Name", "Last Name", "Email", "Address", "Birthday", "Status", "Contact Number", "Gender", "Course", "College"},
                new String[]{"student_no", "firstname", "lastname", "email", "address", "birthdate", "status", "contact_num", "gender", "course_description", "college"});

        fetchDataAndPopulateTable("SELECT * FROM STUDENTVIEW", student_table1,
                new String[]{"Student No", "First Name", "Last Name", "Email", "Address", "Birthday", "Status", "Contact Number", "Gender", "Course", "College"},
                new String[]{"student_no", "firstname", "lastname", "email", "address", "birthdate", "status", "contact_num", "gender", "course_description", "college"});
        
        fetchDataAndPopulateTable("SELECT * FROM CONSULTATIONVIEW", appointment_table,
                new String[]{"School Year", "Semester", "Student No", "Patient Name", "Illness", "Attending Physician", "Prepared By", "Date Consulted", "Diagnosis"},
                new String[]{"sy", "semester", "student_no", "student_fullname", "illness_description", "attending_physician_fullname", "prepared_by_fullname", "date_consulted", "diagnosis"});

        fetchDataAndPopulateTable("SELECT * FROM DT_EMPLOYEE", employee_table,
                new String[]{"Employee ID", "Last Name", "First Name", "Email", "Gender", "Cellphone No.", "Address", "Birthdate", "Status"},
                new String[]{"employee_id", "lastname", "firstname", "email", "gender", "cp_num", "address", "bday", "status"});

        fetchDataAndPopulateTable("SELECT * FROM DT_EMPLOYEE", employee_table1,
                new String[]{"Employee ID", "Last Name", "First Name", "Email", "Gender", "Cellphone No.", "Address", "Birthdate", "Status"},
                new String[]{"employee_id", "lastname", "firstname", "email", "gender", "cp_num", "address", "bday", "status"});        

        fetchDataAndPopulateTable("SELECT * FROM DT_ILLNESS", illness_table,
                new String[]{"Code", "Illness", "Status"},
                new String[]{"illness_code", "description", "status"});
        
        fetchDataAndPopulateTable("SELECT * FROM DT_ILLNESS", illness_table1,
                new String[]{"Code", "Illness", "Status"},
                new String[]{"illness_code", "description", "status"});       

            populateComboBoxFromDatabase(student_course_list_cb, "course_description", "COURSECOLLEGEVIEW");
        
            
        // Set the row counts in your JLabels
        patients_total.setText(Integer.toString(getRowCount("SELECT * FROM STUDENTVIEW")));
        appointments_total.setText(Integer.toString(getRowCount("SELECT * FROM FT_CONSULTATION")));
        employees_total.setText(Integer.toString(getRowCount("SELECT * FROM DT_EMPLOYEE")));
        illness_total.setText(Integer.toString(getRowCount("SELECT * FROM DT_ILLNESS")));
    }//GEN-LAST:event_formWindowActivated

    private void student_firstname_fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_firstname_fldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_firstname_fldActionPerformed

    private void student_cmd_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_cmd_addActionPerformed
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing !", "", JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "You can now input details in each field !", "", JOptionPane.WARNING_MESSAGE);
        resetAllTextFields();
        student_table1.setEnabled(false);
        textFieldEditTrue();    
        showComboBox();
        student_status_fld.setEditable(true);
        save_btn_student_lbl.setVisible(true);
        discard_btn_student_lbl.setVisible(true);
        student_bday_chooser.setVisible(true);
        student_add_save_btn.setVisible(true);
        student_discard_btn.setVisible(true);
        student_edit_save_btn.setVisible(false);
        isEditing = true;
    }
    }//GEN-LAST:event_student_cmd_addActionPerformed

    private void student_discard_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_discard_btnActionPerformed
        JOptionPane.showMessageDialog(this, "No changes were saved !", "", JOptionPane.WARNING_MESSAGE);
        student_table1.setEnabled(true);

        hideSaveAndDiscardButtons();
        
        student_bday_chooser.setVisible(false);

        resetAllTextFields();
        
        textFieldEditFalse();

        hideComboBoxes();
        
        resetEditingState();
        
    }//GEN-LAST:event_student_discard_btnActionPerformed

    private void student_cmd_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_cmd_editActionPerformed
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are already editing", "", JOptionPane.ERROR_MESSAGE);
    } else if (!student_no_fld.getText().isEmpty()) {
            student_no_fld.setEditable(false);
        JOptionPane.showMessageDialog(this, "You can now edit the fields!", "", JOptionPane.WARNING_MESSAGE);
        setBirthdateFromTextField(student_birthdate_fld, student_bday_chooser);
        student_table1.setEnabled(false);
        textFieldEditTrue();    
//        student_no_fld.setEditable(false);
//        student_no_fld.setForeground(Color.red);
        showComboBox();
        student_bday_chooser.setVisible(true);
        save_btn_student_lbl.setVisible(true);
        discard_btn_student_lbl.setVisible(true);
        student_add_save_btn.setVisible(false);
        student_discard_btn.setVisible(true);
        student_edit_save_btn.setVisible(true);        
        isEditing = true;
    } else {
        JOptionPane.showMessageDialog(this, "Please select a student first !", "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_student_cmd_editActionPerformed

    private void employee_discard_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_discard_btnActionPerformed
        JOptionPane.showMessageDialog(this, "No changes were saved !", "", JOptionPane.WARNING_MESSAGE);
        employee_table1.setEnabled(true);

        hideSaveAndDiscardButtons();
        
        textFieldEditFalse();

        resetAllTextFields();
        
        hideComboBoxes();    
        
        resetEditingState();
    }//GEN-LAST:event_employee_discard_btnActionPerformed

    private void employee_cmd_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_cmd_addActionPerformed
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are already editing !", "", JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "You can now input details in each field !", "", JOptionPane.WARNING_MESSAGE);
        
        employee_bday_chooser.setVisible(true);
        
        employee_add_save_btn.setVisible(true);
        employee_edit_save_btn.setVisible(false);
        
        employee_table1.setEnabled(false);
        
        resetAllTextFields();
        textFieldEditTrue();  
        employee_no_fld.setEditable(true);
        showComboBox();   

        save_btn_employee_lbl.setVisible(true);
        employee_discard_btn.setVisible(true);
        discard_btn_employee_lbl.setVisible(true);
        isEditing = true;
    }
    }//GEN-LAST:event_employee_cmd_addActionPerformed

    private void employee_cmd_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_cmd_editActionPerformed
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are already editing", "", JOptionPane.ERROR_MESSAGE);
    } else if (!employee_no_fld.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "You can now edit the fields!\n", "", JOptionPane.WARNING_MESSAGE);

        setBirthdateFromTextField(employee_birthdate_fld, employee_bday_chooser);
        employee_bday_chooser.setVisible(true);
        
        employee_add_save_btn.setVisible(false);
        employee_edit_save_btn.setVisible(true);

        employee_no_fld.setForeground(Color.red);
        
        employee_table1.setEnabled(false);
        
        textFieldEditTrue();    
        employee_no_fld.setEditable(true);
        showComboBox();      
        
        save_btn_employee_lbl.setVisible(true);
        employee_discard_btn.setVisible(true);
        discard_btn_employee_lbl.setVisible(true);
        
        isEditing = true;
    } else {
        JOptionPane.showMessageDialog(this, "Please select an employee first !", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_employee_cmd_editActionPerformed

    private void employee_firstname_fldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_firstname_fldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_firstname_fldActionPerformed

    private void student_add_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_add_save_btnActionPerformed
        try {   
            addToDatabase_Student();
        } catch (ParseException ex) {
            Logger.getLogger(Main_FRAME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_student_add_save_btnActionPerformed

    private void employee_cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_cmd_deleteActionPerformed
    if (isEditing) {
        // Inform the user about the editing state
        JOptionPane.showMessageDialog(this, "You are currently in editing state. Please save or cancel your changes before deleting a student.", "Editing State", JOptionPane.WARNING_MESSAGE);
        return;  // Exit the method without further processing
    }
        
    // Get the selected row index
    int selectedRowIndex = employee_table1.getSelectedRow();

    if (selectedRowIndex >= 0) { // Check if a row is selected
        try {
            // Get the data from the selected row
            // Assuming you have a DefaultTableModel, modify this accordingly
            DefaultTableModel model = (DefaultTableModel) employee_table1.getModel();
            // Assuming your first column is the primary key in the database
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);

            // Check if the primary key is used as a foreign key in other tables
            if (!isForeignKeyInUse(primaryKey)) {
                // Remove the row from the JTable
                model.removeRow(selectedRowIndex);

                // Delete the corresponding record from the database
                String deleteQuery = "DELETE FROM DT_EMPLOYEE WHERE employee_id = ?";
                try (PreparedStatement pstmt = con.prepareStatement(deleteQuery)) {
                    pstmt.setString(1, primaryKey);
                    pstmt.executeUpdate();
                JOptionPane.showMessageDialog(this, "Employee " + primaryKey + " was successfully deleted.", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);
                resetAllTextFields();

                }
            } else {
                // Inform the user that the key is used in other tables
                JOptionPane.showMessageDialog(this, "Cannot delete. The employee has an active appointment.", "Foreign Key Constraint", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            // Handle any SQL exception here
            ex.printStackTrace();
        }
    } else {
        // Inform the user to select a row before clicking delete
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    }
    
    
}

    private boolean isForeignKeyInUse(String primaryKey) throws SQLException {
        // Check if the primary key is used as a foreign key in other tables
        String checkForeignKeyQuery = "SELECT COUNT(*) FROM CONSULTATIONVIEW WHERE attending_physician_id = ? OR prepared_by_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(checkForeignKeyQuery)) {
            pstmt.setString(1, primaryKey);
            pstmt.setString(2, primaryKey);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            }
        }
        return false;        // TODO add your handling code here:
    }//GEN-LAST:event_employee_cmd_deleteActionPerformed

    private void appointment_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointment_tabMouseClicked
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing !\nPlease save or discard your changes.", "", JOptionPane.ERROR_MESSAGE);
    } else {
        label_appointments_tab.setForeground(Color.WHITE);
        label_patients_tab.setForeground(Color.BLACK);
        label_employees_tab.setForeground(Color.BLACK);
        label_overview_tab.setForeground(Color.BLACK);
        label_illness_tab.setForeground(Color.BLACK);
//        appointments_panel.setVisible(true);
        overview_panel.setVisible(false);
        patient_panel.setVisible(false);
        employees_panel.setVisible(false);
        illness_panel.setVisible(false);
        appointments_active.setVisible(true);
        patients_active.setVisible(false);
        overview_active.setVisible(false);
        employees_active.setVisible(false);
        illness_active.setVisible(false);        // TODO add your handling code here:
    }
    }//GEN-LAST:event_appointment_tabMouseClicked

    private void appointments_activeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointments_activeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_appointments_activeMouseClicked

    private void illness_discard_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illness_discard_btnActionPerformed
        JOptionPane.showMessageDialog(this, "No changes were saved !", "", JOptionPane.WARNING_MESSAGE);
        illness_table1.setEnabled(true);

        save_btn_illness_lbl.setVisible(false);
        discard_btn_illness_lbl.setVisible(false);
        illness_add_save_btn.setVisible(false);
        illness_edit_save_btn.setVisible(false);        
        illness_discard_btn.setVisible(false);
        
        illness_code_fld.setEditable(false);
        illness_description_fld.setEditable(false);
        illness_status_fld.setEditable(false);
        illness_status_cb.setEditable(false);

        illness_code_fld.setText("");
        illness_description_fld.setText("");
        illness_status_fld.setText("");
        
        illness_status_cb.setVisible(false);
        
        resetEditingState();
    }//GEN-LAST:event_illness_discard_btnActionPerformed

    private void illness_cmd_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illness_cmd_addActionPerformed
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are already editing !", "", JOptionPane.ERROR_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "You can now input details in each field !", "", JOptionPane.WARNING_MESSAGE);
        illness_table1.setEnabled(false);
        illness_code_fld.setText("");
        illness_description_fld.setText("");
        illness_status_fld.setText("");
        illness_status_cb.setVisible(true);
        illness_code_fld.setEditable(true);
        illness_description_fld.setEditable(true);
        
        illness_add_save_btn.setVisible(true);
        illness_discard_btn.setVisible(true);
        illness_edit_save_btn.setVisible(false);

        save_btn_illness_lbl.setVisible(true);
        discard_btn_illness_lbl.setVisible(true);
        isEditing = true;
    }
    }//GEN-LAST:event_illness_cmd_addActionPerformed

    private void illness_cmd_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illness_cmd_editActionPerformed
    if (isEditing) {
        JOptionPane.showMessageDialog(this, "You are currently editing!", "", JOptionPane.ERROR_MESSAGE);
    } else if (!illness_code_fld.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "You can now edit the fields!", "", JOptionPane.WARNING_MESSAGE);
        illness_table1.setEnabled(false);
        illness_code_fld.setEditable(true);
        illness_description_fld.setEditable(true);
        illness_status_cb.setVisible(true);
        illness_add_save_btn.setVisible(false);
        illness_discard_btn.setVisible(true);
        illness_edit_save_btn.setVisible(true);
        save_btn_illness_lbl.setVisible(true);
        discard_btn_illness_lbl.setVisible(true);
        isEditing = true;
    } else {
        JOptionPane.showMessageDialog(this, "Please select an illness first !", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_illness_cmd_editActionPerformed

    private void illness_cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illness_cmd_deleteActionPerformed
    if (isEditing) {
        // Inform the user about the editing state
        JOptionPane.showMessageDialog(this, "You are currently in editing state. Please save or cancel your changes before deleting a student.", "Editing State", JOptionPane.WARNING_MESSAGE);
        return;  // Exit the method without further processing
    }
        
    // Get the selected row index    
    int selectedRowIndex = illness_table1.getSelectedRow();

    if (selectedRowIndex >= 0) { // Check if a row is selected
        try {
            // Get the data from the selected row
            // Assuming you have a DefaultTableModel, modify this accordingly
            DefaultTableModel model = (DefaultTableModel) illness_table1.getModel();
            // Assuming your first column is the primary key in the database
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);

            // Check if the primary key is used as a foreign key in other tables
            if (!isForeignKeyInUseIllness(primaryKey)) {
                // Get the student number before removing the row from the JTable
                String illnessCode = (String) model.getValueAt(selectedRowIndex, 0);

                // Remove the row from the JTable
                model.removeRow(selectedRowIndex);

                // Delete the corresponding record from the database
                String deleteQuery = "DELETE FROM DT_ILLNESS WHERE illness_code = ?";
                try (PreparedStatement pstmt = con.prepareStatement(deleteQuery)) {
                    pstmt.setString(1, primaryKey);
                    pstmt.executeUpdate();
                }
                
                JOptionPane.showMessageDialog(this, "Illness " + illnessCode + " was successfully deleted.", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Inform the user that the key is used in other tables
                JOptionPane.showMessageDialog(this, "Cannot delete. The illness is being used.", "Foreign Key Constraint", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            // Handle any SQL exception here
            ex.printStackTrace();
        }
    } else {
        // Inform the user to select a row before clicking delete
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    }
    
        resetAllTextFields();
    
}

private boolean isForeignKeyInUseIllness(String primaryKey) throws SQLException {
    // Check if the primary key is used as a foreign key in other tables
    String checkForeignKeyQuery = "SELECT COUNT(*) FROM CONSULTATIONVIEW WHERE illness_code = ?";
    try (PreparedStatement pstmt = con.prepareStatement(checkForeignKeyQuery)) {
        pstmt.setString(1, primaryKey);

        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }
    return false;
    }//GEN-LAST:event_illness_cmd_deleteActionPerformed

    private void student_cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_cmd_deleteActionPerformed
    if (isEditing) {
        // Inform the user about the editing state
        JOptionPane.showMessageDialog(this, "You are currently in editing state. Please save or cancel your changes before deleting a student.", "Editing State", JOptionPane.WARNING_MESSAGE);
        return;  // Exit the method without further processing
    }
        
    // Get the selected row index    
    int selectedRowIndex = student_table1.getSelectedRow();

    if (selectedRowIndex >= 0) { // Check if a row is selected
        try {
            // Get the data from the selected row
            // Assuming you have a DefaultTableModel, modify this accordingly
            DefaultTableModel model = (DefaultTableModel) student_table1.getModel();
            // Assuming your first column is the primary key in the database
            String primaryKey = (String) model.getValueAt(selectedRowIndex, 0);

            // Check if the primary key is used as a foreign key in other tables
            if (!isForeignKeyInUseStudent(primaryKey)) {
                // Get the student number before removing the row from the JTable
                String studentNumber = (String) model.getValueAt(selectedRowIndex, 0);

                // Remove the row from the JTable
                model.removeRow(selectedRowIndex);

                // Delete the corresponding record from the database
                String deleteQuery = "DELETE FROM DT_STUDENT WHERE student_no = ?";
                try (PreparedStatement pstmt = con.prepareStatement(deleteQuery)) {
                    pstmt.setString(1, primaryKey);
                    pstmt.executeUpdate();
                }
                
                JOptionPane.showMessageDialog(this, "Student " + studentNumber + " was successfully deleted.", "Delete Successful", JOptionPane.INFORMATION_MESSAGE);

            } else {
                // Inform the user that the key is used in other tables
                JOptionPane.showMessageDialog(this, "Cannot delete. The student is an active patient.", "Foreign Key Constraint", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            // Handle any SQL exception here
            ex.printStackTrace();
        }
    } else {
        // Inform the user to select a row before clicking delete
        JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
    }
    
        resetAllTextFields();
    
}

private boolean isForeignKeyInUseStudent(String primaryKey) throws SQLException {
    // Check if the primary key is used as a foreign key in other tables
    String checkForeignKeyQuery = "SELECT COUNT(*) FROM CONSULTATIONVIEW WHERE student_no = ?";
    try (PreparedStatement pstmt = con.prepareStatement(checkForeignKeyQuery)) {
        pstmt.setString(1, primaryKey);

        try (ResultSet resultSet = pstmt.executeQuery()) {
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        }
    }
    return false;

    }//GEN-LAST:event_student_cmd_deleteActionPerformed

    private void student_cp_no_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_cp_no_fldKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        
        // Check if the total number of digits is less than 10
        if (student_cp_no_fld.getText().length() >= 11) {
            evt.consume();
        }

        // Check if it's the first digit and it's not 0
        if (student_cp_no_fld.getText().isEmpty() && c != '0') {
            evt.consume();
        }
    }//GEN-LAST:event_student_cp_no_fldKeyTyped

    private void student_edit_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_edit_save_btnActionPerformed
    try {
        editDatabase_Student();
        student_no_fld.setForeground(Color.black);
    } catch (ParseException ex) {
        // Handle parsing exceptions if needed
        ex.printStackTrace();
    }
    }//GEN-LAST:event_student_edit_save_btnActionPerformed

    private void student_no_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_no_fldKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        
        // Check if the total number of digits is less than 10
        if (student_no_fld.getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_student_no_fldKeyTyped

    private void employee_cp_no_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_cp_no_fldKeyTyped
        char c = evt.getKeyChar();
        if(!Character.isDigit(c)){
            evt.consume();
        }
        
        // Check if the total number of digits is less than 10
        if (employee_cp_no_fld.getText().length() >= 11) {
            evt.consume();
        }

        // Check if it's the first digit and it's not 0
        if (employee_cp_no_fld.getText().isEmpty() && c != '0') {
            evt.consume();
        }
    }//GEN-LAST:event_employee_cp_no_fldKeyTyped

    private void employee_no_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_no_fldKeyTyped
        char c = evt.getKeyChar();

        // Check if the total number of digits is less than 4 (3 digits for numbers)
        if (employee_no_fld.getText().length() >= 4) {
            evt.consume();
        }

        // Check if it's the first character and it's not 'E'
        if (employee_no_fld.getText().isEmpty() && c != 'E') {
            evt.consume();
        }

        // Check if 'E' is entered and it's not the first character
        if (!employee_no_fld.getText().isEmpty() && c == 'E') {
            evt.consume();
        }

        // Allow only digits after 'E'
        if (!Character.isDigit(c) && !employee_no_fld.getText().isEmpty()) {
            evt.consume();
        }
    }//GEN-LAST:event_employee_no_fldKeyTyped

    private void student_no_fld1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_student_no_fld1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_student_no_fld1KeyTyped

    private void employee_add_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_add_save_btnActionPerformed
        try {   
            addToDatabase_Employee();
        } catch (ParseException ex) {
            Logger.getLogger(Main_FRAME.class.getName()).log(Level.SEVERE, null, ex);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_employee_add_save_btnActionPerformed

    private void employee_edit_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_employee_edit_save_btnActionPerformed
    try {
        editDatabase_Employee();
        employee_no_fld.setForeground(Color.black);
    } catch (ParseException ex) {
        // Handle parsing exceptions if needed
        ex.printStackTrace();
    }
    }//GEN-LAST:event_employee_edit_save_btnActionPerformed

    private void employee_no_fld1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_employee_no_fld1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_employee_no_fld1KeyTyped

    private void illness_add_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illness_add_save_btnActionPerformed
        try {   
            addToDatabase_Illness();
        } catch (ParseException ex) {
            Logger.getLogger(Main_FRAME.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_illness_add_save_btnActionPerformed

    private void illness_code_fldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_illness_code_fldKeyTyped
        // Check if the total number of digits is less than 10
        if (illness_code_fld.getText().length() >= 5) {
            evt.consume();
        }
    }//GEN-LAST:event_illness_code_fldKeyTyped

    private void illness_code_fld1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_illness_code_fld1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_illness_code_fld1KeyTyped

    private void illness_edit_save_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_illness_edit_save_btnActionPerformed
    try {
        editDatabase_Illness();
        illness_code_fld.setForeground(Color.black);
    } catch (ParseException ex) {
        // Handle parsing exceptions if needed
        ex.printStackTrace();
    }
    }//GEN-LAST:event_illness_edit_save_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Main_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main_FRAME.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
        UIDefaults ui = UIManager.getDefaults();
        
        ui.put("ScrollBarUI", ScrollBarWin11UI.class.getCanonicalName());
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_FRAME().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel SIDE_TAB;
    private javax.swing.JLabel add_btn_lbl;
    private javax.swing.JLabel add_btn_lbl1;
    private javax.swing.JLabel add_btn_lbl2;
    private javax.swing.JPanel appointment_tab;
    private javaswingdev.swing.table.Table appointment_table;
    private MainAPP.GUI.ScrollPaneWin11 appointment_table_pane;
    private javax.swing.JPanel appointments_active;
    private javax.swing.JLabel appointments_total;
    private javax.swing.JLabel delete_btn_lbl;
    private javax.swing.JLabel delete_btn_lbl1;
    private javax.swing.JLabel delete_btn_lbl2;
    private javax.swing.JLabel discard_btn_employee_lbl;
    private javax.swing.JLabel discard_btn_illness_lbl;
    private javax.swing.JLabel discard_btn_student_lbl;
    private javax.swing.JLabel edit_btn_lbl;
    private javax.swing.JLabel edit_btn_lbl1;
    private javax.swing.JLabel edit_btn_lbl2;
    private javax.swing.JButton employee_add_save_btn;
    private javax.swing.JTextField employee_address_fld;
    private com.raven.datechooser.DateChooser employee_bday_chooser;
    private javax.swing.JTextField employee_birthdate_fld;
    private javax.swing.JButton employee_cmd_add;
    private javax.swing.JButton employee_cmd_delete;
    private javax.swing.JButton employee_cmd_edit;
    private javax.swing.JTextField employee_cp_no_fld;
    private javax.swing.JButton employee_discard_btn;
    private javax.swing.JButton employee_edit_save_btn;
    private javax.swing.JTextField employee_email_fld;
    private javax.swing.JTextField employee_firstname_fld;
    private javax.swing.JComboBox<String> employee_gender_cb;
    private javax.swing.JTextField employee_gender_fld;
    private javax.swing.JTextField employee_lastname_fld;
    private javax.swing.JTextField employee_no_fld;
    private javax.swing.JTextField employee_no_fld1;
    private javax.swing.JPanel employee_panel_main;
    private javax.swing.JComboBox<String> employee_status_cb;
    private javax.swing.JTextField employee_status_fld;
    private javaswingdev.swing.table.Table employee_table;
    private javaswingdev.swing.table.Table employee_table1;
    private MainAPP.GUI.ScrollPaneWin11 employee_table_pane;
    private MainAPP.GUI.ScrollPaneWin11 employee_table_pane1;
    private javax.swing.JPanel employees_active;
    private MainAPP.GUI.ScrollPaneWin11 employees_panel;
    private javax.swing.JPanel employees_tab;
    private javax.swing.JLabel employees_total;
    private javax.swing.JPanel exit_tab;
    private javax.swing.JLabel icon_appointment;
    private javax.swing.JLabel icon_doctor;
    private javax.swing.JLabel icon_exit;
    private javax.swing.JLabel icon_illness;
    private javax.swing.JLabel icon_overview;
    private javax.swing.JLabel icon_patients;
    private javax.swing.JPanel illness_active;
    private javax.swing.JButton illness_add_save_btn;
    private javax.swing.JButton illness_cmd_add;
    private javax.swing.JButton illness_cmd_delete;
    private javax.swing.JButton illness_cmd_edit;
    private javax.swing.JTextField illness_code_fld;
    private javax.swing.JTextField illness_code_fld1;
    private javax.swing.JTextField illness_description_fld;
    private javax.swing.JButton illness_discard_btn;
    private javax.swing.JButton illness_edit_save_btn;
    private MainAPP.GUI.ScrollPaneWin11 illness_panel;
    private javax.swing.JPanel illness_panel_main;
    private javax.swing.JComboBox<String> illness_status_cb;
    private javax.swing.JTextField illness_status_fld;
    private javax.swing.JPanel illness_tab;
    private javaswingdev.swing.table.Table illness_table;
    private javaswingdev.swing.table.Table illness_table1;
    private MainAPP.GUI.ScrollPaneWin11 illness_table_pane;
    private MainAPP.GUI.ScrollPaneWin11 illness_table_pane1;
    private javax.swing.JLabel illness_total;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel label_appointments_tab;
    private javax.swing.JLabel label_employees_tab;
    private javax.swing.JLabel label_exit_tab;
    private javax.swing.JLabel label_illness_tab;
    private javax.swing.JLabel label_overview_tab;
    private javax.swing.JLabel label_patients_tab;
    private javax.swing.JPanel overview_active;
    private MainAPP.GUI.ScrollPaneWin11 overview_panel;
    private javax.swing.JPanel overview_panel_main;
    private javax.swing.JPanel overview_tab;
    private MainAPP.GUI.ScrollPaneWin11 patient_panel;
    private javax.swing.JPanel patient_panel_main;
    private javax.swing.JPanel patients_active;
    private javax.swing.JLabel patients_total;
    private javax.swing.JLabel save_btn_employee_lbl;
    private javax.swing.JLabel save_btn_illness_lbl;
    private javax.swing.JLabel save_btn_student_lbl;
    private javax.swing.JButton student_add_save_btn;
    private javax.swing.JTextField student_address_fld;
    private com.raven.datechooser.DateChooser student_bday_chooser;
    private javax.swing.JTextField student_birthdate_fld;
    private javax.swing.JButton student_cmd_add;
    private javax.swing.JButton student_cmd_delete;
    private javax.swing.JButton student_cmd_edit;
    private javax.swing.JTextField student_college_fld;
    private javax.swing.JTextField student_course_fld;
    private javax.swing.JComboBox<String> student_course_list_cb;
    private javax.swing.JTextField student_cp_no_fld;
    private javax.swing.JButton student_discard_btn;
    private javax.swing.JButton student_edit_save_btn;
    private javax.swing.JTextField student_email_fld;
    private javax.swing.JTextField student_firstname_fld;
    private javax.swing.JComboBox<String> student_gender_cb;
    private javax.swing.JTextField student_gender_fld;
    private javax.swing.JTextField student_lastname_fld;
    private javax.swing.JTextField student_no_fld;
    private javax.swing.JTextField student_no_fld1;
    private javax.swing.JComboBox<String> student_status_cb;
    private javax.swing.JTextField student_status_fld;
    private javaswingdev.swing.table.Table student_table;
    private javaswingdev.swing.table.Table student_table1;
    private MainAPP.GUI.ScrollPaneWin11 student_table_pane;
    private MainAPP.GUI.ScrollPaneWin11 student_table_pane1;
    private javax.swing.JPanel students_tab;
    // End of variables declaration//GEN-END:variables

    private void resetEditingState() {
        isEditing = false;
        // Add code to reset the editable state of fields or any other necessary cleanup
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
    
    private String mapLabelToStatus_Status(String label) {
        switch (label) {
            case "Active":
                return "A";
            case "Inactive":
                return "I";
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
    
    private int getRowCount(String query) {
        int rowCount = 0;
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CLINIC_FinalProject", "clinicadmin", "clinicadmin");

            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            // Count the number of rows
            while (rs.next()) {
                rowCount++;
            }

            rs.close();
            pst.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
    
    private void fetchDataAndPopulateTable(String query, JTable table, String[] customColumnNames, String[] columnLabels) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/CLINIC_FinalProject", "clinicadmin", "clinicadmin");

            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            DefaultTableModel model = new DefaultTableModel();
            table.setModel(model);

            for (String customColumnName : customColumnNames) {
                model.addColumn(customColumnName);
            }

            table.setDefaultEditor(Object.class, null);

            while (rs.next()) {
                Object[] row = new Object[customColumnNames.length];
                for (int i = 0; i < customColumnNames.length; i++) {
                    String columnName = columnLabels[i];
                    Object value = rs.getObject(columnName);

                    // Use the mapping methods for specific columns
                    if ("gender".equals(columnName)) {
                        value = mapStatusToLabel_Gender((String) value);
                    } else if ("status".equals(columnName)) {
                        value = mapStatusToLabel_Status((String) value);
                    }
                    // Add more conditions for other columns as needed

                    row[i] = value;
                }
                model.addRow(row);
            }
            
            rs.close();
            pst.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void updateTextFieldStudent(int selectedRow) {
            DefaultTableModel model = (DefaultTableModel) student_table1.getModel();

            // Check if selectedRow is within the valid range
            if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                student_no_fld.setText(model.getValueAt(selectedRow, 0).toString());
                student_no_fld1.setText(model.getValueAt(selectedRow, 0).toString());
                student_firstname_fld.setText(model.getValueAt(selectedRow, 1).toString());
                student_lastname_fld.setText(model.getValueAt(selectedRow, 2).toString());
                student_email_fld.setText(model.getValueAt(selectedRow, 3).toString());
                student_address_fld.setText(model.getValueAt(selectedRow, 4).toString());
                student_birthdate_fld.setText(model.getValueAt(selectedRow, 5).toString());
                student_status_cb.setSelectedItem(model.getValueAt(selectedRow, 6).toString());
                student_status_fld.setText(model.getValueAt(selectedRow, 6).toString());
                student_cp_no_fld.setText(model.getValueAt(selectedRow, 7).toString());
                student_gender_cb.setSelectedItem(model.getValueAt(selectedRow, 8).toString());
                student_gender_fld.setText(model.getValueAt(selectedRow, 8).toString());
                student_course_fld.setText(model.getValueAt(selectedRow, 9).toString());
                student_college_fld.setText(model.getValueAt(selectedRow, 10).toString());
                // Add more lines if you have more text fields
            } else {
                // Handle the case where selectedRow is out of bounds, maybe display a message or log an error
                System.err.println("Selected row is out of bounds: " + selectedRow);
            }
        }

    private void updateTextFieldEmployee(int selectedRow) {
            DefaultTableModel model = (DefaultTableModel) employee_table1.getModel();

            // Check if selectedRow is within the valid range
            if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                employee_no_fld.setText(model.getValueAt(selectedRow, 0).toString());
                employee_no_fld1.setText(model.getValueAt(selectedRow, 0).toString());
                employee_lastname_fld.setText(model.getValueAt(selectedRow, 1).toString());
                employee_firstname_fld.setText(model.getValueAt(selectedRow, 2).toString());
                employee_email_fld.setText(model.getValueAt(selectedRow, 3).toString());
                employee_gender_fld.setText(model.getValueAt(selectedRow, 4).toString());
                employee_gender_cb.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
                employee_cp_no_fld.setText(model.getValueAt(selectedRow, 5).toString());
                employee_address_fld.setText(model.getValueAt(selectedRow, 6).toString());
                employee_birthdate_fld.setText(model.getValueAt(selectedRow, 7).toString());
                employee_status_cb.setSelectedItem(model.getValueAt(selectedRow, 8).toString());
                employee_status_fld.setText(model.getValueAt(selectedRow, 8).toString());
                // Add more lines if you have more text fields
            } else {
                // Handle the case where selectedRow is out of bounds, maybe display a message or log an error
                System.err.println("Selected row is out of bounds: " + selectedRow);
            }
        }

        private void updateTextFieldIllness(int selectedRow) {
                DefaultTableModel model = (DefaultTableModel) illness_table1.getModel();

                // Check if selectedRow is within the valid range
                if (selectedRow >= 0 && selectedRow < model.getRowCount()) {
                    illness_code_fld.setText(model.getValueAt(selectedRow, 0).toString());
                    illness_code_fld1.setText(model.getValueAt(selectedRow, 0).toString());
                    illness_description_fld.setText(model.getValueAt(selectedRow, 1).toString());
                    illness_status_cb.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
                    illness_status_fld.setText(model.getValueAt(selectedRow, 2).toString());

                    // Add more lines if you have more text fields
                } else {
                    // Handle the case where selectedRow is out of bounds, maybe display a message or log an error
                    System.err.println("Selected row is out of bounds: " + selectedRow);
                }
            }

    private void addToDatabase_Student() throws ParseException {
        try {
            // Assuming you have a table named 'DT_STUDENT' with appropriate columns
            String queryCheckExisting = "SELECT COUNT(*) FROM DT_STUDENT WHERE student_no = ?";
            String queryInsert = "INSERT INTO DT_STUDENT (student_no, lastname, firstname, email, gender, course_code, cp_num, address, bday, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstCheckExisting = con.prepareStatement(queryCheckExisting);
                 PreparedStatement pstInsert = con.prepareStatement(queryInsert)) {

                // Validate if student_no already exists
                pstCheckExisting.setString(1, student_no_fld.getText());
                ResultSet resultSet = pstCheckExisting.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Student with the same student number already exists!");
                    return; // Stop the execution if student_no already exists
                }

                // Validate if any of the fields is empty
                if (fieldsAreEmptyStudent()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; // Stop the execution if any field is empty
                }

                // Validate email format
                String email = student_email_fld.getText();
                if (!email.endsWith("@plm.edu.ph")) {
                    JOptionPane.showMessageDialog(this, "Invalid email format. It should end with @plm.edu.ph");
                    return; // Stop the execution if the email format is invalid
                }

            // Validate birthdate
            String birthdateStr = student_birthdate_fld.getText();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date birthdate;
            
            try {
                birthdate = dateFormat.parse(birthdateStr);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd");
                return; // Stop the execution if the date format is invalid
            }

            Date currentDate = new Date();
            if (birthdate.after(currentDate)) {
                JOptionPane.showMessageDialog(this, "Birthdate should be before the present date.");
                return; // Stop the execution if the birthdate is after the present date
            }
                
                // If everything is valid, proceed with the insertion
                pstInsert.setString(1, student_no_fld.getText());
                pstInsert.setString(2, student_lastname_fld.getText());
                pstInsert.setString(3, student_firstname_fld.getText());
                pstInsert.setString(4, student_email_fld.getText());
                pstInsert.setString(5, mapLabelToStatus_Gender(student_gender_cb.getSelectedItem().toString()));
                pstInsert.setString(6, getCourseCodeFromDescription(student_course_list_cb.getSelectedItem().toString()));
                pstInsert.setString(7, student_cp_no_fld.getText());
                pstInsert.setString(8, student_address_fld.getText());
                pstInsert.setString(9, student_birthdate_fld.getText());
                pstInsert.setString(10, mapLabelToStatus_Status(student_status_cb.getSelectedItem().toString()));

                int result = pstInsert.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Student information saved successfully!");
                    resetAllTextFields();
                    hideComboBoxes();
                    hideSaveAndDiscardButtons();
                    textFieldEditFalse();
                    student_table1.setEnabled(true);
                    resetEditingState();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save student information.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            // Handle exceptions appropriately
            ex.printStackTrace();
        }
    }
    
    private void addToDatabase_Employee() throws ParseException {
        try {
            // Assuming you have a table named 'DT_STUDENT' with appropriate columns
            String queryCheckExisting = "SELECT COUNT(*) FROM DT_EMPLOYEE WHERE employee_id = ?";
            String queryInsert = "INSERT INTO DT_EMPLOYEE (employee_id, lastname, firstname, email, gender, cp_num, address, bday, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstCheckExisting = con.prepareStatement(queryCheckExisting);
                 PreparedStatement pstInsert = con.prepareStatement(queryInsert)) {

                // Validate if student_no already exists
                pstCheckExisting.setString(1, employee_no_fld.getText());
                ResultSet resultSet = pstCheckExisting.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Employee with the same employee ID already exists!");
                    return; // Stop the execution if student_no already exists
                }
                // Validate email format
                String email = employee_email_fld.getText();
                String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                if (!email.matches(emailRegex)) {
                    JOptionPane.showMessageDialog(this, "Invalid email format");
                    return; // Stop the execution if the email format is invalid
                }
                // Validate if any of the fields is empty
                if (fieldsAreEmptyEmployee()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; // Stop the execution if any field is empty
                }

                // Validate birthdate
                String birthdateStr = employee_birthdate_fld.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthdate;

                try {
                    birthdate = dateFormat.parse(birthdateStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd");
                    return; // Stop the execution if the date format is invalid
                }

                Date currentDate = new Date();
                if (birthdate.after(currentDate)) {
                    JOptionPane.showMessageDialog(this, "Birthdate should be before the present date.");
                    return; // Stop the execution if the birthdate is after the present date
                }
                
                // If everything is valid, proceed with the insertion
                pstInsert.setString(1, employee_no_fld.getText());
                pstInsert.setString(2, employee_lastname_fld.getText());
                pstInsert.setString(3, employee_firstname_fld.getText());
                pstInsert.setString(4, employee_email_fld.getText());
                pstInsert.setString(5, mapLabelToStatus_Gender(employee_gender_cb.getSelectedItem().toString()));
                pstInsert.setString(6, employee_cp_no_fld.getText());
                pstInsert.setString(7, employee_address_fld.getText());
                pstInsert.setString(8, employee_birthdate_fld.getText());
                pstInsert.setString(9, mapLabelToStatus_Status(employee_status_cb.getSelectedItem().toString()));

                int result = pstInsert.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Employee information saved successfully!");
                    resetAllTextFields();
                    hideSaveAndDiscardButtons();
                    textFieldEditFalse();
                    employee_table1.setEnabled(true);
                    resetEditingState();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save employee information.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            // Handle exceptions appropriately
            ex.printStackTrace();
        }
    }
    
    private void addToDatabase_Illness() throws ParseException {
        try {
            // Assuming you have a table named 'DT_STUDENT' with appropriate columns
            String queryCheckExisting = "SELECT COUNT(*) FROM DT_ILLNESS WHERE illness_code = ?";
            String queryInsert = "INSERT INTO DT_ILLNESS (illness_code, description, status) VALUES (?, ?, ?)";

            try (PreparedStatement pstCheckExisting = con.prepareStatement(queryCheckExisting);
                 PreparedStatement pstInsert = con.prepareStatement(queryInsert)) {

                // Validate if student_no already exists
                pstCheckExisting.setString(1, illness_code_fld.getText());
                ResultSet resultSet = pstCheckExisting.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                if (count > 0) {
                    JOptionPane.showMessageDialog(this, "Illness with the same code already exists!");
                    return; // Stop the execution if student_no already exists
                }

                // Validate if any of the fields is empty
                if (fieldsAreEmptyIllness()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; // Stop the execution if any field is empty
                }
                
                // If everything is valid, proceed with the insertion
                pstInsert.setString(1, illness_code_fld.getText());
                pstInsert.setString(2, illness_description_fld.getText());
                pstInsert.setString(3, mapLabelToStatus_Status(illness_status_cb.getSelectedItem().toString()));


                int result = pstInsert.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Illness information saved successfully!");
                    resetAllTextFields();
                    hideComboBoxes();
                    hideSaveAndDiscardButtons();
                    textFieldEditFalse();
                    illness_table1.setEnabled(true);
                    resetEditingState();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to save illness information.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            // Handle exceptions appropriately
            ex.printStackTrace();
        }
    }
    
    private void editDatabase_Student() throws ParseException {
        try {
            // Assuming you have a table named 'DT_STUDENT' with appropriate columns
            String queryCheckExisting = "SELECT COUNT(*) FROM DT_STUDENT WHERE student_no = ?";
            String queryUpdate = "UPDATE DT_STUDENT SET student_no = ?, lastname=?, firstname=?, email=?, gender=?, course_code=?, cp_num=?, address=?, bday=?, status=? WHERE student_no = ?";

            try (PreparedStatement pstCheckExisting = con.prepareStatement(queryCheckExisting);
                 PreparedStatement pstUpdate = con.prepareStatement(queryUpdate)) {

                // Validate if student_no exists
                pstCheckExisting.setString(1, student_no_fld.getText());
                ResultSet resultSet = pstCheckExisting.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                // Validate if any of the fields is empty
                if (fieldsAreEmptyStudent()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; // Stop the execution if any field is empty
                }

                // Validate email format
                String email = student_email_fld.getText();
                if (!email.endsWith("@plm.edu.ph")) {
                    JOptionPane.showMessageDialog(this, "Invalid email format. It should end with @plm.edu.ph");
                    return; // Stop the execution if the email format is invalid
                }

                // Validate birthdate
                String birthdateStr = student_birthdate_fld.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthdate;

                try {
                    birthdate = dateFormat.parse(birthdateStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd");
                    return; // Stop the execution if the date format is invalid
                }

                Date currentDate = new Date();
                if (birthdate.after(currentDate)) {
                    JOptionPane.showMessageDialog(this, "Birthdate should be before the present date.");
                    return; // Stop the execution if the birthdate is after the present date
                }

                // If everything is valid, proceed with the update
                pstUpdate.setString(1, student_no_fld.getText());
                pstUpdate.setString(2, student_lastname_fld.getText());
                pstUpdate.setString(3, student_firstname_fld.getText());
                pstUpdate.setString(4, student_email_fld.getText());
                pstUpdate.setString(5, mapLabelToStatus_Gender(student_gender_cb.getSelectedItem().toString()));
                pstUpdate.setString(6, getCourseCodeFromDescription(student_course_list_cb.getSelectedItem().toString()));
                pstUpdate.setString(7, student_cp_no_fld.getText());
                pstUpdate.setString(8, student_address_fld.getText());
                pstUpdate.setString(9, student_birthdate_fld.getText());
                pstUpdate.setString(10, mapLabelToStatus_Status(student_status_cb.getSelectedItem().toString()));
                pstUpdate.setString(11, student_no_fld1.getText());

//                pstUpdate.setString(10, student_no_fld.getText());

                int result = pstUpdate.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Student information updated successfully!");
                    resetAllTextFields();
                    hideComboBoxes();
                    hideSaveAndDiscardButtons();
                    textFieldEditFalse();
                    student_table1.setEnabled(true);
                    resetEditingState();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update student information.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("foreign key constraint")) {
                JOptionPane.showMessageDialog(this, "Cannot update student information due to a foreign key constraint.");
            } else if (e.getMessage().contains("duplicate key value")) {
                JOptionPane.showMessageDialog(this, "Cannot update student information. A student with the same student number already exists.");
                showComboBox();
                return;
            } else {
                e.printStackTrace(); // Handle other integrity constraint violations
            }
        } catch (SQLException ex) {
            // Handle other SQL exceptions appropriately
            ex.printStackTrace();
        }
    }

    private void editDatabase_Employee() throws ParseException {
        try {
            // Assuming you have a table named 'DT_EMPLOYEE' with appropriate columns
            String queryCheckExisting = "SELECT COUNT(*) FROM DT_EMPLOYEE WHERE employee_id = ?";
            String queryUpdate = "UPDATE DT_EMPLOYEE SET employee_id = ?, lastname=?, firstname=?, email=?, gender=?, cp_num=?, address=?, bday=?, status=? WHERE employee_id = ?";

            try (PreparedStatement pstCheckExisting = con.prepareStatement(queryCheckExisting);
                 PreparedStatement pstUpdate = con.prepareStatement(queryUpdate)) {

                // Validate if employee_id exists
                pstCheckExisting.setString(1, employee_no_fld.getText());
                ResultSet resultSet = pstCheckExisting.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                // Validate if any of the fields is empty
                if (fieldsAreEmptyEmployee()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; // Stop the execution if any field is empty
                }

                    // Validate email format
                    String email = employee_email_fld.getText();
                    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

                    if (!email.matches(emailRegex)) {
                        JOptionPane.showMessageDialog(this, "Invalid email format");
                        return; // Stop the execution if the email format is invalid
                    }
                    // Validate if any of the fields is empty
                    if (fieldsAreEmptyEmployee()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                        return; // Stop the execution if any field is empty
                    }

                // Validate birthdate
                String birthdateStr = employee_birthdate_fld.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date birthdate;

                try {
                    birthdate = dateFormat.parse(birthdateStr);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd");
                    return; // Stop the execution if the date format is invalid
                }

                Date currentDate = new Date();
                if (birthdate.after(currentDate)) {
                    JOptionPane.showMessageDialog(this, "Birthdate should be before the present date.");
                    return; // Stop the execution if the birthdate is after the present date
                }

                // If everything is valid, proceed with the update
                pstUpdate.setString(1, employee_no_fld.getText());
                pstUpdate.setString(2, employee_lastname_fld.getText());
                pstUpdate.setString(3, employee_firstname_fld.getText());
                pstUpdate.setString(4, employee_email_fld.getText());
                pstUpdate.setString(5, mapLabelToStatus_Gender(employee_gender_cb.getSelectedItem().toString()));
                pstUpdate.setString(6, employee_cp_no_fld.getText());
                pstUpdate.setString(7, employee_address_fld.getText());
                pstUpdate.setString(8, employee_birthdate_fld.getText());
                pstUpdate.setString(9, mapLabelToStatus_Status(employee_status_cb.getSelectedItem().toString()));
                pstUpdate.setString(10, employee_no_fld1.getText());

                int result = pstUpdate.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Employee information updated successfully!");
                    resetAllTextFields();
                    hideComboBoxes();
                    hideSaveAndDiscardButtons();
                    textFieldEditFalse();
                    employee_table1.setEnabled(true);
                    resetEditingState();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update employee information.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("foreign key constraint")) {
                JOptionPane.showMessageDialog(this, "Cannot update employee information due to a foreign key constraint.");
            } else if (e.getMessage().contains("duplicate key value")) {
                JOptionPane.showMessageDialog(this, "Cannot update employee information. An employee with the same employee ID already exists.");
                // Handle accordingly, maybe show relevant fields or return
                return;
            } else {
                e.printStackTrace(); // Handle other integrity constraint violations
            }
        } catch (SQLException ex) {
            // Handle other SQL exceptions appropriately
            ex.printStackTrace();
        }
    }

    private void editDatabase_Illness() throws ParseException {
        try {
            // Assuming you have a table named 'DT_EMPLOYEE' with appropriate columns
            String queryCheckExisting = "SELECT COUNT(*) FROM DT_ILLNESS WHERE illness_code = ?";
            String queryUpdate = "UPDATE DT_ILLNESS SET illness_code = ?, description=?, status=? WHERE illness_code = ?";

            try (PreparedStatement pstCheckExisting = con.prepareStatement(queryCheckExisting);
                 PreparedStatement pstUpdate = con.prepareStatement(queryUpdate)) {

                // Validate if employee_id exists
                pstCheckExisting.setString(1, illness_code_fld.getText());
                ResultSet resultSet = pstCheckExisting.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);

                // Validate if any of the fields is empty
                if (fieldsAreEmptyIllness()) {
                    JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
                    return; // Stop the execution if any field is empty
                }

                // If everything is valid, proceed with the update
                pstUpdate.setString(1, illness_code_fld.getText());
                pstUpdate.setString(2, illness_description_fld.getText());
                pstUpdate.setString(3, mapLabelToStatus_Status(illness_status_cb.getSelectedItem().toString()));
                pstUpdate.setString(4, illness_code_fld1.getText());

                int result = pstUpdate.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Illness information updated successfully!");
                    resetAllTextFields();
                    hideComboBoxes();
                    hideSaveAndDiscardButtons();
                    textFieldEditFalse();
                    employee_table1.setEnabled(true);
                    resetEditingState();
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to update illness information.", "", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            if (e.getMessage().contains("foreign key constraint")) {
                JOptionPane.showMessageDialog(this, "Cannot update illness information due to a foreign key constraint.");
            } else if (e.getMessage().contains("duplicate key value")) {
                JOptionPane.showMessageDialog(this, "Cannot update illness information. An Illness with the same code already exists.");
                // Handle accordingly, maybe show relevant fields or return
                return;
            } else {
                e.printStackTrace(); // Handle other integrity constraint violations
            }
        } catch (SQLException ex) {
            // Handle other SQL exceptions appropriately
            ex.printStackTrace();
        }
    }
    
    private boolean fieldsAreEmptyStudent() {
        // Check if any of the relevant fields is empty
        return student_no_fld.getText().isEmpty() ||
                student_lastname_fld.getText().isEmpty() ||
                student_firstname_fld.getText().isEmpty() ||
                student_email_fld.getText().isEmpty() ||
                student_cp_no_fld.getText().isEmpty() ||
                student_birthdate_fld.getText().isEmpty();
    }

    private boolean fieldsAreEmptyEmployee() {
        // Check if any of the relevant fields for employees is empty
        return employee_firstname_fld.getText().isEmpty() ||
                employee_lastname_fld.getText().isEmpty() ||
                employee_email_fld.getText().isEmpty() ||
                employee_no_fld.getText().isEmpty() ||
                employee_address_fld.getText().isEmpty() ||
                employee_cp_no_fld.getText().isEmpty();
    } 
    
    private boolean fieldsAreEmptyIllness() {
        // Check if any of the relevant fields for employees is empty
        return illness_code_fld.getText().isEmpty() ||
                illness_description_fld.getText().isEmpty();
    } 
    
        public static void populateComboBoxFromDatabase(JComboBox<String> jComboBox, String columnName, String tableName) {
            // Update these values with your actual database connection details
            String url = "jdbc:derby://localhost:1527/CLINIC_FinalProject";
            String username = "clinicadmin";
            String password = "clinicadmin";

            try (Connection conn = DriverManager.getConnection(url, username, password);
                 Statement stmt = conn.createStatement()) {

                // Execute query to retrieve data
                String query = "SELECT " + columnName + " FROM " + tableName;
                try (ResultSet rs = stmt.executeQuery(query)) {

                    // Clear existing items
                    jComboBox.removeAllItems();

                    // Populate JComboBox with data from the database
                    while (rs.next()) {
                        jComboBox.addItem(rs.getString(columnName));
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception according to your needs
            }
        }
   
        public static void updateCollegeTextField(JTextField collegeTextField, JComboBox<String> courseComboBox) {
            // Check if the JComboBox is visible
            if (courseComboBox.isVisible()) {
                // Get the selected course
                String selectedCourse = (String) courseComboBox.getSelectedItem();

                // Update these values with your actual database connection details
                String url = "jdbc:derby://localhost:1527/CLINIC_FinalProject";
                String username = "clinicadmin";
                String password = "clinicadmin";

                try (Connection conn = DriverManager.getConnection(url, username, password);
                     Statement stmt = conn.createStatement()) {

                    // Execute query to retrieve college based on the selected course
                    String query = "SELECT * FROM COURSECOLLEGEVIEW WHERE course_description = '" + selectedCourse + "'";
                    try (ResultSet rs = stmt.executeQuery(query)) {
                        // Check if there is a result and update the JTextField
                        if (rs.next()) {
                            collegeTextField.setText(rs.getString("college_description"));
                        } else {
                            collegeTextField.setText("College not found");
                        }
                    }

                } catch (SQLException ex) {
                    ex.printStackTrace(); // Handle the exception according to your needs
                }
            } else {
                // If the JComboBox is not visible, clear the JTextField
                collegeTextField.setText("");
            }
        }

        private String getCourseCodeFromDescription(String courseDescription) {
            String courseCode = null;

            try {
                String query = "SELECT course_code FROM COURSECOLLEGEVIEW WHERE course_description = ?";

                try (PreparedStatement pst = con.prepareStatement(query)) {
                    pst.setString(1, courseDescription);

                    try (ResultSet resultSet = pst.executeQuery()) {
                        if (resultSet.next()) {
                            courseCode = resultSet.getString("course_code");
                        }
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle exceptions appropriately
            }

            return courseCode;
        }

    public void resetAllTextFields() {
        JTextField[] textFields = {
            student_firstname_fld,
            student_lastname_fld,
            student_email_fld,
            student_address_fld,
            student_cp_no_fld,
            student_birthdate_fld,
            student_gender_fld,
            student_status_fld,
            student_course_fld,
            student_college_fld,
            student_no_fld,
            employee_firstname_fld,
            employee_lastname_fld,
            employee_email_fld,
            employee_no_fld,
            employee_address_fld,
            employee_cp_no_fld,
            employee_birthdate_fld,
            employee_gender_fld,
            employee_status_fld,
            illness_code_fld,
            illness_description_fld,
            illness_status_fld
        };

        for (JTextField textField : textFields) {
            textField.setText("");
        }
    }        
    
    public void hideComboBoxes() {
        JComboBox[] comboBoxes = {
            student_gender_cb,
            student_status_cb,
            student_course_list_cb,
            employee_gender_cb,
            employee_status_cb,
            illness_status_cb
        };

        for (JComboBox comboBox : comboBoxes) {
            comboBox.setVisible(false);
        }
    }
    
    public void showComboBox() {
        JComboBox[] comboBoxes = {
            student_gender_cb,
            student_status_cb,
            student_course_list_cb,
            employee_gender_cb,
            employee_status_cb,
            illness_status_cb
        };

        for (JComboBox comboBox : comboBoxes) {
            comboBox.setVisible(true);
        }
    }
    
    public void hideSaveAndDiscardButtons() {
        JLabel[] jLabels = {
            save_btn_student_lbl,
            discard_btn_student_lbl,
            save_btn_employee_lbl,
            discard_btn_employee_lbl,
            save_btn_illness_lbl,
            discard_btn_illness_lbl
        };
        JButton[] jButtons = {
            student_add_save_btn,
            student_edit_save_btn,
            student_discard_btn,
            employee_add_save_btn,
            employee_edit_save_btn,
            employee_discard_btn,
            illness_add_save_btn,
            illness_edit_save_btn,
            illness_discard_btn
        };        
        for (JLabel comboBox : jLabels) {
            comboBox.setVisible(false);
        }
        for (JButton jButton : jButtons) {
            jButton.setVisible(false);
        }
    }
    
    public void textFieldEditTrue() {
        setTextFieldEditable(true);
    }

    // Method to turn off editing for student fields
    public void textFieldEditFalse() {
        setTextFieldEditable(false);
    }

    // Helper method to set text field editing
    private void setTextFieldEditable(boolean editable) {
        JTextField[] textFields = {
            student_no_fld,
            student_firstname_fld,
            student_lastname_fld,
            student_email_fld,
            student_address_fld,
            student_cp_no_fld,
            student_gender_fld,
            student_status_fld,
            employee_firstname_fld,
            employee_lastname_fld,
            employee_email_fld,
            employee_address_fld,
            employee_cp_no_fld,
            employee_gender_fld,
            employee_status_fld,
            illness_code_fld,
            illness_description_fld,
            illness_status_fld
        };

        for (JTextField textField : textFields) {
            textField.setEditable(editable);
        }
    }

    private void setBirthdateFromTextField(JTextField textField, DateChooser dateChooser) {
        try {
            // Assuming the provided textField is a JTextField
            String dateString = textField.getText();

            // Create a SimpleDateFormat for the yyyy-MM-dd format
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Parse the string into a Date object
            Date birthdate = dateFormat.parse(dateString);

            // Set the selected date in the provided DateChooser
            dateChooser.setSelectedDate(birthdate);

        } catch (ParseException e) {
            e.printStackTrace();
            // Handle the ParseException appropriately in your application
        }
    }

    private boolean isStudentInConsultationTable(String studentNo) {
        try {
            // Assuming you have a connection named 'con'
            String query = "SELECT COUNT(*) FROM FT_CONSULTATION WHERE student_no = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, studentNo);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // If count is greater than 0, student_no is present in FT_CONSULTATION
                        return rs.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
        return false; // Default to false in case of an exception
    }
    
    private boolean isEmployeeInConsultationTable(String employeeNo) {
        try {
            // Assuming you have a connection named 'con'
            String query = "SELECT COUNT(*) FROM FT_CONSULTATION WHERE attending_physician_id = ? OR prepared_by_id = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, employeeNo);
                pst.setString(2, employeeNo);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // If count is greater than 0, student_no is present in FT_CONSULTATION
                        return rs.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
        return false; // Default to false in case of an exception
    }
    
    private boolean isIllnessInConsultationTable(String illnessCode) {
        try {
            // Assuming you have a connection named 'con'
            String query = "SELECT COUNT(*) FROM FT_CONSULTATION WHERE illness_code = ?";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                pst.setString(1, illnessCode);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        // If count is greater than 0, student_no is present in FT_CONSULTATION
                        return rs.getInt(1) > 0;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately in your application
        }
        return false; // Default to false in case of an exception
    }
    
}

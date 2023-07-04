package apartment_test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import java.awt.Color;
import javax.swing.table.TableModel;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

/**
 *
 * @author ccs
 */
public class VisitorRecord extends javax.swing.JFrame {
    private int posX; // Stores the initial X position of the mouse during dragging
    private int posY; // Stores the initial Y position of the mouse during dragging
    private JComboBox<String> cmbtype;
    private JDateChooser dateChooser;
    private JSpinner timeSpinner;
    private DefaultTableModel model;



    /**
     * Creates new form AddRecord
     */
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String sqr;
    int s = 0;
    String name = "";
    String vehicleno = "";
    String reason = "";
    String type = "";
    String timein = "";
    String timeout = "";
    String apartmentno = "";
    String date = "";
    
    public VisitorRecord () {
        initComponents();
        conn = DBConnect.connect();
        createTable();
        tablelord();
    } 
    
    private void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS visitor (" +
                "reason TEXT NOT NULL , " +
                "type CHAR(10) NOT NULL, " +
                "name CHAR(20) NOT NULL, " +
                "vehicleno VARCHAR(7) NOT NULL, " +
                "apartmentno VARCHAR(4) NOT NULL, " +
                "timein TIME NOT NULL, " +
                "timeout TIME NOT NULL, " +
                "date DATE NOT NULL, " +
                "PRIMARY KEY (name))";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
            System.out.println("Table 'visitor' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    model = new DefaultTableModel(
            new Object[][]{},
            new String[]{
                    "Reason", "Type", "Name", "Vehicle No", "Apartment No", "Time In", "Time Out", "Date"
            }
    );
    jTable1.setModel(model);
}

    
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        txtvehicleno = new javax.swing.JTextField();
        cmbype = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtreason = new javax.swing.JTextArea();
        txtapartmentno = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txttimein = new javax.swing.JTextField();
        txttimeout = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(252, 65, 54));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel1MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(43, 44, 120));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/close-window-24.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8)
        );

        jLabel1.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Type");

        jLabel3.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Vehicle No");

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Apartment No");

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Time In");

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Reason");

        txtname.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        txtname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnameActionPerformed(evt);
            }
        });

        txtvehicleno.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N

        cmbype.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        cmbype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Type", "Car", "Motocycle", "Lorry", "Truck" }));
        cmbype.setSelectedIndex(0);
        cmbype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbypeActionPerformed(evt);
            }
        });
        cmbype.setBounds(160, 230, 190, 22); // Adjust the bounds as needed
        getContentPane().add(cmbype);

        txtreason.setColumns(20);
        txtreason.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        txtreason.setRows(5);
        jScrollPane1.setViewportView(txtreason);

        txtapartmentno.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        txtapartmentno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapartmentnoActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete-24.png"))); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 255, 0));
        jButton3.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/add-user-3-24.png"))); // NOI18N
        jButton3.setText("Create");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 51));
        jButton4.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/brush-2-24.png"))); // NOI18N
        jButton4.setText("Generate PDF");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnupdate.setBackground(new java.awt.Color(0, 0, 255));
        btnupdate.setFont(new java.awt.Font("Sitka Text", 3, 14)); // NOI18N
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/available-updates-24.png"))); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jLabel4.setFont(new java.awt.Font("Sitka Heading", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Visitor Details");

        txttimein.setFont(new java.awt.Font("Sitka Text", 1, 12));
        timeSpinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm:ss");
        timeSpinner.setEditor(timeEditor);

        txttimeout.setFont(new java.awt.Font("Sitka Text", 1, 12));
        // Create a SpinnerDateModel for the time spinner
        SpinnerDateModel timeModel = new SpinnerDateModel();
        JSpinner timeSpinner = new JSpinner(timeModel);

        // Add the timeSpinner to the JFrame's content pane
        getContentPane().add(timeSpinner);
        txttimeout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimeoutActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Time out");

        jLabel10.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Date");

        txtdate.setFont(new java.awt.Font("Sitka Text", 1, 12));
        txtdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtname, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(txtvehicleno, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(cmbype, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtapartmentno))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttimeout, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addComponent(txtdate)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txttimein, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel4)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtvehicleno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txttimein, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txttimeout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtapartmentno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtapartmentnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapartmentnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapartmentnoActionPerformed

    private void getvalue() {

        reason = txtreason.getText();
        name = txtvehicleno.getText();
        type = cmbype.getSelectedItem().toString();
        vehicleno = txtvehicleno.getText();
        apartmentno = txtapartmentno.getText();
        timein = txttimein.getText();
        timeout = txttimeout.getText();
        date = txtdate.getText();

    }
    
    // Event handler for mouse pressed event
    public void formMousePressed(java.awt.event.MouseEvent evt) {
        posX = evt.getX(); // Get the initial X position of the mouse
        posY = evt.getY(); // Get the initial Y position of the mouse
    }

    // Event handler for mouse dragged event
    public void formMouseDragged(java.awt.event.MouseEvent evt) {
        int newX = evt.getXOnScreen() - posX; // Calculate the new X position of the frame
        int newY = evt.getYOnScreen() - posY; // Calculate the new Y position of the frame
        setLocation(newX, newY); // Set the new position of the frame
    }
    
    

 
    public class DateTime {

        public static void main(String[] args) {
            // Get the current date and time
            LocalDateTime now = LocalDateTime.now();

            // Define the desired date and time format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format the current date and time
            String formattedDateTime = now.format(formatter);

            // Display the formatted date and time
            System.out.println("Current date and time: " + formattedDateTime);
        }
    }
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
        getvalue();
        String q = "INSERT INTO `visitor`(`name`, `vehicleno`, `type`, `reason`, `timein`, `timeout`, `apartmentno`, `date`) VALUES (?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(q);
        pst.setString(1, name);
        pst.setString(2, vehicleno);
        pst.setString(3, type);
        pst.setString(4, reason);
        pst.setString(5, timein);
        pst.setString(6, timeout);
        pst.setString(7, apartmentno);
        pst.setString(8, date);
        pst.executeUpdate();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(rootPane, e);
    }
    JOptionPane.showMessageDialog(rootPane, "Registration success");
    tablelord();

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
       
    }//GEN-LAST:event_jLabel8MouseClicked

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            int selectedRow = jTable1.getSelectedRow();
                       
            // Assuming the column indexes for each field
            String newName = txtname.getText();
            String newVehicleNo = txtvehicleno.getText();
            String newReason = txtreason.getText();
            String newTimeIn = txttimein.getText();
            String newTimeOut = txttimeout.getText();
            String newApartmentNo = txtapartmentno.getText();
            String newDate = txtdate.getText();

            // Assuming the "name" column index is 2
            String name = jTable1.getValueAt(selectedRow, 2).toString();

            String q = "UPDATE `visitor` SET `name`=?, `vehicleno`=?, `reason`=?, `timein`=?, `timeout`=?, `apartmentno`=?, `date`=? WHERE `name`=?";
            pst = conn.prepareStatement(q);
            pst.setString(1, newName);
            pst.setString(2, newVehicleNo);
            pst.setString(3, newReason);
            pst.setString(4, newTimeIn);
            pst.setString(5, newTimeOut);
            pst.setString(6, newApartmentNo);
            pst.setString(7, newDate);
            pst.setString(8, name);
            
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Update success", "Success", JOptionPane.INFORMATION_MESSAGE);
                tablelord(); // Refresh the table after successful update
            } else {
                JOptionPane.showMessageDialog(this, "Update failed", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnupdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int x = JOptionPane.showConfirmDialog(rootPane, "Do you realy want to delete");
        if (x == 0) {
            try {
                String sql = "DELETE FROM `visitor` where name='" + txtvehicleno.getText() + "'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(rootPane, "successfully delete");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
        tablelord();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    int selectedRowIndex = jTable1.getSelectedRow();

    // Retrieve the values from the selected row
    String reason = jTable1.getValueAt(selectedRowIndex, 0).toString();
    String type = jTable1.getValueAt(selectedRowIndex, 1).toString();
    String name = jTable1.getValueAt(selectedRowIndex, 2).toString();
    String vehicleNo = jTable1.getValueAt(selectedRowIndex, 3).toString();
    String apartmentNo = jTable1.getValueAt(selectedRowIndex, 4).toString();
    String timeIn = jTable1.getValueAt(selectedRowIndex, 5).toString();
    String timeOut = jTable1.getValueAt(selectedRowIndex, 6).toString();
    String date = jTable1.getValueAt(selectedRowIndex, 7).toString();

    // Display the retrieved values
    txtreason.setText(reason);
     // Set the selected item in cmbtype
    cmbype.setSelectedItem(type);  
    txtname.setText(name);
    txtvehicleno.setText(vehicleNo);
    txtapartmentno.setText(apartmentNo);
    txttimein.setText(timeIn);
    txttimeout.setText(timeOut);
    txtdate.setText(date);
    }//GEN-LAST:event_jTable1MouseClicked
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     // Create a new save file dialog
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Save PDF File");

    // Set the file filter to only allow saving as PDF files
    FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF Files", "pdf");
    fileChooser.setFileFilter(filter);

    // Show the save file dialog
    int userSelection = fileChooser.showSaveDialog(this);

    if (userSelection == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        String outputPath = selectedFile.getAbsolutePath();

        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage(PDRectangle.A4);
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            
            // Create a table with the same number of columns as the table in your GUI
            int numColumns = jTable1.getColumnCount();
            float tableWidth = page.getMediaBox().getWidth() - 2 * 50; // Adjust the margins as needed
            float yStart = page.getMediaBox().getHeight() - 50; // Adjust the starting position as needed
            float tableHeight = 20f; // Adjust the row height as needed
            float cellMargin = 5f; // Adjust the cell margin as needed

            // Set up the table header
            float[] columnWidths = new float[numColumns];
            float tableYPos = yStart;
            float tableXPos = 50;

            // Set the column widths based on the table in your GUI
            for (int i = 0; i < numColumns; i++) {
                columnWidths[i] = jTable1.getColumnModel().getColumn(i).getWidth();
            }

             // Draw the table header
            drawTableHeader(document,contentStream, tableXPos, tableYPos, tableWidth, tableHeight, columnWidths);


            // Draw the table data
            float nextYPos = tableYPos - tableHeight;
            drawTableData(document,contentStream, tableXPos, nextYPos, tableWidth, tableHeight, cellMargin, columnWidths);

            // Save the document to the output file
            document.save(outputPath);

            // Show a success message
            JOptionPane.showMessageDialog(this, "PDF file saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            // Show an error message if an exception occurs
            JOptionPane.showMessageDialog(this, "Failed to save PDF file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cmbypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbypeActionPerformed
     
    }//GEN-LAST:event_cmbypeActionPerformed

    private void txtdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdateActionPerformed

    private void txttimeoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimeoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimeoutActionPerformed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseEntered

    private void jPanel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseExited

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseReleased

    private void txtnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnameActionPerformed

    private void tablelord() {
    try {
        String sql = "SELECT * FROM visitor";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        model.setRowCount(0); // Clear existing rows

        while (rs.next()) {
            String reason = rs.getString("reason");
            String type = rs.getString("type");
            String name = rs.getString("name");
            String vehicleNo = rs.getString("vehicleno");
            String apartmentNo = rs.getString("apartmentno");
            String timeIn = rs.getTime("timein").toString();
            String timeOut = rs.getTime("timeout").toString();
            String date = rs.getDate("date").toString();

            // Add the retrieved data as a new row to the table
            model.addRow(new Object[] { reason, type, name, vehicleNo, apartmentNo, timeIn, timeOut, date });
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    private void drawTableHeader(PDDocument document,PDPageContentStream contentStream, float x, float y, float tableWidth, float tableHeight, float[] columnWidths) throws IOException {
    // Set the font for the header
    PDType0Font font = PDType0Font.load(document, new File("C:/Users/Dell/Downloads/39335_UniversCondensed.ttf"));
    contentStream.setFont(font, 12);

    // Set the fill color for the header
    contentStream.setNonStrokingColor(Color.BLACK);

    // Set the initial position for drawing the table cells
    float currentX = x;
    float currentY = y;

    // Draw the header cells
    for (int i = 0; i < columnWidths.length; i++) {
        float cellWidth = columnWidths[i];

        // Draw the cell rectangle
        contentStream.addRect(currentX, currentY, cellWidth, tableHeight);
        contentStream.fill();

        // Set the text color to white
        contentStream.setNonStrokingColor(Color.WHITE);

        // Set the text position and draw the column name
        contentStream.beginText();
        contentStream.newLineAtOffset(currentX + 2, currentY + 2);
        contentStream.showText(jTable1.getColumnName(i));
        contentStream.endText();

        // Set the text color back to black
        contentStream.setNonStrokingColor(Color.BLACK);

        currentX += cellWidth;
    }
}


private void drawTableData(PDDocument document, PDPageContentStream contentStream, float x, float y, float tableWidth, float tableHeight, float cellMargin, float[] columnWidths) throws IOException {
    // Set the font for the table data
    PDType0Font font = PDType0Font.load(document, new File("C:/Users/Dell/Downloads/39335_UniversCondensed.ttf"));
    contentStream.setFont(font, 12);
    
    // Set the fill color for the table data
    contentStream.setNonStrokingColor(Color.BLACK);

    // Set the initial position for drawing the table cells
    float currentX = x;
    float currentY = y;

    // Get the table data from your GUI table
    TableModel model = jTable1.getModel();
    int rowCount = model.getRowCount();
    int columnCount = model.getColumnCount();

    // Draw the table data cells
    for (int row = 0; row < rowCount; row++) {
        currentX = x;
        currentY -= tableHeight;

        for (int column = 0; column < columnCount; column++) {
            float cellWidth = columnWidths[column];
            String cellValue = model.getValueAt(row, column).toString();

            // Draw the cell rectangle
            contentStream.addRect(currentX, currentY, cellWidth, tableHeight);
            contentStream.fill();

            // Set the text color to white
            contentStream.setNonStrokingColor(Color.WHITE);

            // Set the text position and draw the cell value
            contentStream.beginText();
            contentStream.newLineAtOffset(currentX + cellMargin, currentY + 2);
            contentStream.showText(cellValue);
            contentStream.endText();

            // Set the text color back to black
            contentStream.setNonStrokingColor(Color.BLACK);

            currentX += cellWidth;
        }
    }
}

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        // Create an instance of the VisitorRecord class
        VisitorRecord visitorRecord = new VisitorRecord();

        // Set up and display the frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisitorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisitorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisitorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisitorRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
             
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisitorRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox cmbype;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtapartmentno;
    private javax.swing.JTextField txtdate;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextArea txtreason;
    private javax.swing.JTextField txttimein;
    private javax.swing.JTextField txttimeout;
    private javax.swing.JTextField txtvehicleno;
    // End of variables declaration//GEN-END:variables
}

package my.serialgui;

import com.fazecast.jSerialComm.*; // main serial lib
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.Timer;

public class SerialGUIUI extends javax.swing.JFrame {

    // store available serial ports
    private SerialPort[] ports;

    // active serial port
    private static SerialPort p;

    // Used to get the event from the clock to update GUI automagically
    private Updater updater = new Updater();

    // Timer to call the update method
    private Timer updateTimer;
    
    private boolean verbose = false;

    private byte[] readBuffer;
    
    private String serialString = "";

    private boolean keepGoing = false;

    // This is what gets called when the timer is up
    // This is where you do the constant updating
    public class Updater implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                // If the port has data to read
                if (p.bytesAvailable() != 0) {
                    // Create buffer array
                    readBuffer = new byte[p.bytesAvailable()];
                    // Read data into buffer
                    p.readBytes(readBuffer, readBuffer.length);
                    // turn buffer into string
                    String bufferString = new String(readBuffer);
                    // append to reader string
                    serialString += bufferString;
                    
                    if(serialString.indexOf('\n') > 0){
                        
                        // make new string to parse from 
                        String lineString = serialString.substring(0, serialString.indexOf('\n'));
                        
                        // take first line off of string
                        serialString = serialString.substring(serialString.indexOf('\n'));
                        
                        if(verbose) statusText.append("Got a whole line: "+ lineString +"\n");
                        
                        // make scanner to parse
                        Scanner lineScanner = new Scanner(serialString);
                        
                        // set alt display
                        String altString = lineScanner.next();
                        altitudeDisplayText.setText(altString);
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public SerialGUIUI() {
        initComponents();
        
        disconnectButtonActionPerformed(null);

        // Initialize timer with 20ms period, to call the updater object
        updateTimer = new Timer(20, updater);
    }

    //DONT TOUCH! GUI STUFF!
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        autoManulText = new javax.swing.JLabel();
        manualButton = new javax.swing.JButton();
        autoButton = new javax.swing.JButton();
        armedDisarmedText = new javax.swing.JLabel();
        armButton = new javax.swing.JButton();
        disarmButton = new javax.swing.JButton();
        gliderButton = new javax.swing.JButton();
        habsButton = new javax.swing.JButton();
        waterButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        statusText = new javax.swing.JTextArea();
        disconnectButton = new javax.swing.JButton();
        connectButton = new javax.swing.JButton();
        portSelector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        altitudeDisplayText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(700, 500));
        setResizable(false);

        autoManulText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        autoManulText.setText("Manual");
        autoManulText.setToolTipText("");

        manualButton.setText("Manual");
        manualButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualButtonActionPerformed(evt);
            }
        });

        autoButton.setText("Auto");
        autoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autoButtonActionPerformed(evt);
            }
        });

        armedDisarmedText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        armedDisarmedText.setText("Disarmed");
        armedDisarmedText.setToolTipText("");

        armButton.setText("Arm");
        armButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                armButtonActionPerformed(evt);
            }
        });

        disarmButton.setText("Disarm");
        disarmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disarmButtonActionPerformed(evt);
            }
        });

        gliderButton.setText("Glider");
        gliderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gliderButtonActionPerformed(evt);
            }
        });

        habsButton.setText("Habs");
        habsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                habsButtonActionPerformed(evt);
            }
        });

        waterButton.setText("Water");
        waterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waterButtonActionPerformed(evt);
            }
        });

        statusText.setColumns(20);
        statusText.setRows(5);
        jScrollPane1.setViewportView(statusText);

        disconnectButton.setText("Disconnect");
        disconnectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disconnectButtonActionPerformed(evt);
            }
        });

        connectButton.setText("Connect");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        portSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Altitude:");

        altitudeDisplayText.setText("--");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(altitudeDisplayText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 395, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(armedDisarmedText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(armButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(disarmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(autoManulText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(manualButton, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(autoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(habsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(waterButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gliderButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(connectButton, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(disconnectButton, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE))
                        .addComponent(portSelector, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoManulText)
                    .addComponent(armedDisarmedText)
                    .addComponent(jLabel1)
                    .addComponent(altitudeDisplayText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manualButton)
                    .addComponent(armButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autoButton)
                    .addComponent(disarmButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(gliderButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(waterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(habsButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disconnectButton)
                    .addComponent(connectButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        statusText.append("Opening Port\n");
        
        // Find which port is selected in the drop-down
        int portSelection = portSelector.getSelectedIndex();
        
        // Extract from array to make it easier
        p = ports[portSelection];
        
        // A li'l error checking
        if (p.isOpen()) {
            statusText.append("Port already open\n");
            return;
        }
        
        // 
        int selectedBaud = Integer.parseInt("9600");
        
        // Open port with baud rate.
        p.openPort();
        p.setBaudRate(selectedBaud);
        
        serialString = "";
        
        if(verbose) statusText.append("Opened Port at " + selectedBaud + " bps\n");

        // Start timer after 50ms
        updateTimer.setInitialDelay(50);
        updateTimer.start();
    }//GEN-LAST:event_connectButtonActionPerformed

    private void disconnectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disconnectButtonActionPerformed

        if (p != null && p.isOpen()) {
            // close port
            if(verbose) statusText.append("Closing port\n");
            p.closePort();
            statusText.append("Port closed\n");
            updateTimer.stop();
        } else {
            // scan ports
            statusText.append("Scanning ports\n");

            // Remove all the old ports from the list
            portSelector.removeAllItems();

            // Update ports array
            ports = SerialPort.getCommPorts();

            // Add each port to the drop-down
            for (SerialPort port : ports) {
                portSelector.addItem(port.getDescriptivePortName());
            }

            if(verbose) statusText.append("Done scanning\n");
        }
    }//GEN-LAST:event_disconnectButtonActionPerformed

    private void armButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_armButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_armButtonActionPerformed

    private void disarmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disarmButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disarmButtonActionPerformed

    private void manualButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manualButtonActionPerformed

    private void autoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autoButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autoButtonActionPerformed

    private void gliderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gliderButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gliderButtonActionPerformed

    private void waterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waterButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waterButtonActionPerformed

    private void habsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_habsButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_habsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SerialGUIUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SerialGUIUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SerialGUIUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SerialGUIUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SerialGUIUI().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel altitudeDisplayText;
    private javax.swing.JButton armButton;
    private javax.swing.JLabel armedDisarmedText;
    private javax.swing.JButton autoButton;
    private javax.swing.JLabel autoManulText;
    private javax.swing.JButton connectButton;
    private javax.swing.JButton disarmButton;
    private javax.swing.JButton disconnectButton;
    private javax.swing.JButton gliderButton;
    private javax.swing.JButton habsButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton manualButton;
    private javax.swing.JComboBox<String> portSelector;
    private javax.swing.JTextArea statusText;
    private javax.swing.JButton waterButton;
    // End of variables declaration//GEN-END:variables
}

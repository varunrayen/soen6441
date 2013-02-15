/*
 * TEAM C in SOEN6441/WW
 */
package kingdom.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import kingdom.actions.IGameAction.ActionResult;
import kingdom.actions.LoadCofigAction;
import kingdom.actions.MoveItemFromUserToBoard;
import kingdom.actions.SaveCofigAction;
import kingdom.gameitems.BoardCell;
import kingdom.gameitems.Castle;
import kingdom.gameitems.Const;
import kingdom.gameitems.Game;
import kingdom.gameitems.ItemLabel;
import kingdom.gameitems.Tile;
import kingdom.gameitems.User;
import kingdom.utiles.ListenerHelper;
import kingdom.utiles.MoneyManager;

/**
 * Main window of the game. The window will show all properties of <code>Game.java</code>
 */
public class MainWindow extends javax.swing.JFrame implements PropertyChangeListener{
    
    private final Game theGame = Game.getInstance();
    
    /* keeps all user JPanel object as value for User.NAME key */
    private final Map<String, UserPanel> userPanels = new HashMap<String, UserPanel>();

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
        createCellZone();
        
        // register listeners
        theGame.addPropertyChangeListener(this);
        
        redrawFreeTiles();
        redrawFreeCastles();
        updateBankMoneyLabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbltop1 = new javax.swing.JLabel();
        lblEpoch = new javax.swing.JLabel();
        jLabel_king = new javax.swing.JLabel();
        lblTopUserName = new javax.swing.JLabel();
        pnlTopGameInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblBankTotal = new javax.swing.JLabel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel3 = new javax.swing.JPanel();
        pnlGame = new javax.swing.JPanel();
        btnNextUser = new javax.swing.JButton();
        btnMoveUserItem = new javax.swing.JButton();
        pnlRight = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelCastles = new javax.swing.JPanel();
        panelTiles = new javax.swing.JPanel();
        usersTabbedPanel = new javax.swing.JTabbedPane();
        mnbTopMenu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        itemSaveGame = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        itemLoadGame = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        actNextUser = new javax.swing.JMenuItem();

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Kingdom");
        setPreferredSize(new java.awt.Dimension(800, 700));

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(751, 50));

        lbltop1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/epoch.png"))); // NOI18N

        lblEpoch.setFont(new java.awt.Font("Cantarell", 2, 24)); // NOI18N
        lblEpoch.setForeground(new java.awt.Color(255, 0, 198));
        lblEpoch.setText("0");

        jLabel_king.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/king.png"))); // NOI18N

        lblTopUserName.setFont(new java.awt.Font("Courier", 3, 18)); // NOI18N
        lblTopUserName.setForeground(new java.awt.Color(255, 0, 0));
        lblTopUserName.setText("...");

        jLabel1.setFont(new java.awt.Font("Cantarell", 2, 12)); // NOI18N
        jLabel1.setText("Banc money: ");

        lblBankTotal.setFont(new java.awt.Font("Cantarell", 3, 12)); // NOI18N
        lblBankTotal.setText("0");

        javax.swing.GroupLayout pnlTopGameInfoLayout = new javax.swing.GroupLayout(pnlTopGameInfo);
        pnlTopGameInfo.setLayout(pnlTopGameInfoLayout);
        pnlTopGameInfoLayout.setHorizontalGroup(
            pnlTopGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopGameInfoLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBankTotal)
                .addGap(0, 185, Short.MAX_VALUE))
        );
        pnlTopGameInfoLayout.setVerticalGroup(
            pnlTopGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTopGameInfoLayout.createSequentialGroup()
                .addGroup(pnlTopGameInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblBankTotal))
                .addGap(0, 29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbltop1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEpoch)
                .addGap(18, 18, 18)
                .addComponent(jLabel_king)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTopUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addComponent(pnlTopGameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(pnlTopGameInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTopUserName)
                    .addComponent(lblEpoch)
                    .addComponent(lbltop1)
                    .addComponent(jLabel_king))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jSplitPane1.setDividerLocation(550);

        jPanel3.setBackground(new java.awt.Color(190, 204, 249));
        jPanel3.setAutoscrolls(true);
        jPanel3.setMinimumSize(new java.awt.Dimension(450, 100));
        jPanel3.setPreferredSize(new java.awt.Dimension(600, 523));

        pnlGame.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        pnlGame.setLayout(new java.awt.GridLayout(5, 6, 3, 3));

        btnNextUser.setText("Next");
        btnNextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextUserActionPerformed(evt);
            }
        });

        btnMoveUserItem.setText("Move Item");
        btnMoveUserItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoveUserItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnNextUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMoveUserItem)
                .addGap(0, 358, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(pnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(pnlGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 440, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNextUser)
                    .addComponent(btnMoveUserItem)))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        pnlRight.setLayout(new java.awt.BorderLayout());

        jTabbedPane1.setBackground(new java.awt.Color(237, 236, 235));
        jTabbedPane1.addTab("Casles", panelCastles);
        jTabbedPane1.addTab("Tiles", panelTiles);

        pnlRight.add(jTabbedPane1, java.awt.BorderLayout.CENTER);
        pnlRight.add(usersTabbedPanel, java.awt.BorderLayout.SOUTH);

        jSplitPane1.setRightComponent(pnlRight);

        jPanel1.add(jSplitPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("File");

        itemSaveGame.setText("Save Game");
        itemSaveGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSaveGameActionPerformed(evt);
            }
        });
        jMenu1.add(itemSaveGame);

        jMenuItem2.setText("Save Game to ...");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        itemLoadGame.setText("Load Game");
        itemLoadGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLoadGameActionPerformed(evt);
            }
        });
        jMenu1.add(itemLoadGame);

        jMenuItem1.setText("Load Game from ...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        mnbTopMenu.add(jMenu1);

        jMenu2.setText("Start");

        jMenuItem3.setText("Start Game");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        actNextUser.setText("Next User (debug)");
        actNextUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actNextUserActionPerformed(evt);
            }
        });
        jMenu2.add(actNextUser);

        mnbTopMenu.add(jMenu2);

        setJMenuBar(mnbTopMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSaveGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSaveGameActionPerformed
        boolean isSaved = Game.getInstance().saveAllConfigs();
        if(isSaved){
            JOptionPane.showMessageDialog(this, "Configuration Saved");
        } else {
            JOptionPane.showMessageDialog(this, "Problem saving Configuration", null, JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_itemSaveGameActionPerformed

    private void itemLoadGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLoadGameActionPerformed
        // TODO add your handling code here:
        boolean loadResult = Game.getInstance().loadAllConfigs(null);
        //redrawTiles(); //aaa
        if(loadResult){
            JOptionPane.showMessageDialog(this, "Configuration Loaded");
        } else {
            JOptionPane.showMessageDialog(this, "Problem loading Configuration", null, JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_itemLoadGameActionPerformed

    private void actNextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actNextUserActionPerformed
        showNextUser();
    }//GEN-LAST:event_actNextUserActionPerformed

    private void btnNextUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextUserActionPerformed
        showNextUser();
    }//GEN-LAST:event_btnNextUserActionPerformed

    private void btnMoveUserItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoveUserItemActionPerformed

        MoveItemFromUserToBoard action = new MoveItemFromUserToBoard(this, theGame);
        ActionResult result = action.execute();
        if (result == ActionResult.SUCCESS) {

            //update user panel
            Component userTab = usersTabbedPanel.getSelectedComponent();
            if (userTab instanceof UserPanel) {
                UserPanel panel = (UserPanel) userTab;
                panel.refreshUserPanel();
            }
            showNextUser();
        }
    }//GEN-LAST:event_btnMoveUserItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        LoadCofigAction action = new LoadCofigAction(this, theGame);
        action.execute();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        SaveCofigAction action = new SaveCofigAction(this, theGame);
        action.execute();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        StartWizard startWizard = new StartWizard(this, true);
        startWizard.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actNextUser;
    private javax.swing.JButton btnMoveUserItem;
    private javax.swing.JButton btnNextUser;
    private javax.swing.JMenuItem itemLoadGame;
    private javax.swing.JMenuItem itemSaveGame;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_king;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblBankTotal;
    private javax.swing.JLabel lblEpoch;
    private javax.swing.JLabel lblTopUserName;
    private javax.swing.JLabel lbltop1;
    private javax.swing.JMenuBar mnbTopMenu;
    private javax.swing.JPanel panelCastles;
    private javax.swing.JPanel panelTiles;
    private javax.swing.JPanel pnlGame;
    private javax.swing.JPanel pnlRight;
    private javax.swing.JPanel pnlTopGameInfo;
    private javax.swing.JTabbedPane usersTabbedPanel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void dispose() {
        theGame.removePropertyChangeListener(this);
        super.dispose();
    }
    
    private void showNextUser() {
        User curUser = theGame.switchNextUser();
        
        if(curUser == null){
            return;
        }
        
        usersTabbedPanel.setSelectedIndex(theGame.getCurrentUserNumber());
        refreshPanelUserName();
    }

    /**
     * remove all components (cells) from game board. Create new game board grid based on Game.BoardCell[][]
     */
    private void createCellZone() {

        pnlGame.removeAll();
        BoardCell[][] cells = theGame.getBoardCells();

        for (BoardCell row[] : cells) {
            for (BoardCell cell : row) {
                pnlGame.add(cell);
            }
        }
        createNumericBorder();
        //pack();
        refreshAllCells();
    }
    
    /* draw numbers for columns and rows */
    private void createNumericBorder(){
        int cellSpace = 3;
        int beginOffset = 10;
        int cellOffset = 60;
        JLabel horLab;
        
        // set columns numeration
        for(int i = 1; i < 7; ++i){
            horLab = new JLabel(String.valueOf(i));
            int xIncrement = (i - 1) * (BoardCell.SIDE + cellSpace);
            horLab.setBounds(cellOffset + xIncrement, beginOffset, 20, 20);
            jPanel3.add(horLab);
        }
        
        // set rows numeration
        for(int i = 1; i < 6; ++i){
            horLab = new JLabel(String.valueOf(i));
            int yIncrement = (i - 1) * (BoardCell.SIDE + cellSpace);
            horLab.setBounds(beginOffset, (cellOffset + beginOffset) + yIncrement, 20, 20);
            jPanel3.add(horLab);
        }
    }
    
    private void redrawFreeTiles() {
        panelTiles.removeAll();
        ItemLabel tempLabel;
        for (Tile t : theGame.getFreeTiles()) {
            tempLabel = new ItemLabel();
            tempLabel.setItem(t);
            tempLabel.setIcon(t.getCoverIcon());
            tempLabel.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, Const.BG_DEFAULT_COLOR));
            ListenerHelper.addTileLabelListeners(tempLabel);
            panelTiles.add(tempLabel);
        }
        panelTiles.validate();
        panelTiles.repaint();
    }

    private void redrawFreeCastles(){
        panelCastles.removeAll();
        String iconPath;
        JLabel tempLabel;
        
         for(Castle c : theGame.getFreeCastles()){
            tempLabel = new JLabel();
            iconPath = "/res/24x24/" + String.valueOf(c.getColor()).toLowerCase().charAt(0) + String.valueOf(c.getRank()) + ".png";
            tempLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconPath)));
            panelCastles.add(tempLabel);
        }
        panelCastles.validate();
        panelCastles.repaint();
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String propName = evt.getPropertyName();
        if(Game.PROP_SET_CONFIG.equals(propName)){
            refreshAllParts();
        } else if (Game.PROP_BANK_WALET_CHANGED.equals(propName)){
            updateBankMoneyLabel();
        }
    }

    private void createUserPanels() {
        usersTabbedPanel.removeAll();
        UserPanel temp;
        
        for(User u : theGame.getActiveUsers()){
            temp = new UserPanel(u);
            usersTabbedPanel.addTab(temp.NAME, temp);
        }
        
        // open panel for active user
        usersTabbedPanel.setSelectedIndex(theGame.getCurrentUserNumber());
    }

    /**
     * update all cells in game board based on current cell content
     */
    private void refreshAllCells() {
        for(BoardCell[] row : theGame.getBoardCells()){
            for(BoardCell cell : row){
                cell.updateCell();
            }
        }
        pnlGame.repaint();
    }

    private void refreshEpoch() {
        // epoch is zero based
        int epoch = theGame.getEpoch() + 1;
        
        lblEpoch.setText(String.valueOf(epoch));
        lblEpoch.repaint();
    }
    
    private void refreshPanelUserName() {
        // epoch is zero based
        String userName = "";
        Color foreColor = new Color(0, 0, 0);

        User currentUser = theGame.getCurrentUser();
        if (currentUser != null) {
            userName = currentUser.getUserName();
            
            switch (currentUser.getColor()) {
                case RED:
                    foreColor = new Color(255, 0, 0);
                    break;
                case GREEN:
                    foreColor = new Color(0, 255, 0);
                    break;
                case BLUE:
                    foreColor = new Color(0, 0, 255);
                    break;
                case YELLOW:
                    foreColor = new Color(255, 255, 0);
                    break;
                default: {
                    Const.logErr(this, "Illegal State for user. Undefined color type");
                }
            }
        }

        lblTopUserName.setText(userName);
        lblTopUserName.setForeground(foreColor);

    }

    private void updateBankMoneyLabel() {
        int newTotal = MoneyManager.getTotal(theGame.getBankWallet());
        lblBankTotal.setText(String.valueOf(newTotal));
    }

    private void refreshAllParts() {
        redrawFreeTiles();
        redrawFreeCastles();
        createUserPanels();
        createCellZone();
        refreshEpoch();
        refreshPanelUserName();
        updateBankMoneyLabel();
    }

}
package cctv;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;

/**
 * @author CCTV
 */
public class Principal extends javax.swing.JFrame implements Runnable {

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    String HOME = System.getProperty("user.home");
    private Image dogImage;
    private SystemTray sysTray;
    private MenuItem item1;
    private MenuItem item2;
    private TrayIcon trayIcon;
    private PopupMenu menu;
    
    boolean estadoventana=false;

    public Principal() {
        initComponents();
        setIcon();
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        
        h1 = new Thread(this);
        h1.start();
        
        if (SystemTray.isSupported()) {
            sysTray = SystemTray.getSystemTray();
 
            //create dog image
            dogImage = Toolkit.getDefaultToolkit().getImage(""+HOME+"/Pictures/cctv_mojave/sun.png");
 
            //create popupmenu
            menu = new PopupMenu();
 
            //create item
            item1 = new MenuItem("Exit");
 
            item2 = new MenuItem("Show app");
            //add second item to popup menu
 
            //add actionListener to second menu item
            item2.addActionListener(new ActionListener()  {
 
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                }
            });
 
            //add item to menu
            menu.add(item2);
            menu.add(item1);
 
            //add action listener to the item in the popup menu
            item1.addActionListener(new ActionListener() {
 
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
 
 
 
            //create system tray icon.
            trayIcon = new TrayIcon(dogImage, "Dog App.", menu);
 
            //add the tray icon to the system tray.
            try {
                sysTray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("System Tray unsupported!");
            }
        }
        
        
    }

    private void setIcon() {
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/icons/sun.png")));
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        lbHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CCTV Dynamic Mojave");
        setResizable(false);

        lbHora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbHora.setForeground(new java.awt.Color(254, 254, 254));
        lbHora.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbHora.setText("jLabel1");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cctv/banner.png"))); // NOI18N

        jLayeredPane1.setLayer(lbHora, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbHora, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbHora)
                .addContainerGap())
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("?");

        jMenuItem2.setText("Acerca de");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbHora;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            
            calcula();
            EjecutarWallpaper();
            lbHora.setText(hora + ":" + minutos + " " + ampm);
            try {
                Thread.sleep(1200000);
            } catch (InterruptedException e) {
            }
        }
    }

    public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY) - 12;
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
        
        
    }
    
    public void EjecutarWallpaper(){
        
        Calendar c1 = Calendar.getInstance();
        // TODO code application logic here
        int Hora = (c1.get(Calendar.HOUR_OF_DAY));
        int Minuto = (c1.get(Calendar.MINUTE));
        int Segundo = (c1.get(Calendar.SECOND));
        System.err.println("Hora: "+Hora);
        String cmd = "halt"; //Comando de apagado en linux
        
        if(Hora<=6){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_1.jpeg";
        } else if(Hora>6&&Hora<=7){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_2.jpeg";
        } else if(Hora>7&&Hora<=8){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_3.jpeg";
        } else if(Hora>8&&Hora<=9){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_4.jpeg";
        }else if(Hora>9&&Hora<=10){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_5.jpeg";
        }else if(Hora>10&&Hora<=11){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_6.jpeg";
        }else if(Hora>11&&Hora<=12){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_7.jpeg";
        }else if(Hora>12&&Hora<=13){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_8.jpeg";
        }else if(Hora>13&&Hora<=14){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_9.jpeg";
        }else if(Hora>14&&Hora<=15){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_10.jpeg";
        }else if(Hora>15&&Hora<=16){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_11.jpeg";
        }else if(Hora>16&&Hora<=17){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_12.jpeg";
        }else if(Hora>17&&Hora<=18){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_13.jpeg";
        }else if(Hora>18&&Hora<=19){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_14.jpeg";
        }else if(Hora>19&&Hora<=20){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_15.jpeg";
        }else if(Hora>20){
            cmd="gsettings set org.gnome.desktop.background picture-uri file:////"+HOME+"/Pictures/cctv_mojave/mojave_dynamic_16.jpeg";
        }
        
        try {   
            Runtime.getRuntime().exec(cmd); 
        } catch (IOException ioe) {
            System.out.println (ioe);
        }
    }
    
}

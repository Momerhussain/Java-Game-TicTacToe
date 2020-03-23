package Tic;
import static Tic.check.name;
import static Tic.game.n1;
import static Tic.game.n2;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class play extends javax.swing.JFrame {
String a="X";
int p1count=0;
int p2count=0;
int p1points=0;
int p2points=0;
//String p1;
private Timer t;
private ActionListener al;
    public play() {
        initComponents();
        this.setLocationRelativeTo(null);
        score();

    }

    public void database(){
                try{
      
                   
          Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/mydata","omer","omer");
        PreparedStatement st=con.prepareStatement("insert into SCORE(Name,Score) values(?,?)");
       if(p1count==3){
           st.setString(1,n1);
           st.setInt(2,p1points);
       }
        else  if(p2count==3){
           st.setString(1,n2);
           st.setInt(2,p2points);
       }
       int a=st.executeUpdate();
       JOptionPane.showMessageDialog(null ,"saved");
       st.close();
       con.close();
          //jLabel3.setText(name+""+score);
        
                }
      catch(Exception d){
            System.out.println("error");
      }
    }
    
    
    
    
    
    
    
    
    private void time(){
       al=new ActionListener(){
            public void actionPerformed(ActionEvent ae){
             if(jProgressBar1.getValue() <100)
             {
                 jProgressBar1.setValue(jProgressBar1.getValue()+5);}
             else{t.stop();
          JOptionPane.showMessageDialog(null,"time over" );}
            // turn();
             }
        
            };
        t=new Timer(200,al);
}
    private void turn(){   
    
            if(a.equalsIgnoreCase("X")){
             a="O";   
             time();
            }
          else {
             a="X";
             time();
           }  
   }
    /* private void tie(){   
        String one=jButton1.getText();
        String two=jButton2.getText();
        String three=jButton3.getText();
        String four=jButton4.getText();
        String five=jButton5.getText();
        String six=jButton6.getText();
        String seven=jButton7.getText();
        String eight=jButton8.getText();
        String nine=jButton9.getText();
        if(one!="" && two!="" && three!="" && four!="" && five!=""&& six!="" && seven!="" && eight!="" && nine!="")
        {
          JOptionPane.showMessageDialog(null,"TIE" );
         
         reset();
        }
        
        
    }*/
   
    private void xwon(){
        JOptionPane.showMessageDialog(null,"player1 won" );
         p1count++;
       database();
         reset();
      
    }
    private void owon(){
        JOptionPane.showMessageDialog(null,"player2 won" );
        p2count++;
        database();
        reset();
        
       }
    
   
    private void reset(){
        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        
    jButton1.setEnabled(true);
    jButton2.setEnabled(true);
    jButton3.setEnabled(true);
    jButton4.setEnabled(true);
    jButton5.setEnabled(true);
    jButton6.setEnabled(true);
    jButton7.setEnabled(true);
    jButton8.setEnabled(true);
    jButton9.setEnabled(true);
    score();
    if(p1count==3){
        JOptionPane.showMessageDialog(null,"PLAYER 1 WON" );
    
    game obj= new game();
          
        obj.setVisible(true);
     this.dispose();
     obj.setLocationRelativeTo(null);
    
    }
    else if(p2count==3){
        JOptionPane.showMessageDialog(null,"PLAYER 2 WON" );
     
    game obj= new game();
          
        obj.setVisible(true);
     this.dispose();
     obj.setLocationRelativeTo(null);
    }
    }
    
    public void score(){
       jLabel3.setText(n1+" game won : "+String.valueOf(p1count));
       jLabel4.setText(n2+" game won : "+String.valueOf(p2count));
  jLabel5.setText(n1+" points : "+String.valueOf(p1points));
jLabel6.setText(n2+" points : "+String.valueOf(p2points));  
    }
    
    
    
    public void win(){
        String one=jButton1.getText();
        String two=jButton2.getText();
        String three=jButton3.getText();
        String four=jButton4.getText();
        String five=jButton5.getText();
        String six=jButton6.getText();
        String seven=jButton7.getText();
        String eight=jButton8.getText();
        String nine=jButton9.getText();
        
        if(one=="X"&&two=="X"&&three=="X"){
            p1points=p1points+100; 
            xwon();
         
          }
          if(four=="X"&&five=="X"&&six=="X"){
            p1points=p1points+100; 
              xwon();
          
            
        }
            if(seven=="X"&&eight=="X"&&nine=="X"){
            p1points=p1points+100; 
                xwon();
           
        }
              if(one=="X"&&four=="X"&&seven=="X"){
            p1points=p1points+150; 
                  xwon();
            
        }
                if(two=="X"&&five=="X"&&eight=="X"){
            p1points=p1points+150;
                    xwon();
           
        }
                  if(three=="X"&&six=="X"&&nine=="X"){
            p1points=p1points+150;
                      xwon();
          
        }
                    if(one=="X"&&five=="X"&&nine=="X"){
            p1points=p1points+200;
                        xwon();
           
        }
                      if(three=="X"&&five=="X"&&seven=="X"){
            p1points=p1points+200;
                          xwon();
           
        }
            
                      
                      
            if(one=="O"&&two=="O"&&three=="O"){
            p2points=p2points+100;
                owon();
            
        }
          if(four=="O"&&five=="O"&&six=="O"){
            p2points=p2points+100;
              owon();
            
        }
            if(seven=="O"&&eight=="O"&&nine=="O"){
            p2points=p2points+100;
                owon();
            
        }
              if(one=="O"&&four=="O"&&seven=="O"){
           p2points=p2points+150;
                  
                  owon();
            
        }
                if(two=="O"&&five=="O"&&eight=="O"){
            p2points=p2points+150;
                    owon();
            
        }
                  if(three=="O"&&six=="O"&&nine=="O"){
            p2points=p2points+150;
                      owon();
            
        }
                    if(one=="O"&&five=="O"&&nine=="O"){
            p2points=p2points+200;
                        owon();
            
        }
                      if(three=="O"&&five=="O"&&seven=="O"){
            p2points=p2points+200;
                          owon();
            
        }
       else if(one!="" && two!="" && three!="" && four!="" && five!=""&& six!="" && seven!="" && eight!="" && nine!="" )
                   
        {
          JOptionPane.showMessageDialog(null,"TIE" );
         p2points=p2points+75;
         p1points=p1points+75;
         reset();
        }               
              
    }  /*                
       private void tie(){
        JOptionPane.showMessageDialog(null,"TIE" );
        reset();
        }
        public void nowin(){
        String one=jButton1.getText();
        String two=jButton2.getText();
        String three=jButton3.getText();
        String four=jButton4.getText();
        String five=jButton5.getText();
        String six=jButton6.getText();
        String seven=jButton7.getText();
        String eight=jButton8.getText();
        String nine=jButton9.getText();
       
                if(one!="X"&&two!="X"&&three!="X"){
             tie();
         
          }
          if(four!="X"&&five!="X"&&six!="X"){
            tie();
          
            
        }
            if(seven!="X"&&eight!="X"&&nine!="X"){
            tie();
           
        }
              if(one!="X"&&four!="X"&&seven!="X"){
            tie();
            
        }
                if(two!="X"&&five!="X"&&eight!="X"){
            tie();
           
        }
                  if(three!="X"&&six!="X"&&nine!="X"){
            tie();
          
        }
                    if(one!="X"&&five!="X"&&nine!="X"){
            tie();
           
        }
                      if(three!="X"&&five!="X"&&seven!="X"){
            tie();
           
        }
             
                      
                      
            if(one!="O"&&two!="O"&&three!="O"){
            tie();
            
        }
          if(four!="O"&&five!="O"&&six!="O"){
            tie();
            
        }
            if(seven!="O"&&eight!="O"&&nine!="O"){
            tie();
            
        }
              if(one!="O"&&four!="O"&&seven!="O"){
            tie();
            
        }
                if(two!="O"&&five!="O"&&eight!="O"){
            tie();
            
        }
                  if(three!="O"&&six!="O"&&nine!="O"){
            tie(); 
            
        }
                    if(one!="O"&&five!="O"&&nine!="O"){
            tie();
            
        }
                      if(three!="O"&&five!="O"&&seven!="O"){
            tie();
            
        }

    }*/
    



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGrid = new javax.swing.JPanel();
        jPanelgrid2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelGrid.setLayout(new java.awt.GridLayout(1, 0));

        jPanelgrid2.setLayout(new java.awt.GridLayout(3, 3, 1, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton1.setText(" ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel5);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.BorderLayout());

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton6, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel6);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton7, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel7);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton8, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel9.add(jButton9, java.awt.BorderLayout.CENTER);

        jPanelgrid2.add(jPanel9);

        jPanelGrid.add(jPanelgrid2);

        jLabel1.setText("Player X:");

        jLabel2.setText("Player O:");

        jButton10.setText("Reset");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(24, 24, 24))
        );

        jProgressBar1.setOpaque(true);

        jButton11.setText("jButton11");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jButton11)))
                        .addContainerGap(152, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      jButton1.setText(a);
      if(a.equalsIgnoreCase("X")){
          jButton1.setForeground(Color.red);
      jButton1.setEnabled(false);
      }
      else{
          jButton1.setForeground(Color.blue);
      jButton1.setEnabled(false);
      }
        
      turn();
      win();
      //tie();
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       jButton2.setText(a);
      if(a.equalsIgnoreCase("X")){
          jButton2.setForeground(Color.red);
      jButton2.setEnabled(false);
      }
      else{
          jButton2.setForeground(Color.blue);
      jButton2.setEnabled(false);
      }
       turn();
       win();
       //tie();
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       jButton3.setText(a);
        if(a.equalsIgnoreCase("X")){
          jButton3.setForeground(Color.red);
      jButton3.setEnabled(false);
        }
      else{
          jButton3.setForeground(Color.blue);
      jButton3.setEnabled(false);
        }
       turn();
        win();
      //tie();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setText(a);
        if(a.equalsIgnoreCase("X")){
          jButton4.setForeground(Color.red);
      jButton4.setEnabled(false);
        }
      else{
          jButton4.setForeground(Color.blue);
      jButton4.setEnabled(false);
        }
        turn();
        win();
      //tie();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
      jButton5.setText(a);
         if(a.equalsIgnoreCase("X")){
          jButton5.setForeground(Color.red);
      jButton5.setEnabled(false);
         }
      else{
          jButton5.setForeground(Color.blue);
      jButton5.setEnabled(false);
         }
      turn();
      win();
      //tie();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      jButton6.setText(a);
        if(a.equalsIgnoreCase("X")){
          jButton6.setForeground(Color.red);
      jButton6.setEnabled(false);
        }
      else{
          jButton6.setForeground(Color.blue);
      jButton6.setEnabled(false);
        }
      turn();
      win();
      //tie();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      jButton7.setText(a);
         if(a.equalsIgnoreCase("X")){
          jButton7.setForeground(Color.red);
      jButton7.setEnabled(false);
         }
      else{
          jButton7.setForeground(Color.blue);
      jButton7.setEnabled(false);
         }
      turn();
      win();
     // tie();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
      jButton8.setText(a);
         if(a.equalsIgnoreCase("X")){
          jButton8.setForeground(Color.red);
      jButton8.setEnabled(false);
         }
      else{
          jButton8.setForeground(Color.blue);
      jButton8.setEnabled(false);
         }
      turn();
      win();
      //tie();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
      jButton9.setText(a);
        if(a.equalsIgnoreCase("X")){
          jButton9.setForeground(Color.red);
      jButton9.setEnabled(false);
        }
      else{
          jButton9.setForeground(Color.blue);
      jButton9.setEnabled(false);
        }
      turn();
      win();
      //tie();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        reset();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        
        time();
        t.start();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(play.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new play().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelGrid;
    private javax.swing.JPanel jPanelgrid2;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables

}

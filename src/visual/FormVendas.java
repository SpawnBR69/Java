/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import dao.DAOCliente;
import dao.DAOFuncionario;
import dao.DAOVenda;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Venda;

/**
 *
 * @author igorm
 */
public class FormVendas extends javax.swing.JDialog {
    private DAOVenda dao = new DAOVenda();
    private DAOCliente daoC = new DAOCliente();
    private DAOFuncionario daoF = new DAOFuncionario();
    /**
     * Creates new form FormVendas
     */
    public FormVendas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lstCliente.clear();
        lstCliente.addAll(daoC.getLista());
        lstFuncionario.clear();
        lstFuncionario.addAll(daoF.getLista());
        trataEdicao(false);
        atualizaTabela();
    }
    public boolean validaCampos() {
        if ((txtData.getText().length() > 0)) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            try {
                sdf.parse(txtData.getText());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Informe a data de nascimento");
                txtData.requestFocus();
                return false;
            }
        }
        if (!(cbxIdFuncionario.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Funcionario!");
            cbxIdFuncionario.requestFocus();
            return false;
        }
        if (!(cbxIdCliente.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Cliente!");
            cbxIdCliente.requestFocus();
            return false;
        }
        return true;
    }
    public void atualizaTabela(){
        lstConsulta.clear();
        lstConsulta.addAll(dao.getLista());
        int linha = lstConsulta.size() - 1;
        if (linha >= 0) {
            tblDadosCadastrais.setRowSelectionInterval(linha, linha);
            tblDadosCadastrais.scrollRectToVisible(
                    tblDadosCadastrais.getCellRect(linha, linha, true)
            );
        }        
    }
    private void trataEdicao(boolean editanto){
        btnCancelar.setEnabled(editanto);
        btnSalvar.setEnabled(editanto);
        btnEditar.setEnabled(!editanto);
        btnExcluir.setEnabled(!editanto);
        btnNovo.setEnabled(!editanto);
        btnPrimeiro.setEnabled(!editanto);
        btnProximo.setEnabled(!editanto);
        btnAnterior.setEnabled(!editanto);
        btnUltimo.setEnabled(!editanto);
        cbxIdFuncionario.setEnabled(editanto);
        cbxIdCliente.setEnabled(editanto);
        txtData.setEnabled(editanto);
        txtValor.setEnabled(editanto);
        tblDadosCadastrais.setEnabled(!editanto);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstFuncionario = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Funcionario>())
        ;
        lstCliente = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Cliente>())
        ;
        lstConsulta = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<>())
        ;
        converterData1 = new visual.ConverterData();
        converterData2 = new visual.ConverterData();
        pnlNavegacao = new javax.swing.JPanel();
        btnPrimeiro = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        btnProximo = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        pnlPrincipal = new javax.swing.JTabbedPane();
        pnlListagem = new javax.swing.JPanel();
        pnlAux = new javax.swing.JScrollPane();
        tblDadosCadastrais = new javax.swing.JTable();
        pnlDados = new javax.swing.JPanel();
        txtID = new javax.swing.JTextField();
        cbxIdFuncionario = new javax.swing.JComboBox<>();
        cbxIdCliente = new javax.swing.JComboBox<>();
        txtValor = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblIdFuncionario = new javax.swing.JLabel();
        lblIdCliente = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        btnIDV = new javax.swing.JButton();
        pnlAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        javax.swing.text.MaskFormatter maskData = null;
        try {
            maskData = new javax.swing.text.MaskFormatter("##/##/####");
            maskData.setPlaceholderCharacter('_');
        } catch (Exception e){}
        txtData = new javax.swing.JFormattedTextField(maskData);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlNavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Navega????o"));
        pnlNavegacao.setLayout(new java.awt.GridLayout(1, 0));

        btnPrimeiro.setText("Primeiro");
        btnPrimeiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimeiroActionPerformed(evt);
            }
        });
        pnlNavegacao.add(btnPrimeiro);

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        pnlNavegacao.add(btnAnterior);

        btnProximo.setText("Pr??ximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        pnlNavegacao.add(btnProximo);

        btnUltimo.setText("??ltimo");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        pnlNavegacao.add(btnUltimo);

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });
        pnlNavegacao.add(btnFechar);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstConsulta, tblDadosCadastrais);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idVenda}"));
        columnBinding.setColumnName("Id Venda");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idCliente}"));
        columnBinding.setColumnName("Id Cliente");
        columnBinding.setColumnClass(modelo.Cliente.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFuncionario}"));
        columnBinding.setColumnName("Id Funcionario");
        columnBinding.setColumnClass(modelo.Funcionario.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nascimentoFormatado}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        pnlAux.setViewportView(tblDadosCadastrais);

        javax.swing.GroupLayout pnlListagemLayout = new javax.swing.GroupLayout(pnlListagem);
        pnlListagem.setLayout(pnlListagemLayout);
        pnlListagemLayout.setHorizontalGroup(
            pnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAux, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        pnlListagemLayout.setVerticalGroup(
            pnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAux, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pnlPrincipal.addTab("Listagem", pnlListagem);

        txtID.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idVenda}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstFuncionario, cbxIdFuncionario);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idFuncionario}"), cbxIdFuncionario, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        cbxIdFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxIdFuncionarioActionPerformed(evt);
            }
        });

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstCliente, cbxIdCliente);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idCliente}"), cbxIdCliente, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.valor}"), txtValor, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblID.setText("ID:");

        lblIdFuncionario.setText("Funcionario:");

        lblIdCliente.setText("CLiente:");

        lblData.setText("Data:");

        lblValor.setText("Valor:");

        btnIDV.setText("Adicionar Itens ?? Venda");
        btnIDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDVActionPerformed(evt);
            }
        });

        pnlAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("A????es"));
        pnlAcoes.setLayout(new java.awt.GridLayout(1, 0));

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });
        pnlAcoes.add(btnNovo);

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        pnlAcoes.add(btnEditar);

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        pnlAcoes.add(btnSalvar);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlAcoes.add(btnCancelar);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        pnlAcoes.add(btnExcluir);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.data}"), txtData, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setConverter(converterData1);
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(lblID))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDadosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblValor, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblData, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIdCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblIdFuncionario, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addComponent(cbxIdFuncionario, 0, 232, Short.MAX_VALUE)
                    .addComponent(btnIDV)
                    .addComponent(cbxIdCliente, 0, 232, Short.MAX_VALUE)
                    .addComponent(txtValor)
                    .addComponent(txtData))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addComponent(pnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxIdFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdFuncionario))
                .addGap(10, 10, 10)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblData)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnIDV)
                .addGap(162, 162, 162))
        );

        pnlPrincipal.addTab("Dados", pnlDados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNavegacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPrincipal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlNavegacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPrincipal))
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProximoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProximoActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "N??o foi encontrado registro!!!");
        }else{
        int linha = tblDadosCadastrais.getSelectedRow();
        if ((linha + 1) <= (tblDadosCadastrais.getRowCount() - 1)) {
            linha++;
        }
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(linha, 0, true));
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void cbxIdFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxIdFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxIdFuncionarioActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "N??o foi encontrado registro!!!");
        }else{
        int linhaSelecionada = tblDadosCadastrais.getSelectedRow();
        Venda obj =  lstConsulta.get(linhaSelecionada);
        dao.deletar(obj);
        this.atualizaTabela();
        trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        lstConsulta.add(new Venda());
        int linha = lstConsulta.size() - 1;
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        cbxIdFuncionario.requestFocus(); 
        trataEdicao(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "N??o foi encontrado registro!!!");
        }else{
            cbxIdFuncionario.requestFocus();
            trataEdicao(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(validaCampos()){
            int linhaSelecionada = tblDadosCadastrais.getSelectedRow();
            Venda obj = lstConsulta.get(linhaSelecionada);
            dao.salvar(obj);
            this.atualizaTabela();
            trataEdicao(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.atualizaTabela();
        trataEdicao(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
       if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "N??o foi encontrado registro!!!");
        }else{
        tblDadosCadastrais.setRowSelectionInterval(0, 0);
       tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(0, 0, true));
       }
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "N??o foi encontrado registro!!!");
        }else{
        int linha = tblDadosCadastrais.getSelectedRow();
        if ((linha - 1) >= 0) {
            linha--;
        }
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(linha, 0, true));
        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "N??o foi encontrado registro!!!");
        }else{
        int linha = tblDadosCadastrais.getRowCount() - 1;
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(linha, 0, true));
        }
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnIDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDVActionPerformed
        FormItensDaVenda form = new FormItensDaVenda(null, true);
        form.setTitle("Adicione Os Itens!");
        form.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
    }//GEN-LAST:event_btnIDVActionPerformed

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
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormVendas dialog = new FormVendas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnIDV;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbxIdCliente;
    private javax.swing.JComboBox<String> cbxIdFuncionario;
    private visual.ConverterData converterData1;
    private visual.ConverterData converterData2;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdCliente;
    private javax.swing.JLabel lblIdFuncionario;
    private javax.swing.JLabel lblValor;
    private java.util.List<Cliente> lstCliente;
    private java.util.List<Venda> lstConsulta;
    private java.util.List<Funcionario> lstFuncionario;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JScrollPane pnlAux;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlListagem;
    private javax.swing.JPanel pnlNavegacao;
    private javax.swing.JTabbedPane pnlPrincipal;
    private javax.swing.JTable tblDadosCadastrais;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtValor;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

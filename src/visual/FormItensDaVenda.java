/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import dao.DAOItensDaVenda;
import dao.DAOProduto;
import dao.DAOVenda;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import modelo.ItensDaVenda;
import modelo.Produto;
import modelo.Venda;

/**
 *
 * @author igorm
 */
public class FormItensDaVenda extends javax.swing.JDialog {
    DAOItensDaVenda dao = new DAOItensDaVenda();
    DAOVenda daoV = new DAOVenda();
    DAOProduto daoP = new DAOProduto();
    /**
     * Creates new form FormItensDaVenda
     */
    public FormItensDaVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lstProduto.clear();
        lstProduto.addAll(daoP.getLista());
        lstVenda.clear();
        lstVenda.addAll(daoV.getLista());
        trataEdicao(false);
        btnEditar.setEnabled(false);
        atualizaTabela();
    }
    private void trataEdicao(boolean editanto){
        btnCancelar.setEnabled(editanto);
        btnSalvar.setEnabled(editanto);
        btnExcluir.setEnabled(!editanto);
        btnNovo.setEnabled(!editanto);
        btnPrimeiro.setEnabled(!editanto);
        btnProximo.setEnabled(!editanto);
        btnAnterior.setEnabled(!editanto);
        btnUltimo.setEnabled(!editanto);
        cbxIdVenda.setEnabled(editanto);
        cbxIdProduto.setEnabled(editanto);
        txtQtdProduto.setEnabled(editanto);
        txtSubTotal.setEnabled(editanto);
        tblDadosCadastrais.setEnabled(!editanto);
    }
    public boolean validaCampos() {
        if (!(txtSubTotal.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Valor!");
            txtSubTotal.requestFocus();
            return false;
        }
        if (!(txtQtdProduto.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a Data!");
            txtQtdProduto.requestFocus();
            return false;
        }
        if (!(cbxIdProduto.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Funcionario!");
            cbxIdProduto.requestFocus();
            return false;
        }
        if (!(cbxIdVenda.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Cliente!");
            cbxIdVenda.requestFocus();
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        lstConsulta = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<>())
        ;
        lstVenda = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<>());
        lstProduto = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<>());
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
        pnlAcoes = new javax.swing.JPanel();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        cbxIdVenda = new javax.swing.JComboBox<>();
        cbxIdProduto = new javax.swing.JComboBox<>();
        txtQtdProduto = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblIdVendas = new javax.swing.JLabel();
        lblIdProduto = new javax.swing.JLabel();
        lblQtdProd = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        txtSubTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlNavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Navegação"));
        pnlNavegacao.setLayout(new java.awt.GridLayout());

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

        btnProximo.setText("Próximo");
        btnProximo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProximoActionPerformed(evt);
            }
        });
        pnlNavegacao.add(btnProximo);

        btnUltimo.setText("Último");
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
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idIDV}"));
        columnBinding.setColumnName("Id IDV");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduto}"));
        columnBinding.setColumnName("Id Produto");
        columnBinding.setColumnClass(modelo.Produto.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idVendas}"));
        columnBinding.setColumnName("Id Vendas");
        columnBinding.setColumnClass(modelo.Venda.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtdProd}"));
        columnBinding.setColumnName("Qtd Prod");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${subTotal}"));
        columnBinding.setColumnName("Sub Total");
        columnBinding.setColumnClass(Double.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        pnlAux.setViewportView(tblDadosCadastrais);

        javax.swing.GroupLayout pnlListagemLayout = new javax.swing.GroupLayout(pnlListagem);
        pnlListagem.setLayout(pnlListagemLayout);
        pnlListagemLayout.setHorizontalGroup(
            pnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAux, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        pnlListagemLayout.setVerticalGroup(
            pnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAux, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        pnlPrincipal.addTab("Listagem", pnlListagem);

        pnlAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
        pnlAcoes.setLayout(new java.awt.GridLayout());

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

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idIDV}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstVenda, cbxIdVenda);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idVendas}"), cbxIdVenda, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstProduto, cbxIdProduto);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idProduto}"), cbxIdProduto, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        cbxIdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbxIdProdutoFocusLost(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qtdProd}"), txtQtdProduto, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtQtdProduto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtQtdProdutoFocusLost(evt);
            }
        });

        lblID.setText("ID:");

        lblIdVendas.setText("ID da Venda:");

        lblIdProduto.setText("ID do Produto:");

        lblQtdProd.setText("Quantidade do Produto:");

        lblSubTotal.setText("Sub Total:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.subTotal}"), txtSubTotal, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblQtdProd)
                    .addComponent(lblIdVendas)
                    .addComponent(lblID)
                    .addComponent(lblIdProduto)
                    .addComponent(lblSubTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtQtdProduto)
                    .addComponent(cbxIdProduto, 0, 279, Short.MAX_VALUE)
                    .addComponent(cbxIdVenda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtID)
                    .addComponent(txtSubTotal))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addComponent(pnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxIdVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdVendas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxIdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtdProd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubTotal)
                    .addComponent(txtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 229, Short.MAX_VALUE))
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
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
        int linha = tblDadosCadastrais.getSelectedRow();
        if ((linha + 1) <= (tblDadosCadastrais.getRowCount() - 1)) {
            linha++;
        }
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(linha, 0, true));
        }
    }//GEN-LAST:event_btnProximoActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        lstConsulta.add(new ItensDaVenda());
        int linha = lstConsulta.size() - 1;
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        cbxIdVenda.requestFocus(); 
        trataEdicao(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
            cbxIdVenda.requestFocus();
            trataEdicao(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(validaCampos()){
            int linhaSelecionada = tblDadosCadastrais.getSelectedRow();
            ItensDaVenda obj = lstConsulta.get(linhaSelecionada);
            obj.getIdVendas().setValor(obj.getIdVendas().getValor() + obj.getSubTotal());
            obj.getIdProduto().setQtdEstoque(obj.getIdProduto().getQtdEstoque() - obj.getQtdProd());
            dao.salvar(obj);
            daoV.salvar(obj.getIdVendas());
            daoP.salvar(obj.getIdProduto());
            this.atualizaTabela();
            trataEdicao(false);
        }
        
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.atualizaTabela();
        trataEdicao(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
        int linhaSelecionada = tblDadosCadastrais.getSelectedRow();
        ItensDaVenda obj =  lstConsulta.get(linhaSelecionada);
        obj.getIdVendas().setValor(obj.getIdVendas().getValor() - obj.getSubTotal());
        obj.getIdProduto().setQtdEstoque(obj.getIdProduto().getQtdEstoque() + obj.getQtdProd());
        dao.deletar(obj);
        daoV.salvar(obj.getIdVendas());
        daoP.salvar(obj.getIdProduto());
        this.atualizaTabela();
        trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPrimeiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimeiroActionPerformed
       if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
        tblDadosCadastrais.setRowSelectionInterval(0, 0);
       tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(0, 0, true));
       }
    }//GEN-LAST:event_btnPrimeiroActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
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
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
        int linha = tblDadosCadastrais.getRowCount() - 1;
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        tblDadosCadastrais.scrollRectToVisible(tblDadosCadastrais.getCellRect(linha, 0, true));
        }
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void txtQtdProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtQtdProdutoFocusLost
        if(cbxIdProduto.getSelectedIndex()>=0){
        Produto obj = (Produto) cbxIdProduto.getSelectedItem();
        Integer int1=Integer.parseInt(txtQtdProduto.getText());
        txtSubTotal.setText(""+obj.getPreco()*int1);
        }
    }//GEN-LAST:event_txtQtdProdutoFocusLost

    private void cbxIdProdutoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbxIdProdutoFocusLost
        if(cbxIdProduto.getSelectedIndex()>=0){
        Produto obj = (Produto) cbxIdProduto.getSelectedItem();
        Integer int1=Integer.parseInt(txtQtdProduto.getText());
        txtSubTotal.setText(""+obj.getPreco()*int1);
        }
    }//GEN-LAST:event_cbxIdProdutoFocusLost

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
            java.util.logging.Logger.getLogger(FormItensDaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormItensDaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormItensDaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormItensDaVenda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormItensDaVenda dialog = new FormItensDaVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPrimeiro;
    private javax.swing.JButton btnProximo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox<String> cbxIdProduto;
    private javax.swing.JComboBox<String> cbxIdVenda;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdProduto;
    private javax.swing.JLabel lblIdVendas;
    private javax.swing.JLabel lblQtdProd;
    private javax.swing.JLabel lblSubTotal;
    private java.util.List<ItensDaVenda> lstConsulta;
    private java.util.List<Produto> lstProduto;
    private java.util.List<Venda> lstVenda;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JScrollPane pnlAux;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlListagem;
    private javax.swing.JPanel pnlNavegacao;
    private javax.swing.JTabbedPane pnlPrincipal;
    private javax.swing.JTable tblDadosCadastrais;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtQtdProduto;
    private javax.swing.JTextField txtSubTotal;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}

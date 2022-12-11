/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import dao.DAOProduto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Fornecedor;
import modelo.Produto;
import dao.DAOFornecedor;

/**
 *
 * @author igorm
 */
public class FormProduto extends javax.swing.JDialog {
    private DAOProduto dao = new DAOProduto();
    private DAOFornecedor dao1 = new DAOFornecedor();
    /**
     * Creates new form FormProduto
     */
    public FormProduto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        lstFornecedor.clear();
        lstFornecedor.addAll(dao1.getLista());
        atualizaTabela();
        trataEdicao(false);
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
        txtNome.setEnabled(editanto);
        cbxIdFornecedor.setEnabled(editanto);
        txtPreco.setEnabled(editanto);
        txtQtdEstoque.setEnabled(editanto);
        txtUnidade.setEnabled(editanto);
        tblDadosCadastrais.setEnabled(!editanto);
    }
        public boolean validaCampos() {
        if (!(txtNome.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o nome!");
            txtNome.requestFocus();
            return false;
        }
        if (!(txtPreco.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Preço!");
            txtPreco.requestFocus();
            return false;
        }
        if (!(txtQtdEstoque.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Quantidade em Estoque!");
            txtQtdEstoque.requestFocus();
            return false;
        }
        if (!(txtUnidade.getText().length() > 0)) {
            JOptionPane.showMessageDialog(null, "Informe a Unidade!");
            txtUnidade.requestFocus();
            return false;
        }
        if (!(cbxIdFornecedor.getSelectedIndex() >= 0)) {
            JOptionPane.showMessageDialog(null, "Informe o Fornecedor!");
            cbxIdFornecedor.requestFocus();
            return false;
        }
        return true;
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

        lstConsulta = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Produto>())
        ;
        lstFornecedor = org.jdesktop.observablecollections.ObservableCollections.observableList(new ArrayList<Fornecedor>())
        ;
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
        txtNome = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtQtdEstoque = new javax.swing.JTextField();
        txtUnidade = new javax.swing.JTextField();
        lblID = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblIdFornecedor = new javax.swing.JLabel();
        lblPreco = new javax.swing.JLabel();
        lblQtdEstoques = new javax.swing.JLabel();
        lblUnidade = new javax.swing.JLabel();
        cbxIdFornecedor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlNavegacao.setBorder(javax.swing.BorderFactory.createTitledBorder("Navegação"));
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
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idProduto}"));
        columnBinding.setColumnName("Id Produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nome}"));
        columnBinding.setColumnName("Nome");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${idFornecedor}"));
        columnBinding.setColumnName("Id Fornecedor");
        columnBinding.setColumnClass(modelo.Fornecedor.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${preco}"));
        columnBinding.setColumnName("Preco");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtdEstoque}"));
        columnBinding.setColumnName("Qtd Estoque");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${unidade}"));
        columnBinding.setColumnName("Unidade");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        pnlAux.setViewportView(tblDadosCadastrais);

        javax.swing.GroupLayout pnlListagemLayout = new javax.swing.GroupLayout(pnlListagem);
        pnlListagem.setLayout(pnlListagemLayout);
        pnlListagemLayout.setHorizontalGroup(
            pnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAux, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
        );
        pnlListagemLayout.setVerticalGroup(
            pnlListagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlListagemLayout.createSequentialGroup()
                .addComponent(pnlAux, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlPrincipal.addTab("Listagem", pnlListagem);

        pnlAcoes.setBorder(javax.swing.BorderFactory.createTitledBorder("Ações"));
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

        txtID.setEditable(false);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idProduto}"), txtID, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nome}"), txtNome, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.preco}"), txtPreco, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qtdEstoque}"), txtQtdEstoque, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        txtQtdEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtdEstoqueActionPerformed(evt);
            }
        });

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.unidade}"), txtUnidade, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        lblID.setText("ID:");

        lblNome.setText("Nome:");

        lblIdFornecedor.setText("ID do Fornecedor:");

        lblPreco.setText("Preço:");

        lblQtdEstoques.setText("Quantidade em Estoque:");

        lblUnidade.setText("Unidade:");

        org.jdesktop.swingbinding.JComboBoxBinding jComboBoxBinding = org.jdesktop.swingbinding.SwingBindings.createJComboBoxBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, lstFornecedor, cbxIdFornecedor);
        bindingGroup.addBinding(jComboBoxBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tblDadosCadastrais, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.idFornecedor}"), cbxIdFornecedor, org.jdesktop.beansbinding.BeanProperty.create("selectedItem"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout pnlDadosLayout = new javax.swing.GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAcoes, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblID)
                    .addComponent(lblNome)
                    .addComponent(lblIdFornecedor)
                    .addComponent(lblPreco)
                    .addComponent(lblQtdEstoques)
                    .addComponent(lblUnidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNome)
                    .addComponent(txtID)
                    .addComponent(txtPreco)
                    .addComponent(txtQtdEstoque)
                    .addComponent(txtUnidade)
                    .addComponent(cbxIdFornecedor, 0, 206, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addComponent(pnlAcoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdFornecedor)
                    .addComponent(cbxIdFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQtdEstoques))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUnidade))
                .addGap(0, 225, Short.MAX_VALUE))
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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.atualizaTabela();
        trataEdicao(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
        int linhaSelecionada = tblDadosCadastrais.getSelectedRow();
        Produto obj =  lstConsulta.get(linhaSelecionada);
        dao.deletar(obj);
        this.atualizaTabela();
        trataEdicao(false);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

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

    private void txtQtdEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtdEstoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtdEstoqueActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        lstConsulta.add(new Produto());
        int linha = lstConsulta.size() - 1;
        tblDadosCadastrais.setRowSelectionInterval(linha, linha);
        txtNome.requestFocus(); 
        trataEdicao(true);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(tblDadosCadastrais.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Não foi encontrado registro!!!");
        }else{
            txtNome.requestFocus();
            trataEdicao(true);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if(validaCampos()){
            int linhaSelecionada = tblDadosCadastrais.getSelectedRow();
            Produto obj = lstConsulta.get(linhaSelecionada);
            dao.salvar(obj);
            this.atualizaTabela();
            trataEdicao(false);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

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

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

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
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormProduto dialog = new FormProduto(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbxIdFornecedor;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdFornecedor;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JLabel lblQtdEstoques;
    private javax.swing.JLabel lblUnidade;
    private java.util.List<Produto> lstConsulta;
    private java.util.List<Fornecedor> lstFornecedor;
    private javax.swing.JPanel pnlAcoes;
    private javax.swing.JScrollPane pnlAux;
    private javax.swing.JPanel pnlDados;
    private javax.swing.JPanel pnlListagem;
    private javax.swing.JPanel pnlNavegacao;
    private javax.swing.JTabbedPane pnlPrincipal;
    private javax.swing.JTable tblDadosCadastrais;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtdEstoque;
    private javax.swing.JTextField txtUnidade;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
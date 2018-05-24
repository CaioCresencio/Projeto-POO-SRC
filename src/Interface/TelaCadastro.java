package Interface;

import usuario.Cadastro;
import usuario.User;
import usuario.Usuario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class TelaCadastro {
    private JTextField fieldEmail;
    private JTextField fieldNome;
    private JTextField fieldSenha;
    private JLabel labelEmail;
    private JPanel painelPrincipal;
    private JLabel labelNome;
    private JLabel labelSenha;
    private JLabel labelCadastro;
    private JButton botaoCadastro;
    private JButton voltarButton;
    private JPanel painelBotao;

    public TelaCadastro(Cadastro banco){
        botaoCadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = fieldNome.getText();
                String email= fieldEmail.getText();
                String senha = fieldSenha.getText();
                if(banco.autenticarEmail(email)){
                    if(banco.procuraEmail(email) == null) {
                        banco.newCadastro(new Usuario(nome, email, senha));
                        JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
                    }else{
                        JOptionPane.showMessageDialog(null,"E-mail ja cadastrado!");
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"E-mail invalido!");
                }
            }
        });
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    public JPanel getPainelPrincipal(){
        return painelPrincipal;
    }
}

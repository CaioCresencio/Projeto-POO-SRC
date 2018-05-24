package Interface;

import usuario.Cadastro;
import usuario.User;
import usuario.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JTextField fieldEmail;
    private JButton loginButton;
    private JLabel labelEmail;
    private JFormattedTextField fieldSenha;
    private JPanel painel;
    private Cadastro banco;
    private int tentativas;

    public Login(Cadastro banco){

        int i;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = fieldEmail.getText();
                String senha = fieldSenha.getText();

                if(banco.autenticarEmail(email)){
                    User user = banco.procuraEmail(email);
                    if(banco.autenticarSenha(user,senha) && !user.isBloqueado(user.tempoBloqueio())){
                        JOptionPane.showMessageDialog(null,"Logado");

                    }else{
                        if(user.isBloqueado(user.tempoBloqueio())){
                            JOptionPane.showMessageDialog(null, "Usuario bloqueado por " + user.tempoBloqueio() +" minutos","Dominó", JOptionPane.INFORMATION_MESSAGE);

                        }else {
                            JOptionPane.showMessageDialog(null, "Senha Invalida!");
                        }


                    }
                }else{
                    JOptionPane.showMessageDialog(null,"E-mail não cadastrado!");
                }
            }
        });
  }
  public JPanel getPainel(){
        return painel;
  }
}

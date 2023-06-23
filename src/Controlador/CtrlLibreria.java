package Controlador;

import Modelo.ConsultasLibreria;
import Modelo.LibreriasGet_Set;
import Vista.frmLibreria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class CtrlLibreria implements ActionListener{
    
    private LibreriasGet_Set mod;
    private ConsultasLibreria Cmod;
    private frmLibreria frm;

    public CtrlLibreria(LibreriasGet_Set mod, ConsultasLibreria Cmod, frmLibreria frm) {
        this.mod = mod;
        this.Cmod = Cmod;
        this.frm = frm;
        this.frm.btnRegistrar.addActionListener(this);
        this.frm.btnCancelar.addActionListener(this);
        
    }
    public void iniciar(){
        
        frm.setTitle("Libreria");
        frm.setLocationRelativeTo(null);
        frm.txtID.setVisible(false);
    }
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == frm.btnRegistrar){
            mod.setNombre(frm.txtNombre.getText());
            mod.setDireccion(frm.txtDireccion.getText());
            mod.setTelefono(Integer.parseInt(frm.txtTelefon.getText()));
            mod.setCorreo(frm.txtCorreo.getText());
            mod.setEstado(frm.txtEstado.getText());
            
            if(Cmod.registrar(mod)){
                JOptionPane.showMessageDialog(null, "Registro guardado satisfactoriamente");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "No se logro guardar el registro");
                limpiar();
            }
        }
        
    }
    public void limpiar(){
        frm.txtDireccion.setText(null);
        frm.txtCorreo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtTelefon.setText(null);
        frm.txtEstado.setText(null);
    }
}

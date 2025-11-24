package Exceptions;

public class UsuarioSemPermissaoException extends Exception {
    public UsuarioSemPermissaoException (String msg){
        super(msg);
    }
}